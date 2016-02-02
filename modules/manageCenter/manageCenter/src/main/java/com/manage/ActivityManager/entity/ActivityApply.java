/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -活动申请内容列表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_activity_apply")
public class ActivityApply implements Domain{
	
	private static final long serialVersionUID = 4534422851143497323L;
	

	@Column(name = "APPLY_TITLE_")
	@Length(max=32)
	private String applyTitle;//活动标题

	@Column(name = "APPLY_STATUS_")
	@Length(max=2)
	private String applyStatus;//活动申请状态

	@Column(name = "COMMENT_CONTENT_")
	@Length(max=32)
	private String commentContent;//评论内容

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "APPLY_NUMBER_")
	@Length(max=32)
	private String applyNumber;//活动申请编号
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "APPLY_ID_")
	@Length(max=36)
	private String applyId;//活动申请ID

	@Column(name = "APPLY_MAXUSER_")
	@Length(max=32)
	private String applyMaxuser;//限制人数

	@Column(name = "APPLY_ORDER_NUMBER_")
	@Length(max=32)
	private String applyOrderNumber;//场地订单编号

	@Column(name = "COMMENT_TIME_")
	private String commentTime;//评论时间
	
	public String getApplyTitle(){
		return this.applyTitle;
	}
	
	public void setApplyTitle(String applyTitle){
		this.applyTitle = applyTitle;
	}
	public String getApplyStatus(){
		return this.applyStatus;
	}
	
	public void setApplyStatus(String applyStatus){
		this.applyStatus = applyStatus;
	}
	public String getCommentContent(){
		return this.commentContent;
	}
	
	public void setCommentContent(String commentContent){
		this.commentContent = commentContent;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getApplyNumber(){
		return this.applyNumber;
	}
	
	public void setApplyNumber(String applyNumber){
		this.applyNumber = applyNumber;
	}
	public String getApplyId(){
		return this.applyId;
	}
	
	public void setApplyId(String applyId){
		this.applyId = applyId;
	}
	public String getApplyMaxuser(){
		return this.applyMaxuser;
	}
	
	public void setApplyMaxuser(String applyMaxuser){
		this.applyMaxuser = applyMaxuser;
	}
	public String getApplyOrderNumber(){
		return this.applyOrderNumber;
	}
	
	public void setApplyOrderNumber(String applyOrderNumber){
		this.applyOrderNumber = applyOrderNumber;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyTitle == null) ? 0 : applyTitle.hashCode());
		result = prime * result + ((applyStatus == null) ? 0 : applyStatus.hashCode());
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((applyNumber == null) ? 0 : applyNumber.hashCode());
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result + ((applyMaxuser == null) ? 0 : applyMaxuser.hashCode());
		result = prime * result + ((applyOrderNumber == null) ? 0 : applyOrderNumber.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
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
		final ActivityApply other = (ActivityApply) obj;
		if (applyTitle == null) {
			if (other.applyTitle != null)
				return false;
		} else if (!applyTitle.equals(other.applyTitle))
			return false;
		if (applyStatus == null) {
			if (other.applyStatus != null)
				return false;
		} else if (!applyStatus.equals(other.applyStatus))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (applyNumber == null) {
			if (other.applyNumber != null)
				return false;
		} else if (!applyNumber.equals(other.applyNumber))
			return false;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyMaxuser == null) {
			if (other.applyMaxuser != null)
				return false;
		} else if (!applyMaxuser.equals(other.applyMaxuser))
			return false;
		if (applyOrderNumber == null) {
			if (other.applyOrderNumber != null)
				return false;
		} else if (!applyOrderNumber.equals(other.applyOrderNumber))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}