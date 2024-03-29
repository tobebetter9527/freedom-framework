package com.freedom.code.controller;

import com.freedom.code.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Api(tags = {"工作流接口"})
@RestController
@RequestMapping("/v1/activiti")
public class ActivitiController {

  @Autowired
  private ProcessRuntime processRuntime;
  @Autowired
  private TaskRuntime taskRuntime;
  @Autowired
  private SecurityUtil securityUtil;
  @Autowired
  private ProcessEngine processEngine;

  /**
   * 根据bpmn文件部署一个流程
   *
   * @return 流程部署信息
   */
  @PostMapping("/deploy")
  @ApiOperation(value = "部署工作流bpmn文件")
  public Deployment deploy(@ApiParam(value = "bpmn2.0文件", required = true) @RequestParam("file") MultipartFile file
      //@ApiParam(value = "流程名称", required = true) @RequestParam("flowName") String flowName
     ) {
    System.out.println("sdfa");
    try (InputStream inputStream = file.getInputStream()) {

    } catch (Exception e) {
      log.error("saf", e);
    }

    RepositoryService repositoryService = processEngine.getRepositoryService();
    Deployment deployment = repositoryService.createDeployment()
        .addClasspathResource("processes/leave-approve.bpmn")//添加bpmn资源
        //                .addClasspathResource("diagram/holiday.png")
        .name("请假申请单流程")
        .deploy();

    System.out.println("流程部署id:" + deployment.getName());
    System.out.println("流程部署名称:" + deployment.getId());
    return deployment;
  }

  /**
   * 查询已经部署的流程
   */
  // @RequestMapping("/getProcess")
  public void getProcess() {
    //查询所有流程定义信息
    Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
    System.out.println("当前流程定义的数量：" + processDefinitionPage.getTotalItems());
    //获取流程信息
    for (ProcessDefinition processDefinition : processDefinitionPage.getContent()) {
      System.out.println("流程定义信息" + processDefinition);
    }
  }


  /**
   * 启动流程示例
   */
  //  @RequestMapping("/startInstance")
  public void startInstance() {
    ProcessInstance instance = processRuntime
        .start(ProcessPayloadBuilder.start().withProcessDefinitionKey("myProcess_leave_approve_1").build());
    System.out.println(instance.getId());
  }

  /**
   * 获取任务，拾取任务，并且执行（认领、完成）
   */
  //@RequestMapping("/getTask")
  public void getTask() {
    securityUtil.logInAs("team-leader");        //指定组内任务人
    Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
    if (tasks.getTotalItems() > 0) {
      for (Task task : tasks.getContent()) {
        System.out.println("任务名称：" + task.getName());
        //拾取任务
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
        //执行任务
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
      }
    }
  }
}