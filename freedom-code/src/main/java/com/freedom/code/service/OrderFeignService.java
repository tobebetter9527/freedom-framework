package com.freedom.code.service;

import com.freedom.common.dto.OrderDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2022/04/13 22:26
 */
@Component
@FeignClient(value = "freedom-order")
public interface OrderFeignService {

  @GetMapping("/v1/order/getById")
  OrderDTO getById(@ApiParam(value = "用户id") @RequestParam("id") Long id);
}
