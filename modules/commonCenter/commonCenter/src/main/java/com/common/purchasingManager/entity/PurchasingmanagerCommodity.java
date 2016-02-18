/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_commodity")
public class PurchasingmanagerCommodity implements Domain{
	
	private static final long serialVersionUID = -8892744983342179078L;
	

	@Column(name = "COMPANY_SERVER_ID_")
	@Length(max=36)
	private String companyServerId;//企业服务购物车ID

	@Column(name = "COMMODITY_DESCRIBE_")
	private String commodityDescribe;//描述

	@Column(name = "COMMODITY_IMAGE_")
	@Length(max=256)
	private String commodityImage;//图像
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_ID_")
	@Length(max=36)
	private String commodityId;//商品ID

	@Column(name = "COMMODITY_TITLE_")
	@Length(max=128)
	private String commodityTitle;//标题
	
	@Column(name = "COMMODITY_BRAND_")
	@Length(max=128)
	private String commodityBrand;//品牌

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型

	@Column(name = "FAVORIT_GOODS_ID_")
	@Length(max=36)
	private String favoritGoodsId;//商品收藏表ID

	@Column(name = "COMMODITY_HIGHEST_PRICE_")
	@Length(max=10)
	private String commodityHighestPrice;//最高价

	@Column(name = "COMMODITY_ISNOT_DISPLAY_STOCK_")
	@Length(max=1)
	private String commodityIsnotDisplayStock;//是否显示库存

	@Column(name = "COMPANY_CATERING_ID_")
	@Length(max=36)
	private String companyCateringId;//餐饮购物车ID

	@Column(name = "COMMODITY_PRICE_")
	@Length(max=10)
	private String commodityPrice;//标价

	@Column(name = "COMMODITY_COVER_IMAGE_")
	@Length(max=256)
	private String commodityCoverImage;//封面图片

	@Column(name = "COMMODITY_ORIGINAL_PRICE_")
	@Length(max=10)
	private String commodityOriginalPrice;//原价

	@Column(name = "COMMODITY_DOWN_TIME_")
	@Length(max=20)
	private String commodityDownTime;//下架时间

	@Column(name = "COMPANY_GROUP_ID_")
	@Length(max=36)
	private String companyGroupId;//集采购物车ID

	@Column(name = "COMMODITY_LOWEST_PRICE_")
	@Length(max=10)
	private String commodityLowestPrice;//最低价

	@Column(name = "COMMODITY_UP_TIME_")
	@Length(max=20)
	private String commodityUpTime;//上架时间

	@Column(name = "COMMODITY_STOCK_")
	private String commodityStock;//库存
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MERCHANT_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerMerchant purchasingmanagerMerchant;//商户ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENRE_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre;//商业类别ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCategory purchasingmanagerCategory;//类目ID
	
	public String getCompanyServerId(){
		return this.companyServerId;
	}
	
	public void setCompanyServerId(String companyServerId){
		this.companyServerId = companyServerId;
	}
	public String getCommodityDescribe(){
		return this.commodityDescribe;
	}
	
	public void setCommodityDescribe(String commodityDescribe){
		this.commodityDescribe = commodityDescribe;
	}
	public String getCommodityImage(){
		return this.commodityImage;
	}
	
	public void setCommodityImage(String commodityImage){
		this.commodityImage = commodityImage;
	}
	public String getCommodityId(){
		return this.commodityId;
	}
	
	public void setCommodityId(String commodityId){
		this.commodityId = commodityId;
	}
	public String getCommodityTitle(){
		return this.commodityTitle;
	}
	
