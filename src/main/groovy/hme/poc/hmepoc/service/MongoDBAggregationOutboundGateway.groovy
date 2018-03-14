package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.repository.TransformedAggregationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDBAggregationOutboundGateway implements MessageProducingPort {

    private final TransformedAggregationRepository transformedAggregationRepository

    @Autowired
    MongoDBAggregationOutboundGateway( final TransformedAggregationRepository transformedAggregationRepository ) {
        this.transformedAggregationRepository = transformedAggregationRepository
    }

    @Override
    void produce( final List<TransformedAggregation> aggregations ) {
        aggregations.collect {
            it.mongoId = UUID.randomUUID() as String
            it
        }
        aggregations.collect {
            transformedAggregationRepository.save(it)
        }
    }
}
