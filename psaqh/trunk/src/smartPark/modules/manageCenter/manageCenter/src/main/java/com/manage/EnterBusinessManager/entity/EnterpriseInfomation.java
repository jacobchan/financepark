package com.manage.EnterBusinessManager.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.gsoft.framework.core.dataobj.Domain;
@SuppressWarnings("serial")
@Entity
@Table(name = "sp_enterbusinessmanager_rz")
public class EnterpriseInfomation implements Domain {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
	
	@Column(name = "RZ_NAME_")
	@Length(max=128)
	private String rzName; //企业名称
	
	@Column(name = "RZ_SIGN_")
	@Length(max=32)
	private String rzSign; //企业码
	
	@Column(name = "RZ_DATE_")
	@Length(max=20)
	private Date rzDate; //入驻时间
	
	@Column(name = "en_type_id_")
	@Length(max=36)
	private String enTypeName; //行业类型
	
	@Column(name = "RZ_TYPE_")
	@Length(max=50)
	private String rzType; //上市类型
	
	@Column(name = "RZ_PROPERTY_")
	@Length(max=50)
	private String rzProperty; //企业性质
	
	@Column(name = "RZ_MANAGER_")
	@Length(max=50)
	private String memberName; //企业管理员
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId; //园区
	
	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId; //楼栋
	
	@Column(name = "ROOM_ID_")
	@Length(max=36)
	private String roomId; //单元
	
	@Column(name = "FLOOR_ID_")
	@Length(max=36)
	private String floorId; //楼层
	
	@Column(name = "RZ_LOGO_")
	@Length(max=256)
	private String rzLogo; //logo
	
	@Column(name = "RZ_URL_")
	@Length(max=256)
	private String rzUrl; //网址

	@Column(name = "RZ_REMARK_")
	@Length(max=200)
	private String rzRemark; //描述
	
	public EnterpriseInfomation() {
		super();
	}

	public EnterpriseInfomation(String rzId, String rzName, String rzSign,
			Date rzDate, String enTypeName, String rzType, String rzProperty,
			String memberName, String parkId, String buildingId, String roomId,
			String floorId, String rzLogo, String rzUrl, String rzRemark) {
		super();
		this.rzId = rzId;
		this.rzName = rzName;
		this.rzSign = rzSign;
		this.rzDate = rzDate;
		this.enTypeName = enTypeName;
		this.rzType = rzType;
		this.rzProperty = rzProperty;
		this.memberName = memberName;
		this.parkId = parkId;
		this.buildingId = buildingId;
		this.roomId = roomId;
		this.floorId = floorId;
		this.rzLogo = rzLogo;
		this.rzUrl = rzUrl;
		this.rzRemark = rzRemark;
	}

	public String getRzId() {
		return rzId;
	}

	public void setRzId(String rzId) {
		this.rzId = rzId;
	}

	public String getRzName() {
		return rzName;
	}

	public void setRzName(String rzName) {
		this.rzName = rzName;
	}

	public String getRzSign() {
		return rzSign;
	}

	public void setRzSign(String rzSign) {
		this.rzSign = rzSign;
	}

	public Date getRzDate() {
		return rzDate;
	}

	public void setRzDate(Date rzDate) {
		this.rzDate = rzDate;
	}

	public String getEnTypeName() {
		return enTypeName;
	}

	public void setEnTypeName(String enTypeName) {
		this.enTypeName = enTypeName;
	}

	public String getRzType() {
		return rzType;
	}

	public void setRzType(String rzType) {
		this.rzType = rzType;
	}

	public String getRzProperty() {
		return rzProperty;
	}

	public void setRzProperty(String rzProperty) {
		this.rzProperty = rzProperty;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getRzLogo() {
		return rzLogo;
	}

	public void setRzLogo(String rzLogo) {
		this.rzLogo = rzLogo;
	}

	public String getRzUrl() {
		return rzUrl;
	}

	public void setRzUrl(String rzUrl) {
		this.rzUrl = rzUrl;
	}

	public String getRzRemark() {
		return rzRemark;
	}

	public void setRzRemark(String rzRemark) {
		this.rzRemark = rzRemark;
	}
	
	@Override
	public String toString() {
		return "[rzId=" + rzId + ", rzName=" + rzName
				+ ", rzSign=" + rzSign + ", rzDate=" + rzDate + ", enTypeName="
				+ enTypeName + ", rzType=" + rzType + ", rzProperty="
				+ rzProperty + ", memberName=" + memberName + ", parkId="
				+ parkId + ", buildingId=" + buildingId + ", roomId=" + roomId
				+ ", floorId=" + floorId + ", rzLogo=" + rzLogo + ", rzUrl="
				+ rzUrl + ", rzRemark=" + rzRemark + "]";
	}
}