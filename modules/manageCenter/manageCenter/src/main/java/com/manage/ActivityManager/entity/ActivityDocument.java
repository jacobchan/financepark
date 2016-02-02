/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -文档列表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_activity_document")
public class ActivityDocument implements Domain{
	
	private static final long serialVersionUID = -8083082063697230997L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "DOCUMENT_ID_")
	@Length(max=36)
	private String documentId;//文档ID

	@Column(name = "DOCUMENT_NAME_")
	@Length(max=32)
	private String documentName;//文档名

	@Column(name = "DOCUMENT_PATH_")
	@Length(max=256)
	private String documentPath;//文档路径
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="APPLY_ID_")
	private com.manage.ActivityManager.entity.ActivityApply activityApply;//活动申请ID
	
	public String getDocumentId(){
		return this.documentId;
	}
	
	public void setDocumentId(String documentId){
		this.documentId = documentId;
	}
	public String getDocumentName(){
		return this.documentName;
	}
	
	public void setDocumentName(String documentName){
		this.documentName = documentName;
	}
	public String getDocumentPath(){
		return this.documentPath;
	}
	
	public void setDocumentPath(String documentPath){
		this.documentPath = documentPath;
	}
	
	public void setActivityApply(com.manage.ActivityManager.entity.ActivityApply activityApply){
		this.activityApply = activityApply;
	}
	
	public com.manage.ActivityManager.entity.ActivityApply getActivityApply(){
		return this.activityApply;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result + ((documentPath == null) ? 0 : documentPath.hashCode());
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
		final ActivityDocument other = (ActivityDocument) obj;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (documentName == null) {
			if (other.documentName != null)
				return false;
		} else if (!documentName.equals(other.documentName))
			return false;
		if (documentPath == null) {
			if (other.documentPath != null)
				return false;
		} else if (!documentPath.equals(other.documentPath))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}