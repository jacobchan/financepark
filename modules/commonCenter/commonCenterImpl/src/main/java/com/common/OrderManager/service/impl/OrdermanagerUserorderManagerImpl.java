/**
getPagerPend_query * 代码声明
 */
package com.common.OrderManager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.common.wxpay.protocol.UnifiedOrderReqData;
import com.common.wxpay.service.WxPayManager;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.codemap.dao.CodeitemDao;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.DomainCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;

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
	@Autowired
	private PurchasingmanagerGenrePropertyManager purchasingmanagerGenrePropertyManager;
	@Autowired
	private OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager;
	@Autowired
	private CodeitemDao<Codeitem, String> codeItemDao;
	@Autowired
	private ExtentionAtrManager extentionAtrManager;
	@Autowired
	private WxPayManager wxPayManager;
	
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
     * 分页查询公共资源的订单
     */
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerUserordersForPublic(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		
		//查询属于公共资源的的所有商品:genreCode= 03
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,"03"));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
		String genreId="";
//		List<String> list = new ArrayList<String>();
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		condition.clear();
		condition.add(ConditionUtils.getCondition("pagrenId",Condition.EQUALS,genreId));
		purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null);
		int i=0;
		String[] genreIdArray=new String[purchasingmanagerGenreList.size()];
		for(PurchasingmanagerGenre pg:purchasingmanagerGenreList){
			String genreIds=pg.getGenreId();
//			list.add(genreIds);
			genreIdArray[i]=genreIds;
			i++;
		}
		conditions.add(ConditionUtils.getCondition("genreId.genreId",Condition.IN,genreIdArray));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存订单
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId")})
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
    		//order.setMemberId(o.getUpdateUser());
    		order.setUpdateUser(o.getUpdateUser());
    		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(order);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		//o.setMemberId(o.getUpdateUser());
    		if(StringUtils.isNotEmpty(o.getMemberId())){
    			MemberInformation mem = memberInformationManager.getMemberInformation(o.getMemberId());
    			o.setUserorderBuyUser(mem.getMemberName());
    		}
    		return ordermanagerUserorderDao.save(o);
    	}
    }
	
	/**
	 * 分页查询用户订单表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public PagerRecords getUserorder(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="genreCode") String genreCode) throws BusException{
		//查询商品类别
		Collection<Condition> conditionP = new ArrayList<Condition>();
		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
		//查询用户订单表(where=订单项目,商品类别ID)
		if(purchasingmanagerGenreList.size()>0){
			System.out.println(purchasingmanagerGenreList.get(0).getGenreId());
			System.out.println(purchasingmanagerGenreList.get(0).getGenreName());
			conditions.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,purchasingmanagerGenreList.get(0)));
			conditions.add(ConditionUtils.getCondition("userorderProject",Condition.EQUALS,purchasingmanagerGenreList.get(0).getGenreName()));
		}
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	/**
     * 修改订单
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public OrdermanagerUserorder saveOrder(OrdermanagerUserorder o) throws BusException{
    	String userorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(userorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder order = ordermanagerUserorderDao.get(userorderId);
    		order.setUserorderProject(o.getUserorderProject());
    		order.setUserorderAmount(o.getUserorderAmount());
    		order.setUserorderStatus(o.getUserorderStatus());
    		order.setUserorderPayMode(o.getUserorderPayMode());
    		if(o.getGenreId() != null){
    			order.setGenreId(o.getGenreId());
    		}
    		order.setUpdateUser(o.getUpdateUser());
    		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(order);
    	}
		return o;
    }
	
	/**
     * 保存订单
     */
	@Override
	@EsbServiceMapping
    public OrdermanagerUserorder saveUserOrder(OrdermanagerUserorder o) throws BusException{
		return ordermanagerUserorderDao.save(o);
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
		List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getCompSerOrderTypes("");
		List<String> genreIdList = new ArrayList<String>();
		for(PurchasingmanagerGenre pg:pgList){
			genreIdList.add(pg.getGenreId());
		}
		String[] buff = (String[])genreIdList.toArray(new String[genreIdList.size()]);
		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	/**
	 * 获取公共资源订单列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPublicResoOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getPublicResoOrderTypes("");
		List<String> genreIdList = new ArrayList<String>();
		for(PurchasingmanagerGenre pg:pgList){
			genreIdList.add(pg.getGenreId());
		}
		String[] buff = (String[])genreIdList.toArray(new String[genreIdList.size()]);
		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	/**
	 * 获取采购商品订单列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPurOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("genreId.genreCode", Condition.EQUALS, "01"));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	/**
	 * 新增IT服务订单
	 */
    @Override
    @EsbServiceMapping
	public OrdermanagerUserorder saveITSerOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@ServiceParam(name="commodityId") String commodityId,@ServiceParam(name="faultDes") String faultDes,
			@ServiceParam(name="userorderAdr") String userorderAdr) throws BusException {
    	PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(commodity.getGenreId());
		//根据类别ID获取类别扩展属性列表
		List<PurchasingmanagerGenreProperty> pgpList = purchasingmanagerGenrePropertyManager.getPurGenrePropertysByGenre(pg.getGenreId());
		while(pg.getGenreCode() != null){//获取有类别编码的上级商品类别
			pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pg.getPagrenId());
		}
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(commodity.getCommodityPrice());
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("ITFW"));
		order.setUserorderStatus("01");//01-未支付
		order.setUserorderAdr(userorderAdr);
		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
