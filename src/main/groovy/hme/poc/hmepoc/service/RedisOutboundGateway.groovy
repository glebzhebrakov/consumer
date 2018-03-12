package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.Statistic
import hme.poc.hmepoc.dto.TestMessage
import hme.poc.hmepoc.repository.MessageRedisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('redis')
@Service
class RedisOutboundGateway implements MessageStoragePort {

    private final MessageRedisRepository redisRepository

    @Autowired
    RedisOutboundGateway( final MessageRedisRepository redisRepository ) {
        this.redisRepository = redisRepository
    }

    @Override
    void save( final TestMessage message) {
        redisRepository.save(message)
    }

    @Override
    Statistic statistic() {
        new Statistic().with {
            messagesCount = redisRepository.count()
            it
        }
    }

    @Override
    List<TestMessage> aggregateBySlidingWindow(long windowInMs) {
        []
    }
}
