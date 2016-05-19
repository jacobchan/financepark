/**
 * 代码声明
 */
package com.member.ticket.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.member.ticket.entity.TicketOrderItem;

public interface TicketOrderItemDao extends Dao<TicketOrderItem, String>  {

	List<TicketOrderItem> findByThirdOrderId(String orderId);
	
}