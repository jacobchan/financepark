/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketPassengerRelation;
import com.member.ticket.dao.TicketPassengerRelationDao;

@Repository("TicketPassengerRelationDao")
public class TicketPassengerRelationDaoHibernate extends 
		BaseDaoHibernate<TicketPassengerRelation, String> implements TicketPassengerRelationDao{
	public Class<TicketPassengerRelation> getModelClazz(){
		return TicketPassengerRelation.class;
	}
}