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
	
	private static final long serialVersionUID = 5005479729928469213L;
	

	@Column(name = "MEDIA_TILURL_")
	@Length(max=128)
	private String mediaTilurl;//文章URL_

	@Column(name = "MEDIA_URL_")
	@Length(max=64)
	private String mediaUrl;//图片URL

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "MEDIA_TITLE_")
	@Length(max=64)
	private String mediaTitle;//标题
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MEDIA_ID_")
	@Length(max=36)
	private String mediaId;//ID

	@Column(name = "MEDIA_STATUS_")
	@Length(max=2)
	private String mediaStatus;//发布状态

	@Column(name = "MEDIA_RE_")
	@Length(max=32)
	private String mediaRe;//企业信息ID
	
	public String getMediaTilurl(){
		return this.mediaTilurl;
	}
	
	public void setMediaTilurl(String mediaTilurl){
		this.mediaTilurl = mediaTilurl;
	}
	public String getMediaUrl(){
		return this.mediaUrl;
	}
	
	public void setMediaUrl(String mediaUrl){
		this.mediaUrl = mediaUrl;
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
	public String getMediaRe(){
		return this.mediaRe;
	}
	
	public void setMediaRe(String mediaRe){
		this.mediaRe = mediaRe;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaTilurl == null) ? 0 : mediaTilurl.hashCode());
		result = prime * result + ((mediaUrl == null) ? 0 : mediaUrl.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((mediaTitle == null) ? 0 : mediaTitle.hashCode());
		result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
		result = prime * result + ((mediaStatus == null) ? 0 : mediaStatus.hashCode());
		result = prime * result + ((mediaRe == null) ? 0 : mediaRe.hashCode());
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
		if (mediaUrl == null) {
			if (other.mediaUrl != null)
				return false;
		} else if (!mediaUrl.equals(other.mediaUrl))
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
		if (mediaRe == null) {
			if (other.mediaRe != null)
				return false;
		} else if (!mediaRe.equals(other.mediaRe))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}