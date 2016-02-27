/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品类目表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_category")
public class PurchasingmanagerCategory implements Domain{
	
	private static final long serialVersionUID = -529074261216405026L;
	

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CATEGORY_NAME_")
	@Length(max=128)
	private String categoryName;//类目名称

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "CATEGORY_ID_")
	@Length(max=36)
	private String categoryId;//类目ID

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CATEGORY_ISNOT_ENABLE_")
	@Length(max=1)
	private String categoryIsnotEnable;//是否启用
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__CATEGORY_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerCategory purchasingmanagerCategory;//320_类目ID
	
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCategoryName(){
		return this.categoryName;
	}
	
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
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
	public String getCategoryIsnotEnable(){
		return this.categoryIsnotEnable;
	}
	
	public void setCategoryIsnotEnable(String categoryIsnotEnable){
		this.categoryIsnotEnable = categoryIsnotEnable;
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
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((categoryIsnotEnable == null) ? 0 : categoryIsnotEnable.hashCode());
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
		final PurchasingmanagerCategory other = (PurchasingmanagerCategory) obj;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
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
		if (categoryIsnotEnable == null) {
			if (other.categoryIsnotEnable != null)
				return false;
		} else if (!categoryIsnotEnable.equals(other.categoryIsnotEnable))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}