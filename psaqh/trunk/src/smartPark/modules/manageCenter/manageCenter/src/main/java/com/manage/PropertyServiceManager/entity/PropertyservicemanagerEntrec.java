/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 入驻服务办理预约记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_entrec")
public class PropertyservicemanagerEntrec implements Domain{
	
	private static final long serialVersionUID = -2494215305350577964L;
	

	@Column(name = "ENTERING_NAME_")
	@Length(max=32)
	private String enteringName;//入驻申请人

	@Column(name = "ENTERING_TELEPHONE_")
	@Length(max=16)
	private String enteringTelephone;//入驻联系电话
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ENTREC_ID_")
	@Length(max=36)
	private String entrecId;//入驻预约记录ID

	@Column(name = "ENTERING_TIME_")
	@Length(max=20)
	private String enteringTime;//预约时间段

	@Column(name = "ENTERING_STATUS_")
	@Length(max=2)
	private String enteringStatus;//预约数量状态

	@Column(name = "ENTERING_DATE_")
	@Length(max=20)
	private String enteringDate;//预约时间日期
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ENTERING_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering propertyservicemanagerEntering;//预约记录ID
	
	public String getEnteringName(){
		return this.enteringName;
	}
	
	public void setEnteringName(String enteringName){
		this.enteringName = enteringName;
	}
	public String getEnteringTelephone(){
		return this.enteringTelephone;
	}
	
	public void setEnteringTelephone(String enteringTelephone){
		this.enteringTelephone = enteringTelephone;
	}
	
	
	public String getEntrecId(){
		return this.entrecId;
	}
	
	public void setEntrecId(String entrecId){
		this.entrecId = entrecId;
	}
	public String getEnteringTime(){
		return this.enteringTime;
	}
	
	public void setEnteringTime(String enteringTime){
		this.enteringTime = enteringTime;
	}
	public String getEnteringStatus(){
		return this.enteringStatus;
	}
	
	public void setEnteringStatus(String enteringStatus){
		this.enteringStatus = enteringStatus;
	}
	public String getEnteringDate(){
		return this.enteringDate;
	}
	
	public void setEnteringDate(String enteringDate){
		this.enteringDate = enteringDate;
	}
	
	public void setPropertyservicemanagerEntering(com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering propertyservicemanagerEntering){
		this.propertyservicemanagerEntering = propertyservicemanagerEntering;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering getPropertyservicemanagerEntering(){
		return this.propertyservicemanagerEntering;
	}
	
	
	
	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enteringName == null) ? 0 : enteringName.hashCode());
		result = prime * result + ((enteringTelephone == null) ? 0 : enteringTelephone.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((entrecId == null) ? 0 : entrecId.hashCode());
		result = prime * result + ((enteringTime == null) ? 0 : enteringTime.hashCode());
		result = prime * result + ((enteringStatus == null) ? 0 : enteringStatus.hashCode());
		result = prime * result + ((enteringDate == null) ? 0 : enteringDate.hashCode());
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
		final PropertyservicemanagerEntrec other = (PropertyservicemanagerEntrec) obj;
		if (enteringName == null) {
			if (other.enteringName != null)
				return false;
		} else if (!enteringName.equals(other.enteringName))
			return false;
		if (enteringTelephone == null) {
			if (other.enteringTelephone != null)
				return false;
		} else if (!enteringTelephone.equals(other.enteringTelephone))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (entrecId == null) {
			if (other.entrecId != null)
				return false;
		} else if (!entrecId.equals(other.entrecId))
			return false;
		if (enteringTime == null) {
			if (other.enteringTime != null)
				return false;
		} else if (!enteringTime.equals(other.enteringTime))
			return false;
		if (enteringStatus == null) {
			if (other.enteringStatus != null)
				return false;
		} else if (!enteringStatus.equals(other.enteringStatus))
			return false;
		if (enteringDate == null) {
			if (other.enteringDate != null)
				return false;
		} else if (!enteringDate.equals(other.enteringDate))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}