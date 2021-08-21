package com.freedom.code.activiti.listener;

import com.freedom.code.service.UserService;
import com.freedom.common.entity.UserDO;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/21 11:41
 */
@Service("myExpressionTaskListener")
public class ExpressionTaskListener {

  @Autowired
  private UserService userService;

  public void callBack(DelegateTask task) {
    System.out.println("ExpressionTaskListener procInstId" + task.getProcessInstanceId());
    UserDO userDO = userService.selectById(123456L);
    System.out.println(userDO);
  }
}
