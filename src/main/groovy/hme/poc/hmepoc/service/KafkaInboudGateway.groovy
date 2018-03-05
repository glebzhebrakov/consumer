package hme.poc.hmepoc.service

import com.fasterxml.jackson.databind.ObjectMapper
import hme.poc.hmepoc.dto.TestMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Profile('kafka')
@Service
class KafkaInboudGateway implements MessageConsumingPort {

    private final MessageStoragePort messageStoragePort

    private final ObjectMapper objectMapper

    @Autowired
    KafkaInboudGateway(final MessageStoragePort messageStoragePort, final ObjectMapper objectMapper) {
        this.messageStoragePort = messageStoragePort
        this.objectMapper = objectMapper
    }

    @KafkaListener( topics = '${kafka.topic.poc}', groupId = '${kafka.group.id}' )
    @Override
    void receive(byte[] message) {
        messageStoragePort.save(objectMapper.readValue(message, TestMessage))
    }
}
