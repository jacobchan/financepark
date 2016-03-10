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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;

public interface PropertyservicemanagerMoverecManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerMoverec getPropertyservicemanagerMoverec(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerMoverecs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerMoverec savePropertyservicemanagerMoverec(PropertyservicemanagerMoverec o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerMoverec(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerMoverecs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerMoverec(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerMoverec(String propertyName,Object value) throws BusException;
	/**
	 *  根据申请记录id审批
	 * @param id 搬家申请记录id
	 * @throws BusException
	 */
	public void upMovById(String id) throws BusException;
	/**
	 * 根据当前登录获取搬家放行
	 * @param o 搬家对象
	 * @return
	 * @throws BusException
	 */
	public List<PropertyservicemanagerMoverec> getMovListforpage(PropertyservicemanagerMoverec o) throws BusException;
}
