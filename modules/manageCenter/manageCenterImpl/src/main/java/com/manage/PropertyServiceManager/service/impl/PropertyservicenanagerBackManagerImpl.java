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

import com.manage.PropertyServiceManager.entity.PropertyservicenanagerBack;
import com.manage.PropertyServiceManager.dao.PropertyservicenanagerBackDao;
import com.manage.PropertyServiceManager.service.PropertyservicenanagerBackManager;

@Service("propertyservicenanagerBackManager")
@Transactional
public class PropertyservicenanagerBackManagerImpl extends BaseManagerImpl implements PropertyservicenanagerBackManager{
	@Autowired
	private PropertyservicenanagerBackDao propertyservicenanagerBackDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicenanagerBack> getPropertyservicenanagerBacks() throws BusException{
    	return propertyservicenanagerBackDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicenanagerBack> getPropertyservicenanagerBacks(
    	@ConditionCollection(domainClazz=PropertyservicenanagerBack.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicenanagerBackDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicenanagerBack getPropertyservicenanagerBack(@ServiceParam(name="backId") String id)  throws BusException{
    	return propertyservicenanagerBackDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicenanagerBacks(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicenanagerBack.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicenanagerBackDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicenanagerBack savePropertyservicenanagerBack(PropertyservicenanagerBack o) throws BusException{
//    	String propertyservicenanagerBackId = o.getPropertyservicenanagerBackId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicenanagerBackId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicenanagerBackDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicenanagerBack(@ServiceParam(name="backId") String id) throws BusException{
    	propertyservicenanagerBackDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicenanagerBacks(@ServiceParam(name="backId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicenanagerBack(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicenanagerBack(@ServiceParam(name="backId") String id)  throws BusException{
		return propertyservicenanagerBackDao.exists(id);
	}
    
    public boolean exsitPropertyservicenanagerBack(String propertyName,Object value) throws BusException{
		return propertyservicenanagerBackDao.exists(propertyName,value);
	}

}
