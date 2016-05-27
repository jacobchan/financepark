/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.core.dataobj.tree.TreeAttribute;
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
	

	@Column(name = "IS_LEAF_2")
	@Length(max=1)
	private String leaf;//是否子节点

	@Column(name = "ISSUE_PARENT_TYPE_")
	private String parentIssueTypeId;//发布类型上级

	@Column(name = "ISSUE_TYPE_CAPTION_")
	@Length(max=36)
	private String issueTypeCaption;//发布类型描述

	@Column(name = "ISSUE_TYPE_STATUS_")
	@Length(max=2)
	private String issueTypeStatus;//发布类型状态
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_TYPE_ID_")
	@Length(max=36)
	private String issueTypeId;//发布类型ID
	
	@Column(name="ISSUE_TYPE_CODE_")
	private String issueTypeCode;
	
	@Column(name="ISSUE_TYPE_PATH_")
	private String issueTypePath;
	
	@Transient
	private String issueTypeParentCaption;
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
	public String getIssueTypeParentCaption() {
		return issueTypeParentCaption;
	}
	public void setIssueTypeParentCaption(String issueTypeParentCaption) {
		this.issueTypeParentCaption = issueTypeParentCaption;
	}
	
	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	@TreeAttribute("parentId")
	public String getParentIssueTypeId() {
		return parentIssueTypeId;
	}

	public void setParentIssueTypeId(String parentIssueTypeId) {
		this.parentIssueTypeId = parentIssueTypeId;
	}
	@TreeAttribute("text")
	public String getIssueTypeCaption() {
		return issueTypeCaption;
	}

	public void setIssueTypeCaption(String issueTypeCaption) {
		this.issueTypeCaption = issueTypeCaption;
	}

	public String getIssueTypeStatus() {
		return issueTypeStatus;
	}

	public void setIssueTypeStatus(String issueTypeStatus) {
		this.issueTypeStatus = issueTypeStatus;
	}
	@TreeAttribute("id")
	public String getIssueTypeId() {
		return issueTypeId;
	}

	public void setIssueTypeId(String issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	public String getIssueTypeCode() {
		return issueTypeCode;
	}

	public void setIssueTypeCode(String issueTypeCode) {
		this.issueTypeCode = issueTypeCode;
	}

	public String getIssueTypePath() {
		return issueTypePath;
	}

	public void setIssueTypePath(String issueTypePath) {
		this.issueTypePath = issueTypePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((issueTypeCaption == null) ? 0 : issueTypeCaption.hashCode());
		result = prime * result
				+ ((issueTypeCode == null) ? 0 : issueTypeCode.hashCode());
		result = prime * result
				+ ((issueTypeId == null) ? 0 : issueTypeId.hashCode());
		result = prime
				* result
				+ ((issueTypeParentCaption == null) ? 0
						: issueTypeParentCaption.hashCode());
		result = prime * result
				+ ((issueTypePath == null) ? 0 : issueTypePath.hashCode());
		result = prime * result
				+ ((issueTypeStatus == null) ? 0 : issueTypeStatus.hashCode());
		result = prime * result + ((leaf == null) ? 0 : leaf.hashCode());
		result = prime
				* result
				+ ((parentIssueTypeId == null) ? 0 : parentIssueTypeId
						.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result
				+ ((parkName == null) ? 0 : parkName.hashCode());
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
		NmIssuetype other = (NmIssuetype) obj;
		if (issueTypeCaption == null) {
			if (other.issueTypeCaption != null)
				return false;
		} else if (!issueTypeCaption.equals(other.issueTypeCaption))
			return false;
		if (issueTypeCode == null) {
			if (other.issueTypeCode != null)
				return false;
		} else if (!issueTypeCode.equals(other.issueTypeCode))
			return false;
		if (issueTypeId == null) {
			if (other.issueTypeId != null)
				return false;
		} else if (!issueTypeId.equals(other.issueTypeId))
			return false;
		if (issueTypeParentCaption == null) {
			if (other.issueTypeParentCaption != null)
				return false;
		} else if (!issueTypeParentCaption.equals(other.issueTypeParentCaption))
			return false;
		if (issueTypePath == null) {
			if (other.issueTypePath != null)
				return false;
		} else if (!issueTypePath.equals(other.issueTypePath))
			return false;
		if (issueTypeStatus == null) {
			if (other.issueTypeStatus != null)
				return false;
		} else if (!issueTypeStatus.equals(other.issueTypeStatus))
			return false;
		if (leaf == null) {
			if (other.leaf != null)
				return false;
		} else if (!leaf.equals(other.leaf))
			return false;
		if (parentIssueTypeId == null) {
			if (other.parentIssueTypeId != null)
				return false;
		} else if (!parentIssueTypeId.equals(other.parentIssueTypeId))
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