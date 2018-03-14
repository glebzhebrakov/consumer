package hme.poc.hmepoc

import com.fasterxml.jackson.databind.ObjectMapper
import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.repository.TransformRecordsRepository
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import hme.poc.hmepoc.service.DefaultTransformer
import hme.poc.hmepoc.service.InputTransformer
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(['mongodb','azure'])
class TransformRulesIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private InputTransformer transformer

    @Autowired
    private TransformRecordsRepository transformRecordsRepository

    @Autowired
    private TransformedAggregationRepository transformedAggregationRepository

    def 'validate transform'() {

        given: 'a valid file to transform'
        def text = loadJson()

        and: 'a valid objectMapper'
        def objectMapper = new ObjectMapper()

        and: 'a valid transformer'
        assert transformer

        when: 'convert to objects'

        def result = objectMapper.readValue(text, objectMapper.getTypeFactory().constructCollectionType(List, EventRecord)) as List
        long startTime = System.currentTimeMillis()
        def transformedResult = transformer.transform(result)


        and: 'get transformed and aggregated records'
        def aggregation = transformRecordsRepository.aggregateEvents()

        and: 'save aggregation'
        aggregation.collect {
            it.mongoId = UUID.randomUUID() as String
            it
        }
        transformedAggregationRepository.saveAll(aggregation)
        long endTime = System.currentTimeMillis()
        print(endTime-startTime)

        then: 'all ok'
        transformedResult
    }

    private byte[] loadJson(){
        FileUtils.readFileToByteArray(FileUtils.toFile(this.class.classLoader.getResource('trans.json')))
    }
}
