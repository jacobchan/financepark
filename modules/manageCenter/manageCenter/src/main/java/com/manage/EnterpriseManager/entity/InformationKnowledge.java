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
	
	private static final long serialVersionUID = 8580116059989444631L;
	

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "KNOWLEDGE_STATUS_")
	@Length(max=2)
	private String knowledgeStatus;//发布状态

	@Column(name = "KNOWLEDGE_URL_")
	@Length(max=64)
	private String knowledgeUrl;//图片URL

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "KNOWLEDGE_ID_")
	@Length(max=32)
	private String knowledgeId;//ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "KNOWLEDGE_TITLE_")
	@Length(max=64)
	private String knowledgeTitle;//标题

	@Column(name = "KNOWLEDGE_CONTENT_")
	@Length(max=256)
	private String knowledgeContent;//描述

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "KNOWLEDGE_RE_")
	@Length(max=32)
	private String knowledgeRe;//企业信息ID

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
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
	
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getKnowledgeStatus(){
		return this.knowledgeStatus;
	}
	
	public void setKnowledgeStatus(String knowledgeStatus){
		this.knowledgeStatus = knowledgeStatus;
	}
	public String getKnowledgeUrl(){
		return this.knowledgeUrl;
	}
	
	public void setKnowledgeUrl(String knowledgeUrl){
		this.knowledgeUrl = knowledgeUrl;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getKnowledgeId(){
		return this.knowledgeId;
	}
	
	public void setKnowledgeId(String knowledgeId){
		this.knowledgeId = knowledgeId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getKnowledgeTitle(){
		return this.knowledgeTitle;
	}
	
	public void setKnowledgeTitle(String knowledgeTitle){
		this.knowledgeTitle = knowledgeTitle;
	}
	public String getKnowledgeContent(){
		return this.knowledgeContent;
	}
	
	public void setKnowledgeContent(String knowledgeContent){
		this.knowledgeContent = knowledgeContent;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getKnowledgeRe(){
		return this.knowledgeRe;
	}
	
	public void setKnowledgeRe(String knowledgeRe){
		this.knowledgeRe = knowledgeRe;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((knowledgeStatus == null) ? 0 : knowledgeStatus.hashCode());
		result = prime * result + ((knowledgeUrl == null) ? 0 : knowledgeUrl.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((knowledgeId == null) ? 0 : knowledgeId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((knowledgeTitle == null) ? 0 : knowledgeTitle.hashCode());
		result = prime * result + ((knowledgeContent == null) ? 0 : knowledgeContent.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((knowledgeRe == null) ? 0 : knowledgeRe.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
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
		final InformationKnowledge other = (InformationKnowledge) obj;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (knowledgeStatus == null) {
			if (other.knowledgeStatus != null)
				return false;
		} else if (!knowledgeStatus.equals(other.knowledgeStatus))
			return false;
		if (knowledgeUrl == null) {
			if (other.knowledgeUrl != null)
				return false;
		} else if (!knowledgeUrl.equals(other.knowledgeUrl))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (knowledgeId == null) {
			if (other.knowledgeId != null)
				return false;
		} else if (!knowledgeId.equals(other.knowledgeId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (knowledgeTitle == null) {
			if (other.knowledgeTitle != null)
				return false;
		} else if (!knowledgeTitle.equals(other.knowledgeTitle))
			return false;
		if (knowledgeContent == null) {
			if (other.knowledgeContent != null)
				return false;
		} else if (!knowledgeContent.equals(other.knowledgeContent))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (knowledgeRe == null) {
			if (other.knowledgeRe != null)
				return false;
		} else if (!knowledgeRe.equals(other.knowledgeRe))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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