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
 * 实体: -餐饮购物车
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_shoppingCar_catering")
public class ShoppingcarCatering implements Domain{
	
	private static final long serialVersionUID = 180614955197918113L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMMODITY_ID_")
	private MemberInformation commodityId;//商品ID
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMPANY_CATERING_ID_")
	@Length(max=36)
	private String companyCateringId;//餐饮购物车ID

	@Column(name = "COMPANY_CATERING_AMOUNT_")
	@Length(max=16)
	private String companyCateringAmount;//餐饮数量

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "COMPANY_CATERING_UNIVALENCE_")
	@Length(max=16)
	private String companyCateringUnivalence;//餐饮单价
	
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
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	public MemberInformation getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(MemberInformation commodityId) {
		this.commodityId = commodityId;
	}

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
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
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
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((companyCateringId == null) ? 0 : companyCateringId.hashCode());
		result = prime * result + ((companyCateringAmount == null) ? 0 : companyCateringAmount.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
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
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
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
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
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