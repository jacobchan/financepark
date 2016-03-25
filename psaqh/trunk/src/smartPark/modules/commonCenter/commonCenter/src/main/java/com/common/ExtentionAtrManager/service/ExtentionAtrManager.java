package com.common.ExtentionAtrManager.service;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;

public interface ExtentionAtrManager extends BaseManager {
	/**Jack
	 * 根据商品获取会议室的扩张属性的内容
	 * @param commdity 商品
	 */
	public void setMeetingRoomExtendValue(PurchasingmanagerCommodity commdity) throws BusException;
}
