package hme.poc.hmepoc.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.microsoft.azure.eventhubs.EventData
import com.microsoft.azure.eventhubs.EventHubClient
import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDBAggregationOutboundGateway implements MessageProducingPort {

    private final TransformedAggregationRepository transformedAggregationRepository
    private final EventHubClient eventHubClient
    private final ObjectMapper objectMapper

    @Autowired
    MongoDBAggregationOutboundGateway(
            final TransformedAggregationRepository transformedAggregationRepository, ObjectMapper objectMapper, EventHubClient eventHubClient) {
        this.transformedAggregationRepository = transformedAggregationRepository
        this.objectMapper = objectMapper
        this.eventHubClient = eventHubClient
    }

    @Override
    void produce( final List<TransformedAggregation> aggregations ) {
        aggregations.collect {
            it.mongoId = UUID.randomUUID() as String
            transformedAggregationRepository.save(it)
        }
//        aggregations.each {
//            eventHubClient.send(EventData.create(objectMapper.writeValueAsBytes(it)))
//        }
//        aggregations.collect {
//            it.mongoId = UUID.randomUUID() as String
//            it
//        }
//        aggregations.collect {
//            transformedAggregationRepository.save(it)
//        }
    }
}
