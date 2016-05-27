/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 公告信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_notice")
public class InformationNotice implements Domain{
	
	private static final long serialVersionUID = -4753466788726283536L;
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "NOTICE_CONTENT_")
	@Length(max=256)
	private String noticeContent;//内容

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "NOTICE_SUM_")
	private String noticeSum;//收藏次数

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "NOTICE_RE_")
	@Length(max=32)
	private String noticeRe;//企业信息ID

	@Column(name = "NOTICE_COUNT_")
	private String noticeCount;//浏览次数
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "NOTICE_ID_")
	@Length(max=32)
	private String noticeId;//ID

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "NOTICE_TITLE_")
	@Length(max=64)
	private String noticeTitle;//标题

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "NOTICE_TIME_")
	@Length(max=32)
	private String noticeTime;//发布时间
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
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getNoticeContent(){
		return this.noticeContent;
	}
	
	public void setNoticeContent(String noticeContent){
		this.noticeContent = noticeContent;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getNoticeSum(){
		return this.noticeSum;
	}
	
	public void setNoticeSum(String noticeSum){
		this.noticeSum = noticeSum;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getNoticeRe(){
		return this.noticeRe;
	}
	
	public void setNoticeRe(String noticeRe){
		this.noticeRe = noticeRe;
	}
	public String getNoticeCount(){
		return this.noticeCount;
	}
	
	public void setNoticeCount(String noticeCount){
		this.noticeCount = noticeCount;
	}
	public String getNoticeId(){
		return this.noticeId;
	}
	
	public void setNoticeId(String noticeId){
		this.noticeId = noticeId;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getNoticeTitle(){
		return this.noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle){
		this.noticeTitle = noticeTitle;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getNoticeTime(){
		return this.noticeTime;
	}
	
	public void setNoticeTime(String noticeTime){
		this.noticeTime = noticeTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((noticeContent == null) ? 0 : noticeContent.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((noticeSum == null) ? 0 : noticeSum.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((noticeRe == null) ? 0 : noticeRe.hashCode());
		result = prime * result + ((noticeCount == null) ? 0 : noticeCount.hashCode());
		result = prime * result + ((noticeId == null) ? 0 : noticeId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((noticeTitle == null) ? 0 : noticeTitle.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((noticeTime == null) ? 0 : noticeTime.hashCode());
		
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
		final InformationNotice other = (InformationNotice) obj;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (noticeContent == null) {
			if (other.noticeContent != null)
				return false;
		} else if (!noticeContent.equals(other.noticeContent))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (noticeSum == null) {
			if (other.noticeSum != null)
				return false;
		} else if (!noticeSum.equals(other.noticeSum))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (noticeRe == null) {
			if (other.noticeRe != null)
				return false;
		} else if (!noticeRe.equals(other.noticeRe))
			return false;
		if (noticeCount == null) {
			if (other.noticeCount != null)
				return false;
		} else if (!noticeCount.equals(other.noticeCount))
			return false;
		if (noticeId == null) {
			if (other.noticeId != null)
				return false;
		} else if (!noticeId.equals(other.noticeId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (noticeTitle == null) {
			if (other.noticeTitle != null)
				return false;
		} else if (!noticeTitle.equals(other.noticeTitle))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (noticeTime == null) {
			if (other.noticeTime != null)
				return false;
		} else if (!noticeTime.equals(other.noticeTime))
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