package hme.poc.hmepoc

import com.microsoft.azure.eventhubs.ConnectionStringBuilder
import com.microsoft.azure.eventhubs.EventHubClient
import com.microsoft.azure.eventprocessorhost.EventProcessorHost
import com.microsoft.azure.eventprocessorhost.IEventProcessorFactory
import com.microsoft.azure.eventprocessorhost.PartitionContext
import hme.poc.hmepoc.service.AzureEventHubInboundGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableRedisRepositories
@EnableScheduling
//@EnableAutoConfiguration(exclude=CassandraDataAutoConfiguration)
class HmepocApplication {

	private final static Logger logger = LoggerFactory.getLogger(HmepocApplication)

	static void main(String[] args) {
		SpringApplication.run HmepocApplication, args
	}

//	@Bean
//	MongoClient mongoClient(@Value('${azure.mongoConnectionString}') String mongoConnectionString) {
//		def mongoClient = new MongoClient(new MongoClientURI(mongoConnectionString))
//		mongoClient
//	}

//	@Bean
//	EventProcessorHost eventProcessorHost(@Value('${azure.connectionString}') String connectionString,
//										  @Value('${azure.storageConnectionString}')String storageConnectionString,
//										  AzureEventHubInboundGateway recieveHandler){
//		def connStr = new ConnectionStringBuilder(connectionString)
//		def eventProcessorHost = new EventProcessorHost(
//				'poc-event-processor',
//				'transpocrealevents',
//				EventHubClient.DEFAULT_CONSUMER_GROUP_NAME,
//				connStr.toString(),
//				storageConnectionString,
//				'teststoragecontainerpoc'
//
//		)
//
//		eventProcessorHost.registerEventProcessorFactory(new IEventProcessorFactory<AzureEventHubInboundGateway>(){
//
//			@Override
//			AzureEventHubInboundGateway createEventProcessor(PartitionContext context) throws Exception {
//				recieveHandler
//			}
//		})
//		eventProcessorHost
//	}

//	@Bean
//	EventHubClient eventHubClient(@Value('${azure.connectionString}') String connectionString, AzureEventHubInboundGateway recieveHandler){
//
//		def connStr = new ConnectionStringBuilder(connectionString)
//
//
//
////AzureEventHubInboundGateway
//		def ehClient = EventHubClient.create(connStr.toString(), Executors.newCachedThreadPool())
//
//		ehClient.get()
//	}
//
//	@Bean
//	PartitionReceiver partitionReceiver(EventHubClient eventHubClient, AzureEventHubInboundGateway recieveHandler) {
//		def partitionId = '0'
//		def receiver = eventHubClient.createReceiverSync(
//				EventHubClient.DEFAULT_CONSUMER_GROUP_NAME,
//				partitionId,
//				EventPosition.fromEnqueuedTime()
//		)
//		receiver.setReceiveTimeout(Duration.ofSeconds(20))
//		receiver.setReceiveHandler(recieveHandler).get()
//		receiver
//	}
}
