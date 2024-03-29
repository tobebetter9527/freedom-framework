package com.freedom.activiti;

import com.freedom.code.FreedomApplication;
import com.freedom.code.util.SecurityUtil;
import com.oracle.webservices.internal.api.EnvelopeStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tobebetter9527
 * @description user测试类
 * @create 2021/02/17 10:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FreedomApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ActivitiTest {

  @Resource
  private RepositoryService repositoryService;
  @Resource
  private TaskService taskService;
  @Resource
  private RuntimeService runtimeService;
  @Resource
  private HistoryService historyService;
  @Resource
  private ProcessRuntime processRuntime;
  @Autowired
  private TaskRuntime taskRuntime;
  @Resource
  private SecurityUtil securityUtil;

  /**
   * 根据bpmn文件，创建一个新的流程
   */
  @Test
  public void create() {
    Deployment deployment = repositoryService.createDeployment()
        .addClasspathResource("bpmn/HelloWorldWithListener.bpmn")//添加bpmn资源
        //.addClasspathResource("diagram/holiday.png")
        .name("Hello World with listener")
        .deploy();

    System.out.println("流程部署id:" + deployment.getId());
    System.out.println("流程部署名称:" + deployment.getName());
  }

  /**
   * 查询已有的流程
   */
  @Test
  public void read() {
    List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
    for (ProcessDefinition p : processDefinitions) {
      System.out.println(p.getDeploymentId());
      System.out.println(p);
    }
  }

  /**
   * 删除已有的流程
   */
  @Test
  public void delete() {
    //这个id是DeploymentId
   // repositoryService.deleteDeployment("6c41300f-aee0-11ea-9969-00ff0d0b7f9d");
    List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
    for (ProcessDefinition p : processDefinitions) {
      repositoryService.deleteDeployment(p.getDeploymentId());
      System.out.println("DeploymentId:" + p.getDeploymentId());
      System.out.println(p);
    }
  }

  /**
   * 启动一个实例
   */
  @Test
  public void startProcessInstance() {
    System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("HelloWorldWithListener");
    System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());

  }

  /**
   * 传递参数、读取参数 查询用户的任务列表
   */
  @Test
  public void taskQuery() {
    //根据流程定义的key,负责人assignee来实现当前用户的任务列表查询
    List<Task> list = taskService.createTaskQuery()
        .processDefinitionKey("myProcess_leave")
        .taskCandidateOrAssigned("teamleader")
        .list();

    if (list != null && list.size() > 0) {

      for (Task task : list) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", "Kermit");
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");

        taskService.setVariable(task.getId(), "参数", variables);
      }

      for (Task task : list) {
        System.out.println("任务ID:" + task.getId());
        System.out.println("任务名称:" + task.getName());
        System.out.println("任务的创建时间:" + task.getCreateTime());
        System.out.println("任务的办理人:" + task.getAssignee());
        System.out.println("流程实例ID：" + task.getProcessInstanceId());
        System.out.println("执行对象ID:" + task.getExecutionId());
        System.out.println("流程定义ID:" + task.getProcessDefinitionId());
        System.out.println("getOwner:" + task.getOwner());
        System.out.println("getCategory:" + task.getCategory());
        System.out.println("getDescription:" + task.getDescription());
        System.out.println("getFormKey:" + task.getFormKey());

        Map<String, Object> map1 = (Map<String, Object>) taskService.getVariable(task.getId(), "参数");
        for (Map.Entry<String, Object> m : map1.entrySet()) {
          System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }
        Map<String, Object> map = task.getProcessVariables();
        for (Map.Entry<String, Object> m : map.entrySet()) {
          System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }
        for (Map.Entry<String, Object> m : task.getTaskLocalVariables().entrySet()) {
          System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }

      }
    }
  }

  /**
   * 完成任务
   */
  @Test
  public void completeTask() {
    securityUtil.logInAs("salaboy");        //指定组内任务人
    Page<org.activiti.api.task.model.Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
    if (tasks.getTotalItems() > 0) {
      for (org.activiti.api.task.model.Task task : tasks.getContent()) {
        System.out.println("任务名称：" + task.getName());
        //拾取任务
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
        //执行任务
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
      }
    }
  }

  @Test
  public void completeTask2() {
    List<Task> list = taskService.createTaskQuery().list();
    for (Task task : list) {
      taskService.complete(task.getId());
    }
  }

  /**
   * 历史活动实例查询,参数也能查到
   */
  @Test
  public void queryHistoryTask() {
    List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery() // 创建历史活动实例查询
        //                .processInstanceId("9671cdea-3367-11ea-a057-30b49ec7161f") // 执行流程实例id
        .includeProcessVariables()
        .orderByTaskCreateTime()
        .asc()
        .list();
    for (HistoricTaskInstance hai : list) {
      System.out.println("活动ID:" + hai.getId());
      System.out.println("流程实例ID:" + hai.getProcessInstanceId());
      System.out.println("活动名称：" + hai.getName());
      System.out.println("办理人：" + hai.getAssignee());
      System.out.println("开始时间：" + hai.getStartTime());
      System.out.println("结束时间：" + hai.getEndTime());
    }
  }

  @Test
  public void deleteProcessInstance() {
    runtimeService.deleteProcessInstance("1428933503352369154","废弃");
  }

  @Test
  public void deleteDeployment() {
    repositoryService.deleteDeployment("1428933205909110786");
  }
}