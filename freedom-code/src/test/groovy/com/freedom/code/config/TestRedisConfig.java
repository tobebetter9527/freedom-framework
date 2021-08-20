package com.freedom.code.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/02 11:27
 */
@ConditionalOnProperty(prefix = "test.conditional", name = "enabled", havingValue = "true")
@Configuration
//@EnableRedisRepositories
public class TestRedisConfig {

//  @Bean
//  public LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
//    return new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());
//  }
//
//  @Bean
//  public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
//    RedisTemplate<String, Object> template = new RedisTemplate<>();
//    template.setConnectionFactory(connectionFactory);
//    template.setKeySerializer(new StringRedisSerializer());
//    template.setValueSerializer(new StringRedisSerializer());
//    template.setHashKeySerializer(new StringRedisSerializer());
//    template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//    return template;
//  }

}
