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
	
	private static final long serialVersionUID = -5088530498436456120L;
	

	@Column(name = "ISSUE_TYPE_STATUS_")
	@Length(max=2)
	private String issueTypeStatus;//发布类型状态

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "ISSUE_PARENT_TYPE_")
	@Length(max=36)
	private String issueParentType;//发布类型上级

	@Column(name = "ISSUE_TYPE_CAPTION_")
	@Length(max=36)
	private String issueTypeCaption;//发布类型描述

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "ISSUE_TYPE_PATH_")
	@Length(max=256)
	private String issueTypePath;//层级关系

	@Column(name = "IS_LEAF_2")
	@Length(max=1)
	private String isLeaf;//是否子节点

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_TYPE_ID_")
	@Length(max=36)
	private String issueTypeId;//发布类型ID

	@Column(name = "ISSUE_TYPE_CODE_")
	@Length(max=12)
	private String issueTypeCode;//编码
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__ISSUE_TYPE_ID_")
	private com.common.NewsManager.entity.NmIssuetype nmIssuetype;//320_发布类型ID
	
	public String getIssueTypeStatus(){
		return this.issueTypeStatus;
	}
	
	public void setIssueTypeStatus(String issueTypeStatus){
		this.issueTypeStatus = issueTypeStatus;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getIssueParentType(){
		return this.issueParentType;
	}
	
	public void setIssueParentType(String issueParentType){
		this.issueParentType = issueParentType;
	}
	public String getIssueTypeCaption(){
		return this.issueTypeCaption;
	}
	
	public void setIssueTypeCaption(String issueTypeCaption){
		this.issueTypeCaption = issueTypeCaption;
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
	public String getIssueTypePath(){
		return this.issueTypePath;
	}
	
	public void setIssueTypePath(String issueTypePath){
		this.issueTypePath = issueTypePath;
	}
	public String getIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(String isLeaf){
		this.isLeaf = isLeaf;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getIssueTypeId(){
		return this.issueTypeId;
	}
	
	public void setIssueTypeId(String issueTypeId){
		this.issueTypeId = issueTypeId;
	}
	public String getIssueTypeCode(){
		return this.issueTypeCode;
	}
	
	public void setIssueTypeCode(String issueTypeCode){
		this.issueTypeCode = issueTypeCode;
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
		result = prime * result + ((issueTypeStatus == null) ? 0 : issueTypeStatus.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((issueParentType == null) ? 0 : issueParentType.hashCode());
		result = prime * result + ((issueTypeCaption == null) ? 0 : issueTypeCaption.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((issueTypePath == null) ? 0 : issueTypePath.hashCode());
		result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((issueTypeId == null) ? 0 : issueTypeId.hashCode());
		result = prime * result + ((issueTypeCode == null) ? 0 : issueTypeCode.hashCode());
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
		if (issueTypeStatus == null) {
			if (other.issueTypeStatus != null)
				return false;
		} else if (!issueTypeStatus.equals(other.issueTypeStatus))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (issueParentType == null) {
			if (other.issueParentType != null)
				return false;
		} else if (!issueParentType.equals(other.issueParentType))
			return false;
		if (issueTypeCaption == null) {
			if (other.issueTypeCaption != null)
				return false;
		} else if (!issueTypeCaption.equals(other.issueTypeCaption))
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
		if (issueTypePath == null) {
			if (other.issueTypePath != null)
				return false;
		} else if (!issueTypePath.equals(other.issueTypePath))
			return false;
		if (isLeaf == null) {
			if (other.isLeaf != null)
				return false;
		} else if (!isLeaf.equals(other.isLeaf))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (issueTypeId == null) {
			if (other.issueTypeId != null)
				return false;
		} else if (!issueTypeId.equals(other.issueTypeId))
			return false;
		if (issueTypeCode == null) {
			if (other.issueTypeCode != null)
				return false;
		} else if (!issueTypeCode.equals(other.issueTypeCode))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}