package com.freedom.code.mapper;

import java.util.Date;
import java.util.Map;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/10 17:14
 */
@Mapper
public interface SourceTargetMapper {

  @MapMapping(valueDateFormat = "dd.MM.yyyy")
  Map<String, String> longDateMapToStringStringMap(Map<Long, Date> source);

  @MapMapping(valueDateFormat = "dd.MM.yyyy")
  Map<Long, Date> stringStringMapToLongDateMap(Map<String, String> source);
}



