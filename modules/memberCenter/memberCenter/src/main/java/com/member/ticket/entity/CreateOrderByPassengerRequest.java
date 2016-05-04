package com.member.ticket.entity;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
public class CreateOrderByPassengerRequest implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String agencyCode;
	private String sign;
	private String policyId;
	private String linkMan;
	private String linkPhone;
	private String otherLinkMethod;
	private String notifiedUrl;
	private String paymentReturnUrl;
	private String outOrderNo;
	private WsBookPnr pnrInfo;
	private String allowSwitchPolicy;
	private String needSpeRulePolicy;
	private String b2cProfit;
	private String b2cClientPay;
	private String createdBy;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getOtherLinkMethod() {
		return otherLinkMethod;
	}
	public void setOtherLinkMethod(String otherLinkMethod) {
		this.otherLinkMethod = otherLinkMethod;
	}
	public String getNotifiedUrl() {
		return notifiedUrl;
	}
	public void setNotifiedUrl(String notifiedUrl) {
		this.notifiedUrl = notifiedUrl;
	}
	public String getPaymentReturnUrl() {
		return paymentReturnUrl;
	}
	public void setPaymentReturnUrl(String paymentReturnUrl) {
		this.paymentReturnUrl = paymentReturnUrl;
	}
	public String getOutOrderNo() {
		return outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	public WsBookPnr getPnrInfo() {
		return pnrInfo;
	}
	public void setPnrInfo(WsBookPnr pnrInfo) {
		this.pnrInfo = pnrInfo;
	}
	public String getAllowSwitchPolicy() {
		return allowSwitchPolicy;
	}
	public void setAllowSwitchPolicy(String allowSwitchPolicy) {
		this.allowSwitchPolicy = allowSwitchPolicy;
	}
	public String getNeedSpeRulePolicy() {
		return needSpeRulePolicy;
	}
	public void setNeedSpeRulePolicy(String needSpeRulePolicy) {
		this.needSpeRulePolicy = needSpeRulePolicy;
	}
	public String getB2cProfit() {
		return b2cProfit;
	}
	public void setB2cProfit(String b2cProfit) {
		this.b2cProfit = b2cProfit;
	}
	public String getB2cClientPay() {
		return b2cClientPay;
	}
	public void setB2cClientPay(String b2cClientPay) {
		this.b2cClientPay = b2cClientPay;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public String getParam5() {
		return param5;
	}
	public void setParam5(String param5) {
		this.param5 = param5;
	}

}
