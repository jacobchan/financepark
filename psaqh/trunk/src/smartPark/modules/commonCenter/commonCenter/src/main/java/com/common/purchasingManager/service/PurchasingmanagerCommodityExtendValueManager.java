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
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;

public interface PurchasingmanagerCommodityExtendValueManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerCommodityExtendValue> getPurchasingmanagerCommodityExtendValues() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerCommodityExtendValue> getPurchasingmanagerCommodityExtendValues(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerCommodityExtendValue getPurchasingmanagerCommodityExtendValue(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerCommodityExtendValues(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerCommodityExtendValue savePurchasingmanagerCommodityExtendValue(PurchasingmanagerCommodityExtendValue o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerCommodityExtendValue(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommodityExtendValues(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerCommodityExtendValue(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerCommodityExtendValue(String propertyName,Object value) throws BusException;
	/**
     * 根据商品ID和扩展属性名获取扩展属性值对象
     */
	public PurchasingmanagerCommodityExtendValue getPurchasingmanagerCommodityExtendValue(
			String commodityId, String commodityExtendValueFieldName);
}
