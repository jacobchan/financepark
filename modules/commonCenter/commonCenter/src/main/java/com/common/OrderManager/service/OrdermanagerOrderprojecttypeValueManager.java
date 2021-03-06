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
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;

public interface OrdermanagerOrderprojecttypeValueManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<OrdermanagerOrderprojecttypeValue> getOrdermanagerOrderprojecttypeValues() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<OrdermanagerOrderprojecttypeValue> getOrdermanagerOrderprojecttypeValues(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public OrdermanagerOrderprojecttypeValue getOrdermanagerOrderprojecttypeValue(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerOrdermanagerOrderprojecttypeValues(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public OrdermanagerOrderprojecttypeValue saveOrdermanagerOrderprojecttypeValue(OrdermanagerOrderprojecttypeValue o) throws BusException;

    /**
     * 删除对象
     */
    public void removeOrdermanagerOrderprojecttypeValue(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrderprojecttypeValues(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitOrdermanagerOrderprojecttypeValue(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitOrdermanagerOrderprojecttypeValue(String propertyName,Object value) throws BusException;
	/**
	 * 根据订单ID获取订单扩展属性列表
	 * @param userorderId
	 * @return
	 * @throws BusException
	 */
	public List<OrdermanagerOrderprojecttypeValue> getOovListByOrder(String userorderId)
			throws BusException;
	/**
	 * 根据字段名称和订单ID获取唯一扩展属性
	 * @param fieldName
	 * @param orderId
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerOrderprojecttypeValue getOovExtend(String fieldName,
			String orderId) throws BusException;
}
