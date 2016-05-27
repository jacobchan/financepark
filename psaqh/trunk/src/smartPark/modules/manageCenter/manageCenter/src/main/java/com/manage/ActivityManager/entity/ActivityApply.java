/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

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
	
	@Column(name = "DEADLINE_")
	@Length(max=32)
	private String deadline;//报名截至时间

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
	
	@Column(name = "APPLAY_ADR_")
	@Length(max=256)
	private String activityAdr;//活动地址
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TYPE_ID_")
	private com.manage.ActivityManager.entity.ApplayType applayType;//活动类型ID
	
	@Column(name = "DOCUMENT_COUNT_")
	private int documentCount;  //活动文档数
		
	@Transient
	private String documentPath ;
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
	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	
	public int getDocumentCount() {
		return documentCount;
	}

	public void setDocumentCount(int documentCount) {
		this.documentCount = documentCount;
	}

	public String getActivityAdr() {
		return activityAdr;
	}

	public void setActivityAdr(String activityAdr) {
		this.activityAdr = activityAdr;
	}

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

	
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activityAdr == null) ? 0 : activityAdr.hashCode());
		result = prime * result
				+ ((activityImage == null) ? 0 : activityImage.hashCode());
		result = prime * result
				+ ((applayType == null) ? 0 : applayType.hashCode());
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result
				+ ((applyMaxuser == null) ? 0 : applyMaxuser.hashCode());
		result = prime * result
				+ ((applyNumber == null) ? 0 : applyNumber.hashCode());
		result = prime
				* result
				+ ((applyOrderNumber == null) ? 0 : applyOrderNumber.hashCode());
		result = prime * result
				+ ((applyStatus == null) ? 0 : applyStatus.hashCode());
		result = prime * result
				+ ((applyTitle == null) ? 0 : applyTitle.hashCode());
		result = prime * result
				+ ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result
				+ ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + documentCount;
		result = prime * result
				+ ((documentPath == null) ? 0 : documentPath.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((isRecoomend == null) ? 0 : isRecoomend.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
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
		ActivityApply other = (ActivityApply) obj;
		if (activityAdr == null) {
			if (other.activityAdr != null)
				return false;
		} else if (!activityAdr.equals(other.activityAdr))
			return false;
		if (activityImage == null) {
			if (other.activityImage != null)
				return false;
		} else if (!activityImage.equals(other.activityImage))
			return false;
		if (applayType == null) {
			if (other.applayType != null)
				return false;
		} else if (!applayType.equals(other.applayType))
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
		if (applyNumber == null) {
			if (other.applyNumber != null)
				return false;
		} else if (!applyNumber.equals(other.applyNumber))
			return false;
		if (applyOrderNumber == null) {
			if (other.applyOrderNumber != null)
				return false;
		} else if (!applyOrderNumber.equals(other.applyOrderNumber))
			return false;
		if (applyStatus == null) {
			if (other.applyStatus != null)
				return false;
		} else if (!applyStatus.equals(other.applyStatus))
			return false;
		if (applyTitle == null) {
			if (other.applyTitle != null)
				return false;
		} else if (!applyTitle.equals(other.applyTitle))
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
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
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (documentCount != other.documentCount)
			return false;
		if (documentPath == null) {
			if (other.documentPath != null)
				return false;
		} else if (!documentPath.equals(other.documentPath))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (isRecoomend == null) {
			if (other.isRecoomend != null)
				return false;
		} else if (!isRecoomend.equals(other.isRecoomend))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
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