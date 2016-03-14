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

import com.member.ticket.entity.TicketCtrancts;
import com.member.ticket.dao.TicketCtranctsDao;
import com.member.ticket.service.TicketCtranctsManager;

@Service("ticketCtranctsManager")
@Transactional
public class TicketCtranctsManagerImpl extends BaseManagerImpl implements TicketCtranctsManager{
	@Autowired
	private TicketCtranctsDao ticketCtranctsDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<TicketCtrancts> getTicketCtranctss() throws BusException{
    	return ticketCtranctsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<TicketCtrancts> getTicketCtranctss(
    	@ConditionCollection(domainClazz=TicketCtrancts.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ticketCtranctsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public TicketCtrancts getTicketCtrancts(@ServiceParam(name="recId") String id)  throws BusException{
    	return ticketCtranctsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerTicketCtranctss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TicketCtrancts.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ticketCtranctsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public TicketCtrancts saveTicketCtrancts(TicketCtrancts o) throws BusException{
//    	String ticketCtranctsId = o.getTicketCtranctsId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ticketCtranctsId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ticketCtranctsDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeTicketCtrancts(@ServiceParam(name="recId") String id) throws BusException{
    	ticketCtranctsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeTicketCtranctss(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeTicketCtrancts(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitTicketCtrancts(@ServiceParam(name="recId") String id)  throws BusException{
		return ticketCtranctsDao.exists(id);
	}
    
    public boolean exsitTicketCtrancts(String propertyName,Object value) throws BusException{
		return ticketCtranctsDao.exists(propertyName,value);
	}

}
