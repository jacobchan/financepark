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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerFkcodeDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerFkcodeManager;

@Service("propertyservicemanagerFkcodeManager")
@Transactional
public class PropertyservicemanagerFkcodeManagerImpl extends BaseManagerImpl implements PropertyservicemanagerFkcodeManager{
	@Autowired
	private PropertyservicemanagerFkcodeDao propertyservicemanagerFkcodeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes() throws BusException{
    	return propertyservicemanagerFkcodeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes(
    	@ConditionCollection(domainClazz=PropertyservicemanagerFkcode.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerFkcodeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerFkcode getPropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id)  throws BusException{
    	return propertyservicemanagerFkcodeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerFkcodes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerFkcode.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerFkcodeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerFkcode savePropertyservicemanagerFkcode(PropertyservicemanagerFkcode o) throws BusException{
//    	String propertyservicemanagerFkcodeId = o.getPropertyservicemanagerFkcodeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerFkcodeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerFkcodeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id) throws BusException{
    	propertyservicemanagerFkcodeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerFkcodes(@ServiceParam(name="fkcodeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerFkcode(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id)  throws BusException{
		return propertyservicemanagerFkcodeDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerFkcode(String propertyName,Object value) throws BusException{
		return propertyservicemanagerFkcodeDao.exists(propertyName,value);
	}

}
