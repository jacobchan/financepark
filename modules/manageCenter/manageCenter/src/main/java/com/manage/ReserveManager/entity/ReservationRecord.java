/**
 *
 */
package com.manage.ReserveManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 预约记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_reservation_record")
public class ReservationRecord implements Domain{
	
	private static final long serialVersionUID = 432033653808983708L;
	

	@Column(name = "RECORD_SERVICE_TEL")
	@Length(max=32)
	private String recordServiceTel;//客服电话

	@Column(name = "RECORD_STATUS")
	@Length(max=2)
	private String recordStatus;//预约记录状态

	@Column(name = "RECORD_MEMBER_ID")
	@Length(max=32)
	private String recordMemberId;//预约对象ID

	@Column(name = "RECORD_VISITE_STATUS")
	@Length(max=2)
	private String recordVisiteStatus;//是否到访

	@Column(name = "RECORD_CUSTOMER")
	@Length(max=32)
	private String recordCustomer;//客服代表
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RECORD_ID")
	@Length(max=36)
	private String recordId;//预约记录ID

	@Column(name = "RECORD_TYPE")
	@Length(max=2)
	private String recordType;//预约类型
	
	public String getRecordServiceTel(){
		return this.recordServiceTel;
	}
	
	public void setRecordServiceTel(String recordServiceTel){
		this.recordServiceTel = recordServiceTel;
	}
	public String getRecordStatus(){
		return this.recordStatus;
	}
	
	public void setRecordStatus(String recordStatus){
		this.recordStatus = recordStatus;
	}
	public String getRecordMemberId(){
		return this.recordMemberId;
	}
	
	public void setRecordMemberId(String recordMemberId){
		this.recordMemberId = recordMemberId;
	}
	public String getRecordVisiteStatus(){
		return this.recordVisiteStatus;
	}
	
	public void setRecordVisiteStatus(String recordVisiteStatus){
		this.recordVisiteStatus = recordVisiteStatus;
	}
	public String getRecordCustomer(){
		return this.recordCustomer;
	}
	
	public void setRecordCustomer(String recordCustomer){
		this.recordCustomer = recordCustomer;
	}
	public String getRecordId(){
		return this.recordId;
	}
	
	public void setRecordId(String recordId){
		this.recordId = recordId;
	}
	public String getRecordType(){
		return this.recordType;
	}
	
	public void setRecordType(String recordType){
		this.recordType = recordType;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recordServiceTel == null) ? 0 : recordServiceTel.hashCode());
		result = prime * result + ((recordStatus == null) ? 0 : recordStatus.hashCode());
		result = prime * result + ((recordMemberId == null) ? 0 : recordMemberId.hashCode());
		result = prime * result + ((recordVisiteStatus == null) ? 0 : recordVisiteStatus.hashCode());
		result = prime * result + ((recordCustomer == null) ? 0 : recordCustomer.hashCode());
		result = prime * result + ((recordId == null) ? 0 : recordId.hashCode());
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
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
		final ReservationRecord other = (ReservationRecord) obj;
		if (recordServiceTel == null) {
			if (other.recordServiceTel != null)
				return false;
		} else if (!recordServiceTel.equals(other.recordServiceTel))
			return false;
		if (recordStatus == null) {
			if (other.recordStatus != null)
				return false;
		} else if (!recordStatus.equals(other.recordStatus))
			return false;
		if (recordMemberId == null) {
			if (other.recordMemberId != null)
				return false;
		} else if (!recordMemberId.equals(other.recordMemberId))
			return false;
		if (recordVisiteStatus == null) {
			if (other.recordVisiteStatus != null)
				return false;
		} else if (!recordVisiteStatus.equals(other.recordVisiteStatus))
			return false;
		if (recordCustomer == null) {
			if (other.recordCustomer != null)
				return false;
		} else if (!recordCustomer.equals(other.recordCustomer))
			return false;
		if (recordId == null) {
			if (other.recordId != null)
				return false;
		} else if (!recordId.equals(other.recordId))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}