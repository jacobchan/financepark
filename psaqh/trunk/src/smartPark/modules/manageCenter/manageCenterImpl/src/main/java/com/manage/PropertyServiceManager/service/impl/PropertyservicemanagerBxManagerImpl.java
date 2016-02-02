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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;

@Service("propertyservicemanagerBxManager")
@Transactional
public class PropertyservicemanagerBxManagerImpl extends BaseManagerImpl implements PropertyservicemanagerBxManager{
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	
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
    @EsbServiceMapping
    public PropertyservicemanagerBx savePropertyservicemanagerBx(PropertyservicemanagerBx o) throws BusException{
//    	String propertyservicemanagerBxId = o.getPropertyservicemanagerBxId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerBxId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerBxDao.save(o);
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

}
