package hme.poc.hmepoc.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@Canonical
class MongoDBTestMessage {

    @Id
    String mongoId
    String payload
    String id
    long timestamp
}
