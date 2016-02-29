/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 费用清单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_ser")
public class PropertyservicemanagerSer implements Domain{
	
	private static final long serialVersionUID = -8805836969850136686L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SER_ID_")
	@Length(max=36)
	private String serId;//主键ID_

	@Column(name = "SER_NAME_")
	@Length(max=2)
	private String serName;//材料名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "SER_PAY_STATUS_")
	@Length(max=2)
	private String serPayStatus;//支付状态

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "SER_PRICE_")
	@Length(max=14)
	private String serPrice;//材料价格

	@Column(name = "SER_TYPE_")
	@Length(max=2)
	private String serType;//材料类别

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TS_ID_")
	private com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs propertyservicemanagerTs;//主键ID_2
	
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getSerId(){
		return this.serId;
	}
	
	public void setSerId(String serId){
		this.serId = serId;
	}
	public String getSerName(){
		return this.serName;
	}
	
	public void setSerName(String serName){
		this.serName = serName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getSerPayStatus(){
		return this.serPayStatus;
	}
	
	public void setSerPayStatus(String serPayStatus){
		this.serPayStatus = serPayStatus;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getSerPrice(){
		return this.serPrice;
	}
	
	public void setSerPrice(String serPrice){
		this.serPrice = serPrice;
	}
	public String getSerType(){
		return this.serType;
	}
	
	public void setSerType(String serType){
		this.serType = serType;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public void setPropertyservicemanagerTs(com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs propertyservicemanagerTs){
		this.propertyservicemanagerTs = propertyservicemanagerTs;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs getPropertyservicemanagerTs(){
		return this.propertyservicemanagerTs;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((serId == null) ? 0 : serId.hashCode());
		result = prime * result + ((serName == null) ? 0 : serName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((serPayStatus == null) ? 0 : serPayStatus.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((serPrice == null) ? 0 : serPrice.hashCode());
		result = prime * result + ((serType == null) ? 0 : serType.hashCode());
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
		final PropertyservicemanagerSer other = (PropertyservicemanagerSer) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (serId == null) {
			if (other.serId != null)
				return false;
		} else if (!serId.equals(other.serId))
			return false;
		if (serName == null) {
			if (other.serName != null)
				return false;
		} else if (!serName.equals(other.serName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (serPayStatus == null) {
			if (other.serPayStatus != null)
				return false;
		} else if (!serPayStatus.equals(other.serPayStatus))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (serPrice == null) {
			if (other.serPrice != null)
				return false;
		} else if (!serPrice.equals(other.serPrice))
			return false;
		if (serType == null) {
			if (other.serType != null)
				return false;
		} else if (!serType.equals(other.serType))
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