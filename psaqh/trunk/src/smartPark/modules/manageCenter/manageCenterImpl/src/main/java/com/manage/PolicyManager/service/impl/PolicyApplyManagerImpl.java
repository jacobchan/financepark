/**
 * 代码声明
 */
package com.manage.PolicyManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.service.NmIssueflowManager;
import com.common.NewsManager.service.NmIssuenewsManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PolicyManager.dao.PolicyApplyDao;
import com.manage.PolicyManager.entity.PolicyApply;
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
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
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
    	/*后台用于判断是否为企业会员*/
    	String enName = o.getPolicyApplyConpanyName() ;//得到企业名称
    	if(StringUtils.isEmpty(enName)){//如果得到的企业名称为空
    		throw new BusException("非企业会员不能提交申请") ;
    	}
    	
    	String policyApplyId = o.getPolicyApplyId();
    	boolean isUpdate = StringUtils.isNotEmpty(policyApplyId);
    	//若isUpdate不为空，表示存在该对象，做修改操作
    	if(isUpdate){
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return policyApplyDao.save(o) ;
    	}else{//isUpdate为空，表示不存在该对象，做新增操作
    		String memberId = o.getCreateUser() ;
        	MemberInformation member = null ;
        	if(StringUtils.isEmpty(memberId)){
        		member = memberInformationManager.getMemberInformation(o.getMember().getMemberId()) ;//后台调用
        	}else{
        		//前端调用
        		member = memberInformationManager.getMemberInformation(o.getCreateUser()) ;
        		EnterpriseEmployees e = new EnterpriseEmployees() ;
        		e.setMember(member);
        		EnterpriseEmployees enterpriseEmployees = enterpriseEmployeesManager.getEnterEmployforpage(e) ;//判断当前用户是否为企业会员
        		if(enterpriseEmployees == null){
        			throw new BusException("非企业会员不能提交申请！") ;
        		}
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
        			o.setApplyCode(BizCodeUtil.getInstance().getBizCodeDate("ZCSQ"));
        			o.setNmIssueflow(nmIssueflow);
        			o.setMember(member);
        			o.setPolicyApplyStatus("01");//01为申请中
        			o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        			policyApply = policyApplyDao.save(o) ;
        			//构建替换模板参数对应的map
        			Map<String, String> replaceMap = new HashMap<String, String>();
        			replaceMap.put("#user", policyApply.getPolicyApplyContactPeople());
        			replaceMap.put("#policyCaption", policyApply.getNmIssuenews().getPolicyCaption());
        			replaceMap.put("#issueFlow", nmIssueflow.getIssueFlowCStatus());
        			//构建消息内容数据
        			McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0401", replaceMap);
        			//发送消息,给会员
        			mcMsgdatasManager.sendToUser(msgData, member.getMemberId());
        		}
        	}
        	return policyApply;
    	}
    }
    
    /**
     * 更新新政策流程状态
     * @param policyApplyId，政策申请记录ID
     * @throws BusException
     */
    @EsbServiceMapping
    public void updatePolicyApply(@ServiceParam(name="id") String policyApplyId) throws BusException{
    	PolicyApply policyApply = policyApplyDao.get(policyApplyId) ;//得到政策记录对象
    	String nmIssuetypeId =  policyApply.getNmIssuenews().getPolicyType().getIssueTypeId() ;//得到新闻类型ID
    	String issueFlowId = policyApply.getNmIssueflow().getIssueFlowId() ;//得到当前流程状态ID
    	boolean flag = this.isFinally(policyApplyId) ;//判断当前流程是否为最后一个
    	if(! flag){
    		NmIssueflow temp = nmIssueflowManager.getNextFlow(nmIssuetypeId, issueFlowId) ;
    		policyApply.setNmIssueflow(temp);
    		policyApplyDao.save(policyApply) ;
    		//构建替换模板参数对应的map
			Map<String, String> replaceMap = new HashMap<String, String>();
			replaceMap.put("#user", policyApply.getPolicyApplyContactPeople());
			replaceMap.put("#policyCaption", policyApply.getNmIssuenews().getPolicyCaption());
			replaceMap.put("#issueFlow", temp.getIssueFlowCStatus());
			//构建消息内容数据
			McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0402", replaceMap);
			//发送消息,给会员
			mcMsgdatasManager.sendToUser(msgData, policyApply.getCreateUser());

    	}else{
    		//构建替换模板参数对应的map
			Map<String, String> replaceMap = new HashMap<String, String>();
			replaceMap.put("#user", policyApply.getPolicyApplyContactPeople());
			replaceMap.put("#policyCaption", policyApply.getNmIssuenews().getPolicyCaption());
			//构建消息内容数据
			McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0403", replaceMap);
			//发送消息,给会员
			mcMsgdatasManager.sendToUser(msgData, policyApply.getCreateUser());
    	}
    }
    
    /**
     * 判断当前传过来的政策申请ID对应的流程是否为最终流程，是则返回true，否则返回false
     * @param policyApplyId 政策申请ID
     * @return
     */
    private boolean isFinally(String policyApplyId){
    	PolicyApply policyApply = policyApplyDao.get(policyApplyId) ;//得到政策记录对象
    	String nmIssuetypeId =  policyApply.getNmIssuenews().getPolicyType().getIssueTypeId() ;//得到新闻类型ID
    	String currentStatus = policyApply.getNmIssueflow().getIssueFlowCStatus() ;//得到当前流程状态
    	boolean flag = nmIssueflowManager.isFinally(nmIssuetypeId, currentStatus) ;//判断当前流程是否为最后一个
    	if(flag){
    		policyApply.setPolicyApplyStatus("02");//02为申请成功
    		policyApplyDao.save(policyApply) ;
    	}
    	return flag ;
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
         * 修改政策申请状态
         * @return
         * @throws BusException
         */
    @EsbServiceMapping
    public PolicyApply updatePolicyApplyStatus(@ServiceParam(name="id") String policyApplyId) throws BusException{   	
	    PolicyApply p = policyApplyDao.get(policyApplyId); 
	    String status = p.getPolicyApplyStatus() ;
	    if("01".equals(status)){
	    	p.setPolicyApplyStatus("03");//3为申请失败
	    	p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
	    	PolicyApply policy = policyApplyDao.save(p);
	    	//构建替换模板参数对应的map
			Map<String, String> replaceMap = new HashMap<String, String>();
			replaceMap.put("#user", p.getPolicyApplyContactPeople());
			replaceMap.put("#policyCaption", p.getNmIssuenews().getPolicyCaption());
			//构建消息内容数据
			McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0404", replaceMap);
			//发送消息,给会员
			mcMsgdatasManager.sendToUser(msgData, p.getCreateUser());
	    	return policy ;
	    }else if("02".equals(status)){
	    	throw new BusException("当前状态无法拒绝申请！") ;
	    }else if("03".equals(status)){
	    	throw new BusException("当前状态已经为拒绝申请！") ;
	    }else{
	    	throw new BusException("已取消的申请无法拒绝！") ;
	    }
    }
    
	 /**
     * 取消政策申请，前端调用
     * @param policyApplyId，政策申请记录ID
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public PolicyApply cancelApply(@ServiceParam(name="policyApplyId") String policyApplyId) throws BusException {
		 PolicyApply p = policyApplyDao.get(policyApplyId); 
		 String status = p.getPolicyApplyStatus() ;//得到政策申请状态
		 if("01".equals(status)){//若当前状态为申请中
		    	p.setPolicyApplyStatus("04");//04为已取消，相当于前端取消申请
		    	p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	PolicyApply policy = policyApplyDao.save(p);
		    	//构建替换模板参数对应的map
				Map<String, String> replaceMap = new HashMap<String, String>();
				replaceMap.put("#user", p.getPolicyApplyContactPeople());
				replaceMap.put("#policyCaption", p.getNmIssuenews().getPolicyCaption());
				//构建消息内容数据
				McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0405", replaceMap);
				//发送消息,给会员
				mcMsgdatasManager.sendToUser(msgData, p.getCreateUser());
		    	return policy ;
		 }else{
		    	throw new BusException("当前状态无法取消申请！") ;
		 }
	}
    /**
	 * 根据当前用户分页查询
	 * @return 分页对象
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerPolicyApply(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)
			throws BusException {
    	PagerRecords pagerRecords = policyApplyDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    
    /**
	 * 获取整个数据的totalCount
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
			@ConditionCollection(domainClazz=PolicyApply.class) Collection<Condition> conditions)  throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		List<PolicyApply> policyApplyList = this.getPolicyApplys(conditions, null);
		Record record = new Record();
		record.put("totalCount", policyApplyList.size());
		recordList.add(record);
		return recordList;
	}
}

