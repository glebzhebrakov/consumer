package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.CassandraTestMessage
import hme.poc.hmepoc.dto.Statistic
import hme.poc.hmepoc.dto.TestMessage
import hme.poc.hmepoc.repository.MessageCassandraRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('cassandra')
@Service
class CassandraOutboundGateway implements MessageStoragePort {

    private final MessageCassandraRepository messageCassandraRepository

    @Autowired
    CassandraOutboundGateway(final MessageCassandraRepository messageCassandraRepository) {
        this.messageCassandraRepository = messageCassandraRepository
    }

    @Override
    void save( final TestMessage message) {

        messageCassandraRepository.save(new CassandraTestMessage().with {
            id = message.id
            timestamp = message.timestamp
            payload = message.payload
            it
        })
    }

    @Override
    Statistic statistic() {
        new Statistic().with {
            messagesCount = messageCassandraRepository.count()
            it
        }
    }
}
