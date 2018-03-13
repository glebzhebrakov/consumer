package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonProperty

class TimeOnDetector {
    @JsonProperty(value = '@DPGoalIndex', required = false)
    Long dpGoalIndex

    @JsonProperty(value = '#text', required = false)
    Long text
}
