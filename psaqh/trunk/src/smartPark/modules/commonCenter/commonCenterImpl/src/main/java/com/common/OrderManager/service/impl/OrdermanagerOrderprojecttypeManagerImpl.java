/**
 * 代码声明
 */
package com.common.OrderManager.service.impl;

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

import com.common.OrderManager.entity.OrdermanagerOrderprojecttype;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeDao;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeManager;

@Service("ordermanagerOrderprojecttypeManager")
@Transactional
public class OrdermanagerOrderprojecttypeManagerImpl extends BaseManagerImpl implements OrdermanagerOrderprojecttypeManager{
	@Autowired
	private OrdermanagerOrderprojecttypeDao ordermanagerOrderprojecttypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerOrderprojecttype> getOrdermanagerOrderprojecttypes() throws BusException{
    	return ordermanagerOrderprojecttypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerOrderprojecttype> getOrdermanagerOrderprojecttypes(
    	@ConditionCollection(domainClazz=OrdermanagerOrderprojecttype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerOrderprojecttypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerOrderprojecttype getOrdermanagerOrderprojecttype(@ServiceParam(name="orderprojecttypeId") String id)  throws BusException{
    	return ordermanagerOrderprojecttypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerOrderprojecttypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerOrderprojecttype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerOrderprojecttypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerOrderprojecttype saveOrdermanagerOrderprojecttype(OrdermanagerOrderprojecttype o) throws BusException{
//    	String ordermanagerOrderprojecttypeId = o.getOrdermanagerOrderprojecttypeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerOrderprojecttypeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerOrderprojecttypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerOrderprojecttype(@ServiceParam(name="orderprojecttypeId") String id) throws BusException{
    	ordermanagerOrderprojecttypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrderprojecttypes(@ServiceParam(name="orderprojecttypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerOrderprojecttype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerOrderprojecttype(@ServiceParam(name="orderprojecttypeId") String id)  throws BusException{
		return ordermanagerOrderprojecttypeDao.exists(id);
	}
    
    public boolean exsitOrdermanagerOrderprojecttype(String propertyName,Object value) throws BusException{
		return ordermanagerOrderprojecttypeDao.exists(propertyName,value);
	}

}
