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

import com.common.OrderManager.entity.OrdermanagerOrdermerchanNexus;
import com.common.OrderManager.dao.OrdermanagerOrdermerchanNexusDao;
import com.common.OrderManager.service.OrdermanagerOrdermerchanNexusManager;

@Service("ordermanagerOrdermerchanNexusManager")
@Transactional
public class OrdermanagerOrdermerchanNexusManagerImpl extends BaseManagerImpl implements OrdermanagerOrdermerchanNexusManager{
	@Autowired
	private OrdermanagerOrdermerchanNexusDao ordermanagerOrdermerchanNexusDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerOrdermerchanNexus> getOrdermanagerOrdermerchanNexuss() throws BusException{
    	return ordermanagerOrdermerchanNexusDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerOrdermerchanNexus> getOrdermanagerOrdermerchanNexuss(
    	@ConditionCollection(domainClazz=OrdermanagerOrdermerchanNexus.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerOrdermerchanNexusDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerOrdermerchanNexus getOrdermanagerOrdermerchanNexus(@ServiceParam(name="ordermerchanNexusId") String id)  throws BusException{
    	return ordermanagerOrdermerchanNexusDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerOrdermerchanNexuss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerOrdermerchanNexus.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerOrdermerchanNexusDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerOrdermerchanNexus saveOrdermanagerOrdermerchanNexus(OrdermanagerOrdermerchanNexus o) throws BusException{
//    	String ordermanagerOrdermerchanNexusId = o.getOrdermanagerOrdermerchanNexusId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerOrdermerchanNexusId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerOrdermerchanNexusDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerOrdermerchanNexus(@ServiceParam(name="ordermerchanNexusId") String id) throws BusException{
    	ordermanagerOrdermerchanNexusDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrdermerchanNexuss(@ServiceParam(name="ordermerchanNexusId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerOrdermerchanNexus(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerOrdermerchanNexus(@ServiceParam(name="ordermerchanNexusId") String id)  throws BusException{
		return ordermanagerOrdermerchanNexusDao.exists(id);
	}
    
    public boolean exsitOrdermanagerOrdermerchanNexus(String propertyName,Object value) throws BusException{
		return ordermanagerOrdermerchanNexusDao.exists(propertyName,value);
	}

}
