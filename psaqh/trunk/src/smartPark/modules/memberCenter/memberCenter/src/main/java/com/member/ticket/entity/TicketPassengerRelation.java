/**
 *
 */
package com.member.ticket.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 340506乘机人机票关系
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_ticket_passenger_relation")
public class TicketPassengerRelation implements Domain{
	
	private static final long serialVersionUID = 7322331315038333662L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TICKET_PASSENGER_ID")
	@Length(max=36)
	private String ticketPassengerId;//TICKET_PASSENGER_ID

	@Column(name = "PASSENGER_ID")
	@Length(max=36)
	private String passengerId;//PASSENGER_ID

	@Column(name = "ITEM_ID_")
	@Length(max=36)
	private String itemId;//ITEM_ID_
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

	public String getTicketPassengerId(){
		return this.ticketPassengerId;
	}
	
	public void setTicketPassengerId(String ticketPassengerId){
		this.ticketPassengerId = ticketPassengerId;
	}
	public String getPassengerId(){
		return this.passengerId;
	}
	
	public void setPassengerId(String passengerId){
		this.passengerId = passengerId;
	}
	public String getItemId(){
		return this.itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketPassengerId == null) ? 0 : ticketPassengerId.hashCode());
		result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		
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
		final TicketPassengerRelation other = (TicketPassengerRelation) obj;
		if (ticketPassengerId == null) {
			if (other.ticketPassengerId != null)
				return false;
		} else if (!ticketPassengerId.equals(other.ticketPassengerId))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
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