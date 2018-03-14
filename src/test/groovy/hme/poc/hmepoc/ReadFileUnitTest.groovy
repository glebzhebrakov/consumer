package hme.poc.hmepoc

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.FileUtils

import java.nio.file.Files

class ReadFileUnitTest extends BaseUnitTest {

    def 'test'() {
        given: 'path to file'
        def path = '/home/glibzhebrakov/Downloads/1/00_0_27d87fe044454eb29dabec8a389c20b5.json'

        and: 'path to out directory'
        def outpath = '/home/glibzhebrakov/Downloads/1/out'

        when: 'split to small files'

//        def lines = FileUtils.readLines(new File(path))
//        lines.eachWithIndex{it, index ->
//            FileUtils.writeByteArrayToFile(new File("$outpath/$index"+'.json'), it.toString().bytes)
//        }

        def files = FileUtils.listFiles(new File(outpath), ['json'] as String[], false) as List
        files.size()
        files.collate(10)


        then: 'all ok'
        true
    }

}
