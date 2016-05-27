/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商户地址库
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_merchant_address_")
public class PurchasingmanagerMerchantAddress implements Domain{
	
	private static final long serialVersionUID = 2980811411567964261L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "MERCHANT_ADDRESS_PHONE_")
	@Length(max=16)
	private String merchantAddressPhone;//联系电话

	@Column(name = "MERCHANT_ADDRESS_LINKMAN_")
	@Length(max=32)
	private String merchantAddressLinkman;//联系人

	@Column(name = "MERCHANT_ADDRESS_ADDRESS_")
	@Length(max=256)
	private String merchantAddressAddress;//地址

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "MERCHANT_ADDRESS_ISNOT_DEFAULT_")
	@Length(max=1)
	private String merchantAddressIsnotDefault;//是否默认
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MERCHANT_ADDRESS_ID_")
	@Length(max=36)
	private String merchantAddressId;//地址ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MERCHANT_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerMerchant purchasingmanagerMerchant;//商户ID
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
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getMerchantAddressPhone(){
		return this.merchantAddressPhone;
	}
	
	public void setMerchantAddressPhone(String merchantAddressPhone){
		this.merchantAddressPhone = merchantAddressPhone;
	}
	public String getMerchantAddressLinkman(){
		return this.merchantAddressLinkman;
	}
	
	public void setMerchantAddressLinkman(String merchantAddressLinkman){
		this.merchantAddressLinkman = merchantAddressLinkman;
	}
	public String getMerchantAddressAddress(){
		return this.merchantAddressAddress;
	}
	
	public void setMerchantAddressAddress(String merchantAddressAddress){
		this.merchantAddressAddress = merchantAddressAddress;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getMerchantAddressIsnotDefault(){
		return this.merchantAddressIsnotDefault;
	}
	
	public void setMerchantAddressIsnotDefault(String merchantAddressIsnotDefault){
		this.merchantAddressIsnotDefault = merchantAddressIsnotDefault;
	}
	public String getMerchantAddressId(){
		return this.merchantAddressId;
	}
	
	public void setMerchantAddressId(String merchantAddressId){
		this.merchantAddressId = merchantAddressId;
	}
	
	public void setPurchasingmanagerMerchant(com.common.purchasingManager.entity.PurchasingmanagerMerchant purchasingmanagerMerchant){
		this.purchasingmanagerMerchant = purchasingmanagerMerchant;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerMerchant getPurchasingmanagerMerchant(){
		return this.purchasingmanagerMerchant;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((merchantAddressPhone == null) ? 0 : merchantAddressPhone.hashCode());
		result = prime * result + ((merchantAddressLinkman == null) ? 0 : merchantAddressLinkman.hashCode());
		result = prime * result + ((merchantAddressAddress == null) ? 0 : merchantAddressAddress.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((merchantAddressIsnotDefault == null) ? 0 : merchantAddressIsnotDefault.hashCode());
		result = prime * result + ((merchantAddressId == null) ? 0 : merchantAddressId.hashCode());
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
		final PurchasingmanagerMerchantAddress other = (PurchasingmanagerMerchantAddress) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
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
		if (merchantAddressPhone == null) {
			if (other.merchantAddressPhone != null)
				return false;
		} else if (!merchantAddressPhone.equals(other.merchantAddressPhone))
			return false;
		if (merchantAddressLinkman == null) {
			if (other.merchantAddressLinkman != null)
				return false;
		} else if (!merchantAddressLinkman.equals(other.merchantAddressLinkman))
			return false;
		if (merchantAddressAddress == null) {
			if (other.merchantAddressAddress != null)
				return false;
		} else if (!merchantAddressAddress.equals(other.merchantAddressAddress))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (merchantAddressIsnotDefault == null) {
			if (other.merchantAddressIsnotDefault != null)
				return false;
		} else if (!merchantAddressIsnotDefault.equals(other.merchantAddressIsnotDefault))
			return false;
		if (merchantAddressId == null) {
			if (other.merchantAddressId != null)
				return false;
		} else if (!merchantAddressId.equals(other.merchantAddressId))
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