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

import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.common.purchasingManager.service.PurchasingmanagerMerchantManager;
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
	private PurchasingmanagerMerchantManager purchasingmanagerMerchantManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;

	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
	
	
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
    public List<PublicutilitiesmanagerReso> savePublicutilitiesmanagerResoList(List<PublicutilitiesmanagerReso> o) throws BusException{
    	String resoId = "";
    	List<PublicutilitiesmanagerReso> resoList=new ArrayList<PublicutilitiesmanagerReso>();
    	for(PublicutilitiesmanagerReso pr:o){
    		resoId = pr.getResoId();
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
	public OrdermanagerUserorder savePublicResoOrderByList(@ServiceParam(name="userorderAmount") String userorderAmount,@DomainCollection(domainClazz=PublicutilitiesmanagerReso.class) List<PublicutilitiesmanagerReso> publicResoList) throws BusException {
		publicResoList = this.savePublicutilitiesmanagerResoList(publicResoList);
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
		o.setGenreId(publicResoList.get(0).getCommodityId().getPurchasingmanagerGenre());
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GGZY"));
		o.setUserorderStatus("01");//01-未支付
		o.setUserorderProject(publicResoList.get(0).getCommodityId().getCommodityTitle());
		o.setUpdateUser(publicResoList.get(0).getUpdateUser());
		o.setUserorderAmount(new BigDecimal(userorderAmount));
		o = userOrderManager.saveOrdermanagerUserorder(o);
		//保存订单明细列表
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
		orderDetail.setOrdermanagerUserorder(o);
		orderDetail.setCommodityId(publicResoList.get(0).getCommodityId());
		orderDetail.setCommoditydetailNum("1");
		this.userOrderDetailManager.saveOrdermanagerCommoditydetail(orderDetail);
		//保存订单扩展属性列表
		PurchasingmanagerGenre pg = publicResoList.get(0).getCommodityId().getPurchasingmanagerGenre();
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
		//获取商品类别
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, pg.getGenreId()));
		List<PurchasingmanagerGenreProperty> genrePropertyList = extensionPropertyManager.getPurchasingmanagerGenrePropertys(conditions, null);
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
	
	
	/**
	 * 查询属于公共资源的商品
	 */
	@EsbServiceMapping
	public PagerRecords getPagerPublicCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="genreCode") String genreCode)  throws BusException{
		// 查询属于公共资源的商品：genreCode=0301:会议室 ；genreCode=0302:车辆租赁；genreCode=0303:广告位
		Collection<Condition> conditionP = new ArrayList<Condition>();
		conditionP.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS,genreCode));
		List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditionP, null);
		String genreId="";
		if(purchasingmanagerGenreList.size()>0){
			genreId = purchasingmanagerGenreList.get(0).getGenreId();
		}
		
		List<Record> records = new ArrayList<Record>();
		// 查询公共资源下包含的商品
		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId",Condition.EQUALS,genreId));
		PagerRecords pagerRecords = purchasingmanagerCommodityManager.getPagerPurchasingmanagerCommoditys(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList=(List<PurchasingmanagerCommodity>) pagerRecords.getRecords();

		for(PurchasingmanagerCommodity pc:pcList){
			Record record = new Record();
			record.put("commodityId",pc.getCommodityId());//商品ID
			record.put("commodityTitle",pc.getCommodityTitle());//商品标题
			record.put("commodityPrice",pc.getCommodityPrice());//商品标价
			record.put("commodityDescribe",pc.getCommodityDescribe());//商品描述
			record.put("commodityImage",pc.getCommodityImage());//商品图像
			record.put("commodityCoverImage",pc.getCommodityCoverImage());//封面图片
			record.put("merchantName",pc.getPurchasingmanagerMerchant().getMerchantName());//商户名称
			record.put("merchantId",pc.getPurchasingmanagerMerchant().getMerchantId());//商户Id
			record.put("merchantLinkman",pc.getPurchasingmanagerMerchant().getMerchantLinkman());//联系人电话
			record.put("merchantLinkmanPhone",pc.getPurchasingmanagerMerchant().getMerchantLinkmanPhone());//联系人电话

			PurchasingmanagerGenre pg = pc.getPurchasingmanagerGenre();
			while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
				pg = pg.getPurchasingmanagerGenre();
			}
			//获取商品类别
			Collection<Condition> condition = new ArrayList<Condition>();
			List<PurchasingmanagerCommodityExtend> pceList=new ArrayList<PurchasingmanagerCommodityExtend>();
			condition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, pg.getGenreId()));
			List<PurchasingmanagerGenreProperty> genrePropertyList = extensionPropertyManager.getPurchasingmanagerGenrePropertys(condition, null);
			for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){
				if("dw".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("dwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：档位
				}else if("zw".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("zwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：座位
				}else if("chepai".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("cpValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():"");//商品属性：车牌
				}
			}
			records.add(record);
		}

		pagerRecords.setRecords(records);


		return pagerRecords;
	}
	
	/**
	 * 根据商品id获取资源可用状态
	 */
	@EsbServiceMapping
	public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResoByCommodityId(@ServiceParam(name="commodityId") String commodityId) throws BusException {
		String[] parame = new String[]{"commodityId.commodityId"};
		Object[] objval = new Object[]{commodityId};
		List<PublicutilitiesmanagerReso> list = publicutilitiesmanagerResoDao.getList(parame, objval);
		return list;
	}
}