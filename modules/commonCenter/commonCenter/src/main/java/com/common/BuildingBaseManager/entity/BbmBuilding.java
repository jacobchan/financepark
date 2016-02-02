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
	
	private static final long serialVersionUID = -2235069631583582631L;
	

	@Column(name = "BUILDING_UNIT_COUNT_")
	@Length(max=32)
	private String buildingUnitCount;//楼宇单元数

	@Column(name = "Z_FLOOR_NUM_2")
	@Length(max=2)
	private String floorNum;//招商_楼层数量

	@Column(name = "COMPANY_")
	@Length(max=32)
	private String company;//入驻企业

	@Column(name = "BUILDING_CAPTION")
	@Length(max=32)
	private String buildingCaption;//楼宇说明

	@Column(name = "BUILDING_NO_")
	@Length(max=32)
	private String buildingNo;//楼栋编号
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID

	@Column(name = "Z_USE_STATUS_")
	@Length(max=2)
	private String useStatus;//招商_使用状态

	@Column(name = "Attribute_FLOOR_COUNT_")
	@Length(max=32)
	private String attributeFloorCount;//楼宇层数

	@Column(name = "BUILDING_TYPE_")
	@Length(max=36)
	private String buildingType;//楼栋类别
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARK_ID_")
	private com.common.BuildingBaseManager.entity.BbmPark bbmPark;//园区ID
	
	public String getBuildingUnitCount(){
		return this.buildingUnitCount;
	}
	
	public void setBuildingUnitCount(String buildingUnitCount){
		this.buildingUnitCount = buildingUnitCount;
	}
	public String getFloorNum(){
		return this.floorNum;
	}
	
	public void setFloorNum(String floorNum){
		this.floorNum = floorNum;
	}
	public String getCompany(){
		return this.company;
	}
	
	public void setCompany(String company){
		this.company = company;
	}
	public String getBuildingCaption(){
		return this.buildingCaption;
	}
	
	public void setBuildingCaption(String buildingCaption){
		this.buildingCaption = buildingCaption;
	}
	public String getBuildingNo(){
		return this.buildingNo;
	}
	
	public void setBuildingNo(String buildingNo){
		this.buildingNo = buildingNo;
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
	public String getAttributeFloorCount(){
		return this.attributeFloorCount;
	}
	
	public void setAttributeFloorCount(String attributeFloorCount){
		this.attributeFloorCount = attributeFloorCount;
	}
	public String getBuildingType(){
		return this.buildingType;
	}
	
	public void setBuildingType(String buildingType){
		this.buildingType = buildingType;
	}
	
	public void setBbmPark(com.common.BuildingBaseManager.entity.BbmPark bbmPark){
		this.bbmPark = bbmPark;
	}
	
	public com.common.BuildingBaseManager.entity.BbmPark getBbmPark(){
		return this.bbmPark;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingUnitCount == null) ? 0 : buildingUnitCount.hashCode());
		result = prime * result + ((floorNum == null) ? 0 : floorNum.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((buildingCaption == null) ? 0 : buildingCaption.hashCode());
		result = prime * result + ((buildingNo == null) ? 0 : buildingNo.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((useStatus == null) ? 0 : useStatus.hashCode());
		result = prime * result + ((attributeFloorCount == null) ? 0 : attributeFloorCount.hashCode());
		result = prime * result + ((buildingType == null) ? 0 : buildingType.hashCode());
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
		if (buildingUnitCount == null) {
			if (other.buildingUnitCount != null)
				return false;
		} else if (!buildingUnitCount.equals(other.buildingUnitCount))
			return false;
		if (floorNum == null) {
			if (other.floorNum != null)
				return false;
		} else if (!floorNum.equals(other.floorNum))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (buildingCaption == null) {
			if (other.buildingCaption != null)
				return false;
		} else if (!buildingCaption.equals(other.buildingCaption))
			return false;
		if (buildingNo == null) {
			if (other.buildingNo != null)
				return false;
		} else if (!buildingNo.equals(other.buildingNo))
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
		if (attributeFloorCount == null) {
			if (other.attributeFloorCount != null)
				return false;
		} else if (!attributeFloorCount.equals(other.attributeFloorCount))
			return false;
		if (buildingType == null) {
			if (other.buildingType != null)
				return false;
		} else if (!buildingType.equals(other.buildingType))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}