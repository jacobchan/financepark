/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单商户关系表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_orderMerchan_nexus")
public class OrdermanagerOrdermerchanNexus implements Domain{
	
	private static final long serialVersionUID = 5883518807930679324L;
	

	@Column(name = "ORDERMERCHAN_NEXUS_EXPRESS_ORDER_")
	@Length(max=32)
	private String ordermerchanNexusExpressOrder;//物流单号

	@Column(name = "MERCHANT_ID_")
	@Length(max=36)
	private String merchantId;//商户ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDERMERCHAN_NEXUS_ID_")
	@Length(max=36)
	private String ordermerchanNexusId;//订单商户序列
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERORDER_ID_")
	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单序列
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

	public String getOrdermerchanNexusExpressOrder(){
		return this.ordermerchanNexusExpressOrder;
	}
	
	public void setOrdermerchanNexusExpressOrder(String ordermerchanNexusExpressOrder){
		this.ordermerchanNexusExpressOrder = ordermerchanNexusExpressOrder;
	}
	public String getMerchantId(){
		return this.merchantId;
	}
	
	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
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
	public String getOrdermerchanNexusId(){
		return this.ordermerchanNexusId;
	}
	
	public void setOrdermerchanNexusId(String ordermerchanNexusId){
		this.ordermerchanNexusId = ordermerchanNexusId;
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
		result = prime * result + ((ordermerchanNexusExpressOrder == null) ? 0 : ordermerchanNexusExpressOrder.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((ordermerchanNexusId == null) ? 0 : ordermerchanNexusId.hashCode());
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
		final OrdermanagerOrdermerchanNexus other = (OrdermanagerOrdermerchanNexus) obj;
		if (ordermerchanNexusExpressOrder == null) {
			if (other.ordermerchanNexusExpressOrder != null)
				return false;
		} else if (!ordermerchanNexusExpressOrder.equals(other.ordermerchanNexusExpressOrder))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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
		if (ordermerchanNexusId == null) {
			if (other.ordermerchanNexusId != null)
				return false;
		} else if (!ordermerchanNexusId.equals(other.ordermerchanNexusId))
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