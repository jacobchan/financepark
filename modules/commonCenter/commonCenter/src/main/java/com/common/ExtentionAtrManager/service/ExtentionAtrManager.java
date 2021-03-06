package com.common.ExtentionAtrManager.service;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;

public interface ExtentionAtrManager extends BaseManager {
	/**Jack
	 * 根据商品获取会议室的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setMeetingRoomExtendValue(PurchasingmanagerCommodity commdity) throws BusException;
	/**
	 * 根据商品获取车辆的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setCarExtendValue(PurchasingmanagerCommodity commdity) throws BusException;
	/**
	 * 根据商品获取工位的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setGwExtendValue(PurchasingmanagerCommodity commdity) throws BusException;
	
	/**
	 * 根据商品获取创立方的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setClfExtendValue(PurchasingmanagerCommodity commdity) throws BusException;
	
	/**
	 * 根据商品获取代理记账扩展属性的内容
	 * @param commdity
	 * @throws BusException
	 */
	public void setAgencyBookExtendValue(PurchasingmanagerCommodity commdity)
			throws BusException;
	
	/**
	 * 根据商品获取广告位的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setMeetingLedExtendValue(PurchasingmanagerCommodity commdity)throws BusException;
	/**
	 * 根据商品获取法律服务扩展属性的内容
	 * @param commdity
	 * @throws BusException
	 */
	public void setLawserverExtendValue(PurchasingmanagerCommodity commdity)
			throws BusException;
	/**
	 * 根据会议室订单获取会议室订单的扩展属性的内容
	 * @param order
	 * @throws BusException
	 */
	public void setMeetingOrderExtendValue(OrdermanagerUserorder order)
			throws BusException;
	/**
	 * 根据车辆租赁订单获取订单的扩展属性的内容
	 * @param order
	 * @throws BusException
	 */
	public void setCarOrderExtendValue(OrdermanagerUserorder order)
			throws BusException;
	/**
	 * 根据广告位订单获取订单的扩展属性的内容
	 * @param order
	 * @throws BusException
	 */
	public void setAdsenseOrderExtendValue(OrdermanagerUserorder order)
			throws BusException;
}
