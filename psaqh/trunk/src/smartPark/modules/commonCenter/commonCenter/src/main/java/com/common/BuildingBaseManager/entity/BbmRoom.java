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
	
	private static final long serialVersionUID = -6670704169358974891L;
	

	@Column(name = "Z_REBATE_")
	@Length(max=10)
	private String rebate;//招商_折扣

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ROOM_ID_")
	@Length(max=36)
	private String roomId;//单元ID

	@Column(name = "B_ROOM_NAME")
	@Length(max=32)
	private String roomName;//招商_房间名称

	@Column(name = "FLOOR_ID_")
	@Length(max=36)
	private String floorId;//楼层ID

	@Column(name = "W_RENT_CHARGE_")
	@Length(max=10)
	private String rentCharge;//物业_租金

	@Column(name = "B_ROOM_CAPTION_")
	@Length(max=256)
	private String roomCaption;//单元说明

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID

	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID

	@Column(name = "B_ASPECT_")
	@Length(max=32)
	private String aspect;//招商_朝向

	@Column(name = "B_FLOOR_")
	@Length(max=32)
	private String floor;//所属楼层

	@Column(name = "B_ROOM_NO_")
	@Length(max=10)
	private String roomNo;//单元编号

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "B_AREA_")
	@Length(max=32)
	private String area;//招商_房间面积

	@Column(name = "Z_LOWER_PRICE_")
	@Length(max=10)
	private String lowerPrice;//招商_底价

	@Column(name = "W_PROPERTY_CHARGE_")
	@Length(max=10)
	private String propertyCharge;//物业_物业费

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@Column(name = "Z_SALES_PRICE_")
	@Length(max=10)
	private String salesPrice;//招商_单价

	@Column(name = "W_WATER_CHARGE_")
	@Length(max=10)
	private String waterCharge;//物业_水费

	@Column(name = "Z_SALE_STATE_")
	@Length(max=2)
	private String saleState;//招商_销售状态

	@Column(name = "W_ENERY_CHARGE_")
	@Length(max=10)
	private String eneryCharge;//物业_电费

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "B_STATUS_")
	@Length(max=2)
	private String status;//使用状态

	@Column(name = "B_ROOM_MODULE")
	@Length(max=32)
	private String roomModule;//招商_户型

	@Column(name = "B_ENTERED_ENT_")
	@Length(max=32)
	private String enteredEnt;//包含企业

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "B_FURNISH_")
	@Length(max=2)
	private String furnish;//招商_装修
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__FLOOR_ID_")
	private com.common.BuildingBaseManager.entity.BbmFloor bbmFloor;//320_楼层ID
	
	public String getRebate(){
		return this.rebate;
	}
	
	public void setRebate(String rebate){
		this.rebate = rebate;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRoomId(String roomId){
		this.roomId = roomId;
	}
	public String getRoomName(){
		return this.roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	public String getFloorId(){
		return this.floorId;
	}
	
	public void setFloorId(String floorId){
		this.floorId = floorId;
	}
	public String getRentCharge(){
		return this.rentCharge;
	}
	
	public void setRentCharge(String rentCharge){
		this.rentCharge = rentCharge;
	}
	public String getRoomCaption(){
		return this.roomCaption;
	}
	
	public void setRoomCaption(String roomCaption){
		this.roomCaption = roomCaption;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getBuildingId(){
		return this.buildingId;
	}
	
	public void setBuildingId(String buildingId){
		this.buildingId = buildingId;
	}
	public String getAspect(){
		return this.aspect;
	}
	
	public void setAspect(String aspect){
		this.aspect = aspect;
	}
	public String getFloor(){
		return this.floor;
	}
	
	public void setFloor(String floor){
		this.floor = floor;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getArea(){
		return this.area;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	public String getLowerPrice(){
		return this.lowerPrice;
	}
	
	public void setLowerPrice(String lowerPrice){
		this.lowerPrice = lowerPrice;
	}
	public String getPropertyCharge(){
		return this.propertyCharge;
	}
	
	public void setPropertyCharge(String propertyCharge){
		this.propertyCharge = propertyCharge;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getSalesPrice(){
		return this.salesPrice;
	}
	
	public void setSalesPrice(String salesPrice){
		this.salesPrice = salesPrice;
	}
	public String getWaterCharge(){
		return this.waterCharge;
	}
	
	public void setWaterCharge(String waterCharge){
		this.waterCharge = waterCharge;
	}
	public String getSaleState(){
		return this.saleState;
	}
	
	public void setSaleState(String saleState){
		this.saleState = saleState;
	}
	public String getEneryCharge(){
		return this.eneryCharge;
	}
	
	public void setEneryCharge(String eneryCharge){
		this.eneryCharge = eneryCharge;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	public String getRoomModule(){
		return this.roomModule;
	}
	
	public void setRoomModule(String roomModule){
		this.roomModule = roomModule;
	}
	public String getEnteredEnt(){
		return this.enteredEnt;
	}
	
	public void setEnteredEnt(String enteredEnt){
		this.enteredEnt = enteredEnt;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getFurnish(){
		return this.furnish;
	}
	
	public void setFurnish(String furnish){
		this.furnish = furnish;
	}
	
	public void setBbmFloor(com.common.BuildingBaseManager.entity.BbmFloor bbmFloor){
		this.bbmFloor = bbmFloor;
	}
	
	public com.common.BuildingBaseManager.entity.BbmFloor getBbmFloor(){
		return this.bbmFloor;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rebate == null) ? 0 : rebate.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + ((floorId == null) ? 0 : floorId.hashCode());
		result = prime * result + ((rentCharge == null) ? 0 : rentCharge.hashCode());
		result = prime * result + ((roomCaption == null) ? 0 : roomCaption.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((aspect == null) ? 0 : aspect.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((lowerPrice == null) ? 0 : lowerPrice.hashCode());
		result = prime * result + ((propertyCharge == null) ? 0 : propertyCharge.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((salesPrice == null) ? 0 : salesPrice.hashCode());
		result = prime * result + ((waterCharge == null) ? 0 : waterCharge.hashCode());
		result = prime * result + ((saleState == null) ? 0 : saleState.hashCode());
		result = prime * result + ((eneryCharge == null) ? 0 : eneryCharge.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((roomModule == null) ? 0 : roomModule.hashCode());
		result = prime * result + ((enteredEnt == null) ? 0 : enteredEnt.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((furnish == null) ? 0 : furnish.hashCode());
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
		if (rebate == null) {
			if (other.rebate != null)
				return false;
		} else if (!rebate.equals(other.rebate))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		if (floorId == null) {
			if (other.floorId != null)
				return false;
		} else if (!floorId.equals(other.floorId))
			return false;
		if (rentCharge == null) {
			if (other.rentCharge != null)
				return false;
		} else if (!rentCharge.equals(other.rentCharge))
			return false;
		if (roomCaption == null) {
			if (other.roomCaption != null)
				return false;
		} else if (!roomCaption.equals(other.roomCaption))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (aspect == null) {
			if (other.aspect != null)
				return false;
		} else if (!aspect.equals(other.aspect))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (lowerPrice == null) {
			if (other.lowerPrice != null)
				return false;
		} else if (!lowerPrice.equals(other.lowerPrice))
			return false;
		if (propertyCharge == null) {
			if (other.propertyCharge != null)
				return false;
		} else if (!propertyCharge.equals(other.propertyCharge))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (salesPrice == null) {
			if (other.salesPrice != null)
				return false;
		} else if (!salesPrice.equals(other.salesPrice))
			return false;
		if (waterCharge == null) {
			if (other.waterCharge != null)
				return false;
		} else if (!waterCharge.equals(other.waterCharge))
			return false;
		if (saleState == null) {
			if (other.saleState != null)
				return false;
		} else if (!saleState.equals(other.saleState))
			return false;
		if (eneryCharge == null) {
			if (other.eneryCharge != null)
				return false;
		} else if (!eneryCharge.equals(other.eneryCharge))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (roomModule == null) {
			if (other.roomModule != null)
				return false;
		} else if (!roomModule.equals(other.roomModule))
			return false;
		if (enteredEnt == null) {
			if (other.enteredEnt != null)
				return false;
		} else if (!enteredEnt.equals(other.enteredEnt))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (furnish == null) {
			if (other.furnish != null)
				return false;
		} else if (!furnish.equals(other.furnish))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}