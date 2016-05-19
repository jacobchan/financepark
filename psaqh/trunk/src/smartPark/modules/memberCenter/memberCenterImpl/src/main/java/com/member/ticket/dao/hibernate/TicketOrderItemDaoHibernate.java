/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.TicketOrderItem;
import com.member.ticket.dao.TicketOrderItemDao;

@Repository("TicketOrderItemDao")
public class TicketOrderItemDaoHibernate extends 
		BaseDaoHibernate<TicketOrderItem, String> implements TicketOrderItemDao{
	public Class<TicketOrderItem> getModelClazz(){
		return TicketOrderItem.class;
	}

	@Override
	public List<TicketOrderItem> findByThirdOrderId(String orderId) {
		String hql = "from sp_ticket_order_item m where "
				+ "m.ORDER_ID_THIRD = " + orderId;
		return getHibernateTemplate().find(hql);
	}
}