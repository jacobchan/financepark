/**
 *
 */
package com.manage.ActivityManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 活动类型
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_applay_type")
public class ApplayType implements Domain{
	
	private static final long serialVersionUID = -5207689854204033892L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TYPE_ID_")
	@Length(max=36)
	private String typeId;//活动类型ID

	@Column(name = "TYPE_CODE_")
	@Length(max=10)
	private String typeCode;//类型编码

	@Column(name = "IS_RECOMENT_")
	@Length(max=2)
	private String isRecoment;//是否推荐

	@Column(name = "TYPE_NAME_")
	@Length(max=32)
	private String typeName;//类型名称

	@Column(name = "TYPE__ICON_")
	@Length(max=128)
	private String typeIcon;//类型图标
	
	public String getTypeId(){
		return this.typeId;
	}
	
	public void setTypeId(String typeId){
		this.typeId = typeId;
	}
	public String getTypeCode(){
		return this.typeCode;
	}
	
	public void setTypeCode(String typeCode){
		this.typeCode = typeCode;
	}
	public String getIsRecoment(){
		return this.isRecoment;
	}
	
	public void setIsRecoment(String isRecoment){
		this.isRecoment = isRecoment;
	}
	public String getTypeName(){
		return this.typeName;
	}
	
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	public String getTypeIcon(){
		return this.typeIcon;
	}
	
	public void setTypeIcon(String typeIcon){
		this.typeIcon = typeIcon;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		result = prime * result + ((isRecoment == null) ? 0 : isRecoment.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		result = prime * result + ((typeIcon == null) ? 0 : typeIcon.hashCode());
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
		final ApplayType other = (ApplayType) obj;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		if (isRecoment == null) {
			if (other.isRecoment != null)
				return false;
		} else if (!isRecoment.equals(other.isRecoment))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (typeIcon == null) {
			if (other.typeIcon != null)
				return false;
		} else if (!typeIcon.equals(other.typeIcon))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}