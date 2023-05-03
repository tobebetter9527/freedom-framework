package com.freedom.code.controller;

import com.freedom.code.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tobebetter9527
 * @create 2020/12/28 0:14
 */
@Api(tags = {"库存接口"})
@RestController
@RequestMapping("/v1/storage")
public class StorageController {

  @Autowired
  private StorageService storageService;

  @ApiOperation(value = "减少库存", notes = "减少库存")
  @PostMapping("/deduct/{productId}/{num}")
  public int deduct(@PathVariable("productId") Long productId, @PathVariable("num") Long num) {
    return storageService.deduct(productId, num);
  }
}
