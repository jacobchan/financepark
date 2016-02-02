/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 知识产权信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_knowledge")
public class InformationKnowledge implements Domain{
	
	private static final long serialVersionUID = 8627120313363183051L;
	

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "KNOWLEDGE_URL_")
	@Length(max=64)
	private String knowledgeUrl;//图片URL

	@Column(name = "KNOWLEDGE_RE_")
	@Length(max=32)
	private String knowledgeRe;//企业信息ID

	@Column(name = "KNOWLEDGE_STATUS_")
	@Length(max=2)
	private String knowledgeStatus;//发布状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "KNOWLEDGE_ID_")
	@Length(max=32)
	private String knowledgeId;//ID

	@Column(name = "KNOWLEDGE_CONTENT_")
	@Length(max=256)
	private String knowledgeContent;//描述

	@Column(name = "KNOWLEDGE_TITLE_")
	@Length(max=64)
	private String knowledgeTitle;//标题
	
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getKnowledgeUrl(){
		return this.knowledgeUrl;
	}
	
	public void setKnowledgeUrl(String knowledgeUrl){
		this.knowledgeUrl = knowledgeUrl;
	}
	public String getKnowledgeRe(){
		return this.knowledgeRe;
	}
	
	public void setKnowledgeRe(String knowledgeRe){
		this.knowledgeRe = knowledgeRe;
	}
	public String getKnowledgeStatus(){
		return this.knowledgeStatus;
	}
	
	public void setKnowledgeStatus(String knowledgeStatus){
		this.knowledgeStatus = knowledgeStatus;
	}
	public String getKnowledgeId(){
		return this.knowledgeId;
	}
	
	public void setKnowledgeId(String knowledgeId){
		this.knowledgeId = knowledgeId;
	}
	public String getKnowledgeContent(){
		return this.knowledgeContent;
	}
	
	public void setKnowledgeContent(String knowledgeContent){
		this.knowledgeContent = knowledgeContent;
	}
	public String getKnowledgeTitle(){
		return this.knowledgeTitle;
	}
	
	public void setKnowledgeTitle(String knowledgeTitle){
		this.knowledgeTitle = knowledgeTitle;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((knowledgeUrl == null) ? 0 : knowledgeUrl.hashCode());
		result = prime * result + ((knowledgeRe == null) ? 0 : knowledgeRe.hashCode());
		result = prime * result + ((knowledgeStatus == null) ? 0 : knowledgeStatus.hashCode());
		result = prime * result + ((knowledgeId == null) ? 0 : knowledgeId.hashCode());
		result = prime * result + ((knowledgeContent == null) ? 0 : knowledgeContent.hashCode());
		result = prime * result + ((knowledgeTitle == null) ? 0 : knowledgeTitle.hashCode());
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
		final InformationKnowledge other = (InformationKnowledge) obj;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (knowledgeUrl == null) {
			if (other.knowledgeUrl != null)
				return false;
		} else if (!knowledgeUrl.equals(other.knowledgeUrl))
			return false;
		if (knowledgeRe == null) {
			if (other.knowledgeRe != null)
				return false;
		} else if (!knowledgeRe.equals(other.knowledgeRe))
			return false;
		if (knowledgeStatus == null) {
			if (other.knowledgeStatus != null)
				return false;
		} else if (!knowledgeStatus.equals(other.knowledgeStatus))
			return false;
		if (knowledgeId == null) {
			if (other.knowledgeId != null)
				return false;
		} else if (!knowledgeId.equals(other.knowledgeId))
			return false;
		if (knowledgeContent == null) {
			if (other.knowledgeContent != null)
				return false;
		} else if (!knowledgeContent.equals(other.knowledgeContent))
			return false;
		if (knowledgeTitle == null) {
			if (other.knowledgeTitle != null)
				return false;
		} else if (!knowledgeTitle.equals(other.knowledgeTitle))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}