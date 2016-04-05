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

import com.member.applications.entity.Carport;
import com.member.applications.dao.CarportDao;
import com.member.applications.service.CarportManager;

@Service("carportManager")
@Transactional
public class CarportManagerImpl extends BaseManagerImpl implements CarportManager{
	@Autowired
	private CarportDao carportDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Carport> getCarports() throws BusException{
    	return carportDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Carport> getCarports(
    	@ConditionCollection(domainClazz=Carport.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return carportDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Carport getCarport(@ServiceParam(name="id") String id)  throws BusException{
    	return carportDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerCarports(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Carport.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = carportDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public Carport saveCarport(Carport o) throws BusException{
//    	String carportId = o.getCarportId();
//    	boolean isUpdate = StringUtils.isNotEmpty(carportId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return carportDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeCarport(@ServiceParam(name="id") String id) throws BusException{
    	carportDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeCarports(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeCarport(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitCarport(@ServiceParam(name="id") String id)  throws BusException{
		return carportDao.exists(id);
	}
    
    public boolean exsitCarport(String propertyName,Object value) throws BusException{
		return carportDao.exists(propertyName,value);
	}

}
