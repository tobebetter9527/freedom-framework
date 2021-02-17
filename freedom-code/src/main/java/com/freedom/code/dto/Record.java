package com.freedom.code.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/05 23:28
 */
@Data
public class Record {
  private String name;

  private LocalDateTime buyDate;
}
