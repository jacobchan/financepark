package com.gsoft.framework.workflow.esb;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.data.ReqContext;
import com.gsoft.framework.esb.data.ResContext;
import com.gsoft.framework.esb.service.EsbExporterCaller;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.workflow.entity.TaskForm;
import com.gsoft.framework.workflow.service.FlowRunManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EsbFlowRunManager
{

  @Resource(name="commonEsbExporterCaller")
  private EsbExporterCaller esbExporterCaller;

  public Record getStartFormData(String processKey)
    throws BusException
  {
    ReqContext req = new ReqContext();
    req.add("processKey", processKey);
    ResContext res = this.esbExporterCaller.callEsbService("getStartFormData", req);
    if (res.getRecord() instanceof Record) {
      return (Record)res.getRecord();
    }
    return null;
  }

  public TaskForm getTaskFormData(String taskId)
    throws BusException
  {
    ReqContext req = new ReqContext();
    req.add("taskId", taskId);
    ResContext res = this.esbExporterCaller.callEsbService("getTaskFormData", req);
    if (res.getRecord() instanceof TaskForm) {
      return (TaskForm)res.getRecord();
    }
    return null;
  }

  public String start(String processDefinitionId, String initiator, Map<String, Object> params)
    throws BusException
  {
    ReqContext req = new ReqContext();

    for (Map.Entry entry : params.entrySet()) {
      if ((entry.getValue().getClass().isArray()) || 
        (List.class.isAssignableFrom(entry.getValue().getClass()))) {
        continue;
      }
      req.add(entry.getKey(), entry.getValue());
    }

    req.add("initiator", initiator);
    if (!req.containsKey(processDefinitionId)) {
      req.add("processDefinitionId", processDefinitionId);
    }

    this.esbExporterCaller.callEsbService("startWorkflow", req);

    return "";
  }

  public PagerRecords getPagerTasks(Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    return null;
  }

  public PagerRecords getUserPagerTasks(String userId, Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    return null;
  }

  public PagerRecords getGroupPagerTasks(AccountPrincipal account, Pager pager, Collection<Condition> conditions, Collection<Order> orders)
    throws BusException
  {
    return null;
  }

  public void completeTask(String taskId, Map<String, Object> taskVariables)
    throws BusException
  {
    ReqContext req = new ReqContext();
    req.putAll(taskVariables);
    req.add("taskId", taskId);
    this.esbExporterCaller.callEsbService("completeTask", req);
  }

  public String getProcessXml(String processDefinitionId)
    throws BusException
  {
    ReqContext req = new ReqContext();
    req.add("processDefinitionId", processDefinitionId);
    ResContext res = this.esbExporterCaller.callEsbService("getProcessXml", req);

    if (res.getRecord() instanceof Record) {
      Object html = ((Record)res.getRecord()).get("html");
      return (html == null) ? null : html.toString();
    }
    return null;
  }
}