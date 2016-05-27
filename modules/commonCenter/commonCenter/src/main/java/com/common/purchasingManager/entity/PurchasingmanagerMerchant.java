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
	
	private static final long serialVersionUID = -7613866920193893382L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MERCHANT_RETURN_ADDRESS_")
	@Length(max=256)
	private String merchantReturnAddress;//退货地址

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MERCHANT_ID_")
	@Length(max=36)
	private String merchantId;//商户ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "MERCHANT_LINKMAN_PHONE_")
	@Length(max=16)
	private String merchantLinkmanPhone;//联系人电话

	@Column(name = "MERCHANT_LINKMAN_")
	@Length(max=32)
	private String merchantLinkman;//联系人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MERCHANT_TYPE_")
	private PurchasingmanagerGenre merchantType;//商户类型ID

	@Column(name = "MERCHANT_NAME_")
	@Length(max=128)
	private String merchantName;//商户名称

	@Column(name = "MERCHANT_ENTERPRISE_NAME_")
	@Length(max=128)
	private String merchantEnterpriseName;//企业名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "MERCHANT_SEND_ADDRESS_")
	@Length(max=256)
	private String merchantSendAddress;//发货地址
	
	@Column(name = "MERCHANT_LOGO_")
	@Length(max=256)
	private String merchantLogo;//商户LOGO
	
	@Column(name = "MERCHANT_URL_")
	@Length(max=256)
	private String merchantUrl;//商户网址
	
	@Column(name = "MERCHANT_ABOUT_")
	@Length(max=2048)
	private String merchantAbout;//商户简介
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

	public String getMerchantUrl() {
		return merchantUrl;
	}

	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}

	public String getMerchantAbout() {
		return merchantAbout;
	}

	public void setMerchantAbout(String merchantAbout) {
		this.merchantAbout = merchantAbout;
	}

	public String getMerchantLogo() {
		return merchantLogo;
	}

	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
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
	public String getMerchantReturnAddress(){
		return this.merchantReturnAddress;
	}
	
	public void setMerchantReturnAddress(String merchantReturnAddress){
		this.merchantReturnAddress = merchantReturnAddress;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
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
	public String getMerchantLinkmanPhone(){
		return this.merchantLinkmanPhone;
	}
	
	public void setMerchantLinkmanPhone(String merchantLinkmanPhone){
		this.merchantLinkmanPhone = merchantLinkmanPhone;
	}
	public String getMerchantLinkman(){
		return this.merchantLinkman;
	}
	
	public void setMerchantLinkman(String merchantLinkman){
		this.merchantLinkman = merchantLinkman;
	}

	public PurchasingmanagerGenre getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(PurchasingmanagerGenre merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantName(){
		return this.merchantName;
	}
	
	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}
	public String getMerchantEnterpriseName(){
		return this.merchantEnterpriseName;
	}
	
	public void setMerchantEnterpriseName(String merchantEnterpriseName){
		this.merchantEnterpriseName = merchantEnterpriseName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
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
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((merchantReturnAddress == null) ? 0 : merchantReturnAddress.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((merchantLinkmanPhone == null) ? 0 : merchantLinkmanPhone.hashCode());
		result = prime * result + ((merchantLinkman == null) ? 0 : merchantLinkman.hashCode());
		result = prime * result + ((merchantType == null) ? 0 : merchantType.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((merchantEnterpriseName == null) ? 0 : merchantEnterpriseName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((merchantSendAddress == null) ? 0 : merchantSendAddress.hashCode());
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
		final PurchasingmanagerMerchant other = (PurchasingmanagerMerchant) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (merchantReturnAddress == null) {
			if (other.merchantReturnAddress != null)
				return false;
		} else if (!merchantReturnAddress.equals(other.merchantReturnAddress))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
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
		if (merchantLinkmanPhone == null) {
			if (other.merchantLinkmanPhone != null)
				return false;
		} else if (!merchantLinkmanPhone.equals(other.merchantLinkmanPhone))
			return false;
		if (merchantLinkman == null) {
			if (other.merchantLinkman != null)
				return false;
		} else if (!merchantLinkman.equals(other.merchantLinkman))
			return false;
		if (merchantType == null) {
			if (other.merchantType != null)
				return false;
		} else if (!merchantType.equals(other.merchantType))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (merchantEnterpriseName == null) {
			if (other.merchantEnterpriseName != null)
				return false;
		} else if (!merchantEnterpriseName.equals(other.merchantEnterpriseName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (merchantSendAddress == null) {
			if (other.merchantSendAddress != null)
				return false;
		} else if (!merchantSendAddress.equals(other.merchantSendAddress))
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