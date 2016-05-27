/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 330214二维码记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_twcrd")
public class PropertyservicemanagerTwcrd implements Domain{
	
	private static final long serialVersionUID = -1625881208499470837L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TWCRD_ID_")
	@Length(max=36)
	private String twcrdId;//二维码记录序列

	@Column(name = "TWCRD_ADDREC_")
	@Length(max=200)
	private String twcrdAddrec;//二维码URL地址
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="FKCODE_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode propertyservicemanagerFkcode;//访客申请ID
	
	@Column(name = "STATUS_")
	@Length(max=2)
	private String status;//二维码状态
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getTwcrdId(){
		return this.twcrdId;
	}
	
	public void setTwcrdId(String twcrdId){
		this.twcrdId = twcrdId;
	}
	public String getTwcrdAddrec(){
		return this.twcrdAddrec;
	}
	
	public void setTwcrdAddrec(String twcrdAddrec){
		this.twcrdAddrec = twcrdAddrec;
	}
	
	public void setPropertyservicemanagerFkcode(com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode propertyservicemanagerFkcode){
		this.propertyservicemanagerFkcode = propertyservicemanagerFkcode;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode getPropertyservicemanagerFkcode(){
		return this.propertyservicemanagerFkcode;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((twcrdId == null) ? 0 : twcrdId.hashCode());
		result = prime * result + ((twcrdAddrec == null) ? 0 : twcrdAddrec.hashCode());
		
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
		final PropertyservicemanagerTwcrd other = (PropertyservicemanagerTwcrd) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (twcrdId == null) {
			if (other.twcrdId != null)
				return false;
		} else if (!twcrdId.equals(other.twcrdId))
			return false;
		if (twcrdAddrec == null) {
			if (other.twcrdAddrec != null)
				return false;
		} else if (!twcrdAddrec.equals(other.twcrdAddrec))
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