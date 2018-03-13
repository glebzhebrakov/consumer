package hme.poc.hmepoc.dto.domain

import com.fasterxml.jackson.annotation.JsonProperty

class RCDRecords {

    @JsonProperty('CarRecord')
    List<CarRecord> carRecords

    @JsonProperty('StatisticRecord')
    List<StatisticRecord> statisticRecords
}
