/**
 *
 */
package com.manage.EnterpriseMessageManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 评论
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_lettermanager_comment")
public class LettermanagerComment implements Domain{
	
	private static final long serialVersionUID = -1524431320357080658L;
	

	@Column(name = "COMMENT_ENTERPRISE")
	@Length(max=64)
	private String commentEnterprise;//企业信息

	@Column(name = "COMMENT__REPLY_TIME")
	@Length(max=32)
	private String commentReplyTime;//回复时间

	@Column(name = "COMMENT_CONTENT")
	@Length(max=1024)
	private String commentContent;//评论内容

	@Column(name = "COMMENT_REPLY_CONTENT")
	@Length(max=256)
	private String commentReplyContent;//回复内容

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@Column(name = "COMMENT_TIME")
	@Length(max=32)
	private String commentTime;//评论时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMENT_ID_")
	@Length(max=36)
	private String commentId;//ID_
	
	public String getCommentEnterprise(){
		return this.commentEnterprise;
	}
	
	public void setCommentEnterprise(String commentEnterprise){
		this.commentEnterprise = commentEnterprise;
	}
	public String getCommentReplyTime(){
		return this.commentReplyTime;
	}
	
	public void setCommentReplyTime(String commentReplyTime){
		this.commentReplyTime = commentReplyTime;
	}
	public String getCommentContent(){
		return this.commentContent;
	}
	
	public void setCommentContent(String commentContent){
		this.commentContent = commentContent;
	}
	public String getCommentReplyContent(){
		return this.commentReplyContent;
	}
	
	public void setCommentReplyContent(String commentReplyContent){
		this.commentReplyContent = commentReplyContent;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
	}
	public String getCommentId(){
		return this.commentId;
	}
	
	public void setCommentId(String commentId){
		this.commentId = commentId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentEnterprise == null) ? 0 : commentEnterprise.hashCode());
		result = prime * result + ((commentReplyTime == null) ? 0 : commentReplyTime.hashCode());
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentReplyContent == null) ? 0 : commentReplyContent.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
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
		final LettermanagerComment other = (LettermanagerComment) obj;
		if (commentEnterprise == null) {
			if (other.commentEnterprise != null)
				return false;
		} else if (!commentEnterprise.equals(other.commentEnterprise))
			return false;
		if (commentReplyTime == null) {
			if (other.commentReplyTime != null)
				return false;
		} else if (!commentReplyTime.equals(other.commentReplyTime))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentReplyContent == null) {
			if (other.commentReplyContent != null)
				return false;
		} else if (!commentReplyContent.equals(other.commentReplyContent))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}