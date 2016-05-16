package com.common.ExtentionAtrManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.ExtentionAtrManager.entity.AdsenseOrderEntity;
import com.common.ExtentionAtrManager.entity.AgencyBookEntity;
import com.common.ExtentionAtrManager.entity.Billboard;
import com.common.ExtentionAtrManager.entity.CarEntity;
import com.common.ExtentionAtrManager.entity.CarOrderEntity;
import com.common.ExtentionAtrManager.entity.ClfEntity;
import com.common.ExtentionAtrManager.entity.GwEntity;
import com.common.ExtentionAtrManager.entity.LawserverEntity;
import com.common.ExtentionAtrManager.entity.MeetingEntity;
import com.common.ExtentionAtrManager.entity.MeetingOrderEntity;
import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.gsoft.framework.codemap.dao.CodeitemDao;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.core.exception.BusException;

@Service("ExtentionAtrManager")
@Transactional
public class ExtentionAtrManagerImpl implements ExtentionAtrManager {
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
	@Autowired
	private OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager;
	@Autowired
	private CodeitemDao<Codeitem, String> codeItemDao;
	
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
	 * 根据商品获取创立方的扩展属性的内容
	 * @param commdity 商品
	 */
	public void setClfExtendValue(PurchasingmanagerCommodity commdity)throws BusException{
		ClfEntity clf = new ClfEntity();
		clf.setAdr(this.getExtendValue(clf.getAdrfieldName(),commdity.getCommodityId()));
		commdity.setClf(clf);;
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
		billboard.setAdr(this.getExtendValue(billboard.getAdrfieldName(),commdity.getCommodityId()));
		commdity.setBillboard(billboard);
	}
	
	/**
	 * 根据会议室订单获取会议室订单的扩展属性的内容
	 */
	@Override
	public void setMeetingOrderExtendValue(OrdermanagerUserorder order)throws BusException{
		MeetingOrderEntity mettingOrder = new MeetingOrderEntity();
		mettingOrder.setPublicResoIdDate(this.getOrderExtendValue(mettingOrder.getPublicResoIdDatefieldName(), order.getUserorderId()));
		String timeStr = this.getOrderExtendValue(mettingOrder.getPublicResoIdTimefieldName(), order.getUserorderId());
		String[] timeStrs = timeStr.split(",");
		StringBuffer buff = new StringBuffer();
		for(int i = 0;i<timeStrs.length;i++){
			String ss = timeStrs[i];
			buff.append(getTimeStr(ss));
			if(i+1 < timeStrs.length){
				buff.append(",");
			}
		}
		mettingOrder.setPublicResoIdTime(buff.toString());
		mettingOrder.setPublicResoId(this.getOrderExtendValue(mettingOrder.getPublicResoIdfieldName(), order.getUserorderId()));
		mettingOrder.setDriver(this.getOrderExtendValue(mettingOrder.getDriverfieldName(), order.getUserorderId()));
		mettingOrder.setTea(this.getOrderExtendValue(mettingOrder.getTeafieldName(), order.getUserorderId()));
		order.setMettingOrder(mettingOrder);
	}
	
	public String getTimeStr(String ss){
		String str = "";
		List<Codeitem> codeitemList = codeItemDao.getList("codemap.code", "resoTime");//可用时段
    	for(int y = 0;y<codeitemList.size();y++){
   			Codeitem codeitem = codeitemList.get(y);
   			if(codeitem.getItemValue().equals(ss)){
   				str = codeitem.getItemCaption();
   			}
   		} 
    	return str;
	}
	
	/**
	 * 根据车辆租赁订单获取订单的扩展属性的内容
	 */
	@Override
	public void setCarOrderExtendValue(OrdermanagerUserorder order)throws BusException{
		CarOrderEntity carOrder = new CarOrderEntity();
		carOrder.setPublicResoIdDate(this.getOrderExtendValue(carOrder.getPublicResoIdDatefieldName(), order.getUserorderId()));
		carOrder.setPublicResoId(this.getOrderExtendValue(carOrder.getPublicResoIdfieldName(), order.getUserorderId()));
		order.setCarOrder(carOrder);
	}
	/**
	 * 根据广告位订单获取订单的扩展属性的内容
	 */
	@Override
	public void setAdsenseOrderExtendValue(OrdermanagerUserorder order)throws BusException{
		AdsenseOrderEntity adsenseOrder = new AdsenseOrderEntity();
		adsenseOrder.setPublicResoIdDate(this.getOrderExtendValue(adsenseOrder.getPublicResoIdDatefieldName(), order.getUserorderId()));
		adsenseOrder.setPublicResoId(this.getOrderExtendValue(adsenseOrder.getPublicResoIdfieldName(), order.getUserorderId()));
		order.setAdsenseOrder(adsenseOrder);
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
		if( null!= purExtend){
			extendValue=purExtend.getCommodityExtendContent();
		}
		
		return extendValue !=null?extendValue:"";
	}
	/**Jack
	 * 根据字段名称，和订单ID获取订单唯一的扩展属性值
	 * @param fieldName
	 * @param commdityId
	 * @return
	 */
	private String getOrderExtendValue(String fieldName,String orderId){
		OrdermanagerOrderprojecttypeValue oovExtend = ordermanagerOrderprojecttypeValueManager.getOovExtend(fieldName, orderId);
		String extendValue = "";
		if( null!= oovExtend){
			extendValue=oovExtend.getOrderprojecttypeValueFieldValue();
		}
		
		return extendValue !=null?extendValue:"";
	}

}
