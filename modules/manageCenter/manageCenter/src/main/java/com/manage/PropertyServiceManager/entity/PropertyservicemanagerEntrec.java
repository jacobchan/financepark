/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 入驻服务办理预约记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_entrec")
public class PropertyservicemanagerEntrec implements Domain{
	
	private static final long serialVersionUID = 804004827154883868L;
	

	@Column(name = "ENTERREC_STATUS_")
	@Length(max=2)
	private String enterrecStatus;//预约记录状态
	
	@Column(name = "ENTERING_TYPE_")
	@Length(max=2)
	private String enteringType;//入驻申请状态

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	
	@Column(name = "ENTERREC_CODE_")
	@Length(max=32)
	private String enterrecCode;//预约受理编号

	@Column(name = "ENTERING_NAME_")
	@Length(max=32)
	private String enteringName;//入驻申请人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "ENTERING_TIME_")
	@Length(max=20)
	private String enteringTime;//预约时间段

	@Column(name = "ENTERING_TELEPHONE_")
	@Length(max=16)
	private String enteringTelephone;//入驻联系电话

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ENTREC_ID_")
	@Length(max=36)
	private String entrecId;//入驻预约记录ID

	@Column(name = "ENTERING_DATE_")
	@Length(max=20)
	private String enteringDate;//预约时间日期
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ENTERING_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering propertyservicemanagerEntering;//预约记录ID
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

	public String getEnterrecStatus(){
		return this.enterrecStatus;
	}
	
	public void setEnterrecStatus(String enterrecStatus){
		this.enterrecStatus = enterrecStatus;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getEnteringName(){
		return this.enteringName;
	}
	
	public void setEnteringName(String enteringName){
		this.enteringName = enteringName;
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
	public String getEnteringTime(){
		return this.enteringTime;
	}
	
	public void setEnteringTime(String enteringTime){
		this.enteringTime = enteringTime;
	}
	public String getEnteringTelephone(){
		return this.enteringTelephone;
	}
	
	public void setEnteringTelephone(String enteringTelephone){
		this.enteringTelephone = enteringTelephone;
	}
	
	
	
	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getEntrecId(){
		return this.entrecId;
	}
	
	public void setEntrecId(String entrecId){
		this.entrecId = entrecId;
	}
	public String getEnteringDate(){
		return this.enteringDate;
	}
	
	public void setEnteringDate(String enteringDate){
		this.enteringDate = enteringDate;
	}
	
	public void setPropertyservicemanagerEntering(com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering propertyservicemanagerEntering){
		this.propertyservicemanagerEntering = propertyservicemanagerEntering;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering getPropertyservicemanagerEntering(){
		return this.propertyservicemanagerEntering;
	}
	
	
	
	public String getEnterrecCode() {
		return enterrecCode;
	}

	public void setEnterrecCode(String enterrecCode) {
		this.enterrecCode = enterrecCode;
	}

	
	
	public String getEnteringType() {
		return enteringType;
	}

	public void setEnteringType(String enteringType) {
		this.enteringType = enteringType;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((enteringDate == null) ? 0 : enteringDate.hashCode());
		result = prime * result
				+ ((enteringName == null) ? 0 : enteringName.hashCode());
		result = prime
				* result
				+ ((enteringTelephone == null) ? 0 : enteringTelephone
						.hashCode());
		result = prime * result
				+ ((enteringTime == null) ? 0 : enteringTime.hashCode());
		result = prime * result
				+ ((enteringType == null) ? 0 : enteringType.hashCode());
		result = prime * result
				+ ((enterrecCode == null) ? 0 : enterrecCode.hashCode());
		result = prime * result
				+ ((enterrecStatus == null) ? 0 : enterrecStatus.hashCode());
		result = prime * result
				+ ((entrecId == null) ? 0 : entrecId.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime
				* result
				+ ((propertyservicemanagerEntering == null) ? 0
						: propertyservicemanagerEntering.hashCode());
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
		PropertyservicemanagerEntrec other = (PropertyservicemanagerEntrec) obj;
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
		if (enteringDate == null) {
			if (other.enteringDate != null)
				return false;
		} else if (!enteringDate.equals(other.enteringDate))
			return false;
		if (enteringName == null) {
			if (other.enteringName != null)
				return false;
		} else if (!enteringName.equals(other.enteringName))
			return false;
		if (enteringTelephone == null) {
			if (other.enteringTelephone != null)
				return false;
		} else if (!enteringTelephone.equals(other.enteringTelephone))
			return false;
		if (enteringTime == null) {
			if (other.enteringTime != null)
				return false;
		} else if (!enteringTime.equals(other.enteringTime))
			return false;
		if (enteringType == null) {
			if (other.enteringType != null)
				return false;
		} else if (!enteringType.equals(other.enteringType))
			return false;
		if (enterrecCode == null) {
			if (other.enterrecCode != null)
				return false;
		} else if (!enterrecCode.equals(other.enterrecCode))
			return false;
		if (enterrecStatus == null) {
			if (other.enterrecStatus != null)
				return false;
		} else if (!enterrecStatus.equals(other.enterrecStatus))
			return false;
		if (entrecId == null) {
			if (other.entrecId != null)
				return false;
		} else if (!entrecId.equals(other.entrecId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (propertyservicemanagerEntering == null) {
			if (other.propertyservicemanagerEntering != null)
				return false;
		} else if (!propertyservicemanagerEntering
				.equals(other.propertyservicemanagerEntering))
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