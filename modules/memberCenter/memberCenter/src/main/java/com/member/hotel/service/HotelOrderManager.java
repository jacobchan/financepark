/**
 * 代码声明
 */
package com.member.hotel.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.member.hotel.entity.HotelOrder;

public interface HotelOrderManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<HotelOrder> getHotelOrders() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<HotelOrder> getHotelOrders(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public HotelOrder getHotelOrder(String id) throws BusException;
    
    /**
     *获取总条数 
     */
    public List<Record> getTotalCount( Collection<Condition> conditions,
			String startTime, String endTime)  throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerHotelOrders(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders, String startTime, String endTime) throws BusException;
    /**
     * 保存并返回对象
     */
    public HotelOrder saveHotelOrder(HotelOrder o) throws BusException;

    /**
     * 删除对象
     */
    public void removeHotelOrder(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeHotelOrders(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitHotelOrder(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitHotelOrder(String propertyName,Object value) throws BusException;
}
