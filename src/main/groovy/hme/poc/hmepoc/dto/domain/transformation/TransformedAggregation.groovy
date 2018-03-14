package hme.poc.hmepoc.dto.domain.transformation

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class TransformedAggregation {

    @Id
    String mongoId

    String arrivalTime
    String currentDateTimeHour
    String storeDay
    String storeUID
    String departureTime
    @JsonProperty(defaultValue = '-1')
    Long totalTimeInLane
    String type
    String storeNumber
    @JsonProperty(defaultValue = '-1')
    Long daypartIndex
    String firstJobProcessedTime
    String partitionId
    @JsonProperty(defaultValue = '-1')
    Long alert
    @JsonProperty(defaultValue = '-1')
    Long arrival
    @JsonProperty(defaultValue = '-1')
    Long booth
    @JsonProperty(defaultValue = '-1')
    Long cashier
    @JsonProperty(defaultValue = '-1')
    Long delivery
    @JsonProperty(defaultValue = '-1')
    Long menuBoard
    @JsonProperty(defaultValue = '-1')
    Long menuBoard1
    @JsonProperty(defaultValue = '-1')
    Long menuBoard2
    @JsonProperty(defaultValue = '-1')
    Long orderPoint
    @JsonProperty(defaultValue = '-1')
    Long orderPoint1
    @JsonProperty(defaultValue = '-1')
    Long orderPoint2
    @JsonProperty(defaultValue = '-1')
    Long pickup
    @JsonProperty(defaultValue = '-1')
    Long preAlert
    @JsonProperty(defaultValue = '-1')
    Long preLoop
    @JsonProperty(defaultValue = '-1')
    Long preWarning
    @JsonProperty(defaultValue = '-1')
    Long presenter
    @JsonProperty(defaultValue = '-1')
    Long service
    @JsonProperty(defaultValue = '-1')
    Long window1
    @JsonProperty(defaultValue = '-1')
    Long window2
    @JsonProperty(defaultValue = '-1')
    Long orderPoint_1
    @JsonProperty(defaultValue = '-1')
    Long orderPoint_2
    @JsonProperty(defaultValue = '-1')
    Long lane1Queue
    @JsonProperty(defaultValue = '-1')
    Long lane1Queue2
    @JsonProperty(defaultValue = '-1')
    Long lane1Total
    @JsonProperty(defaultValue = '-1')
    Long lane1Total2
    @JsonProperty(defaultValue = '-1')
    Long lane2Queue
    @JsonProperty(defaultValue = '-1')
    Long lane2Queue2
    @JsonProperty(defaultValue = '-1')
    Long lane2Total
    @JsonProperty(defaultValue = '-1')
    Long lane2Total2
    @JsonProperty(defaultValue = '-1')
    Long laneQueue
    @JsonProperty(defaultValue = '-1')
    Long laneQueue2
    @JsonProperty(defaultValue = '-1')
    Long laneTotal
    @JsonProperty(defaultValue = '-1')
    Long laneTotal2
    @JsonProperty(defaultValue = '-1')
    Long maxOneLaneEvents
    @JsonProperty(defaultValue = '-1')
    Long maxTwoLaneEvents
    @JsonProperty(defaultValue = '-1')
    Long maxYLaneEvents
    @JsonProperty(defaultValue = '-1')
    Long totalEvent
    @JsonProperty(defaultValue = '-1')
    Long totalEvent1
    @JsonProperty(defaultValue = '-1')
    Long totalEvent2
    @JsonProperty(defaultValue = '-1')
    Long menu_1
    @JsonProperty(defaultValue = '-1')
    Long menu_2
    @JsonProperty(defaultValue = '-1')
    Long service_1
    @JsonProperty(defaultValue = '-1')
    Long service_2
    @JsonProperty(defaultValue = '-1')
    Long pre_Warning
    @JsonProperty(value = 'menu', defaultValue = '-1')
    Long enu
    @JsonProperty(defaultValue = '-1')
    Long menu1
    @JsonProperty(defaultValue = '-1')
    Long menu2
    @JsonProperty(defaultValue = '-1')
    Long pre_Loop
    @JsonProperty(defaultValue = '-1')
    Long preLoop1
    @JsonProperty(defaultValue = '-1')
    Long preLoop2
    @JsonProperty(defaultValue = '-1')
    Long pre_Alert
    @JsonProperty(defaultValue = '-1')
    Long preAlert1
    @JsonProperty(defaultValue = '-1')
    Long preAlert2
    @JsonProperty(defaultValue = '-1')
    Long alert1
    @JsonProperty(defaultValue = '-1')
    Long alert2
    @JsonProperty(defaultValue = '-1')
    Long arrival1
    @JsonProperty(defaultValue = '-1')
    Long arrival2
    @JsonProperty(defaultValue = '-1')
    Long preWarning1
    @JsonProperty(defaultValue = '-1')
    Long preWarning2
    @JsonProperty(defaultValue = '-1')
    Long booth1
    @JsonProperty(defaultValue = '-1')
    Long booth2
    @JsonProperty(defaultValue = '-1')
    Long delivery1
    @JsonProperty(defaultValue = '-1')
    Long delivery2
    @JsonProperty(defaultValue = '-1')
    Long greet
    @JsonProperty(defaultValue = '-1')
    Long greet1
    @JsonProperty(defaultValue = '-1')
    Long greet2
    @JsonProperty(defaultValue = '-1')
    Long greet_1
    @JsonProperty(defaultValue = '-1')
    Long greet_2
    @JsonProperty(defaultValue = '-1')
    Long presenter1
    @JsonProperty(defaultValue = '-1')
    Long presenter2
    @JsonProperty(defaultValue = '-1')
    Long service1
    @JsonProperty(defaultValue = '-1')
    Long service2
    @JsonProperty(defaultValue = '-1')
    Long orderPnt1
    @JsonProperty(defaultValue = '-1')
    Long orderPnt2
    @JsonProperty(defaultValue = '-1')
    Long order_1
    @JsonProperty(defaultValue = '-1')
    Long order_2
    @JsonProperty(defaultValue = '-1')
    Long order1
    @JsonProperty(defaultValue = '-1')
    Long order2
    @JsonProperty(defaultValue = '-1')
    Long pickupWindow
    @JsonProperty(defaultValue = '-1')
    Long waitArea
}
