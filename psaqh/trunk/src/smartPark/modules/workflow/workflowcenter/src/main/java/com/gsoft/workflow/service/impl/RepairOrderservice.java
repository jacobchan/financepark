package com.gsoft.workflow.service.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.gsoft.framework.workflow.entity.WorkflowDomain;
import com.gsoft.framework.workflow.service.AccountFlowBusinessService;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.workflow.entity.RepairOrder;
import com.gsoft.workflow.service.RepairOrderManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;

@Service("repairOrderservice")
@Transactional
public class RepairOrderservice implements AccountFlowBusinessService{
	@Autowired
	RepairOrderManager repairOrderManager;
	@Autowired
	PropertyservicemanagerBxManager propertyservicemanagerBxManager;
	@Autowired
	PropertyservicemanagerTsManager propertyservicemanagerTsManager;
	@Autowired
	UserManager userManager;

	@Override
	public WorkflowDomain saveBusiness(String serviceName, Map<String, Object> map) {
		Object object = SecurityUtils.getSubject().getPrincipal();
		String userName = "";
		String userId = "";
		if(object instanceof MemberInformation){
			MemberInformation mem = (MemberInformation) object;
			userName = mem.getMemberName();
			userId = mem.getMemberId();
		}else if(object instanceof User){
			User user = (User)object;
			userName = user.getUserCaption();
			userId = user.getUserId();
		}else{
			throw new BusException("用户不存在或会话已失效！");
		}
		String bxComp = (String) PropertyUtils.getSimplePropertyValue(map, "bxComp");
		String bxType = (String) PropertyUtils.getSimplePropertyValue(map, "bxType");
		String bxRemark = (String) PropertyUtils.getSimplePropertyValue(map, "bxRemark");
		String bxAddress = (String) PropertyUtils.getSimplePropertyValue(map, "bxAddress");
		String flowProcessId = (String) PropertyUtils.getSimplePropertyValue(map, "flowProcessId");
		String bxFujian = (String) PropertyUtils.getSimplePropertyValue(map, "bxFujian");
		String bxCode = (String) PropertyUtils.getSimplePropertyValue(map, "bxCode");
		String bxStatus = (String) PropertyUtils.getSimplePropertyValue(map, "bxStatus");
		PropertyservicemanagerBx psbx = new PropertyservicemanagerBx();
//		psbx.setMemberId("4028808253f3f3e00153f417624e0022");
		psbx.setBxComp(bxComp);
		psbx.setBxType(bxType);
		psbx.setBxRemark(bxRemark);
		psbx.setBxAddress(bxAddress);
		psbx.setBxFujian(bxFujian);
		psbx.setBxCode(bxCode);
		psbx.setCreateUser(userId);
		psbx.setBxStatus(bxStatus);
		psbx = propertyservicemanagerBxManager.savaPsBx(psbx);
			
		RepairOrder repairOrder = new RepairOrder();
		repairOrder.setFlowType("01");
		repairOrder.setFlowProcessId(flowProcessId);
		repairOrder.setPropertyservicemanagerBx(psbx);
		repairOrder.setCreateUser(userId);
		repairOrder.setCreateUsercaption(userName);
		repairOrder.setCreateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
		repairOrder.setUpdateUser(userId);
		repairOrder.setUpdateUsercaption(userName);
		repairOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
		repairOrderManager.saveRepairOrder(repairOrder);
//		MyWorkflowDomain myWorkflowDomain = new MyWorkflowDomain();
//		myWorkflowDomain.setBusinessKey(repairOrder_.getFlowId());
		return psbx;
	}
	
//    private static class MyWorkflowDomain implements WorkflowDomain{
//	    private static final long serialVersionUID = 3414507418651586611L;
//	    private String businessKey;
//	
//	    public void setBusinessKey(String businessKey){
//	      this.businessKey = businessKey;
//	    }
//	
//	    public String getBusinessKey(){
//	      return this.businessKey;
//	    }
//    }

	@Override
	public void saveProcessInstanceId(String s, ProcessInstance processinstance) {
		System.out.println("--------saveProcessInstanceId--------");
		// TODO Auto-generated method stub
	}

