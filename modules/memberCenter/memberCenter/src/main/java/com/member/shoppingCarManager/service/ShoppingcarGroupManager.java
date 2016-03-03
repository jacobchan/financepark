/**
 * 代码声明
 */
package com.member.shoppingCarManager.service;

import java.util.List;
import java.util.Collection;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.member.shoppingCarManager.entity.ShoppingcarGroup;

public interface ShoppingcarGroupManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ShoppingcarGroup> getShoppingcarGroups() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ShoppingcarGroup> getShoppingcarGroups(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ShoppingcarGroup getShoppingcarGroup(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerShoppingcarGroups(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ShoppingcarGroup saveShoppingcarGroup(ShoppingcarGroup o) throws BusException;

    /**
     * 删除对象
     */
    public void removeShoppingcarGroup(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarGroups(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitShoppingcarGroup(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitShoppingcarGroup(String propertyName,Object value) throws BusException;
	/**
	 * 新增采购订单
	 * @param o
	 * @param shopCarList 购物车列表
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder savePurOrder(OrdermanagerUserorder o,
			List<ShoppingcarGroup> shopCarList) throws BusException;
}
