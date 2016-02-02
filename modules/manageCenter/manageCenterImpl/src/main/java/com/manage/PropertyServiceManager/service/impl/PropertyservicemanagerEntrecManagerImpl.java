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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEntrecDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEntrecManager;

@Service("propertyservicemanagerEntrecManager")
@Transactional
public class PropertyservicemanagerEntrecManagerImpl extends BaseManagerImpl implements PropertyservicemanagerEntrecManager{
	@Autowired
	private PropertyservicemanagerEntrecDao propertyservicemanagerEntrecDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs() throws BusException{
    	return propertyservicemanagerEntrecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerEntrecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntrec getPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
    	return propertyservicemanagerEntrecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerEntrecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerEntrecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntrec savePropertyservicemanagerEntrec(PropertyservicemanagerEntrec o) throws BusException{
//    	String propertyservicemanagerEntrecId = o.getPropertyservicemanagerEntrecId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerEntrecId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerEntrecDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id) throws BusException{
    	propertyservicemanagerEntrecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEntrecs(@ServiceParam(name="entrecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerEntrec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
		return propertyservicemanagerEntrecDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerEntrec(String propertyName,Object value) throws BusException{
		return propertyservicemanagerEntrecDao.exists(propertyName,value);
	}

}
