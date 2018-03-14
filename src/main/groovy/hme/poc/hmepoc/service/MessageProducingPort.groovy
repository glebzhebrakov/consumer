package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation

interface MessageProducingPort {
    void produce( final List<TransformedAggregation> aggregations )
}
