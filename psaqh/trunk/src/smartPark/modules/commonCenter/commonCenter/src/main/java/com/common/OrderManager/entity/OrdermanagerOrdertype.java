/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单类型表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_orderType_")
public class OrdermanagerOrdertype implements Domain{
	
	private static final long serialVersionUID = -2418760104691203148L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "ORDERTYPE_NAME_")
	@Length(max=128)
	private String ordertypeName;//类型名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Id
	@Column(name = "ORDERTYPE_ID_")
	@Length(max=10)
	private String ordertypeId;//订单类型编号

	@Column(name = "ORDERTYPE_PROJECT_NAME_")
	@Length(max=128)
	private String ordertypeProjectName;//订单项目名称

	@Column(name = "ORDERTYPE_PROJECT_TEMPLATE_ADDRESS_")
	@Length(max=256)
	private String ordertypeProjectTemplateAddress;//订单项目模板地址

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getOrdertypeName(){
		return this.ordertypeName;
	}
	
	public void setOrdertypeName(String ordertypeName){
		this.ordertypeName = ordertypeName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getOrdertypeId(){
		return this.ordertypeId;
	}
	
	public void setOrdertypeId(String ordertypeId){
		this.ordertypeId = ordertypeId;
	}
	public String getOrdertypeProjectName(){
		return this.ordertypeProjectName;
	}
	
	public void setOrdertypeProjectName(String ordertypeProjectName){
		this.ordertypeProjectName = ordertypeProjectName;
	}
	public String getOrdertypeProjectTemplateAddress(){
		return this.ordertypeProjectTemplateAddress;
	}
	
	public void setOrdertypeProjectTemplateAddress(String ordertypeProjectTemplateAddress){
		this.ordertypeProjectTemplateAddress = ordertypeProjectTemplateAddress;
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
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((ordertypeName == null) ? 0 : ordertypeName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((ordertypeId == null) ? 0 : ordertypeId.hashCode());
		result = prime * result + ((ordertypeProjectName == null) ? 0 : ordertypeProjectName.hashCode());
		result = prime * result + ((ordertypeProjectTemplateAddress == null) ? 0 : ordertypeProjectTemplateAddress.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
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
		final OrdermanagerOrdertype other = (OrdermanagerOrdertype) obj;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (ordertypeName == null) {
			if (other.ordertypeName != null)
				return false;
		} else if (!ordertypeName.equals(other.ordertypeName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (ordertypeId == null) {
			if (other.ordertypeId != null)
				return false;
		} else if (!ordertypeId.equals(other.ordertypeId))
			return false;
		if (ordertypeProjectName == null) {
			if (other.ordertypeProjectName != null)
				return false;
		} else if (!ordertypeProjectName.equals(other.ordertypeProjectName))
			return false;
		if (ordertypeProjectTemplateAddress == null) {
			if (other.ordertypeProjectTemplateAddress != null)
				return false;
		} else if (!ordertypeProjectTemplateAddress.equals(other.ordertypeProjectTemplateAddress))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}