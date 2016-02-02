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
	
	private static final long serialVersionUID = 4190731057235608988L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_EXTEND_ID_")
	@Length(max=36)
	private String commodityExtendId;//类型定义序列

	@Column(name = "COMMODITY_EXTEND_ISNOT_MUST_")
	@Length(max=1)
	private String commodityExtendIsnotMust;//是否必须

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型

	@Column(name = "COMMODITY_EXTEND_CONTENT_")
	private String commodityExtendContent;//内容

	@Column(name = "COMMODITY_EXTEND_FIELD_TYPE_")
	@Length(max=2)
	private String commodityExtendFieldType;//字段类型

	@Column(name = "COMMODITY_EXTEND_ISNOT_DISPLAY_")
	@Length(max=1)
	private String commodityExtendIsnotDisplay;//是否显示

	@Column(name = "COMMODITY_EXTEND_INFORMATION_TYPE_")
	@Length(max=2)
	private String commodityExtendInformationType;//信息类型

	@Column(name = "COMMODITY_EXTEND_DISPLAY_NAME_")
	@Length(max=128)
	private String commodityExtendDisplayName;//显示名称

	@Column(name = "COMMODITY_EXTEND_FIELD_NAME_")
	@Length(max=128)
	private String commodityExtendFieldName;//字段名称
	
	public String getCommodityExtendId(){
		return this.commodityExtendId;
	}
	
	public void setCommodityExtendId(String commodityExtendId){
		this.commodityExtendId = commodityExtendId;
	}
	public String getCommodityExtendIsnotMust(){
		return this.commodityExtendIsnotMust;
	}
	
	public void setCommodityExtendIsnotMust(String commodityExtendIsnotMust){
		this.commodityExtendIsnotMust = commodityExtendIsnotMust;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	public String getCommodityExtendContent(){
		return this.commodityExtendContent;
	}
	
	public void setCommodityExtendContent(String commodityExtendContent){
		this.commodityExtendContent = commodityExtendContent;
	}
	public String getCommodityExtendFieldType(){
		return this.commodityExtendFieldType;
	}
	
	public void setCommodityExtendFieldType(String commodityExtendFieldType){
		this.commodityExtendFieldType = commodityExtendFieldType;
	}
	public String getCommodityExtendIsnotDisplay(){
		return this.commodityExtendIsnotDisplay;
	}
	
	public void setCommodityExtendIsnotDisplay(String commodityExtendIsnotDisplay){
		this.commodityExtendIsnotDisplay = commodityExtendIsnotDisplay;
	}
	public String getCommodityExtendInformationType(){
		return this.commodityExtendInformationType;
	}
	
	public void setCommodityExtendInformationType(String commodityExtendInformationType){
		this.commodityExtendInformationType = commodityExtendInformationType;
	}
	public String getCommodityExtendDisplayName(){
		return this.commodityExtendDisplayName;
	}
	
	public void setCommodityExtendDisplayName(String commodityExtendDisplayName){
		this.commodityExtendDisplayName = commodityExtendDisplayName;
	}
	public String getCommodityExtendFieldName(){
		return this.commodityExtendFieldName;
	}
	
	public void setCommodityExtendFieldName(String commodityExtendFieldName){
		this.commodityExtendFieldName = commodityExtendFieldName;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodityExtendId == null) ? 0 : commodityExtendId.hashCode());
		result = prime * result + ((commodityExtendIsnotMust == null) ? 0 : commodityExtendIsnotMust.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((commodityExtendContent == null) ? 0 : commodityExtendContent.hashCode());
		result = prime * result + ((commodityExtendFieldType == null) ? 0 : commodityExtendFieldType.hashCode());
		result = prime * result + ((commodityExtendIsnotDisplay == null) ? 0 : commodityExtendIsnotDisplay.hashCode());
		result = prime * result + ((commodityExtendInformationType == null) ? 0 : commodityExtendInformationType.hashCode());
		result = prime * result + ((commodityExtendDisplayName == null) ? 0 : commodityExtendDisplayName.hashCode());
		result = prime * result + ((commodityExtendFieldName == null) ? 0 : commodityExtendFieldName.hashCode());
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
		if (commodityExtendId == null) {
			if (other.commodityExtendId != null)
				return false;
		} else if (!commodityExtendId.equals(other.commodityExtendId))
			return false;
		if (commodityExtendIsnotMust == null) {
			if (other.commodityExtendIsnotMust != null)
				return false;
		} else if (!commodityExtendIsnotMust.equals(other.commodityExtendIsnotMust))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		if (commodityExtendContent == null) {
			if (other.commodityExtendContent != null)
				return false;
		} else if (!commodityExtendContent.equals(other.commodityExtendContent))
			return false;
		if (commodityExtendFieldType == null) {
			if (other.commodityExtendFieldType != null)
				return false;
		} else if (!commodityExtendFieldType.equals(other.commodityExtendFieldType))
			return false;
		if (commodityExtendIsnotDisplay == null) {
			if (other.commodityExtendIsnotDisplay != null)
				return false;
		} else if (!commodityExtendIsnotDisplay.equals(other.commodityExtendIsnotDisplay))
			return false;
		if (commodityExtendInformationType == null) {
			if (other.commodityExtendInformationType != null)
				return false;
		} else if (!commodityExtendInformationType.equals(other.commodityExtendInformationType))
			return false;
		if (commodityExtendDisplayName == null) {
			if (other.commodityExtendDisplayName != null)
				return false;
		} else if (!commodityExtendDisplayName.equals(other.commodityExtendDisplayName))
			return false;
		if (commodityExtendFieldName == null) {
			if (other.commodityExtendFieldName != null)
				return false;
		} else if (!commodityExtendFieldName.equals(other.commodityExtendFieldName))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}