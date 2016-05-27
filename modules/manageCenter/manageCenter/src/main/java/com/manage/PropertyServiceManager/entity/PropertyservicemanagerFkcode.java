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
 * 实体: 访客申请记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_fkcode_")
public class PropertyservicemanagerFkcode implements Domain{
	
	private static final long serialVersionUID = -2996794324484747531L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "FKCODE_COMP_")
	@Length(max=36)
	private String fkcodeComp;//到访企业
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FKCODE_ID_")
	@Length(max=36)
	private String fkcodeId;//访客申请ID

	@Column(name = "FKCODE_SEX_")
	@Length(max=2)
	private String fkcodeSex;//性别

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "FKCODE_TELEPHONE_")
	@Length(max=16)
	private String fkcodeTelephone;//联系电话

	@Column(name = "FKCODE_NAME_")
	@Length(max=32)
	private String fkcodeName;//联系人

//	@Column(name = "MEMBER_ID_")
//	@Length(max=36)
//	private String memberId;//会员用户ID
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation member;//会员用户ID

	@Column(name = "FKCODE_REMARK_")
	@Length(max=300)
	private String fkcodeRemark;//访客说明

	@Column(name = "FKCODE_TIME_")
	@Length(max=20)
	private String fkcodeTime;//到访时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "APPLY_STATUS_")
	@Length(max=2)
	private String applyStatus;//申请状态
	
	@Column(name = "APPLY_TIME_")
	private String applyTime;//访客申请时间
	
	@Column(name = "FK_CODE_")
	@Length(max=50)
	private String fkCode;//访客申请单号
	
	@Transient
	private String dksataus;
	
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

	
	public String getDksataus() {
		return dksataus;
	}

	public void setDksataus(String dksataus) {
		this.dksataus = dksataus;
	}

	public String getFkCode() {
		return fkCode;
	}

	public void setFkCode(String fkCode) {
		this.fkCode = fkCode;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getFkcodeComp(){
		return this.fkcodeComp;
	}
	
	public void setFkcodeComp(String fkcodeComp){
		this.fkcodeComp = fkcodeComp;
	}
	public String getFkcodeId(){
		return this.fkcodeId;
	}
	
	public void setFkcodeId(String fkcodeId){
		this.fkcodeId = fkcodeId;
	}
	public String getFkcodeSex(){
		return this.fkcodeSex;
	}
	
	public void setFkcodeSex(String fkcodeSex){
		this.fkcodeSex = fkcodeSex;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getFkcodeTelephone(){
		return this.fkcodeTelephone;
	}
	
	public void setFkcodeTelephone(String fkcodeTelephone){
		this.fkcodeTelephone = fkcodeTelephone;
	}
	public String getFkcodeName(){
		return this.fkcodeName;
	}
	
	public void setFkcodeName(String fkcodeName){
		this.fkcodeName = fkcodeName;
	}
	
	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}

	public String getFkcodeRemark(){
		return this.fkcodeRemark;
	}
	
	public void setFkcodeRemark(String fkcodeRemark){
		this.fkcodeRemark = fkcodeRemark;
	}
	public String getFkcodeTime(){
		return this.fkcodeTime;
	}
	
	public void setFkcodeTime(String fkcodeTime){
		this.fkcodeTime = fkcodeTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applyStatus == null) ? 0 : applyStatus.hashCode());
		result = prime * result
				+ ((applyTime == null) ? 0 : applyTime.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((fkCode == null) ? 0 : fkCode.hashCode());
		result = prime * result
				+ ((fkcodeComp == null) ? 0 : fkcodeComp.hashCode());
		result = prime * result
				+ ((fkcodeId == null) ? 0 : fkcodeId.hashCode());
		result = prime * result
				+ ((fkcodeName == null) ? 0 : fkcodeName.hashCode());
		result = prime * result
				+ ((fkcodeRemark == null) ? 0 : fkcodeRemark.hashCode());
		result = prime * result
				+ ((fkcodeSex == null) ? 0 : fkcodeSex.hashCode());
		result = prime * result
				+ ((fkcodeTelephone == null) ? 0 : fkcodeTelephone.hashCode());
		result = prime * result
				+ ((fkcodeTime == null) ? 0 : fkcodeTime.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
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
		PropertyservicemanagerFkcode other = (PropertyservicemanagerFkcode) obj;
		if (applyStatus == null) {
			if (other.applyStatus != null)
				return false;
		} else if (!applyStatus.equals(other.applyStatus))
			return false;
		if (applyTime == null) {
			if (other.applyTime != null)
				return false;
		} else if (!applyTime.equals(other.applyTime))
			return false;
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
		if (fkCode == null) {
			if (other.fkCode != null)
				return false;
		} else if (!fkCode.equals(other.fkCode))
			return false;
		if (fkcodeComp == null) {
			if (other.fkcodeComp != null)
				return false;
		} else if (!fkcodeComp.equals(other.fkcodeComp))
			return false;
		if (fkcodeId == null) {
			if (other.fkcodeId != null)
				return false;
		} else if (!fkcodeId.equals(other.fkcodeId))
			return false;
		if (fkcodeName == null) {
			if (other.fkcodeName != null)
				return false;
		} else if (!fkcodeName.equals(other.fkcodeName))
			return false;
		if (fkcodeRemark == null) {
			if (other.fkcodeRemark != null)
				return false;
		} else if (!fkcodeRemark.equals(other.fkcodeRemark))
			return false;
		if (fkcodeSex == null) {
			if (other.fkcodeSex != null)
				return false;
		} else if (!fkcodeSex.equals(other.fkcodeSex))
			return false;
		if (fkcodeTelephone == null) {
			if (other.fkcodeTelephone != null)
				return false;
		} else if (!fkcodeTelephone.equals(other.fkcodeTelephone))
			return false;
		if (fkcodeTime == null) {
			if (other.fkcodeTime != null)
				return false;
		} else if (!fkcodeTime.equals(other.fkcodeTime))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
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