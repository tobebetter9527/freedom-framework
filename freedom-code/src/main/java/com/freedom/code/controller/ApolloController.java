package com.freedom.code.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tobebetter9527
 * @create 2022/03/30
 */
@Api(tags = {"apollo接口"})
@RestController
@RequestMapping("/v1/apollo")
public class ApolloController {

  @Value("${test.apollo.test}")
  private String value;

  @ApiOperation(value = "测试apollo", notes = "测试apollo")
  @GetMapping("/test")
  public String test() {
    return value;
  }

}
