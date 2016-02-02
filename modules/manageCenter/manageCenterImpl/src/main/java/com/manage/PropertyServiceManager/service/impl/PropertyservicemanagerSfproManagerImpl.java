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

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSfproDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSfproManager;

@Service("propertyservicemanagerSfproManager")
@Transactional
public class PropertyservicemanagerSfproManagerImpl extends BaseManagerImpl implements PropertyservicemanagerSfproManager{
	@Autowired
	private PropertyservicemanagerSfproDao propertyservicemanagerSfproDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerSfpro> getPropertyservicemanagerSfpros() throws BusException{
    	return propertyservicemanagerSfproDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerSfpro> getPropertyservicemanagerSfpros(
    	@ConditionCollection(domainClazz=PropertyservicemanagerSfpro.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerSfproDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerSfpro getPropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id)  throws BusException{
    	return propertyservicemanagerSfproDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSfpros(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSfpro.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerSfproDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerSfpro savePropertyservicemanagerSfpro(PropertyservicemanagerSfpro o) throws BusException{
//    	String propertyservicemanagerSfproId = o.getPropertyservicemanagerSfproId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerSfproId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerSfproDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id) throws BusException{
    	propertyservicemanagerSfproDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerSfpros(@ServiceParam(name="sfproId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerSfpro(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id)  throws BusException{
		return propertyservicemanagerSfproDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerSfpro(String propertyName,Object value) throws BusException{
		return propertyservicemanagerSfproDao.exists(propertyName,value);
	}

}
