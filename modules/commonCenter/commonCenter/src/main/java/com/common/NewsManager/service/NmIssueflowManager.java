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
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuetype;

public interface NmIssueflowManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<NmIssueflow> getNmIssueflows() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<NmIssueflow> getNmIssueflows(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public NmIssueflow getNmIssueflow(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerNmIssueflows(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public NmIssueflow saveNmIssueflow(NmIssueflow o) throws BusException;

    /**
     * 删除对象
     */
    public void removeNmIssueflow(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssueflows(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitNmIssueflow(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitNmIssueflow(String propertyName,Object value) throws BusException;
	
	/**
	 * 保存多条
	 * @param nmIssueflows
	 * @throws BusException
	 */
	public void saveNmIssueflows(List<NmIssueflow> nmIssueflows) throws BusException;
	
	/**
	 * 根据发布类型获取所有流程状态
	 * @param pager
	 * @param nmIssuetype
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerNmIssueflowByType(Pager pager, NmIssuetype nmIssuetype, @OrderCollection Collection<Order> orders) throws BusException;
	
	/**
	 * 根据条件查询
	 * @param issueTypeId
	 * @param properties
	 * @param values
	 * @return
	 * @throws BusException
	 */
	public List<NmIssueflow> getNmIssueflowsWithTypeid(String issueTypeId,String[] properties,String[] values) throws BusException;
	
	/**
	 * 根据新闻发布类型确认初始流程
	 * @param nmIssuetypeId
	 * @return
	 * @throws BusException
	 */
	public NmIssueflow getStartFlow(String nmIssuetypeId) throws BusException;
	
	/**
	 * 根据新闻发布类型和流程确认下一步流程
	 * @param nmIssuetypeId
	 * @param issueFlowId
	 * @return
	 * @throws BusException
	 */
	public NmIssueflow getNextFlow(String nmIssuetypeId,String issueFlowId) throws BusException;
	
	/**
	 * 状态查对应操作
	 * @param status
	 * @return
	 * @throws BusException
	 */
	public String getOperateByStatus(String nmIssuetypeId,String status) throws BusException;
	
	/**
	 * 判断是否最后一步
	 * @param nmIssuetypeId
	 * @param currentStatus
	 * @return
	 * @throws BusException
	 */
	public boolean isFinally(String nmIssuetypeId,String currentStatus) throws BusException;
}
