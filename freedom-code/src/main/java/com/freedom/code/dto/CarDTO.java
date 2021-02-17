package com.freedom.code.dto;

import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/07 22:14
 */
@Data
public class CarDTO {

  private Integer id;
  private String name;
  private Integer price;

  private boolean electronic;

  public CarDTO(String name) {
    this.name = name;
  }
}
