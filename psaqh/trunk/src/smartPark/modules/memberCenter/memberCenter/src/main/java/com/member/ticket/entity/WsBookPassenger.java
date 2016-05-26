package com.member.ticket.entity;

import com.gsoft.framework.core.dataobj.Domain;

public class WsBookPassenger implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 456L;
	private String name;
	private String type;
	private String identityType;
	private String identityNo;
	private String birthday;
	//订单返回包括以下信息
	private String parPrice;//票面价
	private String settlePrice;//结算价
	private String fuelTax;//燃油费
	private String airportTax;//机建费
	
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
		return param4;
	}
	public void setParam4(String param4) {
		this.param4 = param4;
	}
	public String getParPrice() {
		return parPrice;
	}
	public void setParPrice(String parPrice) {
		this.parPrice = parPrice;
	}
	public String getSettlePrice() {
		return settlePrice;
	}
	public void setSettlePrice(String settlePrice) {
		this.settlePrice = settlePrice;
	}
	public String getFuelTax() {
		return fuelTax;
	}
	public void setFuelTax(String fuelTax) {
		this.fuelTax = fuelTax;
	}
	public String getAirportTax() {
		return airportTax;
	}
	public void setAirportTax(String airportTax) {
		this.airportTax = airportTax;
	}

}
