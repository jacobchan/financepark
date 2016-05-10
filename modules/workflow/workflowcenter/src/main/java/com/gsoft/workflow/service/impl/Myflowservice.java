package com.gsoft.workflow.service.impl;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.workflow.entity.WorkflowDomain;
import com.gsoft.framework.workflow.service.AccountFlowBusinessService;
import com.gsoft.framework.workflow.service.FlowBusinessService;
import com.gsoft.workflow.entity.Flowdata;
import com.gsoft.workflow.service.FlowdataManager;

@Service("myflowservice")
@Transactional
public class Myflowservice implements AccountFlowBusinessService{
	@Autowired
	FlowdataManager flowdataManager;
	@Autowired
	@Qualifier("flowBusinessService")
	FlowBusinessService flowBusinessService;

	@Override
	public WorkflowDomain saveBusiness(String s, Map<String, Object> map) {
		System.out.println("--------saveBusiness--------");
		System.out.println("-----------sss:"+s);
		System.out.println("遍历map：");
		for(Map.Entry<String, Object> entry:map.entrySet()){
			System.out.print("key:"+entry.getKey()+",");
			System.out.println("value:"+entry.getValue());
		}
		
		String name = (String) map.get("name");
		String status = (String) map.get("status");
		Flowdata flowdata = new Flowdata();
		flowdata.setName(name);
		flowdata.setStatus(status);
		Flowdata flowdata_ = flowdataManager.saveFlowdata(flowdata);
		String businessKey = flowdata_.getId();//businessKey
//		map.put("businessKey", businessKey);
		MyWorkflowDomain myWorkflowDomain = new MyWorkflowDomain();
		myWorkflowDomain.setBusinessKey(businessKey);
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
		System.out.println("--------updateBusiness--------");
//		String businessKey = (String) map.get("businessKey");
		String businessKey = processinstance.getBusinessKey();
		Flowdata flowdata = flowdataManager.getFlowdata(businessKey);
		String name = (String) map.get("name");
		String status = (String) map.get("status");
		flowdata.setName(name);
		flowdata.setStatus(status);
		flowdataManager.saveFlowdata(flowdata);
	}

	@Override
	public Map<String, Object> getCustomAccountProperties() {
		// TODO Auto-generated method stub
		System.out.println("--------getCustomAccountProperties--------");
		return null;
	}

}
