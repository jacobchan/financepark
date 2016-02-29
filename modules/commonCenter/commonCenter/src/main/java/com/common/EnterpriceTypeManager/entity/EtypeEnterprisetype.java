/**
 *
 */
package com.common.EnterpriceTypeManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 企业行业类型表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_etype_enterprisetype")
public class EtypeEnterprisetype implements Domain{
	
	private static final long serialVersionUID = -7971290360345350536L;
	

	@Column(name = "en_type_name_")
	@Length(max=32)
	private String enTypeName;//企业类型名称

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "parent_id_")
	@Length(max=36)
	private String parentId;//父ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "en_type_id_")
	@Length(max=36)
	private String enTypeId;//企业类型ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__en_type_id_")
	private com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype etypeEnterprisetype;//320_企业类型ID
	
	public String getEnTypeName(){
		return this.enTypeName;
	}
	
	public void setEnTypeName(String enTypeName){
		this.enTypeName = enTypeName;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	public String getEnTypeId(){
		return this.enTypeId;
	}
	
	public void setEnTypeId(String enTypeId){
		this.enTypeId = enTypeId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public void setEtypeEnterprisetype(com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype etypeEnterprisetype){
		this.etypeEnterprisetype = etypeEnterprisetype;
	}
	
	public com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype getEtypeEnterprisetype(){
		return this.etypeEnterprisetype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enTypeName == null) ? 0 : enTypeName.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((enTypeId == null) ? 0 : enTypeId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
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
		final EtypeEnterprisetype other = (EtypeEnterprisetype) obj;
		if (enTypeName == null) {
			if (other.enTypeName != null)
				return false;
		} else if (!enTypeName.equals(other.enTypeName))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (enTypeId == null) {
			if (other.enTypeId != null)
				return false;
		} else if (!enTypeId.equals(other.enTypeId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}