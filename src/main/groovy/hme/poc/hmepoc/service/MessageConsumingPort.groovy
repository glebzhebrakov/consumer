package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord

interface MessageConsumingPort {

    @Deprecated
    void receive(byte [] message)
    void receive(List<EventRecord> records)
}