/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
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
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;

@Service("propertyservicemanagerBxManager")
@Transactional
public class PropertyservicemanagerBxManagerImpl extends BaseManagerImpl implements PropertyservicemanagerBxManager{
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private PurchasingmanagerGenreManager	purchasingmanagerGenreManager;
	@Autowired
	private PurchasingmanagerGenrePropertyManager purchasingmanagerGenrePropertyManager;
	@Autowired
	private OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager;
	@Autowired
	private PropertyservicemanagerTsManager propertyservicemanagerTsManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs() throws BusException{
    	return propertyservicemanagerBxDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerBxDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerBx getPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
    	return propertyservicemanagerBxDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerBxs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerBxDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="createUser",pubProperty="userId")})
    public PropertyservicemanagerBx savePropertyservicemanagerBx(PropertyservicemanagerBx o) throws BusException{
//    	String propertyservicemanagerBxId = o.getPropertyservicemanagerBxId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerBxId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	//物业管理员定价生成订单
    	if(o.getBxStatus().equals("05")){
    		//获取报修单
    		String bxId = o.getBxId();
    		PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(bxId);
    		//获取当前登录用户
    		Object object = SecurityUtils.getPrincipal();
    		User user = new User();
    		if(object != null && object instanceof User){
    			user = (User) object;
    		}
    		OrdermanagerUserorder order = new OrdermanagerUserorder();
 
    		//查询商品类别
    		Collection<Condition> condition =  new ArrayList<Condition>();
    		condition.add(ConditionUtils.getCondition("genreCode", Condition.EQUALS,"07"));
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null).get(0);
    		
    		order.setGenreId(pg);
    		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("WYBX"));
    		order.setUserorderStatus("01");//01-未支付
    		order.setCreateUser(user.getUserId());
    		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		order.setUpdateUser(user.getUserId());
    		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		order.setUserorderBuyUser(user.getUserCaption());
    		order.setMemberId(user.getUserId());
    		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		order.setUserorderAmount(o.getBxAmount());
    		ordermanagerUserorderManager.saveOrdermanagerUserorder(order);
    		
    		//保存订单扩展属性列表
    		Collection<Condition> purcondition =  new ArrayList<Condition>();
    		purcondition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS,pg.getGenreId()));
    		List<PurchasingmanagerGenreProperty> genrePropertyList = purchasingmanagerGenrePropertyManager.getPurchasingmanagerGenrePropertys(purcondition,null);
    		if(genrePropertyList.size()>0){
	    		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){//保存订单扩展项信息
	    			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
	    			orderExtendValue.setOrdermanagerUserorder(order);
	    			orderExtendValue.setGenrePropertyId(genreProperty);
	    			if("orderBxId".equals(genreProperty.getGenrePropertyFieldName())){
	    				orderExtendValue.setOrderprojecttypeValueFieldValue(bxId);
	    			}
	    			ordermanagerOrderprojecttypeValueManager.saveOrdermanagerOrderprojecttypeValue(orderExtendValue);
	    		}
    		}
    		//物业管理员定价，同时关闭派工记录
    		PropertyservicemanagerTs ts =  propertyservicemanagerTsManager.getTsBybxId(bxId);
    		ts.setTsStatus("03");
    		propertyservicemanagerTsManager.savePropertyservicemanagerTs(ts);
    		//保存报修记录
    		bx.setBxStatus(o.getBxStatus());
    		bx.setBxAmount(o.getBxAmount());
    		return propertyservicemanagerBxDao.save(bx);
    	}else{
    		o.setBxCode(BizCodeUtil.getInstance().getBizCodeDate("BX"));
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return propertyservicemanagerBxDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerBx(@ServiceParam(name="bxId") String id) throws BusException{
    	propertyservicemanagerBxDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerBxs(@ServiceParam(name="bxId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerBx(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
		return propertyservicemanagerBxDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerBx(String propertyName,Object value) throws BusException{
		return propertyservicemanagerBxDao.exists(propertyName,value);
	}

    /**
     * 根据id修改报修状态
	 * @param id 报修记录主键id
	 * @param code 判断流程是否标识
	 * @throws BusException
     */
    @EsbServiceMapping
	public void upBxbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(id);
    	String bxstatus = bx.getBxStatus();
    	if(code.equals("01")){//回绝报修
    		if(bxstatus.equals("00")){
    			bx.setBxStatus("08");
    		}else if(bxstatus.equals("05")){//重修报修
        		bx.setBxStatus("01");//回滚状态到已受理	
    		}
    	}else{
    		if(bxstatus.equals("00")){//待受理-->已受理
    			bx.setBxStatus("01");
    		}else if(bxstatus.equals("05")){//已定价-->已支付
    			bx.setBxStatus("06");
    		}else if(bxstatus.equals("06")){//已付款-->已完成
    			bx.setBxStatus("07");
    		}
    	}
    	propertyservicemanagerBxDao.save(bx);
	}
    
	/**
	 * 根据当前登录用户获取报修单
	 * @param o 报修对象
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
	public List<PropertyservicemanagerBx> getBxListforpage(PropertyservicemanagerBx o)
			throws BusException {
		//获取当前登录用户id
		String id = o.getCreateUser();
		if(id!=null){
	    	//获取当前用户参加活动的list
	    	Collection<Condition> condition = new ArrayList<Condition>();
	    	condition.add(ConditionUtils.getCondition("createUser", Condition.EQUALS, id));
	    	 List<PropertyservicemanagerBx> list = propertyservicemanagerBxDao.commonQuery(condition, null);
	    	 if(list.size()>0){
	    		 return list;
	    	 }else{
	    		 return null;
	    	 }
		}else{
			return null;
		}
		
	}

    
}
