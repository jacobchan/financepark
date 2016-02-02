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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSerDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSerManager;

@Service("propertyservicemanagerSerManager")
@Transactional
public class PropertyservicemanagerSerManagerImpl extends BaseManagerImpl implements PropertyservicemanagerSerManager{
	@Autowired
	private PropertyservicemanagerSerDao propertyservicemanagerSerDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers() throws BusException{
    	return propertyservicemanagerSerDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers(
    	@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerSerDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerSer getPropertyservicemanagerSer(@ServiceParam(name="serId") String id)  throws BusException{
    	return propertyservicemanagerSerDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSer.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerSerDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerSer savePropertyservicemanagerSer(PropertyservicemanagerSer o) throws BusException{
//    	String propertyservicemanagerSerId = o.getPropertyservicemanagerSerId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerSerId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerSerDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerSer(@ServiceParam(name="serId") String id) throws BusException{
    	propertyservicemanagerSerDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerSers(@ServiceParam(name="serId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerSer(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerSer(@ServiceParam(name="serId") String id)  throws BusException{
		return propertyservicemanagerSerDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerSer(String propertyName,Object value) throws BusException{
		return propertyservicemanagerSerDao.exists(propertyName,value);
	}

}
