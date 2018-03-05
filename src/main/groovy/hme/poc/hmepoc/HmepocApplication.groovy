package hme.poc.hmepoc

import hme.poc.hmepoc.dto.TestMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@SpringBootApplication
@EnableRedisRepositories
//@EnableAutoConfiguration(exclude=CassandraDataAutoConfiguration)
class HmepocApplication {

	private final static Logger logger = LoggerFactory.getLogger(HmepocApplication)

	static void main(String[] args) {
		SpringApplication.run HmepocApplication, args
	}

	@Bean
	RedisConnectionFactory connectionFactory() {
		new JedisConnectionFactory()
	}

	@Bean
	RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {

		RedisTemplate<String, TestMessage> template = new RedisTemplate<>()
		template.setConnectionFactory(connectionFactory)
		template
	}
}
