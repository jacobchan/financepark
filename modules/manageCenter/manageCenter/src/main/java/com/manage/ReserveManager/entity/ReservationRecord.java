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
	
	private static final long serialVersionUID = 7795969662685750349L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RECORD_ID")
	@Length(max=36)
	private String recordId;//预约记录ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "RECORD_SERVICE_TEL")
	@Length(max=32)
	private String recordServiceTel;//客服电话

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "RECORD_TYPE")
	@Length(max=2)
	private String recordType;//预约类型

	@Column(name = "RECORD_CUSTOMER")
	@Length(max=32)
	private String recordCustomer;//客服代表

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "VISITE_DATE_")
	@Length(max=20)
	private String visiteDate;//到访日期

	@Column(name = "RECORD_MEMBER_ID")
	@Length(max=32)
	private String recordMemberId;//预约对象ID

	@Column(name = "RECORD_VISITE_STATUS")
	@Length(max=2)
	private String recordVisiteStatus;//是否到访

	@Column(name = "RECORD_STATUS")
	@Length(max=2)
	private String recordStatus;//预约记录状态

	@Column(name = "VISITE_TIME_")
	@Length(max=20)
	private String visiteTime;//到访时间
	
	public String getRecordId(){
		return this.recordId;
	}
	
	public void setRecordId(String recordId){
		this.recordId = recordId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getRecordServiceTel(){
		return this.recordServiceTel;
	}
	
	public void setRecordServiceTel(String recordServiceTel){
		this.recordServiceTel = recordServiceTel;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getRecordType(){
		return this.recordType;
	}
	
	public void setRecordType(String recordType){
		this.recordType = recordType;
	}
	public String getRecordCustomer(){
		return this.recordCustomer;
	}
	
	public void setRecordCustomer(String recordCustomer){
		this.recordCustomer = recordCustomer;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getVisiteDate(){
		return this.visiteDate;
	}
	
	public void setVisiteDate(String visiteDate){
		this.visiteDate = visiteDate;
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
	public String getRecordStatus(){
		return this.recordStatus;
	}
	
	public void setRecordStatus(String recordStatus){
		this.recordStatus = recordStatus;
	}
	public String getVisiteTime(){
		return this.visiteTime;
	}
	
	public void setVisiteTime(String visiteTime){
		this.visiteTime = visiteTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recordId == null) ? 0 : recordId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((recordServiceTel == null) ? 0 : recordServiceTel.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + ((recordCustomer == null) ? 0 : recordCustomer.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((visiteDate == null) ? 0 : visiteDate.hashCode());
		result = prime * result + ((recordMemberId == null) ? 0 : recordMemberId.hashCode());
		result = prime * result + ((recordVisiteStatus == null) ? 0 : recordVisiteStatus.hashCode());
		result = prime * result + ((recordStatus == null) ? 0 : recordStatus.hashCode());
		result = prime * result + ((visiteTime == null) ? 0 : visiteTime.hashCode());
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
		if (recordId == null) {
			if (other.recordId != null)
				return false;
		} else if (!recordId.equals(other.recordId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (recordServiceTel == null) {
			if (other.recordServiceTel != null)
				return false;
		} else if (!recordServiceTel.equals(other.recordServiceTel))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (recordCustomer == null) {
			if (other.recordCustomer != null)
				return false;
		} else if (!recordCustomer.equals(other.recordCustomer))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (visiteDate == null) {
			if (other.visiteDate != null)
				return false;
		} else if (!visiteDate.equals(other.visiteDate))
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
		if (recordStatus == null) {
			if (other.recordStatus != null)
				return false;
		} else if (!recordStatus.equals(other.recordStatus))
			return false;
		if (visiteTime == null) {
			if (other.visiteTime != null)
				return false;
		} else if (!visiteTime.equals(other.visiteTime))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}