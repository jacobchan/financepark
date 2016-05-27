/**
 *
 */
package com.member.hotel.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 酒店订单
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_hotel_order")
public class HotelOrder implements Domain{
	
	private static final long serialVersionUID = 2115536228939409075L;
	

	@Column(name = "DAILY_PRICE_")
	@Length(max=1024)
	private String dailyPrice;//每日价格

	@Column(name = "RZ_MOBILE_")
	@Length(max=20)
	private String rzMobile;//客人手机

	@Column(name = "ORDER_ID_THIRD")
	@Length(max=64)
	private String orderIdThird;//第三方订单号

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "HOTEL_ID_")
	@Length(max=36)
	private String hotelId;//酒店ID

	@Column(name = "COMING_TIME_")
	@Length(max=20)
	private String comingTime;//入驻时间

	@Column(name = "ORDER_INFO_")
	@Length(max=256)
	private String orderInfo;//客户姓名

	@Column(name = "ORDER_AMOUNT_")
	@Length(max=10)
	private String orderAmount;//订单总价格
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDER_ID_")
	@Length(max=36)
	private String orderId;//ORDER_ID_

	@Column(name = "ORDER_STATUS_")
	@Length(max=2)
	private String orderStatus;//订单状态

	@Column(name = "ORDER_UPDATE_TIME")
	@Length(max=20)
	private String orderUpdateTime;//订单更新时间

	@Column(name = "ORDER_NUM_")
	@Length(max=36)
	private String orderNum;//订单编号

	@Column(name = "XING_HAO_")
	@Length(max=256)
	private String xingHao;//房间型号

	@Column(name = "ORDER_TIME_")
	@Length(max=20)
	private String orderTime;//下单时间

	@Column(name = "HOTEL_NAME_")
	@Length(max=256)
	private String hotelName;//酒店名称

	@Column(name = "OUT_TIME_")
	@Length(max=20)
	private String outTime;//离店时间

	@Column(name = "ROOM_COUNT_")
	private String roomCount;//房间数量
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
	public String getDailyPrice(){
		return this.dailyPrice;
	}
	
	public void setDailyPrice(String dailyPrice){
		this.dailyPrice = dailyPrice;
	}
	public String getRzMobile(){
		return this.rzMobile;
	}
	
	public void setRzMobile(String rzMobile){
		this.rzMobile = rzMobile;
	}
	public String getOrderIdThird(){
		return this.orderIdThird;
	}
	
	public void setOrderIdThird(String orderIdThird){
		this.orderIdThird = orderIdThird;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getHotelId(){
		return this.hotelId;
	}
	
	public void setHotelId(String hotelId){
		this.hotelId = hotelId;
	}
	public String getComingTime(){
		return this.comingTime;
	}
	
	public void setComingTime(String comingTime){
		this.comingTime = comingTime;
	}
	public String getOrderInfo(){
		return this.orderInfo;
	}
	
	public void setOrderInfo(String orderInfo){
		this.orderInfo = orderInfo;
	}
	public String getOrderAmount(){
		return this.orderAmount;
	}
	
	public void setOrderAmount(String orderAmount){
		this.orderAmount = orderAmount;
	}
	public String getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	public String getOrderStatus(){
		return this.orderStatus;
	}
	
	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}
	public String getOrderUpdateTime(){
		return this.orderUpdateTime;
	}
	
	public void setOrderUpdateTime(String orderUpdateTime){
		this.orderUpdateTime = orderUpdateTime;
	}
	public String getOrderNum(){
		return this.orderNum;
	}
	
	public void setOrderNum(String orderNum){
		this.orderNum = orderNum;
	}
	public String getXingHao(){
		return this.xingHao;
	}
	
	public void setXingHao(String xingHao){
		this.xingHao = xingHao;
	}
	public String getOrderTime(){
		return this.orderTime;
	}
	
	public void setOrderTime(String orderTime){
		this.orderTime = orderTime;
	}
	public String getHotelName(){
		return this.hotelName;
	}
	
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	public String getOutTime(){
		return this.outTime;
	}
	
	public void setOutTime(String outTime){
		this.outTime = outTime;
	}
	public String getRoomCount(){
		return this.roomCount;
	}
	
	public void setRoomCount(String roomCount){
		this.roomCount = roomCount;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dailyPrice == null) ? 0 : dailyPrice.hashCode());
		result = prime * result + ((rzMobile == null) ? 0 : rzMobile.hashCode());
		result = prime * result + ((orderIdThird == null) ? 0 : orderIdThird.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		result = prime * result + ((comingTime == null) ? 0 : comingTime.hashCode());
		result = prime * result + ((orderInfo == null) ? 0 : orderInfo.hashCode());
		result = prime * result + ((orderAmount == null) ? 0 : orderAmount.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((orderUpdateTime == null) ? 0 : orderUpdateTime.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((xingHao == null) ? 0 : xingHao.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((outTime == null) ? 0 : outTime.hashCode());
		result = prime * result + ((roomCount == null) ? 0 : roomCount.hashCode());
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
		final HotelOrder other = (HotelOrder) obj;
		if (dailyPrice == null) {
			if (other.dailyPrice != null)
				return false;
		} else if (!dailyPrice.equals(other.dailyPrice))
			return false;
		if (rzMobile == null) {
			if (other.rzMobile != null)
				return false;
		} else if (!rzMobile.equals(other.rzMobile))
			return false;
		if (orderIdThird == null) {
			if (other.orderIdThird != null)
				return false;
		} else if (!orderIdThird.equals(other.orderIdThird))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
			return false;
		if (comingTime == null) {
			if (other.comingTime != null)
				return false;
		} else if (!comingTime.equals(other.comingTime))
			return false;
		if (orderInfo == null) {
			if (other.orderInfo != null)
				return false;
		} else if (!orderInfo.equals(other.orderInfo))
			return false;
		if (orderAmount == null) {
			if (other.orderAmount != null)
				return false;
		} else if (!orderAmount.equals(other.orderAmount))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (orderUpdateTime == null) {
			if (other.orderUpdateTime != null)
				return false;
		} else if (!orderUpdateTime.equals(other.orderUpdateTime))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (xingHao == null) {
			if (other.xingHao != null)
				return false;
		} else if (!xingHao.equals(other.xingHao))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (outTime == null) {
			if (other.outTime != null)
				return false;
		} else if (!outTime.equals(other.outTime))
			return false;
		if (roomCount == null) {
			if (other.roomCount != null)
				return false;
		} else if (!roomCount.equals(other.roomCount))
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