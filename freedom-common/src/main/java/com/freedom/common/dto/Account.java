package com.freedom.common.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/05 23:30
 */
@Data
public class Account {

  private String name;

  private String bankName;

  private BigDecimal amount;
}
