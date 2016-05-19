/**
 * 代码声明
 */
package com.member.ticket.dao;

import com.gsoft.framework.core.dao.Dao;
import com.member.ticket.entity.TicketOrder;

public interface TicketOrderDao extends Dao<TicketOrder, String>  {

	TicketOrder findByOrderItem(String itemId);

	void update(TicketOrder ticketOrder);
	
}