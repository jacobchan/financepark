/**
 * 代码声明
 */
package com.member.applications.service.impl;

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

import com.member.applications.entity.Entrepreneurship;
import com.member.applications.dao.EntrepreneurshipDao;
import com.member.applications.service.EntrepreneurshipManager;

@Service("entrepreneurshipManager")
@Transactional
public class EntrepreneurshipManagerImpl extends BaseManagerImpl implements EntrepreneurshipManager{
	@Autowired
	private EntrepreneurshipDao entrepreneurshipDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Entrepreneurship> getEntrepreneurships() throws BusException{
    	return entrepreneurshipDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Entrepreneurship> getEntrepreneurships(
    	@ConditionCollection(domainClazz=Entrepreneurship.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return entrepreneurshipDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Entrepreneurship getEntrepreneurship(@ServiceParam(name="id") String id)  throws BusException{
    	return entrepreneurshipDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEntrepreneurships(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Entrepreneurship.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = entrepreneurshipDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public Entrepreneurship saveEntrepreneurship(Entrepreneurship o) throws BusException{
//    	String entrepreneurshipId = o.getEntrepreneurshipId();
//    	boolean isUpdate = StringUtils.isNotEmpty(entrepreneurshipId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return entrepreneurshipDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEntrepreneurship(@ServiceParam(name="id") String id) throws BusException{
    	entrepreneurshipDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEntrepreneurships(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEntrepreneurship(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEntrepreneurship(@ServiceParam(name="id") String id)  throws BusException{
		return entrepreneurshipDao.exists(id);
	}
    
    public boolean exsitEntrepreneurship(String propertyName,Object value) throws BusException{
		return entrepreneurshipDao.exists(propertyName,value);
	}

}
