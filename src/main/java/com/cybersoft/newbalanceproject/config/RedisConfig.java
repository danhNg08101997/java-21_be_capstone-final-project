package com.cybersoft.newbalanceproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;

    @Bean
    public LettuceConnectionFactory connectionFactory(){
        // Khai báo thông tin server redis sử dụng
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        return new LettuceConnectionFactory(configuration);
    }
    @Bean
    @Primary
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, String>redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
