package hme.poc.hmepoc.dto.domain.transformation

import org.springframework.data.annotation.Transient

class DetectorEvents {
    DetectorEvent alert            = new DetectorEvent('Alert')
    DetectorEvent arrival          = new DetectorEvent('Arrival')
    DetectorEvent booth            = new DetectorEvent('Booth')
    DetectorEvent cashier          = new DetectorEvent('Cashier')
    DetectorEvent delivery         = new DetectorEvent('Delivery')
    DetectorEvent menuBoard        = new DetectorEvent('Menu Board')
    DetectorEvent menuBoard1       = new DetectorEvent('Menu Board1')
    DetectorEvent menuBoard2       = new DetectorEvent('Menu Board2')
    DetectorEvent orderPoint       = new DetectorEvent('Order Point')
    DetectorEvent orderPoint1      = new DetectorEvent('Order Point1')
    DetectorEvent orderPoint2      = new DetectorEvent('Order Point2')
    DetectorEvent pickup           = new DetectorEvent('Pickup')
    DetectorEvent preAlert         = new DetectorEvent('Pre Alert')
    DetectorEvent preLoop          = new DetectorEvent('Pre Loop')
    DetectorEvent preWarning       = new DetectorEvent('Pre Warning')
    DetectorEvent presenter        = new DetectorEvent('Presenter')
    DetectorEvent service          = new DetectorEvent('Service')
    DetectorEvent window1          = new DetectorEvent('Window1')
    DetectorEvent window2          = new DetectorEvent('Window2')
    DetectorEvent orderPoint_1     = new DetectorEvent('Order Point 1')
    DetectorEvent orderPoint_2     = new DetectorEvent('Order Point 2')
    DetectorEvent lane1Queue       = new DetectorEvent('Lane 1 Queue')
    DetectorEvent lane1Queue2      = new DetectorEvent('Lane 1 Queue 2')
    DetectorEvent lane1Total       = new DetectorEvent('Lane 1 Total')
    DetectorEvent lane1Total2      = new DetectorEvent('Lane 1 Total 2')
    DetectorEvent lane2Queue       = new DetectorEvent('Lane 2 Queue')
    DetectorEvent lane2Queue2      = new DetectorEvent('Lane 2 Queue 2')
    DetectorEvent lane2Total       = new DetectorEvent('Lane 2 Total')
    DetectorEvent lane2Total2      = new DetectorEvent('Lane 2 Total 2')
    DetectorEvent laneQueue        = new DetectorEvent('Lane Queue')
    DetectorEvent laneQueue2       = new DetectorEvent('Lane Queue 2')
    DetectorEvent laneTotal        = new DetectorEvent('Lane Total')
    DetectorEvent laneTotal2       = new DetectorEvent('Lane Total 2')
    DetectorEvent maxOneLaneEvents = new DetectorEvent('Max One Lane Events')
    DetectorEvent maxTwoLaneEvents = new DetectorEvent('Max Two Lane Events')
    DetectorEvent maxYLaneEvents   = new DetectorEvent('Max Y Lane Events')
    DetectorEvent totalEvent       = new DetectorEvent('Total Event')
    DetectorEvent totalEvent1      = new DetectorEvent('Total Event1')
    DetectorEvent totalEvent2      = new DetectorEvent('Total Event2')
    DetectorEvent menu_1           = new DetectorEvent('Menu 1')
    DetectorEvent menu_2           = new DetectorEvent('Menu 2')
    DetectorEvent service_1        = new DetectorEvent('Service 1')
    DetectorEvent service_2        = new DetectorEvent('Service 2')
    DetectorEvent pre_Warning      = new DetectorEvent('Pre-Warning')
    DetectorEvent enu              = new DetectorEvent('Menu')
    DetectorEvent menu1            = new DetectorEvent('Menu1')
    DetectorEvent menu2            = new DetectorEvent('Menu2')
    DetectorEvent pre_Loop         = new DetectorEvent('Pre-Loop')
    DetectorEvent preLoop1         = new DetectorEvent('Pre Loop1')
    DetectorEvent preLoop2         = new DetectorEvent('Pre Loop2')
    DetectorEvent pre_Alert        = new DetectorEvent('Pre-Alert')
    DetectorEvent preAlert1        = new DetectorEvent('Pre Alert1')
    DetectorEvent preAlert2        = new DetectorEvent('Pre Alert2')
    DetectorEvent alert1           = new DetectorEvent('Alert1')
    DetectorEvent alert2           = new DetectorEvent('Alert2')
    DetectorEvent arrival1         = new DetectorEvent('Arrival1')
    DetectorEvent arrival2         = new DetectorEvent('Arrival2')
    DetectorEvent preWarning1      = new DetectorEvent('Pre Warning1')
    DetectorEvent preWarning2      = new DetectorEvent('Pre Warning2')
    DetectorEvent booth1           = new DetectorEvent('Booth1')
    DetectorEvent booth2           = new DetectorEvent('Booth2')
    DetectorEvent delivery1        = new DetectorEvent('Delivery1')
    DetectorEvent delivery2        = new DetectorEvent('Delivery2')
    DetectorEvent greet            = new DetectorEvent('Greet')
    DetectorEvent greet1           = new DetectorEvent('Greet1')
    DetectorEvent greet2           = new DetectorEvent('Greet2')
    DetectorEvent greet_1          = new DetectorEvent('Greet 1')
    DetectorEvent greet_2          = new DetectorEvent('Greet 2')
    DetectorEvent presenter1       = new DetectorEvent('Presenter1')
    DetectorEvent presenter2       = new DetectorEvent('Presenter2')
    DetectorEvent service1         = new DetectorEvent('Service1')
    DetectorEvent service2         = new DetectorEvent('Service2')
    DetectorEvent orderPnt1        = new DetectorEvent('Order Pnt1')
    DetectorEvent orderPnt2        = new DetectorEvent('Order Pnt2')
    DetectorEvent order_1          = new DetectorEvent('Order 1')
    DetectorEvent order_2          = new DetectorEvent('Order 2')
    DetectorEvent order1           = new DetectorEvent('Order1')
    DetectorEvent order2           = new DetectorEvent('Order2')
    DetectorEvent pickupWindow     = new DetectorEvent('Pickup Window')
    DetectorEvent waitArea         = new DetectorEvent('Wait Area')

