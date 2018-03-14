package hme.poc.hmepoc.dto.domain.transformation

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class TransformedRecord {
    @Id
    String mongoId
    String currentDateTimeHour
    String storeUID
    String departureTime
    Long totalTimeInLane
    String type
    String storeNumber
    Long daypartIndex
    String storeDay
    String arrivalTime
    String firstJobProcessedTime
    String partitionId
    DetectorEvents detectorEvents
}
