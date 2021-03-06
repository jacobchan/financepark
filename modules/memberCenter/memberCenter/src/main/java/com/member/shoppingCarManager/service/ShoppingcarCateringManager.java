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
import com.member.shoppingCarManager.entity.ShoppingcarCatering;

public interface ShoppingcarCateringManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ShoppingcarCatering> getShoppingcarCaterings() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ShoppingcarCatering> getShoppingcarCaterings(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ShoppingcarCatering getShoppingcarCatering(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerShoppingcarCaterings(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ShoppingcarCatering saveShoppingcarCatering(ShoppingcarCatering o) throws BusException;

    /**
     * 删除对象
     */
    public void removeShoppingcarCatering(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarCaterings(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitShoppingcarCatering(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitShoppingcarCatering(String propertyName,Object value) throws BusException;
	/**
	 * 新增餐饮订单
	 * @param o
	 * @param shopCarList 购物车列表
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveFoodOrder(OrdermanagerUserorder o,
			List<ShoppingcarCatering> shopCarList) throws BusException;
}
