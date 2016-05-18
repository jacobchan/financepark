/**
 *
 */
package com.common.MemberManager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.IdUser;
import com.gsoft.framework.security.PrincipalConfig;
/**
 * 实体: -会员信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_member_information")
public class MemberInformation implements Domain,IdUser, IUser,IMemberInfomation{
	
	private static final long serialVersionUID = 2177240078237624499L;
	
	@Column(name = "MEMBER_BIRTHDATE_")
	private String memberBirthdate;//出生日期

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MEMBER_NAME_")
	@Length(max=32)
	private String memberName;//姓名

	@Column(name = "COMPANY_INVITECODE_")
	@Length(max=32)
	private String companyInvitecode;//企业邀请码
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "MEMBER_HEAD_PORTRAIT_")
	@Length(max=256)
	private String memberHeadPortrait;//头像

	@Column(name = "MEMBER_PHONE_NUMBER_")
	@Length(max=16)
	private String memberPhoneNumber;//电话号码

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "COMPANY_ID_")
	@Length(max=36)
	private String companyId;//企业ID

	@Column(name = "MEMBER_PASSWORD_")
	@Length(max=64)
	private String memberPassword;//用户密码

	@Column(name = "MEMBER_DESCRIBE2_")
	@Length(max=256)
	private String memberDescribe2;//简介

	@Column(name = "MEMBER_NICKNAME_")
	@Length(max=32)
	private String memberNickname;//昵称
	
	@Column(name = "PARENT_MEMBER_ID_")
	@Length(max=36)
	private String parentMemberId;//上级会员id
	
	@Column(name = "M_LEVEL_")
	@Length(max=32)
	private String level;//会员等级
	
	@Transient
	private String loginType;//非数据库映射属性
	
	
	@Transient
	private List<String> roleIds = new ArrayList<String>();//非数据库映射属性
	
	@Transient
	private PrincipalConfig principalConfig = new PrincipalConfig();
	
	
	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(String parentMemberId) {
		this.parentMemberId = parentMemberId;
	}

	public String getMemberBirthdate(){
		return this.memberBirthdate;
	}
	
	public void setMemberBirthdate(String memberBirthdate){
		this.memberBirthdate = memberBirthdate;
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMemberName(){
		return this.memberName;
	}
	
	public void setMemberName(String memberName){
		this.memberName = memberName;
	}
	public String getCompanyInvitecode(){
		return this.companyInvitecode;
	}
	
	public void setCompanyInvitecode(String companyInvitecode){
		this.companyInvitecode = companyInvitecode;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getMemberHeadPortrait(){
		return this.memberHeadPortrait;
	}
	
	public void setMemberHeadPortrait(String memberHeadPortrait){
		this.memberHeadPortrait = memberHeadPortrait;
	}
	public String getMemberPhoneNumber(){
		return this.memberPhoneNumber;
	}
	
	public void setMemberPhoneNumber(String memberPhoneNumber){
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCompanyId(){
		return this.companyId;
	}
	
	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}
	public String getMemberPassword(){
		return this.memberPassword;
	}
	
	public void setMemberPassword(String memberPassword){
		this.memberPassword = memberPassword;
	}
	public String getMemberDescribe2(){
		return this.memberDescribe2;
	}
	
	public void setMemberDescribe2(String memberDescribe2){
		this.memberDescribe2 = memberDescribe2;
	}
	public String getMemberNickname(){
		return this.memberNickname;
	}
	
	public void setMemberNickname(String memberNickname){
		this.memberNickname = memberNickname;
	}
	
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	
	public List<String> getRoleIds(){
		return this.roleIds;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberBirthdate == null) ? 0 : memberBirthdate.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((companyInvitecode == null) ? 0 : companyInvitecode.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberHeadPortrait == null) ? 0 : memberHeadPortrait.hashCode());
		result = prime * result + ((memberPhoneNumber == null) ? 0 : memberPhoneNumber.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
		result = prime * result + ((memberDescribe2 == null) ? 0 : memberDescribe2.hashCode());
		result = prime * result + ((memberNickname == null) ? 0 : memberNickname.hashCode());
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
		final MemberInformation other = (MemberInformation) obj;
		if (memberBirthdate == null) {
			if (other.memberBirthdate != null)
				return false;
		} else if (!memberBirthdate.equals(other.memberBirthdate))
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
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (companyInvitecode == null) {
			if (other.companyInvitecode != null)
				return false;
		} else if (!companyInvitecode.equals(other.companyInvitecode))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberHeadPortrait == null) {
			if (other.memberHeadPortrait != null)
				return false;
		} else if (!memberHeadPortrait.equals(other.memberHeadPortrait))
			return false;
		if (memberPhoneNumber == null) {
			if (other.memberPhoneNumber != null)
				return false;
		} else if (!memberPhoneNumber.equals(other.memberPhoneNumber))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (memberPassword == null) {
			if (other.memberPassword != null)
				return false;
		} else if (!memberPassword.equals(other.memberPassword))
			return false;
		if (memberDescribe2 == null) {
			if (other.memberDescribe2 != null)
				return false;
		} else if (!memberDescribe2.equals(other.memberDescribe2))
			return false;
		if (memberNickname == null) {
			if (other.memberNickname != null)
				return false;
		} else if (!memberNickname.equals(other.memberNickname))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}

	@Override
	public PrincipalConfig getPrincipalConfig() {
		// TODO Auto-generated method stub
		return principalConfig;
	}

	@Override
	public String getLoginName() {
		// TODO Auto-generated method stub
		return this.memberName;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.memberPassword;
	}

	@Override
	public List<String> roleIds() {
		// TODO Auto-generated method stub
		return roleIds;
	}
	
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	@Override
	public String getLoginType()
	{
		return this.loginType;
	}
	
	@Override
	@Transient
	public String getUserId() {
		// TODO Auto-generated method stub
		return this.memberId;
	}
}