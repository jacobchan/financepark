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
import com.common.purchasingManager.entity.PurchasingmanagerMerchant;

public interface PurchasingmanagerMerchantManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerMerchant> getPurchasingmanagerMerchants() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerMerchant> getPurchasingmanagerMerchants(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerMerchant getPurchasingmanagerMerchant(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerMerchants(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerMerchant savePurchasingmanagerMerchant(PurchasingmanagerMerchant o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerMerchant(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerMerchants(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerMerchant(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerMerchant(String propertyName,Object value) throws BusException;
	/**
	 * 根据商品类别获取相关商户列表
	 * @param genreId
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerMerchant> getMerchantsByGenre(String genreId,String genreCode)  throws BusException;
	/**
	 * 获取会议室所属商户列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerMerchant> getMeetRoomMerchants() throws BusException;
	/**
	 * 获取车辆租赁所属商户列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerMerchant> getCarRentalMerchants() throws BusException;
	/**
	 * 获取广告位所属商户列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerMerchant> getAdsenseMerchants() throws BusException;
	/**
	 * 获取公共资源类型的商户列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPublicResoMerchants(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取采购类型的商户列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPurMerchants(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取企业服务类型的商户列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerCompSerMerchants(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
	/**
	 * 获取采购商品所属商户列表
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerMerchant> getPurMerchants() throws BusException;
	/**
	 * 保存采购商户
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerMerchant savePurMerchant(PurchasingmanagerMerchant o)
			throws BusException;
}
