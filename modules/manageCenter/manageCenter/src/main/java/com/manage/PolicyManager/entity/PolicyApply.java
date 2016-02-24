/**
 *
 */
package com.manage.PolicyManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
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
	
	private static final long serialVersionUID = 1325080004393847520L;
	

	@Column(name = "POLICY_APPLY_CONTACT_PEOPLE_")
	@Length(max=32)
	private String policyApplyContactPeople;//联系人

	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation member;//会员用户ID

	@Column(name = "POLICY_APPLY_CONPANY_NAME_")
	@Length(max=32)
	private String policyApplyConpanyName;//企业名称

	@Column(name = "POLICY_APPLY_STATUS_")
	@Length(max=2)
	private String policyApplyStatus;//申请状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POLICY_APPLY_ID_")
	@Length(max=36)
	private String policyApplyId;//政策申请记录ID

	@Column(name = "POLICY_APPLY_CONTACT_TEL_")
	@Length(max=32)
	private String policyApplyContactTel;//联系电话
	
	public String getPolicyApplyContactPeople(){
		return this.policyApplyContactPeople;
	}
	
	public void setPolicyApplyContactPeople(String policyApplyContactPeople){
		this.policyApplyContactPeople = policyApplyContactPeople;
	}
	public MemberInformation getMember(){
		return this.member;
	}
	
	public void setMember(MemberInformation member){
		this.member = member;
	}
	public String getPolicyApplyConpanyName(){
		return this.policyApplyConpanyName;
	}
	
	public void setPolicyApplyConpanyName(String policyApplyConpanyName){
		this.policyApplyConpanyName = policyApplyConpanyName;
	}
	public String getPolicyApplyStatus(){
		return this.policyApplyStatus;
	}
	
	public void setPolicyApplyStatus(String policyApplyStatus){
		this.policyApplyStatus = policyApplyStatus;
	}
	public String getPolicyApplyId(){
		return this.policyApplyId;
	}
	
	public void setPolicyApplyId(String policyApplyId){
		this.policyApplyId = policyApplyId;
	}
	public String getPolicyApplyContactTel(){
		return this.policyApplyContactTel;
	}
	
	public void setPolicyApplyContactTel(String policyApplyContactTel){
		this.policyApplyContactTel = policyApplyContactTel;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((policyApplyContactPeople == null) ? 0 : policyApplyContactPeople.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((policyApplyConpanyName == null) ? 0 : policyApplyConpanyName.hashCode());
		result = prime * result + ((policyApplyStatus == null) ? 0 : policyApplyStatus.hashCode());
		result = prime * result + ((policyApplyId == null) ? 0 : policyApplyId.hashCode());
		result = prime * result + ((policyApplyContactTel == null) ? 0 : policyApplyContactTel.hashCode());
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
		if (policyApplyContactPeople == null) {
			if (other.policyApplyContactPeople != null)
				return false;
		} else if (!policyApplyContactPeople.equals(other.policyApplyContactPeople))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (policyApplyConpanyName == null) {
			if (other.policyApplyConpanyName != null)
				return false;
		} else if (!policyApplyConpanyName.equals(other.policyApplyConpanyName))
			return false;
		if (policyApplyStatus == null) {
			if (other.policyApplyStatus != null)
				return false;
		} else if (!policyApplyStatus.equals(other.policyApplyStatus))
			return false;
		if (policyApplyId == null) {
			if (other.policyApplyId != null)
				return false;
		} else if (!policyApplyId.equals(other.policyApplyId))
			return false;
		if (policyApplyContactTel == null) {
			if (other.policyApplyContactTel != null)
				return false;
		} else if (!policyApplyContactTel.equals(other.policyApplyContactTel))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}