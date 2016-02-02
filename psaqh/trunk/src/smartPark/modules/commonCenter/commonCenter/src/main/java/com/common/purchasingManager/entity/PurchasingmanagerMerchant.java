/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商户信息表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_merchant")
public class PurchasingmanagerMerchant implements Domain{
	
	private static final long serialVersionUID = -3588403812506515613L;
	

	@Column(name = "MERCHANT_RETURN_ADDRESS_")
	@Length(max=256)
	private String merchantReturnAddress;//退货地址

	@Column(name = "MERCHANT_LINKMAN_")
	@Length(max=32)
	private String merchantLinkman;//联系人

	@Column(name = "MERCHANT_LINKMAN_PHONE_")
	@Length(max=16)
	private String merchantLinkmanPhone;//联系人电话

	@Column(name = "MERCHANT_TYPE_")
	@Length(max=2)
	private String merchantType;//商户类型

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型

	@Column(name = "MERCHANT_ENTERPRISE_NAME_")
	@Length(max=128)
	private String merchantEnterpriseName;//企业名称

	@Column(name = "MERCHANT_NAME_")
	@Length(max=128)
	private String merchantName;//商户名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MERCHANT_ID_")
	@Length(max=36)
	private String merchantId;//商户ID

	@Column(name = "MERCHANT_SEND_ADDRESS_")
	@Length(max=256)
	private String merchantSendAddress;//发货地址
	
	public String getMerchantReturnAddress(){
		return this.merchantReturnAddress;
	}
	
	public void setMerchantReturnAddress(String merchantReturnAddress){
		this.merchantReturnAddress = merchantReturnAddress;
	}
	public String getMerchantLinkman(){
		return this.merchantLinkman;
	}
	
	public void setMerchantLinkman(String merchantLinkman){
		this.merchantLinkman = merchantLinkman;
	}
	public String getMerchantLinkmanPhone(){
		return this.merchantLinkmanPhone;
	}
	
	public void setMerchantLinkmanPhone(String merchantLinkmanPhone){
		this.merchantLinkmanPhone = merchantLinkmanPhone;
	}
	public String getMerchantType(){
		return this.merchantType;
	}
	
	public void setMerchantType(String merchantType){
		this.merchantType = merchantType;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	public String getMerchantEnterpriseName(){
		return this.merchantEnterpriseName;
	}
	
	public void setMerchantEnterpriseName(String merchantEnterpriseName){
		this.merchantEnterpriseName = merchantEnterpriseName;
	}
	public String getMerchantName(){
		return this.merchantName;
	}
	
	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}
	public String getMerchantId(){
		return this.merchantId;
	}
	
	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}
	public String getMerchantSendAddress(){
		return this.merchantSendAddress;
	}
	
	public void setMerchantSendAddress(String merchantSendAddress){
		this.merchantSendAddress = merchantSendAddress;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((merchantReturnAddress == null) ? 0 : merchantReturnAddress.hashCode());
		result = prime * result + ((merchantLinkman == null) ? 0 : merchantLinkman.hashCode());
		result = prime * result + ((merchantLinkmanPhone == null) ? 0 : merchantLinkmanPhone.hashCode());
		result = prime * result + ((merchantType == null) ? 0 : merchantType.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((merchantEnterpriseName == null) ? 0 : merchantEnterpriseName.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((merchantSendAddress == null) ? 0 : merchantSendAddress.hashCode());
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
		final PurchasingmanagerMerchant other = (PurchasingmanagerMerchant) obj;
		if (merchantReturnAddress == null) {
			if (other.merchantReturnAddress != null)
				return false;
		} else if (!merchantReturnAddress.equals(other.merchantReturnAddress))
			return false;
		if (merchantLinkman == null) {
			if (other.merchantLinkman != null)
				return false;
		} else if (!merchantLinkman.equals(other.merchantLinkman))
			return false;
		if (merchantLinkmanPhone == null) {
			if (other.merchantLinkmanPhone != null)
				return false;
		} else if (!merchantLinkmanPhone.equals(other.merchantLinkmanPhone))
			return false;
		if (merchantType == null) {
			if (other.merchantType != null)
				return false;
		} else if (!merchantType.equals(other.merchantType))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		if (merchantEnterpriseName == null) {
			if (other.merchantEnterpriseName != null)
				return false;
		} else if (!merchantEnterpriseName.equals(other.merchantEnterpriseName))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (merchantSendAddress == null) {
			if (other.merchantSendAddress != null)
				return false;
		} else if (!merchantSendAddress.equals(other.merchantSendAddress))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}