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
	
	private static final long serialVersionUID = 6846502395644472633L;
	
	@Id
	@Column(name = "ORDERTYPE_ID_")
	@Length(max=10)
	private String ordertypeId;//订单类型编号

	@Column(name = "ORDERTYPE_PROJECT_NAME_")
	@Length(max=128)
	private String ordertypeProjectName;//订单项目名称

	@Column(name = "ORDERTYPE_NAME_")
	@Length(max=128)
	private String ordertypeName;//类型名称

	@Column(name = "ORDERTYPE_PROJECT_TEMPLATE_ADDRESS_")
	@Length(max=256)
	private String ordertypeProjectTemplateAddress;//订单项目模板地址
	
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
	public String getOrdertypeName(){
		return this.ordertypeName;
	}
	
	public void setOrdertypeName(String ordertypeName){
		this.ordertypeName = ordertypeName;
	}
	public String getOrdertypeProjectTemplateAddress(){
		return this.ordertypeProjectTemplateAddress;
	}
	
	public void setOrdertypeProjectTemplateAddress(String ordertypeProjectTemplateAddress){
		this.ordertypeProjectTemplateAddress = ordertypeProjectTemplateAddress;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordertypeId == null) ? 0 : ordertypeId.hashCode());
		result = prime * result + ((ordertypeProjectName == null) ? 0 : ordertypeProjectName.hashCode());
		result = prime * result + ((ordertypeName == null) ? 0 : ordertypeName.hashCode());
		result = prime * result + ((ordertypeProjectTemplateAddress == null) ? 0 : ordertypeProjectTemplateAddress.hashCode());
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
		if (ordertypeName == null) {
			if (other.ordertypeName != null)
				return false;
		} else if (!ordertypeName.equals(other.ordertypeName))
			return false;
		if (ordertypeProjectTemplateAddress == null) {
			if (other.ordertypeProjectTemplateAddress != null)
				return false;
		} else if (!ordertypeProjectTemplateAddress.equals(other.ordertypeProjectTemplateAddress))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}