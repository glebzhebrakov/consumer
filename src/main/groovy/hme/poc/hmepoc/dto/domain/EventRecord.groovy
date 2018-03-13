package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonProperty

class EventRecord {

    @JsonProperty('@StoreNumber')
    String storeNumber

    @JsonProperty('@IPAddress')
    String ipAddress

    @JsonProperty('@StoreUID')
    String storeUID

    @JsonProperty('EventProcessedUtcTime')
    String eventProcessedUtcTime

    @JsonProperty('PartitionId')
    Integer partitionId

    @JsonProperty('EventEnqueuedUtcTime')
    String eventEnqueuedUtcTime

    @JsonProperty('RCDRecords')
    RCDRecords rcdRecords

    @JsonProperty('LaneConfig')
    LaneConfig laneConfig
}
