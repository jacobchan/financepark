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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEnteringDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEnteringManager;

@Service("propertyservicemanagerEnteringManager")
@Transactional
public class PropertyservicemanagerEnteringManagerImpl extends BaseManagerImpl implements PropertyservicemanagerEnteringManager{
	@Autowired
	private PropertyservicemanagerEnteringDao propertyservicemanagerEnteringDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings() throws BusException{
    	return propertyservicemanagerEnteringDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings(
    	@ConditionCollection(domainClazz=PropertyservicemanagerEntering.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerEnteringDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntering getPropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id)  throws BusException{
    	return propertyservicemanagerEnteringDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerEnterings(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntering.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerEnteringDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntering savePropertyservicemanagerEntering(PropertyservicemanagerEntering o) throws BusException{
//    	String propertyservicemanagerEnteringId = o.getPropertyservicemanagerEnteringId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerEnteringId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerEnteringDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id) throws BusException{
    	propertyservicemanagerEnteringDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEnterings(@ServiceParam(name="enteringId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerEntering(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id)  throws BusException{
		return propertyservicemanagerEnteringDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerEntering(String propertyName,Object value) throws BusException{
		return propertyservicemanagerEnteringDao.exists(propertyName,value);
	}

}
