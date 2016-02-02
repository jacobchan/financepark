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
	
	private static final long serialVersionUID = 2337514252468953833L;
	

	@Column(name = "MERCHANT_ADDRESS_ADDRESS_")
	@Length(max=256)
	private String merchantAddressAddress;//地址

	@Column(name = "MERCHANT_ADDRESS_PHONE_")
	@Length(max=16)
	private String merchantAddressPhone;//联系电话

	@Column(name = "MERCHANT_ADDRESS_ISNOT_DEFAULT_")
	@Length(max=1)
	private String merchantAddressIsnotDefault;//是否默认
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MERCHANT_ADDRESS_ID_")
	@Length(max=36)
	private String merchantAddressId;//地址ID

	@Column(name = "MERCHANT_ADDRESS_LINKMAN_")
	@Length(max=32)
	private String merchantAddressLinkman;//联系人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MERCHANT_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerMerchant purchasingmanagerMerchant;//商户ID
	
	public String getMerchantAddressAddress(){
		return this.merchantAddressAddress;
	}
	
	public void setMerchantAddressAddress(String merchantAddressAddress){
		this.merchantAddressAddress = merchantAddressAddress;
	}
	public String getMerchantAddressPhone(){
		return this.merchantAddressPhone;
	}
	
	public void setMerchantAddressPhone(String merchantAddressPhone){
		this.merchantAddressPhone = merchantAddressPhone;
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
	public String getMerchantAddressLinkman(){
		return this.merchantAddressLinkman;
	}
	
	public void setMerchantAddressLinkman(String merchantAddressLinkman){
		this.merchantAddressLinkman = merchantAddressLinkman;
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
		result = prime * result + ((merchantAddressAddress == null) ? 0 : merchantAddressAddress.hashCode());
		result = prime * result + ((merchantAddressPhone == null) ? 0 : merchantAddressPhone.hashCode());
		result = prime * result + ((merchantAddressIsnotDefault == null) ? 0 : merchantAddressIsnotDefault.hashCode());
		result = prime * result + ((merchantAddressId == null) ? 0 : merchantAddressId.hashCode());
		result = prime * result + ((merchantAddressLinkman == null) ? 0 : merchantAddressLinkman.hashCode());
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
		if (merchantAddressAddress == null) {
			if (other.merchantAddressAddress != null)
				return false;
		} else if (!merchantAddressAddress.equals(other.merchantAddressAddress))
			return false;
		if (merchantAddressPhone == null) {
			if (other.merchantAddressPhone != null)
				return false;
		} else if (!merchantAddressPhone.equals(other.merchantAddressPhone))
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
		if (merchantAddressLinkman == null) {
			if (other.merchantAddressLinkman != null)
				return false;
		} else if (!merchantAddressLinkman.equals(other.merchantAddressLinkman))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}