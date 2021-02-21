package com.freedom.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/05 0:14
 */
@Data
public class RoleDO {
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  private String name;
}
