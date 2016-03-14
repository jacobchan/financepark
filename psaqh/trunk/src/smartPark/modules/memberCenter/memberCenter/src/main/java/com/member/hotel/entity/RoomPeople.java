/**
 *
 */
package com.member.hotel.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 房间联系人关系
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_room_people")
public class RoomPeople implements Domain{
	
	private static final long serialVersionUID = -7110682135206038696L;
	

	@Column(name = "CONTRACTS_ID_")
	@Length(max=36)
	private String contractsId;//联系人ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "REC_ID_")
	@Length(max=36)
	private String recId;//REC_ID_
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ITEM_ID_")
	private com.member.hotel.entity.HotelOrderItem hotelOrderItem;//ITEM_ID_
	
	public String getContractsId(){
		return this.contractsId;
	}
	
	public void setContractsId(String contractsId){
		this.contractsId = contractsId;
	}
	public String getRecId(){
		return this.recId;
	}
	
	public void setRecId(String recId){
		this.recId = recId;
	}
	
	public void setHotelOrderItem(com.member.hotel.entity.HotelOrderItem hotelOrderItem){
		this.hotelOrderItem = hotelOrderItem;
	}
	
	public com.member.hotel.entity.HotelOrderItem getHotelOrderItem(){
		return this.hotelOrderItem;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractsId == null) ? 0 : contractsId.hashCode());
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
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
		final RoomPeople other = (RoomPeople) obj;
		if (contractsId == null) {
			if (other.contractsId != null)
				return false;
		} else if (!contractsId.equals(other.contractsId))
			return false;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}