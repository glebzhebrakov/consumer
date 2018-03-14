package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.transformation.DetectorEvents
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord
import hme.poc.hmepoc.repository.TransformRecordsRepository
import org.apache.tomcat.websocket.TransformationResult
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultTransformer implements InputTransformer {


    private final TransformRecordsRepository transformRecordsRepository

    @Autowired
    DefaultTransformer(TransformRecordsRepository transformRecordsRepository) {
        this.transformRecordsRepository = transformRecordsRepository
    }

    @Override
    List<TransformedRecord> transform(List<EventRecord> events) {
        def transformations = []
        events.forEach { event ->
            event.rcdRecords.carRecords.forEach { record ->

                def transformedRecord = new TransformedRecord().with {
                    mongoId = UUID.randomUUID().toString()
                    storeUID = event.storeUID
                    departureTime = record.departureTime
                    totalTimeInLine = record.totalTimeInLane?.text
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

        transformations.forEach{
            transformRecordsRepository.save(it)
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
