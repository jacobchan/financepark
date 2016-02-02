/**
 *
 */
package com.manage.PolicyManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -政策申请记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_policy_apply")
public class PolicyApply implements Domain{
	
	private static final long serialVersionUID = 3571676396182358249L;
	

	@Column(name = "POLICY_APPLY_CONTACT_TEL_")
	@Length(max=32)
	private String policyApplyContactTel;//联系电话
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POLICY_APPLY_ID_")
	private String policyApplyId;//政策申请记录ID

	@Column(name = "企业名称3POLICY_APPLY_CONPANY_NAME_")
	@Length(max=32)
	private String 企业名称3policyApplyConpanyName;//企业名称

	@Column(name = "POLICY_APPLY_CONTACT_PEOPLE_")
	@Length(max=32)
	private String policyApplyContactPeople;//联系人

	@Column(name = "POLICY_APPLY_STATUS_")
	@Length(max=2)
	private String policyApplyStatus;//申请状态

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID
	
	public String getPolicyApplyContactTel(){
		return this.policyApplyContactTel;
	}
	
	public void setPolicyApplyContactTel(String policyApplyContactTel){
		this.policyApplyContactTel = policyApplyContactTel;
	}
	public String getPolicyApplyId(){
		return this.policyApplyId;
	}
	
	public void setPolicyApplyId(String policyApplyId){
		this.policyApplyId = policyApplyId;
	}
	public String get企业名称3policyApplyConpanyName(){
		return this.企业名称3policyApplyConpanyName;
	}
	
	public void set企业名称3policyApplyConpanyName(String 企业名称3policyApplyConpanyName){
		this.企业名称3policyApplyConpanyName = 企业名称3policyApplyConpanyName;
	}
	public String getPolicyApplyContactPeople(){
		return this.policyApplyContactPeople;
	}
	
	public void setPolicyApplyContactPeople(String policyApplyContactPeople){
		this.policyApplyContactPeople = policyApplyContactPeople;
	}
	public String getPolicyApplyStatus(){
		return this.policyApplyStatus;
	}
	
	public void setPolicyApplyStatus(String policyApplyStatus){
		this.policyApplyStatus = policyApplyStatus;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((policyApplyContactTel == null) ? 0 : policyApplyContactTel.hashCode());
		result = prime * result + ((policyApplyId == null) ? 0 : policyApplyId.hashCode());
		result = prime * result + ((企业名称3policyApplyConpanyName == null) ? 0 : 企业名称3policyApplyConpanyName.hashCode());
		result = prime * result + ((policyApplyContactPeople == null) ? 0 : policyApplyContactPeople.hashCode());
		result = prime * result + ((policyApplyStatus == null) ? 0 : policyApplyStatus.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		final PolicyApply other = (PolicyApply) obj;
		if (policyApplyContactTel == null) {
			if (other.policyApplyContactTel != null)
				return false;
		} else if (!policyApplyContactTel.equals(other.policyApplyContactTel))
			return false;
		if (policyApplyId == null) {
			if (other.policyApplyId != null)
				return false;
		} else if (!policyApplyId.equals(other.policyApplyId))
			return false;
		if (企业名称3policyApplyConpanyName == null) {
			if (other.企业名称3policyApplyConpanyName != null)
				return false;
		} else if (!企业名称3policyApplyConpanyName.equals(other.企业名称3policyApplyConpanyName))
			return false;
		if (policyApplyContactPeople == null) {
			if (other.policyApplyContactPeople != null)
				return false;
		} else if (!policyApplyContactPeople.equals(other.policyApplyContactPeople))
			return false;
		if (policyApplyStatus == null) {
			if (other.policyApplyStatus != null)
				return false;
		} else if (!policyApplyStatus.equals(other.policyApplyStatus))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}