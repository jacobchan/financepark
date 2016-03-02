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
}
