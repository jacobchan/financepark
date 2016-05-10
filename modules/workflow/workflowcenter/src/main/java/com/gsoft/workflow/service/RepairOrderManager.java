package com.gsoft.workflow.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.workflow.entity.RepairOrder;

public interface RepairOrderManager extends BaseManager{


    /**
     * 查询列表
     */
    public List<RepairOrder> getRepairOrders() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<RepairOrder> getRepairOrders(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public RepairOrder getRepairOrder(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerRepairOrders(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public RepairOrder saveRepairOrder(RepairOrder o) throws BusException;

    /**
     * 删除对象
     */
    public void removeRepairOrder(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeRepairOrders(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitRepairOrder(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitRepairOrder(String propertyName,Object value) throws BusException;
	
}