    @Transient
    Map<String, DetectorEvent> getDetectorsMap() {
        def map = new HashMap<String, DetectorEvent>()
        getDetectorEvents().collect {
            map.put(it.alias, it)
        }
        map
    }


    @Transient
    List<DetectorEvent> getDetectorEvents() {
        [alert,
         arrival,
         booth,
         cashier,
         delivery,
         menuBoard,
         menuBoard1,
         menuBoard2,
         orderPoint,
         orderPoint1,
         orderPoint2,
         pickup,
         preAlert,
         preLoop,
         preWarning,
         presenter,
         service,
         window1,
         window2,
         orderPoint_1,
         orderPoint_2,
         lane1Queue,
         lane1Queue2,
         lane1Total,
         lane1Total2,
         lane2Queue,
         lane2Queue2,
         lane2Total,
         lane2Total2,
         laneQueue,
         laneQueue2,
         laneTotal,
         laneTotal2,
         maxOneLaneEvents,
         maxTwoLaneEvents,
         maxYLaneEvents,
         totalEvent,
         totalEvent1,
         totalEvent2,
         menu_1,
         menu_2,
         service_1,
         service_2,
         pre_Warning,
         enu,
         menu1,
         menu2,
         pre_Loop,
         preLoop1,
         preLoop2,
         pre_Alert,
         preAlert1,
         preAlert2,
         alert1,
         alert2,
         arrival1,
         arrival2,
         preWarning1,
         preWarning2,
         booth1,
         booth2,
         delivery1,
         delivery2,
         greet,
         greet1,
         greet2,
         greet_1,
         greet_2,
         presenter1,
         presenter2,
         service1,
         service2,
         orderPnt1,
         orderPnt2,
         order_1,
         order_2,
         order1,
         order2,
         pickupWindow,
         waitArea,
        ]
    }
}
