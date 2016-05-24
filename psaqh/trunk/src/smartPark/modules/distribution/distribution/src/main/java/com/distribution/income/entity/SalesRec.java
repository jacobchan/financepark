/**
 *
 */
package com.distribution.income.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 楼宇售卖记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_sales_rec")
public class SalesRec implements Domain{
	
	private static final long serialVersionUID = -5737404655671022264L;
	

	@Column(name = "DIS_LEVEL_COUNT_")
	private String disLevelCount;//分佣层数

	@Column(name = "FACT_DIS_RATE_")
	@Length(max=10)
	private String factDisRate;//分佣总比例
	
	@Transient
	private String factDisRateShow;//分佣总比例百分比显示

	@Column(name = "FACT_DIS_AMOUNT_")
	@Length(max=10)
	private String factDisAmount;//分佣总额

	@Column(name = "ROOM_ID_")
	@Length(max=36)
	private String roomId;//单元ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "SALE_REC_ID_")
	@Length(max=36)
	private String saleRecId;//SALE_REC_ID_

	@Column(name = "SALE_AMOUNT_")
	@Length(max=10)
	private String saleAmount;//成交金额

	@Column(name = "PRE_DIS_AMOUNT_")
	@Length(max=10)
	private String preDisAmount;//预计分佣总额

	@Column(name = "REC_ID_")
	@Length(max=36)
	private String recId;//序列

	@Column(name = "IS_OUT_")
	@Length(max=2)
	private String isOut;//是否超额

	@Column(name = "IS_EXTRACT_")
	@Length(max=2)
	private String isExtract;//是否提佣
	
	public String getDisLevelCount(){
		return this.disLevelCount;
	}
	
	public void setDisLevelCount(String disLevelCount){
		this.disLevelCount = disLevelCount;
	}
	public String getFactDisRate(){
		return this.factDisRate;
	}
	
	public String getFactDisRateShow() {
		return factDisRateShow;
	}

	public void setFactDisRateShow(String factDisRateShow) {
		this.factDisRateShow = factDisRateShow;
	}

	public void setFactDisRate(String factDisRate){
		this.factDisRate = factDisRate;
	}
	public String getFactDisAmount(){
		return this.factDisAmount;
	}
	
	public void setFactDisAmount(String factDisAmount){
		this.factDisAmount = factDisAmount;
	}
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRoomId(String roomId){
		this.roomId = roomId;
	}
	public String getSaleRecId(){
		return this.saleRecId;
	}
	
	public void setSaleRecId(String saleRecId){
		this.saleRecId = saleRecId;
	}
	public String getSaleAmount(){
		return this.saleAmount;
	}
	
	public void setSaleAmount(String saleAmount){
		this.saleAmount = saleAmount;
	}
	public String getPreDisAmount(){
		return this.preDisAmount;
	}
	
	public void setPreDisAmount(String preDisAmount){
		this.preDisAmount = preDisAmount;
	}
	public String getRecId(){
		return this.recId;
	}
	
	public void setRecId(String recId){
		this.recId = recId;
	}
	public String getIsOut(){
		return this.isOut;
	}
	
	public void setIsOut(String isOut){
		this.isOut = isOut;
	}
	public String getIsExtract(){
		return this.isExtract;
	}
	
	public void setIsExtract(String isExtract){
		this.isExtract = isExtract;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disLevelCount == null) ? 0 : disLevelCount.hashCode());
		result = prime * result + ((factDisRate == null) ? 0 : factDisRate.hashCode());
		result = prime * result + ((factDisAmount == null) ? 0 : factDisAmount.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((saleRecId == null) ? 0 : saleRecId.hashCode());
		result = prime * result + ((saleAmount == null) ? 0 : saleAmount.hashCode());
		result = prime * result + ((preDisAmount == null) ? 0 : preDisAmount.hashCode());
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
		result = prime * result + ((isOut == null) ? 0 : isOut.hashCode());
		result = prime * result + ((isExtract == null) ? 0 : isExtract.hashCode());
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
		final SalesRec other = (SalesRec) obj;
		if (disLevelCount == null) {
			if (other.disLevelCount != null)
				return false;
		} else if (!disLevelCount.equals(other.disLevelCount))
			return false;
		if (factDisRate == null) {
			if (other.factDisRate != null)
				return false;
		} else if (!factDisRate.equals(other.factDisRate))
			return false;
		if (factDisAmount == null) {
			if (other.factDisAmount != null)
				return false;
		} else if (!factDisAmount.equals(other.factDisAmount))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (saleRecId == null) {
			if (other.saleRecId != null)
				return false;
		} else if (!saleRecId.equals(other.saleRecId))
			return false;
		if (saleAmount == null) {
			if (other.saleAmount != null)
				return false;
		} else if (!saleAmount.equals(other.saleAmount))
			return false;
		if (preDisAmount == null) {
			if (other.preDisAmount != null)
				return false;
		} else if (!preDisAmount.equals(other.preDisAmount))
			return false;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
			return false;
		if (isOut == null) {
			if (other.isOut != null)
				return false;
		} else if (!isOut.equals(other.isOut))
			return false;
		if (isExtract == null) {
			if (other.isExtract != null)
				return false;
		} else if (!isExtract.equals(other.isExtract))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}