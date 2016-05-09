/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketPassenger;
import com.member.ticket.dao.TicketPassengerDao;

@Repository("TicketPassengerDao")
public class TicketPassengerDaoHibernate extends 
		BaseDaoHibernate<TicketPassenger, String> implements TicketPassengerDao{
	public Class<TicketPassenger> getModelClazz(){
		return TicketPassenger.class;
	}
}