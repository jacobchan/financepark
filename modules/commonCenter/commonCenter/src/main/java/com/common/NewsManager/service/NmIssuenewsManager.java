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
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public NmIssuenews saveNmIssuenews(NmIssuenews o) throws BusException;

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
	 * 发布
	 * @return
	 * @param nmIssuenews
	 * @throws BueException
	 */
//	public String issue(NmIssuenews nmIssuenews) throws BusException;
}
