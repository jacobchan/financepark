/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.NewsManager.dao.NmIssueflowDao;
import com.common.NewsManager.dao.NmIssuenewsDao;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.service.NmIssueflowManager;
import com.common.NewsManager.service.NmIssuenewsManager;
import com.common.NewsManager.service.NmIssuetypeManager;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;

@Service("nmIssuenewsManager")
@Transactional
public class NmIssuenewsManagerImpl extends BaseManagerImpl implements NmIssuenewsManager{
	@Autowired
	private NmIssuenewsDao nmIssuenewsDao;
	@Autowired
	private NmIssueflowManager nmIssueflowManager;
	@Autowired
	private NmIssuetypeManager issuetypeManager;
	@Autowired
	private NmIssueflowManager issueflowManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssuenews> getNmIssuenewss() throws BusException{
    	return nmIssuenewsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuenews> getNmIssuenewss(
    	@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuenewsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssuenews getNmIssuenews(@ServiceParam(name="policyId") String id)  throws BusException{
    	return nmIssuenewsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuenewss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssuenewsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping//(pubConditions={@PubCondition(property="policyCome",pubProperty="userId")})
    public NmIssuenews saveNmIssuenews(NmIssuenews o) throws BusException{
//    	String nmIssuenewsId = o.getNmIssuenewsId();
//    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuenewsId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return nmIssuenewsDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssuenews(@ServiceParam(name="policyId") String id) throws BusException{
    	nmIssuenewsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuenewss(@ServiceParam(name="policyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssuenews(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssuenews(@ServiceParam(name="policyId") String id)  throws BusException{
		return nmIssuenewsDao.exists(id);
	}
    
    public boolean exsitNmIssuenews(String propertyName,Object value) throws BusException{
		return nmIssuenewsDao.exists(propertyName,value);
	}
    
	@Override
	public NmIssueflow getNmIssueflowById(String id,String currentStatus) throws BusException {
		NmIssuenews nmIssuenews = nmIssuenewsDao.get(id);
		if(nmIssuenews!=null){
			NmIssuetype issueType = nmIssuenews.getPolicyType();//发布类型
			List<NmIssueflow> nmIssueflows = nmIssueflowManager.getNmIssueflows(issueType.getIssueTypeId());
			if(nmIssueflows!=null&&nmIssueflows.size()>0){
				for(NmIssueflow nmIssueflow:nmIssueflows){
					if(currentStatus.equals(nmIssueflow.getIssueFlowCStatus())){
						String operate = nmIssueflow.getIssueOperate();//当前操作
					}
					if(currentStatus.equals(nmIssueflow.getIssueFlowNStatus())){
						String nextOperate = nmIssueflow.getIssueOperate();//下一步操作
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean supportIssue(String issueTypeId, String status)
			throws BusException {
		return issueflowManager.isFinally(issueTypeId, status);
	}
	
	@Override
	public void issue(Object apply) throws BusException {
		// TODO Auto-generated method stub
		//String status ;
		//NmIssuenews nmIssuenews;
	}
	
	/**
	 * 得到所有的优惠政策
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public List<NmIssuenews> getAllPolicy() {
		List<NmIssuenews> list = this.getNmIssuenewss() ;
		List<NmIssuenews> policyList = new ArrayList<NmIssuenews>() ;
		for(int i=0;i<list.size();i++){
			NmIssuenews nm = list.get(i) ;
			String typeCode = nm.getPolicyType().getIssueTypeCode() ;//得到当前新闻的发布类型的typeCode
			if("02".equals(typeCode)){//02表示当前政策新闻的发布类型为优惠政策
				policyList.add(nm) ;
			}
		}
		return policyList;
	}
	
	/**
	 * 通过发布类型ID，得到该类型下的所有新闻
	 * @param issueTypeId 发布类型ID
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public List<NmIssuenews> getAllPolicyByTypeId(@ServiceParam(name="issueTypeId") String issueTypeId) {
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("policyType.issueTypeId", Condition.EQUALS,issueTypeId));
		List<NmIssuenews> list = this.getNmIssuenewss(condition, null) ;
		if(list != null){
			return list;
		}else{
			return new ArrayList<NmIssuenews>() ;
		}
	}
	
	/**
	 * 通过政策新闻ID得到当前的政策新闻（供前端调用） 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public NmIssuenews getNewsByPolicyId(@ServiceParam(name="policyId")String policyId) throws BusException{
		if(StringUtils.isNotEmpty(policyId)){
			return this.getNmIssuenews(policyId) ;
		}
		throw new BusException("policyId 不能为空！") ;
	}
}
