package hme.poc.hmepoc.dto

import com.fasterxml.jackson.annotation.JsonIgnore
//import org.springframework.data.cassandra.core.mapping.PrimaryKey
//import org.springframework.data.cassandra.core.mapping.Table

//@Table
class CassandraTestMessage implements Serializable{

    String payload
    String id
//    @PrimaryKey
    @JsonIgnore
    String kasssandraId = UUID.randomUUID().toString()
    long timestamp
}
