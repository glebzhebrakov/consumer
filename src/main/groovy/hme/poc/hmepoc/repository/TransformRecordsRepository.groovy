package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord
import org.springframework.context.annotation.Profile
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TransformRecordsRepository extends MongoRepository<TransformedRecord, String>, TransformRecordsRepositoryExtension {
}
