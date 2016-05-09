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

import com.member.ticket.entity.TicketPassenger;
import com.member.ticket.dao.TicketPassengerDao;
import com.member.ticket.service.TicketPassengerManager;

@Service("ticketPassengerManager")
@Transactional
public class TicketPassengerManagerImpl extends BaseManagerImpl implements TicketPassengerManager{
	@Autowired
	private TicketPassengerDao ticketPassengerDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<TicketPassenger> getTicketPassengers() throws BusException{
    	return ticketPassengerDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<TicketPassenger> getTicketPassengers(
    	@ConditionCollection(domainClazz=TicketPassenger.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ticketPassengerDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public TicketPassenger getTicketPassenger(@ServiceParam(name="passengerId") String id)  throws BusException{
    	return ticketPassengerDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerTicketPassengers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TicketPassenger.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ticketPassengerDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public TicketPassenger saveTicketPassenger(TicketPassenger o) throws BusException{
//    	String ticketPassengerId = o.getTicketPassengerId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ticketPassengerId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ticketPassengerDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeTicketPassenger(@ServiceParam(name="passengerId") String id) throws BusException{
    	ticketPassengerDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeTicketPassengers(@ServiceParam(name="passengerId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeTicketPassenger(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitTicketPassenger(@ServiceParam(name="passengerId") String id)  throws BusException{
		return ticketPassengerDao.exists(id);
	}
    
    public boolean exsitTicketPassenger(String propertyName,Object value) throws BusException{
		return ticketPassengerDao.exists(propertyName,value);
	}

}
