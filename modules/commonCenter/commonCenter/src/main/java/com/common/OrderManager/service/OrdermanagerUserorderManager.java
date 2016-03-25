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
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
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
	 * 分页查询公共资源的订单
	 * @return 分页对象
	 */
	public PagerRecords getPagerOrdermanagerUserordersForPublic(Pager pager,//分页条件
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
	 * 获取企业服务订单列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerComSerOrders(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders) throws BusException;
	
	/**
	 * 新增IT服务订单
	 * @param userId 当前登录用户ID
	 * @param commodityId 商品ID
	 * @param faultDes 故障描述
	 * @param userorderAdr 联系地址
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveITSerOrder(String userId,String commodityId,String faultDes,String userorderAdr) throws BusException;
	/**
	 * 新增工商变更订单
	 * @param userId
	 * @param orderDetailList
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveComChangeOrder(String userId,
			List<OrdermanagerCommoditydetail> orderDetailList) throws BusException;
	/**
	 * 新增公司注册订单
	 * @param userId
	 * @param orderDetailList
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder saveComReisterOrder(String userId,
			List<OrdermanagerCommoditydetail> orderDetailList) throws BusException;
	/**
	 * 新增代理记账订单
	 * @param userId
	 * @param orderDetailList
	 * @return
	 * @throws BusException
	 */
   	public OrdermanagerUserorder saveAgencyOrder(String userId,
   			List<OrdermanagerCommoditydetail> orderDetailList) throws BusException;
   	/**
   	 * 新增法律服务订单
   	 * @param userId
   	 * @param orderDetailList
   	 * @return
   	 * @throws BusException
   	 */
   	public OrdermanagerUserorder saveLawSerOrder(String userId,
   			List<OrdermanagerCommoditydetail> orderDetailList) throws BusException;
   	/**
   	 * 新增商标专利订单
   	 * @param userId
   	 * @param orderDetailList
   	 * @return
   	 * @throws BusException
   	 */
   	public OrdermanagerUserorder saveChopPatentOrder(String userId,
   			List<OrdermanagerCommoditydetail> orderDetailList) throws BusException;
   	/**
   	 * 获取公共资源订单列表
   	 * @param pager
   	 * @param conditions
   	 * @param orders
   	 * @return
   	 * @throws BusException
   	 */
   	public PagerRecords getPagerPublicResoOrders(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
   	/**
   	 * 修改订单
   	 * @param o
   	 * @return
   	 * @throws BusException
   	 */
   	public OrdermanagerUserorder saveOrder(OrdermanagerUserorder o)
			throws BusException;
   	/**
   	 * 获取采购商品订单列表
   	 * @param pager
   	 * @param conditions
   	 * @param orders
   	 * @return
   	 * @throws BusException
   	 */
   	public PagerRecords getPagerPurOrders(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
   	/**
   	 * 获取当前登录用户投诉列表
   	 * @param o
   	 * @return
   	 * @throws BusException
   	 */
   	public List<OrdermanagerUserorder> getOrderListByLoginUser(OrdermanagerUserorder o) throws BusException;
}
