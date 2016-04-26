/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -文档列表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_activity_document")
public class ActivityDocument implements Domain{
	
	private static final long serialVersionUID = -6768471027129728755L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "DOCUMENT_ID_")
	@Length(max=36)
	private String documentId;//文档ID

	@Column(name = "DOCUMENT_NAME_")
	@Length(max=32)
	private String documentName;//文档名

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "DOCUMENT_PATH_")
	@Length(max=256)
	private String documentPath;//文档路径

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	
	@Column(name = "COMMENT_LEVEL_")
	private String commentLevel;//星数
	
	public String getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(String commentLevel) {
		this.commentLevel = commentLevel;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="APPLY_ID_")
	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getDocumentId(){
		return this.documentId;
	}
	
	public void setDocumentId(String documentId){
		this.documentId = documentId;
	}
	public String getDocumentName(){
		return this.documentName;
	}
	
	public void setDocumentName(String documentName){
		this.documentName = documentName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getDocumentPath(){
		return this.documentPath;
	}
	
	public void setDocumentPath(String documentPath){
		this.documentPath = documentPath;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	
	public void setActivityApply(com.manage.ActivityManager.entity.ActivityApply activityApply){
		this.activityApply = activityApply;
	}
	
	public com.manage.ActivityManager.entity.ActivityApply getActivityApply(){
		return this.activityApply;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((documentPath == null) ? 0 : documentPath.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((commentLevel == null) ? 0 : commentLevel.hashCode());
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
		final ActivityDocument other = (ActivityDocument) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (documentName == null) {
			if (other.documentName != null)
				return false;
		} else if (!documentName.equals(other.documentName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (documentPath == null) {
			if (other.documentPath != null)
				return false;
		} else if (!documentPath.equals(other.documentPath))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (commentLevel == null) {
			if (other.commentLevel != null)
				return false;
		} else if (!commentLevel.equals(other.commentLevel))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}