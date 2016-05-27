/**
 *
 */
package com.common.NewsManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 发布模板
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_nm_issueTempalate_")
public class NmIssuetempalate implements Domain{
	
	private static final long serialVersionUID = -4527808613163354480L;
	

	@Column(name = "ISSUE_SENDSTATUS_")
	@Length(max=2)
	private String issueSendstatus;//发送状态

	@Column(name = "ISSUE_TEMPALATE_TO_")
	@Length(max=36)
	private String issueTempalateTo;//发送到

	@Column(name = "ISSUE_TEMPALATE_CONTENT_")
	@Length(max=256)
	private String issueTempalateContent;//发布模板内容

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "ISSUE_TEMPALATE_CAPTION_")
	@Length(max=36)
	private String issueTempalateCaption;//发布模板名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "ISSUE_TEMPALATE_SRC_")
	@Length(max=256)
	private String issueTempalateSrc;//模板路径
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_TEMPALATE_ID_")
	@Length(max=36)
	private String issueTempalateId;//发布模板ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ISSUE_TYPE_ID_")
	private com.common.NewsManager.entity.NmIssuetype nmIssuetype;//发布类型ID
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

	public String getIssueSendstatus(){
		return this.issueSendstatus;
	}
	
	public void setIssueSendstatus(String issueSendstatus){
		this.issueSendstatus = issueSendstatus;
	}
	public String getIssueTempalateTo(){
		return this.issueTempalateTo;
	}
	
	public void setIssueTempalateTo(String issueTempalateTo){
		this.issueTempalateTo = issueTempalateTo;
	}
	public String getIssueTempalateContent(){
		return this.issueTempalateContent;
	}
	
	public void setIssueTempalateContent(String issueTempalateContent){
		this.issueTempalateContent = issueTempalateContent;
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getIssueTempalateCaption(){
		return this.issueTempalateCaption;
	}
	
	public void setIssueTempalateCaption(String issueTempalateCaption){
		this.issueTempalateCaption = issueTempalateCaption;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getIssueTempalateSrc(){
		return this.issueTempalateSrc;
	}
	
	public void setIssueTempalateSrc(String issueTempalateSrc){
		this.issueTempalateSrc = issueTempalateSrc;
	}
	public String getIssueTempalateId(){
		return this.issueTempalateId;
	}
	
	public void setIssueTempalateId(String issueTempalateId){
		this.issueTempalateId = issueTempalateId;
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
		result = prime * result + ((issueSendstatus == null) ? 0 : issueSendstatus.hashCode());
		result = prime * result + ((issueTempalateTo == null) ? 0 : issueTempalateTo.hashCode());
		result = prime * result + ((issueTempalateContent == null) ? 0 : issueTempalateContent.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((issueTempalateCaption == null) ? 0 : issueTempalateCaption.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((issueTempalateSrc == null) ? 0 : issueTempalateSrc.hashCode());
		result = prime * result + ((issueTempalateId == null) ? 0 : issueTempalateId.hashCode());
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
		final NmIssuetempalate other = (NmIssuetempalate) obj;
		if (issueSendstatus == null) {
			if (other.issueSendstatus != null)
				return false;
		} else if (!issueSendstatus.equals(other.issueSendstatus))
			return false;
		if (issueTempalateTo == null) {
			if (other.issueTempalateTo != null)
				return false;
		} else if (!issueTempalateTo.equals(other.issueTempalateTo))
			return false;
		if (issueTempalateContent == null) {
			if (other.issueTempalateContent != null)
				return false;
		} else if (!issueTempalateContent.equals(other.issueTempalateContent))
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
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (issueTempalateCaption == null) {
			if (other.issueTempalateCaption != null)
				return false;
		} else if (!issueTempalateCaption.equals(other.issueTempalateCaption))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (issueTempalateSrc == null) {
			if (other.issueTempalateSrc != null)
				return false;
		} else if (!issueTempalateSrc.equals(other.issueTempalateSrc))
			return false;
		if (issueTempalateId == null) {
			if (other.issueTempalateId != null)
				return false;
		} else if (!issueTempalateId.equals(other.issueTempalateId))
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