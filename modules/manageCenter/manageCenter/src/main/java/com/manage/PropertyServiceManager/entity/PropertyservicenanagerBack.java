/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 投诉回访记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicenanager_back")
public class PropertyservicenanagerBack implements Domain{
	
	private static final long serialVersionUID = -8616190603389459289L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "BACK_RECORD_")
	@Length(max=300)
	private String backRecord;//回访记录

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "BACK_CODE_")
	@Length(max=32)
	private String backCode;//回访单号

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BACK_ID_")
	@Length(max=36)
	private String backId;//回访ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COS_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos propertyservicemanagerCos;//投诉ID
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
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getBackRecord(){
		return this.backRecord;
	}
	
	public void setBackRecord(String backRecord){
		this.backRecord = backRecord;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getBackCode(){
		return this.backCode;
	}
	
	public void setBackCode(String backCode){
		this.backCode = backCode;
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
	public String getBackId(){
		return this.backId;
	}
	
	public void setBackId(String backId){
		this.backId = backId;
	}
	
	public void setPropertyservicemanagerCos(com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos propertyservicemanagerCos){
		this.propertyservicemanagerCos = propertyservicemanagerCos;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos getPropertyservicemanagerCos(){
		return this.propertyservicemanagerCos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((backRecord == null) ? 0 : backRecord.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((backCode == null) ? 0 : backCode.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((backId == null) ? 0 : backId.hashCode());
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
		final PropertyservicenanagerBack other = (PropertyservicenanagerBack) obj;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (backRecord == null) {
			if (other.backRecord != null)
				return false;
		} else if (!backRecord.equals(other.backRecord))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (backCode == null) {
			if (other.backCode != null)
				return false;
		} else if (!backCode.equals(other.backCode))
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
		if (backId == null) {
			if (other.backId != null)
				return false;
		} else if (!backId.equals(other.backId))
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