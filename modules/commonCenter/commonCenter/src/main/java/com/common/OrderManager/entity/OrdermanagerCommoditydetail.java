/**
 *
 */
package com.common.OrderManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
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
	
	private static final long serialVersionUID = 9208657303598567150L;
	

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "COMMODITYDETAIL_URL_")
	@Length(max=256)
	private String commoditydetailUrl;//商品明细URL

	@Column(name = "COMMODITYDETAIL_NUM_")
	private String commoditydetailNum;//数量

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COMMODITY_ID_")
	private PurchasingmanagerCommodity commodityId;//商品ID

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "COMMODITYDETAIL_COMMODITY_ID_")
	@Length(max=36)
	private String commoditydetailCommodityId;//商户ID
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "COMMODITYDETAIL_ID_")
	@Length(max=36)
	private String commoditydetailId;//明细序号
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="USERORDER_ID_")
//	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单序列
	@Column(name = "USERORDER_ID_")
	@Length(max=36)
	private String orderId;
	
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
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

	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCommoditydetailCommodityId(){
		return this.commoditydetailCommodityId;
	}
	
	public void setCommoditydetailCommodityId(String commoditydetailCommodityId){
		this.commoditydetailCommodityId = commoditydetailCommodityId;
	}
	public String getCommoditydetailId(){
		return this.commoditydetailId;
	}
	
	public void setCommoditydetailId(String commoditydetailId){
		this.commoditydetailId = commoditydetailId;
	}
	
//	public void setOrdermanagerUserorder(com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder){
//		this.ordermanagerUserorder = ordermanagerUserorder;
//	}
//	
//	public com.common.OrderManager.entity.OrdermanagerUserorder getOrdermanagerUserorder(){
//		return this.ordermanagerUserorder;
//	}
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public String getOrderId(){
		return this.orderId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((commoditydetailUrl == null) ? 0 : commoditydetailUrl.hashCode());
		result = prime * result + ((commoditydetailNum == null) ? 0 : commoditydetailNum.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((commodityId == null) ? 0 : commodityId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((commoditydetailCommodityId == null) ? 0 : commoditydetailCommodityId.hashCode());
		result = prime * result + ((commoditydetailId == null) ? 0 : commoditydetailId.hashCode());
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
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
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
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (commodityId == null) {
			if (other.commodityId != null)
				return false;
		} else if (!commodityId.equals(other.commodityId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (commoditydetailCommodityId == null) {
			if (other.commoditydetailCommodityId != null)
				return false;
		} else if (!commoditydetailCommodityId.equals(other.commoditydetailCommodityId))
			return false;
		if (commoditydetailId == null) {
			if (other.commoditydetailId != null)
				return false;
		} else if (!commoditydetailId.equals(other.commoditydetailId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}