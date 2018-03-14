package hme.poc.hmepoc.dto.domain
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class TestRealOut {

    @Id
    String mongoId

    String payload
}
