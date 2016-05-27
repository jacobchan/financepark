/**
 *
 */
package com.distribution.rule.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 楼宇佣金比率配置
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_building_rate")
public class BuildingRate implements Domain{
	
	private static final long serialVersionUID = 6241518055323535190L;
	

	@Column(name = "ITEM_NAME_")
	@Length(max=36)
	private String itemName;//单元/楼宇名称

	@Column(name = "ITEM_ID_")
	@Length(max=36)
	private String itemId;//单元/楼宇ID

	@Column(name = "ITEM_TYPE_")
	@Length(max=1)
	private String itemType;//单元/楼宇

	@Column(name = "DIC_RATE_")
	@Length(max=10)
	private String dicRate;//提佣系数
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "REC_ID_")
	@Length(max=36)
	private String recId;//序列ID
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

	public String getItemName(){
		return this.itemName;
	}
	
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemId(){
		return this.itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getItemType(){
		return this.itemType;
	}
	
	public void setItemType(String itemType){
		this.itemType = itemType;
	}
	public String getDicRate(){
		return this.dicRate;
	}
	
	public void setDicRate(String dicRate){
		this.dicRate = dicRate;
	}
	public String getRecId(){
		return this.recId;
	}
	
	public void setRecId(String recId){
		this.recId = recId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((dicRate == null) ? 0 : dicRate.hashCode());
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
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
		final BuildingRate other = (BuildingRate) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (dicRate == null) {
			if (other.dicRate != null)
				return false;
		} else if (!dicRate.equals(other.dicRate))
			return false;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
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