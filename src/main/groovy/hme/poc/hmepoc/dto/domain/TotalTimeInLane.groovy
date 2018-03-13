package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonProperty

class TotalTimeInLane {

    @JsonProperty('@DPGoalIndex')
    Long dpGoalIndex

    @JsonProperty('#text')
    Long text
}