	@Override
	public void updateBusiness(String serviceName, ProcessInstance processinstance,
			Task task, Map<String, Object> map) {
		String bxType = (String) PropertyUtils.getSimplePropertyValue(map, "bxType");
		String bxRemark = (String) PropertyUtils.getSimplePropertyValue(map, "bxRemark");
		String bxAddress = (String) PropertyUtils.getSimplePropertyValue(map, "bxAddress");
		String bxCode = (String) PropertyUtils.getSimplePropertyValue(map, "bxCode");
		String bxStatus = (String) PropertyUtils.getSimplePropertyValue(map, "bxStatus");
		String flowProcessId = (String) PropertyUtils.getSimplePropertyValue(map, "flowProcessId");
		
		Object object = SecurityUtils.getSubject().getPrincipal();
		String userId = "";
		String userName = "";
		if(object instanceof User){
			User user = (User)object;
			userName= user.getUserCaption();
			userId = user.getUserId();
		}else{
			throw new BusException("用户不存在或会话已失效！");
		}
		String key = task.getTaskDefinitionKey();
		if(key!=null&&!key.equals("")){
			RepairOrder repairOrder = new RepairOrder();
			String bxId = processinstance.getBusinessKey();
			PropertyservicemanagerBx psbx = propertyservicemanagerBxManager.getPropertyservicemanagerBx(bxId);
			if(key.equals("dispatching")){//待派工
				String flowResultPg = (String) PropertyUtils.getSimplePropertyValue(map, "flowResultPg");
				String flowSuggestPg = (String) PropertyUtils.getSimplePropertyValue(map, "flowSuggestPg");
				String flowPersonId = (String) PropertyUtils.getSimplePropertyValue(map, "flowPersonId");
				if("1".equals(flowResultPg)){//拒绝派工
					psbx.setBxStatus("99");
					
					repairOrder.setFlowType("99");
				}else{
					psbx.setBxStatus("02");//待接单
					
					repairOrder.setFlowType("02");
					repairOrder.setFlowPersonId(flowPersonId);
					User user = userManager.getUser(flowPersonId);
					//生成派工记录
					PropertyservicemanagerTs pts = new PropertyservicemanagerTs();
					pts.setCreateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
					pts.setCreateUser(userId);
					pts.setPropertyservicemanagerBx(psbx);
					pts.setTsName(user.getUserCaption());
					pts.setTsStatus("00");
					pts.setTsTelephone("123456");
					pts.setUpdateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
					pts.setUpdateUser(userId);
					propertyservicemanagerTsManager.savePts(pts);
					
				}
				psbx.setUpdateUser(userId);
				propertyservicemanagerBxManager.savaPsBx(psbx);
				repairOrder.setFlowResultPg(flowResultPg);
				repairOrder.setFlowSuggestPg(flowSuggestPg);
				repairOrder.setFlowProcessId(flowProcessId);
			}else if(key.equals("accept")){//待接单
				String flowResultJg = (String) PropertyUtils.getSimplePropertyValue(map, "flowResultJg");
				String flowSuggestJg = (String) PropertyUtils.getSimplePropertyValue(map, "flowSuggestJg");
				//根据物业报修ID查询最新一条维修记录
				PropertyservicemanagerTs pts= propertyservicemanagerTsManager.getPropertyservicemanagerTssBybxId(bxId);
				if("1".equals(flowResultJg)){//拒绝接单
					psbx.setBxStatus("00");//待派工
					
					repairOrder.setFlowType("00");
					
					pts.setTsStatus("02");//已拒单
				}else{
					psbx.setBxStatus("03");//已派工
					
					repairOrder.setFlowType("03");
					
					pts.setTsStatus("01");//已接单
				}
				pts.setUpdateUser(userId);
				pts.setUpdateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
				propertyservicemanagerTsManager.savePts(pts);
				
				psbx.setUpdateUser(userId);
				propertyservicemanagerBxManager.savaPsBx(psbx);
				repairOrder.setFlowSuggestJg(flowSuggestJg);
				repairOrder.setFlowResultJg(flowResultJg);
				repairOrder.setFlowProcessId(flowProcessId);
				
			}else if(key.equals("mainRecord")){//待填报维修记录
				psbx.setBxStatus("04");//已完工
				psbx.setUpdateUser(userId);
				propertyservicemanagerBxManager.savaPsBx(psbx);
				repairOrder.setFlowType("04");
				
			}
			repairOrder.setPropertyservicemanagerBx(psbx);
			repairOrder.setCreateUser(userId);
			repairOrder.setCreateUsercaption(userName);
			repairOrder.setCreateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
			repairOrder.setUpdateUser(userId);
			repairOrder.setUpdateUsercaption(userName);
			repairOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd hh:mm:ss"));
			repairOrderManager.saveRepairOrder(repairOrder);
		}
//		String id = processinstance.getBusinessKey();
//		RepairOrder repairOrder = repairOrderManager.getRepairOrder(id);
////		String name = (String) PropertyUtils.getSimplePropertyValue(map, "name");
//		String status = (String) PropertyUtils.getSimplePropertyValue(map, "status");
////		String content = (String) PropertyUtils.getSimplePropertyValue(map, "content");
////		String describe = (String) PropertyUtils.getSimplePropertyValue(map, "describe");
////		
////		String price = (String) PropertyUtils.getSimplePropertyValue(map, "price");
////		String appraise = (String) PropertyUtils.getSimplePropertyValue(map, "appraise");
//		
////		repairOrder.setName(name);
////		repairOrder.setStatus(status);
////		repairOrder.setContent(content);
////		repairOrder.setDescribe(describe);
////		repairOrder.setPrice(StringUtils.isEmpty(price)?"0":price);
////		repairOrder.setAppraise(appraise==null?"":appraise);
////		
//		//根据不同状态某些字段不同
//		if("01".equals(status)){//待提交（新建-修改）
//			
//		}else if("02".equals(status)){//提交待受理
//			
//		}else if("03".equals(status)){//受理待派工
//			
//		}else if("04".equals(status)){//派工待接单
//			
//		}else if("05".equals(status)){//接单待维修
//			
//		}else if("06".equals(status)){//维修待评价
//			
//		}else if("07".equals(status)){//关闭
//			
//		}
//		repairOrderManager.saveRepairOrder(repairOrder);
	}

	@Override
	public Map<String, Object> getCustomAccountProperties() {
		// TODO Auto-generated method stub
		//将属性添加到流程数据中
		return null;
	}

}
