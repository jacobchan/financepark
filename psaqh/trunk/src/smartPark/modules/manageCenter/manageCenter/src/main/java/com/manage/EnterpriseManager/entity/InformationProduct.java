/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 产品信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_product")
public class InformationProduct implements Domain{
	
	private static final long serialVersionUID = 822382060365811351L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PRODUCT_ID_")
	@Length(max=36)
	private String productId;//ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "PRODUCT_TYPE_")
	@Length(max=2)
	private String productType;//产品类别

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID2

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "PRODUCT_RE_")
	@Length(max=32)
	private String productRe;//企业ID

	@Column(name = "PRODUCT_CONTENT_")
	@Length(max=256)
	private String productContent;//产品描述

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "PRODUCT_NAME_")
	@Length(max=64)
	private String productName;//产品名称

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "PRODUCT_BROWSE_COUNT_")
	@Length(max=20)
	private Integer productBrowseCount;//产品浏览次数

	@Column(name = "PRODUCT_COLLECTION_COUNT_")
	@Length(max=20)
	private Integer productCollectionCount;//产品收藏次数
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
	public Integer getProductBrowseCount() {
		return productBrowseCount;
	}

	public void setProductBrowseCount(Integer productBrowseCount) {
		this.productBrowseCount = productBrowseCount;
	}

	public Integer getProductCollectionCount() {
		return productCollectionCount;
	}

	public void setProductCollectionCount(Integer productCollectionCount) {
		this.productCollectionCount = productCollectionCount;
	}

	public String getProductId(){
		return this.productId;
	}
	
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getProductType(){
		return this.productType;
	}
	
	public void setProductType(String productType){
		this.productType = productType;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getProductRe(){
		return this.productRe;
	}
	
	public void setProductRe(String productRe){
		this.productRe = productRe;
	}
	public String getProductContent(){
		return this.productContent;
	}
	
	public void setProductContent(String productContent){
		this.productContent = productContent;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getProductName(){
		return this.productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((productRe == null) ? 0 : productRe.hashCode());
		result = prime * result + ((productContent == null) ? 0 : productContent.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		final InformationProduct other = (InformationProduct) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (productRe == null) {
			if (other.productRe != null)
				return false;
		} else if (!productRe.equals(other.productRe))
			return false;
		if (productContent == null) {
			if (other.productContent != null)
				return false;
		} else if (!productContent.equals(other.productContent))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
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