/**
 * 代码声明
 */
package com.manage.PublicUtilitiesManager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
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
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
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
import com.manage.PublicUtilitiesManager.dao.PublicutilitiesmanagerResoDao;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.manage.PublicUtilitiesManager.service.PublicutilitiesmanagerResoManager;

@Service("publicutilitiesmanagerResoManager")
@Transactional
public class PublicutilitiesmanagerResoManagerImpl extends BaseManagerImpl implements PublicutilitiesmanagerResoManager{
	@Autowired
	private PublicutilitiesmanagerResoDao publicutilitiesmanagerResoDao;
	
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
	
	@Autowired
	private OrdermanagerUserorderManager userOrderManager;
	
	@Autowired
	private OrdermanagerCommoditydetailManager userOrderDetailManager;
	
	@Autowired
	private PurchasingmanagerGenrePropertyManager extensionPropertyManager;
	
	@Autowired
	private OrdermanagerOrderprojecttypeValueManager orderprojectValueManager;
	
	@Autowired
	private BbmRoomManager bbmRoomManager;

	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	@Autowired
	private MemberInformationDao memberInformationDao;
	
	@Autowired
	private ExtentionAtrManager extentionAtrManager;
	
	
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos() throws BusException{
    	return publicutilitiesmanagerResoDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos(
    	@ConditionCollection(domainClazz=PublicutilitiesmanagerReso.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return publicutilitiesmanagerResoDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PublicutilitiesmanagerReso getPublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id)  throws BusException{
    	return publicutilitiesmanagerResoDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPublicutilitiesmanagerResos(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PublicutilitiesmanagerReso.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = publicutilitiesmanagerResoDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PublicutilitiesmanagerReso savePublicutilitiesmanagerReso(PublicutilitiesmanagerReso o) throws BusException{
    	String resoId = o.getResoId();
    	boolean isUpdate = StringUtils.isNotEmpty(resoId);
    	//获取商品信息
    	String commodityId=o.getCommodityId().getCommodityId();
		PurchasingmanagerCommodity pc=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
    	if(isUpdate){//修改
    		PublicutilitiesmanagerReso pr = publicutilitiesmanagerResoDao.get(resoId); 
    		pr.setCommodityId(pc);
    		pr.setResoDate(o.getResoDate());
    		pr.setResoTime(o.getResoTime());
    		pr.setUpdateUser(o.getUpdateUser());
    		pr.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return publicutilitiesmanagerResoDao.save(o);
    	}else{//新增
    		o.setResoStatus("01");//01:可用
    		o.setCommodityId(pc);
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return publicutilitiesmanagerResoDao.save(o);
    	}
    	
    }
    
    /**
     *前台页面：用户预约公共资源,保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public List<PublicutilitiesmanagerReso> savePublicutilitiesmanagerResoList(List<PublicutilitiesmanagerReso> o,String commodityId) throws BusException{
    	String resoId = "";
    	List<PublicutilitiesmanagerReso> resoList=new ArrayList<PublicutilitiesmanagerReso>();
    	List<PublicutilitiesmanagerReso> reListForCar=new ArrayList<PublicutilitiesmanagerReso>();
    	List<PublicutilitiesmanagerReso> reList=new ArrayList<PublicutilitiesmanagerReso>();
    	PurchasingmanagerCommodity purchasingmanagerCommodity =new PurchasingmanagerCommodity();
    	for(PublicutilitiesmanagerReso pr:o){
    		
    		String resoDate=pr.getResoDate();
    		String resoTime=pr.getResoTime();
    		if(StringUtils.isNotEmpty(resoDate) && StringUtils.isNotEmpty(resoTime) && StringUtils.isNotEmpty(commodityId)){
    			//根据商品id和可用日期、可用时段查询是否存在公共资源预约：会议室和广告位
    			purchasingmanagerCommodity=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
    			reList=publicutilitiesmanagerResoDao.getList(new String[] {"resoDate","resoTime","commodityId.commodityId"}, new  String[] {resoDate,resoTime,commodityId});
    		}else if(StringUtils.isNotEmpty(resoDate) && StringUtils.isNotEmpty(commodityId)){
    			//根据商品id和可用日期查询是否存在公共资源预约：车辆租赁
    			purchasingmanagerCommodity=purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
    			reListForCar=publicutilitiesmanagerResoDao.getList(new String[] {"resoDate","commodityId.commodityId"}, new  String[] {resoDate,commodityId});
    		}
    		if(reList.size()>0){
    			//判断广告位或会议室是否被预约:02---已预约
    			if(!reList.get(0).getResoStatus().equals("02")){
    				resoId = reList.get(0).getResoId();
    			}else{
        			throw new BusException("该日期时段已被预约,请重新选择日期时段！");
        		}
    		}	
    		if(reListForCar.size()>0){
    			//判断车辆是否被预约
    			if(!reListForCar.get(0).getResoStatus().equals("02")){
    				resoId = reListForCar.get(0).getResoId();
    			}else{
        			throw new BusException("该日期时段已被预约,请重新选择日期时段！");
        		}
    		}
    		boolean isUpdate = StringUtils.isNotEmpty(resoId);
        	if(isUpdate){//修改,更新预约状态
        		//根据主键Id查询公共资源信息
        		PublicutilitiesmanagerReso preso=publicutilitiesmanagerResoDao.get(resoId);
        		preso.setResoStatus("02");//更新状态：02---已预约
        		preso.setUpdateUser(pr.getUpdateUser());
        		preso.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		preso.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		PublicutilitiesmanagerReso reso=publicutilitiesmanagerResoDao.save(preso);
        		resoList.add(reso);
        	}else{//新增
        		pr.setResoStatus("02");//02---已预约
        		pr.setCommodityId(purchasingmanagerCommodity);
        		pr.setCreateUser(pr.getUpdateUser());
        		pr.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		pr.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		PublicutilitiesmanagerReso reso=publicutilitiesmanagerResoDao.save(pr);//生成新的公共资源信息
        		resoList.add(reso);
        	}
    	}
    	
    	
    	return resoList;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id) throws BusException{
    	publicutilitiesmanagerResoDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePublicutilitiesmanagerResos(@ServiceParam(name="resoId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePublicutilitiesmanagerReso(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPublicutilitiesmanagerReso(@ServiceParam(name="resoId") String id)  throws BusException{
		return publicutilitiesmanagerResoDao.exists(id);
	}
    
    public boolean exsitPublicutilitiesmanagerReso(String propertyName,Object value) throws BusException{
		return publicutilitiesmanagerResoDao.exists(propertyName,value);
	}
    
    /**
	 * 查询园区商品类型为公用资源的商品
	 */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodity> getCommoditysByPublicStatus() throws BusException{
//    	List<PurchasingmanagerCommodity> extendValueList=new ArrayList<PurchasingmanagerCommodity>();
    	//查询属于公共资源的商品
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("parkBusinessTupe", Condition.EQUALS,"03"));//03:公共资源
    	List<PurchasingmanagerCommodity> commodityList=purchasingmanagerCommodityManager.getPurchasingmanagerCommoditys(condition, order);
    	return commodityList;
    }
	
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public OrdermanagerUserorder savePublicResoOrderByList(@ServiceParam(name="addService") String addService,@ServiceParam(name="userorderAmount") String userorderAmount,@ServiceParam(name="commodityId") String commodityId,@DomainCollection(domainClazz=PublicutilitiesmanagerReso.class) List<PublicutilitiesmanagerReso> publicResoList) throws BusException {
		publicResoList = this.savePublicutilitiesmanagerResoList(publicResoList,commodityId);
//		List<PublicutilitiesmanagerReso> prList=new ArrayList<PublicutilitiesmanagerReso> ();
//		String resoId=publicReso.getResoId();
//		if(StringUtils.isNotEmpty(resoId)){
//			PublicutilitiesmanagerReso publics = publicutilitiesmanagerResoDao.get(resoId); 
//			publics.setUpdateUser(publicReso.getUpdateUser());
//			prList.add(publics);
//			this.savePublicutilitiesmanagerResoList(prList);
//			publicReso=publics;
//		}
		
		OrdermanagerUserorder o =new OrdermanagerUserorder();
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(publicResoList.get(0).getCommodityId().getGenreId());
		o.setGenreId(pg);
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GGZY"));
		o.setUserorderStatus("01");//01-未支付
		o.setUserorderProject(publicResoList.get(0).getCommodityId().getCommodityTitle());
		o.setUpdateUser(publicResoList.get(0).getUpdateUser());
		o.setMemberId(publicResoList.get(0).getUpdateUser());
		if(StringUtils.isNotEmpty(userorderAmount) && userorderAmount!=null){
			o.setUserorderAmount(new BigDecimal(userorderAmount));
		}else{
			o.setUserorderAmount(new BigDecimal(0));
		}
		
		o = userOrderManager.saveOrdermanagerUserorder(o);
		//保存订单明细列表
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
//		orderDetail.setOrdermanagerUserorder(order);
		orderDetail.setOrderId(o.getUserorderId());
		orderDetail.setCommodityId(publicResoList.get(0).getCommodityId());
		orderDetail.setCommoditydetailNum("1");
		this.userOrderDetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		//保存订单扩展属性列表
		if(pg.getGenreId() != null){//获取最顶级商品类别
			pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pg.getGenreId());
		}
		StringBuffer publicResoIdBuff =  new StringBuffer();//公共资源ID
		StringBuffer dateStrBuff =new StringBuffer();;//订单预定日期
		StringBuffer timeStrBuff =  new StringBuffer();//订单预定时段
		for(int i = 0;i<publicResoList.size();i++){
			PublicutilitiesmanagerReso publicReso = publicResoList.get(i);
			dateStrBuff.append(publicReso.getResoDate());
			timeStrBuff.append(publicReso.getResoTime());
			publicResoIdBuff.append(publicReso.getResoId());
			if(i+1<publicResoList.size()){
				dateStrBuff.append(",");
				timeStrBuff.append(",");
				publicResoIdBuff.append(",");
			}
		}
		//获取商品类别
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, pg.getGenreId()));
		List<PurchasingmanagerGenreProperty> genrePropertyList = extensionPropertyManager.getPurchasingmanagerGenrePropertys(conditions, null);
		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){//保存订单扩展项信息
			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
			orderExtendValue.setOrdermanagerUserorder(o);
			orderExtendValue.setGenrePropertyId(genreProperty);
			if("publicResoIdDate".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(dateStrBuff.toString());
			}else if("publicResoIdTime".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(timeStrBuff.toString());
			}else if("publicResoId".equals(genreProperty.getGenrePropertyFieldName())){
				orderExtendValue.setOrderprojecttypeValueFieldValue(publicResoIdBuff.toString());
			}else if("driver".equals(genreProperty.getGenrePropertyFieldName())){
				if(addService.equals("true")){//01：有增值服务：司机
					orderExtendValue.setOrderprojecttypeValueFieldValue(addService);
				}
			}else if("tea".equals(genreProperty.getGenrePropertyFieldName())){
				if(addService.equals("true")){//01：有增值服务：茶水
					orderExtendValue.setOrderprojecttypeValueFieldValue(addService);
				}
			}
			this.orderprojectValueManager.saveOrdermanagerOrderprojecttypeValue(orderExtendValue);
			
					
		}
		
