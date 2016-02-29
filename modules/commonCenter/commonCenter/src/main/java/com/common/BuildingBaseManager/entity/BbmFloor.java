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
	
	private static final long serialVersionUID = -8973015410789283629L;
	

	@Column(name = "Z_COMPANY_")
	@Length(max=36)
	private String company;//招商_所属企业

	@Column(name = "Z_USE_STATUS_")
	@Length(max=2)
	private String useStatus;//招商_使用状态

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID

	@Column(name = "Z_ROOM_NUM_")
	@Length(max=2)
	private String roomNum;//招商_房间个数

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID

	@Column(name = "Z_ROOM_NO_")
	@Length(max=36)
	private String roomNo;//招商_房间编号

	@Column(name = "FLOOR_ROOM_COUNT_")
	@Length(max=32)
	private String floorRoomCount;//楼层单元数量

	@Column(name = "FLOOR_CAPTION_")
	@Length(max=32)
	private String floorCaption;//楼层说明

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FLOOR_ID_")
	@Length(max=36)
	private String floorId;//楼层ID

	@Column(name = "FLOOR_NO_")
	@Length(max=32)
	private String floorNo;//楼层编号

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sp__BUILDING_ID_")
	private com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding;//320_楼栋ID
	
	public String getCompany(){
		return this.company;
	}
	
	public void setCompany(String company){
		this.company = company;
	}
	public String getUseStatus(){
		return this.useStatus;
	}
	
	public void setUseStatus(String useStatus){
		this.useStatus = useStatus;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getRoomNum(){
		return this.roomNum;
	}
	
	public void setRoomNum(String roomNum){
		this.roomNum = roomNum;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getBuildingId(){
		return this.buildingId;
	}
	
	public void setBuildingId(String buildingId){
		this.buildingId = buildingId;
	}
	public String getRoomNo(){
		return this.roomNo;
	}
	
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;
	}
	public String getFloorRoomCount(){
		return this.floorRoomCount;
	}
	
	public void setFloorRoomCount(String floorRoomCount){
		this.floorRoomCount = floorRoomCount;
	}
	public String getFloorCaption(){
		return this.floorCaption;
	}
	
	public void setFloorCaption(String floorCaption){
		this.floorCaption = floorCaption;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getFloorId(){
		return this.floorId;
	}
	
	public void setFloorId(String floorId){
		this.floorId = floorId;
	}
	public String getFloorNo(){
		return this.floorNo;
	}
	
	public void setFloorNo(String floorNo){
		this.floorNo = floorNo;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	public void setBbmBuilding(com.common.BuildingBaseManager.entity.BbmBuilding bbmBuilding){
		this.bbmBuilding = bbmBuilding;
	}
	
	public com.common.BuildingBaseManager.entity.BbmBuilding getBbmBuilding(){
		return this.bbmBuilding;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((useStatus == null) ? 0 : useStatus.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((roomNum == null) ? 0 : roomNum.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((floorRoomCount == null) ? 0 : floorRoomCount.hashCode());
		result = prime * result + ((floorCaption == null) ? 0 : floorCaption.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((floorId == null) ? 0 : floorId.hashCode());
		result = prime * result + ((floorNo == null) ? 0 : floorNo.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
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
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (useStatus == null) {
			if (other.useStatus != null)
				return false;
		} else if (!useStatus.equals(other.useStatus))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (roomNum == null) {
			if (other.roomNum != null)
				return false;
		} else if (!roomNum.equals(other.roomNum))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (floorRoomCount == null) {
			if (other.floorRoomCount != null)
				return false;
		} else if (!floorRoomCount.equals(other.floorRoomCount))
			return false;
		if (floorCaption == null) {
			if (other.floorCaption != null)
				return false;
		} else if (!floorCaption.equals(other.floorCaption))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (floorId == null) {
			if (other.floorId != null)
				return false;
		} else if (!floorId.equals(other.floorId))
			return false;
		if (floorNo == null) {
			if (other.floorNo != null)
				return false;
		} else if (!floorNo.equals(other.floorNo))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}