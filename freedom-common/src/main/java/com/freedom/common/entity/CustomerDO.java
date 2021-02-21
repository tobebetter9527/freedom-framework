package com.freedom.common.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/05 23:27
 */
@Data
public class CustomerDO {

  private Long id;

  private String name;

  private LocalDateTime buyDate;

  private String bankName;

  private BigDecimal amount;


}