		return o;
		
	}
	
	
	
	/**
	 * 取消订单,变更公共资源状态:由已预订变更为可用
	 */
	@EsbServiceMapping
	public void updateUserorderStatus(OrdermanagerUserorder o) throws BusException{
		String userorderId=o.getUserorderId();//订单ID
		if(StringUtils.isNotEmpty(userorderId)){
			//取消订单，变更状态为已取消
			o=userOrderManager.getOrdermanagerUserorder(userorderId);
			o.setUserorderStatus("05");//05-已取消
			userOrderManager.saveOrdermanagerUserorder(o);
		}
        //根据订单ID获取订单扩展项信息
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Order> orders = new ArrayList<Order>();
		conditions.add(ConditionUtils.getCondition("ordermanagerUserorder.userorderId", Condition.EQUALS, userorderId));
		List<OrdermanagerOrderprojecttypeValue> orderprojecttypeList=orderprojectValueManager.getOrdermanagerOrderprojecttypeValues(conditions, orders);
		for(OrdermanagerOrderprojecttypeValue ot:orderprojecttypeList){
			//获取订单扩展项里的公共资源ID:publicResoId
			if(ot.getGenrePropertyId().getGenrePropertyFieldName().equals("publicResoId")){
				String[] publicResoId=ot.getOrderprojecttypeValueFieldValue().split(",");
				for(String publicId:publicResoId){
					//查询公共资源信息
					PublicutilitiesmanagerReso pr = publicutilitiesmanagerResoDao.get(publicId);
					pr.setResoStatus("01");//可用
					publicutilitiesmanagerResoDao.save(pr);
				}
			}
		}
	}
	
	
