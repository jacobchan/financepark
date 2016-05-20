/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;

public interface PropertyservicemanagerTsManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerTs getPropertyservicemanagerTs(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerTss(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
	
	/**
	 * 根据报修记录id分页查询派工记录
	 * @param pager
	 * @param bx 报修记录
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPropertyservicemanagerTssByBx(Pager pager,//分页条件
			PropertyservicemanagerBx bx,
			Collection<Order> orders) throws BusException;

    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerTs savePropertyservicemanagerTs(PropertyservicemanagerTs o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerTs(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerTss(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerTs(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerTs(String propertyName,Object value) throws BusException;
	/**
	 * 根据派工id修改保修状态
	 * @param id 派工id
	 * @param code 判断回绝与接单标识
	 * @throws BusException
	 */
	public void upTsbyId(String id,String code) throws BusException;
	/**
	 * 根据报修id查找接单状态下的派工记录
	 * @param bxId
	 * @return
	 * @throws BusException
	 */
	public PropertyservicemanagerTs getTsBybxId(String bxId)throws BusException;
	/**
     * 后台个人派工记录
     * @param userId
	 * @return
	 * @throws BusException
     */;
    public PagerRecords getPropertyTs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,
			String userId) throws BusException;
    /**
   	 * 根据派工id修改保修状态 为已完成
   	 * @param id 派工id
   	 * @throws BusException
   	 */
   	public void upTsStatusbyId(String id) throws BusException;
	/**
	 * 根据物业报修ID查询最新一条维修记录
	 * @param bxId
	 * @return
	 * @throws BusException
	 */
	public PropertyservicemanagerTs getPropertyservicemanagerTssBybxId(
			String bxId) throws BusException;
	/**
	 * 保存对象
	 * @param o
	 * @return
	 */
	public PropertyservicemanagerTs savePts(PropertyservicemanagerTs o);
}
