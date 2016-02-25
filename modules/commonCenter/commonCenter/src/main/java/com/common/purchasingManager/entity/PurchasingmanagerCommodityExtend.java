/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 采购商品信息扩展
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_commodity_extend")
public class PurchasingmanagerCommodityExtend implements Domain{
	
	private static final long serialVersionUID = 449194860747549827L;
	

	@Column(name = "COMMODITY_EXTEND_ISNOT_DISPLAY_")
	@Length(max=1)
	private String commodityExtendIsnotDisplay;//是否显示

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "COMMODITY_EXTEND_FIELD_NAME_")
	@Length(max=128)
	private String commodityExtendFieldName;//字段名称

	@Column(name = "COMMODITY_EXTEND_CONTENT_")
	private String commodityExtendContent;//内容

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "COMMODITY_EXTEND_ISNOT_MUST_")
	@Length(max=1)
	private String commodityExtendIsnotMust;//是否必须

	@Column(name = "COMMODITY_EXTEND_DISPLAY_NAME_")
	@Length(max=128)
	private String commodityExtendDisplayName;//显示名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_EXTEND_ID_")
	@Length(max=36)
	private String commodityExtendId;//类型定义序列

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "COMMODITY_EXTEND_FIELD_TYPE_")
	@Length(max=2)
	private String commodityExtendFieldType;//字段类型

	@Column(name = "COMMODITY_EXTEND_INFORMATION_TYPE_")
	@Length(max=2)
	private String commodityExtendInformationType;//信息类型

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型
	
	public String getCommodityExtendIsnotDisplay(){
		return this.commodityExtendIsnotDisplay;
	}
	
	public void setCommodityExtendIsnotDisplay(String commodityExtendIsnotDisplay){
		this.commodityExtendIsnotDisplay = commodityExtendIsnotDisplay;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCommodityExtendFieldName(){
		return this.commodityExtendFieldName;
	}
	
	public void setCommodityExtendFieldName(String commodityExtendFieldName){
		this.commodityExtendFieldName = commodityExtendFieldName;
	}
	public String getCommodityExtendContent(){
		return this.commodityExtendContent;
	}
	
	public void setCommodityExtendContent(String commodityExtendContent){
		this.commodityExtendContent = commodityExtendContent;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCommodityExtendIsnotMust(){
		return this.commodityExtendIsnotMust;
	}
	
	public void setCommodityExtendIsnotMust(String commodityExtendIsnotMust){
		this.commodityExtendIsnotMust = commodityExtendIsnotMust;
	}
	public String getCommodityExtendDisplayName(){
		return this.commodityExtendDisplayName;
	}
	
	public void setCommodityExtendDisplayName(String commodityExtendDisplayName){
		this.commodityExtendDisplayName = commodityExtendDisplayName;
	}
	public String getCommodityExtendId(){
		return this.commodityExtendId;
	}
	
	public void setCommodityExtendId(String commodityExtendId){
		this.commodityExtendId = commodityExtendId;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCommodityExtendFieldType(){
		return this.commodityExtendFieldType;
	}
	
	public void setCommodityExtendFieldType(String commodityExtendFieldType){
		this.commodityExtendFieldType = commodityExtendFieldType;
	}
	public String getCommodityExtendInformationType(){
		return this.commodityExtendInformationType;
	}
	
	public void setCommodityExtendInformationType(String commodityExtendInformationType){
		this.commodityExtendInformationType = commodityExtendInformationType;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodityExtendIsnotDisplay == null) ? 0 : commodityExtendIsnotDisplay.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((commodityExtendFieldName == null) ? 0 : commodityExtendFieldName.hashCode());
		result = prime * result + ((commodityExtendContent == null) ? 0 : commodityExtendContent.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((commodityExtendIsnotMust == null) ? 0 : commodityExtendIsnotMust.hashCode());
		result = prime * result + ((commodityExtendDisplayName == null) ? 0 : commodityExtendDisplayName.hashCode());
		result = prime * result + ((commodityExtendId == null) ? 0 : commodityExtendId.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((commodityExtendFieldType == null) ? 0 : commodityExtendFieldType.hashCode());
		result = prime * result + ((commodityExtendInformationType == null) ? 0 : commodityExtendInformationType.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
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
		final PurchasingmanagerCommodityExtend other = (PurchasingmanagerCommodityExtend) obj;
		if (commodityExtendIsnotDisplay == null) {
			if (other.commodityExtendIsnotDisplay != null)
				return false;
		} else if (!commodityExtendIsnotDisplay.equals(other.commodityExtendIsnotDisplay))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (commodityExtendFieldName == null) {
			if (other.commodityExtendFieldName != null)
				return false;
		} else if (!commodityExtendFieldName.equals(other.commodityExtendFieldName))
			return false;
		if (commodityExtendContent == null) {
			if (other.commodityExtendContent != null)
				return false;
		} else if (!commodityExtendContent.equals(other.commodityExtendContent))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (commodityExtendIsnotMust == null) {
			if (other.commodityExtendIsnotMust != null)
				return false;
		} else if (!commodityExtendIsnotMust.equals(other.commodityExtendIsnotMust))
			return false;
		if (commodityExtendDisplayName == null) {
			if (other.commodityExtendDisplayName != null)
				return false;
		} else if (!commodityExtendDisplayName.equals(other.commodityExtendDisplayName))
			return false;
		if (commodityExtendId == null) {
			if (other.commodityExtendId != null)
				return false;
		} else if (!commodityExtendId.equals(other.commodityExtendId))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (commodityExtendFieldType == null) {
			if (other.commodityExtendFieldType != null)
				return false;
		} else if (!commodityExtendFieldType.equals(other.commodityExtendFieldType))
			return false;
		if (commodityExtendInformationType == null) {
			if (other.commodityExtendInformationType != null)
				return false;
		} else if (!commodityExtendInformationType.equals(other.commodityExtendInformationType))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}