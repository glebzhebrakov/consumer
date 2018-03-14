package hme.poc.hmepoc

import com.fasterxml.jackson.databind.ObjectMapper
import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import hme.poc.hmepoc.service.MessageProducingPort
import hme.poc.hmepoc.service.MessageStoragePort
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(['mongodb','azure'])
class TransformRulesIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MessageStoragePort messageStoragePort

    @Autowired
    private MessageProducingPort messageProducingPort

    @Autowired
    private TransformedAggregationRepository transformedAggregationRepository

    def 'validate transform'() {

        given: 'a valid file to transform'
        def text = loadJson()

        and: 'a valid objectMapper'
        def objectMapper = new ObjectMapper()

        and: 'a valid messageStoragePort'
        assert messageStoragePort

        and: 'a valid producer'
        assert messageProducingPort

        when: 'convert to objects'

        def result = objectMapper.readValue(text, objectMapper.getTypeFactory().constructCollectionType(List, EventRecord)) as List
        long startTime = System.currentTimeMillis()
        messageStoragePort.transform(result)

        and: 'get transformed and aggregated records'
        def aggregation = messageStoragePort.aggregate()

        and: 'save aggregation'
        messageProducingPort.produce( aggregation )
        long  endTime = System.currentTimeMillis()
        print(endTime-startTime)

        and: 'get aggregations'
        def aggregations = transformedAggregationRepository.findAll()

        then: 'all ok'
        aggregations
    }

    private byte[] loadJson(){
        FileUtils.readFileToByteArray(FileUtils.toFile(this.class.classLoader.getResource('transformation.json')))
    }
}
