package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord

interface TransformRecordsRepositoryExtension {

    List<TransformedAggregation> aggregateEvents()
}