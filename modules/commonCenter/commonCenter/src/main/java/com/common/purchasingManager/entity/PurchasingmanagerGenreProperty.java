/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品类属性
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_genre_property")
public class PurchasingmanagerGenreProperty implements Domain{
	
	private static final long serialVersionUID = -2535008294852660613L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "GENRE_PROPERTY_FIELD_NAME_")
	@Length(max=128)
	private String genrePropertyFieldName;//字段名称

	@Column(name = "GENRE_PROPERTY_ISNOT_DISPLAY_")
	@Length(max=1)
	private String genrePropertyIsnotDisplay;//是否显示

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "GENRE_PROPERTY_ID_")
	@Length(max=36)
	private String genrePropertyId;//商品类别属性序列

	@Column(name = "GENRE_PROPERTY_DISPLAY_NAME_")
	@Length(max=128)
	private String genrePropertyDisplayName;//显示名称

	@Column(name = "GENRE_PROPERTY_DEFAULT_VALUE_")
	@Length(max=128)
	private String genrePropertyDefaultValue;//默认值

	@Column(name = "GENRE_PROPERTY_FIELD_TYPE_")
	@Length(max=2)
	private String genrePropertyFieldType;//字段类型

	@Column(name = "GENRE_PROPERTY_ISNOT_MUST_")
	@Length(max=1)
	private String genrePropertyIsnotMust;//是否必须

	@Column(name = "GENRE_PROPERTY_FIELD_LENGTH_")
	private String genrePropertyFieldLength;//字段长度

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENRE_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre;//商品类别ID
	
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getGenrePropertyFieldName(){
		return this.genrePropertyFieldName;
	}
	
	public void setGenrePropertyFieldName(String genrePropertyFieldName){
		this.genrePropertyFieldName = genrePropertyFieldName;
	}
	public String getGenrePropertyIsnotDisplay(){
		return this.genrePropertyIsnotDisplay;
	}
	
	public void setGenrePropertyIsnotDisplay(String genrePropertyIsnotDisplay){
		this.genrePropertyIsnotDisplay = genrePropertyIsnotDisplay;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getGenrePropertyId(){
		return this.genrePropertyId;
	}
	
	public void setGenrePropertyId(String genrePropertyId){
		this.genrePropertyId = genrePropertyId;
	}
	public String getGenrePropertyDisplayName(){
		return this.genrePropertyDisplayName;
	}
	
	public void setGenrePropertyDisplayName(String genrePropertyDisplayName){
		this.genrePropertyDisplayName = genrePropertyDisplayName;
	}
	public String getGenrePropertyDefaultValue(){
		return this.genrePropertyDefaultValue;
	}
	
	public void setGenrePropertyDefaultValue(String genrePropertyDefaultValue){
		this.genrePropertyDefaultValue = genrePropertyDefaultValue;
	}
	public String getGenrePropertyFieldType(){
		return this.genrePropertyFieldType;
	}
	
	public void setGenrePropertyFieldType(String genrePropertyFieldType){
		this.genrePropertyFieldType = genrePropertyFieldType;
	}
	public String getGenrePropertyIsnotMust(){
		return this.genrePropertyIsnotMust;
	}
	
	public void setGenrePropertyIsnotMust(String genrePropertyIsnotMust){
		this.genrePropertyIsnotMust = genrePropertyIsnotMust;
	}
	public String getGenrePropertyFieldLength(){
		return this.genrePropertyFieldLength;
	}
	
	public void setGenrePropertyFieldLength(String genrePropertyFieldLength){
		this.genrePropertyFieldLength = genrePropertyFieldLength;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	
	public void setPurchasingmanagerGenre(com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre){
		this.purchasingmanagerGenre = purchasingmanagerGenre;
	}
	
	public com.common.purchasingManager.entity.PurchasingmanagerGenre getPurchasingmanagerGenre(){
		return this.purchasingmanagerGenre;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((genrePropertyFieldName == null) ? 0 : genrePropertyFieldName.hashCode());
		result = prime * result + ((genrePropertyIsnotDisplay == null) ? 0 : genrePropertyIsnotDisplay.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((genrePropertyId == null) ? 0 : genrePropertyId.hashCode());
		result = prime * result + ((genrePropertyDisplayName == null) ? 0 : genrePropertyDisplayName.hashCode());
		result = prime * result + ((genrePropertyDefaultValue == null) ? 0 : genrePropertyDefaultValue.hashCode());
		result = prime * result + ((genrePropertyFieldType == null) ? 0 : genrePropertyFieldType.hashCode());
		result = prime * result + ((genrePropertyIsnotMust == null) ? 0 : genrePropertyIsnotMust.hashCode());
		result = prime * result + ((genrePropertyFieldLength == null) ? 0 : genrePropertyFieldLength.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
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
		final PurchasingmanagerGenreProperty other = (PurchasingmanagerGenreProperty) obj;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (genrePropertyFieldName == null) {
			if (other.genrePropertyFieldName != null)
				return false;
		} else if (!genrePropertyFieldName.equals(other.genrePropertyFieldName))
			return false;
		if (genrePropertyIsnotDisplay == null) {
			if (other.genrePropertyIsnotDisplay != null)
				return false;
		} else if (!genrePropertyIsnotDisplay.equals(other.genrePropertyIsnotDisplay))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (genrePropertyId == null) {
			if (other.genrePropertyId != null)
				return false;
		} else if (!genrePropertyId.equals(other.genrePropertyId))
			return false;
		if (genrePropertyDisplayName == null) {
			if (other.genrePropertyDisplayName != null)
				return false;
		} else if (!genrePropertyDisplayName.equals(other.genrePropertyDisplayName))
			return false;
		if (genrePropertyDefaultValue == null) {
			if (other.genrePropertyDefaultValue != null)
				return false;
		} else if (!genrePropertyDefaultValue.equals(other.genrePropertyDefaultValue))
			return false;
		if (genrePropertyFieldType == null) {
			if (other.genrePropertyFieldType != null)
				return false;
		} else if (!genrePropertyFieldType.equals(other.genrePropertyFieldType))
			return false;
		if (genrePropertyIsnotMust == null) {
			if (other.genrePropertyIsnotMust != null)
				return false;
		} else if (!genrePropertyIsnotMust.equals(other.genrePropertyIsnotMust))
			return false;
		if (genrePropertyFieldLength == null) {
			if (other.genrePropertyFieldLength != null)
				return false;
		} else if (!genrePropertyFieldLength.equals(other.genrePropertyFieldLength))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}