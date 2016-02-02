/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 330214二维码记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_twcrd")
public class PropertyservicemanagerTwcrd implements Domain{
	
	private static final long serialVersionUID = -2667746533182298089L;
	

	@Column(name = "TWCRD_ADDREC_")
	@Length(max=50)
	private String twcrdAddrec;//二维码URL地址
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "TWCRD_ID_")
	@Length(max=36)
	private String twcrdId;//二维码记录序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FKCODE_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode propertyservicemanagerFkcode;//访客申请ID
	
	public String getTwcrdAddrec(){
		return this.twcrdAddrec;
	}
	
	public void setTwcrdAddrec(String twcrdAddrec){
		this.twcrdAddrec = twcrdAddrec;
	}
	public String getTwcrdId(){
		return this.twcrdId;
	}
	
	public void setTwcrdId(String twcrdId){
		this.twcrdId = twcrdId;
	}
	
	public void setPropertyservicemanagerFkcode(com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode propertyservicemanagerFkcode){
		this.propertyservicemanagerFkcode = propertyservicemanagerFkcode;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode getPropertyservicemanagerFkcode(){
		return this.propertyservicemanagerFkcode;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((twcrdAddrec == null) ? 0 : twcrdAddrec.hashCode());
		result = prime * result + ((twcrdId == null) ? 0 : twcrdId.hashCode());
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
		final PropertyservicemanagerTwcrd other = (PropertyservicemanagerTwcrd) obj;
		if (twcrdAddrec == null) {
			if (other.twcrdAddrec != null)
				return false;
		} else if (!twcrdAddrec.equals(other.twcrdAddrec))
			return false;
		if (twcrdId == null) {
			if (other.twcrdId != null)
				return false;
		} else if (!twcrdId.equals(other.twcrdId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}