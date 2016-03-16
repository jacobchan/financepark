/**
 * 代码声明
 */
package com.common.OrderManager.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;

@Service("ordermanagerUserorderManager")
@Transactional
public class OrdermanagerUserorderManagerImpl extends BaseManagerImpl implements OrdermanagerUserorderManager{
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	@Autowired
	private OrdermanagerCommoditydetailManager ordermanagerCommoditydetailManager;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders() throws BusException{
    	return ordermanagerUserorderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders(
    	@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerUserorderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerUserorder getOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
    	return ordermanagerUserorderDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerUserorders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存订单
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public OrdermanagerUserorder saveOrdermanagerUserorder(OrdermanagerUserorder o) throws BusException{
    	String userorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(userorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder order = ordermanagerUserorderDao.get(userorderId);
    		if(o.getUserorderAmount() != null){
    			order.setUserorderAmount(o.getUserorderAmount());
    		}
    		if(o.getUserorderStatus() != null){
    			order.setUserorderStatus(o.getUserorderStatus());
    		}
    		order.setUpdateUser(o.getUpdateUser());
    		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(order);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setMemberId(o.getUpdateUser());
    		if(StringUtils.isNotEmpty(o.getUpdateUser())){
    			MemberInformation mem = memberInformationManager.getMemberInformation(o.getUpdateUser());
    			o.setUserorderBuyUser(mem.getMemberName());
    		}
    		return ordermanagerUserorderDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerUserorder(@ServiceParam(name="userorderId") String id) throws BusException{
    	ordermanagerUserorderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerUserorders(@ServiceParam(name="userorderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerUserorder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
		return ordermanagerUserorderDao.exists(id);
	}
    
    public boolean exsitOrdermanagerUserorder(String propertyName,Object value) throws BusException{
		return ordermanagerUserorderDao.exists(propertyName,value);
	}
    /**
	 * 获取企业服务订单列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerComSerOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("ordermanagerOrdertype.ordertypeId", Condition.LIKE, "05"));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	/**
	 * 新增IT服务订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveITSerOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@ServiceParam(name="commodityId") String commodityId) throws BusException {
    	PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
		PurchasingmanagerGenre pg = commodity.getPurchasingmanagerGenre();
		while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
			pg = pg.getPurchasingmanagerGenre();
		}
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(commodity.getCommodityPrice());
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("ITFW"));
		order.setUserorderStatus("01");//01-未支付
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
		orderDetail.setOrdermanagerUserorder(order);
		orderDetail.setCommodityId(commodity);
		orderDetail.setCommoditydetailNum("1");
		ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		return order;
	}
    
    /**
	 * 新增工商变更订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveComChangeOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
    	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
    	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
    		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
    		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
    				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
    	}
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("0502");
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(userorderAmoun);
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GSBG"));
		order.setUserorderStatus("01");//01-未支付
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
			orderDetail.setOrdermanagerUserorder(order);
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		}
		return order;
	}
    /**
	 * 新增公司注册订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveComReisterOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
    	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
    	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
    		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
    		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
    				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
    	}
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("0501");
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(userorderAmoun);
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GSZC"));
		order.setUserorderStatus("01");//01-未支付
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
			orderDetail.setOrdermanagerUserorder(order);
			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		}
		return order;
	}
    /**
   	 * 新增代理记账订单
   	 */
    @Override
    @EsbServiceMapping
   	public OrdermanagerUserorder saveAgencyOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
   			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
       	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
       	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
       		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
       		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
       				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
       	}
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("0504");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("DLJZ"));
   		order.setUserorderStatus("01");//01-未支付
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
   			orderDetail.setOrdermanagerUserorder(order);
   			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
   		}
   		return order;
   	}
    /**
   	 * 新增法律服务订单
   	 */
    @Override
    @EsbServiceMapping
   	public OrdermanagerUserorder saveLawSerOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
   			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
       	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
       	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
       		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
       		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
       				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
       	}
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("0505");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("FLFW"));
   		order.setUserorderStatus("01");//01-未支付
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
   			orderDetail.setOrdermanagerUserorder(order);
   			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
   		}
   		return order;
   	}
    /**
   	 * 新增商标专利订单
   	 */
    @Override
    @EsbServiceMapping
   	public OrdermanagerUserorder saveChopPatentOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
   			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
       	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
       	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
       		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
       		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
       				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
       	}
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("0506");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("SBZL"));
   		order.setUserorderStatus("01");//01-未支付
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
   			orderDetail.setOrdermanagerUserorder(order);
   			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
   		}
   		return order;
   	}
}
