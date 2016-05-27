/**
 *
 */
package com.common.BuildingBaseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 楼层基础信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_bbm_floor_")
public class BbmFloor implements Domain{
	
	private static final long serialVersionUID = -6290771457545483180L;
	

	@Column(name = "FLOOR_NO_")
	@Length(max=32)
	private String floorNo;//楼层编号

	@Column(name = "Z_ROOM_NO_")
	@Length(max=36)
	private String roomNo;//招商_房间编号

	@Column(name = "Z_USE_STATUS_")
	@Length(max=2)
	private String useStatus;//招商_使用状态

	@Column(name = "FLOOR_CAPTION_")
	@Length(max=32)
	private String floorCaption;//楼层说明

	@Column(name = "Z_ROOM_NUM_")
	@Length(max=2)
	private String roomNum;//招商_房间个数
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FLOOR_ID_")
	@Length(max=36)
	private String floorId;//楼层ID

	@Column(name = "Z_COMPANY_")
	@Length(max=36)
	private String company;//招商_所属企业

	@Column(name = "FLOOR_ROOM_COUNT_")
	@Length(max=32)
	private String floorRoomCount;//楼层单元数量
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PARK_ID_")
	private com.common.BuildingBaseManager.entity.BbmPark bbmPark;//园区ID
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="BUILDING_ID_")
	private com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding;//楼栋ID
	
//	@Transient
//	private String parkName;
	@Transient
	private String buildingName;
	
	@Column(name = "FLOOR_IMAGE_")
	@Length(max=100)
	private String floorImage;//楼层图片URL
	
	@Column(name = "PARK_NAME_")
	@Length(max=36)
	private String parkName;//园区名称
    /**新增园区字段   start**/
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 	
	
	public String getFloorImage() {
		return floorImage;
	}

	public void setFloorImage(String floorImage) {
		this.floorImage = floorImage;
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

	public String getFloorNo(){
		return this.floorNo;
	}
	
	public void setFloorNo(String floorNo){
		this.floorNo = floorNo;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	public String getUseStatus(){
		return this.useStatus;
	}
	
	public void setUseStatus(String useStatus){
		this.useStatus = useStatus;
	}
	public String getFloorCaption(){
		return this.floorCaption;
	}
	
	public void setFloorCaption(String floorCaption){
		this.floorCaption = floorCaption;
	}
	public String getRoomNum(){
		return this.roomNum;
	}
	
	public void setRoomNum(String roomNum){
		this.roomNum = roomNum;
	}
	public String getFloorId(){
		return this.floorId;
	}
	
	public void setFloorId(String floorId){
		this.floorId = floorId;
	}
	public String getCompany(){
		return this.company;
	}
	
	public void setCompany(String company){
		this.company = company;
	}
	public String getFloorRoomCount(){
		return this.floorRoomCount;
	}
	
	public void setFloorRoomCount(String floorRoomCount){
		this.floorRoomCount = floorRoomCount;
	}
	
	public void setBbmPark(com.common.BuildingBaseManager.entity.BbmPark bbmPark){
		this.bbmPark = bbmPark;
	}
	
	public com.common.BuildingBaseManager.entity.BbmPark getBbmPark(){
		return this.bbmPark;
	}
	
	public void setBbmBuilding(com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding){
		this.bbmBuilding = bbmBuilding;
	}
	
	public com.common.BuildingBaseManager.entity.BbmBuilding getBbmBuilding(){
		return this.bbmBuilding;
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
		result = prime * result + ((floorNo == null) ? 0 : floorNo.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((useStatus == null) ? 0 : useStatus.hashCode());
		result = prime * result + ((floorCaption == null) ? 0 : floorCaption.hashCode());
		result = prime * result + ((roomNum == null) ? 0 : roomNum.hashCode());
		result = prime * result + ((floorId == null) ? 0 : floorId.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((floorRoomCount == null) ? 0 : floorRoomCount.hashCode());
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
		final BbmFloor other = (BbmFloor) obj;
		if (floorNo == null) {
			if (other.floorNo != null)
				return false;
		} else if (!floorNo.equals(other.floorNo))
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (useStatus == null) {
			if (other.useStatus != null)
				return false;
		} else if (!useStatus.equals(other.useStatus))
			return false;
		if (floorCaption == null) {
			if (other.floorCaption != null)
				return false;
		} else if (!floorCaption.equals(other.floorCaption))
			return false;
		if (roomNum == null) {
			if (other.roomNum != null)
				return false;
		} else if (!roomNum.equals(other.roomNum))
			return false;
		if (floorId == null) {
			if (other.floorId != null)
				return false;
		} else if (!floorId.equals(other.floorId))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (floorRoomCount == null) {
			if (other.floorRoomCount != null)
				return false;
		} else if (!floorRoomCount.equals(other.floorRoomCount))
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