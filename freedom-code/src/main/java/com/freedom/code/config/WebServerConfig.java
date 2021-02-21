package com.freedom.code.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/02/18 22:51
 */

@Configuration
public class WebServerConfig {

  @Bean
  public ApplicationRunner runner(WebServerApplicationContext context) {
    return args -> {
      System.out.println("2.当前WebServer实现类为：" + context.getWebServer().getPort());
    };
  }

}
