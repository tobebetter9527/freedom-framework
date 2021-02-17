package com.freedom.code.entity;

import lombok.Data;
import org.mapstruct.MapperConfig;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/07 22:14
 */
@Data
public class CarDO {

  private Long id;
  private String name;

  private String price;

  private Boolean electronic;

}
