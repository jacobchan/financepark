/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos;



public interface PropertyservicemanagerCosManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerCos getPropertyservicemanagerCos(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerCoss(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerCos savePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException;
    
    /**
     * 修改对象
     */
    public PropertyservicemanagerCos updatePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerCos(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerCoss(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerCos(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerCos(String propertyName,Object value) throws BusException;
	
	/**
     * 根据id修改投诉状态
     * @param ids
     */
	public void upCosbyId(String id,String code) throws BusException;
	 /**
     * 获取当前登录用户id
     * @return
     * @throws BusException
     */  
	public List<PropertyservicemanagerCos> getCosListByLoginUser(PropertyservicemanagerCos p) throws BusException ;    	 	
   	
    /**
     * 前台修改订单
     * @param cosId
     * @return
     * @throws BusException
     */
    public PropertyservicemanagerCos updateCosforpage(String cosId) throws BusException ;    	 	
	/**
     * 受理保存对象
     * 修改投诉状态标识，添加回访记录
     */
    public PropertyservicemanagerCos acceptancePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException;
    	
    /**
     * 受理拒绝保存对象
     * 修改投诉状态标识，添加拒绝原因记录
     */
    public PropertyservicemanagerCos rejectPropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException;
    /**
	 * 根据当前用户分页查询 根据投诉单号模糊查询（ 前台个人中心）		   chenye
	 * @return 分页对象
	 */
	public PagerRecords getPagerCos(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,				
			String startTime,String endTime) throws BusException;
	/**
	 * 获取已完成订单的totalCount    陈烨
	 * @param conditions
	 * @param coslikeCode
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusException
	 */
	public List<Record> getTotalCount(
   			Collection<Condition> conditions,
   			String startTime,String endTime) throws BusException;
}
