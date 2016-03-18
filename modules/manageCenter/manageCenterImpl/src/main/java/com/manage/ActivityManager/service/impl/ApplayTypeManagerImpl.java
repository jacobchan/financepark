/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

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

import com.manage.ActivityManager.entity.ApplayType;
import com.manage.ActivityManager.dao.ApplayTypeDao;
import com.manage.ActivityManager.service.ApplayTypeManager;

@Service("applayTypeManager")
@Transactional
public class ApplayTypeManagerImpl extends BaseManagerImpl implements ApplayTypeManager{
	@Autowired
	private ApplayTypeDao applayTypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ApplayType> getApplayTypes() throws BusException{
    	return applayTypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ApplayType> getApplayTypes(
    	@ConditionCollection(domainClazz=ApplayType.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return applayTypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ApplayType getApplayType(@ServiceParam(name="typeId") String id)  throws BusException{
    	return applayTypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerApplayTypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ApplayType.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = applayTypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ApplayType saveApplayType(ApplayType o) throws BusException{
//    	String applayTypeId = o.getApplayTypeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(applayTypeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return applayTypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeApplayType(@ServiceParam(name="typeId") String id) throws BusException{
    	applayTypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeApplayTypes(@ServiceParam(name="typeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeApplayType(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitApplayType(@ServiceParam(name="typeId") String id)  throws BusException{
		return applayTypeDao.exists(id);
	}
    
    public boolean exsitApplayType(String propertyName,Object value) throws BusException{
		return applayTypeDao.exists(propertyName,value);
	}

}
