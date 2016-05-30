/**
 *
 */
package com.common.BuildingBaseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 楼栋基础信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_bbm_building_")
public class BbmBuilding implements Domain{
	
	private static final long serialVersionUID = 1299058536300579348L;
	
	@Column(name = "BUILDING_NO_")
	@Length(max=32)
	private String buildingNo;//楼栋编号

	@Column(name = "BUILDING_CAPTION")
	@Length(max=32)
	private String buildingCaption;//楼宇说明

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "BUILDING_UNIT_COUNT_")
	@Length(max=32)
	private String buildingUnitCount;//楼宇单元数

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "Attribute_FLOOR_COUNT_")
	@Length(max=32)
	private String attributeFloorCount;//楼宇层数

	@Column(name = "BUILDING_IMAGE_")
	@Length(max=100)
	private String buildingImage;//楼栋图片

	@Column(name = "BUILDING_TYPE_")
	@Length(max=36)
	private String buildingType;//楼栋类别
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID

	@Column(name = "Z_USE_STATUS_")
	@Length(max=2)
	private String useStatus;//招商_使用状态
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PARK_ID_")
	private com.common.BuildingBaseManager.entity.BbmPark bbmPark;//320_园区ID
	
	@Column(name = "BUILDING_NAME_")
	@Length(max=32)
	private String buildingName;//楼栋名称
	
    /**新增园区字段   start**/
//	@Column(name = "PARK_NAME_")
//	@Length(max=256)
//	private String parkName;//园区名称
	
//	@Column(name = "PARK_ID_")
//	@Length(max=36)
//	private String parkId;//园区id
	/**新增园区字段   end**/  
	
	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingNo(){
		return this.buildingNo;
	}
	
	public void setBuildingNo(String buildingNo){
		this.buildingNo = buildingNo;
	}
	public String getBuildingCaption(){
		return this.buildingCaption;
	}
	
	public void setBuildingCaption(String buildingCaption){
		this.buildingCaption = buildingCaption;
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
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getBuildingUnitCount(){
		return this.buildingUnitCount;
	}
	
	public void setBuildingUnitCount(String buildingUnitCount){
		this.buildingUnitCount = buildingUnitCount;
	}
	
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getAttributeFloorCount(){
		return this.attributeFloorCount;
	}
	
	public void setAttributeFloorCount(String attributeFloorCount){
		this.attributeFloorCount = attributeFloorCount;
	}
	public String getBuildingImage(){
		return this.buildingImage;
	}
	
	public void setBuildingImage(String buildingImage){
		this.buildingImage = buildingImage;
	}
	public String getBuildingType(){
		return this.buildingType;
	}
	
	public void setBuildingType(String buildingType){
		this.buildingType = buildingType;
	}
	public String getBuildingId(){
		return this.buildingId;
	}
	
	public void setBuildingId(String buildingId){
		this.buildingId = buildingId;
	}
	public String getUseStatus(){
		return this.useStatus;
	}
	
	public void setUseStatus(String useStatus){
		this.useStatus = useStatus;
	}
	
	public void setBbmPark(com.common.BuildingBaseManager.entity.BbmPark bbmPark){
		this.bbmPark = bbmPark;
	}
	
	public com.common.BuildingBaseManager.entity.BbmPark getBbmPark(){
		return this.bbmPark;
	}
	/**新增园区字段   start**/
//	public String getParkName() {
//		return parkName;
//	}
//
//	public void setParkName(String parkName) {
//		this.parkName = parkName;
//	}

//	public String getParkId() {
//		return parkId;
//	}
//
//	public void setParkId(String parkId) {
//		this.parkId = parkId;
//	}
	/**新增园区字段   end**/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingNo == null) ? 0 : buildingNo.hashCode());
		result = prime * result + ((buildingCaption == null) ? 0 : buildingCaption.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((buildingUnitCount == null) ? 0 : buildingUnitCount.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((attributeFloorCount == null) ? 0 : attributeFloorCount.hashCode());
		result = prime * result + ((buildingImage == null) ? 0 : buildingImage.hashCode());
		result = prime * result + ((buildingType == null) ? 0 : buildingType.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((useStatus == null) ? 0 : useStatus.hashCode());
		
		/**新增园区字段   start**/
//		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
//		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
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
		final BbmBuilding other = (BbmBuilding) obj;
		if (buildingNo == null) {
			if (other.buildingNo != null)
				return false;
		} else if (!buildingNo.equals(other.buildingNo))
			return false;
		if (buildingCaption == null) {
			if (other.buildingCaption != null)
				return false;
		} else if (!buildingCaption.equals(other.buildingCaption))
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
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (buildingUnitCount == null) {
			if (other.buildingUnitCount != null)
				return false;
		} else if (!buildingUnitCount.equals(other.buildingUnitCount))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (attributeFloorCount == null) {
			if (other.attributeFloorCount != null)
				return false;
		} else if (!attributeFloorCount.equals(other.attributeFloorCount))
			return false;
		if (buildingImage == null) {
			if (other.buildingImage != null)
				return false;
		} else if (!buildingImage.equals(other.buildingImage))
			return false;
		if (buildingType == null) {
			if (other.buildingType != null)
				return false;
		} else if (!buildingType.equals(other.buildingType))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (useStatus == null) {
			if (other.useStatus != null)
				return false;
		} else if (!useStatus.equals(other.useStatus))
			return false;
		/**新增园区字段   start**/
//		if (parkId == null) {
//			if (other.parkId != null)
//				return false;
//		} else if (!parkId.equals(other.parkId))
//			return false;
//		if (parkName == null) {
//			if (other.parkName != null)
//				return false;
//		} else if (!parkName.equals(other.parkName))
//			return false;
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}