package com.gsoft.workflow.service.impl;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.workflow.entity.WorkflowDomain;
import com.gsoft.framework.workflow.service.AccountFlowBusinessService;
import com.gsoft.workflow.entity.FlowOrder;
import com.gsoft.workflow.service.FlowOrderManager;

@Service("flowOrderservice")
@Transactional
public class FlowOrderservice implements AccountFlowBusinessService{
	@Autowired
	FlowOrderManager flowOrderManager;

	@Override
	public WorkflowDomain saveBusiness(String s, Map<String, Object> map) {
		String orderName = (String) PropertyUtils.getSimplePropertyValue(map, "orderName");
		String status = (String) PropertyUtils.getSimplePropertyValue(map, "status");
		String orderContent = (String) PropertyUtils.getSimplePropertyValue(map, "orderContent");
		FlowOrder flowOrder = new FlowOrder();
		flowOrder.setOrderName(orderName);
		flowOrder.setStatus(status);
		flowOrder.setOrderContent(orderContent);
		String principal = SecurityUtils.getPrincipal().toString();
		flowOrder.setCreateUser(principal);
		flowOrder.setCreateDate(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
		
		FlowOrder flowOrder_ = flowOrderManager.saveFlowOrder(flowOrder);
		MyWorkflowDomain myWorkflowDomain = new MyWorkflowDomain();
		myWorkflowDomain.setBusinessKey(flowOrder_.getId());
		return myWorkflowDomain;
	}
	
	  private static class MyWorkflowDomain
	    implements WorkflowDomain
	  {
	    private static final long serialVersionUID = 3414507418651586611L;
	    private String businessKey;

	    public void setBusinessKey(String businessKey)
	    {
	      this.businessKey = businessKey;
	    }

	    public String getBusinessKey()
	    {
	      return this.businessKey;
	    }
	  }

	@Override
	public void saveProcessInstanceId(String s, ProcessInstance processinstance) {
		System.out.println("--------saveProcessInstanceId--------");
		// TODO Auto-generated method stub
	}

	@Override
	public void updateBusiness(String s, ProcessInstance processinstance,
			Task task, Map<String, Object> map) {
		String id = processinstance.getBusinessKey();
		FlowOrder flowOrder = flowOrderManager.getFlowOrder(id);
		String orderName = (String) PropertyUtils.getSimplePropertyValue(map, "orderName");
		String status = (String) PropertyUtils.getSimplePropertyValue(map, "status");
		String orderContent = (String) PropertyUtils.getSimplePropertyValue(map, "orderContent");
		flowOrder.setOrderName(orderName);
		flowOrder.setStatus(status);
		flowOrder.setOrderContent(orderContent);
		
		//根据不同状态某些字段不同
		if("01".equals(status)){//待提交（新建-修改）
			
		}else if("02".equals(status)){//提交待受理
			
		}else if("03".equals(status)){//受理待派工
			
		}else if("04".equals(status)){//派工待接单
			
		}else if("05".equals(status)){//接单待处理
			
		}else if("06".equals(status)){//流程结束
			
		}

	}

	@Override
	public Map<String, Object> getCustomAccountProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}
