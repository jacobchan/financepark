/**
 * 代码声明
 */
package com.manage.PolicyManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.service.NmIssueflowManager;
import com.common.NewsManager.service.NmIssuenewsManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PolicyManager.entity.PolicyApply;
import com.manage.PolicyManager.dao.PolicyApplyDao;
import com.manage.PolicyManager.service.PolicyApplyManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerOc;

@Service("policyApplyManager")
@Transactional
public class PolicyApplyManagerImpl extends BaseManagerImpl implements PolicyApplyManager{
	@Autowired
	private PolicyApplyDao policyApplyDao;
	@Autowired
	private MemberInformationManager memberInformationManager ;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager ;
	@Autowired
	private NmIssueflowManager nmIssueflowManager ;
	@Autowired
	private NmIssuenewsManager nmIssuenewsManager ;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PolicyApply> getPolicyApplys() throws BusException{
    	return policyApplyDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PolicyApply> getPolicyApplys(
    	@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return policyApplyDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PolicyApply getPolicyApply(@ServiceParam(name="policyApplyId") String id)  throws BusException{
    	return policyApplyDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPolicyApplys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = policyApplyDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     * @param o 政策申请对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="createUser",pubProperty="userId")})
    public PolicyApply savePolicyApply(PolicyApply o) throws BusException{
    	
    	/*String policyApplyId = o.getPolicyApplyId();
    	boolean isUpdate = StringUtils.isNotEmpty(policyApplyId);
    	//若isUpdate不为空，表示存在该对象，做修改操作
    	if(isUpdate){
    		if(o.getPolicyApplyStatus().equals("1")){//如果当前状态是1，则将其设置为2
    			o.setPolicyApplyStatus("2");
    		}
    	}else{//isUpdate为空，表示不存在该对象，做新增操作
    		
    	}*/
    	String enName = o.getPolicyApplyConpanyName() ;//得到企业名称
    	if(StringUtils.isEmpty(enName)){//如果得到的企业名称为空
    		throw new BusException("非企业会员不能提交申请") ;
    	}
    	PolicyApply policyApply = null ;
    	NmIssuenews nmIssuenews = o.getNmIssuenews() ;//得到政策新闻
    	if(nmIssuenews != null){
    		String nmIssuenewsId = nmIssuenews.getPolicyId() ;//得到政策新闻ID
    		nmIssuenews = nmIssuenewsManager.getNmIssuenews(nmIssuenewsId) ;//得到政策新闻对象实体
    		NmIssuetype nmIssuetype = nmIssuenews.getPolicyType();//得到政策类型
    		if(nmIssuetype != null){
    			String nmIssuetypeId = nmIssuetype.getIssueTypeId() ;//得到政策类型的ID
    			NmIssueflow nmIssueflow = nmIssueflowManager.getStartFlow(nmIssuetypeId) ;//通过政策类型ID得到初始流程
    			o.setNmIssueflow(nmIssueflow);
    			policyApply = policyApplyDao.save(o) ;
    			try {
    				HttpSenderMsg.sendMsg(policyApply.getPolicyApplyContactTel(), "尊敬的 "+policyApply.getPolicyApplyContactPeople()
    						+" 用户，您已提交 "+policyApply.getNmIssuenews().getPolicyCaption()+" 的申请，当前处理流程为："+nmIssueflow.getIssueFlowCStatus()+",请耐心等待！");
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return policyApply;
    }
    
    /**
     * 更新新政策申请状态
     * @param policyApplyId，政策申请记录ID
     * @throws BusException
     */
    @EsbServiceMapping
    public void updatePolicyApply(@ServiceParam(name="id") String policyApplyId) throws BusException{
    	PolicyApply policyApply = policyApplyDao.get(policyApplyId) ;//得到政策记录对象
    	String nmIssuetypeId =  policyApply.getNmIssuenews().getPolicyType().getIssueTypeId() ;//得到新闻类型ID
    	String issueFlowId = policyApply.getNmIssueflow().getIssueFlowId() ;//得到当前流程状态ID
    	String currentStatus = policyApply.getNmIssueflow().getIssueFlowCStatus() ;//得到当前流程状态
    	boolean flag = nmIssueflowManager.isFinally(nmIssuetypeId, currentStatus) ;//判断当前流程是否为最后一个
    	if(! flag){
    		NmIssueflow temp = nmIssueflowManager.getNextFlow(nmIssuetypeId, issueFlowId) ;
    		policyApply.setNmIssueflow(temp);
    		try {
    			HttpSenderMsg.sendMsg(policyApply.getPolicyApplyContactTel(), "尊敬的 "+policyApply.getPolicyApplyContactPeople()
						+"用户，您申请的"+policyApply.getNmIssuenews().getPolicyCaption()+"的当前处理流程为："+temp.getIssueFlowCStatus()+",请耐心等待！");
			} catch (Exception e) {
				e.printStackTrace();
			}

    	}else{
    		try {
    			HttpSenderMsg.sendMsg(policyApply.getPolicyApplyContactTel(), "尊敬的 "+policyApply.getPolicyApplyContactPeople()
						+"用户，您已成功申请"+policyApply.getNmIssuenews().getPolicyCaption()+",谢谢您的支持！");
			} catch (Exception e) {
				e.printStackTrace();
			}
    		throw new BusException("当前状态已经是最终状态！") ;
    	}
    	policyApplyDao.save(policyApply) ;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePolicyApply(@ServiceParam(name="policyApplyId") String id) throws BusException{
    	policyApplyDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePolicyApplys(@ServiceParam(name="policyApplyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePolicyApply(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPolicyApply(@ServiceParam(name="policyApplyId") String id)  throws BusException{
		return policyApplyDao.exists(id);
	}
    
    public boolean exsitPolicyApply(String propertyName,Object value) throws BusException{
		return policyApplyDao.exists(propertyName,value);
	}
    
    /**
	 * 通过会员id查询到相应的企业名称
	 * @param id 会员id
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public EnterbusinessmanagerRz findEnterpriseByMemberId(@ServiceParam(name="memberId") String id)
			throws BusException {
		if(StringUtils.isNotEmpty(id)){
			MemberInformation member = memberInformationManager.getMemberInformation(id) ;//根据会员id得到会员对象
			if(member != null){
				//通过会员对象得到当前的企业员工
				EnterpriseEmployees enterpriseEmployees = enterpriseEmployeesManager.getEnterpriseEmployeesByMember(member) ;
				//得到企业员工对应的EnterbusinessmanagerRz 对象
				if(enterpriseEmployees != null){
					EnterbusinessmanagerRz enterBusiness = enterpriseEmployees.getRz();
					if(enterBusiness != null){
						return enterBusiness ;
					}
				}
			}
		}
		return null;
	}
	/**
     * 获取当前登录用户申请的政策
     * @return
     * @throws BusException
     */
    
    	@EsbServiceMapping(pubConditions = {@PubCondition(property = "member.memberId", pubProperty = "userId")})
    	public List<PolicyApply> getPolicyApplyListByLoginUser(PolicyApply o)
       			throws BusException {
       		//获取当前登录用户id
       		String id = o.getMember().getMemberId();
       		if(id!=null){
       	    	//获取当前用户参加活动的list  	    	  	    	  	    	
       	    	 List<PolicyApply> list=policyApplyDao.getList("member.memberId", id);
       	    	 if(list.size()>0){
       	    		 return list;
       	    	 }else{
       	    		 return null;
       	    	 }
       		}else{
       			return null;
       		}
       		
       	}
    
    	 /**
         * 修改政策流程状态
         * @return
         * @throws BusException
         */
       @EsbServiceMapping
    public PolicyApply updatePolicyApplyStatus(
        	@ServiceParam(name="policyApplyId") String policyApplyId) throws BusException{   	
       PolicyApply p = policyApplyDao.get(policyApplyId);  
       String applyStatus=p.getPolicyApplyStatus();
       if(applyStatus.equals("1")){
    	   p.setPolicyApplyStatus("0");
    	   p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	   return policyApplyDao.save(p);
       }  else{
    	   
    	   throw new BusException("只有在未办理成功时才能取消"); 
       }
	    
       
        }				
	}

