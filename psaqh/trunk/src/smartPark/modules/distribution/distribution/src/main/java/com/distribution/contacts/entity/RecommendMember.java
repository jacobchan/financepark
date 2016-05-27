/**
 *
 */
package com.distribution.contacts.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 350301推荐联系人
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_recommend_member")
public class RecommendMember implements Domain{
	
	private static final long serialVersionUID = 6107150375154475633L;
	

	@Column(name = "MEM_ROLE_")
	@Length(max=20)
	private String memRole;//职位

	@Column(name = "MEM_NAME_")
	@Length(max=100)
	private String memName;//联系人姓名

	@Column(name = "MEM_SEX_")
	@Length(max=2)
	private String memSex;//性别

	@Column(name = "LAST_BUY_TIME_")
	@Length(max=20)
	private String lastBuyTime;//末次购买时间

	@Column(name = "REC_CODE_")
	@Length(max=10)
	private String recCode;//推荐码

	@Column(name = "BUY_COUNT_")
	private String buyCount;//购买次数

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "MEM_PHONE_")
	@Length(max=12)
	private String memPhone;//联系电话

	@Column(name = "REG_TIME_")
	@Length(max=64)
	private String regTime;//注册时间

	@Column(name = "IS_BUY_")
	@Length(max=2)
	private String isBuy;//是否完成购买
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "REC_ID_")
	@Length(max=36)
	private String recId;//序列

	@Column(name = "REG_ID_")
	@Length(max=36)
	private String regId;//注册会员ID

	@Column(name = "IS_REG_")
	@Length(max=2)
	private String isReg;//是否注册
	
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

	/*private String remark;//备注
	
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}*/

	public String getMemRole(){
		return this.memRole;
	}
	
	public void setMemRole(String memRole){
		this.memRole = memRole;
	}
	public String getMemName(){
		return this.memName;
	}
	
	public void setMemName(String memName){
		this.memName = memName;
	}
	public String getMemSex(){
		return this.memSex;
	}
	
	public void setMemSex(String memSex){
		this.memSex = memSex;
	}
	public String getLastBuyTime(){
		return this.lastBuyTime;
	}
	
	public void setLastBuyTime(String lastBuyTime){
		this.lastBuyTime = lastBuyTime;
	}
	public String getRecCode(){
		return this.recCode;
	}
	
	public void setRecCode(String recCode){
		this.recCode = recCode;
	}
	public String getBuyCount(){
		return this.buyCount;
	}
	
	public void setBuyCount(String buyCount){
		this.buyCount = buyCount;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getMemPhone(){
		return this.memPhone;
	}
	
	public void setMemPhone(String memPhone){
		this.memPhone = memPhone;
	}
	public String getRegTime(){
		return this.regTime;
	}
	
	public void setRegTime(String regTime){
		this.regTime = regTime;
	}
	public String getIsBuy(){
		return this.isBuy;
	}
	
	public void setIsBuy(String isBuy){
		this.isBuy = isBuy;
	}
	public String getRecId(){
		return this.recId;
	}
	
	public void setRecId(String recId){
		this.recId = recId;
	}
	public String getRegId(){
		return this.regId;
	}
	
	public void setRegId(String regId){
		this.regId = regId;
	}
	public String getIsReg(){
		return this.isReg;
	}
	
	public void setIsReg(String isReg){
		this.isReg = isReg;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memRole == null) ? 0 : memRole.hashCode());
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + ((memSex == null) ? 0 : memSex.hashCode());
		result = prime * result + ((lastBuyTime == null) ? 0 : lastBuyTime.hashCode());
		result = prime * result + ((recCode == null) ? 0 : recCode.hashCode());
		result = prime * result + ((buyCount == null) ? 0 : buyCount.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memPhone == null) ? 0 : memPhone.hashCode());
		result = prime * result + ((regTime == null) ? 0 : regTime.hashCode());
		result = prime * result + ((isBuy == null) ? 0 : isBuy.hashCode());
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((isReg == null) ? 0 : isReg.hashCode());
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
		final RecommendMember other = (RecommendMember) obj;
		if (memRole == null) {
			if (other.memRole != null)
				return false;
		} else if (!memRole.equals(other.memRole))
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memSex == null) {
			if (other.memSex != null)
				return false;
		} else if (!memSex.equals(other.memSex))
			return false;
		if (lastBuyTime == null) {
			if (other.lastBuyTime != null)
				return false;
		} else if (!lastBuyTime.equals(other.lastBuyTime))
			return false;
		if (recCode == null) {
			if (other.recCode != null)
				return false;
		} else if (!recCode.equals(other.recCode))
			return false;
		if (buyCount == null) {
			if (other.buyCount != null)
				return false;
		} else if (!buyCount.equals(other.buyCount))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memPhone == null) {
			if (other.memPhone != null)
				return false;
		} else if (!memPhone.equals(other.memPhone))
			return false;
		if (regTime == null) {
			if (other.regTime != null)
				return false;
		} else if (!regTime.equals(other.regTime))
			return false;
		if (isBuy == null) {
			if (other.isBuy != null)
				return false;
		} else if (!isBuy.equals(other.isBuy))
			return false;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (isReg == null) {
			if (other.isReg != null)
				return false;
		} else if (!isReg.equals(other.isReg))
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