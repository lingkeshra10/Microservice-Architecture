package com.lingkesh.microservice.EmailService.config;

import com.lingkesh.microservice.EmailService.entity.EmailServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, EmailServer> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, EmailServer> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Set key and value serializers
        template.setKeySerializer(new StringRedisSerializer()); // String keys
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // JSON for values

        return template;
    }
}
