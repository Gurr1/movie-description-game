package xyz.engsmyre.moviedescriptiongame.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory

@Configuration
open class RedisConfig {
    @Bean
    open fun redisConnectionFactory(): JedisConnectionFactory {
        val redisConfig = RedisStandaloneConfiguration("0.0.0.0", 6379) // TODO Move to properties
        return JedisConnectionFactory(redisConfig)
    }
}