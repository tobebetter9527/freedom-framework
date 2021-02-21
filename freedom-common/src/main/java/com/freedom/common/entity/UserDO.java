package com.freedom.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.freedom.common.model.BaseDO;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description 用户类
 * @create 2020/12/27 20:21
 */
@Data
@TableName("user")
public class UserDO extends BaseDO {

  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  private String name;
  private Integer age;
  private String email;

  @TableField(exist = false)
  private RoleDO roleDO;

}
