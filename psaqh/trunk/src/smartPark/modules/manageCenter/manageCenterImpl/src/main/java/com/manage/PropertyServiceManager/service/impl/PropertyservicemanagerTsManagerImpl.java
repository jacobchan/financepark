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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTsDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;

@Service("propertyservicemanagerTsManager")
@Transactional
public class PropertyservicemanagerTsManagerImpl extends BaseManagerImpl implements PropertyservicemanagerTsManager{
	@Autowired
	private PropertyservicemanagerTsDao propertyservicemanagerTsDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss() throws BusException{
    	return propertyservicemanagerTsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerTs> getPropertyservicemanagerTss(
    	@ConditionCollection(domainClazz=PropertyservicemanagerTs.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerTsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerTs getPropertyservicemanagerTs(@ServiceParam(name="tsId") String id)  throws BusException{
    	return propertyservicemanagerTsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerTss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerTs.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerTsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerTs savePropertyservicemanagerTs(PropertyservicemanagerTs o) throws BusException{
//    	String propertyservicemanagerTsId = o.getPropertyservicemanagerTsId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerTsId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerTsDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerTs(@ServiceParam(name="tsId") String id) throws BusException{
    	propertyservicemanagerTsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerTss(@ServiceParam(name="tsId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerTs(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerTs(@ServiceParam(name="tsId") String id)  throws BusException{
		return propertyservicemanagerTsDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerTs(String propertyName,Object value) throws BusException{
		return propertyservicemanagerTsDao.exists(propertyName,value);
	}

}
