package com.freedom.code.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/21 11:41
 */
@Service("myExpressionTaskListener")
public class ExpressionTaskListener {

  public void callBack(DelegateTask task) {
    System.out.println("ExpressionTaskListener procInstId" + task.getProcessInstanceId());
  }
}
