/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 搬家放行二维码记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_fxtdc")
public class PropertyservicemanagerFxtdc implements Domain{
	
	private static final long serialVersionUID = -8925685932897568932L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FXTDC_ID_")
	@Length(max=36)
	private String fxtdcId;//二维码记录序列

	@Column(name = "TWCRD_ADDREC_")
	@Length(max=50)
	private String twcrdAddrec;//二维码URL地址
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MOVEREC_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec propertyservicemanagerMoverec;//搬家申请记录ID
	
	public String getFxtdcId(){
		return this.fxtdcId;
	}
	
	public void setFxtdcId(String fxtdcId){
		this.fxtdcId = fxtdcId;
	}
	public String getTwcrdAddrec(){
		return this.twcrdAddrec;
	}
	
	public void setTwcrdAddrec(String twcrdAddrec){
		this.twcrdAddrec = twcrdAddrec;
	}
	
	public void setPropertyservicemanagerMoverec(com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec propertyservicemanagerMoverec){
		this.propertyservicemanagerMoverec = propertyservicemanagerMoverec;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec getPropertyservicemanagerMoverec(){
		return this.propertyservicemanagerMoverec;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fxtdcId == null) ? 0 : fxtdcId.hashCode());
		result = prime * result + ((twcrdAddrec == null) ? 0 : twcrdAddrec.hashCode());
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
		final PropertyservicemanagerFxtdc other = (PropertyservicemanagerFxtdc) obj;
		if (fxtdcId == null) {
			if (other.fxtdcId != null)
				return false;
		} else if (!fxtdcId.equals(other.fxtdcId))
			return false;
		if (twcrdAddrec == null) {
			if (other.twcrdAddrec != null)
				return false;
		} else if (!twcrdAddrec.equals(other.twcrdAddrec))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}