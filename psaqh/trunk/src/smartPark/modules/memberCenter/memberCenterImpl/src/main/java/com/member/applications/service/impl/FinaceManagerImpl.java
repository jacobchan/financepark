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

import com.member.applications.entity.Finace;
import com.member.applications.dao.FinaceDao;
import com.member.applications.service.FinaceManager;

@Service("finaceManager")
@Transactional
public class FinaceManagerImpl extends BaseManagerImpl implements FinaceManager{
	@Autowired
	private FinaceDao finaceDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Finace> getFinaces() throws BusException{
    	return finaceDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Finace> getFinaces(
    	@ConditionCollection(domainClazz=Finace.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return finaceDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Finace getFinace(@ServiceParam(name="id") String id)  throws BusException{
    	return finaceDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerFinaces(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Finace.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = finaceDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public Finace saveFinace(Finace o) throws BusException{
//    	String finaceId = o.getFinaceId();
//    	boolean isUpdate = StringUtils.isNotEmpty(finaceId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return finaceDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeFinace(@ServiceParam(name="id") String id) throws BusException{
    	finaceDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFinaces(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeFinace(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitFinace(@ServiceParam(name="id") String id)  throws BusException{
		return finaceDao.exists(id);
	}
    
    public boolean exsitFinace(String propertyName,Object value) throws BusException{
		return finaceDao.exists(propertyName,value);
	}

}
