/**
 *
 */
package com.member.ticket.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 机票订单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_ticket_order")
public class TicketOrder implements Domain{
	
	private static final long serialVersionUID = 739765471124415244L;
	

	@Column(name = "PAY_TYPE_")
	@Length(max=2)
	private String payType;//支付方式

	@Column(name = "ORDER_AMOUNT_")
	@Length(max=10)
	private String orderAmount;//订单金额

	@Column(name = "ORDER_TYPE_")
	@Length(max=2)
	private String orderType;//订单状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDER_ID_")
	@Length(max=36)
	private String orderId;//ORDER_ID_

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "ORDER_TIME_")
	@Length(max=20)
	private String orderTime;//订单时间

	@Column(name = "ORDER_NO_")
	@Length(max=32)
	private String orderNo;//订单号码
	
	@Column(name = "note")
	@Length(max=256)
	private String note;//备注
	
	public String getPayType(){
		return this.payType;
	}
	
	public void setPayType(String payType){
		this.payType = payType;
	}
	public String getOrderAmount(){
		return this.orderAmount;
	}
	
	public void setOrderAmount(String orderAmount){
		this.orderAmount = orderAmount;
	}
	public String getOrderType(){
		return this.orderType;
	}
	
	public void setOrderType(String orderType){
		this.orderType = orderType;
	}
	public String getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getOrderTime(){
		return this.orderTime;
	}
	
	public void setOrderTime(String orderTime){
		this.orderTime = orderTime;
	}
	public String getOrderNo(){
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		result = prime * result + ((orderAmount == null) ? 0 : orderAmount.hashCode());
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TicketOrder other = (TicketOrder) obj;
		if (payType == null) {
			if (other.payType != null)
				return false;
		} else if (!payType.equals(other.payType))
			return false;
		if (orderAmount == null) {
			if (other.orderAmount != null)
				return false;
		} else if (!orderAmount.equals(other.orderAmount))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}