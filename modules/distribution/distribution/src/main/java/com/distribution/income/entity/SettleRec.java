/**
 *
 */
package com.distribution.income.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 佣金结算记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_settle_rec")
public class SettleRec implements Domain{
	
	private static final long serialVersionUID = 8444944074739512419L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "POC_REC_ID_")
	@Length(max=36)
	private String pocRecId;//POC_REC_ID_

	@Column(name = "DIS_LEVEL_")
	private String disLevel;//收益链路层级

	@Column(name = "MEM_ID_")
	@Length(max=36)
	private String memId;//佣金受益人

	@Column(name = "MEM_LEVEL_")
	@Length(max=2)
	private String memLevel;//收益当前会员等级

	@Column(name = "DIS_AMOUNT_")
	@Length(max=10)
	private String disAmount;//佣金结算金额

	@Column(name = "DIS_RATE_")
	@Length(max=10)
	private String disRate;//收益层级比率
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SALE_REC_ID_")
	private com.distribution.income.entity.SalesRec salesRec;//SALE_REC_ID_
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
	public String getPocRecId(){
		return this.pocRecId;
	}
	
	public void setPocRecId(String pocRecId){
		this.pocRecId = pocRecId;
	}
	public String getDisLevel(){
		return this.disLevel;
	}
	
	public void setDisLevel(String disLevel){
		this.disLevel = disLevel;
	}
	public String getMemId(){
		return this.memId;
	}
	
	public void setMemId(String memId){
		this.memId = memId;
	}
	public String getMemLevel(){
		return this.memLevel;
	}
	
	public void setMemLevel(String memLevel){
		this.memLevel = memLevel;
	}
	public String getDisAmount(){
		return this.disAmount;
	}
	
	public void setDisAmount(String disAmount){
		this.disAmount = disAmount;
	}
	public String getDisRate(){
		return this.disRate;
	}
	
	public void setDisRate(String disRate){
		this.disRate = disRate;
	}
	
	public void setSalesRec(com.distribution.income.entity.SalesRec salesRec){
		this.salesRec = salesRec;
	}
	
	public com.distribution.income.entity.SalesRec getSalesRec(){
		return this.salesRec;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pocRecId == null) ? 0 : pocRecId.hashCode());
		result = prime * result + ((disLevel == null) ? 0 : disLevel.hashCode());
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((memLevel == null) ? 0 : memLevel.hashCode());
		result = prime * result + ((disAmount == null) ? 0 : disAmount.hashCode());
		result = prime * result + ((disRate == null) ? 0 : disRate.hashCode());
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
		final SettleRec other = (SettleRec) obj;
		if (pocRecId == null) {
			if (other.pocRecId != null)
				return false;
		} else if (!pocRecId.equals(other.pocRecId))
			return false;
		if (disLevel == null) {
			if (other.disLevel != null)
				return false;
		} else if (!disLevel.equals(other.disLevel))
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memLevel == null) {
			if (other.memLevel != null)
				return false;
		} else if (!memLevel.equals(other.memLevel))
			return false;
		if (disAmount == null) {
			if (other.disAmount != null)
				return false;
		} else if (!disAmount.equals(other.disAmount))
			return false;
		if (disRate == null) {
			if (other.disRate != null)
				return false;
		} else if (!disRate.equals(other.disRate))
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