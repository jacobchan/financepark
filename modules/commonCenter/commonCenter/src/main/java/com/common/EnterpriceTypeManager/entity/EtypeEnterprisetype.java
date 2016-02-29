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
	
	private static final long serialVersionUID = -7442553670728591442L;
	

	@Column(name = "parent_id_")
	@Length(max=36)
	private String parentId;//父ID

	@Column(name = "en_type_name_")
	@Length(max=32)
	private String enTypeName;//企业类型名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "en_type_id_")
	@Length(max=36)
	private String enTypeId;//企业类型ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sp__en_type_id_")
	private com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype etypeEnterprisetype;//320_企业类型ID
	
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	public String getEnTypeName(){
		return this.enTypeName;
	}
	
	public void setEnTypeName(String enTypeName){
		this.enTypeName = enTypeName;
	}
	public String getEnTypeId(){
		return this.enTypeId;
	}
	
	public void setEnTypeId(String enTypeId){
		this.enTypeId = enTypeId;
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
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((enTypeName == null) ? 0 : enTypeName.hashCode());
		result = prime * result + ((enTypeId == null) ? 0 : enTypeId.hashCode());
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
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (enTypeName == null) {
			if (other.enTypeName != null)
				return false;
		} else if (!enTypeName.equals(other.enTypeName))
			return false;
		if (enTypeId == null) {
			if (other.enTypeId != null)
				return false;
		} else if (!enTypeId.equals(other.enTypeId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}