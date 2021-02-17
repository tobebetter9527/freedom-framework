package com.freedom.code.mybatis.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/02 18:03
 */
@Data
public class BaseDO {

  @TableField(fill = FieldFill.INSERT)
  protected String createBy;
  @TableField(fill = FieldFill.INSERT)
  protected String createByName;
  @TableField(fill = FieldFill.INSERT)
  protected LocalDateTime createDate;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  protected String updateBy;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  protected String updateByName;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  protected LocalDateTime updateDate;

  @Version
  protected Integer version;

}
