package hme.poc.hmepoc.dto

import com.datastax.driver.core.utils.UUIDs
import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.Canonical
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import org.springframework.data.redis.core.RedisHash

@RedisHash("TestMessage")
class TestMessage implements Serializable {
    String payload


    String id

    @JsonIgnore
    String kasssandraId = UUID.randomUUID().toString()

    String randId = UUID.randomUUID().toString()
    long timestamp
}
