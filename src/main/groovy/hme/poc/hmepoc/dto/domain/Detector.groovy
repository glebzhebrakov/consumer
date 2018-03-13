package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

//@JsonIgnoreProperties(ignoreUnknown = true)
class Detector {

    @JsonProperty('@EventName')
    String eventName

    @JsonProperty('@ID')
    Long id

    @JsonProperty('@Type')
    String type

    @JsonProperty(value = 'TimeInQueue', required = false)
    Long timeInQueue

    @JsonProperty('TimeOnDetector')
    TimeOnDetector timeOnDetector
}
