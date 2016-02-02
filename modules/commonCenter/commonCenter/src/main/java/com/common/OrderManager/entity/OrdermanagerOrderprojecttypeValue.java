/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单项目值表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_orderProjectType_value_")
public class OrdermanagerOrderprojecttypeValue implements Domain{
	
	private static final long serialVersionUID = 32771399428826099L;
	

	@Column(name = "ORDERPROJECTTYPE_VALUE_FIELD_VALUE_")
	private String orderprojecttypeValueFieldValue;//字段值
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDERPROJECTTYPE_VALUE_ID_")
	@Length(max=36)
	private String orderprojecttypeValueId;//订单项目序列

	@Column(name = "ORDERPROJECTTYPE_VALUE_FIELD_NAME_")
	@Length(max=128)
	private String orderprojecttypeValueFieldName;//字段名称

	@Column(name = "ORDERPROJECTTYPE_VALUE_DISPLAY_NAME_")
	@Length(max=128)
	private String orderprojecttypeValueDisplayName;//显示名称
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDERPROJECTTYPE_ID_")
	private com.common.OrderManager.entity.OrdermanagerOrderprojecttype ordermanagerOrderprojecttype;//订单项目ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERORDER_ID_")
	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单序列
	
	public String getOrderprojecttypeValueFieldValue(){
		return this.orderprojecttypeValueFieldValue;
	}
	
	public void setOrderprojecttypeValueFieldValue(String orderprojecttypeValueFieldValue){
		this.orderprojecttypeValueFieldValue = orderprojecttypeValueFieldValue;
	}
	public String getOrderprojecttypeValueId(){
		return this.orderprojecttypeValueId;
	}
	
	public void setOrderprojecttypeValueId(String orderprojecttypeValueId){
		this.orderprojecttypeValueId = orderprojecttypeValueId;
	}
	public String getOrderprojecttypeValueFieldName(){
		return this.orderprojecttypeValueFieldName;
	}
	
	public void setOrderprojecttypeValueFieldName(String orderprojecttypeValueFieldName){
		this.orderprojecttypeValueFieldName = orderprojecttypeValueFieldName;
	}
	public String getOrderprojecttypeValueDisplayName(){
		return this.orderprojecttypeValueDisplayName;
	}
	
	public void setOrderprojecttypeValueDisplayName(String orderprojecttypeValueDisplayName){
		this.orderprojecttypeValueDisplayName = orderprojecttypeValueDisplayName;
	}
	
	public void setOrdermanagerOrderprojecttype(com.common.OrderManager.entity.OrdermanagerOrderprojecttype ordermanagerOrderprojecttype){
		this.ordermanagerOrderprojecttype = ordermanagerOrderprojecttype;
	}
	
	public com.common.OrderManager.entity.OrdermanagerOrderprojecttype getOrdermanagerOrderprojecttype(){
		return this.ordermanagerOrderprojecttype;
	}
	public void setOrdermanagerUserorder(com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder){
		this.ordermanagerUserorder = ordermanagerUserorder;
	}
	
	public com.common.OrderManager.entity.OrdermanagerUserorder getOrdermanagerUserorder(){
		return this.ordermanagerUserorder;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderprojecttypeValueFieldValue == null) ? 0 : orderprojecttypeValueFieldValue.hashCode());
		result = prime * result + ((orderprojecttypeValueId == null) ? 0 : orderprojecttypeValueId.hashCode());
		result = prime * result + ((orderprojecttypeValueFieldName == null) ? 0 : orderprojecttypeValueFieldName.hashCode());
		result = prime * result + ((orderprojecttypeValueDisplayName == null) ? 0 : orderprojecttypeValueDisplayName.hashCode());
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
		final OrdermanagerOrderprojecttypeValue other = (OrdermanagerOrderprojecttypeValue) obj;
		if (orderprojecttypeValueFieldValue == null) {
			if (other.orderprojecttypeValueFieldValue != null)
				return false;
		} else if (!orderprojecttypeValueFieldValue.equals(other.orderprojecttypeValueFieldValue))
			return false;
		if (orderprojecttypeValueId == null) {
			if (other.orderprojecttypeValueId != null)
				return false;
		} else if (!orderprojecttypeValueId.equals(other.orderprojecttypeValueId))
			return false;
		if (orderprojecttypeValueFieldName == null) {
			if (other.orderprojecttypeValueFieldName != null)
				return false;
		} else if (!orderprojecttypeValueFieldName.equals(other.orderprojecttypeValueFieldName))
			return false;
		if (orderprojecttypeValueDisplayName == null) {
			if (other.orderprojecttypeValueDisplayName != null)
				return false;
		} else if (!orderprojecttypeValueDisplayName.equals(other.orderprojecttypeValueDisplayName))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}