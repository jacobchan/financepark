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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFxtdc;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;

public interface PropertyservicemanagerFxtdcManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerFxtdc> getPropertyservicemanagerFxtdcs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerFxtdc> getPropertyservicemanagerFxtdcs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerFxtdc getPropertyservicemanagerFxtdc(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerFxtdcs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerFxtdc savePropertyservicemanagerFxtdc(PropertyservicemanagerFxtdc o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerFxtdc(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerFxtdcs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerFxtdc(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerFxtdc(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过搬家申请对象得到对应的二维码
	 * @param moverec 搬家申请对象
	 * @return
	 */
	public PropertyservicemanagerFxtdc getFxtdcByMoverec(PropertyservicemanagerMoverec moverec) ;
}
