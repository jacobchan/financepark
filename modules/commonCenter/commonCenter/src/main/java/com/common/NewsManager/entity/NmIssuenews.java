/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 政策新闻内容
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_nm_issueNews_")
public class NmIssuenews implements Domain{
	
	private static final long serialVersionUID = -6674237235447509920L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POLICY_ID_")
	@Length(max=36)
	private String policyId;//政策ID

	@Column(name = "POLICY_STATUS_")
	@Length(max=2)
	private String policyStatus;//政策发布状态

	@Column(name = "POLICY_ISSUE_DATE_")
	@Length(max=20)
	private String policyIssueDate;//政策发布时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "POLICY_TYPE_")
	@Length(max=36)
	private String policyType;//政策类别

	@Column(name = "POLICY_CAPTION_")
	@Length(max=36)
	private String policyCaption;//政策名称

	@Column(name = "POLICY_CONTENT_")
	@Length(max=36)
	private String policyContent;//政策内容

	@Column(name = "POLICY_COME_")
	@Length(max=36)
	private String policyCome;//政策发布人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ISSUE_TEMPALATE_ID_")
	private com.common.NewsManager.entity.NmIssuetempalate nmIssuetempalate;//发布模板ID
	
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
	public String getPolicyId(){
		return this.policyId;
	}
	
	public void setPolicyId(String policyId){
		this.policyId = policyId;
	}
	public String getPolicyStatus(){
		return this.policyStatus;
	}
	
	public void setPolicyStatus(String policyStatus){
		this.policyStatus = policyStatus;
	}
	public String getPolicyIssueDate(){
		return this.policyIssueDate;
	}
	
	public void setPolicyIssueDate(String policyIssueDate){
		this.policyIssueDate = policyIssueDate;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getPolicyType(){
		return this.policyType;
	}
	
	public void setPolicyType(String policyType){
		this.policyType = policyType;
	}
	public String getPolicyCaption(){
		return this.policyCaption;
	}
	
	public void setPolicyCaption(String policyCaption){
		this.policyCaption = policyCaption;
	}
	public String getPolicyContent(){
		return this.policyContent;
	}
	
	public void setPolicyContent(String policyContent){
		this.policyContent = policyContent;
	}
	public String getPolicyCome(){
		return this.policyCome;
	}
	
	public void setPolicyCome(String policyCome){
		this.policyCome = policyCome;
	}
	
	public void setNmIssuetempalate(com.common.NewsManager.entity.NmIssuetempalate nmIssuetempalate){
		this.nmIssuetempalate = nmIssuetempalate;
	}
	
	public com.common.NewsManager.entity.NmIssuetempalate getNmIssuetempalate(){
		return this.nmIssuetempalate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((policyId == null) ? 0 : policyId.hashCode());
		result = prime * result + ((policyStatus == null) ? 0 : policyStatus.hashCode());
		result = prime * result + ((policyIssueDate == null) ? 0 : policyIssueDate.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((policyType == null) ? 0 : policyType.hashCode());
		result = prime * result + ((policyCaption == null) ? 0 : policyCaption.hashCode());
		result = prime * result + ((policyContent == null) ? 0 : policyContent.hashCode());
		result = prime * result + ((policyCome == null) ? 0 : policyCome.hashCode());
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
		final NmIssuenews other = (NmIssuenews) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (policyId == null) {
			if (other.policyId != null)
				return false;
		} else if (!policyId.equals(other.policyId))
			return false;
		if (policyStatus == null) {
			if (other.policyStatus != null)
				return false;
		} else if (!policyStatus.equals(other.policyStatus))
			return false;
		if (policyIssueDate == null) {
			if (other.policyIssueDate != null)
				return false;
		} else if (!policyIssueDate.equals(other.policyIssueDate))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (policyType == null) {
			if (other.policyType != null)
				return false;
		} else if (!policyType.equals(other.policyType))
			return false;
		if (policyCaption == null) {
			if (other.policyCaption != null)
				return false;
		} else if (!policyCaption.equals(other.policyCaption))
			return false;
		if (policyContent == null) {
			if (other.policyContent != null)
				return false;
		} else if (!policyContent.equals(other.policyContent))
			return false;
		if (policyCome == null) {
			if (other.policyCome != null)
				return false;
		} else if (!policyCome.equals(other.policyCome))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}