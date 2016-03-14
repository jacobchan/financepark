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

import com.member.ticket.entity.TicketOrderItem;
import com.member.ticket.dao.TicketOrderItemDao;
import com.member.ticket.service.TicketOrderItemManager;

@Service("ticketOrderItemManager")
@Transactional
public class TicketOrderItemManagerImpl extends BaseManagerImpl implements TicketOrderItemManager{
	@Autowired
	private TicketOrderItemDao ticketOrderItemDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<TicketOrderItem> getTicketOrderItems() throws BusException{
    	return ticketOrderItemDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<TicketOrderItem> getTicketOrderItems(
    	@ConditionCollection(domainClazz=TicketOrderItem.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ticketOrderItemDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public TicketOrderItem getTicketOrderItem(@ServiceParam(name="itemId") String id)  throws BusException{
    	return ticketOrderItemDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerTicketOrderItems(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TicketOrderItem.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ticketOrderItemDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public TicketOrderItem saveTicketOrderItem(TicketOrderItem o) throws BusException{
//    	String ticketOrderItemId = o.getTicketOrderItemId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ticketOrderItemId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ticketOrderItemDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeTicketOrderItem(@ServiceParam(name="itemId") String id) throws BusException{
    	ticketOrderItemDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeTicketOrderItems(@ServiceParam(name="itemId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeTicketOrderItem(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitTicketOrderItem(@ServiceParam(name="itemId") String id)  throws BusException{
		return ticketOrderItemDao.exists(id);
	}
    
    public boolean exsitTicketOrderItem(String propertyName,Object value) throws BusException{
		return ticketOrderItemDao.exists(propertyName,value);
	}

}
