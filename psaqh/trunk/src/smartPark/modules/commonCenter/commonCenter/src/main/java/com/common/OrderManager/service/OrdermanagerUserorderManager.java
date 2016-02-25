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

import com.common.OrderManager.entity.OrdermanagerUserorder;

public interface OrdermanagerUserorderManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<OrdermanagerUserorder> getOrdermanagerUserorders() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<OrdermanagerUserorder> getOrdermanagerUserorders(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public OrdermanagerUserorder getOrdermanagerUserorder(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerOrdermanagerUserorders(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public OrdermanagerUserorder saveOrdermanagerUserorder(OrdermanagerUserorder o) throws BusException;

    /**
     * 删除对象
     */
    public void removeOrdermanagerUserorder(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerUserorders(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitOrdermanagerUserorder(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitOrdermanagerUserorder(String propertyName,Object value) throws BusException;
	
	  /**
     * 更新状态
     */
    public void updateUserorderStatus(String id,String userorderStatus) throws BusException;
    /**
     * 保存或修改采购订单
     * @param o
     * @return
     * @throws BusException
     */
    public OrdermanagerUserorder savePurOrdermanager(OrdermanagerUserorder o) throws BusException;
    /**
     * 保存或修改餐饮订单
     * @param o
     * @return
     * @throws BusException
     */
	public OrdermanagerUserorder saveFoodOrdermanager(OrdermanagerUserorder o) throws BusException;
	/**
	 * 保存或修改IT服务订单
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveITSerOrderMg(OrdermanagerUserorder o) throws BusException;
	/**
	 * 获取企业服务订单列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerComSerOrders(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)throws BusException;
	/**
	 * 保存或修改企业服务订单
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveCompSerOrderMg(OrdermanagerUserorder o) throws BusException;
}
