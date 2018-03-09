package hme.poc.hmepoc.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.Canonical
import org.springframework.data.redis.core.RedisHash

@RedisHash("TestMessage")
class TestMessage implements Serializable {
    String payload
    String id
    long timestamp
}
