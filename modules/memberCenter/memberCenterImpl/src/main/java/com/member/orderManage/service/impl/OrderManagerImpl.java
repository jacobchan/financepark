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
import com.manage.PublicUtilitiesManager.service.PublicutilitiesmanagerResoManager;
import com.member.orderManager.service.OrderManager;
import com.member.shoppingCarManager.entity.ShoppingcarCatering;
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
	@Autowired
	private PublicutilitiesmanagerResoManager publicutilitiesmanagerResoManager;
	
	/**
	 * 新增采购订单
	 */
	public OrdermanagerUserorder savePurOrder(OrdermanagerUserorder o,
			List<ShoppingcarGroup> shopCarList) throws BusException {
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		PurchasingmanagerGenre pg = shopCarList.get(0).getCommodityId().getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){
			pg = pg.getPurchasingmanagerGenre();
		}
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
		o.setUserorderStatus("01");//01-未支付
		o.setCreateUser(user.getUserId());
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUpdateUser(user.getUserId());
		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUserorderBuyUser(user.getUserCaption());
		o.setMemberId(user.getUserId());
		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o = ordermanagerUserorderDao.save(o);
		for(ShoppingcarGroup shopCar:shopCarList){//保存订单明细
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
			orderDetail.setOrdermanagerUserorder(o);
			orderDetail.setCommodityId(shopCar.getCommodityId().getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailDao.save(orderDetail);
		}
		return o;
	}
	/**
	 * 新增餐饮订单
	 */
	@Override
	public OrdermanagerUserorder saveFoodOrder(OrdermanagerUserorder o,
			List<ShoppingcarCatering> shopCarList) throws BusException {
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		PurchasingmanagerGenre pg = shopCarList.get(0).getCommodityId().getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){
			pg = pg.getPurchasingmanagerGenre();
		}
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CY"));
		o.setUserorderStatus("01");//01-未支付
		o.setCreateUser(user.getUserId());
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUpdateUser(user.getUserId());
		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setUserorderBuyUser(user.getUserCaption());
		o.setMemberId(user.getUserId());
		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o = ordermanagerUserorderDao.save(o);
		for(ShoppingcarCatering shopCar:shopCarList){//保存订单明细
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
			orderDetail.setOrdermanagerUserorder(o);
			orderDetail.setCommodityId(shopCar.getCommodityId().getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailDao.save(orderDetail);
		}
		return o;
	}
	/**
	 * 新增公共资源订单
	 */
	@Override
	public OrdermanagerUserorder savePublicResoOrder(OrdermanagerUserorder o,
			PurchasingmanagerCommodity commodity,
			List<PublicutilitiesmanagerReso> publicResoList) throws BusException {
		publicResoList = publicutilitiesmanagerResoManager.savePublicutilitiesmanagerResoList(publicResoList);
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
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
		orderDetail.setOrdermanagerUserorder(o);
		orderDetail.setCommodityId(commodity.getCommodityId());
		orderDetail.setCommoditydetailNum("1");
		ordermanagerCommoditydetailDao.save(orderDetail);
		//保存订单扩展属性列表
		PurchasingmanagerGenre pg = commodity.getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
			pg = pg.getPurchasingmanagerGenre();
		}
		StringBuffer publicResoIdBuff =  new StringBuffer();//公共资源ID
		String dateStr =  "";//订单预定日期
		StringBuffer timeStrBuff =  new StringBuffer();//订单预定时段
		for(int i = 0;i<publicResoList.size();i++){
			PublicutilitiesmanagerReso publicReso = publicResoList.get(i);
			dateStr = publicReso.getResoDate();
			timeStrBuff.append(publicReso.getResoTime());
			publicResoIdBuff.append(publicReso.getResoId());
			if(i+1<publicResoList.size()){
				timeStrBuff.append(",");
				publicResoIdBuff.append(",");
			}
		}
		List<PurchasingmanagerGenreProperty> genrePropertyList = purchasingmanagerGenrePropertyDao.getList("purchasingmanagerGenre.genreId", pg.getGenreId());
		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){//保存订单扩展项信息
			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
			orderExtendValue.setOrdermanagerUserorder(o);
			orderExtendValue.setGenrePropertyId(genreProperty);
			if("publicResoIdDate".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(dateStr);
			}else if("publicResoIdTime".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(timeStrBuff.toString());
			}else if("publicResoId".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(publicResoIdBuff.toString());
			}
			ordermanagerOrderprojecttypeValueDao.save(orderExtendValue);
		}
		
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
		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){//保存订单扩展项信息
			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
			orderExtendValue.setOrdermanagerUserorder(o);
			orderExtendValue.setGenrePropertyId(genreProperty);
			if("orderBxId".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(propertyBx.getBxId());
			}
			orderExtendList.add(orderExtendValue);
		}
		return o;
	}
}
