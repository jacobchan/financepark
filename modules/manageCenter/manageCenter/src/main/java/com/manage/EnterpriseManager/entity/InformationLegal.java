/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 法人介绍
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_legal")
public class InformationLegal implements Domain{
	
	private static final long serialVersionUID = 7350461715745566508L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "LEGAL_TELEPHONE_")
	@Length(max=16)
	private String legalTelephone;//联系方式

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "LEGAL_ID_")
	@Length(max=36)
	private String legalId;//ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "LEGAL_RE_")
	@Length(max=32)
	private String legalRe;//企业信息ID

	@Column(name = "LEGAL_NAME_")
	@Length(max=64)
	private String legalName;//法人信息

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2
	
	@Column(name = "LEGAL_IMAGE_")
	@Length(max=256)
	private String legalImage;//法人图像

	@Column(name = "LEGAL_BIRTHDAY_")
	@Length(max=20)
	private String legalBirthday;//法人生日
	
	@Column(name = "LEGAL_BUSINESS_")
	@Length(max=256)
	private String legalBusiness;//法人职务

	@Column(name = "LEGAL_REMARK_")
	@Length(max=256)
	private String legalRemark;//法人简述
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
	public String getLegalImage() {
		return legalImage;
	}

	public void setLegalImage(String legalImage) {
		this.legalImage = legalImage;
	}

	public String getLegalBirthday() {
		return legalBirthday;
	}

	public void setLegalBirthday(String legalBirthday) {
		this.legalBirthday = legalBirthday;
	}

	public String getLegalBusiness() {
		return legalBusiness;
	}

	public void setLegalBusiness(String legalBusiness) {
		this.legalBusiness = legalBusiness;
	}

	public String getLegalRemark() {
		return legalRemark;
	}

	public void setLegalRemark(String legalRemark) {
		this.legalRemark = legalRemark;
	}

	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getLegalTelephone(){
		return this.legalTelephone;
	}
	
	public void setLegalTelephone(String legalTelephone){
		this.legalTelephone = legalTelephone;
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
	public String getLegalId(){
		return this.legalId;
	}
	
	public void setLegalId(String legalId){
		this.legalId = legalId;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getLegalRe(){
		return this.legalRe;
	}
	
	public void setLegalRe(String legalRe){
		this.legalRe = legalRe;
	}
	public String getLegalName(){
		return this.legalName;
	}
	
	public void setLegalName(String legalName){
		this.legalName = legalName;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((legalTelephone == null) ? 0 : legalTelephone.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((legalId == null) ? 0 : legalId.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((legalRe == null) ? 0 : legalRe.hashCode());
		result = prime * result + ((legalName == null) ? 0 : legalName.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
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
		final InformationLegal other = (InformationLegal) obj;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (legalTelephone == null) {
			if (other.legalTelephone != null)
				return false;
		} else if (!legalTelephone.equals(other.legalTelephone))
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
		if (legalId == null) {
			if (other.legalId != null)
				return false;
		} else if (!legalId.equals(other.legalId))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (legalRe == null) {
			if (other.legalRe != null)
				return false;
		} else if (!legalRe.equals(other.legalRe))
			return false;
		if (legalName == null) {
			if (other.legalName != null)
				return false;
		} else if (!legalName.equals(other.legalName))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
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