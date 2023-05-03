package com.freedom.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description 用户类
 * @create 2020/12/27 20:21
 */
@Data
@TableName("storage_tb")
public class StorageDO {

  @TableId(type = IdType.ASSIGN_ID)
  private Long id;

  private Long productId;

  private Long productNum;


}
