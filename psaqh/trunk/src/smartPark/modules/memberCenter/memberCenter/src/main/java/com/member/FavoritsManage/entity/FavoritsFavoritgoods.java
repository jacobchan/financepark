/**
 *
 */
package com.member.FavoritsManage.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -商品收藏表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_favorits_favoritGoods")
public class FavoritsFavoritgoods implements Domain{
	
	private static final long serialVersionUID = -8689841793197150974L;
	

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FAVORIT_GOODS_ID_")
	@Length(max=36)
	private String favoritGoodsId;//商品收藏表ID

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMMODITY_ID_")
	private PurchasingmanagerCommodity commodityId;//商品ID
	

	public String getFavoritGoodsId(){
		return this.favoritGoodsId;
	}
	
	public void setFavoritGoodsId(String favoritGoodsId){
		this.favoritGoodsId = favoritGoodsId;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
	
	
	public PurchasingmanagerCommodity getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(PurchasingmanagerCommodity commodityId) {
		this.commodityId = commodityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((favoritGoodsId == null) ? 0 : favoritGoodsId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		final FavoritsFavoritgoods other = (FavoritsFavoritgoods) obj;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (favoritGoodsId == null) {
			if (other.favoritGoodsId != null)
				return false;
		} else if (!favoritGoodsId.equals(other.favoritGoodsId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}