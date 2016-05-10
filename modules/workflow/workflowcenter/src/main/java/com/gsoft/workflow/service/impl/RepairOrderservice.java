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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.workflow.entity.WorkflowDomain;
import com.gsoft.framework.workflow.service.AccountFlowBusinessService;
import com.gsoft.workflow.entity.RepairOrder;
import com.gsoft.workflow.service.RepairOrderManager;

@Service("repairOrderservice")
@Transactional
public class RepairOrderservice implements AccountFlowBusinessService{
	@Autowired
	RepairOrderManager repairOrderManager;

	@Override
	public WorkflowDomain saveBusiness(String serviceName, Map<String, Object> map) {
		String name = (String) PropertyUtils.getSimplePropertyValue(map, "name");
		String status = (String) PropertyUtils.getSimplePropertyValue(map, "status");
		String content = (String) PropertyUtils.getSimplePropertyValue(map, "content");
		String describe = (String) PropertyUtils.getSimplePropertyValue(map, "describe");
		
		RepairOrder repairOrder = new RepairOrder();
		repairOrder.setName(name);
		repairOrder.setStatus(status);
		repairOrder.setContent(content);
		repairOrder.setDescribe(describe);
		repairOrder.setCreateUser(SecurityUtils.getPrincipal().toString());
		repairOrder.setCreateDate(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
		RepairOrder repairOrder_ = repairOrderManager.saveRepairOrder(repairOrder);
		MyWorkflowDomain myWorkflowDomain = new MyWorkflowDomain();
		myWorkflowDomain.setBusinessKey(repairOrder_.getId());
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
	public void updateBusiness(String serviceName, ProcessInstance processinstance,
			Task task, Map<String, Object> map) {
		String id = processinstance.getBusinessKey();
		RepairOrder repairOrder = repairOrderManager.getRepairOrder(id);
		String name = (String) PropertyUtils.getSimplePropertyValue(map, "name");
		String status = (String) PropertyUtils.getSimplePropertyValue(map, "status");
		String content = (String) PropertyUtils.getSimplePropertyValue(map, "content");
		String describe = (String) PropertyUtils.getSimplePropertyValue(map, "describe");
		
		String price = (String) PropertyUtils.getSimplePropertyValue(map, "price");
		String appraise = (String) PropertyUtils.getSimplePropertyValue(map, "appraise");
		
		repairOrder.setName(name);
		repairOrder.setStatus(status);
		repairOrder.setContent(content);
		repairOrder.setDescribe(describe);
		repairOrder.setPrice(StringUtils.isEmpty(price)?"0":price);
		repairOrder.setAppraise(appraise==null?"":appraise);
		
		//根据不同状态某些字段不同
		if("01".equals(status)){//待提交（新建-修改）
			
		}else if("02".equals(status)){//提交待受理
			
		}else if("03".equals(status)){//受理待派工
			
		}else if("04".equals(status)){//派工待接单
			
		}else if("05".equals(status)){//接单待维修
			
		}else if("06".equals(status)){//维修待评价
			
		}else if("07".equals(status)){//关闭
			
		}
		repairOrderManager.saveRepairOrder(repairOrder);
	}

	@Override
	public Map<String, Object> getCustomAccountProperties() {
		// TODO Auto-generated method stub
		//将属性添加到流程数据中
		return null;
	}

}
