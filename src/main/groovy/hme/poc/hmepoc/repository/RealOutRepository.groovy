package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.TestRealOut
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RealOutRepository extends MongoRepository<TestRealOut, String> {
}
