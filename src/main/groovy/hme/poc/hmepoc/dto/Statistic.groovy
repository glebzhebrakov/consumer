package hme.poc.hmepoc.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.Canonical

@Canonical
class Statistic {
    long messagesCount
//    @JsonIgnore
    List<Pair> factCounts
}
