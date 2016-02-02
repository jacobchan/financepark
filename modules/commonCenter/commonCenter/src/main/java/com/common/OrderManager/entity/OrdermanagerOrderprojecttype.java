/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单项目类型表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_orderProjectType_")
public class OrdermanagerOrderprojecttype implements Domain{
	
	private static final long serialVersionUID = 8874039877589015605L;
	

	@Column(name = "ORDERPROJECTTYPE_ISNOT_DISPLAY_")
	@Length(max=1)
	private String orderprojecttypeIsnotDisplay;//是否显示

	@Column(name = "ORDERPROJECTTYPE_FIELD_TYPE_")
	@Length(max=2)
	private String orderprojecttypeFieldType;//字段类型

	@Column(name = "ORDERPROJECTTYPE_DEFAULT_VALUE_")
	@Length(max=128)
	private String orderprojecttypeDefaultValue;//默认值

	@Column(name = "ORDERPROJECTTYPE_FIELD_LENGTH_")
	private String orderprojecttypeFieldLength;//字段长度

	@Column(name = "ORDERPROJECTTYPE_CHECK_FORMAT_")
	@Length(max=64)
	private String orderprojecttypeCheckFormat;//校验格式

	@Column(name = "ORDERPROJECTTYPE_OPTION_CODESET_")
	@Length(max=32)
	private String orderprojecttypeOptionCodeset;//选项代码集
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDERPROJECTTYPE_ID_")
	@Length(max=36)
	private String orderprojecttypeId;//订单项目ID

	@Column(name = "ORDERPROJECTTYPE_SORT_CHAR_")
	@Length(max=32)
	private String orderprojecttypeSortChar;//排序字符

	@Column(name = "ORDERPROJECTTYPE_FIELD_NAME_")
	@Length(max=128)
	private String orderprojecttypeFieldName;//字段名称

	@Column(name = "ORDERPROJECTTYPE_ISNOT_MUST_")
	@Length(max=1)
	private String orderprojecttypeIsnotMust;//是否必须

	@Column(name = "ORDERPROJECTTYPE_DISPLAY_NAME_")
	@Length(max=128)
	private String orderprojecttypeDisplayName;//显示名称
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDERTYPE_ID_")
	private com.common.OrderManager.entity.OrdermanagerOrdertype ordermanagerOrdertype;//订单类型主键
	
	public String getOrderprojecttypeIsnotDisplay(){
		return this.orderprojecttypeIsnotDisplay;
	}
	
	public void setOrderprojecttypeIsnotDisplay(String orderprojecttypeIsnotDisplay){
		this.orderprojecttypeIsnotDisplay = orderprojecttypeIsnotDisplay;
	}
	public String getOrderprojecttypeFieldType(){
		return this.orderprojecttypeFieldType;
	}
	
	public void setOrderprojecttypeFieldType(String orderprojecttypeFieldType){
		this.orderprojecttypeFieldType = orderprojecttypeFieldType;
	}
	public String getOrderprojecttypeDefaultValue(){
		return this.orderprojecttypeDefaultValue;
	}
	
	public void setOrderprojecttypeDefaultValue(String orderprojecttypeDefaultValue){
		this.orderprojecttypeDefaultValue = orderprojecttypeDefaultValue;
	}
	public String getOrderprojecttypeFieldLength(){
		return this.orderprojecttypeFieldLength;
	}
	
	public void setOrderprojecttypeFieldLength(String orderprojecttypeFieldLength){
		this.orderprojecttypeFieldLength = orderprojecttypeFieldLength;
	}
	public String getOrderprojecttypeCheckFormat(){
		return this.orderprojecttypeCheckFormat;
	}
	
	public void setOrderprojecttypeCheckFormat(String orderprojecttypeCheckFormat){
		this.orderprojecttypeCheckFormat = orderprojecttypeCheckFormat;
	}
	public String getOrderprojecttypeOptionCodeset(){
		return this.orderprojecttypeOptionCodeset;
	}
	
	public void setOrderprojecttypeOptionCodeset(String orderprojecttypeOptionCodeset){
		this.orderprojecttypeOptionCodeset = orderprojecttypeOptionCodeset;
	}
	public String getOrderprojecttypeId(){
		return this.orderprojecttypeId;
	}
	
	public void setOrderprojecttypeId(String orderprojecttypeId){
		this.orderprojecttypeId = orderprojecttypeId;
	}
	public String getOrderprojecttypeSortChar(){
		return this.orderprojecttypeSortChar;
	}
	
	public void setOrderprojecttypeSortChar(String orderprojecttypeSortChar){
		this.orderprojecttypeSortChar = orderprojecttypeSortChar;
	}
	public String getOrderprojecttypeFieldName(){
		return this.orderprojecttypeFieldName;
	}
	
	public void setOrderprojecttypeFieldName(String orderprojecttypeFieldName){
		this.orderprojecttypeFieldName = orderprojecttypeFieldName;
	}
	public String getOrderprojecttypeIsnotMust(){
		return this.orderprojecttypeIsnotMust;
	}
	
