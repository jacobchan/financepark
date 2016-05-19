/**
 * 代码声明
 */
package com.member.ticket.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.member.ticket.entity.TicketPassengerRelation;

public interface TicketPassengerRelationDao extends Dao<TicketPassengerRelation, String>  {

	List<TicketPassengerRelation> findByItemId(String itemId);
	
}