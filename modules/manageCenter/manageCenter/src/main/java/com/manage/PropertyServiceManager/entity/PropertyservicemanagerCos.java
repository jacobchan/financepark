/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 物业投诉记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_cos")
public class PropertyservicemanagerCos implements Domain{
	
	private static final long serialVersionUID = 8827386225490969373L;
	

	@Column(name = "COS_CONTENT_")
	@Length(max=300)
	private String cosContent;//投诉内容
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COS_ID_")
	@Length(max=36)
	private String cosId;//投诉ID

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "COS_STATUS_")
	@Length(max=2)
	private String cosStatus;//投诉受理状态

	@Column(name = "COS_TELEPHONE_")
	@Length(max=16)
	private String cosTelephone;//回访电话

	@Column(name = "COS_BOOL_")
	@Length(max=2)
	private String cosBool;//是否接受回访

	@Column(name = "COS_NAME_")
	@Length(max=32)
	private String cosName;//投诉联系人

	@Column(name = "COS_TIME_")
	@Length(max=20)
	private String cosTime;//投诉时间

	@Column(name = "COS_CODE_")
	@Length(max=32)
	private String cosCode;//投诉单号
	
	public String getCosContent(){
		return this.cosContent;
	}
	
	public void setCosContent(String cosContent){
		this.cosContent = cosContent;
	}
	public String getCosId(){
		return this.cosId;
	}
	
	public void setCosId(String cosId){
		this.cosId = cosId;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getCosStatus(){
		return this.cosStatus;
	}
	
	public void setCosStatus(String cosStatus){
		this.cosStatus = cosStatus;
	}
	public String getCosTelephone(){
		return this.cosTelephone;
	}
	
	public void setCosTelephone(String cosTelephone){
		this.cosTelephone = cosTelephone;
	}
	public String getCosBool(){
		return this.cosBool;
	}
	
	public void setCosBool(String cosBool){
		this.cosBool = cosBool;
	}
	public String getCosName(){
		return this.cosName;
	}
	
	public void setCosName(String cosName){
		this.cosName = cosName;
	}
	public String getCosTime(){
		return this.cosTime;
	}
	
	public void setCosTime(String cosTime){
		this.cosTime = cosTime;
	}
	public String getCosCode(){
		return this.cosCode;
	}
	
	public void setCosCode(String cosCode){
		this.cosCode = cosCode;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cosContent == null) ? 0 : cosContent.hashCode());
		result = prime * result + ((cosId == null) ? 0 : cosId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((cosStatus == null) ? 0 : cosStatus.hashCode());
		result = prime * result + ((cosTelephone == null) ? 0 : cosTelephone.hashCode());
		result = prime * result + ((cosBool == null) ? 0 : cosBool.hashCode());
		result = prime * result + ((cosName == null) ? 0 : cosName.hashCode());
		result = prime * result + ((cosTime == null) ? 0 : cosTime.hashCode());
		result = prime * result + ((cosCode == null) ? 0 : cosCode.hashCode());
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
		final PropertyservicemanagerCos other = (PropertyservicemanagerCos) obj;
		if (cosContent == null) {
			if (other.cosContent != null)
				return false;
		} else if (!cosContent.equals(other.cosContent))
			return false;
		if (cosId == null) {
			if (other.cosId != null)
				return false;
		} else if (!cosId.equals(other.cosId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (cosStatus == null) {
			if (other.cosStatus != null)
				return false;
		} else if (!cosStatus.equals(other.cosStatus))
			return false;
		if (cosTelephone == null) {
			if (other.cosTelephone != null)
				return false;
		} else if (!cosTelephone.equals(other.cosTelephone))
			return false;
		if (cosBool == null) {
			if (other.cosBool != null)
				return false;
		} else if (!cosBool.equals(other.cosBool))
			return false;
		if (cosName == null) {
			if (other.cosName != null)
				return false;
		} else if (!cosName.equals(other.cosName))
			return false;
		if (cosTime == null) {
			if (other.cosTime != null)
				return false;
		} else if (!cosTime.equals(other.cosTime))
			return false;
		if (cosCode == null) {
			if (other.cosCode != null)
				return false;
		} else if (!cosCode.equals(other.cosCode))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}