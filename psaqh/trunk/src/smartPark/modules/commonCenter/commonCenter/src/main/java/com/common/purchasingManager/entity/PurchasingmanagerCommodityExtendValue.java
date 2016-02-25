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
	
	private static final long serialVersionUID = 495848771049625535L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "COMMODITY_EXTEND_VALUE_DISPLAY_NAME_")
	@Length(max=128)
	private String commodityExtendValueDisplayName;//显示名称

	@Column(name = "COMMODITY_EXTEND_VALUE_FIELD_NAME_")
	@Length(max=128)
	private String commodityExtendValueFieldName;//字段名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "COMMODITY_EXTEND_VALUE_DISPLAY_CONTENT_")
	private String commodityExtendValueDisplayContent;//显示内容
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_EXTEND_VALUE_id_")
	@Length(max=36)
	private String commodityExtendValueId;//值序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMODITY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCommodity purchasingmanagerCommodity;//商品ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMODITY_EXTEND_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend;//类型定义序列
	
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCommodityExtendValueDisplayName(){
		return this.commodityExtendValueDisplayName;
	}
	
	public void setCommodityExtendValueDisplayName(String commodityExtendValueDisplayName){
		this.commodityExtendValueDisplayName = commodityExtendValueDisplayName;
	}
	public String getCommodityExtendValueFieldName(){
		return this.commodityExtendValueFieldName;
	}
	
	public void setCommodityExtendValueFieldName(String commodityExtendValueFieldName){
		this.commodityExtendValueFieldName = commodityExtendValueFieldName;
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
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCommodityExtendValueDisplayContent(){
		return this.commodityExtendValueDisplayContent;
	}
	
	public void setCommodityExtendValueDisplayContent(String commodityExtendValueDisplayContent){
		this.commodityExtendValueDisplayContent = commodityExtendValueDisplayContent;
	}
	public String getCommodityExtendValueId(){
		return this.commodityExtendValueId;
	}
	
	public void setCommodityExtendValueId(String commodityExtendValueId){
		this.commodityExtendValueId = commodityExtendValueId;
	}
	
	public void setPurchasingmanagerCommodity(com.common.purchasingManager.entity.PurchasingmanagerCommodity purchasingmanagerCommodity){
		this.purchasingmanagerCommodity = purchasingmanagerCommodity;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerCommodity getPurchasingmanagerCommodity(){
		return this.purchasingmanagerCommodity;
	}
	public void setPurchasingmanagerCommodityExtend(com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend purchasingmanagerCommodityExtend){
		this.purchasingmanagerCommodityExtend = purchasingmanagerCommodityExtend;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend getPurchasingmanagerCommodityExtend(){
		return this.purchasingmanagerCommodityExtend;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((commodityExtendValueDisplayName == null) ? 0 : commodityExtendValueDisplayName.hashCode());
		result = prime * result + ((commodityExtendValueFieldName == null) ? 0 : commodityExtendValueFieldName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((commodityExtendValueDisplayContent == null) ? 0 : commodityExtendValueDisplayContent.hashCode());
		result = prime * result + ((commodityExtendValueId == null) ? 0 : commodityExtendValueId.hashCode());
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
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (commodityExtendValueDisplayName == null) {
			if (other.commodityExtendValueDisplayName != null)
				return false;
		} else if (!commodityExtendValueDisplayName.equals(other.commodityExtendValueDisplayName))
			return false;
		if (commodityExtendValueFieldName == null) {
			if (other.commodityExtendValueFieldName != null)
				return false;
		} else if (!commodityExtendValueFieldName.equals(other.commodityExtendValueFieldName))
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
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (commodityExtendValueDisplayContent == null) {
			if (other.commodityExtendValueDisplayContent != null)
				return false;
		} else if (!commodityExtendValueDisplayContent.equals(other.commodityExtendValueDisplayContent))
			return false;
		if (commodityExtendValueId == null) {
			if (other.commodityExtendValueId != null)
				return false;
		} else if (!commodityExtendValueId.equals(other.commodityExtendValueId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}