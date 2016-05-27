/**
 *
 */
package com.manage.PublicUtilitiesManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 资源状态
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_publicutilitiesmanager_reso")
public class PublicutilitiesmanagerReso implements Domain{
	
	private static final long serialVersionUID = 8248797396421261004L;
	

	@Column(name = "RESO_STATUS_")
	@Length(max=2)
	private String resoStatus;//资源状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RESO_ID_")
	@Length(max=36)
	private String resoId;//资源状态序列

	@Column(name = "RESO_TIME_")
	@Length(max=20)
	private String resoTime;//可用时段

	@Column(name = "RESO_DATE_")
	@Length(max=20)
	private String resoDate;//可用日期

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMMODITY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCommodity commodityId;//商品ID
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

	public String getResoStatus(){
		return this.resoStatus;
	}
	
	public void setResoStatus(String resoStatus){
		this.resoStatus = resoStatus;
	}
	public String getResoId(){
		return this.resoId;
	}
	
	public void setResoId(String resoId){
		this.resoId = resoId;
	}
	public String getResoTime(){
		return this.resoTime;
	}
	
	public void setResoTime(String resoTime){
		this.resoTime = resoTime;
	}
	public String getResoDate(){
		return this.resoDate;
	}
	
	public void setResoDate(String resoDate){
		this.resoDate = resoDate;
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
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	
	
	

	
	public com.common.purchasingManager.entity.PurchasingmanagerCommodity getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(
			com.common.purchasingManager.entity.PurchasingmanagerCommodity commodityId) {
		this.commodityId = commodityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((resoDate == null) ? 0 : resoDate.hashCode());
		result = prime * result + ((resoId == null) ? 0 : resoId.hashCode());
		result = prime * result
				+ ((resoStatus == null) ? 0 : resoStatus.hashCode());
		result = prime * result
				+ ((resoTime == null) ? 0 : resoTime.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		PublicutilitiesmanagerReso other = (PublicutilitiesmanagerReso) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (resoDate == null) {
			if (other.resoDate != null)
				return false;
		} else if (!resoDate.equals(other.resoDate))
			return false;
		if (resoId == null) {
			if (other.resoId != null)
				return false;
		} else if (!resoId.equals(other.resoId))
			return false;
		if (resoStatus == null) {
			if (other.resoStatus != null)
				return false;
		} else if (!resoStatus.equals(other.resoStatus))
			return false;
		if (resoTime == null) {
			if (other.resoTime != null)
				return false;
		} else if (!resoTime.equals(other.resoTime))
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