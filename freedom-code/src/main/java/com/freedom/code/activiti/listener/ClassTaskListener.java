package com.freedom.code.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/21 11:41
 */
public class ClassTaskListener implements TaskListener {

  @Override
  public void notify(DelegateTask delegateTask) {
    System.out.println("ClassTaskListener procInstId" + delegateTask.getProcessInstanceId());
  }
}
