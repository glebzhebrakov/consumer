package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord

/**
 * Filters out events with empty car records and detectors inside
 */
class DetectorsInputFilter implements InputFilter {

    @Override
    List<EventRecord> filter(List<EventRecord> events) {

        events.findAll{
            it.rcdRecords.carRecords
        }
    }
}
