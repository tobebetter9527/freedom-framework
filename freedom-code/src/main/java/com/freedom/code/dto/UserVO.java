package com.freedom.code.dto;

import com.freedom.code.mybatis.model.BaseDTO;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description 用户类
 * @create 2020/12/27 20:21
 */
@Data
public class UserVO extends BaseDTO {

  private Long userId;
  private String username;
  private Integer myAge;
  private String email;

}
