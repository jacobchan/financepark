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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.OrderManager.entity.OrdermanagerOrdertype;
import com.common.OrderManager.dao.OrdermanagerOrdertypeDao;
import com.common.OrderManager.service.OrdermanagerOrdertypeManager;

@Service("ordermanagerOrdertypeManager")
@Transactional
public class OrdermanagerOrdertypeManagerImpl extends BaseManagerImpl implements OrdermanagerOrdertypeManager{
	@Autowired
	private OrdermanagerOrdertypeDao ordermanagerOrdertypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerOrdertype> getOrdermanagerOrdertypes() throws BusException{
    	return ordermanagerOrdertypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerOrdertype> getOrdermanagerOrdertypes(
    	@ConditionCollection(domainClazz=OrdermanagerOrdertype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerOrdertypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerOrdertype getOrdermanagerOrdertype(@ServiceParam(name="ordertypeId") String id)  throws BusException{
    	return ordermanagerOrdertypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerOrdertypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerOrdertype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerOrdertypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	/**
	 * 获取企业服务订单类型列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerComSerOrderTypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerOrdertype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("ordertypeId", Condition.LIKE, "05"));
		PagerRecords pagerRecords = ordermanagerOrdertypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "params.userId")})
    public OrdermanagerOrdertype saveOrdermanagerOrdertype(OrdermanagerOrdertype o) throws BusException{
    	String ordermanagerOrdertypeId = o.getOrdertypeId();
    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerOrdertypeId);
    	if(isUpdate){//修改
    		OrdermanagerOrdertype oot = ordermanagerOrdertypeDao.get(ordermanagerOrdertypeId);
    		oot.setOrdertypeName(o.getOrdertypeName());
    		oot.setOrdertypeProjectName(o.getOrdertypeProjectName());
    		oot.setOrdertypeProjectTemplateAddress(o.getOrdertypeProjectTemplateAddress());
    		oot.setUpdateUser(o.getUpdateUser());
    		oot.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerOrdertypeDao.save(oot);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerOrdertypeDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerOrdertype(@ServiceParam(name="ordertypeId") String id) throws BusException{
    	ordermanagerOrdertypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerOrdertypes(@ServiceParam(name="ordertypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerOrdertype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerOrdertype(@ServiceParam(name="ordertypeId") String id)  throws BusException{
		return ordermanagerOrdertypeDao.exists(id);
	}
    
    public boolean exsitOrdermanagerOrdertype(String propertyName,Object value) throws BusException{
		return ordermanagerOrdertypeDao.exists(propertyName,value);
	}

}
