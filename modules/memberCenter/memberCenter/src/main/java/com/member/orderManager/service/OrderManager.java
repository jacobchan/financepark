/**
 * 代码声明
 */
package com.member.orderManager.service;

import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.member.shoppingCarManager.entity.ShoppingcarGroup;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;

public interface OrderManager extends BaseManager{
	
    /**
     * 新增采购订单
     * @param o
     * @param shopCarList
     * @return
     * @throws BusException
     */
    public OrdermanagerUserorder savePurOrdermanager(OrdermanagerUserorder o,List<ShoppingcarGroup> shopCarList) throws BusException;
    /**
     * 新增餐饮订单
     * @param o
     * @return
     * @throws BusException
     */
	public OrdermanagerUserorder saveFoodOrdermanager(OrdermanagerUserorder o) throws BusException;
	/**
	 * 新增公共资源订单
	 * @param o
	 * @param commodity
	 * @param publicReso
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder savePublicResoOrder(OrdermanagerUserorder o,
			PurchasingmanagerCommodity commodity,List<PublicutilitiesmanagerReso> publicResoList) throws BusException;
	/**
	 * 新增物业报修订单
	 * @param o
	 * @param propertyBx
	 * @return
	 * @throws BusException
	 */
	public OrdermanagerUserorder savePropertyBxOrder(OrdermanagerUserorder o,PropertyservicemanagerBx propertyBx) throws BusException;
//	/**
//	 * 新增IT服务订单
//	 * @param o
//	 * @return
//	 * @throws BusException
//	 */
//	public OrdermanagerUserorder saveITSerOrderMg(OrdermanagerUserorder o) throws BusException;
//	/**
//	 * 新增企业服务订单
//	 * @param o
//	 * @return
//	 * @throws BusException
//	 */
//	public OrdermanagerUserorder saveCompSerOrderMg(OrdermanagerUserorder o) throws BusException;
}
