/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 发布类型
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_nm_issueType_")
public class NmIssuetype implements Domain{
	
	private static final long serialVersionUID = 2675933496658127185L;
	

	@Column(name = "ISSUE_PARENT_TYPE_")
	@Length(max=36)
	private String issueParentType;//发布类型上级

	@Column(name = "ISSUE_TYPE_STATUS_")
	@Length(max=2)
	private String issueTypeStatus;//发布类型状态

	@Column(name = "IS_LEAF_2")
	@Length(max=1)
	private String isLeaf;//是否子节点
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_TYPE_ID_")
	@Length(max=36)
	private String issueTypeId;//发布类型ID

	@Column(name = "ISSUE_TYPE_CAPTION_")
	@Length(max=36)
	private String issueTypeCaption;//发布类型描述
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__ISSUE_TYPE_ID_")
	private com.common.NewsManager.entity.NmIssuetype nmIssuetype;//320_发布类型ID
	
	public String getIssueParentType(){
		return this.issueParentType;
	}
	
	public void setIssueParentType(String issueParentType){
		this.issueParentType = issueParentType;
	}
	public String getIssueTypeStatus(){
		return this.issueTypeStatus;
	}
	
	public void setIssueTypeStatus(String issueTypeStatus){
		this.issueTypeStatus = issueTypeStatus;
	}
	public String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(String isLeaf){
		this.isLeaf = isLeaf;
	}
	public String getIssueTypeId(){
		return this.issueTypeId;
	}
	
	public void setIssueTypeId(String issueTypeId){
		this.issueTypeId = issueTypeId;
	}
	public String getIssueTypeCaption(){
		return this.issueTypeCaption;
	}
	
	public void setIssueTypeCaption(String issueTypeCaption){
		this.issueTypeCaption = issueTypeCaption;
	}
	
	public void setNmIssuetype(com.common.NewsManager.entity.NmIssuetype nmIssuetype){
		this.nmIssuetype = nmIssuetype;
	}
	
	public com.common.NewsManager.entity.NmIssuetype getNmIssuetype(){
		return this.nmIssuetype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueParentType == null) ? 0 : issueParentType.hashCode());
		result = prime * result + ((issueTypeStatus == null) ? 0 : issueTypeStatus.hashCode());
		result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());
		result = prime * result + ((issueTypeId == null) ? 0 : issueTypeId.hashCode());
		result = prime * result + ((issueTypeCaption == null) ? 0 : issueTypeCaption.hashCode());
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
		final NmIssuetype other = (NmIssuetype) obj;
		if (issueParentType == null) {
			if (other.issueParentType != null)
				return false;
		} else if (!issueParentType.equals(other.issueParentType))
			return false;
		if (issueTypeStatus == null) {
			if (other.issueTypeStatus != null)
				return false;
		} else if (!issueTypeStatus.equals(other.issueTypeStatus))
			return false;
		if (isLeaf == null) {
			if (other.isLeaf != null)
				return false;
		} else if (!isLeaf.equals(other.isLeaf))
			return false;
		if (issueTypeId == null) {
			if (other.issueTypeId != null)
				return false;
		} else if (!issueTypeId.equals(other.issueTypeId))
			return false;
		if (issueTypeCaption == null) {
			if (other.issueTypeCaption != null)
				return false;
		} else if (!issueTypeCaption.equals(other.issueTypeCaption))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}