/**
 * 代码声明
 */
package com.manage.PublicUtilitiesManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.dao.PurchasingmanagerGenrePropertyDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.manage.PublicUtilitiesManager.dao.PublicutilitiesmanagerResoDao;
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
	
//	@Autowired
//	private PurchasingmanagerCommodityExtendValueManager purchasingmanagerCommodityExtendValueManager;
	
	
	
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
    @EsbServiceMapping
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
        		PublicutilitiesmanagerReso reso=publicutilitiesmanagerResoDao.save(preso);
        		resoList.add(reso);
        	}else{//新增
        		pr.setResoStatus("02");//02---已预约
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
    	
//    	for(PurchasingmanagerCommodity p:commodityList){
//    		//根据商品信息实体查询商品扩展属性值表
//    		Collection<Condition> conditions = new ArrayList<Condition>();
//    		Collection<Order> orders = new ArrayList<Order>();
//    		conditions.add(ConditionUtils.getCondition("purchasingmanagerCommodity", Condition.EQUALS,
//    				p));
//    		List<PurchasingmanagerCommodity> commodityExtendValueList=purchasingmanagerCommodityManager.getPurchasingmanagerCommodityExtendValues(conditions, orders);
//    		for(PurchasingmanagerCommodityExtendValue value:commodityExtendValueList){
//    			extendValueList.add(value);
//    		}
//    	}
    	return commodityList;
    }
	@Override
	public OrdermanagerUserorder savePublicResoOrder(OrdermanagerUserorder o, PurchasingmanagerCommodity commodity,
			List<PublicutilitiesmanagerReso> publicResoList) throws BusException {
		publicResoList = this.savePublicutilitiesmanagerResoList(publicResoList);
		o.setGenreId(commodity.getPurchasingmanagerGenre());
		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("GGZY"));
		o.setUserorderStatus("01");//01-未支付
		o = userOrderManager.saveOrdermanagerUserorder(o);
		//保存订单明细列表
		OrdermanagerCommoditydetail orderDetail = new OrdermanagerCommoditydetail();
		orderDetail.setOrdermanagerUserorder(o);
		orderDetail.setCommodityId(commodity.getCommodityId());
		orderDetail.setCommoditydetailNum("1");
		this.userOrderDetailManager.saveOrdermanagerCommoditydetail(orderDetail);
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
	

}
