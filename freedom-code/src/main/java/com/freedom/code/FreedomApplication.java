package com.freedom.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tobebetter9527
 * @description springboot启动类
 * @create 2020/12/27 20:11
 */
@SpringBootApplication
@MapperScan("com.freedom.*.repository")
@EnableAsync
@EnableDiscoveryClient
@EnableFeignClients
public class FreedomApplication {

  public static void main(String[] args) {
    SpringApplication.run(FreedomApplication.class, args);
  }


}
