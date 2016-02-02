/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerChargeDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerChargeManager;

@Service("propertyservicemanagerChargeManager")
@Transactional
public class PropertyservicemanagerChargeManagerImpl extends BaseManagerImpl implements PropertyservicemanagerChargeManager{
	@Autowired
	private PropertyservicemanagerChargeDao propertyservicemanagerChargeDao;
	
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
    public PropertyservicemanagerCharge savePropertyservicemanagerCharge(PropertyservicemanagerCharge o) throws BusException{
//    	String propertyservicemanagerChargeId = o.getPropertyservicemanagerChargeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerChargeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerChargeDao.save(o);
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
