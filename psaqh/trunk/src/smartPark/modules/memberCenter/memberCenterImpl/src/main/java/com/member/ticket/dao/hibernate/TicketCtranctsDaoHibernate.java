/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketCtrancts;
import com.member.ticket.dao.TicketCtranctsDao;

@Repository("TicketCtranctsDao")
public class TicketCtranctsDaoHibernate extends 
		BaseDaoHibernate<TicketCtrancts, String> implements TicketCtranctsDao{
	public Class<TicketCtrancts> getModelClazz(){
		return TicketCtrancts.class;
	}
}