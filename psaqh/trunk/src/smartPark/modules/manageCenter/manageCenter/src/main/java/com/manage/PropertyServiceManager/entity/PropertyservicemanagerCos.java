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
 * 实体: 物业投诉记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_cos")
public class PropertyservicemanagerCos implements Domain{
	
	private static final long serialVersionUID = 4688840683427101188L;
	

	@Column(name = "COS_TELEPHONE_")
	@Length(max=16)
	private String cosTelephone;//回访电话

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "COS_STATUS_")
	@Length(max=2)
	private String cosStatus;//投诉受理状态 01：待受理 02：已受理 03：已取消 04：已退回

	@Column(name = "COS_TIME_")
	@Length(max=20)
	private String cosTime;//投诉时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "COS_CONTENT_")
	@Length(max=300)
	private String cosContent;//投诉内容

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "COS_CODE_")
	@Length(max=32)
	private String cosCode;//投诉单号

	@Column(name = "COS_BOOL_")
	@Length(max=2)
	private String cosBool;//是否接受回访
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COS_ID_")
	@Length(max=36)
	private String cosId;//投诉ID

	@Column(name = "COS_NAME_")
	@Length(max=32)
	private String cosName;//投诉联系人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberInformation;//会员ID
	
	@Column(name = "BACK_CODE_")
	@Length(max=32)
	private String backcode;//回访编号
	
	@Column(name = "BACK_RECORD_")
	@Length(max=300)
	private String backrecord;//回访记录
	
	@Column(name = "BACK_TIME_")
	@Length(max=20)
	private String backtime;//回访时间
	
	@Column(name = "BACK_REMARK_")
	@Length(max=256)
	private String backRemark;//拒绝理由
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
	
	public String getBackRemark() {
		return backRemark;
	}

	public void setBackRemark(String backRemark) {
		this.backRemark = backRemark;
	}

	public String getBackcode() {
		return backcode;
	}

	public void setBackcode(String backcode) {
		this.backcode = backcode;
	}

	public String getBackrecord() {
		return backrecord;
	}

	public void setBackrecord(String backrecord) {
		this.backrecord = backrecord;
	}

	public String getBacktime() {
		return backtime;
	}

	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}

	public String getCosTelephone(){
		return this.cosTelephone;
	}
	
	public void setCosTelephone(String cosTelephone){
		this.cosTelephone = cosTelephone;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCosStatus(){
		return this.cosStatus;
	}
	
	public void setCosStatus(String cosStatus){
		this.cosStatus = cosStatus;
	}
	public String getCosTime(){
		return this.cosTime;
	}
	
	public void setCosTime(String cosTime){
		this.cosTime = cosTime;
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
	public String getCosContent(){
		return this.cosContent;
	}
	
	public void setCosContent(String cosContent){
		this.cosContent = cosContent;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCosCode(){
		return this.cosCode;
	}
	
	public void setCosCode(String cosCode){
		this.cosCode = cosCode;
	}
	public String getCosBool(){
		return this.cosBool;
	}
	
	public void setCosBool(String cosBool){
		this.cosBool = cosBool;
	}
	public String getCosId(){
		return this.cosId;
	}
	
	public void setCosId(String cosId){
		this.cosId = cosId;
	}
	public String getCosName(){
		return this.cosName;
	}
	
	public void setCosName(String cosName){
		this.cosName = cosName;
	}
	
	public MemberInformation getMemberInformation() {
		return memberInformation;
	}

	public void setMemberInformation(MemberInformation memberInformation) {
		this.memberInformation = memberInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cosTelephone == null) ? 0 : cosTelephone.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((cosStatus == null) ? 0 : cosStatus.hashCode());
		result = prime * result + ((cosTime == null) ? 0 : cosTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((cosContent == null) ? 0 : cosContent.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((cosCode == null) ? 0 : cosCode.hashCode());
		result = prime * result + ((cosBool == null) ? 0 : cosBool.hashCode());
		result = prime * result + ((cosId == null) ? 0 : cosId.hashCode());
		result = prime * result + ((cosName == null) ? 0 : cosName.hashCode());
		result = prime * result + ((backRemark == null) ? 0 : backRemark.hashCode());
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
		final PropertyservicemanagerCos other = (PropertyservicemanagerCos) obj;
		if (cosTelephone == null) {
			if (other.cosTelephone != null)
				return false;
		} else if (!cosTelephone.equals(other.cosTelephone))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (cosStatus == null) {
			if (other.cosStatus != null)
				return false;
		} else if (!cosStatus.equals(other.cosStatus))
			return false;
		if (cosTime == null) {
			if (other.cosTime != null)
				return false;
		} else if (!cosTime.equals(other.cosTime))
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
		if (cosContent == null) {
			if (other.cosContent != null)
				return false;
		} else if (!cosContent.equals(other.cosContent))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (cosCode == null) {
			if (other.cosCode != null)
				return false;
		} else if (!cosCode.equals(other.cosCode))
			return false;
		if (cosBool == null) {
			if (other.cosBool != null)
				return false;
		} else if (!cosBool.equals(other.cosBool))
			return false;
		if (cosId == null) {
			if (other.cosId != null)
				return false;
		} else if (!cosId.equals(other.cosId))
			return false;
		if (cosName == null) {
			if (other.cosName != null)
				return false;
		} else if (!cosName.equals(other.cosName))
			return false;
		if (backRemark == null) {
			if (other.backRemark != null)
				return false;
		} else if (!backRemark.equals(other.backRemark))
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