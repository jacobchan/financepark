/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

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
	
	private static final long serialVersionUID = 914550468307755210L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMENT_ID")
	@Length(max=36)
	private String commentId;//评论ID

	@Column(name = "COMMENT_TIME_")
	private String commentTime;//评论时间

	@Column(name = "COMMENT_CONTENT_")
	@Length(max=32)
	private String commentContent;//评论内容
	
	@Column(name = "COMMENT_MEMBER_")
	@Length(max=36)
	private String commentMember;//评论人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="APPLY_ID_")
	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	
	
	public String getCommentMember() {
		return commentMember;
	}

	public void setCommentMember(String commentMember) {
		this.commentMember = commentMember;
	}

	public String getCommentId(){
		return this.commentId;
	}
	
	public void setCommentId(String commentId){
		this.commentId = commentId;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
	}
	public String getCommentContent(){
		return this.commentContent;
	}
	
	public void setCommentContent(String commentContent){
		this.commentContent = commentContent;
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
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
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
		final ActivityComment other = (ActivityComment) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}