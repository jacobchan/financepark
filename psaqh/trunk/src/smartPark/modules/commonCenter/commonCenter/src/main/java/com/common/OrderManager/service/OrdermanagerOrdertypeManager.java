/**
 * 代码声明
 */
package com.common.OrderManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.common.OrderManager.entity.OrdermanagerOrdertype;

public interface OrdermanagerOrdertypeManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<OrdermanagerOrdertype> getOrdermanagerOrdertypes() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<OrdermanagerOrdertype> getOrdermanagerOrdertypes(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public OrdermanagerOrdertype getOrdermanagerOrdertype(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerOrdermanagerOrdertypes(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public OrdermanagerOrdertype saveOrdermanagerOrdertype(OrdermanagerOrdertype o) throws BusException;

    /**
     * 删除对象
     */
    public void removeOrdermanagerOrdertype(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrdertypes(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitOrdermanagerOrdertype(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitOrdermanagerOrdertype(String propertyName,Object value) throws BusException;
	/**
	 * 获取企业服务订单类型列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerComSerOrderTypes(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders) throws BusException;
}
