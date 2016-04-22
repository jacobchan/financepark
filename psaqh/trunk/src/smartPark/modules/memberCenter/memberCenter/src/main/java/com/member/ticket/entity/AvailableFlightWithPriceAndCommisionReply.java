package com.member.ticket.entity;

import java.util.List;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
public class AvailableFlightWithPriceAndCommisionReply implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String returnCode;
	
	private String returnMessage;
	
	private List<WsFlightWithPriceAndCommisionItem> flightItems;
	
	private String param1;
	
	private String param2;
	
	private String param3;
	
	private String Param4;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public List<WsFlightWithPriceAndCommisionItem> getFlightItems() {
		return flightItems;
	}

	public void setFlightItems(List<WsFlightWithPriceAndCommisionItem> flightItems) {
		this.flightItems = flightItems;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return Param4;
	}

	public void setParam4(String param4) {
		Param4 = param4;
	}
	
}
