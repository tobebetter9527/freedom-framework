package com.freedom.code.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/12/24 21:23
 */
@Slf4j
@Component
public class SpringContextUtil implements ApplicationContextAware {

  private static DefaultListableBeanFactory springFactory;
  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
    if (applicationContext instanceof AbstractRefreshableApplicationContext) {
      AbstractRefreshableApplicationContext springContext = (AbstractRefreshableApplicationContext) applicationContext;
      springFactory = (DefaultListableBeanFactory) springContext.getBeanFactory();
    } else if (applicationContext instanceof GenericApplicationContext) {
      GenericApplicationContext springContext = (GenericApplicationContext) applicationContext;
      springFactory = springContext.getDefaultListableBeanFactory();
    }
  }

  public DefaultListableBeanFactory getSpringFactory() {
    return springFactory;
  }

  public ApplicationContext getContext() {
    return context;
  }
}
