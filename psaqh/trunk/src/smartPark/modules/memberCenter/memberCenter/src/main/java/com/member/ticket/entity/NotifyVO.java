package com.member.ticket.entity;

import com.gsoft.framework.core.dataobj.Domain;
import com.itextpdf.text.pdf.security.PrivateKeySignature;

public class NotifyVO implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;//0拒单1成功出票2出票失败3预定失败
	private String sequenceNo;//----订单号
	
	private String passengerNames;//---乘客名
	private String ticketNos;//—票号
	private String ticketPrice;//—票面价
	private String fuelTax;//—燃油
	private String airportTax;//—机建
	private String settlePrice;//—结算价
	private String pnrNo;//—当前编码
	private String oldPnrNo;//—旧编码
	
	private String reason;//拒单原因

	private String refundNo;//退款单号
	private String orderNo;//订单号
	private String refundTime;//退款日期
	private String refundPrice;
	
	private String flightNo;
	private String content;
	
	private String venderRefundTime;//退款时间
	private String venderPayPrice;//退款金额
	private String refundFee;//退款手续费
	private String outRefundNo;//外部退票单号
	private String venderRemark;//外部退款备注

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public String getPassengerNames() {
		return passengerNames;
	}
	public void setPassengerNames(String passengerNames) {
		this.passengerNames = passengerNames;
	}
	public String getTicketNos() {
		return ticketNos;
	}
	public void setTicketNos(String ticketNos) {
		this.ticketNos = ticketNos;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
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
	public String getSettlePrice() {
		return settlePrice;
	}
	public void setSettlePrice(String settlePrice) {
		this.settlePrice = settlePrice;
	}
	public String getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getOldPnrNo() {
		return oldPnrNo;
	}
	public void setOldPnrNo(String oldPnrNo) {
		this.oldPnrNo = oldPnrNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}
	public String getRefundPrice() {
		return refundPrice;
	}
	public void setRefundPrice(String refundPrice) {
		this.refundPrice = refundPrice;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVenderRefundTime() {
		return venderRefundTime;
	}
	public void setVenderRefundTime(String venderRefundTime) {
		this.venderRefundTime = venderRefundTime;
	}
	public String getVenderPayPrice() {
		return venderPayPrice;
	}
	public void setVenderPayPrice(String venderPayPrice) {
		this.venderPayPrice = venderPayPrice;
	}
	public String getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}
	public String getOutRefundNo() {
		return outRefundNo;
	}
	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}
	public String getVenderRemark() {
		return venderRemark;
	}
	public void setVenderRemark(String venderRemark) {
		this.venderRemark = venderRemark;
	}
	
	
}
