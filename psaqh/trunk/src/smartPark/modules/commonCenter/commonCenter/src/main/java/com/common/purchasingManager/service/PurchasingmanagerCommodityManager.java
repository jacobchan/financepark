/**
 * 代码声明
 */
package com.common.purchasingManager.service;

import java.util.Collection;
import java.util.List;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ServiceParam;

public interface PurchasingmanagerCommodityManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerCommodity getPurchasingmanagerCommodity(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerCommoditys(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerCommodity savePurchasingmanagerCommodity(PurchasingmanagerCommodity o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerCommodity(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommoditys(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerCommodity(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerCommodity(String propertyName,Object value) throws BusException;
	
	  /**
     * 根据商品类型获取相应的商品信息
     *  @param genreId:商品类别
     */
    public List<PurchasingmanagerCommodity> getCommodityRecordsByRecordType(String genreId) throws BusException;
    
    /**
     * 根据商品类别ID获取相应的商品信息
     * @param genreId:商品类别ID
     */
    public List<PurchasingmanagerCommodity> getCommodityRecordsByGenreId(String genreId) throws BusException;
    /**
     * 获取工商变更类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getComChangeCommodityList(String userId) throws BusException;
    /**
     * 获取公司注册类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getComReisterCommodityList(String userId) throws BusException;
    /**
     * 获取代理记账类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getAgencyCommodityList(String userId) throws BusException;
    /**
     * 获取法律服务类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getLawSerCommodityList(String userId) throws BusException;
    /**
     * 获取商标专利类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getChopPatentCommodityList(String userId) throws BusException;
    /**
     * 保存会议室
     * @param o
     * @return
     * @throws BusException
     */
	public PurchasingmanagerCommodity saveMeetRoomCommodity(PurchasingmanagerCommodity o) throws BusException;
	/**
	 * 保存广告位
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerCommodity saveAdsenseCommodity(PurchasingmanagerCommodity o) throws BusException;
	/**
	 * 保存车辆租赁
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerCommodity saveCarRentalCommodity(PurchasingmanagerCommodity o) throws BusException;
	/**
	 * 获取采购类别的所有商品列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPurCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取企业服务类别的所有商品列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerCompSerCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取所有的会议室列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerMeetRoomCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取所有的车辆列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerCarRentalCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取所有的广告位列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerAdsenseCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取所有的创立方列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerCcuCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取所有的工位列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerStationCommoditys(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 保存创立方
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerCommodity saveCcuCommodity(PurchasingmanagerCommodity o)
			throws BusException;
	/**
	 * 保存工位
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerCommodity saveStationCommodity(PurchasingmanagerCommodity o)
			throws BusException;
	/**
	 * 获取威客服务类别的所有商品列表
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerCommodity> getWkserverCommodityList(String userId)
			throws BusException;
	/**
	 * 删除用户角色
	 * @param id
	 * @throws BusException
	 */
	public void removeRole( String id) throws BusException;
	/**
	 * 删除系统菜单
	 * @param id
	 * @throws BusException
	 */
	public void removeMenu(String id) throws BusException;
}
