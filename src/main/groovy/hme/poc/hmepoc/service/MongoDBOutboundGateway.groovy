package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.MongoDBTestMessage
import hme.poc.hmepoc.dto.Statistic
import hme.poc.hmepoc.dto.TestMessage
import hme.poc.hmepoc.repository.MessageMongoDBRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('mongodb')
@Service
class MongoDBOutboundGateway implements MessageStoragePort {

    private final MessageMongoDBRepository messageMongoDBRepository

    @Autowired
    MongoDBOutboundGateway(MessageMongoDBRepository messageMongoDBRepository) {
        this.messageMongoDBRepository = messageMongoDBRepository
    }

    @Override
    void save(TestMessage message) {
        messageMongoDBRepository.save(new MongoDBTestMessage().with {
            id = message.id
            timestamp = message.timestamp
            payload = message.payload
            it
        })
    }

    @Override
    Statistic statistic() {
        new Statistic().with {
            messagesCount = messageMongoDBRepository.count()
            it
        }
    }
}
