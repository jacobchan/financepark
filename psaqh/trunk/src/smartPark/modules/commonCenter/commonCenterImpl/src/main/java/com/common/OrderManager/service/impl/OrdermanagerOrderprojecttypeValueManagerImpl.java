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

import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeValueDao;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;

@Service("ordermanagerOrderprojecttypeValueManager")
@Transactional
public class OrdermanagerOrderprojecttypeValueManagerImpl extends BaseManagerImpl implements OrdermanagerOrderprojecttypeValueManager{
	@Autowired
	private OrdermanagerOrderprojecttypeValueDao ordermanagerOrderprojecttypeValueDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerOrderprojecttypeValue> getOrdermanagerOrderprojecttypeValues() throws BusException{
    	return ordermanagerOrderprojecttypeValueDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerOrderprojecttypeValue> getOrdermanagerOrderprojecttypeValues(
    	@ConditionCollection(domainClazz=OrdermanagerOrderprojecttypeValue.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerOrderprojecttypeValueDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerOrderprojecttypeValue getOrdermanagerOrderprojecttypeValue(@ServiceParam(name="orderprojecttypeValueId") String id)  throws BusException{
    	return ordermanagerOrderprojecttypeValueDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerOrderprojecttypeValues(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerOrderprojecttypeValue.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerOrderprojecttypeValueDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerOrderprojecttypeValue saveOrdermanagerOrderprojecttypeValue(OrdermanagerOrderprojecttypeValue o) throws BusException{
//    	String ordermanagerOrderprojecttypeValueId = o.getOrdermanagerOrderprojecttypeValueId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerOrderprojecttypeValueId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerOrderprojecttypeValueDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerOrderprojecttypeValue(@ServiceParam(name="orderprojecttypeValueId") String id) throws BusException{
    	ordermanagerOrderprojecttypeValueDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrderprojecttypeValues(@ServiceParam(name="orderprojecttypeValueId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerOrderprojecttypeValue(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerOrderprojecttypeValue(@ServiceParam(name="orderprojecttypeValueId") String id)  throws BusException{
		return ordermanagerOrderprojecttypeValueDao.exists(id);
	}
    
    public boolean exsitOrdermanagerOrderprojecttypeValue(String propertyName,Object value) throws BusException{
		return ordermanagerOrderprojecttypeValueDao.exists(propertyName,value);
	}

}
