/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.MemberAdrManager.entity.MemberadrAddress;
import com.common.MemberManager.entity.MemberInformation;
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
	
	private static final long serialVersionUID = 6936020378028605564L;
	

	@Column(name = "APPLY_MAXUSER_")
	@Length(max=32)
	private String applyMaxuser;//限制人数

	@Column(name = "END_TIME_")
	@Length(max=32)
	private String endTime;//结束时间

	@Column(name = "COMMENT_TIME_")
	private String commentTime;//评论时间

	@Column(name = "APPLY_TITLE_")
	@Length(max=32)
	private String applyTitle;//活动标题

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "APPLY_STATUS_")
	@Length(max=2)
	private String applyStatus;//活动申请状态


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//申请会员用户

	@Column(name = "APPLY_ORDER_NUMBER_")
	@Length(max=32)
	private String applyOrderNumber;//场地订单编号

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "COMMENT_CONTENT_")
	private String commentContent;//内容


	@Column(name = "START_TIME_")
	@Length(max=32)
	private String startTime;//开始时间
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "APPLY_ID_")
	@Length(max=36)
	private String applyId;//活动申请ID

	@Column(name = "APPLY_NUMBER_")
	@Length(max=32)
	private String applyNumber;//活动申请编号

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "ACTIVITY_IMAGE_")
	@Length(max=100)
	private String activityImage;//活动图片
	
	@Column(name = "IS_RECOOMEND_")
	@Length(max=2)
	private String isRecoomend;//是否推荐
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TYPE_ID_")
	private com.manage.ActivityManager.entity.ApplayType applayType;//活动类型ID
	
	
	
	public com.manage.ActivityManager.entity.ApplayType getApplayType() {
		return applayType;
	}

	public void setApplayType(
			com.manage.ActivityManager.entity.ApplayType applayType) {
		this.applayType = applayType;
	}

	public String getIsRecoomend() {
		return isRecoomend;
	}

	public void setIsRecoomend(String isRecoomend) {
		this.isRecoomend = isRecoomend;
	}

	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	public String getApplyMaxuser(){
		return this.applyMaxuser;
	}
	
	public void setApplyMaxuser(String applyMaxuser){
		this.applyMaxuser = applyMaxuser;
	}
	public String getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	public String getCommentTime(){
		return this.commentTime;
	}
	
	public void setCommentTime(String commentTime){
		this.commentTime = commentTime;
	}
	public String getApplyTitle(){
		return this.applyTitle;
	}
	
	public void setApplyTitle(String applyTitle){
		this.applyTitle = applyTitle;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getApplyStatus(){
		return this.applyStatus;
	}
	
	public void setApplyStatus(String applyStatus){
		this.applyStatus = applyStatus;
	}
	


	public String getApplyOrderNumber(){
		return this.applyOrderNumber;
	}
	
	public void setApplyOrderNumber(String applyOrderNumber){
		this.applyOrderNumber = applyOrderNumber;
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
	public String getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	public String getApplyId(){
		return this.applyId;
	}
	
	public void setApplyId(String applyId){
		this.applyId = applyId;
	}
	public String getApplyNumber(){
		return this.applyNumber;
	}
	
	public void setApplyNumber(String applyNumber){
		this.applyNumber = applyNumber;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	
	public String getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(String activityImage) {
		this.activityImage = activityImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyMaxuser == null) ? 0 : applyMaxuser.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((applyTitle == null) ? 0 : applyTitle.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((applyStatus == null) ? 0 : applyStatus.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((applyOrderNumber == null) ? 0 : applyOrderNumber.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result + ((applyNumber == null) ? 0 : applyNumber.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
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
		if (applyMaxuser == null) {
			if (other.applyMaxuser != null)
				return false;
		} else if (!applyMaxuser.equals(other.applyMaxuser))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (applyTitle == null) {
			if (other.applyTitle != null)
				return false;
		} else if (!applyTitle.equals(other.applyTitle))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (applyStatus == null) {
			if (other.applyStatus != null)
				return false;
		} else if (!applyStatus.equals(other.applyStatus))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (applyOrderNumber == null) {
			if (other.applyOrderNumber != null)
				return false;
		} else if (!applyOrderNumber.equals(other.applyOrderNumber))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyNumber == null) {
			if (other.applyNumber != null)
				return false;
		} else if (!applyNumber.equals(other.applyNumber))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}