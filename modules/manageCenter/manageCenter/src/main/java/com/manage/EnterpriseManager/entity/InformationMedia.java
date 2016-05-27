/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 媒体报道信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_media")
public class InformationMedia implements Domain{
	
	private static final long serialVersionUID = -1845492527138289629L;
	

	@Column(name = "MEDIA_TILURL_")
	@Length(max=128)
	private String mediaTilurl;//文章URL_

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "MEDIA_TITLE_")
	@Length(max=64)
	private String mediaTitle;//标题

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MEDIA_RE_")
	@Length(max=32)
	private String mediaRe;//企业信息ID

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "MEDIA_URL_")
	@Length(max=64)
	private String mediaUrl;//图片URL
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MEDIA_ID_")
	@Length(max=36)
	private String mediaId;//ID

	@Column(name = "MEDIA_STATUS_")
	@Length(max=2)
	private String mediaStatus;//发布状态
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
	public String getMediaTilurl(){
		return this.mediaTilurl;
	}
	
	public void setMediaTilurl(String mediaTilurl){
		this.mediaTilurl = mediaTilurl;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getMediaTitle(){
		return this.mediaTitle;
	}
	
	public void setMediaTitle(String mediaTitle){
		this.mediaTitle = mediaTitle;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMediaRe(){
		return this.mediaRe;
	}
	
	public void setMediaRe(String mediaRe){
		this.mediaRe = mediaRe;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getMediaUrl(){
		return this.mediaUrl;
	}
	
	public void setMediaUrl(String mediaUrl){
		this.mediaUrl = mediaUrl;
	}
	public String getMediaId(){
		return this.mediaId;
	}
	
	public void setMediaId(String mediaId){
		this.mediaId = mediaId;
	}
	public String getMediaStatus(){
		return this.mediaStatus;
	}
	
	public void setMediaStatus(String mediaStatus){
		this.mediaStatus = mediaStatus;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaTilurl == null) ? 0 : mediaTilurl.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((mediaTitle == null) ? 0 : mediaTitle.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((mediaRe == null) ? 0 : mediaRe.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((mediaUrl == null) ? 0 : mediaUrl.hashCode());
		result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
		result = prime * result + ((mediaStatus == null) ? 0 : mediaStatus.hashCode());
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
		final InformationMedia other = (InformationMedia) obj;
		if (mediaTilurl == null) {
			if (other.mediaTilurl != null)
				return false;
		} else if (!mediaTilurl.equals(other.mediaTilurl))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (mediaTitle == null) {
			if (other.mediaTitle != null)
				return false;
		} else if (!mediaTitle.equals(other.mediaTitle))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (mediaRe == null) {
			if (other.mediaRe != null)
				return false;
		} else if (!mediaRe.equals(other.mediaRe))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (mediaUrl == null) {
			if (other.mediaUrl != null)
				return false;
		} else if (!mediaUrl.equals(other.mediaUrl))
			return false;
		if (mediaId == null) {
			if (other.mediaId != null)
				return false;
		} else if (!mediaId.equals(other.mediaId))
			return false;
		if (mediaStatus == null) {
			if (other.mediaStatus != null)
				return false;
		} else if (!mediaStatus.equals(other.mediaStatus))
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