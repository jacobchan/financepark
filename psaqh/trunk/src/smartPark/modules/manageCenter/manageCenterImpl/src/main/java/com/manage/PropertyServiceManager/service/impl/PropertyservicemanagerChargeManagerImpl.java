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
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.entity.OrdermanagerUserorder;
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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerChargeDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerChargeManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSfproManager;

@Service("propertyservicemanagerChargeManager")
@Transactional
public class PropertyservicemanagerChargeManagerImpl extends BaseManagerImpl implements PropertyservicemanagerChargeManager{
	@Autowired
	private PropertyservicemanagerChargeDao propertyservicemanagerChargeDao;
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	@Autowired
	private PropertyservicemanagerSfproManager propertyservicemanagerSfproManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerCharge> getPropertyservicemanagerCharges() throws BusException{
    	return propertyservicemanagerChargeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerCharge> getPropertyservicemanagerCharges(
    	@ConditionCollection(domainClazz=PropertyservicemanagerCharge.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerChargeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerCharge getPropertyservicemanagerCharge(@ServiceParam(name="chargeId") String id)  throws BusException{
    	return propertyservicemanagerChargeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerCharges(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerCharge.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerChargeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PropertyservicemanagerCharge savePropertyservicemanagerCharge(PropertyservicemanagerCharge o) throws BusException{
    	String chargeId = o.getChargeId();
    	boolean isUpdate = StringUtils.isNotEmpty(chargeId);
    	if(isUpdate){//修改
    		PropertyservicemanagerCharge pc = new PropertyservicemanagerCharge();
    		pc = propertyservicemanagerChargeDao.get(chargeId);
    		pc.setChargeIsbool(o.getChargeIsbool());
    		pc.setChargeCreatetime(o.getChargeCreatetime());
    		pc.setChargeBedate(o.getChargeBedate());
    		pc.setChargeEndate(o.getChargeEndate());
    		pc.setChargeAmount(o.getChargeAmount());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		OrdermanagerUserorder userOrder = pc.getUserorder();
    		userOrder.setUserorderAmount(o.getChargeAmount());
    		ordermanagerUserorderDao.save(userOrder);
    		
    		return propertyservicemanagerChargeDao.save(pc);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return propertyservicemanagerChargeDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerCharge(@ServiceParam(name="chargeId") String id) throws BusException{
    	propertyservicemanagerChargeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerCharges(@ServiceParam(name="chargeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerCharge(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerCharge(@ServiceParam(name="chargeId") String id)  throws BusException{
		return propertyservicemanagerChargeDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerCharge(String propertyName,Object value) throws BusException{
		return propertyservicemanagerChargeDao.exists(propertyName,value);
	}
    
    /**
	 * 获取当前登录用户获取缴费记录
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="createUser",pubProperty="userId")})
	public List<PropertyservicemanagerCharge> getChargeListforpage(PropertyservicemanagerCharge o) throws BusException{
		String id = o.getCreateUser();
		if(id!=null){
	    	//获取当前用户参加活动的list
	    	Collection<Condition> condition = new ArrayList<Condition>();
	    	condition.add(ConditionUtils.getCondition("createUser", Condition.EQUALS, id));
	    	List<PropertyservicemanagerCharge> list = propertyservicemanagerChargeDao.commonQuery(condition, null);
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
