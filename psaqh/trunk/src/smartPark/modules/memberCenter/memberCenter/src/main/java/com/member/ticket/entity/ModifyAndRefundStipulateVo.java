package com.member.ticket.entity;


import com.gsoft.framework.core.dataobj.Domain;

public class ModifyAndRefundStipulateVo implements Domain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  seatId;
	private String  airlineCode;
	private String 	seatCode;
	private Integer	seatType;
	private String 	serviceLevel;//服务级别
	private String 	routeType;//航程类型
	private String 	refundStipulate;//退票规定，需要URLEncoder.decode(text, "utf-8")解码
	private Double 	refundPercentAdvance;//提前退废票率
	private Double 	refundPercentBefore;//起飞前退票费率
	private Double 	refundPercentAfter;//起飞后退票费率
	private String 	refundTimePointAdvance;//提前退票时间点
	private String 	refundTimePoint;//起飞前退票时间点,比如起飞前2小时收取手续费为10%，那么该字段为2
	private String 	modifyStipulate;//签转规定
	private String 	changeStipulate;//更改规定
	private Double 	changePercentAdvance;//提前更改费率
	private Double 	changePercentBefore;
	private Double 	changePercentAfter;
	private String 	changeTimePointAdvance;
	private String 	changeTimePoint;
	private String 	suitableAirline;//适用航线
	private String 	modifiedAt;
	private String 	param1;
	private String 	param2;
	private String 	param3;
	private String 	param4;
	private String 	id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public Integer getSeatType() {
		return seatType;
	}
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	public String getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	public String getRefundStipulate() {
		return refundStipulate;
	}
	public void setRefundStipulate(String refundStipulate) {
		this.refundStipulate = refundStipulate;
	}
	public Double getRefundPercentAdvance() {
		return refundPercentAdvance;
	}
	public void setRefundPercentAdvance(Double refundPercentAdvance) {
		this.refundPercentAdvance = refundPercentAdvance;
	}
	public Double getRefundPercentBefore() {
		return refundPercentBefore;
	}
	public void setRefundPercentBefore(Double refundPercentBefore) {
		this.refundPercentBefore = refundPercentBefore;
	}
	public Double getRefundPercentAfter() {
		return refundPercentAfter;
	}
	public void setRefundPercentAfter(Double refundPercentAfter) {
		this.refundPercentAfter = refundPercentAfter;
	}
	public String getRefundTimePointAdvance() {
		return refundTimePointAdvance;
	}
	public void setRefundTimePointAdvance(String refundTimePointAdvance) {
		this.refundTimePointAdvance = refundTimePointAdvance;
	}
	public String getRefundTimePoint() {
		return refundTimePoint;
	}
	public void setRefundTimePoint(String refundTimePoint) {
		this.refundTimePoint = refundTimePoint;
	}
	public String getModifyStipulate() {
		return modifyStipulate;
	}
	public void setModifyStipulate(String modifyStipulate) {
		this.modifyStipulate = modifyStipulate;
	}
	public String getChangeStipulate() {
		return changeStipulate;
	}
	public void setChangeStipulate(String changeStipulate) {
		this.changeStipulate = changeStipulate;
	}
	public Double getChangePercentAdvance() {
		return changePercentAdvance;
	}
	public void setChangePercentAdvance(Double changePercentAdvance) {
		this.changePercentAdvance = changePercentAdvance;
	}
	public Double getChangePercentBefore() {
		return changePercentBefore;
	}
	public void setChangePercentBefore(Double changePercentBefore) {
		this.changePercentBefore = changePercentBefore;
	}
	public Double getChangePercentAfter() {
		return changePercentAfter;
	}
	public void setChangePercentAfter(Double changePercentAfter) {
		this.changePercentAfter = changePercentAfter;
	}
	public String getChangeTimePointAdvance() {
		return changeTimePointAdvance;
	}
	public void setChangeTimePointAdvance(String changeTimePointAdvance) {
		this.changeTimePointAdvance = changeTimePointAdvance;
	}
	public String getChangeTimePoint() {
		return changeTimePoint;
	}
	public void setChangeTimePoint(String changeTimePoint) {
		this.changeTimePoint = changeTimePoint;
	}
	public String getSuitableAirline() {
		return suitableAirline;
	}
	public void setSuitableAirline(String suitableAirline) {
		this.suitableAirline = suitableAirline;
	}
	public String getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
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
