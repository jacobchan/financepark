/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketPassenger;
import com.member.ticket.entity.TicketPassengerRelation;
import com.member.ticket.dao.TicketPassengerDao;

@Repository("TicketPassengerDao")
public class TicketPassengerDaoHibernate extends 
		BaseDaoHibernate<TicketPassenger, String> implements TicketPassengerDao{
	public Class<TicketPassenger> getModelClazz(){
		return TicketPassenger.class;
	}

	@Override
	public TicketPassenger findById(String passengerId) {
		String hql = "from sp_ticket_passenger m where "
				+ "m.PASSENGER_ID = " + passengerId;
		if (!getHibernateTemplate().find(hql).isEmpty()) {
			return (TicketPassenger) getHibernateTemplate().find(hql).get(0);
		}else{
			return null;
		}
	}

	@Override
	public void update(TicketPassenger ticketPassenger) {
		getHibernateTemplate().update(ticketPassenger);
		getHibernateTemplate().flush();		
	}
}