	public void setCommodityTitle(String commodityTitle){
		this.commodityTitle = commodityTitle;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	public String getFavoritGoodsId(){
		return this.favoritGoodsId;
	}
	
	public void setFavoritGoodsId(String favoritGoodsId){
		this.favoritGoodsId = favoritGoodsId;
	}
	public String getCommodityHighestPrice(){
		return this.commodityHighestPrice;
	}
	
	public void setCommodityHighestPrice(String commodityHighestPrice){
		this.commodityHighestPrice = commodityHighestPrice;
	}
	public String getCommodityIsnotDisplayStock(){
		return this.commodityIsnotDisplayStock;
	}
	
	public void setCommodityIsnotDisplayStock(String commodityIsnotDisplayStock){
		this.commodityIsnotDisplayStock = commodityIsnotDisplayStock;
	}
	public String getCompanyCateringId(){
		return this.companyCateringId;
	}
	
	public void setCompanyCateringId(String companyCateringId){
		this.companyCateringId = companyCateringId;
	}
	public String getCommodityPrice(){
		return this.commodityPrice;
	}
	
	public void setCommodityPrice(String commodityPrice){
		this.commodityPrice = commodityPrice;
	}
	public String getCommodityCoverImage(){
		return this.commodityCoverImage;
	}
	
	public void setCommodityCoverImage(String commodityCoverImage){
		this.commodityCoverImage = commodityCoverImage;
	}
	public String getCommodityOriginalPrice(){
		return this.commodityOriginalPrice;
	}
	
	public void setCommodityOriginalPrice(String commodityOriginalPrice){
		this.commodityOriginalPrice = commodityOriginalPrice;
	}
	public String getCommodityDownTime(){
		return this.commodityDownTime;
	}
	
	public void setCommodityDownTime(String commodityDownTime){
		this.commodityDownTime = commodityDownTime;
	}
	public String getCompanyGroupId(){
		return this.companyGroupId;
	}
	
	public void setCompanyGroupId(String companyGroupId){
		this.companyGroupId = companyGroupId;
	}
	public String getCommodityLowestPrice(){
		return this.commodityLowestPrice;
	}
	
	public void setCommodityLowestPrice(String commodityLowestPrice){
		this.commodityLowestPrice = commodityLowestPrice;
	}
	public String getCommodityUpTime(){
		return this.commodityUpTime;
	}
	
	public String getCommodityBrand() {
		return commodityBrand;
	}

	public void setCommodityBrand(String commodityBrand) {
		this.commodityBrand = commodityBrand;
	}

	public void setCommodityUpTime(String commodityUpTime){
		this.commodityUpTime = commodityUpTime;
	}
	public String getCommodityStock(){
		return this.commodityStock;
	}
	
	public void setCommodityStock(String commodityStock){
		this.commodityStock = commodityStock;
	}
	
	public void setPurchasingmanagerMerchant(com.common.purchasingManager.entity.PurchasingmanagerMerchant purchasingmanagerMerchant){
		this.purchasingmanagerMerchant = purchasingmanagerMerchant;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerMerchant getPurchasingmanagerMerchant(){
		return this.purchasingmanagerMerchant;
	}
	public void setPurchasingmanagerGenre(com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre){
		this.purchasingmanagerGenre = purchasingmanagerGenre;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerGenre getPurchasingmanagerGenre(){
		return this.purchasingmanagerGenre;
	}
	public void setPurchasingmanagerCategory(com.common.purchasingManager.entity.PurchasingmanagerCategory purchasingmanagerCategory){
		this.purchasingmanagerCategory = purchasingmanagerCategory;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerCategory getPurchasingmanagerCategory(){
		return this.purchasingmanagerCategory;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodityBrand == null) ? 0 : commodityBrand.hashCode());
		result = prime
				* result
				+ ((commodityCoverImage == null) ? 0 : commodityCoverImage
						.hashCode());
		result = prime
				* result
				+ ((commodityDescribe == null) ? 0 : commodityDescribe
						.hashCode());
		result = prime
				* result
				+ ((commodityDownTime == null) ? 0 : commodityDownTime
						.hashCode());
		result = prime
				* result
				+ ((commodityHighestPrice == null) ? 0 : commodityHighestPrice
						.hashCode());
		result = prime * result
				+ ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result
				+ ((commodityImage == null) ? 0 : commodityImage.hashCode());
		result = prime
				* result
				+ ((commodityIsnotDisplayStock == null) ? 0
						: commodityIsnotDisplayStock.hashCode());
		result = prime
				* result
				+ ((commodityLowestPrice == null) ? 0 : commodityLowestPrice
						.hashCode());
		result = prime
				* result
				+ ((commodityOriginalPrice == null) ? 0
						: commodityOriginalPrice.hashCode());
		result = prime * result
				+ ((commodityPrice == null) ? 0 : commodityPrice.hashCode());
		result = prime * result
				+ ((commodityStock == null) ? 0 : commodityStock.hashCode());
		result = prime * result
				+ ((commodityTitle == null) ? 0 : commodityTitle.hashCode());
		result = prime * result
				+ ((commodityUpTime == null) ? 0 : commodityUpTime.hashCode());
		result = prime
				* result
				+ ((companyCateringId == null) ? 0 : companyCateringId
						.hashCode());
		result = prime * result
				+ ((companyGroupId == null) ? 0 : companyGroupId.hashCode());
		result = prime * result
				+ ((companyServerId == null) ? 0 : companyServerId.hashCode());
		result = prime * result
				+ ((favoritGoodsId == null) ? 0 : favoritGoodsId.hashCode());
		result = prime
				* result
				+ ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime
				* result
				+ ((purchasingmanagerCategory == null) ? 0
						: purchasingmanagerCategory.hashCode());
		result = prime
				* result
				+ ((purchasingmanagerGenre == null) ? 0
						: purchasingmanagerGenre.hashCode());
		result = prime
				* result
				+ ((purchasingmanagerMerchant == null) ? 0
						: purchasingmanagerMerchant.hashCode());
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
		PurchasingmanagerCommodity other = (PurchasingmanagerCommodity) obj;
		if (commodityBrand == null) {
			if (other.commodityBrand != null)
				return false;
		} else if (!commodityBrand.equals(other.commodityBrand))
			return false;
		if (commodityCoverImage == null) {
			if (other.commodityCoverImage != null)
				return false;
		} else if (!commodityCoverImage.equals(other.commodityCoverImage))
			return false;
		if (commodityDescribe == null) {
			if (other.commodityDescribe != null)
				return false;
		} else if (!commodityDescribe.equals(other.commodityDescribe))
			return false;
		if (commodityDownTime == null) {
			if (other.commodityDownTime != null)
				return false;
		} else if (!commodityDownTime.equals(other.commodityDownTime))
			return false;
		if (commodityHighestPrice == null) {
			if (other.commodityHighestPrice != null)
				return false;
		} else if (!commodityHighestPrice.equals(other.commodityHighestPrice))
			return false;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (commodityImage == null) {
			if (other.commodityImage != null)
				return false;
		} else if (!commodityImage.equals(other.commodityImage))
			return false;
		if (commodityIsnotDisplayStock == null) {
			if (other.commodityIsnotDisplayStock != null)
				return false;
		} else if (!commodityIsnotDisplayStock
				.equals(other.commodityIsnotDisplayStock))
			return false;
		if (commodityLowestPrice == null) {
			if (other.commodityLowestPrice != null)
				return false;
		} else if (!commodityLowestPrice.equals(other.commodityLowestPrice))
			return false;
		if (commodityOriginalPrice == null) {
			if (other.commodityOriginalPrice != null)
				return false;
		} else if (!commodityOriginalPrice.equals(other.commodityOriginalPrice))
			return false;
		if (commodityPrice == null) {
			if (other.commodityPrice != null)
				return false;
		} else if (!commodityPrice.equals(other.commodityPrice))
			return false;
		if (commodityStock == null) {
			if (other.commodityStock != null)
				return false;
		} else if (!commodityStock.equals(other.commodityStock))
			return false;
		if (commodityTitle == null) {
			if (other.commodityTitle != null)
				return false;
		} else if (!commodityTitle.equals(other.commodityTitle))
			return false;
		if (commodityUpTime == null) {
			if (other.commodityUpTime != null)
				return false;
		} else if (!commodityUpTime.equals(other.commodityUpTime))
			return false;
		if (companyCateringId == null) {
			if (other.companyCateringId != null)
				return false;
		} else if (!companyCateringId.equals(other.companyCateringId))
			return false;
		if (companyGroupId == null) {
			if (other.companyGroupId != null)
				return false;
		} else if (!companyGroupId.equals(other.companyGroupId))
			return false;
		if (companyServerId == null) {
			if (other.companyServerId != null)
				return false;
		} else if (!companyServerId.equals(other.companyServerId))
			return false;
		if (favoritGoodsId == null) {
			if (other.favoritGoodsId != null)
				return false;
		} else if (!favoritGoodsId.equals(other.favoritGoodsId))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		if (purchasingmanagerCategory == null) {
			if (other.purchasingmanagerCategory != null)
				return false;
		} else if (!purchasingmanagerCategory
				.equals(other.purchasingmanagerCategory))
			return false;
		if (purchasingmanagerGenre == null) {
			if (other.purchasingmanagerGenre != null)
				return false;
		} else if (!purchasingmanagerGenre.equals(other.purchasingmanagerGenre))
			return false;
		if (purchasingmanagerMerchant == null) {
			if (other.purchasingmanagerMerchant != null)
				return false;
		} else if (!purchasingmanagerMerchant
				.equals(other.purchasingmanagerMerchant))
			return false;
		return true;
	}

	public String toString(){
		return super.toString();
	}
}