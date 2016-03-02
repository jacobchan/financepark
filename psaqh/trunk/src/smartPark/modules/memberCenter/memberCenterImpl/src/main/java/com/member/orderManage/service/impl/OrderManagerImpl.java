/**
 * 代码声明
 */
package com.member.orderManage.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.member.orderManager.service.OrderManager;
import com.member.shoppingCarManager.entity.ShoppingcarGroup;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerCommoditydetailDao;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeValueDao;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.purchasingManager.dao.PurchasingmanagerGenreDao;
import com.common.purchasingManager.dao.PurchasingmanagerGenrePropertyDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;

@Service("orderManager")
@Transactional
public class OrderManagerImpl extends BaseManagerImpl implements OrderManager{
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private OrdermanagerCommoditydetailDao ordermanagerCommoditydetailDao;
	@Autowired
	private PurchasingmanagerGenrePropertyDao purchasingmanagerGenrePropertyDao;
	@Autowired
	private OrdermanagerOrderprojecttypeValueDao ordermanagerOrderprojecttypeValueDao;
	@Autowired
	private PurchasingmanagerGenreDao purchasingmanagerGenreDao;
	
	/**
	 * 新增采购订单
	 */
	@Override
	public OrdermanagerUserorder savePurOrdermanager(OrdermanagerUserorder o,
			List<ShoppingcarGroup> shopCarList) throws BusException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 新增餐饮订单
	 */
	@Override
	public OrdermanagerUserorder saveFoodOrdermanager(OrdermanagerUserorder o)
			throws BusException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 新增公共资源订单
	 */
	@Override
	public OrdermanagerUserorder savePublicResoOrder(OrdermanagerUserorder o,
			PurchasingmanagerCommodity commodity,
			List<PublicutilitiesmanagerReso> publicResoList) throws BusException {
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		o.setGenreId(commodity.getPurchasingmanagerGenre());
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GGZY"));
		o.setUserorderStatus("01");//01-未支付
		o.setCreateUser(user.getUserId());
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUpdateUser(user.getUserId());
		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUserorderBuyUser(user.getUserCaption());
		o.setMemberId(user.getUserId());
		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o = ordermanagerUserorderDao.save(o);
		//保存订单明细列表
		List<OrdermanagerCommoditydetail> orderDetailList = new ArrayList<OrdermanagerCommoditydetail>();
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
		orderDetail.setOrdermanagerUserorder(o);
		orderDetail.setCommodityId(commodity.getCommodityId());
		orderDetail.setCommoditydetailNum("1");
		orderDetail = ordermanagerCommoditydetailDao.save(orderDetail);
		orderDetailList.add(orderDetail);
		o.setOrderDetailList(orderDetailList);
		//保存订单扩展属性列表
		List<OrdermanagerOrderprojecttypeValue> orderExtendList = new ArrayList<OrdermanagerOrderprojecttypeValue>();
		PurchasingmanagerGenre pg = commodity.getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
			pg = pg.getPurchasingmanagerGenre();
		}
		String dateStr =  "";
		StringBuffer timeStrBuff =  new StringBuffer();
		for(PublicutilitiesmanagerReso publicReso:publicResoList){
			dateStr = publicReso.getResoDate();
			timeStrBuff.append(publicReso.getResoTime());
			timeStrBuff.append(",");
		}
		List<PurchasingmanagerGenreProperty> genrePropertyList = purchasingmanagerGenrePropertyDao.getList("purchasingmanagerGenre.genreId", pg.getGenreId());
		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){
			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
			orderExtendValue.setOrdermanagerUserorder(o);
			orderExtendValue.setGenrePropertyId(genreProperty);
			if("orderDate".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(dateStr);
			}else if("orderTime".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(timeStrBuff.toString());
			}
			orderExtendValue = ordermanagerOrderprojecttypeValueDao.save(orderExtendValue);
			orderExtendList.add(orderExtendValue);
		}
		
		o.setOrderExtendList(orderExtendList);
		return o;
	}
	/**
	 * 新增物业报修订单
	 */
	@Override
	public OrdermanagerUserorder savePropertyBxOrder(OrdermanagerUserorder o,
			PropertyservicemanagerBx propertyBx) throws BusException {
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.getList("genreCode", "07").get(0);
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("WYBX"));
		o.setUserorderStatus("01");//01-未支付
		o.setCreateUser(user.getUserId());
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUpdateUser(user.getUserId());
		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUserorderBuyUser(user.getUserCaption());
		o.setMemberId(user.getUserId());
		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o = ordermanagerUserorderDao.save(o);
		//保存订单扩展属性列表
		List<OrdermanagerOrderprojecttypeValue> orderExtendList = new ArrayList<OrdermanagerOrderprojecttypeValue>();
		List<PurchasingmanagerGenreProperty> genrePropertyList = purchasingmanagerGenrePropertyDao.getList("purchasingmanagerGenre.genreId", pg.getGenreId());
		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){
			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
			orderExtendValue.setOrdermanagerUserorder(o);
			orderExtendValue.setGenrePropertyId(genreProperty);
			if("orderBxId".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(propertyBx.getBxId());
			}
			orderExtendList.add(orderExtendValue);
		}
		o.setOrderExtendList(orderExtendList);
		return o;
	}
    /**
//     * 保存或修改采购订单
//     */
//	@Override
//	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "params.userId")})
//	public OrdermanagerUserorder savePurOrdermanager(OrdermanagerUserorder o,List<ShoppingcarGroup> shopCarList)
//			throws BusException {
//    	String ordermanagerUserorderId = o.getUserorderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
//    	if(!isUpdate){//新增
//    		PurchasingmanagerGenre pg = shopCarList.get(0).getCommodityId().getPurchasingmanagerGenre();
//    		while(pg.getGenreCode() == null){
//    			pg = pg.getPurchasingmanagerGenre();
//    		}
//    		o.setGenreId(pg);
//    		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
//    		o.setUserorderStatus("01");//01-未支付
//    		o.setCreateUser(o.getUpdateUser());
//    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
//    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
//    		if(o.getUpdateUser() != null){
//    			MemberInformation mem = memberInformationDao.get(o.getUpdateUser()); //获取当前登录用户
//        		o.setUserorderBuyUser(mem.getMemberName());
//    		}
//    		o.setMemberId(o.getUpdateUser());
//    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
//    		return ordermanagerUserorderDao.save(o);
//    	}else{
//    		throw new BusException("订单不能修改!");
//    	}
//	}
}
