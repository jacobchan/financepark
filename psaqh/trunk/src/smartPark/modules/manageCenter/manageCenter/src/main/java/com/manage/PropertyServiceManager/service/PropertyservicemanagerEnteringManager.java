/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.DomainCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;

public interface PropertyservicemanagerEnteringManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerEntering getPropertyservicemanagerEntering(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerEnterings(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
	
	/**
	 * 前台展示可办理预约记录
	 */
	@EsbServiceMapping
	public List<Record> getEnteringList(Pager pager,String userId)  throws BusException;
	/**
	 * 查询所有可以预约的预约记录
	 * @return 
	 */
	public PagerRecords getPropertyservicemanagerEnteringsByStatus(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public void savePropertyservicemanagerEntering(PropertyservicemanagerEntering o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerEntering(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEnterings(List<PropertyservicemanagerEntering> listEntering) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerEntering(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public TempDemo exsitPropertyservicemanagerEnteringForDate(String propertyName,String value) throws BusException;
	
    /**
  	 * 批量新增可办理预约记录
  	 * @param listEntering 可办理预约记录
  	 */
     @EsbServiceMapping
  	public void saveListEntering(List<PropertyservicemanagerEntering> listEntering);
}