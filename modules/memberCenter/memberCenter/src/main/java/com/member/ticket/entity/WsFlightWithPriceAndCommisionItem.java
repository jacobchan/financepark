package com.member.ticket.entity;

import java.util.List;

public class WsFlightWithPriceAndCommisionItem {
	private String date;//	出发日期	String	是	
	private String orgCity;//	出发城市	String	是	
	private String dstCity;//	抵达城市	String	是	
	private Double distance;//	航程公里数	Double	是
	
	private List<WsFlightWithPriceAndCommision> flights;//	航班详细信息	List<WsFlightWithPriceAndCommision>	是	见<WsFlightWithPriceAndCommision>对象

	private Double audletAirportTax;//	成人的机建费	Double	是	以<WsFlightWithPriceAndCommision>对象

	private Double audletFuelTax;//	成人的燃油费	Double	是	以<WsFlightWithPriceAndCommision>对象

	private Double basePrice;//	Y舱价格	Double	是

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getDstCity() {
		return dstCity;
	}

	public void setDstCity(String dstCity) {
		this.dstCity = dstCity;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<WsFlightWithPriceAndCommision> getFlights() {
		return flights;
	}

	public void setFlights(List<WsFlightWithPriceAndCommision> flights) {
		this.flights = flights;
	}

	public Double getAudletAirportTax() {
		return audletAirportTax;
	}

	public void setAudletAirportTax(Double audletAirportTax) {
		this.audletAirportTax = audletAirportTax;
	}

	public Double getAudletFuelTax() {
		return audletFuelTax;
	}

	public void setAudletFuelTax(Double audletFuelTax) {
		this.audletFuelTax = audletFuelTax;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	
}
