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
	
	private static final long serialVersionUID = 4296020146236073343L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POLICY_ID_")
	@Length(max=36)
	private String policyId;//政策ID

	@Column(name = "POLICY_TYPE_")
	@Length(max=36)
	private String policyType;//政策类别

	@Column(name = "POLICY_CAPTION_")
	@Length(max=36)
	private String policyCaption;//政策名称

	@Column(name = "POLICY_COME_")
	@Length(max=36)
	private String policyCome;//政策发布人

	@Column(name = "POLICY_CONTENT_")
	@Length(max=36)
	private String policyContent;//政策内容

	@Column(name = "POLICY_STATUS_")
	@Length(max=2)
	private String policyStatus;//政策发布状态

	@Column(name = "POLICY_ISSUE_DATE_")
	@Length(max=20)
	private String policyIssueDate;//政策发布时间
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ISSUE_TEMPALATE_ID_")
	private com.common.NewsManager.entity.NmIssuetempalate nmIssuetempalate;//发布模板ID
	
	public String getPolicyId(){
		return this.policyId;
	}
	
	public void setPolicyId(String policyId){
		this.policyId = policyId;
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
	public String getPolicyCome(){
		return this.policyCome;
	}
	
	public void setPolicyCome(String policyCome){
		this.policyCome = policyCome;
	}
	public String getPolicyContent(){
		return this.policyContent;
	}
	
	public void setPolicyContent(String policyContent){
		this.policyContent = policyContent;
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
		result = prime * result + ((policyId == null) ? 0 : policyId.hashCode());
		result = prime * result + ((policyType == null) ? 0 : policyType.hashCode());
		result = prime * result + ((policyCaption == null) ? 0 : policyCaption.hashCode());
		result = prime * result + ((policyCome == null) ? 0 : policyCome.hashCode());
		result = prime * result + ((policyContent == null) ? 0 : policyContent.hashCode());
		result = prime * result + ((policyStatus == null) ? 0 : policyStatus.hashCode());
		result = prime * result + ((policyIssueDate == null) ? 0 : policyIssueDate.hashCode());
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
		if (policyId == null) {
			if (other.policyId != null)
				return false;
		} else if (!policyId.equals(other.policyId))
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
		if (policyCome == null) {
			if (other.policyCome != null)
				return false;
		} else if (!policyCome.equals(other.policyCome))
			return false;
		if (policyContent == null) {
			if (other.policyContent != null)
				return false;
		} else if (!policyContent.equals(other.policyContent))
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
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}