/**
 * 代码声明
 */
package com.member.shoppingCarManager.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.member.shoppingCarManager.entity.ShoppingcarCompanyserver;
import com.member.shoppingCarManager.dao.ShoppingcarCompanyserverDao;
import com.member.shoppingCarManager.service.ShoppingcarCompanyserverManager;

@Service("shoppingcarCompanyserverManager")
@Transactional
public class ShoppingcarCompanyserverManagerImpl extends BaseManagerImpl implements ShoppingcarCompanyserverManager{
	@Autowired
	private ShoppingcarCompanyserverDao shoppingcarCompanyserverDao;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private OrdermanagerCommoditydetailManager ordermanagerCommoditydetailManager;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers() throws BusException{
    	return shoppingcarCompanyserverDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers(
    	@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarCompanyserverDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver getShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
    	return shoppingcarCompanyserverDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarCompanyservers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarCompanyserverDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver saveShoppingcarCompanyserver(ShoppingcarCompanyserver o) throws BusException{
//    	String shoppingcarCompanyserverId = o.getShoppingcarCompanyserverId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarCompanyserverId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarCompanyserverDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id) throws BusException{
    	shoppingcarCompanyserverDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarCompanyservers(@ServiceParam(name="companyServerId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarCompanyserver(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
		return shoppingcarCompanyserverDao.exists(id);
	}
    
    public boolean exsitShoppingcarCompanyserver(String propertyName,Object value) throws BusException{
		return shoppingcarCompanyserverDao.exists(propertyName,value);
	}
    
    /**
	 * 新增企业服务订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveCompSerOrder(OrdermanagerUserorder o,
			List<ShoppingcarCompanyserver> shopCarList) throws BusException {
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(shopCarList.get(0).getCommodityId().getGenreId());
		while(pg.getGenreId() != null){//获取最顶级商品类别
			pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pg.getGenreId());
		}
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("QYFW"));
		o.setUserorderStatus("01");//01-未支付
		o = ordermanagerUserorderManager.saveOrdermanagerUserorder(o);
		for(ShoppingcarCompanyserver shopCar:shopCarList){//保存订单明细
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
//			orderDetail.setOrdermanagerUserorder(order);
			orderDetail.setOrderId(o.getUserorderId());
			orderDetail.setCommodityId(shopCar.getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		}
		return o;
	}
    /**
	 * 新增威客服务订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveWKserviceOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@DomainCollection(domainClazz=ShoppingcarCompanyserver.class) List<ShoppingcarCompanyserver> shopCarList) throws BusException {
		if(shopCarList.size() == 0){
			throw new BusException("购物车不能为空！");
		}
		if(StringUtils.isEmpty(userId)){
			throw new BusException("请登陆后购买！");
		}
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		ShoppingcarCompanyserver scs = shoppingcarCompanyserverDao.get(shopCarList.get(0).getCompanyServerId());
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(scs.getCommodityId().getGenreId());
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("WKFW"));
		order.setUserorderStatus("01");//01-未支付
		BigDecimal userorderAmoun = BigDecimal.valueOf(0);
    	for(ShoppingcarCompanyserver shopCar:shopCarList){//计算订单金额
    		shopCar = shoppingcarCompanyserverDao.get(shopCar.getCompanyServerId());
    		userorderAmoun = userorderAmoun.add(shopCar.getCommodityId().getCommodityPrice().
    				multiply(new BigDecimal(shopCar.getCompanyCateringNum())));
    	}
		order.setUserorderAmount(userorderAmoun);
		if(StringUtils.isNotEmpty(userId)){
			order.setMemberId(userId);
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
   		order.setUserorderProject(pg.getGenreName());
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderManager.saveOrdermanagerUserorder(order);
		for(ShoppingcarCompanyserver shopCar:shopCarList){//保存订单明细
			shopCar = shoppingcarCompanyserverDao.get(shopCar.getCompanyServerId());
			OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
//			orderDetail.setOrdermanagerUserorder(order);
			orderDetail.setOrderId(order.getUserorderId());
			orderDetail.setCommodityId(shopCar.getCommodityId());
			orderDetail.setCommoditydetailNum(shopCar.getCompanyCateringNum());
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
			shoppingcarCompanyserverDao.remove(shopCar.getCompanyServerId());
		}
		return order;
	}
    //查询当前用户的购物车列表
    @Override
    @EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShopCarList(
    		@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="genreCode") String genreCode){
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", genreCode);
    	String[] aa = {"memberId.memberId","commodityId.genreId"};
    	String[] bb = {userId,pg.getGenreId()};
    	List<ShoppingcarCompanyserver> shopCarLis = shoppingcarCompanyserverDao.getList(aa, bb);
    	return shopCarLis;
    }
    //修改购物车
    @Override
    @EsbServiceMapping
    public ShoppingcarCompanyserver modifyShopCar(
    		@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="id") String id,
    		@ServiceParam(name="num") String num){
    	ShoppingcarCompanyserver shopCar = shoppingcarCompanyserverDao.get(id);
    	BigDecimal big_num = new BigDecimal(num);
    	BigDecimal shopCarAmount = big_num.multiply(shopCar.getCommodityId().getCommodityPrice());
    	shopCar.setCompanyCateringNum(num);
    	shopCar.setCompanyCateringUnivalence(shopCarAmount);
		shopCar.setUpdateUser(userId);
		shopCar.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	return shoppingcarCompanyserverDao.save(shopCar);
    }
    //删除购物车
    @Override
    @EsbServiceMapping
    public void delShopCar(
    		@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="id") String id){
    	shoppingcarCompanyserverDao.remove(id);
    }
    /**
	 * 添加购物车
	 */
    @Override
    @EsbServiceMapping
	public ShoppingcarCompanyserver addShoppingcarCompanyserver(
			@ServiceParam(name="userId",pubProperty="userId") String userId,
			@ServiceParam(name="commodityId") String commodityId) throws BusException {
    	if(StringUtils.isEmpty(userId)){
    		throw new BusException("用户未登录，不能添加购物车！");
    	}
    	PurchasingmanagerCommodity purCommodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
    	String[] aa = {"memberId.memberId","commodityId.commodityId"};
    	String[] bb = {userId,commodityId};
    	List<ShoppingcarCompanyserver> shopCarLis = shoppingcarCompanyserverDao.getList(aa, bb);
    	if(shopCarLis.size()>0){
    		ShoppingcarCompanyserver shopCar = shopCarLis.get(0);
    		String num = shopCar.getCompanyCateringNum();
    		int i = Integer.parseInt(num)+1;	
			shopCar.setCompanyCateringNum(String.valueOf(i));
			BigDecimal shopCarAmount = shopCar.getCompanyCateringUnivalence().add((purCommodity.getCommodityPrice()));
			shopCar.setCompanyCateringUnivalence(shopCarAmount);
			shopCar.setUpdateUser(userId);
			shopCar.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			return shoppingcarCompanyserverDao.save(shopCar);
    	}else{
    		ShoppingcarCompanyserver shopCar = new ShoppingcarCompanyserver();
    		shopCar.setCommodityId(purCommodity);
    		MemberInformation memberId = memberInformationManager.getMemberInformation(userId);
    		shopCar.setMemberId(memberId);
    		shopCar.setCompanyCateringNum("1");
    		shopCar.setCompanyCateringUnivalence(purCommodity.getCommodityPrice());
    		shopCar.setCreateUser(userId);
    		shopCar.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		shopCar.setUpdateUser(userId);
			shopCar.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return shoppingcarCompanyserverDao.save(shopCar);
    	}
	}

}
