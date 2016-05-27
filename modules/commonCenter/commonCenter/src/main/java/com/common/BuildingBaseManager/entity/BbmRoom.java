/**
 *
 */
package com.common.BuildingBaseManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 单元基础信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_bbm_room_")
public class BbmRoom implements Domain{
	
	private static final long serialVersionUID = -1171765789275011173L;
	

	@Column(name = "B_STATUS_")
	@Length(max=2)
	private String status;//使用状态

	@Column(name = "W_RENT_CHARGE_")
	@Length(max=10)
	private String rentCharge;//物业_租金

	@Column(name = "B_ASPECT_")
	@Length(max=32)
	private String aspect;//招商_朝向

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//企业ID

	@Column(name = "Z_SALE_STATE_")
	@Length(max=2)
	private String saleState;//招商_销售状态

	@Column(name = "Z_SALES_PRICE_")
	@Length(max=10)
	private String salesPrice;//招商_单价

	@Column(name = "B_ROOM_CAPTION_")
	@Length(max=256)
	private String roomCaption;//单元说明

	@Column(name = "Z_LOWER_PRICE_")
	@Length(max=10)
	private String lowerPrice;//招商_底价

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ROOM_ID_")
	@Length(max=36)
	private String roomId;//单元ID

	@Column(name = "B_ROOM_MODULE")
	@Length(max=32)
	private String roomModule;//招商_户型

	@Column(name = "B_AREA_")
	@Length(max=32)
	private String area;//招商_房间面积

	@Column(name = "W_PROPERTY_CHARGE_")
	@Length(max=10)
	private String propertyCharge;//物业_物业费

	@Column(name = "B_ROOM_NO_")
	@Length(max=10)
	private String roomNo;//单元编号

	@Column(name = "Z_REBATE_")
	@Length(max=10)
	private String rebate;//招商_折扣

	@Column(name = "W_ENERY_CHARGE_")
	@Length(max=10)
	private String eneryCharge;//物业_电费

	@Column(name = "B_FURNISH_")
	@Length(max=2)
	private String furnish;//招商_装修

	@Column(name = "W_WATER_CHARGE_")
	@Length(max=10)
	private String waterCharge;//物业_水费

	@Column(name = "B_ROOM_NAME")
	@Length(max=32)
	private String roomName;//招商_房间名称
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARK_ID_")
	private com.common.BuildingBaseManager.entity.BbmPark bbmPark;//园区ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BUILDING_ID_")
	private com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding;//楼栋ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="FLOOR_ID_")
	private com.common.BuildingBaseManager.entity.BbmFloor bbmFloor;//楼层ID
	
	@Transient
	private String parkName;//园区名称
	@Transient
	private String buildingName;//楼栋说明
	@Transient
	private String floorName;//楼层说明
	
	@Column(name = "ROOM_HOST_")
	@Length(max=20)
	private String roomHost;//单元业主ROOM_TENEMENT_
	
	@Column(name = "ROOM_TENEMENT_")
	@Length(max=20)
	private String roomTenement;//单元租户
	
	@Column(name = "ROOM_ADR_")
	@Length(max=1024)
	private String roomAddress;//详细地址
	
    /**新增园区字段   start**/
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 
	
	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getRoomHost() {
		return roomHost;
	}

	public void setRoomHost(String roomHost) {
		this.roomHost = roomHost;
	}

	public String getRoomTenement() {
		return roomTenement;
	}

