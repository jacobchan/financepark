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
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="issueTypeCode") String issueTypeCode)  throws BusException{
		if(StringUtils.isNotEmpty(issueTypeCode)){
			conditions.add(ConditionUtils.getCondition("policyType.issueTypeCode", Condition.EQUALS,issueTypeCode));
		}
		PagerRecords pagerRecords = nmIssuenewsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	@EsbServiceMapping
	public PagerRecords getPagerYHZCIssuenewss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="issueTypeCode") String issueTypeCode)  throws BusException{
		List<NmIssuetype> list = issuetypeManager.getNewsType(issueTypeCode) ;
		String[] str = new String[list.size()];
		for(int i=0;i<list.size() ;i++){
			String code = list.get(i).getIssueTypeCode() ;
			str[i] = code ;
		}
		conditions.add(ConditionUtils.getCondition("policyType.issueTypeCode", Condition.IN,str));
		PagerRecords pagerRecords = nmIssuenewsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping//(pubConditions={@PubCondition(property="policyCome",pubProperty="userId")})
    public NmIssuenews saveNmIssuenews(NmIssuenews o) throws BusException{
    	String nmIssuenewsId = o.getPolicyId();
    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuenewsId);
    	if(isUpdate){//修改
    		return nmIssuenewsDao.save(o);
    	}else{//新增
    		o.setBrowseCount("0");
    		o.setCaiCount("0");
    		o.setDingCount("0");
    		return nmIssuenewsDao.save(o);
    	}
    }
    
    @Override
    @EsbServiceMapping
    public NmIssuenews saveNmIssuenewss(NmIssuenews o, @ServiceParam(name="code")String code)
    		throws BusException {
    	String nmIssuenewsId = o.getPolicyId();
    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuenewsId);
    	if(isUpdate){//修改
    		return nmIssuenewsDao.save(o);
    	}else{//新增
    		NmIssuetype type = issuetypeManager.getIssueTypeByIssueTypeCode(code) ;
    		o.setPolicyType(type);
    		o.setPolicyStatus("1");//已发布
    		o.setBrowseCount("0");
    		o.setCaiCount("0");
    		o.setDingCount("0");
    		return nmIssuenewsDao.save(o);
    	}
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
	 * 得到所有已发布的优惠政策下面的孵化器政策
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
			if("0201".equals(typeCode)&& "1".equals(nm.getPolicyStatus())){//0201表示当前政策新闻的发布类型为优惠政策下的孵化器政策,1表示当前政策已发布
				policyList.add(nm) ;
			}
		}
		return policyList;
	}
	
	/**
	 * 后台调用
	 * 得到所有的优惠证政策
	 * @return
	 */
	@EsbServiceMapping
	public List<NmIssuenews> getAllPolicyList(){
		List<NmIssuenews> list = this.getNmIssuenewss() ;
		List<NmIssuenews> policyList = new ArrayList<NmIssuenews>() ;
		for(int i=0;i<list.size();i++){
			NmIssuenews nm = list.get(i) ;
			String typeCode = nm.getPolicyType().getIssueTypeCode() ;//得到当前新闻的发布类型的typeCode
			if("0201".equals(typeCode) || "0202".equals(typeCode)){//0201孵化器政策,0202加速器政策
				policyList.add(nm) ;
			}
		}
		return policyList ;
	}
	
	/**
	 * 通过发布类型ID，得到该类型下的所有已发布的新闻
	 * @param issueTypeId 发布类型ID
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public List<NmIssuenews> getAllPolicyByTypeId(@ServiceParam(name="issueTypeId") String issueTypeId) {
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("policyType.issueTypeId", Condition.EQUALS,issueTypeId));
		List<NmIssuenews> list = this.getNmIssuenewss(condition, null) ;
		List<NmIssuenews> newsList = new ArrayList<NmIssuenews>() ;
		for(int i=0;i<list.size();i++){
			NmIssuenews nm = list.get(i) ;
			String policyStatus = nm.getPolicyStatus() ;//得到政策发布状态
			if("1".equals(policyStatus)){//1表示当前政策发布状态为发布，0为未发布
				newsList.add(nm) ;
			}
		}
		return newsList ;
	}
	
	/**
	 * 通过政策新闻ID得到当前的政策新闻（供前端调用） 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	@EsbServiceMapping
	public NmIssuenews getNewsByPolicyId(@ServiceParam(name="policyId") String policyId) throws BusException{
		if(StringUtils.isNotEmpty(policyId)){
			return this.getNmIssuenews(policyId) ;
		}
		throw new BusException("policyId 不能为空！") ;
	}
	
	/**
	 * 通过政策新闻ID得到下一个政策新闻 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	@EsbServiceMapping
	public NmIssuenews getNextPolicyByPilicyId(@ServiceParam(name="policyId") String policyId) {
		NmIssuenews nm = this.getNmIssuenews(policyId) ;//得到政策新闻
		NmIssuetype type = nm.getPolicyType() ;//得到政策发布类型
		String typeId = type.getIssueTypeId() ;//得到政策发布类型的ID
		List<NmIssuenews> list = this.getAllPolicyByTypeId(typeId) ;//得到当前政策发布类型下面的所有已发布的政策新闻
		int length = list.size() ;
		int index = list.indexOf(nm) + 1;
		if(index < length){
			return list.get(index) ;
		}
		return null;
	}
	
	/**
	 * 通过政策新闻ID得到上一个政策新闻 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	@EsbServiceMapping
	public NmIssuenews getPrePolicyByPolicyId(@ServiceParam(name="policyId") String policyId) {
		NmIssuenews nm = this.getNmIssuenews(policyId) ;//得到政策新闻
		NmIssuetype type = nm.getPolicyType() ;//得到政策发布类型
		String typeId = type.getIssueTypeId() ;//得到政策发布类型的ID
		List<NmIssuenews> list = this.getAllPolicyByTypeId(typeId) ;//得到当前政策发布类型下面的所有已发布的政策新闻
		int index = list.indexOf(nm) - 1;
		if(index >= 0 ){
			return list.get(index) ;
		}
		return null;
	}
	
	/**
	 * 通过政策ID设置当前页面的浏览量
	 * @param policyId 政策新闻ID
	 * @return
	 */
	@EsbServiceMapping
	public NmIssuenews setBrowseCountByPolicyId(@ServiceParam(name="policyId") String policyId) {
		NmIssuenews nm = this.getNmIssuenews(policyId) ;
		int count = Integer.parseInt(nm.getBrowseCount()) + 1 ;//获取当前政策的浏览量，转化为int型，再+1
		nm.setBrowseCount(String.valueOf(count));
		return nmIssuenewsDao.save(nm);
	}
	
	/**
	 * 通过政策类型的Code得到当前政策下面已发布的所有新闻
	 * @param issueTypeCode 政策类型code
	 * @return
	 */
	@EsbServiceMapping
	public List<NmIssuenews> getNmIssuenewsByIssueTypeCode(@ServiceParam(name="issueTypeCode") String issueTypeCode) {
		NmIssuetype type = issuetypeManager.getIssueTypeByIssueTypeCode(issueTypeCode) ; //得到政策发布类型
		String issueTypeId = type.getIssueTypeId() ;//得到政策发布类型的ID
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("policyType.issueTypeId", Condition.EQUALS,issueTypeId));
		condition.add(ConditionUtils.getCondition("policyStatus", Condition.EQUALS,"1"));//1表示当前政策已发布，0为未发布
		List<NmIssuenews> list = this.getNmIssuenewss(condition, null) ;
		return list;
	}
	
	/**
	 * 分页查找，所有已发布的新闻公告
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public PagerRecords getPagerAllPolicy(Pager pager,
			@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="issueTypeCode") String issueTypeCode)
			throws BusException {
		conditions.add(ConditionUtils.getCondition("policyType.issueTypeCode", Condition.EQUALS,issueTypeCode));//0201为当前优惠政策下面的孵化器政策
		conditions.add(ConditionUtils.getCondition("policyStatus", Condition.EQUALS,"1"));//1表示当前政策已发布，0为未发布
		PagerRecords pagerRecords = nmIssuenewsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
}
