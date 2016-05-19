/**
 *
 */
package com.member.ticket.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 340505乘机人
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_ticket_passenger")
public class TicketPassenger implements Domain{
	
	private static final long serialVersionUID = 9207421219953143428L;
	

	@Column(name = "identity_num")
	@Length(max=16)
	private String identityNum;//证件号码
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PASSENGER_ID")
	@Length(max=36)
	private String passengerId;//PASSENGER_ID

	@Column(name = "insurance")
	@Length(max=32)
	private String insurance;//保险

	@Column(name = "name")
	@Length(max=16)
	private String name;//乘机人姓名

	@Column(name = "type")
	@Length(max=16)
	private String type;//类型

	@Column(name = "identity_type")
	@Length(max=16)
	private String identityType;//证件类型

	@Column(name = "tel")
	@Length(max=16)
	private String tel;//联系电话

	@Column(name = "input_time")
	private java.sql.Timestamp inputTime;//时间
	
	@Column(name = "ticket_num")
	@Length(max=32)
	private String ticket_num;//票号
	
	public String getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(String ticket_num) {
		this.ticket_num = ticket_num;
	}

	public String getIdentityNum(){
		return this.identityNum;
	}
	
	public void setIdentityNum(String identityNum){
		this.identityNum = identityNum;
	}
	public String getPassengerId(){
		return this.passengerId;
	}
	
	public void setPassengerId(String passengerId){
		this.passengerId = passengerId;
	}
	public String getInsurance(){
		return this.insurance;
	}
	
	public void setInsurance(String insurance){
		this.insurance = insurance;
	}
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getIdentityType(){
		return this.identityType;
	}
	
	public void setIdentityType(String identityType){
		this.identityType = identityType;
	}
	public String getTel(){
		return this.tel;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	public java.sql.Timestamp getInputTime(){
		return this.inputTime;
	}
	
	public void setInputTime(java.sql.Timestamp inputTime){
		this.inputTime = inputTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identityNum == null) ? 0 : identityNum.hashCode());
		result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
		result = prime * result + ((insurance == null) ? 0 : insurance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((identityType == null) ? 0 : identityType.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((ticket_num == null) ? 0 : ticket_num.hashCode());
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
		final TicketPassenger other = (TicketPassenger) obj;
		if (identityNum == null) {
			if (other.identityNum != null)
				return false;
		} else if (!identityNum.equals(other.identityNum))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		if (insurance == null) {
			if (other.insurance != null)
				return false;
		} else if (!insurance.equals(other.insurance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (identityType == null) {
			if (other.identityType != null)
				return false;
		} else if (!identityType.equals(other.identityType))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (inputTime == null) {
			if (other.inputTime != null)
				return false;
		} else if (!inputTime.equals(other.inputTime))
			return false;
		if (ticket_num == null) {
			if (other.ticket_num != null)
				return false;
		} else if (!ticket_num.equals(other.ticket_num))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}