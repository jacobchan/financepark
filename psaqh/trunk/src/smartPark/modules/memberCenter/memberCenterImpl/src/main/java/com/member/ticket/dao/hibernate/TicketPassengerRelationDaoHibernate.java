/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import java.util.List;

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

	@Override
	public List<TicketPassengerRelation> findByItemId(String itemId) {
		String hql = "from sp_ticket_passenger_relation m where "
				+ "m.ITEM_ID_ = " + itemId;
			return getHibernateTemplate().find(hql);
	}
}