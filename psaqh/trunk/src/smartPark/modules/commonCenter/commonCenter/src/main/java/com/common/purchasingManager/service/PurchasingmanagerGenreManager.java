/**
 * 代码声明
 */
package com.common.purchasingManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;

public interface PurchasingmanagerGenreManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    
    /**
     * 根据商品类别（enreCode）查询商品
     */
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenresByGenreCode(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerGenre getPurchasingmanagerGenre(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerGenres(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerGenre savePurchasingmanagerGenre(PurchasingmanagerGenre o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerGenre(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenres(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerGenre(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerGenre(String propertyName,Object value) throws BusException;
    /**
     * 获取所有的采购餐饮类别列表
     */
    public List<PurchasingmanagerGenre> getPurFoodGenres() throws BusException;
    /**
     * 获取所有的订单类型列表
     * @return
     */
	public List<PurchasingmanagerGenre> getOrderTypes() throws BusException;
	/**
	 * 获取商户类别列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getMerchantGenres() throws BusException;
	/**
	 * 根据类别唯一编号获取对象
	 * @param genreCode
	 * @return
	 * @throws BusException
	 */
    public PurchasingmanagerGenre getGenreByUniqueProperty(String paramString,Object paramObject) throws BusException;
    /**
     * 获取所有商品类别列表
     * @return
     * @throws BusException
     */
	public List<PurchasingmanagerGenre> getCommodityGenreList() throws BusException;
	/**
     * 获取IT服务的所有字类别列表
     * @return
     * @throws BusException
     */
	public List<PurchasingmanagerGenre> getITSubGenreList(String userId) throws BusException;
	/**
	 * 获取公共资源的所有类别列表
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getPublicResoOrderTypes(String userId)
			throws BusException;
	/**
	 * 获取企业服务的所有类别列表
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getCompSerOrderTypes(String userId)
			throws BusException;
	/**
	 * 获取所有的采购类别列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getPurGenres() throws BusException;
	/**
	 * 获取所有的企业服务类别列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getCompSerGenres() throws BusException;
	/**
	 * 获取订单项
	 * @param userId
	 * @return
	 */
	public List<PurchasingmanagerGenre> getGenreProject(String userId);
	/**
	 * 获取企业服务的所有类别列表(包括IT服务子类别)
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerGenre> getCompOrderTypes()
			throws BusException;
}