	public void setRoomTenement(String roomTenement) {
		this.roomTenement = roomTenement;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	public String getRentCharge(){
		return this.rentCharge;
	}
	
	public void setRentCharge(String rentCharge){
		this.rentCharge = rentCharge;
	}
	public String getAspect(){
		return this.aspect;
	}
	
	public void setAspect(String aspect){
		this.aspect = aspect;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getSaleState(){
		return this.saleState;
	}
	
	public void setSaleState(String saleState){
		this.saleState = saleState;
	}
	public String getSalesPrice(){
		return this.salesPrice;
	}
	
	public void setSalesPrice(String salesPrice){
		this.salesPrice = salesPrice;
	}
	public String getRoomCaption(){
		return this.roomCaption;
	}
	
	public void setRoomCaption(String roomCaption){
		this.roomCaption = roomCaption;
	}
	public String getLowerPrice(){
		return this.lowerPrice;
	}
	
	public void setLowerPrice(String lowerPrice){
		this.lowerPrice = lowerPrice;
	}
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRoomId(String roomId){
		this.roomId = roomId;
	}
	public String getRoomModule(){
		return this.roomModule;
	}
	
	public void setRoomModule(String roomModule){
		this.roomModule = roomModule;
	}
	public String getArea(){
		return this.area;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	public String getPropertyCharge(){
		return this.propertyCharge;
	}
	
	public void setPropertyCharge(String propertyCharge){
		this.propertyCharge = propertyCharge;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	public String getRebate(){
		return this.rebate;
	}
	
	public void setRebate(String rebate){
		this.rebate = rebate;
	}
	public String getEneryCharge(){
		return this.eneryCharge;
	}
	
	public void setEneryCharge(String eneryCharge){
		this.eneryCharge = eneryCharge;
	}
	public String getFurnish(){
		return this.furnish;
	}
	
	public void setFurnish(String furnish){
		this.furnish = furnish;
	}
	public String getWaterCharge(){
		return this.waterCharge;
	}
	
	public void setWaterCharge(String waterCharge){
		this.waterCharge = waterCharge;
	}
	public String getRoomName(){
		return this.roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public com.common.BuildingBaseManager.entity.BbmPark getBbmPark() {
		return bbmPark;
	}

	public void setBbmPark(com.common.BuildingBaseManager.entity.BbmPark bbmPark) {
		this.bbmPark = bbmPark;
	}

	public com.common.BuildingBaseManager.entity.BbmBuilding getBbmBuilding() {
		return bbmBuilding;
	}

	public void setBbmBuilding(
			com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding) {
		this.bbmBuilding = bbmBuilding;
	}

	public void setBbmFloor(com.common.BuildingBaseManager.entity.BbmFloor bbmFloor){
		this.bbmFloor = bbmFloor;
	}
	
	public com.common.BuildingBaseManager.entity.BbmFloor getBbmFloor(){
		return this.bbmFloor;
	}
	/**新增园区字段   start**/
	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((rentCharge == null) ? 0 : rentCharge.hashCode());
		result = prime * result + ((aspect == null) ? 0 : aspect.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((saleState == null) ? 0 : saleState.hashCode());
		result = prime * result + ((salesPrice == null) ? 0 : salesPrice.hashCode());
		result = prime * result + ((roomCaption == null) ? 0 : roomCaption.hashCode());
		result = prime * result + ((lowerPrice == null) ? 0 : lowerPrice.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((roomModule == null) ? 0 : roomModule.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((propertyCharge == null) ? 0 : propertyCharge.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((rebate == null) ? 0 : rebate.hashCode());
		result = prime * result + ((eneryCharge == null) ? 0 : eneryCharge.hashCode());
		result = prime * result + ((furnish == null) ? 0 : furnish.hashCode());
		result = prime * result + ((waterCharge == null) ? 0 : waterCharge.hashCode());
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		/**新增园区字段   start**/
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
		final BbmRoom other = (BbmRoom) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (rentCharge == null) {
			if (other.rentCharge != null)
				return false;
		} else if (!rentCharge.equals(other.rentCharge))
			return false;
		if (aspect == null) {
			if (other.aspect != null)
				return false;
		} else if (!aspect.equals(other.aspect))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (saleState == null) {
			if (other.saleState != null)
				return false;
		} else if (!saleState.equals(other.saleState))
			return false;
		if (salesPrice == null) {
			if (other.salesPrice != null)
				return false;
		} else if (!salesPrice.equals(other.salesPrice))
			return false;
		if (roomCaption == null) {
			if (other.roomCaption != null)
				return false;
		} else if (!roomCaption.equals(other.roomCaption))
			return false;
		if (lowerPrice == null) {
			if (other.lowerPrice != null)
				return false;
		} else if (!lowerPrice.equals(other.lowerPrice))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (roomModule == null) {
			if (other.roomModule != null)
				return false;
		} else if (!roomModule.equals(other.roomModule))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (propertyCharge == null) {
			if (other.propertyCharge != null)
				return false;
		} else if (!propertyCharge.equals(other.propertyCharge))
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (rebate == null) {
			if (other.rebate != null)
				return false;
		} else if (!rebate.equals(other.rebate))
			return false;
		if (eneryCharge == null) {
			if (other.eneryCharge != null)
				return false;
		} else if (!eneryCharge.equals(other.eneryCharge))
			return false;
		if (furnish == null) {
			if (other.furnish != null)
				return false;
		} else if (!furnish.equals(other.furnish))
			return false;
		if (waterCharge == null) {
			if (other.waterCharge != null)
				return false;
		} else if (!waterCharge.equals(other.waterCharge))
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;		
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}