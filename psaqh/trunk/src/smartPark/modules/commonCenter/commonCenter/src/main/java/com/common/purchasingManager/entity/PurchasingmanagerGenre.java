/**
 *
 */
package com.common.purchasingManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 商品类别表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_purchasingManager_genre")
public class PurchasingmanagerGenre implements Domain{
	
	private static final long serialVersionUID = -2791475623901105243L;
	

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "GENRE_ID_")
	@Length(max=36)
	private String genreId;//商品类别ID

	@Column(name = "GENRE_NAME_")
	@Length(max=128)
	private String genreName;//商品类别名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "GENRE_CODE_")
	@Length(max=10)
	private String genreCode;//商品类别Code

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "GENRE_MODULE_URL_")
	@Length(max=256)
	private String genreModuleUrl;//表单模板地址

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sp__GENRE_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre;//320_商品类别ID
	
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	public String getGenreId(){
		return this.genreId;
	}
	
	public void setGenreId(String genreId){
		this.genreId = genreId;
	}
	public String getGenreName(){
		return this.genreName;
	}
	
	public void setGenreName(String genreName){
		this.genreName = genreName;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getGenreCode(){
		return this.genreCode;
	}
	
	public void setGenreCode(String genreCode){
		this.genreCode = genreCode;
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
	public String getGenreModuleUrl(){
		return this.genreModuleUrl;
	}
	
	public void setGenreModuleUrl(String genreModuleUrl){
		this.genreModuleUrl = genreModuleUrl;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
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
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((genreCode == null) ? 0 : genreCode.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((genreModuleUrl == null) ? 0 : genreModuleUrl.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		final PurchasingmanagerGenre other = (PurchasingmanagerGenre) obj;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (genreCode == null) {
			if (other.genreCode != null)
				return false;
		} else if (!genreCode.equals(other.genreCode))
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
		if (genreModuleUrl == null) {
			if (other.genreModuleUrl != null)
				return false;
		} else if (!genreModuleUrl.equals(other.genreModuleUrl))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}