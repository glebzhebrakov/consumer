package hme.poc.hmepoc.dto

import groovy.transform.Canonical
import org.springframework.data.redis.core.RedisHash

@Canonical
@RedisHash("TestMessage")
class TestMessage implements Serializable {
    String payload
    String id
    long timestamp
}
