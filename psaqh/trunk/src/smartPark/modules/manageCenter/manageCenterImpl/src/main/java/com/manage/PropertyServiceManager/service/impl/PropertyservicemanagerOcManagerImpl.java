/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerOc;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerOcDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerOcManager;
         
@Service("propertyservicemanagerOcManager")
@Transactional
public class PropertyservicemanagerOcManagerImpl extends BaseManagerImpl implements PropertyservicemanagerOcManager{
	@Autowired
	private PropertyservicemanagerOcDao propertyservicemanagerOcDao;
	/**
     * 修改一卡通预约状态
     */
	 @EsbServiceMapping	
	 public void updateOcStatus(@ServiceParam(name="ocId") String id, @ServiceParam(name="ocStatus") String ocStatus)
				throws BusException {
		// TODO Auto-generated method stub
		
		 PropertyservicemanagerOc o=propertyservicemanagerOcDao.get(id);
	    	o.setOcStatus(ocStatus);
	    	propertyservicemanagerOcDao.save(o);
	}
	/* @EsbServiceMapping
		public void updateUserorderStatus(@ServiceParam(name="userorderId") String id, @ServiceParam(name="userorderStatus") String userorderStatus)
				throws BusException {
			// TODO Auto-generated method stub
	    	OrdermanagerUserorder o=ordermanagerUserorderDao.get(id);
	    	o.setUserorderStatus(userorderStatus);
	    	ordermanagerUserorderDao.save(o);
		}*/
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs() throws BusException{
    	return propertyservicemanagerOcDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerOcDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerOc getPropertyservicemanagerOc(@ServiceParam(name="ocId") String id)  throws BusException{
    	return propertyservicemanagerOcDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerOcs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerOcDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerOc savePropertyservicemanagerOc(PropertyservicemanagerOc o) throws BusException{
//    	String propertyservicemanagerOcId = o.getPropertyservicemanagerOcId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerOcId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerOcDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerOc(@ServiceParam(name="ocId") String id) throws BusException{
    	propertyservicemanagerOcDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerOcs(@ServiceParam(name="ocId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerOc(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerOc(@ServiceParam(name="ocId") String id)  throws BusException{
		return propertyservicemanagerOcDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerOc(String propertyName,Object value) throws BusException{
		return propertyservicemanagerOcDao.exists(propertyName,value);
	}
	

}
