/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 费用清单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_ser")
public class PropertyservicemanagerSer implements Domain{
	
	private static final long serialVersionUID = 7141883104253804944L;
	

	@Column(name = "SER_NAME_")
	@Length(max=2)
	private String serName;//材料名称

	@Column(name = "SER_PAY_STATUS_")
	@Length(max=2)
	private String serPayStatus;//支付状态
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SER_ID_")
	@Length(max=36)
	private String serId;//主键ID_

	@Column(name = "SER_PRICE_")
	private BigDecimal serPrice;//材料价格

	@Column(name = "SER_TYPE_")
	@Length(max=2)
	private String serType;//材料类别
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TS_ID_")
	private PropertyservicemanagerTs propertyservicemanagerTs;//主键ID_2
	
	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "UPDATE_TIME_")
	@Length(max=20)
	private String updateTime;//修改时间
	
	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "CREATE_TIME_")
	@Length(max=20)
	private String createTime;//创建时间
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSerName(){
		return this.serName;
	}
	
	public void setSerName(String serName){
		this.serName = serName;
	}
	public String getSerPayStatus(){
		return this.serPayStatus;
	}
	
	public void setSerPayStatus(String serPayStatus){
		this.serPayStatus = serPayStatus;
	}
	public String getSerId(){
		return this.serId;
	}
	
	public void setSerId(String serId){
		this.serId = serId;
	}

	public BigDecimal getSerPrice() {
		return serPrice;
	}

	public void setSerPrice(BigDecimal serPrice) {
		this.serPrice = serPrice;
	}

	public String getSerType(){
		return this.serType;
	}
	
	public void setSerType(String serType){
		this.serType = serType;
	}
	
	public void setPropertyservicemanagerTs(com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs propertyservicemanagerTs){
		this.propertyservicemanagerTs = propertyservicemanagerTs;
	}
	
	public com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs getPropertyservicemanagerTs(){
		return this.propertyservicemanagerTs;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime
				* result
				+ ((propertyservicemanagerTs == null) ? 0
						: propertyservicemanagerTs.hashCode());
		result = prime * result + ((serId == null) ? 0 : serId.hashCode());
		result = prime * result + ((serName == null) ? 0 : serName.hashCode());
		result = prime * result
				+ ((serPayStatus == null) ? 0 : serPayStatus.hashCode());
		result = prime * result
				+ ((serPrice == null) ? 0 : serPrice.hashCode());
		result = prime * result + ((serType == null) ? 0 : serType.hashCode());
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
		PropertyservicemanagerSer other = (PropertyservicemanagerSer) obj;
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
		if (propertyservicemanagerTs == null) {
			if (other.propertyservicemanagerTs != null)
				return false;
		} else if (!propertyservicemanagerTs
				.equals(other.propertyservicemanagerTs))
			return false;
		if (serId == null) {
			if (other.serId != null)
				return false;
		} else if (!serId.equals(other.serId))
			return false;
		if (serName == null) {
			if (other.serName != null)
				return false;
		} else if (!serName.equals(other.serName))
			return false;
		if (serPayStatus == null) {
			if (other.serPayStatus != null)
				return false;
		} else if (!serPayStatus.equals(other.serPayStatus))
			return false;
		if (serPrice == null) {
			if (other.serPrice != null)
				return false;
		} else if (!serPrice.equals(other.serPrice))
			return false;
		if (serType == null) {
			if (other.serType != null)
				return false;
		} else if (!serType.equals(other.serType))
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