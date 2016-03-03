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
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.service.OrdermanagerUserorderManager;

@Service("ordermanagerUserorderManager")
@Transactional
public class OrdermanagerUserorderManagerImpl extends BaseManagerImpl implements OrdermanagerUserorderManager{
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders() throws BusException{
    	return ordermanagerUserorderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders(
    	@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerUserorderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerUserorder getOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
    	return ordermanagerUserorderDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerUserorders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存订单
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public OrdermanagerUserorder saveOrdermanagerUserorder(OrdermanagerUserorder o) throws BusException{
    	String UserorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(UserorderId);
    	if(isUpdate){//修改
    	
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setMemberId(o.getUpdateUser());
    	}
    	return ordermanagerUserorderDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerUserorder(@ServiceParam(name="userorderId") String id) throws BusException{
    	ordermanagerUserorderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerUserorders(@ServiceParam(name="userorderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerUserorder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
		return ordermanagerUserorderDao.exists(id);
	}
    
    public boolean exsitOrdermanagerUserorder(String propertyName,Object value) throws BusException{
		return ordermanagerUserorderDao.exists(propertyName,value);
	}
    /**
	 * 获取企业服务订单列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerComSerOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("ordermanagerOrdertype.ordertypeId", Condition.LIKE, "05"));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
}
