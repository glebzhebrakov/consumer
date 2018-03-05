package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.Statistic
import hme.poc.hmepoc.dto.TestMessage

interface MessageStoragePort {
    void save(final TestMessage message )
    Statistic statistic()
}
