package hme.poc.hmepoc.dto

import groovy.transform.Canonical
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import org.springframework.data.redis.core.RedisHash

@Canonical
@RedisHash("TestMessage")
@Table
class TestMessage implements Serializable {
    String payload

    @PrimaryKey
    String id
    long timestamp
}
