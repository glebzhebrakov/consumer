package hme.poc.hmepoc.service

import com.fasterxml.jackson.databind.ObjectMapper
import hme.poc.hmepoc.dto.TestMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('rabbitmq')
@Service
class RabbitMQInboundGateway implements MessageConsumingPort {

    private final MessageStoragePort messageStoragePort
    private final ObjectMapper objectMapper

    @Autowired
    RabbitMQInboundGateway(final ObjectMapper objectMapper, final MessageStoragePort messageStoragePort) {
        this.messageStoragePort = messageStoragePort
        this.objectMapper = objectMapper
    }

    @RabbitListener(queues = '${rabbit.queueName}')
    @Override
    void receive(byte[] message) {
        def msg = objectMapper.readValue(message, TestMessage)
        msg.id = UUID.randomUUID().toString()
        messageStoragePort.save(msg)
    }
}