//	/**
//	 * 查询属于公共资源的商品
//	 */
//	@EsbServiceMapping
//	public PagerRecords getPagerPublicCommoditys(Pager pager,//分页条件
//			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
//			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode)  throws BusException{
//		// 查询属于公共资源的商品：genreCode=0301:会议室 ；genreCode=0302:车辆租赁；genreCode=0303:广告位
//		Collection<Condition> conditionP = new ArrayList<Condition>();
//		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
//		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
//		String genreId="";
//		if(purchasingmanagerGenreList.size()>0){
//			genreId = purchasingmanagerGenreList.get(0).getGenreId();
//		}
//		
//		List<Record> records = new ArrayList<Record>();
//		// 查询公共资源下包含的商品
//		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId",Condition.EQUALS,genreId));
//		PagerRecords pagerRecords = purchasingmanagerCommodityManager.getPagerPurchasingmanagerCommoditys(pager, conditions, orders);
//		@SuppressWarnings("unchecked")
//		List<PurchasingmanagerCommodity> pcList=(List<PurchasingmanagerCommodity>) pagerRecords.getRecords();
//
//		for(PurchasingmanagerCommodity pc:pcList){
//			Record record = new Record();
//			record.put("commodityId",pc.getCommodityId());//商品ID
//			record.put("commodityTitle",pc.getCommodityTitle());//商品标题
//			record.put("commodityPrice",pc.getCommodityPrice());//商品标价
//			record.put("commodityDescribe",pc.getCommodityDescribe());//商品描述
//			record.put("commodityImage",pc.getCommodityImage());//商品图像
//			record.put("commodityCoverImage",pc.getCommodityCoverImage());//封面图片
//			record.put("merchantName",pc.getPurchasingmanagerMerchant().getMerchantName());//商户名称
//			record.put("merchantId",pc.getPurchasingmanagerMerchant().getMerchantId());//商户Id
//			record.put("merchantLinkman",pc.getPurchasingmanagerMerchant().getMerchantLinkman());//联系人电话
//			record.put("merchantLinkmanPhone",pc.getPurchasingmanagerMerchant().getMerchantLinkmanPhone());//联系人电话
//
//		/*	PurchasingmanagerGenre pg = pc.getPurchasingmanagerGenre();
//			while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
//				pg = pg.getPurchasingmanagerGenre();
//			}*/
//			//获取商品类别
//			Collection<Condition> condition = new ArrayList<Condition>();
//			List<PurchasingmanagerCommodityExtend> pceList=new ArrayList<PurchasingmanagerCommodityExtend>();
//			condition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, pc.getGenreId()));
//			List<PurchasingmanagerGenreProperty> genrePropertyList = extensionPropertyManager.getPurchasingmanagerGenrePropertys(condition, null);
//			for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){
//				if("dw".equals(genreProperty.getGenrePropertyFieldName())){
//					//获取商品扩展属性
//					Collection<Condition> conditionE = new ArrayList<Condition>();
//					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
//					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
//					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
//					record.put("dwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：档位
//				}else if("zw".equals(genreProperty.getGenrePropertyFieldName())){
//					//获取商品扩展属性
//					Collection<Condition> conditionE = new ArrayList<Condition>();
//					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
//					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
//					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
//					record.put("zwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：座位
//				}else if("chepai".equals(genreProperty.getGenrePropertyFieldName())){
//					//获取商品扩展属性
//					Collection<Condition> conditionE = new ArrayList<Condition>();
//					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
//					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
//					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
//					record.put("cpValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：车牌
//				}
//			}
//			records.add(record);
//		}
//
//		pagerRecords.setRecords(records);
//
//
//		return pagerRecords;
//	}
	
	/**
	 * 查询属于公共资源的商品
	 */
	@EsbServiceMapping
	public PagerRecords getPagerPublicCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode,@ServiceParam(name="roomType") String roomType,
			@ServiceParam(name="roomProjector") String roomProjector,@ServiceParam(name="roomGm") String roomGm)  throws BusException{
		// 查询属于公共资源的商品：genreCode=0301:会议室 ；genreCode=0302:车辆租赁；genreCode=0303:广告位
		Collection<Condition> conditionP = new ArrayList<Condition>();
		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
		String genreId="";
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		// 查询公共资源下包含的商品
		conditions.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,genreId));
		PagerRecords pagerRecords = purchasingmanagerCommodityManager.getPagerPurchasingmanagerCommoditys(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList=(List<PurchasingmanagerCommodity>) pagerRecords.getRecords();
		List<PurchasingmanagerCommodity> pcLists=new ArrayList<PurchasingmanagerCommodity> ();

		for(PurchasingmanagerCommodity pc:pcList){
			if(genreCode.equals("0301")){//会议室
				extentionAtrManager.setMeetingRoomExtendValue(pc);
				String adr=pc.getMeetingRoom().getAdr();
				BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(adr);
				if(bbmRoom != null){
					//获取单元默认地址
					String adrName=bbmRoom.getRoomAddress();
					pc.getMeetingRoom().setAdrName(adrName);
				}
				if(StringUtils.isNotEmpty(roomType) && StringUtils.isNotEmpty(roomProjector) && StringUtils.isNotEmpty(roomGm)){
					if(pc.getMeetingRoom().getLx().equals(roomType) && pc.getMeetingRoom().getTyy().equals(roomProjector) && pc.getMeetingRoom().getGm().equals(roomGm)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomType) && StringUtils.isNotEmpty(roomProjector)){
					if(pc.getMeetingRoom().getLx().equals(roomType) && pc.getMeetingRoom().getTyy().equals(roomProjector)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomType) && StringUtils.isNotEmpty(roomGm)){
					if(pc.getMeetingRoom().getLx().equals(roomType) && pc.getMeetingRoom().getGm().equals(roomGm)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomProjector) && StringUtils.isNotEmpty(roomGm)){
					if(pc.getMeetingRoom().getTyy().equals(roomProjector) && pc.getMeetingRoom().getGm().equals(roomGm)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomType)){
					if(pc.getMeetingRoom().getLx().equals(roomType)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomProjector)){
					if(pc.getMeetingRoom().getTyy().equals(roomProjector)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomGm)){
					if(pc.getMeetingRoom().getGm().equals(roomGm)){
						pcLists.add(pc);
					}
				}else{
					pcLists.add(pc);
				}
				
				
			}else if(genreCode.equals("0302")){//车辆
				extentionAtrManager.setCarExtendValue(pc);
				if(StringUtils.isNotEmpty(roomType) && StringUtils.isNotEmpty(roomGm)){
					if(pc.getCar().getDw().equals(roomType) && pc.getCar().getZw().equals(roomGm)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomType)){//档位
					if(pc.getCar().getDw().equals(roomType)){
						pcLists.add(pc);
					}
				}else if(StringUtils.isNotEmpty(roomGm)){//车辆乘坐人数
					if(pc.getCar().getZw().equals(roomGm)){
						pcLists.add(pc);
					}
				}else{
					pcLists.add(pc);
				}
			}else if(genreCode.equals("0303")){//广告
				//填充广告位扩展属性
				extentionAtrManager.setMeetingLedExtendValue(pc);
				pcLists.add(pc);
			}
		}
		pagerRecords.setRecords(pcLists);
		return pagerRecords;
	}
	
	
	
	/**
	 * 查询属于公共资源的商品
	 */
	@EsbServiceMapping
	public PagerRecords goPage(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode,
			@ServiceParam(name="indexPage") String indexPage)  throws BusException{
		// 查询属于公共资源的商品：genreCode=0301:会议室 ；genreCode=0302:车辆租赁；genreCode=0303:广告位
		Collection<Condition> conditionP = new ArrayList<Condition>();
		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
		String genreId="";
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		// 查询公共资源下包含的商品
		conditions.add(ConditionUtils.getCondition("genreId",Condition.EQUALS,genreId));
		//String pageIndex = org.apache.commons.lang.StringUtils.defaultIfEmpty(page, "1");
		pager.setPageIndex(Integer.valueOf(indexPage));
		pager.setPageSize(3);
		PagerRecords pagerRecords = purchasingmanagerCommodityManager.getPagerPurchasingmanagerCommoditys(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList=(List<PurchasingmanagerCommodity>) pagerRecords.getRecords();


		for(PurchasingmanagerCommodity pc:pcList){
			if("0303".equals(genreCode)){
				//广告位
				extentionAtrManager.setMeetingLedExtendValue(pc);
			}
		}



		return pagerRecords;
	}
	
	/**
	 * 根据商品id获取资源可用状态
	 */
	@EsbServiceMapping
	public List<Record> getPublicutilitiesmanagerResoByCommodityId(@ServiceParam(name="userId",pubProperty = "userId") String userId,@ServiceParam(name="commodityId") String commodityId) throws BusException {
		List<Record> recordList=new ArrayList<Record>();
		MemberInformation memberInformation=new MemberInformation();
		if(userId !=null){
		  memberInformation=memberInformationDao.get(userId);
		}
		String[] parame = new String[]{"commodityId.commodityId"};
		Object[] objval = new Object[]{commodityId};
		List<PublicutilitiesmanagerReso> list = publicutilitiesmanagerResoDao.getList(parame, objval);
		if(list.size()>0){
			for(PublicutilitiesmanagerReso p:list){
				Record record=new Record();
				
				record.put("resoId",p.getResoId());
				record.put("resoStatus",p.getResoStatus());
				record.put("commodityId",p.getCommodityId().getCommodityId());
				record.put("resoDate",p.getResoDate());
				record.put("resoTime",p.getResoTime());
				record.put("name",memberInformation!=null?memberInformation.getMemberName():"");
				record.put("phone",memberInformation!=null?memberInformation.getMemberPhoneNumber():"");
				recordList.add(record);
			}
		}else{
			Record record=new Record();
			record.put("resoId","");
			record.put("resoStatus","");
			record.put("commodityId","");
			record.put("resoDate","");
			record.put("resoTime","");
			record.put("name",memberInformation!=null?memberInformation.getMemberName():"");
			record.put("phone",memberInformation!=null?memberInformation.getMemberPhoneNumber():"");	
			recordList.add(record);
		}
		return recordList;
	}
	
	/**
	  * 根据商品ID，日期返回资源状态
	  * @param commodityId
	  * @param updateTime
	  * @return
	  * @throws BusException
	  */
	@EsbServiceMapping
	 public List<PublicutilitiesmanagerReso> findDateResoList(@ServiceParam(name="commodityId") String commodityId,@ServiceParam(name="resoDate") String resoDate ) throws BusException{
		 List<PublicutilitiesmanagerReso> resoList=publicutilitiesmanagerResoDao.getList(new String[] {"resoDate","commodityId.commodityId"}, new  String[] {resoDate,commodityId});
		 return resoList;
	 }
	
	/**
	  * 根据商品ID，日期返回资源状态
	  * @param commodityId
	  * @param updateTime
	  * @return
	  * @throws BusException
	  */
	@EsbServiceMapping
	 public List<PublicutilitiesmanagerReso> findMonthResoList(@ServiceParam(name="commodityId") String commodityId,@ServiceParam(name="month") String month ) throws BusException{
		// List<PublicutilitiesmanagerReso> resoList=publicutilitiesmanagerResoDao.getList(new String[] {"resoDate","commodityId.commodityId"}, new  String[] {resoDate,commodityId});
		String[] m = month.split(",");
		//时间格式 eg:2016-03-01
		String startMonth = m[0]+"-"+m[1]+"-01";
		String endMonth = m[0]+"-"+m[1]+"-31";
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("commodityId.commodityId",Condition.EQUALS, commodityId));
		conditions.add(ConditionUtils.getCondition("resoDate",
				Condition.BETWEEN, startMonth + Condition.BETWEEN_SPLIT
						+ endMonth));
		List<PublicutilitiesmanagerReso> resoList = publicutilitiesmanagerResoDao.commonQuery(conditions, null);
		return resoList;
	 }
}