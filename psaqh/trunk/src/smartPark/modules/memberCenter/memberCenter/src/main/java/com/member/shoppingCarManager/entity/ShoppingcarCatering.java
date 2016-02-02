/**
 *
 */
package com.member.shoppingCarManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -餐饮购物车
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_shoppingCar_catering")
public class ShoppingcarCatering implements Domain{
	
	private static final long serialVersionUID = -3634320706417096476L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMPANY_CATERING_ID_")
	@Length(max=36)
	private String companyCateringId;//餐饮购物车ID

	@Column(name = "COMPANY_CATERING_AMOUNT_")
	@Length(max=16)
	private String companyCateringAmount;//餐饮数量

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "COMPANY_CATERING_UNIVALENCE_")
	@Length(max=16)
	private String companyCateringUnivalence;//餐饮单价
	
	public String getCompanyCateringId(){
		return this.companyCateringId;
	}
	
	public void setCompanyCateringId(String companyCateringId){
		this.companyCateringId = companyCateringId;
	}
	public String getCompanyCateringAmount(){
		return this.companyCateringAmount;
	}
	
	public void setCompanyCateringAmount(String companyCateringAmount){
		this.companyCateringAmount = companyCateringAmount;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getCompanyCateringUnivalence(){
		return this.companyCateringUnivalence;
	}
	
	public void setCompanyCateringUnivalence(String companyCateringUnivalence){
		this.companyCateringUnivalence = companyCateringUnivalence;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCateringId == null) ? 0 : companyCateringId.hashCode());
		result = prime * result + ((companyCateringAmount == null) ? 0 : companyCateringAmount.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((companyCateringUnivalence == null) ? 0 : companyCateringUnivalence.hashCode());
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
		final ShoppingcarCatering other = (ShoppingcarCatering) obj;
		if (companyCateringId == null) {
			if (other.companyCateringId != null)
				return false;
		} else if (!companyCateringId.equals(other.companyCateringId))
			return false;
		if (companyCateringAmount == null) {
			if (other.companyCateringAmount != null)
				return false;
		} else if (!companyCateringAmount.equals(other.companyCateringAmount))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (companyCateringUnivalence == null) {
			if (other.companyCateringUnivalence != null)
				return false;
		} else if (!companyCateringUnivalence.equals(other.companyCateringUnivalence))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}