package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.transformation.DetectorEvents
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord
import hme.poc.hmepoc.repository.TransformRecordsRepository
import org.apache.tomcat.websocket.TransformationResult
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
                    /**
                     * part with DATETIMEFROMPARTS
                     * **/
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

}
