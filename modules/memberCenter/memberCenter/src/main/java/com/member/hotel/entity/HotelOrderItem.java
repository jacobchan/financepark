/**
 *
 */
package com.member.hotel.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 酒店订单明细
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_hotel_order_item")
public class HotelOrderItem implements Domain{
	
	private static final long serialVersionUID = 5706652773657435714L;
	

	@Column(name = "ROOM_PRICE_")
	@Length(max=10)
	private String roomPrice;//单价

	@Column(name = "ROOM_NO_")
	@Length(max=20)
	private String roomNo;//房间号
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ITEM_ID_")
	@Length(max=36)
	private String itemId;//ITEM_ID_

	@Column(name = "ROOM_COUNT_")
	private String roomCount;//数量
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDER_ID_")
	private com.member.hotel.entity.HotelOrder hotelOrder;//ORDER_ID_
	
	public String getRoomPrice(){
		return this.roomPrice;
	}
	
	public void setRoomPrice(String roomPrice){
		this.roomPrice = roomPrice;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	public String getItemId(){
		return this.itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getRoomCount(){
		return this.roomCount;
	}
	
	public void setRoomCount(String roomCount){
		this.roomCount = roomCount;
	}
	
	public void setHotelOrder(com.member.hotel.entity.HotelOrder hotelOrder){
		this.hotelOrder = hotelOrder;
	}
	
	public com.member.hotel.entity.HotelOrder getHotelOrder(){
		return this.hotelOrder;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomPrice == null) ? 0 : roomPrice.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((roomCount == null) ? 0 : roomCount.hashCode());
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
		final HotelOrderItem other = (HotelOrderItem) obj;
		if (roomPrice == null) {
			if (other.roomPrice != null)
				return false;
		} else if (!roomPrice.equals(other.roomPrice))
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (roomCount == null) {
			if (other.roomCount != null)
				return false;
		} else if (!roomCount.equals(other.roomCount))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}