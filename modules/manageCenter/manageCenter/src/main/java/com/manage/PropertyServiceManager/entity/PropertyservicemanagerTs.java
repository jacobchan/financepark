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
	
	private static final long serialVersionUID = 576913379329594609L;
	

	@Column(name = "TS_STATUS_")
	@Length(max=2)
	private String tsStatus;//派工受理状态

	@Column(name = "TS_TELEPHONE_")
	@Length(max=20)
	private String tsTelephone;//派工人员电话号码

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TS_ID_")
	@Length(max=36)
	private String tsId;//主键ID_

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "TS_REMARK_")
	@Length(max=300)
	private String tsRemark;//备注

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "TS_NAME_")
	@Length(max=32)
	private String tsName;//派工人员

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="BX_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx propertyservicemanagerBx;//报修记录ID
	
	@Column(name = "TS_TIME_")
	@Length(max=20)
	private String tsTime;//接单时间
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
	public String getTsTime() {
		return tsTime;
	}

	public void setTsTime(String tsTime) {
		this.tsTime = tsTime;
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getTsId(){
		return this.tsId;
	}
	
	public void setTsId(String tsId){
		this.tsId = tsId;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getTsRemark(){
		return this.tsRemark;
	}
	
	public void setTsRemark(String tsRemark){
		this.tsRemark = tsRemark;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getTsName(){
		return this.tsName;
	}
	
	public void setTsName(String tsName){
		this.tsName = tsName;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
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
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime
				* result
				+ ((propertyservicemanagerBx == null) ? 0
						: propertyservicemanagerBx.hashCode());
		result = prime * result + ((tsId == null) ? 0 : tsId.hashCode());
		result = prime * result + ((tsName == null) ? 0 : tsName.hashCode());
		result = prime * result
				+ ((tsRemark == null) ? 0 : tsRemark.hashCode());
		result = prime * result
				+ ((tsStatus == null) ? 0 : tsStatus.hashCode());
		result = prime * result
				+ ((tsTelephone == null) ? 0 : tsTelephone.hashCode());
		result = prime * result + ((tsTime == null) ? 0 : tsTime.hashCode());
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
		PropertyservicemanagerTs other = (PropertyservicemanagerTs) obj;
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
		if (propertyservicemanagerBx == null) {
			if (other.propertyservicemanagerBx != null)
				return false;
		} else if (!propertyservicemanagerBx
				.equals(other.propertyservicemanagerBx))
			return false;
		if (tsId == null) {
			if (other.tsId != null)
				return false;
		} else if (!tsId.equals(other.tsId))
			return false;
		if (tsName == null) {
			if (other.tsName != null)
				return false;
		} else if (!tsName.equals(other.tsName))
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
		if (tsTime == null) {
			if (other.tsTime != null)
				return false;
		} else if (!tsTime.equals(other.tsTime))
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