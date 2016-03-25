package com.common.ExtentionAtrManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.ExtentionAtrManager.entity.MeetingEntity;
import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.gsoft.framework.core.exception.BusException;

@Service("extentionAtrManagerImpl")
@Transactional
public class ExtentionAtrManagerImpl implements ExtentionAtrManager {
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
	
	/**Jack
	 * 根据商品获取会议室的扩张属性的内容
	 * @param commdity 商品
	 */
	public void setMeetingRoomExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		MeetingEntity mettingRoom = new MeetingEntity();
		mettingRoom.setAdr(this.getExtendValue(mettingRoom.getAdrfieldName(),commdity.getCommodityId()));
		mettingRoom.setGm(this.getExtendValue(mettingRoom.getGmfieldName(),commdity.getCommodityId()));
		mettingRoom.setLx(this.getExtendValue(mettingRoom.getLxfieldName(),commdity.getCommodityId()));
		mettingRoom.setTyy(this.getExtendValue(mettingRoom.getTyyfieldName(),commdity.getCommodityId()));
		commdity.setMeetingRoom(mettingRoom);
	}
	
	
	
	/**Jack
	 * 根据字段名称，和商品ID获取唯一的扩张属性值
	 * @param fieldName
	 * @param commdityId
	 * @return
	 */
	private String getExtendValue(String fieldName,String commdityId){
		return purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(fieldName, commdityId).getCommodityExtendContent();
	}

}
