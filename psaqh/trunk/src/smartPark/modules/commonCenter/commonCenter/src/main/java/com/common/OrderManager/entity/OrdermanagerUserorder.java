/**
 *
 */
package com.common.OrderManager.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.common.ExtentionAtrManager.entity.AdsenseOrderEntity;
import com.common.ExtentionAtrManager.entity.CarOrderEntity;
import com.common.ExtentionAtrManager.entity.MeetingOrderEntity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 用户订单表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_userOrder")
public class OrdermanagerUserorder implements Domain{
	
	private static final long serialVersionUID = 3834682363053179924L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "USERORDER_AMOUNT_")
	private BigDecimal userorderAmount;//订单金额

	@Column(name = "USERORDER_CODE_")
	@Length(max=32)
	private String userorderCode;//订单编号

	@Column(name = "USERORDER_STATUS_")
	@Length(max=2)
	private String userorderStatus;//订单状态

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="GENRE_ID_")
	private PurchasingmanagerGenre genreId;//商品类别ID

	@Column(name = "USERORDER_BUY_USER_")
	@Length(max=64)
	private String userorderBuyUser;//购买人姓名

	@Column(name = "USERORDER_PAY_MODE_")
	@Length(max=2)
	private String userorderPayMode;//支付方式

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "BX_ID_")
	@Length(max=36)
	private String bxId;//报修记录ID

	@Column(name = "USERORDER_PROJECT_")
	@Length(max=128)
	private String userorderProject;//订单项目

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "USERORDER_ID_")
	@Length(max=36)
	private String userorderId;//用户订单序列

	@Column(name = "USERORDER_TIME_")
	@Length(max=20)
	private String userorderTime;//下单时间

	@Column(name = "USERORDER_ADR_")
	@Length(max=256)
	private String userorderAdr;//发货地址
	
	@Column(name = "PAY_STATUS_")
	@Length(max=2)
	private String payStatus;//支付状态
	
	@Column(name = "PAY_RETURN_CODE_")
	@Length(max=32)
	private String payReturnCode;//支付返回订单号
	
	@Transient
	private String status;//订单中文显示状态
	
	@Transient
	private MeetingOrderEntity mettingOrder;//会议室订单扩展属性
	
	@Transient
	private CarOrderEntity carOrder;//车辆租赁订单扩展属性
	
	@Transient
	private AdsenseOrderEntity adsenseOrder;//广告位订单扩展属性
	
	@Transient
	private List<OrdermanagerCommoditydetail> ordermanagerCommodityDetailList;//订单详情（APP专用）
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
	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayReturnCode() {
		return payReturnCode;
	}

	public void setPayReturnCode(String payReturnCode) {
		this.payReturnCode = payReturnCode;
	}
	@Transient
	private String ordermanagerCommodityDetailListCount;//订单详情Count（APP专用）


	public List<OrdermanagerCommoditydetail> getOrdermanagerCommodityDetailList() {
		return ordermanagerCommodityDetailList;
	}

	public void setOrdermanagerCommodityDetailList(
			List<OrdermanagerCommoditydetail> ordermanagerCommodityDetailList) {
		this.ordermanagerCommodityDetailList = ordermanagerCommodityDetailList;
	}

	public String getOrdermanagerCommodityDetailListCount() {
		return ordermanagerCommodityDetailListCount;
	}

	public void setOrdermanagerCommodityDetailListCount(
			String ordermanagerCommodityDetailListCount) {
		this.ordermanagerCommodityDetailListCount = ordermanagerCommodityDetailListCount;
	}

	public CarOrderEntity getCarOrder() {
		return carOrder;
	}

	public void setCarOrder(CarOrderEntity carOrder) {
		this.carOrder = carOrder;
	}

	public AdsenseOrderEntity getAdsenseOrder() {
		return adsenseOrder;
	}

	public void setAdsenseOrder(AdsenseOrderEntity adsenseOrder) {
		this.adsenseOrder = adsenseOrder;
	}

	public MeetingOrderEntity getMettingOrder() {
		return mettingOrder;
	}

	public void setMettingOrder(MeetingOrderEntity mettingOrder) {
		this.mettingOrder = mettingOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public BigDecimal getUserorderAmount() {
		return userorderAmount;
	}

	public void setUserorderAmount(BigDecimal userorderAmount) {
		this.userorderAmount = userorderAmount;
	}

	public String getUserorderCode(){
		return this.userorderCode;
	}
	
	public void setUserorderCode(String userorderCode){
		this.userorderCode = userorderCode;
	}
	public String getUserorderStatus(){
		return this.userorderStatus;
	}
	
	public void setUserorderStatus(String userorderStatus){
		this.userorderStatus = userorderStatus;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	
	public PurchasingmanagerGenre getGenreId() {
		return genreId;
	}

	public void setGenreId(PurchasingmanagerGenre genreId) {
		this.genreId = genreId;
	}

	public String getUserorderBuyUser(){
		return this.userorderBuyUser;
	}
	
	public void setUserorderBuyUser(String userorderBuyUser){
		this.userorderBuyUser = userorderBuyUser;
	}
	public String getUserorderPayMode(){
		return this.userorderPayMode;
	}
	
	public void setUserorderPayMode(String userorderPayMode){
		this.userorderPayMode = userorderPayMode;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getBxId(){
		return this.bxId;
	}
	
	public void setBxId(String bxId){
		this.bxId = bxId;
	}
	public String getUserorderProject(){
		return this.userorderProject;
	}
	
	public void setUserorderProject(String userorderProject){
		this.userorderProject = userorderProject;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getUserorderId(){
		return this.userorderId;
	}
	
	public void setUserorderId(String userorderId){
		this.userorderId = userorderId;
	}
	public String getUserorderTime(){
		return this.userorderTime;
	}
	
	public void setUserorderTime(String userorderTime){
		this.userorderTime = userorderTime;
	}
	public String getUserorderAdr(){
		return this.userorderAdr;
	}
	
	public void setUserorderAdr(String userorderAdr){
		this.userorderAdr = userorderAdr;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((userorderAmount == null) ? 0 : userorderAmount.hashCode());
		result = prime * result + ((userorderCode == null) ? 0 : userorderCode.hashCode());
		result = prime * result + ((userorderStatus == null) ? 0 : userorderStatus.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((userorderBuyUser == null) ? 0 : userorderBuyUser.hashCode());
		result = prime * result + ((userorderPayMode == null) ? 0 : userorderPayMode.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((bxId == null) ? 0 : bxId.hashCode());
		result = prime * result + ((userorderProject == null) ? 0 : userorderProject.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((userorderId == null) ? 0 : userorderId.hashCode());
		result = prime * result + ((userorderTime == null) ? 0 : userorderTime.hashCode());
		result = prime * result + ((userorderAdr == null) ? 0 : userorderAdr.hashCode());
		result = prime * result + ((ordermanagerCommodityDetailList == null) ? 0 : ordermanagerCommodityDetailList.hashCode());
		result = prime * result + ((ordermanagerCommodityDetailListCount == null) ? 0 : ordermanagerCommodityDetailListCount.hashCode());
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
		final OrdermanagerUserorder other = (OrdermanagerUserorder) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (userorderAmount == null) {
			if (other.userorderAmount != null)
				return false;
		} else if (!userorderAmount.equals(other.userorderAmount))
			return false;
		if (userorderCode == null) {
			if (other.userorderCode != null)
				return false;
		} else if (!userorderCode.equals(other.userorderCode))
			return false;
		if (userorderStatus == null) {
			if (other.userorderStatus != null)
				return false;
		} else if (!userorderStatus.equals(other.userorderStatus))
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
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (userorderBuyUser == null) {
			if (other.userorderBuyUser != null)
				return false;
		} else if (!userorderBuyUser.equals(other.userorderBuyUser))
			return false;
		if (userorderPayMode == null) {
			if (other.userorderPayMode != null)
				return false;
		} else if (!userorderPayMode.equals(other.userorderPayMode))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (bxId == null) {
			if (other.bxId != null)
				return false;
		} else if (!bxId.equals(other.bxId))
			return false;
		if (userorderProject == null) {
			if (other.userorderProject != null)
				return false;
		} else if (!userorderProject.equals(other.userorderProject))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (userorderId == null) {
			if (other.userorderId != null)
				return false;
		} else if (!userorderId.equals(other.userorderId))
			return false;
		if (userorderTime == null) {
			if (other.userorderTime != null)
				return false;
		} else if (!userorderTime.equals(other.userorderTime))
			return false;
		if (userorderAdr == null) {
			if (other.userorderAdr != null)
				return false;
		} else if (!userorderAdr.equals(other.userorderAdr))
			return false;
		if (ordermanagerCommodityDetailList == null) {
			if (other.ordermanagerCommodityDetailList != null)
				return false;
		} else if (!ordermanagerCommodityDetailList.equals(other.ordermanagerCommodityDetailList))
			return false;
		if (ordermanagerCommodityDetailListCount == null) {
			if (other.ordermanagerCommodityDetailListCount != null)
				return false;
		} else if (!ordermanagerCommodityDetailListCount.equals(other.ordermanagerCommodityDetailListCount))
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