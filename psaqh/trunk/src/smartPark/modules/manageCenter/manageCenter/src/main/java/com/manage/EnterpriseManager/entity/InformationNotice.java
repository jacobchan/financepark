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
	
	private static final long serialVersionUID = -6747986152099375686L;
	

	@Column(name = "NOTICE_CONTENT_")
	@Length(max=256)
	private String noticeContent;//内容
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "NOTICE_ID_")
	@Length(max=32)
	private String noticeId;//ID

	@Column(name = "NOTICE_RE_")
	@Length(max=32)
	private String noticeRe;//企业信息ID

	@Column(name = "NOTICE_COUNT_")
	private String noticeCount;//浏览次数

	@Column(name = "NOTICE_TIME_")
	@Length(max=32)
	private String noticeTime;//发布时间

	@Column(name = "NOTICE_SUM_")
	private String noticeSum;//收藏次数

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "NOTICE_TITLE_")
	@Length(max=64)
	private String noticeTitle;//标题
	
	public String getNoticeContent(){
		return this.noticeContent;
	}
	
	public void setNoticeContent(String noticeContent){
		this.noticeContent = noticeContent;
	}
	public String getNoticeId(){
		return this.noticeId;
	}
	
	public void setNoticeId(String noticeId){
		this.noticeId = noticeId;
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
	public String getNoticeTime(){
		return this.noticeTime;
	}
	
	public void setNoticeTime(String noticeTime){
		this.noticeTime = noticeTime;
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
	public String getNoticeTitle(){
		return this.noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle){
		this.noticeTitle = noticeTitle;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noticeContent == null) ? 0 : noticeContent.hashCode());
		result = prime * result + ((noticeId == null) ? 0 : noticeId.hashCode());
		result = prime * result + ((noticeRe == null) ? 0 : noticeRe.hashCode());
		result = prime * result + ((noticeCount == null) ? 0 : noticeCount.hashCode());
		result = prime * result + ((noticeTime == null) ? 0 : noticeTime.hashCode());
		result = prime * result + ((noticeSum == null) ? 0 : noticeSum.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((noticeTitle == null) ? 0 : noticeTitle.hashCode());
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
		if (noticeContent == null) {
			if (other.noticeContent != null)
				return false;
		} else if (!noticeContent.equals(other.noticeContent))
			return false;
		if (noticeId == null) {
			if (other.noticeId != null)
				return false;
		} else if (!noticeId.equals(other.noticeId))
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
		if (noticeTime == null) {
			if (other.noticeTime != null)
				return false;
		} else if (!noticeTime.equals(other.noticeTime))
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
		if (noticeTitle == null) {
			if (other.noticeTitle != null)
				return false;
		} else if (!noticeTitle.equals(other.noticeTitle))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}