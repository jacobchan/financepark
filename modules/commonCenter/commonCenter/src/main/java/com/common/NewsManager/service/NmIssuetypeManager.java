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
import com.gsoft.framework.esb.annotation.ServiceParam;

import com.common.NewsManager.entity.NmIssuetype;

public interface NmIssuetypeManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<NmIssuetype> getNmIssuetypes() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<NmIssuetype> getNmIssuetypes(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public NmIssuetype getNmIssuetype(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerNmIssuetypes(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
	/**
	 * 分页查询通过issueTypeCode
	 * @return 分页对象
	 */
	public PagerRecords getPagerNmIssuetypesByCode(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,String issueTypeCode) throws BusException;
    /**
     * 保存并返回对象
     */
    public NmIssuetype saveNmIssuetype(NmIssuetype o) throws BusException;
    
    /**
     * 保存并返回对象
     */
    public NmIssuetype saveNmIssuetypes(NmIssuetype o,String code) throws BusException;

    /**
     * 删除对象
     */
    public void removeNmIssuetype(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuetypes(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitNmIssuetype(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitNmIssuetype(String propertyName,Object value) throws BusException;
	
	 /**
     * 条件查询列表
     */
    public List<NmIssuetype> getChildren(String parentId) throws BusException;
    
    /**类型编码是否已经存在
     * @param code
     * @return
     * @throws BusException
     */
    public String codeExist(String code) throws BusException;
    
    /**
     * 得到政策新闻的所有的子类型通过issueTypeCode
     * @return
     */
    public List<NmIssuetype> getNewsType(String issueTypeCode) ;
    
    /**
     * 通过政策发布类型code得到当前政策
     * @param issueTypeCode 政策发布类型code
     * @return
     */
    public NmIssuetype getIssueTypeByIssueTypeCode(String issueTypeCode) ;
}
