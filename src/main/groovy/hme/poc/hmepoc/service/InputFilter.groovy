package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord

/**
 * Filter event records
 */
interface InputFilter {

    List<EventRecord> filter(final List<EventRecord> events)
}
