package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.transformation.DetectorEvents
import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord
import hme.poc.hmepoc.repository.TransformRecordsRepository
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDBOutboundGateway implements MessageStoragePort {

    private final TransformRecordsRepository transformRecordsRepository
    private final TransformedAggregationRepository transformedAggregationRepository

    @Autowired
    MongoDBOutboundGateway( final TransformRecordsRepository transformRecordsRepository,
                            final TransformedAggregationRepository transformedAggregationRepository) {
        this.transformRecordsRepository = transformRecordsRepository
        this.transformedAggregationRepository = transformedAggregationRepository
    }

    @Override
    List<TransformedRecord> transform( final List<EventRecord> events ) {
        def transformedRecords = transformEvents(events)
        transformRecordsRepository.saveAll(transformedRecords)
    }

    @Override
    List<TransformedRecord> transform( final List<EventRecord> events, final String collectionName ) {
        def transformedRecords = transformEvents(events)
        transformRecordsRepository.saveToCollection(transformedRecords, collectionName)
        transformedRecords
    }

    @Override
    List<TransformedAggregation> aggregate() {
        transformRecordsRepository.aggregateEvents()
    }

    @Override
    List<TransformedAggregation> aggregate(final String collectionName) {
        transformRecordsRepository.aggregateEvents(collectionName)
    }

    private static List<TransformedRecord> transformEvents(final List<EventRecord> events ) {
        def transformations = []
        events.forEach { event ->
            event.rcdRecords.carRecords.forEach { record ->

                def transformedRecord = new TransformedRecord().with {
                    mongoId = UUID.randomUUID().toString()
                    storeUID = event.storeUID
                    departureTime = record.departureTime
                    totalTimeInLane = record.totalTimeInLane?.text
                    type = record.type
                    storeNumber = event.storeNumber
                    daypartIndex = record.dpIndex
                    storeDay = record.storeDay
                    currentDateTimeHour = toISO8601(record.departureTime)
                    arrivalTime = event.eventEnqueuedUtcTime
                    firstJobProcessedTime = event.eventProcessedUtcTime
                    partitionId = event.partitionId
                    detectorEvents = new DetectorEvents()
                    it
                }

                def detectorsMap = transformedRecord.detectorEvents.getDetectorsMap()

                record.detectors.forEach { detector ->
                    detectorsMap.get(detector.eventName).value = detector.timeOnDetector.text
                }
                transformations.add(transformedRecord)
            }
        }
        transformations
    }

    private static String toISO8601(String time) {
        def parsedDate = new DateTime(time)
        def res = new DateTime()
                .withYear(parsedDate.getYear())
                .withMonthOfYear(parsedDate.getMonthOfYear())
                .withDayOfMonth(parsedDate.getDayOfMonth())
                .withHourOfDay(parsedDate.getHourOfDay())
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0)
                .withZone(DateTimeZone.UTC)
        ISODateTimeFormat.dateTime().print(res)
    }
}
