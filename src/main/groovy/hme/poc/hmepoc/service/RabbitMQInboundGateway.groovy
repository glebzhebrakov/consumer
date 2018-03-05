package hme.poc.hmepoc.service

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('rabbitmq')
@Service
class RabbitMQInboundGateway implements MessageConsumingPort {

    private final MessageStoragePort messageStoragePort

    @Autowired
    RabbitMQInboundGateway(final MessageStoragePort messageStoragePort) {
        this.messageStoragePort = messageStoragePort
    }

    @RabbitListener(queues = '${rabbit.queue}')
    @Override
    void receive(byte[] message) {

    }
}
