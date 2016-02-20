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
 * 实体: -集采购物车
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_shoppingCar_group")
public class ShoppingcarGroup implements Domain{
	
	private static final long serialVersionUID = -2910584878725934028L;
	

	@Column(name = "COMPANY_CATERING_UNIVALENCE_")
	@Length(max=16)
	private String companyCateringUnivalence;//餐饮单价

	@Column(name = "COMPANY_GROUP_COLLECT_STATUS_")
	@Length(max=1)
	private String companyGroupCollectStatus;//集采是否收藏
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
	@Column(name = "COMPANY_GROUP_ID_")
	@Length(max=36)
	private String companyGroupId;//集采购物车ID

	@Column(name = "COMPANY_CATERING_AMOUNT_")
	@Length(max=16)
	private String companyCateringAmount;//餐饮数量
	
	public String getCompanyCateringUnivalence(){
		return this.companyCateringUnivalence;
	}
	
	public void setCompanyCateringUnivalence(String companyCateringUnivalence){
		this.companyCateringUnivalence = companyCateringUnivalence;
	}
	public String getCompanyGroupCollectStatus(){
		return this.companyGroupCollectStatus;
	}
	
	public void setCompanyGroupCollectStatus(String companyGroupCollectStatus){
		this.companyGroupCollectStatus = companyGroupCollectStatus;
	}
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

	public String getCompanyGroupId(){
		return this.companyGroupId;
	}
	
	public void setCompanyGroupId(String companyGroupId){
		this.companyGroupId = companyGroupId;
	}
	public String getCompanyCateringAmount(){
		return this.companyCateringAmount;
	}
	
	public void setCompanyCateringAmount(String companyCateringAmount){
		this.companyCateringAmount = companyCateringAmount;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCateringUnivalence == null) ? 0 : companyCateringUnivalence.hashCode());
		result = prime * result + ((companyGroupCollectStatus == null) ? 0 : companyGroupCollectStatus.hashCode());
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((companyGroupId == null) ? 0 : companyGroupId.hashCode());
		result = prime * result + ((companyCateringAmount == null) ? 0 : companyCateringAmount.hashCode());
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
		final ShoppingcarGroup other = (ShoppingcarGroup) obj;
		if (companyCateringUnivalence == null) {
			if (other.companyCateringUnivalence != null)
				return false;
		} else if (!companyCateringUnivalence.equals(other.companyCateringUnivalence))
			return false;
		if (companyGroupCollectStatus == null) {
			if (other.companyGroupCollectStatus != null)
				return false;
		} else if (!companyGroupCollectStatus.equals(other.companyGroupCollectStatus))
			return false;
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
		if (companyGroupId == null) {
			if (other.companyGroupId != null)
				return false;
		} else if (!companyGroupId.equals(other.companyGroupId))
			return false;
		if (companyCateringAmount == null) {
			if (other.companyCateringAmount != null)
				return false;
		} else if (!companyCateringAmount.equals(other.companyCateringAmount))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}