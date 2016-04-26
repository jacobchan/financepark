/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -活动评论
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_activity_comment")
public class ActivityComment implements Domain{
	
	private static final long serialVersionUID = 2072426421182689754L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "COMMENT_CONTENT_")
	@Length(max=1024)
	private String commentContent;//评论内容

	@Column(name = "COMMENT_TIME_")
	private String commentTime;//评论时间

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMMENT_MEMBER_")
	private MemberInformation commentMember;//评论人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMENT_ID")
	@Length(max=36)
	private String commentId;//评论ID
	
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="APPLY_ID_")
//	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DOCUMENT_ID_")
	private com.manage.ActivityManager.entity.ActivityDocument activityDocument;//活动申请ID
	
	@Column(name="COMMENT_LEVEL_")
	private int commentLevel;
	
	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCommentContent(){
		return this.commentContent;
	}
	
	public void setCommentContent(String commentContent){
		this.commentContent = commentContent;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
	}

	
	public MemberInformation getCommentMember() {
		return commentMember;
	}

	public void setCommentMember(MemberInformation commentMember) {
		this.commentMember = commentMember;
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
	public String getCommentId(){
		return this.commentId;
	}
	
	public void setCommentId(String commentId){
		this.commentId = commentId;
	}
	
	public void setActivityDocument(com.manage.ActivityManager.entity.ActivityDocument activityDocument){
		this.activityDocument = activityDocument;
	}
	
	public com.manage.ActivityManager.entity.ActivityDocument getActivityDocument(){
		return this.activityDocument;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((activityDocument == null) ? 0 : activityDocument.hashCode());
		result = prime * result
				+ ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result
				+ ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + commentLevel;
		result = prime * result
				+ ((commentMember == null) ? 0 : commentMember.hashCode());
		result = prime * result
				+ ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		ActivityComment other = (ActivityComment) obj;
		if (activityDocument == null) {
			if (other.activityDocument != null)
				return false;
		} else if (!activityDocument.equals(other.activityDocument))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentLevel != other.commentLevel)
			return false;
		if (commentMember == null) {
			if (other.commentMember != null)
				return false;
		} else if (!commentMember.equals(other.commentMember))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}