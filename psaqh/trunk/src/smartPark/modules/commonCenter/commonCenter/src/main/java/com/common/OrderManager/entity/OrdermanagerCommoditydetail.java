/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单商品明细
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_commodityDetail")
public class OrdermanagerCommoditydetail implements Domain{
	
	private static final long serialVersionUID = -244655877726959214L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITYDETAIL_ID_")
	@Length(max=36)
	private String commoditydetailId;//明细序号

	@Column(name = "COMMODITYDETAIL_COMMODITY_ID_")
	@Length(max=36)
	private String commoditydetailCommodityId;//商户ID

	@Column(name = "COMMODITY_ID_")
	@Length(max=36)
	private String commodityId;//商品ID

	@Column(name = "COMMODITYDETAIL_URL_")
	@Length(max=256)
	private String commoditydetailUrl;//商品明细URL

	@Column(name = "COMMODITYDETAIL_NUM_")
	private String commoditydetailNum;//数量
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERORDER_ID_")
	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单序列
	
	public String getCommoditydetailId(){
		return this.commoditydetailId;
	}
	
	public void setCommoditydetailId(String commoditydetailId){
		this.commoditydetailId = commoditydetailId;
	}
	public String getCommoditydetailCommodityId(){
		return this.commoditydetailCommodityId;
	}
	
	public void setCommoditydetailCommodityId(String commoditydetailCommodityId){
		this.commoditydetailCommodityId = commoditydetailCommodityId;
	}
	public String getCommodityId(){
		return this.commodityId;
	}
	
	public void setCommodityId(String commodityId){
		this.commodityId = commodityId;
	}
	public String getCommoditydetailUrl(){
		return this.commoditydetailUrl;
	}
	
	public void setCommoditydetailUrl(String commoditydetailUrl){
		this.commoditydetailUrl = commoditydetailUrl;
	}
	public String getCommoditydetailNum(){
		return this.commoditydetailNum;
	}
	
	public void setCommoditydetailNum(String commoditydetailNum){
		this.commoditydetailNum = commoditydetailNum;
	}
	
	public void setOrdermanagerUserorder(com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder){
		this.ordermanagerUserorder = ordermanagerUserorder;
	}
	
	public com.common.OrderManager.entity.OrdermanagerUserorder getOrdermanagerUserorder(){
		return this.ordermanagerUserorder;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commoditydetailId == null) ? 0 : commoditydetailId.hashCode());
		result = prime * result + ((commoditydetailCommodityId == null) ? 0 : commoditydetailCommodityId.hashCode());
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((commoditydetailUrl == null) ? 0 : commoditydetailUrl.hashCode());
		result = prime * result + ((commoditydetailNum == null) ? 0 : commoditydetailNum.hashCode());
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
		final OrdermanagerCommoditydetail other = (OrdermanagerCommoditydetail) obj;
		if (commoditydetailId == null) {
			if (other.commoditydetailId != null)
				return false;
		} else if (!commoditydetailId.equals(other.commoditydetailId))
			return false;
		if (commoditydetailCommodityId == null) {
			if (other.commoditydetailCommodityId != null)
				return false;
		} else if (!commoditydetailCommodityId.equals(other.commoditydetailCommodityId))
			return false;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (commoditydetailUrl == null) {
			if (other.commoditydetailUrl != null)
				return false;
		} else if (!commoditydetailUrl.equals(other.commoditydetailUrl))
			return false;
		if (commoditydetailNum == null) {
			if (other.commoditydetailNum != null)
				return false;
		} else if (!commoditydetailNum.equals(other.commoditydetailNum))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}