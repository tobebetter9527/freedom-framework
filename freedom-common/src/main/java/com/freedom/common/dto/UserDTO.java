package com.freedom.common.dto;

import com.freedom.common.model.BaseDTO;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description 用户类
 * @create 2020/12/27 20:21
 */
@Data
public class UserDTO extends BaseDTO {

  private Long id;
  private String name;
  private Integer age;
  private String email;

  private RoleDTO roleDTO;
}
