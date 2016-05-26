/*
 * 机票查询接口
 */
package com.member.ticket.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.service.BaseManager;
import com.member.ticket.entity.AvailableFlightWithPriceAndCommisionRequest;
import com.member.ticket.entity.CreateOrderByPassengerRequest;
import com.member.ticket.entity.DailyLowestPrice;
import com.member.ticket.entity.ModifyAndRefundStipulateVo;
import com.member.ticket.entity.WSRefundActionType;
import com.member.ticket.entity.WsAirSegment;
import com.member.ticket.entity.WsBookPassenger;
import com.member.ticket.entity.WsBookPnr;
import com.member.ticket.entity.WsFlightWithPriceAndCommisionItem;
import com.member.ticket.entity.WsPolicyOrder;

public interface TicketServiceManager extends BaseManager{
	
	public List<WsFlightWithPriceAndCommisionItem> getFlights(AvailableFlightWithPriceAndCommisionRequest conditions);

	public List<DailyLowestPrice> getDailyLowestPrice(String startDate, String deptCode, String arrCode) throws Exception;

	/*public String bookTicket(String userId, WsBookPnr pnrInfo, String policyId,
			String linkMan, String linkPhone, String parPrice, String fuelTax, String airportTax,
			String otherLinkMethod);*/

	public WsPolicyOrder getOrderInfo(String userId, String orderId);

	public String cancelOrder(String userId, String orderId);

	public ModifyAndRefundStipulateVo getModifyAndRefundStipulate(String airlineCode, String classCode,
			String depDate, String depCode, String arrCode);

	public List<WSRefundActionType> getActionTypeForRefund();

	String bookTicket(String userId, List<WsAirSegment> segments, List<WsBookPassenger> passengers, String policyId,
			String linkMan, String linkPhone, String parPrice, String fuelTax, String airportTax,
			String otherLinkMethod);

//	String bookTicket(String userId, CreateOrderByPassengerRequest createOrderByPassengerRequest);

/*	String bookTicket(String userId, WsBookPnr pnrInfo, String policyId, String linkMan, String linkPhone,
			String otherLinkMethod);*/

	
	 
}
