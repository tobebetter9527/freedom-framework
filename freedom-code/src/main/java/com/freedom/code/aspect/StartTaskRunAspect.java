package com.freedom.code.aspect;

import com.freedom.code.annotation.StartTaskRun;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/23 22:53
 */
@Aspect
@Component
public class StartTaskRunAspect {

  @AfterReturning(pointcut = "@annotation(com.freedom.code.annotation.StartTaskRun) || @annotation(com.freedom.code.annotation.StartTaskRuns)", returning = "retValue")
  public void startTask(JoinPoint joinPoint, Object retValue) throws Exception {
    Object[] args = joinPoint.getArgs();
    Signature signature = joinPoint.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    Method method = methodSignature.getMethod();
    StartTaskRun[] annotations = method.getAnnotationsByType(StartTaskRun.class);
    for (StartTaskRun annotation : annotations) {
      System.out.println(annotation.businessType());
    }
  }
}