//		orderDetail.setOrdermanagerUserorder(order);
		orderDetail.setOrderId(order.getUserorderId());
		orderDetail.setCommodityId(commodity);
		orderDetail.setCommoditydetailNum("1");
		ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		
		for(PurchasingmanagerGenreProperty pgp:pgpList){
			if("faultDes".equals(pgp.getGenrePropertyFieldName())){
				OrdermanagerOrderprojecttypeValue orderExc = new OrdermanagerOrderprojecttypeValue();
				orderExc.setOrdermanagerUserorder(order);
				orderExc.setGenrePropertyId(pgp);
				orderExc.setOrderprojecttypeValueFieldValue(faultDes);
				ordermanagerOrderprojecttypeValueManager.saveOrdermanagerOrderprojecttypeValue(orderExc);
			}
		}
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
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0502");
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(userorderAmoun);
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GSBG"));
		order.setUserorderStatus("01");//01-未支付
		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//			orderDetail.setOrdermanagerUserorder(order);
			orderDetail.setOrderId(order.getUserorderId());
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
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0501");
		OrdermanagerUserorder order = new OrdermanagerUserorder();
		order.setUserorderAmount(userorderAmoun);
		order.setGenreId(pg);
		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GSZC"));
		order.setUserorderStatus("01");//01-未支付
		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setCreateUser(userId);
		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order.setUpdateUser(userId);
		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		order = ordermanagerUserorderDao.save(order);
		
		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//			orderDetail.setOrdermanagerUserorder(order);
			orderDetail.setOrderId(order.getUserorderId());
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
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0504");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("DLJZ"));
   		order.setUserorderStatus("01");//01-未支付
   		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
   		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//   			orderDetail.setOrdermanagerUserorder(order);
   			orderDetail.setOrderId(order.getUserorderId());
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
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0505");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("FLFW"));
   		order.setUserorderStatus("01");//01-未支付
   		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
   		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//   			orderDetail.setOrdermanagerUserorder(order);
   			orderDetail.setOrderId(order.getUserorderId());
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
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0506");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("SBZL"));
   		order.setUserorderStatus("01");//01-未支付
   		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
   		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//   			orderDetail.setOrdermanagerUserorder(order);
   			orderDetail.setOrderId(order.getUserorderId());
   			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
   		}
   		return order;
   	}
    /**
   	 * 新增威客服务订单
   	 */
   // @Override
    @EsbServiceMapping
   	public OrdermanagerUserorder saveWKSerOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,
   			@DomainCollection(domainClazz=OrdermanagerCommoditydetail.class) List<OrdermanagerCommoditydetail> orderDetailList) throws BusException {
       	BigDecimal userorderAmoun = BigDecimal.valueOf(0);
       	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//计算订单金额
       		PurchasingmanagerCommodity commodity = purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(orderDetail.getCommodityId().getCommodityId());
       		userorderAmoun = userorderAmoun.add(commodity.getCommodityPrice().
       				multiply(new BigDecimal(orderDetail.getCommoditydetailNum())));
       	}
   		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0507");
   		OrdermanagerUserorder order = new OrdermanagerUserorder();
   		order.setUserorderAmount(userorderAmoun);
   		order.setGenreId(pg);
   		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("WKFW"));
   		order.setUserorderStatus("01");//01-未支付
   		if(StringUtils.isNotEmpty(userId)){
			MemberInformation mem = memberInformationManager.getMemberInformation(userId);
			order.setUserorderBuyUser(mem.getMemberName());
		}
   		order.setMemberId(userId);
   		order.setUserorderProject(pg.getGenreName());
   		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setCreateUser(userId);
   		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order.setUpdateUser(userId);
   		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   		order = ordermanagerUserorderDao.save(order);
   		
   		for(OrdermanagerCommoditydetail orderDetail:orderDetailList){//保存订单明细
//   			orderDetail.setOrdermanagerUserorder(order);
   			orderDetail.setOrderId(order.getUserorderId());
   			ordermanagerCommoditydetailManager.saveOrdermanagerCommoditydetail(orderDetail);
   		}
   		return order;
   	}
    /**
     * 获取当前登录用户订单列表
     * @return
     * @throws BusException
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
	public List<OrdermanagerUserorder> getOrderListByLoginUser(OrdermanagerUserorder o) throws BusException {
    	String id = o.getCreateUser();	    	
    	List<OrdermanagerUserorder> list =ordermanagerUserorderDao.getList("memberId", id);
    	return list; 
	}
    /**
   	 * 通过订单号获取当前用户的订单记录  模糊查询
   	 * @param userId
   	 * @param userorderProject
   	 * @return
   	 * @throws BusException
   	 */
    @EsbServiceMapping					
	 public List<OrdermanagerUserorder> getOrderlistLikeUserorderProject(
			 @ServiceParam(name="userId",pubProperty="userId") String userId,
			 @ServiceParam(name="userorderProject") String userorderProject,
			 @ServiceParam(name="userorderCode") String userorderCode,
			 @ServiceParam(name="userorderStatus") String userorderStatus) throws BusException {		
		
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("memberId", Condition.EQUALS, userId));	
		condition.add(ConditionUtils.getCondition("userorderProject", Condition.LIKE, userorderProject));
		condition.add(ConditionUtils.getCondition("userorderCode", Condition.LIKE, userorderCode));	
		condition.add(ConditionUtils.getCondition("userorderStatus", Condition.EQUALS, userorderStatus));
		List<OrdermanagerUserorder> list =ordermanagerUserorderDao.commonQuery(condition, null);
		return list;
    }
    /**
   	 * 通过订单号获取当前用户的历史订单记录  模糊查询
   	 * @param userId
   	 * @param userorderProject
   	 * @return
   	 * @throws BusException
   	 */
    @EsbServiceMapping					
	 public List<OrdermanagerUserorder> getHospitalOrderlist(
			 @ServiceParam(name="userId",pubProperty="userId") String userId,
			 @ServiceParam(name="userorderProject") String userorderProject,
			 @ServiceParam(name="userorderCode") String userorderCode,
			 @ServiceParam(name="userorderStatus") String userorderStatus) throws BusException {		
		MemberInformation member=memberInformationManager.getMemberInformation(userId);
		String memberName=member.getMemberName();
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("userorderBuyUser", Condition.EQUALS, memberName));	
		condition.add(ConditionUtils.getCondition("userorderProject", Condition.LIKE, userorderProject));
		condition.add(ConditionUtils.getCondition("userorderCode", Condition.LIKE, userorderCode));	
		condition.add(ConditionUtils.getCondition("userorderStatus", Condition.NOT_EQUALS, userorderStatus));
		List<OrdermanagerUserorder> list =ordermanagerUserorderDao.commonQuery(condition, null);
		return list;
    }
    /**
     * 取消状态，前端调用
     * @param id，
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public OrdermanagerUserorder cancelStatus(@ServiceParam(name="id") String id) throws BusException{
    	OrdermanagerUserorder p = ordermanagerUserorderDao.get(id) ;
		 String status = p.getUserorderStatus() ;//得到订单状态
		 if("01".equals(status)){//若当前状态为未支付
		    	p.setUserorderStatus("04");//04为已取消，相当于前端取消申请
		    	p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	return ordermanagerUserorderDao.save(p);
		 }else{
		    	throw new BusException("当前状态无法取消申请！") ;
		 }
	}
    /**
     * 根据订单编号获取订单
     */
    @Override
    @EsbServiceMapping
    public OrdermanagerUserorder getOrderByCode(@ServiceParam(name="userorderCode") String userorderCode)  throws BusException{
    	OrdermanagerUserorder order = ordermanagerUserorderDao.getObjectByUniqueProperty("userorderCode", userorderCode);
    	String status = "";
    	List<Codeitem> codeitemList = codeItemDao.getList("codemap.code", "serviceOrderStatus");//企业服务状态
    	for(int y = 0;y<codeitemList.size();y++){
   			Codeitem codeitem = codeitemList.get(y);
   			if(codeitem.getItemValue().equals(order.getUserorderStatus())){
   				status = codeitem.getItemCaption();
   			}
   		} 
    	order.setStatus(status);
    	if("0301".equals(order.getGenreId().getGenreCode())){
    		extentionAtrManager.setMeetingOrderExtendValue(order);
    	}else if("0302".equals(order.getGenreId().getGenreCode())){
    		extentionAtrManager.setCarOrderExtendValue(order);
    	}else if("0303".equals(order.getGenreId().getGenreCode())){
    		extentionAtrManager.setAdsenseOrderExtendValue(order);
    	}
    	
    	return order;
    }
    
    

  	/**
  	 *前台 根据当前用户分页查询未完成订单     陈烨
  	  * @param pager
  	 * @param conditions
  	 * @param orders
  	 * @param userorderCodeLike
  	 * @param userorderProjecta
  	 * @return
  	 * @throws BusException
  	 */       
      @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
    public PagerRecords getPagerPend_query(Pager pager,//分页条件
    			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
    			@OrderCollection Collection<Order> orders,
    			@ServiceParam(name="genId") String genId)
    			throws BusException {
    	 String[] buff = new String[]{"01",   //01为待付款
    			 						"02"};  //02为待评价
    	 //IT服务（ff80808153f4a86a0153f4b06a65000d）有四个子类别
    	 String[] buff2 = new String[]{"ff80808153f4a86a0153f4b0a31f000e",	//预约单次    商品类别id
    			                       "ff80808153f4a86a0153f4b0be62000f",	//套餐一
    			                       "ff80808153f4a86a0153f4b0d0b90010",	//套餐二
    			                       "ff80808153f4a86a0153f4b0e4210011"};	//套餐三
         conditions.add(ConditionUtils.getCondition("userorderStatus", Condition.IN, buff));
         if(StringUtils.isNotEmpty(genId)){
        	 if("ff80808153f4a86a0153f4b06a65000d".equals(genId)){
        		 conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff2)); 
        	 }else{
        		 conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
        	 }
         }
    	 PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);  	  
    	 return pagerRecords;
    	}


      /**
  	 * 前台 根据当前用户分页查询历史订单 根据订单号，订单项目      陈烨
  	 * @param pager
  	 * @param conditions
  	 * @param orders
  	 * @param userorderCodeLike
  	 * @param userorderProjecta
  	 * @return
  	 * @throws BusException
  	 */
     @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerHospital_query(Pager pager,//分页条件
      			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
      			@OrderCollection Collection<Order> orders,
      			@ServiceParam(name="genId") String genId)
      			throws BusException {
    	String[] buff = new String[]{"01",   //01为待付款
      			 						"02"};  //02为待评价
      	//IT服务（ff80808153f4a86a0153f4b06a65000d）有四个子类别
      	String[] buff2 = new String[]{"ff80808153f4a86a0153f4b0a31f000e",	//预约单次    商品类别id
      			                       "ff80808153f4a86a0153f4b0be62000f",	//套餐一
      			                       "ff80808153f4a86a0153f4b0d0b90010",	//套餐二
      			                       "ff80808153f4a86a0153f4b0e4210011"};	//套餐三
        conditions.add(ConditionUtils.getCondition("userorderStatus", Condition.NOT_IN, buff));
        if(StringUtils.isNotEmpty(genId)){
        	if("ff80808153f4a86a0153f4b06a65000d".equals(genId)){
          		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff2)); 
          	}else{
          	 conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
          	}
        }
      	PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);  	  
      	return pagerRecords;
      }

   
    /**
	 *前台 根据当前用户分页查询全部订单           陈烨
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */       
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerAll(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="genId") String genId)
			throws BusException {	
         if(StringUtils.isNotEmpty(genId)){
        	 conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
         }
    	 PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);  	  
    	 return pagerRecords;
   }
   
    /**
	 * 前台 个人中心 获取整个数据的totalCount chenye
	 * @param conditions
     * @return
     * @throws BusException
	 */	   
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
			@ServiceParam(name="genId") String genId)  throws BusException{
         if(StringUtils.isNotEmpty(genId)){
        	 conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
         }
		List<Record> recordList=new ArrayList<Record>();
		List<OrdermanagerUserorder> List = this.getOrdermanagerUserorders(conditions, null);
		Record record = new Record();
		record.put("totalCount", List.size());
		recordList.add(record);
		return recordList;
	}
    /**
	 * 前台 个人中心   获取待处理订单的totalCount  chenye
	 * @param conditions
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCountPend(
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
			@ServiceParam(name="genId") String genId
			)  throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		String[] buff = new String[]{"01","02"};
        conditions.add(ConditionUtils.getCondition("userorderStatus", Condition.IN, buff));
        //IT服务（ff80808153f4a86a0153f4b06a65000d）有四个子类别
   	    String[] buff2 = new String[]{"ff80808153f4a86a0153f4b0a31f000e",	//预约单次    商品类别id
   			                       "ff80808153f4a86a0153f4b0be62000f",	//套餐一
   			                       "ff80808153f4a86a0153f4b0d0b90010",	//套餐二
   			                       "ff80808153f4a86a0153f4b0e4210011"};	//套餐三
        conditions.add(ConditionUtils.getCondition("userorderStatus", Condition.IN, buff));
        if(StringUtils.isNotEmpty(genId)){
       	 	if("ff80808153f4a86a0153f4b06a65000d".equals(genId)){
       	 		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff2)); 
       	 	}else{
       	 		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
       	 	}
        }
		List<OrdermanagerUserorder> List = this.getOrdermanagerUserorders(conditions, null);
		Record record = new Record();
		record.put("totalCount", List.size());
		recordList.add(record);
		return recordList;
	}
    /**
     * 前台 个人中心
   	 * 获取已完成订单的totalCount    chenye
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
    public List<Record> getTotalCountHospital(
   			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
			@ServiceParam(name="genId") String genId)  throws BusException{
   		List<Record> recordList=new ArrayList<Record>();
   		String[] buff = new String[]{"01","02"};
        conditions.add(ConditionUtils.getCondition("userorderStatus", Condition.NOT_IN, buff));
        //IT服务（ff80808153f4a86a0153f4b06a65000d）有四个子类别
   	    String[] buff2 = new String[]{"ff80808153f4a86a0153f4b0a31f000e",	//预约单次    商品类别id
   			                       "ff80808153f4a86a0153f4b0be62000f",	//套餐一
   			                       "ff80808153f4a86a0153f4b0d0b90010",	//套餐二
   			                       "ff80808153f4a86a0153f4b0e4210011"};	//套餐三
   	    if(StringUtils.isNotEmpty(genId)){
    	 	if("ff80808153f4a86a0153f4b06a65000d".equals(genId)){
    	 		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.IN, buff2)); 
    	 	}else{
    	 		conditions.add(ConditionUtils.getCondition("genreId.genreId", Condition.EQUALS, genId));
    	 	}
   	    }
   		List<OrdermanagerUserorder> List = this.getOrdermanagerUserorders(conditions, null);
   		Record record = new Record();
   		record.put("totalCount", List.size());
   		recordList.add(record);
   		return recordList;
   	}  
        
    /**
  	 * 获取订单记录(APP专用)
  	 * @param conditions
  	 * @return
  	 * @throws BusException
  	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
  	public PagerRecords getOrdermanagerUserorderListApp(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
    	PagerRecords pagerRecords = this.getPagerOrdermanagerUserorders(pager, conditions, orders);
    	//开始获取该订单下的所有订单详情
		for(int i=0;i<pagerRecords.getRecords().size();i++){
			OrdermanagerUserorder ordermanagerUserorder= (OrdermanagerUserorder) pagerRecords.getRecords().get(i);
			//获取订单号
			String userorderId = ordermanagerUserorder.getUserorderId();
			//根据订单号查询该订单下面的所有详细商品
			Collection<Condition> conditionsDetail = new ArrayList<Condition>();; 
			//添加查询商品详细列表的条件
			conditionsDetail.add(ConditionUtils.getCondition("orderId", Condition.EQUALS, userorderId));
			List<OrdermanagerCommoditydetail> ordermanagerCommodityDetailList = ordermanagerCommoditydetailManager.getOrdermanagerCommoditydetails(conditionsDetail, null);
			//商品详情列表
			ordermanagerUserorder.setOrdermanagerCommodityDetailList(ordermanagerCommodityDetailList);
			//商品详情列表Count
			String count = String.valueOf(ordermanagerCommodityDetailList.size());
			ordermanagerUserorder.setOrdermanagerCommodityDetailListCount(count);
		}
  		return pagerRecords;
  	}  
    /**
  	 * 获取支付二维码
  	 * @param conditions
  	 * @return
     * @throws Exception 
  	 */
    @Override
    @EsbServiceMapping
    public String getPayQrcodeByCode(@ServiceParam(name="userorderCode") String userorderCode) throws Exception{
    	OrdermanagerUserorder order = ordermanagerUserorderDao.getObjectByUniqueProperty("userorderCode", userorderCode);
    	BigDecimal b_amount =  order.getUserorderAmount().multiply(BigDecimal.valueOf(100));
    	UnifiedOrderReqData unifiedOrderReqData = new UnifiedOrderReqData(
    			order.getUserorderProject(), order.getUserorderCode(), b_amount.intValue(), 
				"127.0.0.1", "NATIVE", null, order.getUserorderCode(), 
				order.getUserorderProject(), null, null, null, null, null, null);
    	String codeUrl = wxPayManager.requestUnifiedOrderService(unifiedOrderReqData);
    	return codeUrl;
    }
    /**
  	 * 生成微信预支付订单号
  	 * @param conditions
  	 * @return
     * @throws Exception 
  	 */
    @Override
    @EsbServiceMapping
    public TempDemo getPrepayId(@ServiceParam(name="userorderCode") String userorderCode) throws Exception{
    	OrdermanagerUserorder order = ordermanagerUserorderDao.getObjectByUniqueProperty("userorderCode", userorderCode);
    	BigDecimal b_amount =  order.getUserorderAmount().multiply(BigDecimal.valueOf(100));
    	UnifiedOrderReqData appUnifiedOrderReqData = new UnifiedOrderReqData(
    			order.getUserorderProject(), order.getUserorderCode(), b_amount.intValue(), 
				"127.0.0.1", "APP", null, order.getUserorderCode(), 
				order.getUserorderProject(), null, null, null, null, null, null);
    	TempDemo temp = new TempDemo();
    	Map<String, Object> finalpackage = wxPayManager.appRequestOrderService(appUnifiedOrderReqData);
    	temp.setResMap(finalpackage);
    	return temp;
    }
    /**
     *修改该待评价状态为已完成状态，前端调用   chenye
     * @param id，
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public OrdermanagerUserorder  finishStatus(@ServiceParam(name="id") String id) throws BusException{
    	 OrdermanagerUserorder p = ordermanagerUserorderDao.get(id) ;
		 String status = p.getUserorderStatus() ;//得到订单状态
		 if("02".equals(status)){//若当前状态为已支付
		    	p.setUserorderStatus("03");//03为已完成，
		    	p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	return ordermanagerUserorderDao.save(p);
		 }else{
		    	throw new BusException("当前状态无法取消申请！") ;
		 }
	}
}


