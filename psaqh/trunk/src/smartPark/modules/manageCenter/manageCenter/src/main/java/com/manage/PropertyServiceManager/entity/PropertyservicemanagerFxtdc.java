/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 搬家放行二维码记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_fxtdc")
public class PropertyservicemanagerFxtdc implements Domain{
	
	private static final long serialVersionUID = -811901139914338550L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "TWCRD_ADDREC_")
	@Length(max=50)
	private String twcrdAddrec;//二维码URL地址

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FXTDC_ID_")
	@Length(max=36)
	private String fxtdcId;//二维码记录序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MOVEREC_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec propertyservicemanagerMoverec;//搬家申请记录ID
	
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getTwcrdAddrec(){
		return this.twcrdAddrec;
	}
	
	public void setTwcrdAddrec(String twcrdAddrec){
		this.twcrdAddrec = twcrdAddrec;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getFxtdcId(){
		return this.fxtdcId;
	}
	
	public void setFxtdcId(String fxtdcId){
		this.fxtdcId = fxtdcId;
	}
	
	public void setPropertyservicemanagerMoverec(com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec propertyservicemanagerMoverec){
		this.propertyservicemanagerMoverec = propertyservicemanagerMoverec;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec getPropertyservicemanagerMoverec(){
		return this.propertyservicemanagerMoverec;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((twcrdAddrec == null) ? 0 : twcrdAddrec.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((fxtdcId == null) ? 0 : fxtdcId.hashCode());
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
		final PropertyservicemanagerFxtdc other = (PropertyservicemanagerFxtdc) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (twcrdAddrec == null) {
			if (other.twcrdAddrec != null)
				return false;
		} else if (!twcrdAddrec.equals(other.twcrdAddrec))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (fxtdcId == null) {
			if (other.fxtdcId != null)
				return false;
		} else if (!fxtdcId.equals(other.fxtdcId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}