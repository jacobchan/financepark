/**
 *
 */
package com.member.shoppingCarManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: -企业服务购物车
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_shoppingCar_companyServer")
public class ShoppingcarCompanyserver implements Domain{
	
	private static final long serialVersionUID = 405054654136205881L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITY_ID_")
	@Length(max=36)
	private String commodityId;//商品ID

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMPANY_SERVER_ID_")
	@Length(max=36)
	private String companyServerId;//企业服务购物车ID

	@Column(name = "COMPANY_CATERING_AMOUNT_")
	@Length(max=16)
	private String companyCateringAmount;//餐饮数量

	@Column(name = "COMPANY_CATERING_UNIVALENCE_")
	@Length(max=16)
	private String companyCateringUnivalence;//餐饮单价
	
	public String getCommodityId(){
		return this.commodityId;
	}
	
	public void setCommodityId(String commodityId){
		this.commodityId = commodityId;
	}
	
	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	public String getCompanyServerId(){
		return this.companyServerId;
	}
	
	public void setCompanyServerId(String companyServerId){
		this.companyServerId = companyServerId;
	}
	public String getCompanyCateringAmount(){
		return this.companyCateringAmount;
	}
	
	public void setCompanyCateringAmount(String companyCateringAmount){
		this.companyCateringAmount = companyCateringAmount;
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
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((companyServerId == null) ? 0 : companyServerId.hashCode());
		result = prime * result + ((companyCateringAmount == null) ? 0 : companyCateringAmount.hashCode());
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
		final ShoppingcarCompanyserver other = (ShoppingcarCompanyserver) obj;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (companyServerId == null) {
			if (other.companyServerId != null)
				return false;
		} else if (!companyServerId.equals(other.companyServerId))
			return false;
		if (companyCateringAmount == null) {
			if (other.companyCateringAmount != null)
				return false;
		} else if (!companyCateringAmount.equals(other.companyCateringAmount))
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