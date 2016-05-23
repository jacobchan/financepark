package com.gsoft.framework.workflow.service.impl;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ResultMessage;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.gsoft.framework.workflow.dao.FlowDao;
import com.gsoft.framework.workflow.entity.Flow;
import com.gsoft.framework.workflow.entity.TaskForm;
import com.gsoft.framework.workflow.entity.TaskVO;
import com.gsoft.framework.workflow.entity.WorkflowDomain;
import com.gsoft.framework.workflow.service.AccountFlowBusinessService;
import com.gsoft.framework.workflow.service.FlowBusinessService;
import com.gsoft.framework.workflow.service.FlowBusinessServiceFactoryBean;
import com.gsoft.framework.workflow.service.FlowRunManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

@Service("flowRunManager")
@Transactional
public class FlowRunManagerImpl extends BaseManagerImpl
  implements FlowRunManager, ApplicationContextAware
{

  @Autowired
  private FlowDao<Flow, String> flowDao;

  @Resource(name="processEngine")
  private ProcessEngine processEngine;
  private ApplicationContext applicationContext;

  @Resource(name="flowBusinessService")
  private FlowBusinessService defaultFlowBusinessService;

  @EsbServiceMapping
  @ResultMessage(info="申请成功")
  public String start(@ServiceParam(name="processDefinitionId") String processDefinitionKey, @ServiceParam(name="initiator", pubProperty="userId") String initiator, Map<String, Object> variables)
  {
    variables.remove("processDefinitionId");

    Assert.notNull(processDefinitionKey, "参数processDefinitionKey不能为空");

    Flow flow = getFlowByProcessDefinitionIdOrKey(null, processDefinitionKey);

    ProcessDefinition processDefinition = getProcessDefinition(processDefinitionKey);
    StartFormData startFormData = 
      this.processEngine.getFormService().getStartFormData(processDefinition.getId());

    List<FormProperty> formProperties = startFormData.getFormProperties();
    if (formProperties != null) {
      for (FormProperty formProperty : formProperties) {
        variables.put(formProperty.getId(), formProperty.getValue());
      }

    }

    FlowBusinessService flowBusinessService = createFlowBusinessService(flow.getBusinessService());

    WorkflowDomain businessObject = null;

    if (flowBusinessService != null)
    {
      businessObject = flowBusinessService.saveBusiness(flow.getBusinessService(), variables);

      if (AccountFlowBusinessService.class.isAssignableFrom(AopUtils.getTargetClass(flowBusinessService))) {
        Map accountProperties = 
          ((AccountFlowBusinessService)flowBusinessService).getCustomAccountProperties();
        if (accountProperties != null) {
          variables.putAll(accountProperties);
        }
      }
    }
    if (initiator != null) {
      this.processEngine.getIdentityService().setAuthenticatedUserId(initiator);
    }

    Map flowVariables = buildFlowVariables(variables);

    if (businessObject != null) {
      ProcessInstance processInstance = this.processEngine.getRuntimeService().startProcessInstanceByKey(
        processDefinitionKey, businessObject.getBusinessKey(), flowVariables);

      flowBusinessService.saveProcessInstanceId(flow.getBusinessService(), processInstance);
    } else {
      this.processEngine.getRuntimeService().startProcessInstanceByKey(
        processDefinitionKey, flowVariables);
    }
    return "";
  }

  private Map<String, Object> buildFlowVariables(Map<String, Object> variables) {
    Map flowVariables = new HashMap();

    for (Map.Entry entry : variables.entrySet()) {
      if (!((String)entry.getKey()).startsWith("s:")) {
        flowVariables.put((String)entry.getKey(), entry.getValue());
      }
    }
    return flowVariables;
  }

  private Flow getFlowByProcessDefinitionIdOrKey(String processDefinitionId, String processDefinitionKey)
  {
    ProcessDefinition processDefinition = null;

    if (StringUtils.isNotEmpty(processDefinitionId))
      processDefinition = this.processEngine.getRepositoryService().getProcessDefinition(processDefinitionId);
    else if (StringUtils.isNotEmpty(processDefinitionKey)) {
      processDefinition = 
        (ProcessDefinition)this.processEngine.getRepositoryService().createProcessDefinitionQuery()
        .processDefinitionKey(processDefinitionKey).latestVersion().singleResult();
    }

    Assert.notNull(processDefinition, 
      "processDefinitionKey[" + processDefinitionKey + "]没有对应的流程定义！");

    Deployment deployment = 
      (Deployment)this.processEngine.getRepositoryService().createDeploymentQuery()
      .deploymentId(processDefinition.getDeploymentId()).singleResult();

    List allDeploys = 
      ((DeploymentQuery)this.processEngine.getRepositoryService().createDeploymentQuery()
      .deploymentName(deployment.getName()).orderByDeploymenTime().desc()).list();

    Flow flow = (Flow)this.flowDao.getObjectByUniqueProperty("deployId", ((Deployment)allDeploys.get(0)).getId());

    Assert.notNull(flow, "未配置的流程！");
    return flow;
  }

  @EsbServiceMapping
  public void completeTask(@ServiceParam(name="taskId") String taskId, Map<String, Object> taskVariables)
  {
    Task task = 
      (Task)this.processEngine.getTaskService().createTaskQuery().taskId(taskId).singleResult();
    Assert.notNull(task, "任务[" + taskId + "]未找到！");

    Flow flow = getFlowByProcessDefinitionIdOrKey(task.getProcessDefinitionId(), null);

    FlowBusinessService flowBusinessService = createFlowBusinessService(flow.getBusinessService());

    if (flowBusinessService != null)
    {
      ProcessInstance processInstance = 
        (ProcessInstance)this.processEngine.getRuntimeService().createProcessInstanceQuery()
        .processInstanceId(task.getProcessInstanceId()).singleResult();

      TaskFormData taskFormData = 
        this.processEngine.getFormService().getTaskFormData(taskId);
      List<FormProperty> formProperties = taskFormData.getFormProperties();
      if (formProperties != null) {
        for (FormProperty formProperty : formProperties)
        {
          taskVariables.put(formProperty.getId(), formProperty.getValue());
        }
      }
      flowBusinessService.updateBusiness(flow.getBusinessService(), processInstance, task, taskVariables);
    }

    Map flowVariables = buildFlowVariables(taskVariables);

    this.processEngine.getTaskService().complete(taskId, flowVariables);
  }

  @EsbServiceMapping
  public Record getStartFormData(@ServiceParam(name="processKey") String processKey)
    throws BusException
  {
    ProcessDefinition processDefinition = getProcessDefinition(processKey);
    StartFormData startFormData = 
      this.processEngine.getFormService().getStartFormData(processDefinition.getId());
    Record record = new Record();

    List<FormProperty> formProperties = startFormData.getFormProperties();
    for (FormProperty formProperty : formProperties) {
      record.put(formProperty.getId(), formProperty.getValue());
    }

    record.put("processDefinitionKey", processDefinition.getKey());

    record.put("formKey", startFormData.getFormKey());

    record.put("processDefinitionId", processDefinition.getKey());

    return record;
  }

  public TaskForm getTaskFormData(String taskId)
    throws BusException
  {
    TaskFormData taskFormData = 
      this.processEngine.getFormService().getTaskFormData(taskId);

    Map variables = this.processEngine.getRuntimeService()
      .getVariables(taskFormData.getTask().getExecutionId());
    String processDefinitionId = taskFormData.getTask().getProcessDefinitionId();
    int splitIndex = processDefinitionId.indexOf(":");
    if (splitIndex != -1) {
      processDefinitionId = processDefinitionId.substring(0, processDefinitionId.indexOf(":"));
    }

    TaskForm taskForm = new TaskForm();
    taskForm.setFlowName(processDefinitionId);
    taskForm.setFormKey(taskFormData.getFormKey());
    taskForm.setVariables(variables);

    return taskForm;
  }

  public PagerRecords getUserPagerTasks(String userId, Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    if (conditions == null) {
      conditions = new ArrayList();
    }

    conditions.add(ConditionUtils.getCondition("user", 
      "EQUALS", userId));

    return getPagerTasks(pager, conditions, orders);
  }

  public PagerRecords getGroupPagerTasks(AccountPrincipal account, Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    if (conditions == null) {
      conditions = new LinkedList();
    }

    conditions.add(ConditionUtils.getCondition("user", 
      "EQUALS", PropertyUtils.getPropertyValue(account, "userId")));
    conditions.add(ConditionUtils.getCondition("groups", 
      "EQUALS", account.roleIds()));
    return getPagerTasks(pager, conditions, orders);
  }

  @EsbServiceMapping
  public String getProcessXml(@ServiceParam(name="processDefinitionId") String processDefinitionId)
  {
    ProcessDefinitionQuery p = this.processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionId(processDefinitionId);
    ProcessDefinition pd = (ProcessDefinition)p.singleResult();

    InputStream re = this.processEngine.getRepositoryService().getResourceAsStream(pd.getDeploymentId(), pd.getResourceName());
    try {
      return new String(FileCopyUtils.copyToByteArray(re), "UTF-8");
    }
    catch (IOException localIOException) {
    }
    return null;
  }

  @EsbServiceMapping
  public PagerRecords getPagerProcessInstances(Pager pager, Map<String, Object> params, @OrderCollection Collection<Order> orders)
  {
    ProcessInstanceQuery pQuery = this.processEngine.getRuntimeService().createProcessInstanceQuery();

    long totalCount = pQuery.count();
    int firstResult = pager.getStartIndex();
    int maxResults = pager.getPageSize();

    pQuery = (ProcessInstanceQuery)pQuery.orderByProcessInstanceId().desc();

    List processInstances = pQuery.includeProcessVariables().list();

    List<ProcessInstance> pageProcessInstances = processInstances.subList(firstResult, Math.min(firstResult + maxResults, processInstances.size()));
    List records = new ArrayList();

    for (ProcessInstance processInstance : pageProcessInstances) {
      records.add(convert2ProcessInstance(processInstance));
    }

    PagerRecords pagerRecords = new PagerRecords(records, (int)totalCount);
    return pagerRecords;
  }

  private Record convert2ProcessInstance(ProcessInstance processInstance) {
    Record record = new Record();

    String processDefinitionId = processInstance.getProcessDefinitionId();
    try
    {
      record.putAll(processInstance.getProcessVariables());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    record.put("processDefinitionId", processDefinitionId);
    record.put("flowName", processDefinitionId.substring(0, processDefinitionId.indexOf(":")));

    record.put("id", processInstance.getId());
    record.put("activityId", processInstance.getActivityId());

    record.put("businessKey", processInstance.getBusinessKey());

    record.put("suspended", Boolean.toString(processInstance.isSuspended()));
    record.put("ended", Boolean.toString(processInstance.isEnded()));
    return record;
  }

  @EsbServiceMapping
  public PagerRecords getPagerTasks(Pager pager, Map<String, Object> params, @OrderCollection Collection<Order> orders)
  {
    Collection conditions = new ArrayList();

    return getPagerTasks(pager, conditions, orders);
  }

  public PagerRecords getPagerTasks(Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    String paramPrefix = "params.";

    TaskService taskService = this.processEngine.getTaskService();

    List records = new ArrayList();

    TaskQuery taskQuery = taskService.createTaskQuery();

    for (Condition condition : conditions) {
      if (condition.getValue() == null) {
        continue;
      }

      String property = condition.getProperty();
      if ("user".equals(property))
      {
        taskQuery = taskQuery.taskCandidateUser(condition.getValue().toString());
      } else if ("groups".equals(property))
      {
        Object roles = condition.getValue();
        if ((roles != null) && (roles instanceof List))
          taskQuery = taskQuery.taskCandidateGroupIn((List)roles);
      }
      else if (property.startsWith(paramPrefix)) {
        taskQuery = taskQuery.processVariableValueEquals(property.substring(paramPrefix.length()), 
          condition.getValue());
      }
      property = null;
    }

    taskQuery = (TaskQuery)((TaskQuery)taskQuery.orderByTaskPriority().desc()).orderByTaskCreateTime().desc();

    long totalCount = taskQuery.count();
    int firstResult = pager.getStartIndex();
    int maxResults = pager.getPageSize();

    for (Task task : taskQuery.listPage(firstResult, maxResults)) {
      records.add(convert2TaskVO(task));
    }

    PagerRecords pagerRecords = new PagerRecords(records, Long.valueOf(totalCount).intValue());
    pagerRecords.setPager(pager);
    return pagerRecords;
  }

  private TaskVO convert2TaskVO(Task task)
  {
    TaskVO taskVO = new TaskVO(task);

    TaskFormData formData = this.processEngine.getFormService().getTaskFormData(task.getId());

    if ((formData != null) && (StringUtils.isNotEmpty(formData.getFormKey()))) {
      taskVO.setFormKey(formData.getFormKey());
    }

    List<IdentityLink> identityLinks = this.processEngine.getTaskService().getIdentityLinksForTask(task.getId());

    StringBuffer identities = new StringBuffer();

    Set users = new HashSet();
    Set groups = new HashSet();

    if (task.getAssignee() != null) {
      users.add(task.getAssignee());
    }

    for (IdentityLink identityLink : identityLinks) {
      if (identityLink.getUserId() != null) {
        users.add(identityLink.getUserId());
      }

      if (identityLink.getGroupId() != null) {
        groups.add(identityLink.getGroupId());
      }
    }
    identities.append("group").append(groups);
    identities.append(",users");
    identities.append(users);
    taskVO.setAssignee(identities.toString());

    Map params = this.processEngine.getRuntimeService().getVariables(task.getExecutionId());
    taskVO.setParams(params);
    return taskVO;
  }

  private ProcessDefinition getProcessDefinition(String processKey)
  {
    ProcessDefinitionQuery query = this.processEngine
      .getRepositoryService().createProcessDefinitionQuery()
      .processDefinitionKey(processKey);
    if (query.latestVersion().singleResult() == null) {
      throw new BusException("流程" + processKey + "未部署。");
    }
    return (ProcessDefinition)query.latestVersion().singleResult();
  }

  private FlowBusinessService createFlowBusinessService(String businessService)
  {
    if (StringUtils.isEmpty(businessService)) {
      return null;
    }

    FlowBusinessServiceFactoryBean factoryBean = new FlowBusinessServiceFactoryBean();

    factoryBean.setBusinessService(businessService);
    factoryBean.setBeanFactory(this.applicationContext);
    FlowBusinessService flowBusinessService = null;
    try {
      flowBusinessService = factoryBean.getObject();
    } catch (Exception e) {
      this.logger.warn(e.getMessage());
    }

    if (flowBusinessService == null) {
      flowBusinessService = this.defaultFlowBusinessService;
    }

    return flowBusinessService;
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
  {
    this.applicationContext = applicationContext;
  }
}