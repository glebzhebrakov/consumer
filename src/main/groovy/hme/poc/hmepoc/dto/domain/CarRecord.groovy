package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonProperty

class CarRecord {

    @JsonProperty('@Type')
    String type

    @JsonProperty('Lane')
    Integer lane

    @JsonProperty('DepartureTime')
    String departureTime

    @JsonProperty('Detector')
    List<Detector> detectors

    @JsonProperty('TotalTimeInLane')
    TotalTimeInLane totalTimeInLane

    @JsonProperty('Total2TimeInLane')
    TotalTimeInLane total2TimeInLane

    @JsonProperty('QueueTimeInLane')
    Long queueTimeInLane

    @JsonProperty('Queue2TimeInLane')
    Long queue2TimeInLane

    @JsonProperty('CarsInQueue')
    Integer carsInQueue

    @JsonProperty('DPIndex')
    Long dpIndex

    @JsonProperty('ShiftIndex')
    Long shiftIndex

    @JsonProperty('StoreDay')
    String storeDay
}
