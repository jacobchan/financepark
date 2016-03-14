/**
 * 代码声明
 */
package com.member.ticket.service.impl;

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

import com.member.ticket.entity.TicketOrder;
import com.member.ticket.dao.TicketOrderDao;
import com.member.ticket.service.TicketOrderManager;

@Service("ticketOrderManager")
@Transactional
public class TicketOrderManagerImpl extends BaseManagerImpl implements TicketOrderManager{
	@Autowired
	private TicketOrderDao ticketOrderDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<TicketOrder> getTicketOrders() throws BusException{
    	return ticketOrderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<TicketOrder> getTicketOrders(
    	@ConditionCollection(domainClazz=TicketOrder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ticketOrderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public TicketOrder getTicketOrder(@ServiceParam(name="orderId") String id)  throws BusException{
    	return ticketOrderDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerTicketOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TicketOrder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ticketOrderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public TicketOrder saveTicketOrder(TicketOrder o) throws BusException{
//    	String ticketOrderId = o.getTicketOrderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ticketOrderId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ticketOrderDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeTicketOrder(@ServiceParam(name="orderId") String id) throws BusException{
    	ticketOrderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeTicketOrders(@ServiceParam(name="orderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeTicketOrder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitTicketOrder(@ServiceParam(name="orderId") String id)  throws BusException{
		return ticketOrderDao.exists(id);
	}
    
    public boolean exsitTicketOrder(String propertyName,Object value) throws BusException{
		return ticketOrderDao.exists(propertyName,value);
	}

}
