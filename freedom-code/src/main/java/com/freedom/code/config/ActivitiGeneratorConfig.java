package com.freedom.code.config;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.stereotype.Component;

/**
 * 工作流id产生方式
 *
 * @author tobebetter9527
 * @create 2021/08/21 11:00
 */
@Component
public class ActivitiGeneratorConfig implements IdGenerator {

  @Override
  public String getNextId() {
    return IdWorker.getIdStr();
  }
}
