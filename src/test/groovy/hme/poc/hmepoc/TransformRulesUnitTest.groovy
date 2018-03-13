package hme.poc.hmepoc

import com.fasterxml.jackson.databind.ObjectMapper
import hme.poc.hmepoc.dto.domain.EventRecord
import org.apache.commons.io.FileUtils

class TransformRulesUnitTest extends BaseUnitTest {

    def 'validate transform'() {

        given: 'a valid file to transform'
        def text = loadJson()

        and: 'a valid objectMapper'
        def objectMapper = new ObjectMapper()

        when: 'convert to objects'
        long startTime = System.currentTimeMillis()
        def result = objectMapper.readValue(text, objectMapper.getTypeFactory().constructCollectionType(List, EventRecord))
        long endTime = System.currentTimeMillis()
        print(endTime-startTime)

        then: 'all ok'
        result
    }

    private byte[] loadJson(){
        FileUtils.readFileToByteArray(FileUtils.toFile(this.class.classLoader.getResource('transformation.json')))
    }
}
