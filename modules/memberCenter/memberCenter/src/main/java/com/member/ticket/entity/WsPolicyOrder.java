package com.member.ticket.entity;

import java.util.List;

import com.gsoft.framework.core.dataobj.Domain;

public class WsPolicyOrder implements Domain{
	
	private static final long serialVersionUID = 1L;
	
	private String liantuoOrderNo;
	private String vpolicyId;
	private String status;
	private String createdAt;
	private String commisionPoint;
	private List<WsFlightInfo> flightInfoList;
	private List<WsBookedPassenger> passengerList;
	private WsPaymentInfo paymentInfo;
	private String systemAlipayAccount;
	private String increaseSystemCharge;
	private String supplyOfficeNo;
	private String pnrNo;
	private String param1;
	private String param2;
	private String param3;
	private String param4;

}
