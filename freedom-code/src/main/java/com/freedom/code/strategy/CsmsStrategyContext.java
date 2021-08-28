package com.freedom.code.strategy;

import com.freedom.code.util.SpringContextUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/23 23:20
 */
@Service
public class CsmsStrategyContext {

  @Autowired
  private SpringContextUtil springContextUtil;

  private Map<String, CsmsStrategy> map = new HashMap<>();


  @Transactional(rollbackFor = Exception.class)
  public String doCsmsStrategy(Long id) {
    CsmsStrategy userService = springContextUtil.getContext().getBean("userService", CsmsStrategy.class);
    String s = userService.doCsmsStrategy(id);
    return s;
  }


}
