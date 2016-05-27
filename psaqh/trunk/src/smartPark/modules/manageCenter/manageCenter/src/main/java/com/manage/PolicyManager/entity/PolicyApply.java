/**
 *
 */
package com.manage.PolicyManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.entity.NmIssuenews;
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
	
	private static final long serialVersionUID = -3899342288126952071L;
	

//	@Column(name = "MEMBER_ID_")
//	@Length(max=36)
//	private String memberId;//会员用户ID
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID_")
	private MemberInformation member ;//会员用户
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POLICY_APPLY_ID_")
	@Length(max=36)
	private String policyApplyId;//政策申请记录ID

	@Column(name = "ISSUE_FLOW_ID_")
	@Length(max=36)
	private String issueFlowId;//流程ID

	@Column(name = "POLICY_APPLY_CONPANY_NAME_")
	@Length(max=32)
	private String policyApplyConpanyName;//企业名称

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "POLICY_ID_")
	@Length(max=36)
	private String policyId;//政策ID

	@Column(name = "POLICY_APPLY_STATUS_")
	@Length(max=2)
	private String policyApplyStatus;//申请记录状态

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "POLICY_APPLY_CONTACT_TEL_")
	@Length(max=32)
	private String policyApplyContactTel;//联系电话

	@Column(name = "POLICY_APPLY_CONTACT_PEOPLE_")
	@Length(max=32)
	private String policyApplyContactPeople;//联系人
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="POLICY_APPLY_ISSUENEWS_")
	private NmIssuenews nmIssuenews;//申请政策内容
	
	@OneToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="POLICY_APPLY_ISSUEFLOW_")
	private NmIssueflow nmIssueflow;//流程状态
	
	@Column(name = "POLICY_APPLY_CODE_")
	@Length(max=50)
	private String applyCode;//政策申请单号
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
	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public NmIssuenews getNmIssuenews() {
		return nmIssuenews;
	}

	public void setNmIssuenews(NmIssuenews nmIssuenews) {
		this.nmIssuenews = nmIssuenews;
	}

	public NmIssueflow getNmIssueflow() {
		return nmIssueflow;
	}

	public void setNmIssueflow(NmIssueflow nmIssueflow) {
		this.nmIssueflow = nmIssueflow;
	}

	
	public String getPolicyApplyId(){
		return this.policyApplyId;
	}
	
	public void setPolicyApplyId(String policyApplyId){
		this.policyApplyId = policyApplyId;
	}
	public String getIssueFlowId(){
		return this.issueFlowId;
	}
	
	public void setIssueFlowId(String issueFlowId){
		this.issueFlowId = issueFlowId;
	}
	public String getPolicyApplyConpanyName(){
		return this.policyApplyConpanyName;
	}
	
	public void setPolicyApplyConpanyName(String policyApplyConpanyName){
		this.policyApplyConpanyName = policyApplyConpanyName;
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getPolicyId(){
		return this.policyId;
	}
	
	public void setPolicyId(String policyId){
		this.policyId = policyId;
	}
	public String getPolicyApplyStatus(){
		return this.policyApplyStatus;
	}
	
	public void setPolicyApplyStatus(String policyApplyStatus){
		this.policyApplyStatus = policyApplyStatus;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getPolicyApplyContactTel(){
		return this.policyApplyContactTel;
	}
	
	public void setPolicyApplyContactTel(String policyApplyContactTel){
		this.policyApplyContactTel = policyApplyContactTel;
	}
	public String getPolicyApplyContactPeople(){
		return this.policyApplyContactPeople;
	}
	
	public void setPolicyApplyContactPeople(String policyApplyContactPeople){
		this.policyApplyContactPeople = policyApplyContactPeople;
	}
	
	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((policyApplyId == null) ? 0 : policyApplyId.hashCode());
		result = prime * result + ((issueFlowId == null) ? 0 : issueFlowId.hashCode());
		result = prime * result + ((policyApplyConpanyName == null) ? 0 : policyApplyConpanyName.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((policyId == null) ? 0 : policyId.hashCode());
		result = prime * result + ((policyApplyStatus == null) ? 0 : policyApplyStatus.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((policyApplyContactTel == null) ? 0 : policyApplyContactTel.hashCode());
		result = prime * result + ((policyApplyContactPeople == null) ? 0 : policyApplyContactPeople.hashCode());
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
		final PolicyApply other = (PolicyApply) obj;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (policyApplyId == null) {
			if (other.policyApplyId != null)
				return false;
		} else if (!policyApplyId.equals(other.policyApplyId))
			return false;
		if (issueFlowId == null) {
			if (other.issueFlowId != null)
				return false;
		} else if (!issueFlowId.equals(other.issueFlowId))
			return false;
		if (policyApplyConpanyName == null) {
			if (other.policyApplyConpanyName != null)
				return false;
		} else if (!policyApplyConpanyName.equals(other.policyApplyConpanyName))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
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
		if (policyId == null) {
			if (other.policyId != null)
				return false;
		} else if (!policyId.equals(other.policyId))
			return false;
		if (policyApplyStatus == null) {
			if (other.policyApplyStatus != null)
				return false;
		} else if (!policyApplyStatus.equals(other.policyApplyStatus))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (policyApplyContactTel == null) {
			if (other.policyApplyContactTel != null)
				return false;
		} else if (!policyApplyContactTel.equals(other.policyApplyContactTel))
			return false;
		if (policyApplyContactPeople == null) {
			if (other.policyApplyContactPeople != null)
				return false;
		} else if (!policyApplyContactPeople.equals(other.policyApplyContactPeople))
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