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
	
	private static final long serialVersionUID = -6838517779156594186L;
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
	
	@Column(name = "RMEMBER_ID_")
	@Length(max=36)
	private String memberId;//ID

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "COMMENT_REPLY_CONTENT")
	@Length(max=256)
	private String commentReplyContent;//回复内容

	@Column(name = "COMMENT_ENTERPRISE")
	@Length(max=64)
	private String commentEnterprise;//企业信息

	@Column(name = "COMMENT_TIME")
	@Length(max=32)
	private String commentTime;//评论时间

	@Column(name = "COMMENT__REPLY_TIME")
	@Length(max=32)
	private String commentReplyTime;//回复时间

	@Column(name = "COMMENT_CONTENT")
	@Length(max=1024)
	private String commentContent;//评论内容

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMENT_ID_")
	@Length(max=36)
	private String commentId;//ID_
	
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCommentReplyContent(){
		return this.commentReplyContent;
	}
	
	public void setCommentReplyContent(String commentReplyContent){
		this.commentReplyContent = commentReplyContent;
	}
	public String getCommentEnterprise(){
		return this.commentEnterprise;
	}
	
	public void setCommentEnterprise(String commentEnterprise){
		this.commentEnterprise = commentEnterprise;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
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
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((commentReplyContent == null) ? 0 : commentReplyContent.hashCode());
		result = prime * result + ((commentEnterprise == null) ? 0 : commentEnterprise.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((commentReplyTime == null) ? 0 : commentReplyTime.hashCode());
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
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
		if (commentReplyContent == null) {
			if (other.commentReplyContent != null)
				return false;
		} else if (!commentReplyContent.equals(other.commentReplyContent))
			return false;
		if (commentEnterprise == null) {
			if (other.commentEnterprise != null)
				return false;
		} else if (!commentEnterprise.equals(other.commentEnterprise))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
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
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
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