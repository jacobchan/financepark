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
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerCommoditydetailDao;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeValueDao;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.service.OrdermanagerUserorderManager;

@Service("ordermanagerUserorderManager")
@Transactional
public class OrdermanagerUserorderManagerImpl extends BaseManagerImpl implements OrdermanagerUserorderManager{
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private OrdermanagerCommoditydetailDao ordermanagerCommoditydetailDao;
	@Autowired
	private OrdermanagerOrderprojecttypeValueDao ordermanagerOrderprojecttypeValueDao;
	
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
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerUserorder saveOrdermanagerUserorder(OrdermanagerUserorder o) throws BusException{
//    	String ordermanagerUserorderId = o.getOrdermanagerUserorderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerUserorderDao.save(o);
    }
    /**
     * 保存订单
     */
    @EsbServiceMapping
    public OrdermanagerUserorder saveOrder(OrdermanagerUserorder o,List<OrdermanagerCommoditydetail> orderDetailList,
    		List<OrdermanagerOrderprojecttypeValue> orderExtendList) throws BusException{
    	o = ordermanagerUserorderDao.save(o);
    	for(OrdermanagerCommoditydetail orderDetail:orderDetailList){
    		orderDetail.setOrdermanagerUserorder(o);
    		ordermanagerCommoditydetailDao.save(orderDetail);
    	}
    	for(OrdermanagerOrderprojecttypeValue orderExtendValue:orderExtendList){
    		orderExtendValue.setOrdermanagerUserorder(o);
    		ordermanagerOrderprojecttypeValueDao.save(orderExtendValue);
    	}
    	return o;
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
