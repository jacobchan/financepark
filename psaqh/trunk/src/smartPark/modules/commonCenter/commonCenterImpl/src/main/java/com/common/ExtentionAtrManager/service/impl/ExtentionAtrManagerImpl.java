package com.common.ExtentionAtrManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.ExtentionAtrManager.entity.AgencyBookEntity;
import com.common.ExtentionAtrManager.entity.Billboard;
import com.common.ExtentionAtrManager.entity.CarEntity;
import com.common.ExtentionAtrManager.entity.GwEntity;
import com.common.ExtentionAtrManager.entity.LawserverEntity;
import com.common.ExtentionAtrManager.entity.MeetingEntity;
import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.gsoft.framework.core.exception.BusException;

@Service("ExtentionAtrManager")
@Transactional
public class ExtentionAtrManagerImpl implements ExtentionAtrManager {
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
	
	/**Jack
	 * 根据商品获取会议室的扩展属性的内容
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
	
	/**
	 * 根据商品获取车辆的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setCarExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		CarEntity car = new CarEntity();
		car.setDw(this.getExtendValue(car.getDwfieldName(),commdity.getCommodityId()));
		car.setZw(this.getExtendValue(car.getZwfieldName(),commdity.getCommodityId()));
		car.setChepai(this.getExtendValue(car.getCpfieldName(),commdity.getCommodityId()));
		commdity.setCar(car);
	}
	
	/**
	 * 根据商品获取工位的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setGwExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		GwEntity gw = new GwEntity();
		gw.setCommodityId(this.getExtendValue(gw.getCommodityIdfieldName(),commdity.getCommodityId()));
		commdity.setGw(gw);
	}
	/**
	 * 根据商品获取代理记账扩展属性的内容
	 * @param commdity 商品
	 */
	@Override
	public void setAgencyBookExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		AgencyBookEntity agencyBook = new AgencyBookEntity();
		agencyBook.setServiceTerm(getExtendValue(agencyBook.getServiceTermfieldName(),commdity.getCommodityId()));
		commdity.setAgencyBook(agencyBook);
	}
	
	/**
	 * 根据商品获取法律服务扩展属性的内容
	 * @param commdity 商品
	 */
	@Override
	public void setLawserverExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		LawserverEntity lawserver = new LawserverEntity();
		lawserver.setSerTerm(getExtendValue(lawserver.getSerTermfieldName(),commdity.getCommodityId()));
		commdity.setLawserver(lawserver);
	}
	/**
	 * 根据商品获取广告位的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setMeetingLedExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		Billboard billboard = new Billboard();
		//获取广告位尺寸
		String size = billboard.getSizefieldName();
		size = this.getExtendValue(size,commdity.getCommodityId());
		billboard.setSize(size);
		//获取广告位轮播方式
		String loopTypeName = billboard.getLoopTypefieldName();
		String loopType = this.getExtendValue(loopTypeName,commdity.getCommodityId());
		billboard.setLoopType(loopType);
		//获取广告位轮播单位
		String unitName = billboard.getUnitfieldName();
		String unit = this.getExtendValue(unitName,commdity.getCommodityId());
		billboard.setUnit(unit);
		commdity.setBillboard(billboard);
	}
	
	
	
	/**Jack
	 * 根据字段名称，和商品ID获取唯一的扩展属性值
	 * @param fieldName
	 * @param commdityId
	 * @return
	 */
	private String getExtendValue(String fieldName,String commdityId){
		PurchasingmanagerCommodityExtend purExtend = purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(fieldName, commdityId);
		String extendValue = "";
		if(purExtend != null){
			extendValue=purExtend.getCommodityExtendContent();
		}
		
		return extendValue !=null?extendValue:"";
	}

}
