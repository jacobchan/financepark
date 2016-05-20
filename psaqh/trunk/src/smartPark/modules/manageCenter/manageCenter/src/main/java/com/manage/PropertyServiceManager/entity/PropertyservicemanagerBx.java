/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.workflow.entity.WorkflowDomain;
/**
 * 实体: 物业报修记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_bx")
public class PropertyservicemanagerBx implements Domain,WorkflowDomain{
	
	private static final long serialVersionUID = 1200019789396828818L;
	
	
	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "BX_REMARK_")
	@Length(max=300)
	private String bxRemark;//描述

	@Column(name = "BX_ADDRESS_")
	@Length(max=100)
	private String bxAddress;//维修地址

	@Column(name = "BX_WAY_")
	@Length(max=2)
	private String bxWay;//报修方式

	@Column(name = "BX_TYPE_")
	@Length(max=2)
	private String bxType;//报修类型
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BX_ID_")
	@Length(max=36)
	private String bxId;//报修记录ID

	@Column(name = "BX_PROJECT_")
	@Length(max=2)
	private String bxProject;//报修项目

	@Column(name = "BX_AMOUNT_")
	private BigDecimal bxAmount;//维修总价

	@Column(name = "BX_FUJIAN")
	@Length(max=50)
	private String bxFujian;//附件

	@Column(name = "BX_COMP_")
	@Length(max=50)
	private String bxComp;//企业名称
	
	@Column(name = "BX_STATUS_")
	@Length(max=2)
	private String bxStatus;//报修状态
	
	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	@Column(name = "BX_CODE_")
	@Length(max=50)
	private String bxCode;//报修单号
	
	@Column(name = "APPLY_TIME_")
	private String applyTime;//申请时间
	
	@Column(name = "MEMBERID_")
	@Length(max=36)
	private String memberId;//报修人
	
	@Transient
	private MemberInformation member;
	
	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getBxCode() {
		return bxCode;
	}

	public void setBxCode(String bxCode) {
		this.bxCode = bxCode;
	}
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBxStatus() {
		return bxStatus;
	}

	public void setBxStatus(String bxStatus) {
		this.bxStatus = bxStatus;
	}

	public String getBxRemark(){
		return this.bxRemark;
	}
	
	public void setBxRemark(String bxRemark){
		this.bxRemark = bxRemark;
	}
	public String getBxAddress(){
		return this.bxAddress;
	}
	
	public void setBxAddress(String bxAddress){
		this.bxAddress = bxAddress;
	}
	public String getBxWay(){
		return this.bxWay;
	}
	
	public void setBxWay(String bxWay){
		this.bxWay = bxWay;
	}
	public String getBxType(){
		return this.bxType;
	}
	
	public void setBxType(String bxType){
		this.bxType = bxType;
	}
	public String getBxId(){
		return this.bxId;
	}
	
	public void setBxId(String bxId){
		this.bxId = bxId;
	}
	public String getBxProject(){
		return this.bxProject;
	}
	
	public void setBxProject(String bxProject){
		this.bxProject = bxProject;
	}

	
	public BigDecimal getBxAmount() {
		return bxAmount;
	}

	public void setBxAmount(BigDecimal bxAmount) {
		this.bxAmount = bxAmount;
	}

	public String getBxFujian(){
		return this.bxFujian;
	}
	
	public void setBxFujian(String bxFujian){
		this.bxFujian = bxFujian;
	}
	public String getBxComp(){
		return this.bxComp;
	}
	
	public void setBxComp(String bxComp){
		this.bxComp = bxComp;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applyTime == null) ? 0 : applyTime.hashCode());
		result = prime * result
				+ ((bxAddress == null) ? 0 : bxAddress.hashCode());
		result = prime * result
				+ ((bxAmount == null) ? 0 : bxAmount.hashCode());
		result = prime * result + ((bxCode == null) ? 0 : bxCode.hashCode());
		result = prime * result + ((bxComp == null) ? 0 : bxComp.hashCode());
		result = prime * result
				+ ((bxFujian == null) ? 0 : bxFujian.hashCode());
		result = prime * result + ((bxId == null) ? 0 : bxId.hashCode());
		result = prime * result
				+ ((bxProject == null) ? 0 : bxProject.hashCode());
		result = prime * result
				+ ((bxRemark == null) ? 0 : bxRemark.hashCode());
		result = prime * result
				+ ((bxStatus == null) ? 0 : bxStatus.hashCode());
		result = prime * result + ((bxType == null) ? 0 : bxType.hashCode());
		result = prime * result + ((bxWay == null) ? 0 : bxWay.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		PropertyservicemanagerBx other = (PropertyservicemanagerBx) obj;
		if (applyTime == null) {
			if (other.applyTime != null)
				return false;
		} else if (!applyTime.equals(other.applyTime))
			return false;
		if (bxAddress == null) {
			if (other.bxAddress != null)
				return false;
		} else if (!bxAddress.equals(other.bxAddress))
			return false;
		if (bxAmount == null) {
			if (other.bxAmount != null)
				return false;
		} else if (!bxAmount.equals(other.bxAmount))
			return false;
		if (bxCode == null) {
			if (other.bxCode != null)
				return false;
		} else if (!bxCode.equals(other.bxCode))
			return false;
		if (bxComp == null) {
			if (other.bxComp != null)
				return false;
		} else if (!bxComp.equals(other.bxComp))
			return false;
		if (bxFujian == null) {
			if (other.bxFujian != null)
				return false;
		} else if (!bxFujian.equals(other.bxFujian))
			return false;
		if (bxId == null) {
			if (other.bxId != null)
				return false;
		} else if (!bxId.equals(other.bxId))
			return false;
		if (bxProject == null) {
			if (other.bxProject != null)
				return false;
		} else if (!bxProject.equals(other.bxProject))
			return false;
		if (bxRemark == null) {
			if (other.bxRemark != null)
				return false;
		} else if (!bxRemark.equals(other.bxRemark))
			return false;
		if (bxStatus == null) {
			if (other.bxStatus != null)
				return false;
		} else if (!bxStatus.equals(other.bxStatus))
			return false;
		if (bxType == null) {
			if (other.bxType != null)
				return false;
		} else if (!bxType.equals(other.bxType))
			return false;
		if (bxWay == null) {
			if (other.bxWay != null)
				return false;
		} else if (!bxWay.equals(other.bxWay))
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
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
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
		return true;
	}
	
	public String toString(){
		return super.toString();
	}

	@Override
	public String getBusinessKey() {
		// TODO Auto-generated method stub
		return bxId;
	}
}