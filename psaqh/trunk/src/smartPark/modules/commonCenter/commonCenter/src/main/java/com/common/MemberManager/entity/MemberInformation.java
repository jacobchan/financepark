/**
 *
 */
package com.common.MemberManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -会员信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_member_information")
public class MemberInformation implements Domain{
	
	private static final long serialVersionUID = -5654178042215475155L;
	

	@Column(name = "MEMBER_BIRTHDATE_")
	private String memberBirthdate;//出生日期

	@Column(name = "MEMBER_NICKNAME_")
	@Length(max=32)
	private String memberNickname;//昵称

	@Column(name = "MEMBER_DESCRIBE2_")
	@Length(max=256)
	private String memberDescribe2;//简介

	@Column(name = "MEMBER_HEAD_PORTRAIT_")
	@Length(max=32)
	private String memberHeadPortrait;//头像

	@Column(name = "MEMBER_NAME_")
	@Length(max=32)
	private String memberName;//姓名

	@Column(name = "MEMBER_PHONE_NUMBER_")
	@Length(max=16)
	private String memberPhoneNumber;//电话号码
	
	@Column(name = "MEMBER_PASSWORD_")
	@Length(max=40)
	private String memberPassword;//用户密码

	@Column(name = "COMPANY_ID_")
	@Length(max=36)
	private String companyId;//企业ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "COMPANY_INVITECODE_")
	@Length(max=32)
	private String companyInvitecode;//企业邀请码
	
	public String getMemberBirthdate(){
		return this.memberBirthdate;
	}
	
	public void setMemberBirthdate(String memberBirthdate){
		this.memberBirthdate = memberBirthdate;
	}
	public String getMemberNickname(){
		return this.memberNickname;
	}
	
	public void setMemberNickname(String memberNickname){
		this.memberNickname = memberNickname;
	}
	public String getMemberDescribe2(){
		return this.memberDescribe2;
	}
	
	public void setMemberDescribe2(String memberDescribe2){
		this.memberDescribe2 = memberDescribe2;
	}
	public String getMemberHeadPortrait(){
		return this.memberHeadPortrait;
	}
	
	public void setMemberHeadPortrait(String memberHeadPortrait){
		this.memberHeadPortrait = memberHeadPortrait;
	}
	public String getMemberName(){
		return this.memberName;
	}
	
	public void setMemberName(String memberName){
		this.memberName = memberName;
	}
	public String getMemberPhoneNumber(){
		return this.memberPhoneNumber;
	}
	
	public void setMemberPhoneNumber(String memberPhoneNumber){
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getCompanyId(){
		return this.companyId;
	}
	
	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getCompanyInvitecode(){
		return this.companyInvitecode;
	}
	
	public void setCompanyInvitecode(String companyInvitecode){
		this.companyInvitecode = companyInvitecode;
	}
	
	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyId == null) ? 0 : companyId.hashCode());
		result = prime
				* result
				+ ((companyInvitecode == null) ? 0 : companyInvitecode
						.hashCode());
		result = prime * result
				+ ((memberBirthdate == null) ? 0 : memberBirthdate.hashCode());
		result = prime * result
				+ ((memberDescribe2 == null) ? 0 : memberDescribe2.hashCode());
		result = prime
				* result
				+ ((memberHeadPortrait == null) ? 0 : memberHeadPortrait
						.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result
				+ ((memberNickname == null) ? 0 : memberNickname.hashCode());
		result = prime * result
				+ ((memberPassword == null) ? 0 : memberPassword.hashCode());
		result = prime
				* result
				+ ((memberPhoneNumber == null) ? 0 : memberPhoneNumber
						.hashCode());
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
		MemberInformation other = (MemberInformation) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (companyInvitecode == null) {
			if (other.companyInvitecode != null)
				return false;
		} else if (!companyInvitecode.equals(other.companyInvitecode))
			return false;
		if (memberBirthdate == null) {
			if (other.memberBirthdate != null)
				return false;
		} else if (!memberBirthdate.equals(other.memberBirthdate))
			return false;
		if (memberDescribe2 == null) {
			if (other.memberDescribe2 != null)
				return false;
		} else if (!memberDescribe2.equals(other.memberDescribe2))
			return false;
		if (memberHeadPortrait == null) {
			if (other.memberHeadPortrait != null)
				return false;
		} else if (!memberHeadPortrait.equals(other.memberHeadPortrait))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberNickname == null) {
			if (other.memberNickname != null)
				return false;
		} else if (!memberNickname.equals(other.memberNickname))
			return false;
		if (memberPassword == null) {
			if (other.memberPassword != null)
				return false;
		} else if (!memberPassword.equals(other.memberPassword))
			return false;
		if (memberPhoneNumber == null) {
			if (other.memberPhoneNumber != null)
				return false;
		} else if (!memberPhoneNumber.equals(other.memberPhoneNumber))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}