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

import com.member.ticket.entity.TicketPassengerRelation;
import com.member.ticket.dao.TicketPassengerRelationDao;
import com.member.ticket.service.TicketPassengerRelationManager;

@Service("ticketPassengerRelationManager")
@Transactional
public class TicketPassengerRelationManagerImpl extends BaseManagerImpl implements TicketPassengerRelationManager{
	@Autowired
	private TicketPassengerRelationDao ticketPassengerRelationDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<TicketPassengerRelation> getTicketPassengerRelations() throws BusException{
    	return ticketPassengerRelationDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<TicketPassengerRelation> getTicketPassengerRelations(
    	@ConditionCollection(domainClazz=TicketPassengerRelation.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ticketPassengerRelationDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public TicketPassengerRelation getTicketPassengerRelation(@ServiceParam(name="ticketPassengerId") String id)  throws BusException{
    	return ticketPassengerRelationDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerTicketPassengerRelations(Pager pager,//分页条件
			@ConditionCollection(domainClazz=TicketPassengerRelation.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ticketPassengerRelationDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public TicketPassengerRelation saveTicketPassengerRelation(TicketPassengerRelation o) throws BusException{
//    	String ticketPassengerRelationId = o.getTicketPassengerRelationId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ticketPassengerRelationId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ticketPassengerRelationDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeTicketPassengerRelation(@ServiceParam(name="ticketPassengerId") String id) throws BusException{
    	ticketPassengerRelationDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeTicketPassengerRelations(@ServiceParam(name="ticketPassengerId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeTicketPassengerRelation(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitTicketPassengerRelation(@ServiceParam(name="ticketPassengerId") String id)  throws BusException{
		return ticketPassengerRelationDao.exists(id);
	}
    
    public boolean exsitTicketPassengerRelation(String propertyName,Object value) throws BusException{
		return ticketPassengerRelationDao.exists(propertyName,value);
	}

}
