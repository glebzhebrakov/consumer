package hme.poc.hmepoc

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.Canonical
import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Unroll

import java.lang.reflect.Field

class CompareOutsIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private TransformedAggregationRepository transformedAggregationRepository

    @Unroll
    def 'compare outputs #description'() {
        given: 'path to file'
        def path = '/home/glibzhebrakov/oureal.json'

        and: 'aggregation repo'
        assert transformedAggregationRepository

        and: 'mapper'
        def mapper = new ObjectMapper()
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)

        when: 'read lines from file'
        def expected = FileUtils.readLines(new File(path)).collect {
            mapper.readValue(it as String, TransformedAggregation)
        }

        and: 'read from mongo'
        def result = transformedAggregationRepository.findAll()

        then: 'all ok'
        def epairs = expected.collect { a ->
            def p = new Pair().with {
                id = a.storeUID
                it
            }
            def fld = a.metaClass.getMetaProperty("$field").type
            def v = a."$field"
            p.value = v
            if ( fld == Long.class && v == null){
                p.value = '-1'
            }
            if ( fld == String.class && v == null){
                p.value = ''
            }

            if("$field" == 'totalTimeInLane' && v == null) {
                p.value = 'null'
            }

            p
        }.sort()

        def rpairs = result.collect { a ->
            def p = new Pair().with {
                id = a.storeUID
                it
            }
            p.value = a."$field".toString()
            p
        }.sort()

        epairs.size() == rpairs.size()
        epairs == rpairs

        where:
        description               | field
//        'storeDay'                | 'storeDay' //calculated by join with table
        'departureTime'           | 'departureTime'
        'totalTimeInLane'         | 'totalTimeInLane'
        'type'                    | 'type'
        'storeNumber'             | 'storeNumber'
        'daypartIndex'            | 'daypartIndex'
        'alert'                   | 'alert'
        'arrival'                 | 'arrival'
        'booth'                   | 'booth'
        'cashier'                 | 'cashier'
        'delivery'                | 'delivery'
        'menuBoard'               | 'menuBoard'
        'menuBoard1'              | 'menuBoard1'
        'menuBoard2'              | 'menuBoard2'
        'orderPoint'              | 'orderPoint'
        'orderPoint1'             | 'orderPoint1'
        'orderPoint2'             | 'orderPoint2'
        'pickup'                  | 'pickup'
        'preAlert'                | 'preAlert'
        'preLoop'                 | 'preLoop'
        'preWarning'              | 'preWarning'
        'presenter'               | 'presenter'
        'service'                 | 'service'
        'window1'                 | 'window1'
        'window2'                 | 'window2'
        'orderPoint_1'            | 'orderPoint_1'
        'orderPoint_2'            | 'orderPoint_2'
        'lane1Queue'              | 'lane1Queue'
        'lane1Queue2'             | 'lane1Queue2'
        'lane1Total'              | 'lane1Total'
        'lane1Total2'             | 'lane1Total2'
        'lane2Queue'              | 'lane2Queue'
        'lane2Queue2'             | 'lane2Queue2'
        'lane2Total'              | 'lane2Total'
        'lane2Total2'             | 'lane2Total2'
        'laneQueue'               | 'laneQueue'
        'laneQueue2'              | 'laneQueue2'
        'laneTotal'               | 'laneTotal'
        'laneTotal2'              | 'laneTotal2'
        'maxOneLaneEvents'        | 'maxOneLaneEvents'
        'maxTwoLaneEvents'        | 'maxTwoLaneEvents'
        'maxYLaneEvents'          | 'maxYLaneEvents'
        'totalEvent'              | 'totalEvent'
        'totalEvent1'             | 'totalEvent1'
        'totalEvent2'             | 'totalEvent2'
        'menu_1'                  | 'menu_1'
        'menu_2'                  | 'menu_2'
        'service_1'               | 'service_1'
        'service_2'               | 'service_2'
        'pre_Warning'             | 'pre_Warning'
        'enu'                     | 'enu'
        'menu1'                   | 'menu1'
        'menu2'                   | 'menu2'
        'pre_Loop'                | 'pre_Loop'
        'preLoop1'                | 'preLoop1'
        'preLoop2'                | 'preLoop2'
        'pre_Alert'               | 'pre_Alert'
        'preAlert1'               | 'preAlert1'
        'preAlert2'               | 'preAlert2'
        'alert1'                  | 'alert1'
        'alert2'                  | 'alert2'
        'arrival1'                | 'arrival1'
        'arrival2'                | 'arrival2'
        'preWarning1'             | 'preWarning1'
        'preWarning2'             | 'preWarning2'
        'booth1'                  | 'booth1'
        'booth2'                  | 'booth2'
        'delivery1'               | 'delivery1'
        'delivery2'               | 'delivery2'
        'greet'                   | 'greet'
        'greet1'                  | 'greet1'
        'greet2'                  | 'greet2'
        'greet_1'                 | 'greet_1'
        'greet_2'                 | 'greet_2'
        'presenter1'              | 'presenter1'
        'presenter2'              | 'presenter2'
        'service1'                | 'service1'
        'service2'                | 'service2'
        'orderPnt1'               | 'orderPnt1'
        'orderPnt2'               | 'orderPnt2'
        'order_1'                 | 'order_1'
        'order_2'                 | 'order_2'
        'order1'                  | 'order1'
        'order2'                  | 'order2'
        'pickupWindow'            | 'pickupWindow'
        'waitArea'                | 'waitArea'


    }
}
