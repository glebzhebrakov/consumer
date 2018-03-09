package hme.poc.hmepoc.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.microsoft.azure.eventhubs.EventData
import com.microsoft.azure.eventhubs.PartitionReceiveHandler
import com.microsoft.azure.eventhubs.PartitionReceiver
import com.microsoft.azure.eventprocessorhost.CloseReason
import com.microsoft.azure.eventprocessorhost.IEventProcessor
import com.microsoft.azure.eventprocessorhost.PartitionContext
import hme.poc.hmepoc.dto.TestMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile('azure')
@Service
class AzureEventHubInboundGateway implements MessageConsumingPort, /*PartitionReceiveHandler,*/ IEventProcessor {

    private final MessageStoragePort storagePort
    private final ObjectMapper objectMapper
    private final static Logger logger = LoggerFactory.getLogger(AzureEventHubInboundGateway)

    @Autowired
    AzureEventHubInboundGateway( MessageStoragePort storagePort, ObjectMapper objectMapper) {
        this.storagePort = storagePort
        this.objectMapper = objectMapper
    }

    @Override
    void receive(byte[] message) {
        def msg = objectMapper.readValue(message, TestMessage)
        storagePort.save(msg)
    }

//    @Override
//    int getMaxEventCount() {
//        900
//    }
//
//    @Override
//    void onReceive(Iterable<EventData> events) {
//        events.forEach{
//            receive(it.bytes)
//        }
//    }
//
//    @Override
//    void onError(Throwable error) {
//
//    }

    @Override
    void onOpen(PartitionContext context) throws Exception {
        logger.info('# onopen')
    }

    @Override
    void onClose(PartitionContext context, CloseReason reason) throws Exception {
        logger.info('# onclose')
    }

    @Override
    void onEvents(PartitionContext context, Iterable<EventData> events) throws Exception {
        events.forEach{
            receive(it.bytes)
        }
    }

    @Override
    void onError(PartitionContext context, Throwable error) {
        logger.error('# onerror', error)
    }
}
