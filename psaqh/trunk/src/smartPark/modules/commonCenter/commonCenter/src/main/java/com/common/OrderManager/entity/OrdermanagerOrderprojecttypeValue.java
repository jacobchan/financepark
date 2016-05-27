/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单项扩展信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_orderProjectType_value_")
public class OrdermanagerOrderprojecttypeValue implements Domain{
	
	private static final long serialVersionUID = 8308866799151068156L;
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "ORDERPROJECTTYPE_VALUE_DISPLAY_NAME_")
	@Length(max=128)
	private String orderprojecttypeValueDisplayName;//显示名称

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "ORDERPROJECTTYPE_VALUE_FIELD_VALUE_")
	private String orderprojecttypeValueFieldValue;//字段值

	@Column(name = "ORDERPROJECTTYPE_VALUE_FIELD_NAME_")
	@Length(max=128)
	private String orderprojecttypeValueFieldName;//字段名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDERPROJECTTYPE_VALUE_ID_")
	@Length(max=36)
	private String orderprojecttypeValueId;//订单项目序列

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERORDER_ID_")
	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENRE_PROPERTY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerGenreProperty genrePropertyId;//商品类别属性序列
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	public void setGenrePropertyId(
			com.common.purchasingManager.entity.PurchasingmanagerGenreProperty genrePropertyId) {
		this.genrePropertyId = genrePropertyId;
	}
	

	public com.common.purchasingManager.entity.PurchasingmanagerGenreProperty getGenrePropertyId() {
		return genrePropertyId;
	}


	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getOrderprojecttypeValueDisplayName(){
		return this.orderprojecttypeValueDisplayName;
	}
	
	public void setOrderprojecttypeValueDisplayName(String orderprojecttypeValueDisplayName){
		this.orderprojecttypeValueDisplayName = orderprojecttypeValueDisplayName;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getOrderprojecttypeValueFieldValue(){
		return this.orderprojecttypeValueFieldValue;
	}
	
	public void setOrderprojecttypeValueFieldValue(String orderprojecttypeValueFieldValue){
		this.orderprojecttypeValueFieldValue = orderprojecttypeValueFieldValue;
	}
	public String getOrderprojecttypeValueFieldName(){
		return this.orderprojecttypeValueFieldName;
	}
	
	public void setOrderprojecttypeValueFieldName(String orderprojecttypeValueFieldName){
		this.orderprojecttypeValueFieldName = orderprojecttypeValueFieldName;
	}
	public String getOrderprojecttypeValueId(){
		return this.orderprojecttypeValueId;
	}
	
	public void setOrderprojecttypeValueId(String orderprojecttypeValueId){
		this.orderprojecttypeValueId = orderprojecttypeValueId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
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
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((orderprojecttypeValueDisplayName == null) ? 0 : orderprojecttypeValueDisplayName.hashCode());
		result = prime * result + ((genrePropertyId == null) ? 0 : genrePropertyId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((orderprojecttypeValueFieldValue == null) ? 0 : orderprojecttypeValueFieldValue.hashCode());
		result = prime * result + ((orderprojecttypeValueFieldName == null) ? 0 : orderprojecttypeValueFieldName.hashCode());
		result = prime * result + ((orderprojecttypeValueId == null) ? 0 : orderprojecttypeValueId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		/**新增园区字段   end**/
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
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (orderprojecttypeValueDisplayName == null) {
			if (other.orderprojecttypeValueDisplayName != null)
				return false;
		} else if (!orderprojecttypeValueDisplayName.equals(other.orderprojecttypeValueDisplayName))
			return false;
		if (genrePropertyId == null) {
			if (other.genrePropertyId != null)
				return false;
		} else if (!genrePropertyId.equals(other.genrePropertyId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (orderprojecttypeValueFieldValue == null) {
			if (other.orderprojecttypeValueFieldValue != null)
				return false;
		} else if (!orderprojecttypeValueFieldValue.equals(other.orderprojecttypeValueFieldValue))
			return false;
		if (orderprojecttypeValueFieldName == null) {
			if (other.orderprojecttypeValueFieldName != null)
				return false;
		} else if (!orderprojecttypeValueFieldName.equals(other.orderprojecttypeValueFieldName))
			return false;
		if (orderprojecttypeValueId == null) {
			if (other.orderprojecttypeValueId != null)
				return false;
		} else if (!orderprojecttypeValueId.equals(other.orderprojecttypeValueId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}