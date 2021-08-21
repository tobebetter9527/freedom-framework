package com.freedom.code.config;

import java.io.IOException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.activiti.core.common.spring.project.ProjectModelService;
import org.activiti.engine.impl.history.HistoryLevel;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2021/08/21 11:12
 */
@Slf4j
@Configuration
public class ActivitiSpringIdentityAutoConfig {

  @Autowired
  private DataSource dataSource;
  @Autowired
  private PlatformTransactionManager platformTransactionManager;
  @Autowired
  private ActivitiGeneratorConfig activitiGeneratorConfig;
  @Autowired
  private ProjectModelService projectModelService;

  @Bean
  public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
    return initSpringProcessEngineConfiguration(false);
  }

  private SpringProcessEngineConfiguration initSpringProcessEngineConfiguration(boolean autoDeploy) {
    SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration(projectModelService);
    configuration.setDataSource(dataSource);
    configuration.setTransactionManager(platformTransactionManager);
    SpringAsyncExecutor springAsyncExecutor = new SpringAsyncExecutor();
    configuration.setAsyncExecutor(springAsyncExecutor);
    configuration.setDatabaseSchemaUpdate("true");
    configuration.setHistoryLevel(HistoryLevel.FULL);
    configuration.setDbHistoryUsed(true);
    configuration.setIdGenerator(activitiGeneratorConfig);
    configuration.setDeploymentMode("never-fail");

    if (autoDeploy) {
      Resource[] resources = null;

      try {
        resources = new PathMatchingResourcePatternResolver().getResources("classpath*:bpmn/*.bpmn");
      } catch (IOException e) {
        log.error("deploy process fail", e);
      }
      configuration.setDeploymentResources(resources);
    }
    return configuration;
  }


}
