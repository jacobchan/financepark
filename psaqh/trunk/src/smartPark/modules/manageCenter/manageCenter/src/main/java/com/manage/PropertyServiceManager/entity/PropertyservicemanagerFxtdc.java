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
	@Length(max=200)
	private String twcrdAddrec;//二维码URL地址

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FXTDC_ID_")
	@Length(max=36)
	private String fxtdcId;//二维码记录序列
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MOVEREC_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec propertyservicemanagerMoverec;//搬家申请记录ID
	
	@Column(name = "FXTDC_STATUS_")
	@Length(max=2)
	private String fxtdcStatus;//二维码有效状态
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
	public String getFxtdcStatus() {
		return fxtdcStatus;
	}

	public void setFxtdcStatus(String fxtdcStatus) {
		this.fxtdcStatus = fxtdcStatus;
	}

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
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((fxtdcId == null) ? 0 : fxtdcId.hashCode());
		result = prime * result
				+ ((fxtdcStatus == null) ? 0 : fxtdcStatus.hashCode());
		result = prime
				* result
				+ ((propertyservicemanagerMoverec == null) ? 0
						: propertyservicemanagerMoverec.hashCode());
		result = prime * result
				+ ((twcrdAddrec == null) ? 0 : twcrdAddrec.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
		
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
		PropertyservicemanagerFxtdc other = (PropertyservicemanagerFxtdc) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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
		if (fxtdcStatus == null) {
			if (other.fxtdcStatus != null)
				return false;
		} else if (!fxtdcStatus.equals(other.fxtdcStatus))
			return false;
		if (propertyservicemanagerMoverec == null) {
			if (other.propertyservicemanagerMoverec != null)
				return false;
		} else if (!propertyservicemanagerMoverec
				.equals(other.propertyservicemanagerMoverec))
			return false;
		if (twcrdAddrec == null) {
			if (other.twcrdAddrec != null)
				return false;
		} else if (!twcrdAddrec.equals(other.twcrdAddrec))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
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