	public void setOrderprojecttypeIsnotMust(String orderprojecttypeIsnotMust){
		this.orderprojecttypeIsnotMust = orderprojecttypeIsnotMust;
	}
	public String getOrderprojecttypeDisplayName(){
		return this.orderprojecttypeDisplayName;
	}
	
	public void setOrderprojecttypeDisplayName(String orderprojecttypeDisplayName){
		this.orderprojecttypeDisplayName = orderprojecttypeDisplayName;
	}
	
	public void setOrdermanagerOrdertype(com.common.OrderManager.entity.OrdermanagerOrdertype ordermanagerOrdertype){
		this.ordermanagerOrdertype = ordermanagerOrdertype;
	}
	
	public com.common.OrderManager.entity.OrdermanagerOrdertype getOrdermanagerOrdertype(){
		return this.ordermanagerOrdertype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderprojecttypeIsnotDisplay == null) ? 0 : orderprojecttypeIsnotDisplay.hashCode());
		result = prime * result + ((orderprojecttypeFieldType == null) ? 0 : orderprojecttypeFieldType.hashCode());
		result = prime * result + ((orderprojecttypeDefaultValue == null) ? 0 : orderprojecttypeDefaultValue.hashCode());
		result = prime * result + ((orderprojecttypeFieldLength == null) ? 0 : orderprojecttypeFieldLength.hashCode());
		result = prime * result + ((orderprojecttypeCheckFormat == null) ? 0 : orderprojecttypeCheckFormat.hashCode());
		result = prime * result + ((orderprojecttypeOptionCodeset == null) ? 0 : orderprojecttypeOptionCodeset.hashCode());
		result = prime * result + ((orderprojecttypeId == null) ? 0 : orderprojecttypeId.hashCode());
		result = prime * result + ((orderprojecttypeSortChar == null) ? 0 : orderprojecttypeSortChar.hashCode());
		result = prime * result + ((orderprojecttypeFieldName == null) ? 0 : orderprojecttypeFieldName.hashCode());
		result = prime * result + ((orderprojecttypeIsnotMust == null) ? 0 : orderprojecttypeIsnotMust.hashCode());
		result = prime * result + ((orderprojecttypeDisplayName == null) ? 0 : orderprojecttypeDisplayName.hashCode());
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
		final OrdermanagerOrderprojecttype other = (OrdermanagerOrderprojecttype) obj;
		if (orderprojecttypeIsnotDisplay == null) {
			if (other.orderprojecttypeIsnotDisplay != null)
				return false;
		} else if (!orderprojecttypeIsnotDisplay.equals(other.orderprojecttypeIsnotDisplay))
			return false;
		if (orderprojecttypeFieldType == null) {
			if (other.orderprojecttypeFieldType != null)
				return false;
		} else if (!orderprojecttypeFieldType.equals(other.orderprojecttypeFieldType))
			return false;
		if (orderprojecttypeDefaultValue == null) {
			if (other.orderprojecttypeDefaultValue != null)
				return false;
		} else if (!orderprojecttypeDefaultValue.equals(other.orderprojecttypeDefaultValue))
			return false;
		if (orderprojecttypeFieldLength == null) {
			if (other.orderprojecttypeFieldLength != null)
				return false;
		} else if (!orderprojecttypeFieldLength.equals(other.orderprojecttypeFieldLength))
			return false;
		if (orderprojecttypeCheckFormat == null) {
			if (other.orderprojecttypeCheckFormat != null)
				return false;
		} else if (!orderprojecttypeCheckFormat.equals(other.orderprojecttypeCheckFormat))
			return false;
		if (orderprojecttypeOptionCodeset == null) {
			if (other.orderprojecttypeOptionCodeset != null)
				return false;
		} else if (!orderprojecttypeOptionCodeset.equals(other.orderprojecttypeOptionCodeset))
			return false;
		if (orderprojecttypeId == null) {
			if (other.orderprojecttypeId != null)
				return false;
		} else if (!orderprojecttypeId.equals(other.orderprojecttypeId))
			return false;
		if (orderprojecttypeSortChar == null) {
			if (other.orderprojecttypeSortChar != null)
				return false;
		} else if (!orderprojecttypeSortChar.equals(other.orderprojecttypeSortChar))
			return false;
		if (orderprojecttypeFieldName == null) {
			if (other.orderprojecttypeFieldName != null)
				return false;
		} else if (!orderprojecttypeFieldName.equals(other.orderprojecttypeFieldName))
			return false;
		if (orderprojecttypeIsnotMust == null) {
			if (other.orderprojecttypeIsnotMust != null)
				return false;
		} else if (!orderprojecttypeIsnotMust.equals(other.orderprojecttypeIsnotMust))
			return false;
		if (orderprojecttypeDisplayName == null) {
			if (other.orderprojecttypeDisplayName != null)
				return false;
		} else if (!orderprojecttypeDisplayName.equals(other.orderprojecttypeDisplayName))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}