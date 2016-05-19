/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketOrder;
import com.member.ticket.entity.TicketPassengerRelation;
import com.member.ticket.dao.TicketOrderDao;

@Repository("TicketOrderDao")
public class TicketOrderDaoHibernate extends 
		BaseDaoHibernate<TicketOrder, String> implements TicketOrderDao{
	public Class<TicketOrder> getModelClazz(){
		return TicketOrder.class;
	}

	@Override
	public TicketOrder findByOrderItem(String itemId) {
		String hql = "from sp_ticket_order m where "
				+ "m.ITEM_ID_ = " + itemId;
		if (!getHibernateTemplate().find(hql).isEmpty()) {
			return (TicketOrder) getHibernateTemplate().find(hql).get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public void update(TicketOrder ticketOrder) {
		getHibernateTemplate().update(ticketOrder);
		getHibernateTemplate().flush();
	}
}