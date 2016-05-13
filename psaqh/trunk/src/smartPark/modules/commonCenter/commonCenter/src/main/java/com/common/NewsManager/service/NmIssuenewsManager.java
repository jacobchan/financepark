/**
 * 代码声明
 */
package com.common.NewsManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuenews;

public interface NmIssuenewsManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<NmIssuenews> getNmIssuenewss() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<NmIssuenews> getNmIssuenewss(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public NmIssuenews getNmIssuenews(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerNmIssuenewss(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,
			String issueTypeCode) throws BusException;
	/**
	 * 分页查询优惠政策
	 * @return 分页对象
	 */
	public PagerRecords getPagerYHZCIssuenewss(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,
			String issueTypeCode) throws BusException;
    /**
     * 保存并返回对象
     */
    public NmIssuenews saveNmIssuenews(NmIssuenews o) throws BusException;
    
    /**
     * 保存并返回对象
     */
    public NmIssuenews saveNmIssuenewss(NmIssuenews o,String code) throws BusException;

    /**
     * 删除对象
     */
    public void removeNmIssuenews(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuenewss(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitNmIssuenews(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitNmIssuenews(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据ID查出发布流程
	 * @param id
	 * @return
	 * @throws BusException
	 */
	public NmIssueflow getNmIssueflowById(String id,String currentStatus)throws BusException;
	
	/**
	 * 发布,用户的申请
	 * @return
	 * @param nmIssuenews
	 * @throws BueException
	 */
	public void issue(Object apply) throws BusException;
	
	/**
	 * 是否支持发布
	 * @param issueTypeId
	 * @param status
	 * @return
	 * @throws BusException
	 */
	public boolean supportIssue(String issueTypeId,String status)throws BusException;
	/**
	 * 得到所有已发布的优惠政策下面的孵化器政策
	 * @return
	 */
	public List<NmIssuenews> getAllPolicy() ;
	
	/**
	 * 通过发布类型ID，得到该类型下的所有新闻
	 * @param issueTypeId 发布类型ID
	 * @return
	 */
	public List<NmIssuenews> getAllPolicyByTypeId(String issueTypeId) ;
	
	/**
	 * 通过政策新闻ID得到当前的政策新闻（供前端调用） 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	public NmIssuenews getNewsByPolicyId(String policyId) ;
	
	/**
	 * 通过政策新闻ID得到上一个政策新闻 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	public NmIssuenews getPrePolicyByPolicyId(String policyId);
	
	/**
	 * 通过政策新闻ID得到下一个政策新闻 
	 * @param policyId 政策新闻ID
	 * @return
	 */
	public NmIssuenews getNextPolicyByPilicyId(String policyId) ;
	
	/**
	 * 通过政策ID设置当前页面的浏览量
	 * @param policyId 政策新闻ID
	 * @return
	 */
	public NmIssuenews setBrowseCountByPolicyId(String policyId) ;
	
	/**
	 * 通过政策类型的Code得到当前政策下面已发布的所有新闻
	 * @param issueTypeCode 政策类型code
	 * @return
	 */
	public List<NmIssuenews> getNmIssuenewsByIssueTypeCode(String issueTypeCode) ;
	
	/**
	 * 分页查找，所有已发布的优惠政策下面的孵化器政策
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerAllPolicy(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,String issueTypeCode)  throws BusException ;
	
	/**
	 * 后台调用
	 * 得到所有的优惠政策
	 * @return
	 */
	public List<NmIssuenews> getAllPolicyList() ;
	
}
