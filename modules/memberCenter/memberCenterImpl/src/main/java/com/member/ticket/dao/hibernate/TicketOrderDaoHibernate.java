/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketOrder;
import com.member.ticket.dao.TicketOrderDao;

@Repository("TicketOrderDao")
public class TicketOrderDaoHibernate extends 
		BaseDaoHibernate<TicketOrder, String> implements TicketOrderDao{
	public Class<TicketOrder> getModelClazz(){
		return TicketOrder.class;
	}
}