package com.member.ticket.entity;

import java.util.List;

import org.hibernate.annotations.Entity;

@Entity
public class WsFlightWithPriceAndCommision {
	private Boolean codeShare;//	是否共享航班	Boolean	否	
	private String shareNum;//	共享航班号	String	否	共享航班中的实际承运航班
	private String flightNo;//	航班号	String	是	
	private String link;//	联接协议级别	String	是	
	private String orgCity;//	出发城市	String	是	
	private String dstCity;//	抵达城市	String	是	
	private String depTime;//	起飞时间	String	是	
	private String depModifyTime;//	起飞修正时间	String	否	
	private String arriTime;//	降落时间	String	是	
	private String arriModifyTime;//	降落修正时间	String	否	
	private String meal;//	餐食标识	String	是	
	private String planeType;//	机型	String	是	除CR2、CRJ、EMB、ERJ、MA6	5种小机型没有机场建设费，其他机型收取机场建设费
	private Integer stopnum;//	经停次数	Integer	是	
	private Boolean isElectronicTicket;//	是否电子客票	Boolean	是	
	private String orgJetquay;//	始发航站楼	String	否	
	private String dstJetquay;//	到达航站楼	String	否	
	private List<WsSeatWithPriceAndCommisionItem> seatItems;//	舱位信息	List<WsSeatWithPriceAndCommisionItem>	是	见<WsSeatWithPriceAndCommisionItem>对象
	private Double airportTax;//	成人的机建费	Double	是	
	private Double fuelTax;//	成人的燃油费	Double	是
	
	public Boolean getCodeShare() {
		return codeShare;
	}
	public void setCodeShare(Boolean codeShare) {
		this.codeShare = codeShare;
	}
	public String getShareNum() {
		return shareNum;
	}
	public void setShareNum(String shareNum) {
		this.shareNum = shareNum;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		StringBuilder sb=new StringBuilder(depTime);
		sb.insert(2, ':');
		this.depTime = sb.toString();
	}
	public String getDepModifyTime() {
		return depModifyTime;
	}
	public void setDepModifyTime(String depModifyTime) {
		this.depModifyTime = depModifyTime;
	}
	public String getArriTime() {
		return arriTime;
	}
	public void setArriTime(String arriTime) {
		StringBuilder sb=new StringBuilder(arriTime);
		sb.insert(2, ':');
		this.arriTime = sb.toString();
	}
	public String getArriModifyTime() {
		return arriModifyTime;
	}
	public void setArriModifyTime(String arriModifyTime) {
		this.arriModifyTime = arriModifyTime;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public Integer getStopnum() {
		return stopnum;
	}
	public void setStopnum(Integer stopnum) {
		this.stopnum = stopnum;
	}
	public Boolean getIsElectronicTicket() {
		return isElectronicTicket;
	}
	public void setIsElectronicTicket(Boolean isElectronicTicket) {
		this.isElectronicTicket = isElectronicTicket;
	}
	public String getOrgJetquay() {
		return orgJetquay;
	}
	public void setOrgJetquay(String orgJetquay) {
		this.orgJetquay = orgJetquay;
	}
	public String getDstJetquay() {
		return dstJetquay;
	}
	public void setDstJetquay(String dstJetquay) {
		this.dstJetquay = dstJetquay;
	}
	public List<WsSeatWithPriceAndCommisionItem> getSeatItems() {
		return seatItems;
	}
	public void setSeatItems(List<WsSeatWithPriceAndCommisionItem> seatItems) {
		this.seatItems = seatItems;
	}
	public Double getAirportTax() {
		return airportTax;
	}
	public void setAirportTax(Double airportTax) {
		this.airportTax = airportTax;
	}
	public Double getFuelTax() {
		return fuelTax;
	}
	public void setFuelTax(Double fuelTax) {
		this.fuelTax = fuelTax;
	}
	
}
