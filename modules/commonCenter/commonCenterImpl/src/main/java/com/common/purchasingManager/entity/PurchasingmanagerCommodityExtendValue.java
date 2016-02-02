/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品扩展属性值表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_commodity_extend_value")
public class PurchasingmanagerCommodityExtendValue implements Domain{
	
	private static final long serialVersionUID = -2284010239692758977L;
	

	@Column(name = "COMMODITY_EXTEND_VALUE_FIELD_NAME_")
	@Length(max=128)
	private String commodityExtendValueFieldName;//字段名称

	@Column(name = "COMMODITY_EXTEND_VALUE_DISPLAY_NAME_")
	@Length(max=128)
	private String commodityExtendValueDisplayName;//显示名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_EXTEND_VALUE_id_")
	@Length(max=36)
	private String commodityExtendValueId;//值序列

	@Column(name = "COMMODITY_EXTEND_VALUE_DISPLAY_CONTENT_")
	private String commodityExtendValueDisplayContent;//显示内容
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMODITY_EXTEND_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend;//类型定义序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMODITY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCommodity purchasingmanagerCommodity;//商品ID
	
	public String getCommodityExtendValueFieldName(){
		return this.commodityExtendValueFieldName;
	}
	
	public void setCommodityExtendValueFieldName(String commodityExtendValueFieldName){
		this.commodityExtendValueFieldName = commodityExtendValueFieldName;
	}
	public String getCommodityExtendValueDisplayName(){
		return this.commodityExtendValueDisplayName;
	}
	
	public void setCommodityExtendValueDisplayName(String commodityExtendValueDisplayName){
		this.commodityExtendValueDisplayName = commodityExtendValueDisplayName;
	}
	public String getCommodityExtendValueId(){
		return this.commodityExtendValueId;
	}
	
	public void setCommodityExtendValueId(String commodityExtendValueId){
		this.commodityExtendValueId = commodityExtendValueId;
	}
	public String getCommodityExtendValueDisplayContent(){
		return this.commodityExtendValueDisplayContent;
	}
	
	public void setCommodityExtendValueDisplayContent(String commodityExtendValueDisplayContent){
		this.commodityExtendValueDisplayContent = commodityExtendValueDisplayContent;
	}
	
	public void setPurchasingmanagerCommodityExtend(com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend){
		this.purchasingmanagerCommodityExtend = purchasingmanagerCommodityExtend;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend getPurchasingmanagerCommodityExtend(){
		return this.purchasingmanagerCommodityExtend;
	}
	public void setPurchasingmanagerCommodity(com.common.purchasingManager.entity.PurchasingmanagerCommodity purchasingmanagerCommodity){
		this.purchasingmanagerCommodity = purchasingmanagerCommodity;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerCommodity getPurchasingmanagerCommodity(){
		return this.purchasingmanagerCommodity;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodityExtendValueFieldName == null) ? 0 : commodityExtendValueFieldName.hashCode());
		result = prime * result + ((commodityExtendValueDisplayName == null) ? 0 : commodityExtendValueDisplayName.hashCode());
		result = prime * result + ((commodityExtendValueId == null) ? 0 : commodityExtendValueId.hashCode());
		result = prime * result + ((commodityExtendValueDisplayContent == null) ? 0 : commodityExtendValueDisplayContent.hashCode());
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
		final PurchasingmanagerCommodityExtendValue other = (PurchasingmanagerCommodityExtendValue) obj;
		if (commodityExtendValueFieldName == null) {
			if (other.commodityExtendValueFieldName != null)
				return false;
		} else if (!commodityExtendValueFieldName.equals(other.commodityExtendValueFieldName))
			return false;
		if (commodityExtendValueDisplayName == null) {
			if (other.commodityExtendValueDisplayName != null)
				return false;
		} else if (!commodityExtendValueDisplayName.equals(other.commodityExtendValueDisplayName))
			return false;
		if (commodityExtendValueId == null) {
			if (other.commodityExtendValueId != null)
				return false;
		} else if (!commodityExtendValueId.equals(other.commodityExtendValueId))
			return false;
		if (commodityExtendValueDisplayContent == null) {
			if (other.commodityExtendValueDisplayContent != null)
				return false;
		} else if (!commodityExtendValueDisplayContent.equals(other.commodityExtendValueDisplayContent))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}