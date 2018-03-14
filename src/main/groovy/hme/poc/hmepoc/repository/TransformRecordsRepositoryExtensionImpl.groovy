package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.aggregation.Aggregation

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group

class TransformRecordsRepositoryExtensionImpl implements TransformRecordsRepositoryExtension {

    @Autowired
    private MongoOperations mongoOperations

    @Override
    void saveToCollection( final List<TransformedRecord> records, final String collectionName ) {
        mongoOperations.insert(records, collectionName)
    }

    @Override
    List<TransformedAggregation> aggregateEvents() {

        mongoOperations.aggregate(createAggregation(), TransformedRecord, TransformedAggregation) as List
    }

    @Override
    List<TransformedAggregation> aggregateEvents( final String collectionName ) {
        mongoOperations.aggregate(createAggregation(), collectionName, TransformedAggregation) as List
    }

    private static Aggregation createAggregation() {

        def eventsGroup = group(
                'storeUID',
                'departureTime',
                'totalTimeInLane',
                'type',
                'storeNumber',
                'daypartIndex',
                'storeDay',
                'arrivalTime',
                'firstJobProcessedTime',
                'currentDateTimeHour',
                'partitionId'
        )
                .addToSet('storeUID').as('storeUID')
                .addToSet('departureTime').as('departureTime')
                .addToSet('arrivalTime').as('arrivalTime')
                .addToSet('totalTimeInLane').as('totalTimeInLane')
                .addToSet('type').as('type')
                .addToSet('storeNumber').as('storeNumber')
                .addToSet('daypartIndex').as('daypartIndex')
                .addToSet('storeDay').as('storeDay')
                .addToSet('firstJobProcessedTime').as('firstJobProcessedTime')
                .addToSet('currentDateTimeHour').as('currentDateTimeHour')
                .addToSet('partitionId').as('partitionId')
                .max('detectorEvents.alert.value').as('alert')
                .max('detectorEvents.arrival.value').as('arrival')
                .max('detectorEvents.booth.value').as('booth')
                .max('detectorEvents.cashier.value').as('cashier')
                .max('detectorEvents.delivery.value').as('delivery')
                .max('detectorEvents.menuBoard.value').as('menuBoard')
                .max('detectorEvents.menuBoard1.value').as('menuBoard1')
                .max('detectorEvents.menuBoard2.value').as('menuBoard2')
                .max('detectorEvents.orderPoint.value').as('orderPoint')
                .max('detectorEvents.orderPoint1.value').as('orderPoint1')
                .max('detectorEvents.orderPoint2.value').as('orderPoint2')
                .max('detectorEvents.pickup.value').as('pickup')
                .max('detectorEvents.preAlert.value').as('preAlert')
                .max('detectorEvents.preLoop.value').as('preLoop')
                .max('detectorEvents.preWarning.value').as('preWarning')
                .max('detectorEvents.presenter.value').as('presenter')
                .max('detectorEvents.service.value').as('service')
                .max('detectorEvents.window1.value').as('window1')
                .max('detectorEvents.window2.value').as('window2')
                .max('detectorEvents.orderPoint_1.value').as('orderPoint_1')
                .max('detectorEvents.orderPoint_2.value').as('orderPoint_2')
                .max('detectorEvents.lane1Queue.value').as('lane1Queue')
                .max('detectorEvents.lane1Queue2.value').as('lane1Queue2')
                .max('detectorEvents.lane1Total.value').as('lane1Total')
                .max('detectorEvents.lane1Total2.value').as('lane1Total2')
                .max('detectorEvents.lane2Queue.value').as('lane2Queue')
                .max('detectorEvents.lane2Queue2.value').as('lane2Queue2')
                .max('detectorEvents.lane2Total.value').as('lane2Total')
                .max('detectorEvents.lane2Total2.value').as('lane2Total2')
                .max('detectorEvents.laneQueue.value').as('laneQueue')
                .max('detectorEvents.laneQueue2.value').as('laneQueue2')
                .max('detectorEvents.laneTotal.value').as('laneTotal')
                .max('detectorEvents.laneTotal2.value').as('laneTotal2')
                .max('detectorEvents.maxOneLaneEvents.value').as('maxOneLaneEvents')
                .max('detectorEvents.maxTwoLaneEvents.value').as('maxTwoLaneEvents')
                .max('detectorEvents.maxYLaneEvents.value').as('maxYLaneEvents')
                .max('detectorEvents.totalEvent.value').as('totalEvent')
                .max('detectorEvents.totalEvent1.value').as('totalEvent1')
                .max('detectorEvents.totalEvent2.value').as('totalEvent2')
                .max('detectorEvents.menu_1.value').as('menu_1')
                .max('detectorEvents.menu_2.value').as('menu_2')
                .max('detectorEvents.service_1.value').as('service_1')
                .max('detectorEvents.service_2.value').as('service_2')
                .max('detectorEvents.pre_Warning.value').as('pre_Warning')
                .max('detectorEvents.enu.value').as('enu')
                .max('detectorEvents.menu1.value').as('menu1')
                .max('detectorEvents.menu2.value').as('menu2')
                .max('detectorEvents.pre_Loop.value').as('pre_Loop')
                .max('detectorEvents.preLoop1.value').as('preLoop1')
                .max('detectorEvents.preLoop2.value').as('preLoop2')
                .max('detectorEvents.pre_Alert.value').as('pre_Alert')
                .max('detectorEvents.preAlert1.value').as('preAlert1')
                .max('detectorEvents.preAlert2.value').as('preAlert2')
                .max('detectorEvents.alert1.value').as('alert1')
                .max('detectorEvents.alert2.value').as('alert2')
                .max('detectorEvents.arrival1.value').as('arrival1')
                .max('detectorEvents.arrival2.value').as('arrival2')
                .max('detectorEvents.preWarning1.value').as('preWarning1')
                .max('detectorEvents.preWarning2.value').as('preWarning2')
                .max('detectorEvents.booth1.value').as('booth1')
                .max('detectorEvents.booth2.value').as('booth2')
                .max('detectorEvents.delivery1.value').as('delivery1')
                .max('detectorEvents.delivery2.value').as('delivery2')
                .max('detectorEvents.greet.value').as('greet')
                .max('detectorEvents.greet1.value').as('greet1')
                .max('detectorEvents.greet2.value').as('greet2')
                .max('detectorEvents.greet_1.value').as('greet_1')
                .max('detectorEvents.greet_2.value').as('greet_2')
                .max('detectorEvents.presenter1.value').as('presenter1')
                .max('detectorEvents.presenter2.value').as('presenter2')
                .max('detectorEvents.service1.value').as('service1')
                .max('detectorEvents.service2.value').as('service2')
                .max('detectorEvents.orderPnt1.value').as('orderPnt1')
                .max('detectorEvents.orderPnt2.value').as('orderPnt2')
                .max('detectorEvents.order_1.value').as('order_1')
                .max('detectorEvents.order_2.value').as('order_2')
                .max('detectorEvents.order1.value').as('order1')
                .max('detectorEvents.order2.value').as('order2')
                .max('detectorEvents.pickupWindow.value').as('pickupWindow')
                .max('detectorEvents.waitArea.value').as('waitArea')

         Aggregation.newAggregation( eventsGroup )
    }
}
