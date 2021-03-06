/**
 *
 */
package com.member.ticket.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 机票订单详情
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_ticket_order_item")
public class TicketOrderItem implements Domain{
	
	private static final long serialVersionUID = -8557280965948920721L;
	

	@Column(name = "TICKET_COUNT_")
	private String ticketCount;//商品数量
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ITEM_ID_")
	@Length(max=36)
	private String itemId;//ITEM_ID_

	@Column(name = "TICKET_NO_")
	@Length(max=64)
	private String ticketNo;//商品编码

	@Column(name = "ORDER_ID_THIRD")
	@Length(max=64)
	private String orderIdThird;//第三方订单号
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDER_ID_")
	private com.member.ticket.entity.TicketOrder ticketOrder;//ORDER_ID_
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
	public String getTicketCount(){
		return this.ticketCount;
	}
	
	public void setTicketCount(String ticketCount){
		this.ticketCount = ticketCount;
	}
	public String getItemId(){
		return this.itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getTicketNo(){
		return this.ticketNo;
	}
	
	public void setTicketNo(String ticketNo){
		this.ticketNo = ticketNo;
	}
	public String getOrderIdThird(){
		return this.orderIdThird;
	}
	
	public void setOrderIdThird(String orderIdThird){
		this.orderIdThird = orderIdThird;
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
		result = prime * result + ((ticketCount == null) ? 0 : ticketCount.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((ticketNo == null) ? 0 : ticketNo.hashCode());
		result = prime * result + ((orderIdThird == null) ? 0 : orderIdThird.hashCode());
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
		final TicketOrderItem other = (TicketOrderItem) obj;
		if (ticketCount == null) {
			if (other.ticketCount != null)
				return false;
		} else if (!ticketCount.equals(other.ticketCount))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (ticketNo == null) {
			if (other.ticketNo != null)
				return false;
		} else if (!ticketNo.equals(other.ticketNo))
			return false;
		if (orderIdThird == null) {
			if (other.orderIdThird != null)
				return false;
		} else if (!orderIdThird.equals(other.orderIdThird))
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