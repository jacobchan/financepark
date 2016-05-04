package com.member.ticket.entity;

import java.util.List;

public class WsBookPnr {
	private List<WsAirSegment> segments;
	private List<WsBookPassenger> passengers;
	private Double parPrice;//票面价
	private Double uelTax;//燃油税
	private Double airportTax;//机建费
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	
	public List<WsAirSegment> getSegments() {
		return segments;
	}
	public void setSegments(List<WsAirSegment> segments) {
		this.segments = segments;
	}
	public List<WsBookPassenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<WsBookPassenger> passengers) {
		this.passengers = passengers;
	}
	public Double getParPrice() {
		return parPrice;
	}
	public void setParPrice(Double parPrice) {
		this.parPrice = parPrice;
	}
	public Double getUelTax() {
		return uelTax;
	}
	public void setUelTax(Double uelTax) {
		this.uelTax = uelTax;
	}
	public Double getAirportTax() {
		return airportTax;
	}
	public void setAirportTax(Double airportTax) {
		this.airportTax = airportTax;
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
	
}
