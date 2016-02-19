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

	public String toString(){
		return super.toString();
	}
}