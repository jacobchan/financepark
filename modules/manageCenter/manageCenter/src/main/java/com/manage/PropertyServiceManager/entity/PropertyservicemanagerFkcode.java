/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 访客申请记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_fkcode_")
public class PropertyservicemanagerFkcode implements Domain{
	
	private static final long serialVersionUID = 7433589484216675924L;
	

	@Column(name = "FKCODE_TELEPHONE_")
	@Length(max=16)
	private String fkcodeTelephone;//联系电话

	@Column(name = "FKCODE_REMARK_")
	@Length(max=300)
	private String fkcodeRemark;//访客说明

	@Column(name = "FKCODE_COMP_")
	@Length(max=36)
	private String fkcodeComp;//到访企业

	@Column(name = "FKCODE_NAME_")
	@Length(max=32)
	private String fkcodeName;//联系人

	@Column(name = "FKCODE_TIME_")
	@Length(max=20)
	private String fkcodeTime;//到访时间

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "FKCODE_SEX_")
	@Length(max=2)
	private String fkcodeSex;//性别
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FKCODE_ID_")
	@Length(max=36)
	private String fkcodeId;//访客申请ID
	
	public String getFkcodeTelephone(){
		return this.fkcodeTelephone;
	}
	
	public void setFkcodeTelephone(String fkcodeTelephone){
		this.fkcodeTelephone = fkcodeTelephone;
	}
	public String getFkcodeRemark(){
		return this.fkcodeRemark;
	}
	
	public void setFkcodeRemark(String fkcodeRemark){
		this.fkcodeRemark = fkcodeRemark;
	}
	public String getFkcodeComp(){
		return this.fkcodeComp;
	}
	
	public void setFkcodeComp(String fkcodeComp){
		this.fkcodeComp = fkcodeComp;
	}
	public String getFkcodeName(){
		return this.fkcodeName;
	}
	
	public void setFkcodeName(String fkcodeName){
		this.fkcodeName = fkcodeName;
	}
	public String getFkcodeTime(){
		return this.fkcodeTime;
	}
	
	public void setFkcodeTime(String fkcodeTime){
		this.fkcodeTime = fkcodeTime;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getFkcodeSex(){
		return this.fkcodeSex;
	}
	
	public void setFkcodeSex(String fkcodeSex){
		this.fkcodeSex = fkcodeSex;
	}
	public String getFkcodeId(){
		return this.fkcodeId;
	}
	
	public void setFkcodeId(String fkcodeId){
		this.fkcodeId = fkcodeId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fkcodeTelephone == null) ? 0 : fkcodeTelephone.hashCode());
		result = prime * result + ((fkcodeRemark == null) ? 0 : fkcodeRemark.hashCode());
		result = prime * result + ((fkcodeComp == null) ? 0 : fkcodeComp.hashCode());
		result = prime * result + ((fkcodeName == null) ? 0 : fkcodeName.hashCode());
		result = prime * result + ((fkcodeTime == null) ? 0 : fkcodeTime.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((fkcodeSex == null) ? 0 : fkcodeSex.hashCode());
		result = prime * result + ((fkcodeId == null) ? 0 : fkcodeId.hashCode());
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
		final PropertyservicemanagerFkcode other = (PropertyservicemanagerFkcode) obj;
		if (fkcodeTelephone == null) {
			if (other.fkcodeTelephone != null)
				return false;
		} else if (!fkcodeTelephone.equals(other.fkcodeTelephone))
			return false;
		if (fkcodeRemark == null) {
			if (other.fkcodeRemark != null)
				return false;
		} else if (!fkcodeRemark.equals(other.fkcodeRemark))
			return false;
		if (fkcodeComp == null) {
			if (other.fkcodeComp != null)
				return false;
		} else if (!fkcodeComp.equals(other.fkcodeComp))
			return false;
		if (fkcodeName == null) {
			if (other.fkcodeName != null)
				return false;
		} else if (!fkcodeName.equals(other.fkcodeName))
			return false;
		if (fkcodeTime == null) {
			if (other.fkcodeTime != null)
				return false;
		} else if (!fkcodeTime.equals(other.fkcodeTime))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (fkcodeSex == null) {
			if (other.fkcodeSex != null)
				return false;
		} else if (!fkcodeSex.equals(other.fkcodeSex))
			return false;
		if (fkcodeId == null) {
			if (other.fkcodeId != null)
				return false;
		} else if (!fkcodeId.equals(other.fkcodeId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}