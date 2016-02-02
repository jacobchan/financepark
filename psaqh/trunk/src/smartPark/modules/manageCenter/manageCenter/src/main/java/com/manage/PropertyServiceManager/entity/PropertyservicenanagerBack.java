/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 投诉回访记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicenanager_back")
public class PropertyservicenanagerBack implements Domain{
	
	private static final long serialVersionUID = -2704311533158045190L;
	

	@Column(name = "BACK_RECORD_")
	@Length(max=300)
	private String backRecord;//回访记录
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BACK_ID_")
	@Length(max=36)
	private String backId;//回访ID

	@Column(name = "BACK_CODE_")
	@Length(max=32)
	private String backCode;//回访单号
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COS_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos propertyservicemanagerCos;//投诉ID
	
	public String getBackRecord(){
		return this.backRecord;
	}
	
	public void setBackRecord(String backRecord){
		this.backRecord = backRecord;
	}
	public String getBackId(){
		return this.backId;
	}
	
	public void setBackId(String backId){
		this.backId = backId;
	}
	public String getBackCode(){
		return this.backCode;
	}
	
	public void setBackCode(String backCode){
		this.backCode = backCode;
	}
	
	public void setPropertyservicemanagerCos(com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos propertyservicemanagerCos){
		this.propertyservicemanagerCos = propertyservicemanagerCos;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos getPropertyservicemanagerCos(){
		return this.propertyservicemanagerCos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backRecord == null) ? 0 : backRecord.hashCode());
		result = prime * result + ((backId == null) ? 0 : backId.hashCode());
		result = prime * result + ((backCode == null) ? 0 : backCode.hashCode());
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
		final PropertyservicenanagerBack other = (PropertyservicenanagerBack) obj;
		if (backRecord == null) {
			if (other.backRecord != null)
				return false;
		} else if (!backRecord.equals(other.backRecord))
			return false;
		if (backId == null) {
			if (other.backId != null)
				return false;
		} else if (!backId.equals(other.backId))
			return false;
		if (backCode == null) {
			if (other.backCode != null)
				return false;
		} else if (!backCode.equals(other.backCode))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}