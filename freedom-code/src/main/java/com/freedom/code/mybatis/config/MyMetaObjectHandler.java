package com.freedom.code.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/02 20:57
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  private static final String CREATE_BY = "createBy";
  private static final String CREATE_BY_NAME = "createByName";
  private static final String CREATE_DATE = "createDate";
  private static final String UPDATE_BY = "updateBy";
  private static final String UPDATE_BY_NAME = "updateByName";
  private static final String UPDATE_DATE = "updateDate";


  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, CREATE_BY, String.class, "system");
    this.strictInsertFill(metaObject, CREATE_BY_NAME, String.class, "system");
    this.strictInsertFill(metaObject, CREATE_DATE, LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, UPDATE_BY, String.class, "system");
    this.strictInsertFill(metaObject, UPDATE_BY_NAME, String.class, "system");
    this.strictInsertFill(metaObject, UPDATE_DATE, LocalDateTime.class, LocalDateTime.now());

  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, UPDATE_BY, String.class, "system2");
    this.strictUpdateFill(metaObject, UPDATE_BY_NAME, String.class, "system2");
    this.strictUpdateFill(metaObject, UPDATE_DATE, LocalDateTime.class, LocalDateTime.now());
  }

  @Override
  public MetaObjectHandler strictFillStrategy(MetaObject metaObject, String fieldName, Supplier<?> fieldVal) {
    Object obj = fieldVal.get();
    if (Objects.nonNull(obj)) {
      metaObject.setValue(fieldName, obj);
    }
    return this;
  }
}
