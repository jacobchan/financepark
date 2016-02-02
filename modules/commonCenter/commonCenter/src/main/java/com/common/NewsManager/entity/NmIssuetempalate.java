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
	
	private static final long serialVersionUID = -8568820453469037343L;
	

	@Column(name = "ISSUE_SENDSTATUS_")
	@Length(max=2)
	private String issueSendstatus;//发送状态

	@Column(name = "ISSUE_TEMPALATE_CAPTION_")
	@Length(max=36)
	private String issueTempalateCaption;//发布模板名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ISSUE_TEMPALATE_ID_")
	@Length(max=36)
	private String issueTempalateId;//发布模板ID

	@Column(name = "ISSUE_TEMPALATE_TO_")
	@Length(max=36)
	private String issueTempalateTo;//发送到

	@Column(name = "ISSUE_TEMPALATE_SRC_")
	@Length(max=256)
	private String issueTempalateSrc;//模板路径

	@Column(name = "ISSUE_TEMPALATE_CONTENT_")
	@Length(max=256)
	private String issueTempalateContent;//发布模板内容
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ISSUE_TYPE_ID_")
	private com.common.NewsManager.entity.NmIssuetype nmIssuetype;//发布类型ID
	
	public String getIssueSendstatus(){
		return this.issueSendstatus;
	}
	
	public void setIssueSendstatus(String issueSendstatus){
		this.issueSendstatus = issueSendstatus;
	}
	public String getIssueTempalateCaption(){
		return this.issueTempalateCaption;
	}
	
	public void setIssueTempalateCaption(String issueTempalateCaption){
		this.issueTempalateCaption = issueTempalateCaption;
	}
	public String getIssueTempalateId(){
		return this.issueTempalateId;
	}
	
	public void setIssueTempalateId(String issueTempalateId){
		this.issueTempalateId = issueTempalateId;
	}
	public String getIssueTempalateTo(){
		return this.issueTempalateTo;
	}
	
	public void setIssueTempalateTo(String issueTempalateTo){
		this.issueTempalateTo = issueTempalateTo;
	}
	public String getIssueTempalateSrc(){
		return this.issueTempalateSrc;
	}
	
	public void setIssueTempalateSrc(String issueTempalateSrc){
		this.issueTempalateSrc = issueTempalateSrc;
	}
	public String getIssueTempalateContent(){
		return this.issueTempalateContent;
	}
	
	public void setIssueTempalateContent(String issueTempalateContent){
		this.issueTempalateContent = issueTempalateContent;
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
		result = prime * result + ((issueTempalateCaption == null) ? 0 : issueTempalateCaption.hashCode());
		result = prime * result + ((issueTempalateId == null) ? 0 : issueTempalateId.hashCode());
		result = prime * result + ((issueTempalateTo == null) ? 0 : issueTempalateTo.hashCode());
		result = prime * result + ((issueTempalateSrc == null) ? 0 : issueTempalateSrc.hashCode());
		result = prime * result + ((issueTempalateContent == null) ? 0 : issueTempalateContent.hashCode());
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
		if (issueTempalateCaption == null) {
			if (other.issueTempalateCaption != null)
				return false;
		} else if (!issueTempalateCaption.equals(other.issueTempalateCaption))
			return false;
		if (issueTempalateId == null) {
			if (other.issueTempalateId != null)
				return false;
		} else if (!issueTempalateId.equals(other.issueTempalateId))
			return false;
		if (issueTempalateTo == null) {
			if (other.issueTempalateTo != null)
				return false;
		} else if (!issueTempalateTo.equals(other.issueTempalateTo))
			return false;
		if (issueTempalateSrc == null) {
			if (other.issueTempalateSrc != null)
				return false;
		} else if (!issueTempalateSrc.equals(other.issueTempalateSrc))
			return false;
		if (issueTempalateContent == null) {
			if (other.issueTempalateContent != null)
				return false;
		} else if (!issueTempalateContent.equals(other.issueTempalateContent))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}