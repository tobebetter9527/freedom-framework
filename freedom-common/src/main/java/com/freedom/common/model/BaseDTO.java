package com.freedom.common.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/02 18:03
 */
@Data
public class BaseDTO {

  protected String createBy;
  protected String createByName;
  protected LocalDateTime createDate;
  protected String updateBy;
  protected String updateByName;
  protected LocalDateTime updateDate;
  protected Integer version;

}
