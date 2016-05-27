/**
 *
 */
package com.member.shoppingCarManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
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
	
	private static final long serialVersionUID = 7675305009778359327L;
	

	@Column(name = "COMPANY_CATERING_AMOUNT_")
	@Length(max=16)
	private String companyCateringNum;//商品数量

	@Column(name = "COMPANY_CATERING_UNIVALENCE_")
	@Length(max=16)
	private String companyCateringUnivalence;//商品单价
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMPANY_GROUP_ID_")
	@Length(max=36)
	private String companyGroupId;//集采购物车ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMMODITY_ID_")
	private PurchasingmanagerCommodity commodityId;//商品ID

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID

	@Column(name = "COMPANY_GROUP_COLLECT_STATUS_")
	@Length(max=1)
	private String companyGroupCollectStatus;//集采是否收藏

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
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
	public String getCompanyCateringNum() {
		return companyCateringNum;
	}

	public void setCompanyCateringNum(String companyCateringNum) {
		this.companyCateringNum = companyCateringNum;
	}

	public String getCompanyCateringUnivalence(){
		return this.companyCateringUnivalence;
	}
	
	public void setCompanyCateringUnivalence(String companyCateringUnivalence){
		this.companyCateringUnivalence = companyCateringUnivalence;
	}
	public String getCompanyGroupId(){
		return this.companyGroupId;
	}
	
	public void setCompanyGroupId(String companyGroupId){
		this.companyGroupId = companyGroupId;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	public PurchasingmanagerCommodity getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(PurchasingmanagerCommodity commodityId) {
		this.commodityId = commodityId;
	}

	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	
	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	public String getCompanyGroupCollectStatus(){
		return this.companyGroupCollectStatus;
	}
	
	public void setCompanyGroupCollectStatus(String companyGroupCollectStatus){
		this.companyGroupCollectStatus = companyGroupCollectStatus;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime
				* result
				+ ((companyCateringNum == null) ? 0 : companyCateringNum
						.hashCode());
		result = prime
				* result
				+ ((companyCateringUnivalence == null) ? 0
						: companyCateringUnivalence.hashCode());
		result = prime
				* result
				+ ((companyGroupCollectStatus == null) ? 0
						: companyGroupCollectStatus.hashCode());
		result = prime * result
				+ ((companyGroupId == null) ? 0 : companyGroupId.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		ShoppingcarGroup other = (ShoppingcarGroup) obj;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (companyCateringNum == null) {
			if (other.companyCateringNum != null)
				return false;
		} else if (!companyCateringNum.equals(other.companyCateringNum))
			return false;
		if (companyCateringUnivalence == null) {
			if (other.companyCateringUnivalence != null)
				return false;
		} else if (!companyCateringUnivalence
				.equals(other.companyCateringUnivalence))
			return false;
		if (companyGroupCollectStatus == null) {
			if (other.companyGroupCollectStatus != null)
				return false;
		} else if (!companyGroupCollectStatus
				.equals(other.companyGroupCollectStatus))
			return false;
		if (companyGroupId == null) {
			if (other.companyGroupId != null)
				return false;
		} else if (!companyGroupId.equals(other.companyGroupId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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