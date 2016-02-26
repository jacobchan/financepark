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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PolicyManager.entity.PolicyApply;
import com.manage.PolicyManager.dao.PolicyApplyDao;
import com.manage.PolicyManager.service.PolicyApplyManager;

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
    @EsbServiceMapping
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
    	NmIssuenews nmIssuenews = o.getNmIssuenews() ;//得到政策新闻
    	if(nmIssuenews != null){
    		String nmIssuenewsId = nmIssuenews.getPolicyId() ;//得到政策新闻ID
    		nmIssuenews = nmIssuenewsManager.getNmIssuenews(nmIssuenewsId) ;//得到政策新闻对象实体
    		NmIssuetype nmIssuetype = nmIssuenews.getPolicyType();//得到政策类型
    		if(nmIssuetype != null){
    			String nmIssuetypeId = nmIssuetype.getIssueTypeId() ;//得到政策类型的ID
    			NmIssueflow nmIssueflow = nmIssueflowManager.getStartFlow(nmIssuetypeId) ;//通过政策类型ID得到初始流程
    			o.setNmIssueflow(nmIssueflow);
    		}
    	}
    	return policyApplyDao.save(o);
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
    	}else{
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
				EnterbusinessmanagerRz enterBusiness = enterpriseEmployees.getEmployeesComId() ;
				if(enterBusiness != null){
					return enterBusiness ;
				}
			}
		}
		return null;
	}
}
