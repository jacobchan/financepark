/*
 * 机票查询接口
 */
package com.member.ticket.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.service.BaseManager;
import com.member.ticket.entity.AvailableFlightWithPriceAndCommisionRequest;
import com.member.ticket.entity.WsFlightWithPriceAndCommisionItem;

public interface TicketServiceManager extends BaseManager{
	
	public WsFlightWithPriceAndCommisionItem getFlights(AvailableFlightWithPriceAndCommisionRequest conditions);
	 
}
