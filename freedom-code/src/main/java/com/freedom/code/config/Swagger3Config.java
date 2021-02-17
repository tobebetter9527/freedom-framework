package com.freedom.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/01 20:59
 */
@EnableOpenApi
@Configuration
public class Swagger3Config {

  @Autowired
  private SwaggerProperties swaggerProperties;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.OAS_30).pathMapping("/")
        // 定义是否开启swagger，false为关闭，可以通过变量控制
        .enable(swaggerProperties.getEnable())

        // 将api的元信息设置为包含在json ResourceListing响应中。
        .apiInfo(apiInfo())

        // 接口调试地址
        .host(swaggerProperties.getTryHost())

        // 选择哪些接口作为swagger的doc发布
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  /**
   * API 页面上半部分展示信息
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(swaggerProperties.getApplicationName() + " Api Doc")
        .description(swaggerProperties.getApplicationDescription())
        .version("Application Version: " + swaggerProperties.getApplicationVersion() + ", Spring Boot Version: "
            + SpringBootVersion
            .getVersion())
        .build();
  }

}
