package com.member.ticket.entity;

import java.util.List;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
public class WsPolicyOrder implements Domain{
	
	private static final long serialVersionUID = 1L;
	
	private String liantuoOrderNo;//下单成功后返回的订单的订单号
	private String orderNo;//详情接口返回的订单号
	private String policyId;
	private WsPolicyData policyData;//详情接口返回的政策数据
	private String status;
	private String createdAt;
	private String commisionPoint;
	private List<WsAirSegment> flightInfoList;
	private List<WsBookPassenger> passengerList;
	private WsPaymentInfo paymentInfo;
	private String systemAlipayAccount;
	private String increaseSystemCharge;
	private String supplyOfficeNo;
	private String pnrNo;
	private String oldPnrNo;//详情接口 旧pnr
	private String pnrTxt;//详情接口 pnr文本
	private String patTxt;//详情接口pata文本
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	
	public String getLiantuoOrderNo() {
		return liantuoOrderNo;
	}
	public void setLiantuoOrderNo(String liantuoOrderNo) {
		this.liantuoOrderNo = liantuoOrderNo;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getCommisionPoint() {
		return commisionPoint;
	}
	public void setCommisionPoint(String commisionPoint) {
		this.commisionPoint = commisionPoint;
	}
	public List<WsAirSegment> getFlightInfoList() {
		return flightInfoList;
	}
	public void setFlightInfoList(List<WsAirSegment> flightInfoList) {
		this.flightInfoList = flightInfoList;
	}
	public List<WsBookPassenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<WsBookPassenger> passengerList) {
		this.passengerList = passengerList;
	}
	public WsPaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(WsPaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public String getSystemAlipayAccount() {
		return systemAlipayAccount;
	}
	public void setSystemAlipayAccount(String systemAlipayAccount) {
		this.systemAlipayAccount = systemAlipayAccount;
	}
	public String getIncreaseSystemCharge() {
		return increaseSystemCharge;
	}
	public void setIncreaseSystemCharge(String increaseSystemCharge) {
		this.increaseSystemCharge = increaseSystemCharge;
	}
	public String getSupplyOfficeNo() {
		return supplyOfficeNo;
	}
	public void setSupplyOfficeNo(String supplyOfficeNo) {
		this.supplyOfficeNo = supplyOfficeNo;
	}
	public String getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public WsPolicyData getPolicyData() {
		return policyData;
	}
	public void setPolicyData(WsPolicyData policyData) {
		this.policyData = policyData;
	}
	public String getOldPnrNo() {
		return oldPnrNo;
	}
	public void setOldPnrNo(String oldPnrNo) {
		this.oldPnrNo = oldPnrNo;
	}
	public String getPnrTxt() {
		return pnrTxt;
	}
	public void setPnrTxt(String pnrTxt) {
		this.pnrTxt = pnrTxt;
	}
	public String getPatTxt() {
		return patTxt;
	}
	public void setPatTxt(String patTxt) {
		this.patTxt = patTxt;
	}

}
