package xyz.engsmyre.moviedescriptiongame.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory

@Configuration
open class RedisConfig {

    @Value("#{environment['REDIS_HOST']}")
    private lateinit var hostName : String

    @Bean
    open fun redisConnectionFactory(): JedisConnectionFactory {
        val redisConfig = RedisStandaloneConfiguration(hostName, 6379) // TODO Move to properties
        return JedisConnectionFactory(redisConfig)
    }
}