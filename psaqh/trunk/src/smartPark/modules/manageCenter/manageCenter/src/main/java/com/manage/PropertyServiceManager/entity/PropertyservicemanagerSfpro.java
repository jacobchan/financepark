/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 物业收费项目表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_sfpro")
public class PropertyservicemanagerSfpro implements Domain{
	
	private static final long serialVersionUID = -7107806787165801687L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SFPRO_ID_")
	@Length(max=36)
	private String sfproId;//收费项目序列

	@Column(name = "SFPRO_NAME_")
	@Length(max=36)
	private String sfproName;//收费项目名称

	@Column(name = "SFPRO_AMOUNT_")
	@Length(max=14)
	private String sfproAmount;//项目金额
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CHARGE_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge propertyservicemanagerCharge;//收费登记序列
	
	public String getSfproId(){
		return this.sfproId;
	}
	
	public void setSfproId(String sfproId){
		this.sfproId = sfproId;
	}
	public String getSfproName(){
		return this.sfproName;
	}
	
	public void setSfproName(String sfproName){
		this.sfproName = sfproName;
	}
	public String getSfproAmount(){
		return this.sfproAmount;
	}
	
	public void setSfproAmount(String sfproAmount){
		this.sfproAmount = sfproAmount;
	}
	
	public void setPropertyservicemanagerCharge(com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge propertyservicemanagerCharge){
		this.propertyservicemanagerCharge = propertyservicemanagerCharge;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge getPropertyservicemanagerCharge(){
		return this.propertyservicemanagerCharge;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sfproId == null) ? 0 : sfproId.hashCode());
		result = prime * result + ((sfproName == null) ? 0 : sfproName.hashCode());
		result = prime * result + ((sfproAmount == null) ? 0 : sfproAmount.hashCode());
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
		final PropertyservicemanagerSfpro other = (PropertyservicemanagerSfpro) obj;
		if (sfproId == null) {
			if (other.sfproId != null)
				return false;
		} else if (!sfproId.equals(other.sfproId))
			return false;
		if (sfproName == null) {
			if (other.sfproName != null)
				return false;
		} else if (!sfproName.equals(other.sfproName))
			return false;
		if (sfproAmount == null) {
			if (other.sfproAmount != null)
				return false;
		} else if (!sfproAmount.equals(other.sfproAmount))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}