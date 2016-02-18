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
	
	private static final long serialVersionUID = 7357801827477307138L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "GENRE_ID_")
	@Length(max=36)
	private String genreId;//商业类别ID

	@Column(name = "PARK_BUSINESS_TUPE_")
	@Length(max=2)
	private String parkBusinessTupe;//园区商业类型

	@Column(name = "GENRE_NAME_")
	@Length(max=128)
	private String genreName;//商业类别名称
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp_GENRE_ID_")
	private com.common.purchasingManager.entity.PurchasingmanagerGenre purchasingmanagerGenre;//320_商业类别ID
	
	public String getGenreId(){
		return this.genreId;
	}
	
	public void setGenreId(String genreId){
		this.genreId = genreId;
	}
	public String getParkBusinessTupe(){
		return this.parkBusinessTupe;
	}
	
	public void setParkBusinessTupe(String parkBusinessTupe){
		this.parkBusinessTupe = parkBusinessTupe;
	}
	public String getGenreName(){
		return this.genreName;
	}
	
	public void setGenreName(String genreName){
		this.genreName = genreName;
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
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((parkBusinessTupe == null) ? 0 : parkBusinessTupe.hashCode());
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
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
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (parkBusinessTupe == null) {
			if (other.parkBusinessTupe != null)
				return false;
		} else if (!parkBusinessTupe.equals(other.parkBusinessTupe))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}