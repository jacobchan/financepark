/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 派工维修记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_ts")
public class PropertyservicemanagerTs implements Domain{
	
	private static final long serialVersionUID = -6366597979887564546L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TS_ID_")
	@Length(max=36)
	private String tsId;//主键ID_

	@Column(name = "TS_REMARK_")
	@Length(max=300)
	private String tsRemark;//备注

	@Column(name = "TS_STATUS_")
	@Length(max=2)
	private String tsStatus;//派工受理状态

	@Column(name = "TS_TELEPHONE_")
	@Length(max=20)
	private String tsTelephone;//派工人员电话号码

	@Column(name = "TS_NAME_")
	@Length(max=32)
	private String tsName;//派工人员
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="BX_ID_")
	private PropertyservicemanagerBx propertyservicemanagerBx;//报修记录ID
	
	public String getTsId(){
		return this.tsId;
	}
	
	public void setTsId(String tsId){
		this.tsId = tsId;
	}
	public String getTsRemark(){
		return this.tsRemark;
	}
	
	public void setTsRemark(String tsRemark){
		this.tsRemark = tsRemark;
	}
	public String getTsStatus(){
		return this.tsStatus;
	}
	
	public void setTsStatus(String tsStatus){
		this.tsStatus = tsStatus;
	}
	public String getTsTelephone(){
		return this.tsTelephone;
	}
	
	public void setTsTelephone(String tsTelephone){
		this.tsTelephone = tsTelephone;
	}
	public String getTsName(){
		return this.tsName;
	}
	
	public void setTsName(String tsName){
		this.tsName = tsName;
	}
	
	public void setPropertyservicemanagerBx(com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx propertyservicemanagerBx){
		this.propertyservicemanagerBx = propertyservicemanagerBx;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx getPropertyservicemanagerBx(){
		return this.propertyservicemanagerBx;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tsId == null) ? 0 : tsId.hashCode());
		result = prime * result + ((tsRemark == null) ? 0 : tsRemark.hashCode());
		result = prime * result + ((tsStatus == null) ? 0 : tsStatus.hashCode());
		result = prime * result + ((tsTelephone == null) ? 0 : tsTelephone.hashCode());
		result = prime * result + ((tsName == null) ? 0 : tsName.hashCode());
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
		final PropertyservicemanagerTs other = (PropertyservicemanagerTs) obj;
		if (tsId == null) {
			if (other.tsId != null)
				return false;
		} else if (!tsId.equals(other.tsId))
			return false;
		if (tsRemark == null) {
			if (other.tsRemark != null)
				return false;
		} else if (!tsRemark.equals(other.tsRemark))
			return false;
		if (tsStatus == null) {
			if (other.tsStatus != null)
				return false;
		} else if (!tsStatus.equals(other.tsStatus))
			return false;
		if (tsTelephone == null) {
			if (other.tsTelephone != null)
				return false;
		} else if (!tsTelephone.equals(other.tsTelephone))
			return false;
		if (tsName == null) {
			if (other.tsName != null)
				return false;
		} else if (!tsName.equals(other.tsName))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}