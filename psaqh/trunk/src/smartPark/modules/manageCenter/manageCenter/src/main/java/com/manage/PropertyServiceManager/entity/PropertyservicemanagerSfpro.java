/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 物业收费项目表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_sfpro")
public class PropertyservicemanagerSfpro implements Domain{
	
	private static final long serialVersionUID = -900697343768001146L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SFPRO_ID_")
	@Length(max=36)
	private String sfproId;//收费项目序列

	@Column(name = "SFPRO_AMOUNT_")
	private BigDecimal sfproAmount;//项目金额

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "SFPRO_NAME_")
	@Length(max=36)
	private String sfproName;//收费项目名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CHARGE_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge propertyservicemanagerCharge;//收费登记序列
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
	public String getSfproId(){
		return this.sfproId;
	}
	
	public void setSfproId(String sfproId){
		this.sfproId = sfproId;
	}
	
	public BigDecimal getSfproAmount() {
		return sfproAmount;
	}

	public void setSfproAmount(BigDecimal sfproAmount) {
		this.sfproAmount = sfproAmount;
	}

	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getSfproName(){
		return this.sfproName;
	}
	
	public void setSfproName(String sfproName){
		this.sfproName = sfproName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	
	public void setPropertyservicemanagerCharge(com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge propertyservicemanagerCharge){
		this.propertyservicemanagerCharge = propertyservicemanagerCharge;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge getPropertyservicemanagerCharge(){
		return this.propertyservicemanagerCharge;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((sfproId == null) ? 0 : sfproId.hashCode());
		result = prime * result + ((sfproAmount == null) ? 0 : sfproAmount.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((sfproName == null) ? 0 : sfproName.hashCode());
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
		final PropertyservicemanagerSfpro other = (PropertyservicemanagerSfpro) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (sfproId == null) {
			if (other.sfproId != null)
				return false;
		} else if (!sfproId.equals(other.sfproId))
			return false;
		if (sfproAmount == null) {
			if (other.sfproAmount != null)
				return false;
		} else if (!sfproAmount.equals(other.sfproAmount))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (sfproName == null) {
			if (other.sfproName != null)
				return false;
		} else if (!sfproName.equals(other.sfproName))
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