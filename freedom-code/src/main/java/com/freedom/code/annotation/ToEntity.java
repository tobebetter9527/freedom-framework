package com.freedom.code.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.mapstruct.Mapping;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/01/04 23:07
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@Mapping(target = "username", source = "name")
public @interface ToEntity {

}
