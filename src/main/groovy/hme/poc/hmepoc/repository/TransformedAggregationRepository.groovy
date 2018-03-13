package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import org.springframework.context.annotation.Profile
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Profile('mongodb')
@Repository
interface TransformedAggregationRepository extends MongoRepository<TransformedAggregation, String> {
}
