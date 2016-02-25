/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
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
    @EsbServiceMapping
    public PropertyservicemanagerCharge savePropertyservicemanagerCharge(PropertyservicemanagerCharge o,
    		@ServiceParam(name="propertyFee") String propertyFee,@ServiceParam(name="waterFee") String waterFee,
    		@ServiceParam(name="powerFee") String powerFee) throws BusException{
    	PropertyservicemanagerCharge pc = new PropertyservicemanagerCharge();
    	String chargeId = o.getChargeId();
    	boolean isUpdate = StringUtils.isNotEmpty(chargeId);
    	if(isUpdate){//修改
    		pc = propertyservicemanagerChargeDao.get(chargeId);
    		pc.setBbmRoom(o.getBbmRoom());
    		pc.setChargeIsbool(o.getChargeIsbool());
    		pc.setChargeCreatetime(o.getChargeCreatetime());
    		pc.setChargeBedate(o.getChargeBedate());
    		pc.setChargeEndate(o.getChargeEndate());
    		
    		BigDecimal chargeAmount = propertyservicemanagerSfproManager.getChargeAmountByCharge(pc);
    		
    		OrdermanagerUserorder userOrder = pc.getUserorder();
    		userOrder.setUserorderAmount(chargeAmount);
    		ordermanagerUserorderDao.save(userOrder);
    		
    		pc.setChargeAmount(chargeAmount);
    		pc = propertyservicemanagerChargeDao.save(pc);
    	}else{//新增
    		OrdermanagerUserorder userOrder = new OrdermanagerUserorder();
    		userOrder.setUserorderAmount(BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP));
    		userOrder.setUserorderCode("123");
    		userOrder = ordermanagerUserorderDao.save(userOrder);
    		o.setUserorder(userOrder);
    		o.setChargeAmount(BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP));
    		pc = propertyservicemanagerChargeDao.save(o);
    	}
    	return pc;
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

}
