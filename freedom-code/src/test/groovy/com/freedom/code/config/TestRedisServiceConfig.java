package com.freedom.code.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/02 11:27
 */
@ConditionalOnProperty(prefix = "test.conditional", name = "enabled", havingValue = "true")
@Configuration
public class TestRedisServiceConfig {

  private RedisServer redisServer;

  public TestRedisServiceConfig(RedisProperties redisProperties) {
    // this.redisServer = new RedisServer(redisProperties.getPort());
    this.redisServer = RedisServer.builder().port(redisProperties.getPort()).setting("maxmemory 128M").build();
  }

  @PostConstruct
  public void postConstruct() {
    redisServer.start();
  }

  @PreDestroy
  public void preDestroy() {
    redisServer.stop();
  }
}
