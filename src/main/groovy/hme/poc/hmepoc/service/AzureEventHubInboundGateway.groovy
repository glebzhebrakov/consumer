package hme.poc.hmepoc.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.microsoft.azure.eventhubs.EventData
import com.microsoft.azure.eventprocessorhost.CloseReason
import com.microsoft.azure.eventprocessorhost.IEventProcessor
import com.microsoft.azure.eventprocessorhost.PartitionContext
import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.TestRealOut
import hme.poc.hmepoc.repository.RealOutRepository
import org.apache.commons.io.FileUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class AzureEventHubInboundGateway implements MessageConsumingPort, /*PartitionReceiveHandler,*/ IEventProcessor {

    private final MessageStoragePort storagePort
    private final MessageProducingPort messageProducingPort
    private final ObjectMapper objectMapper
    private final static Logger logger = LoggerFactory.getLogger(AzureEventHubInboundGateway)
    private final RealOutRepository realOutRepository

    @Autowired
    AzureEventHubInboundGateway(final MessageStoragePort storagePort,
                                final ObjectMapper objectMapper,
                                final MessageProducingPort messageProducingPort,
                                final RealOutRepository realOutRepository) {
        this.storagePort = storagePort
        this.objectMapper = objectMapper
        this.messageProducingPort = messageProducingPort
        this.realOutRepository = realOutRepository
    }

    @Override
    void receive(byte[] message) {}

    @Override
    void receive( final List<EventRecord> records ) {
//        def collectionName = UUID.randomUUID() as String
//        storagePort.transform( records, collectionName )
//        messageProducingPort.produce( storagePort.aggregate(collectionName) )
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
        logger.info('# onevents')
//        realOutRepository.saveAll(events.collect { e->
//            new TestRealOut().with {
//                mongoId = UUID.randomUUID().toString()
//                payload = new String(e.bytes)
//                it
//            }
//        })
//        receive(events.collect {
//            objectMapper.readValue(it.bytes, EventRecord)
//        })
    }

//    @PostConstruct
//    void save(){
//        def file = new File('/home/glibzhebrakov/oureal.json')
//        FileUtils.writeLines(file, realOutRepository.findAll()*.payload)
////        realOutRepository.findAll().each {
////
////        }
//    }

    @Override
    void onError(PartitionContext context, Throwable error) {
        logger.error('# onerror', error)
    }
}
