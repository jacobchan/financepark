/**
 *
 */
package com.member.ticket.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 退票订单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_refund_order")
public class RefundOrder implements Domain{
	
	private static final long serialVersionUID = -808402628134389615L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDER_ID_")
	@Length(max=36)
	private String orderId;//ORDER_ID_

	@Column(name = "REFUND_ORDER_TYPE_")
	@Length(max=2)
	private String refundOrderType;//退票订单状态

	@Column(name = "FEE_AMOUNT_")
	@Length(max=10)
	private String feeAmount;//退票手续费

	@Column(name = "REFUND_ORDER_NO_")
	@Length(max=32)
	private String refundOrderNo;//退票订单号码

	@Column(name = "REFUND_RECORD_")
	@Length(max=1024)
	private String refundRecord;//退票原因

	@Column(name = "REFUND_ORDER_TIME_")
	@Length(max=20)
	private String refundOrderTime;//退票时间

	@Column(name = "IS_SUCESS_")
	@Length(max=2)
	private String isSucess;//是否成功

	@Column(name = "REFUND_AMOUNT_")
	@Length(max=10)
	private String refundAmount;//退票金额

	@Column(name = "PRE_COMEIN_TIME_")
	@Length(max=20)
	private String preComeinTime;//预计到账时间

	@Column(name = "MAN_ID_")
	@Length(max=36)
	private String manId;//会员ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__ORDER_ID_")
	private com.member.ticket.entity.TicketOrder ticketOrder;//340_ORDER_ID_
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	public String getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	public String getRefundOrderType(){
		return this.refundOrderType;
	}
	
	public void setRefundOrderType(String refundOrderType){
		this.refundOrderType = refundOrderType;
	}
	public String getFeeAmount(){
		return this.feeAmount;
	}
	
	public void setFeeAmount(String feeAmount){
		this.feeAmount = feeAmount;
	}
	public String getRefundOrderNo(){
		return this.refundOrderNo;
	}
	
	public void setRefundOrderNo(String refundOrderNo){
		this.refundOrderNo = refundOrderNo;
	}
	public String getRefundRecord(){
		return this.refundRecord;
	}
	
	public void setRefundRecord(String refundRecord){
		this.refundRecord = refundRecord;
	}
	public String getRefundOrderTime(){
		return this.refundOrderTime;
	}
	
	public void setRefundOrderTime(String refundOrderTime){
		this.refundOrderTime = refundOrderTime;
	}
	public String getIsSucess(){
		return this.isSucess;
	}
	
	public void setIsSucess(String isSucess){
		this.isSucess = isSucess;
	}
	public String getRefundAmount(){
		return this.refundAmount;
	}
	
	public void setRefundAmount(String refundAmount){
		this.refundAmount = refundAmount;
	}
	public String getPreComeinTime(){
		return this.preComeinTime;
	}
	
	public void setPreComeinTime(String preComeinTime){
		this.preComeinTime = preComeinTime;
	}
	public String getManId(){
		return this.manId;
	}
	
	public void setManId(String manId){
		this.manId = manId;
	}
	
	public void setTicketOrder(com.member.ticket.entity.TicketOrder ticketOrder){
		this.ticketOrder = ticketOrder;
	}
	
	public com.member.ticket.entity.TicketOrder getTicketOrder(){
		return this.ticketOrder;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((refundOrderType == null) ? 0 : refundOrderType.hashCode());
		result = prime * result + ((feeAmount == null) ? 0 : feeAmount.hashCode());
		result = prime * result + ((refundOrderNo == null) ? 0 : refundOrderNo.hashCode());
		result = prime * result + ((refundRecord == null) ? 0 : refundRecord.hashCode());
		result = prime * result + ((refundOrderTime == null) ? 0 : refundOrderTime.hashCode());
		result = prime * result + ((isSucess == null) ? 0 : isSucess.hashCode());
		result = prime * result + ((refundAmount == null) ? 0 : refundAmount.hashCode());
		result = prime * result + ((preComeinTime == null) ? 0 : preComeinTime.hashCode());
		result = prime * result + ((manId == null) ? 0 : manId.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		/**新增园区字段   end**/
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
		final RefundOrder other = (RefundOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (refundOrderType == null) {
			if (other.refundOrderType != null)
				return false;
		} else if (!refundOrderType.equals(other.refundOrderType))
			return false;
		if (feeAmount == null) {
			if (other.feeAmount != null)
				return false;
		} else if (!feeAmount.equals(other.feeAmount))
			return false;
		if (refundOrderNo == null) {
			if (other.refundOrderNo != null)
				return false;
		} else if (!refundOrderNo.equals(other.refundOrderNo))
			return false;
		if (refundRecord == null) {
			if (other.refundRecord != null)
				return false;
		} else if (!refundRecord.equals(other.refundRecord))
			return false;
		if (refundOrderTime == null) {
			if (other.refundOrderTime != null)
				return false;
		} else if (!refundOrderTime.equals(other.refundOrderTime))
			return false;
		if (isSucess == null) {
			if (other.isSucess != null)
				return false;
		} else if (!isSucess.equals(other.isSucess))
			return false;
		if (refundAmount == null) {
			if (other.refundAmount != null)
				return false;
		} else if (!refundAmount.equals(other.refundAmount))
			return false;
		if (preComeinTime == null) {
			if (other.preComeinTime != null)
				return false;
		} else if (!preComeinTime.equals(other.preComeinTime))
			return false;
		if (manId == null) {
			if (other.manId != null)
				return false;
		} else if (!manId.equals(other.manId))
			return false;


		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}