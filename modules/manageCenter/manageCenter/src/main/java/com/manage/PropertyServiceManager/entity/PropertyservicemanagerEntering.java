/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 可办理预约记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_entering")
public class PropertyservicemanagerEntering implements Domain{
	
	private static final long serialVersionUID = -5710764330256040250L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "ENTERING_ALRE_")
	private String enteringAlre;//已预约数

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "ENTERING_DATE_")
	@Length(max=20)
	private String enteringDate;//预约时间日期

	@Column(name = "ENTERING_TIME_")
	@Length(max=20)
	private String enteringTime;//预约时间段

	@Column(name = "ENTERING_STATUS_")
	@Length(max=2)
	private String enteringStatus;//可预约状态

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "ENTERING_REMAIN_")
	private String enteringRemain;//剩余数量

	@Column(name = "ENTERING_SUM_")
	private String enteringSum;//预约总量
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ENTERING_ID_")
	@Length(max=36)
	private String enteringId;//预约记录ID

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getEnteringAlre(){
		return this.enteringAlre;
	}
	
	public void setEnteringAlre(String enteringAlre){
		this.enteringAlre = enteringAlre;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getEnteringDate(){
		return this.enteringDate;
	}
	
	public void setEnteringDate(String enteringDate){
		this.enteringDate = enteringDate;
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
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getEnteringRemain(){
		return this.enteringRemain;
	}
	
	public void setEnteringRemain(String enteringRemain){
		this.enteringRemain = enteringRemain;
	}
	public String getEnteringSum(){
		return this.enteringSum;
	}
	
	public void setEnteringSum(String enteringSum){
		this.enteringSum = enteringSum;
	}
	public String getEnteringId(){
		return this.enteringId;
	}
	
	public void setEnteringId(String enteringId){
		this.enteringId = enteringId;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((enteringAlre == null) ? 0 : enteringAlre.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((enteringDate == null) ? 0 : enteringDate.hashCode());
		result = prime * result + ((enteringTime == null) ? 0 : enteringTime.hashCode());
		result = prime * result + ((enteringStatus == null) ? 0 : enteringStatus.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((enteringRemain == null) ? 0 : enteringRemain.hashCode());
		result = prime * result + ((enteringSum == null) ? 0 : enteringSum.hashCode());
		result = prime * result + ((enteringId == null) ? 0 : enteringId.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		final PropertyservicemanagerEntering other = (PropertyservicemanagerEntering) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (enteringAlre == null) {
			if (other.enteringAlre != null)
				return false;
		} else if (!enteringAlre.equals(other.enteringAlre))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (enteringDate == null) {
			if (other.enteringDate != null)
				return false;
		} else if (!enteringDate.equals(other.enteringDate))
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
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (enteringRemain == null) {
			if (other.enteringRemain != null)
				return false;
		} else if (!enteringRemain.equals(other.enteringRemain))
			return false;
		if (enteringSum == null) {
			if (other.enteringSum != null)
				return false;
		} else if (!enteringSum.equals(other.enteringSum))
			return false;
		if (enteringId == null) {
			if (other.enteringId != null)
				return false;
		} else if (!enteringId.equals(other.enteringId))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
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