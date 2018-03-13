package hme.poc.hmepoc.dto.domain.transformation

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class TransformedRecord {
    @Id
    String mongoId

    String storeUID
    String departureTime
    Long totalTimeInLine
    String type
    String storeNumber
    Long daypartIndex
    String storeDay
    String arrivalTime
    String firstJobProcessedTime
    String partitionId
    DetectorEvents detectorEvents
}
