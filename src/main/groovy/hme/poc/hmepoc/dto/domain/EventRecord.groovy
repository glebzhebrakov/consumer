package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
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
    int partitionId

    @JsonProperty('EventEnqueuedUtcTime')
    String eventEnqueuedUtcTime
}
