package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.TestMessage
import org.springframework.context.annotation.Profile
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Profile('cassandra')
@Repository
interface MessageCassandraRepository  extends CassandraRepository<TestMessage, String>{
}
