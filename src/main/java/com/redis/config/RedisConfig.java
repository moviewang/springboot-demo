package com.redis.config;

import com.redis.bean.User;
import com.redis.serializer.RedisObjectSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Movie on 2017/7/7.
 */
@Configuration
public class RedisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new RedisObjectSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
