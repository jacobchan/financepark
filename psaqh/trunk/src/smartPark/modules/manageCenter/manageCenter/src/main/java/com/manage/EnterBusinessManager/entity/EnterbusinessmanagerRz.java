package com.manage.EnterBusinessManager.entity;
import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
/**
 * 实体: 入驻企业基本信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_enterbusinessmanager_rz")
public class EnterbusinessmanagerRz implements Domain{
	
	private static final long serialVersionUID = -2526455072813371693L;
	
	
	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="RZ_MANAGER_")
	private MemberInformation rzManager;//企业管理员
	

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ENTREC_ID_")
	private PropertyservicemanagerEntrec entrecId;//物业入驻记录ID

	@Column(name = "RZ_DATE_")
	@Length(max=20)
	private String rzDate;//入驻时间

	@Column(name = "RZ_REMARK_")
	@Length(max=200)
	private String rzRemark;//企业备注

	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID
	
	@Column(name = "FLOOR_ID_")
	@Length(max=36)
	private String floorId;//所在楼层
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROOM_ID_")
	private BbmRoom roomId;//默认单元

	@Column(name = "RZ_BUSS_")
	@Length(max=2)
	private String rzBuss;//企业主营
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="en_type_id_")
	private EtypeEnterprisetype enTypeId;//企业类型ID

	@Column(name = "RZ_SIGN_")
	@Length(max=32)
	private String rzSign;//企业码

	@Column(name = "RZ_MEM_")
	@Length(max=36)
	private String rzMem;//会员信息

	@Column(name = "RZ_TELEPHONE_")
	@Length(max=16)
	private String rzTelephone;//联系方式
	
	@Column(name = "RZ_NAME_")
	@Length(max=128)
	private String rzName;//企业名称

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID
	
	@Column(name = "RZ_LOGO_")
	@Length(max=256)
	private String rzLogo;//企业logo
	
	@Column(name = "RZ_TYPE_")
	@Length(max=50)
	private String rzType;//上市类型
	
	@Column(name = "RZ_PROPERTY_")
	@Length(max=50)
	private String rzProperty;//企业性质
	
	@Column(name = "RZ_URL_")
	@Length(max=256)
	private String rzUrl;//企业网址
	
	@Column(name = "RZ_IMAGES_")
	private String rzImages;//企业宣传图
	
	@Column(name = "PRODUCT_DISCRIPTIO_")
	private String productDiscriptio;//产品描述
	
	@Column(name = "ATTENTION_COUNT_")
	@Length(max=256)
	private String attentionCount;//关注次数
	
	@Column(name = "SCAN_COUNT_")
	private String scanCount;//浏览次数
	
	@Transient
	private InformationLegal legal;//企业法人
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}


	/**新增园区字段   end**/
	public String getProductDiscriptio() {
		return productDiscriptio;
	}

	public InformationLegal getLegal() {
		return legal;
	}

	public void setLegal(InformationLegal legal) {
		this.legal = legal;
	}

	public void setProductDiscriptio(String productDiscriptio) {
		this.productDiscriptio = productDiscriptio;
	}

	public String getAttentionCount() {
		return attentionCount;
	}

	public void setAttentionCount(String attentionCount) {
		this.attentionCount = attentionCount;
	}

	public String getScanCount() {
		return scanCount;
	}

	public void setScanCount(String scanCount) {
		this.scanCount = scanCount;
	}

	public BbmRoom getRoomId() {
		return roomId;
	}

	public void setRoomId(BbmRoom roomId) {
		this.roomId = roomId;
	}

	public String getRzImages() {
		return rzImages;
	}

	public void setRzImages(String rzImages) {
		this.rzImages = rzImages;
	}

	public String getRzLogo() {
		return rzLogo;
	}

	public void setRzLogo(String rzLogo) {
		this.rzLogo = rzLogo;
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

	public String getRzUrl() {
		return rzUrl;
	}

	public void setRzUrl(String rzUrl) {
		this.rzUrl = rzUrl;
	}

	public String getRzName() {
		return rzName;
	}

	public void setRzName(String rzName) {
		this.rzName = rzName;
	}

	public MemberInformation getRzManager() {
		return rzManager;
	}

	public void setRzManager(MemberInformation rzManager) {
		this.rzManager = rzManager;
	}

	public PropertyservicemanagerEntrec getEntrecId() {
		return entrecId;
	}

	public void setEntrecId(PropertyservicemanagerEntrec entrecId) {
		this.entrecId = entrecId;
	}

	public String getRzDate(){
		return this.rzDate;
	}
	
	public void setRzDate(String rzDate){
		this.rzDate = rzDate;
	}
	public String getRzRemark(){
		return this.rzRemark;
	}
	
	public void setRzRemark(String rzRemark){
		this.rzRemark = rzRemark;
	}
	public String getBuildingId(){
		return this.buildingId;
	}
	
	public void setBuildingId(String buildingId){
		this.buildingId = buildingId;
	}
	public String getRzBuss(){
		return this.rzBuss;
	}
	
	public void setRzBuss(String rzBuss){
		this.rzBuss = rzBuss;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	public EtypeEnterprisetype getEnTypeId() {
		return enTypeId;
	}

	public void setEnTypeId(EtypeEnterprisetype enTypeId) {
		this.enTypeId = enTypeId;
	}

	public String getRzSign(){
		return this.rzSign;
	}
	
	public void setRzSign(String rzSign){
		this.rzSign = rzSign;
	}
	public String getRzMem(){
		return this.rzMem;
	}
	
	public void setRzMem(String rzMem){
		this.rzMem = rzMem;
	}
	public String getRzTelephone(){
		return this.rzTelephone;
	}
	
	public void setRzTelephone(String rzTelephone){
		this.rzTelephone = rzTelephone;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	
	
	

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attentionCount == null) ? 0 : attentionCount.hashCode());
		result = prime * result
				+ ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((enTypeId == null) ? 0 : enTypeId.hashCode());
		result = prime * result
				+ ((entrecId == null) ? 0 : entrecId.hashCode());
		result = prime * result + ((floorId == null) ? 0 : floorId.hashCode());
		result = prime * result + ((legal == null) ? 0 : legal.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result
				+ ((parkName == null) ? 0 : parkName.hashCode());
		result = prime
				* result
				+ ((productDiscriptio == null) ? 0 : productDiscriptio
						.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((rzBuss == null) ? 0 : rzBuss.hashCode());
		result = prime * result + ((rzDate == null) ? 0 : rzDate.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result
				+ ((rzImages == null) ? 0 : rzImages.hashCode());
		result = prime * result + ((rzLogo == null) ? 0 : rzLogo.hashCode());
		result = prime * result
				+ ((rzManager == null) ? 0 : rzManager.hashCode());
		result = prime * result + ((rzMem == null) ? 0 : rzMem.hashCode());
		result = prime * result + ((rzName == null) ? 0 : rzName.hashCode());
		result = prime * result
				+ ((rzProperty == null) ? 0 : rzProperty.hashCode());
		result = prime * result
				+ ((rzRemark == null) ? 0 : rzRemark.hashCode());
		result = prime * result + ((rzSign == null) ? 0 : rzSign.hashCode());
		result = prime * result
				+ ((rzTelephone == null) ? 0 : rzTelephone.hashCode());
		result = prime * result + ((rzType == null) ? 0 : rzType.hashCode());
		result = prime * result + ((rzUrl == null) ? 0 : rzUrl.hashCode());
		result = prime * result
				+ ((scanCount == null) ? 0 : scanCount.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		EnterbusinessmanagerRz other = (EnterbusinessmanagerRz) obj;
		if (attentionCount == null) {
			if (other.attentionCount != null)
				return false;
		} else if (!attentionCount.equals(other.attentionCount))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (enTypeId == null) {
			if (other.enTypeId != null)
				return false;
		} else if (!enTypeId.equals(other.enTypeId))
			return false;
		if (entrecId == null) {
			if (other.entrecId != null)
				return false;
		} else if (!entrecId.equals(other.entrecId))
			return false;
		if (floorId == null) {
			if (other.floorId != null)
				return false;
		} else if (!floorId.equals(other.floorId))
			return false;
		if (legal == null) {
			if (other.legal != null)
				return false;
		} else if (!legal.equals(other.legal))
			return false;
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
		if (productDiscriptio == null) {
			if (other.productDiscriptio != null)
				return false;
		} else if (!productDiscriptio.equals(other.productDiscriptio))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (rzBuss == null) {
			if (other.rzBuss != null)
				return false;
		} else if (!rzBuss.equals(other.rzBuss))
			return false;
		if (rzDate == null) {
			if (other.rzDate != null)
				return false;
		} else if (!rzDate.equals(other.rzDate))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (rzImages == null) {
			if (other.rzImages != null)
				return false;
		} else if (!rzImages.equals(other.rzImages))
			return false;
		if (rzLogo == null) {
			if (other.rzLogo != null)
				return false;
		} else if (!rzLogo.equals(other.rzLogo))
			return false;
		if (rzManager == null) {
			if (other.rzManager != null)
				return false;
		} else if (!rzManager.equals(other.rzManager))
			return false;
		if (rzMem == null) {
			if (other.rzMem != null)
				return false;
		} else if (!rzMem.equals(other.rzMem))
			return false;
		if (rzName == null) {
			if (other.rzName != null)
				return false;
		} else if (!rzName.equals(other.rzName))
			return false;
		if (rzProperty == null) {
			if (other.rzProperty != null)
				return false;
		} else if (!rzProperty.equals(other.rzProperty))
			return false;
		if (rzRemark == null) {
			if (other.rzRemark != null)
				return false;
		} else if (!rzRemark.equals(other.rzRemark))
			return false;
		if (rzSign == null) {
			if (other.rzSign != null)
				return false;
		} else if (!rzSign.equals(other.rzSign))
			return false;
		if (rzTelephone == null) {
			if (other.rzTelephone != null)
				return false;
		} else if (!rzTelephone.equals(other.rzTelephone))
			return false;
		if (rzType == null) {
			if (other.rzType != null)
				return false;
		} else if (!rzType.equals(other.rzType))
			return false;
		if (rzUrl == null) {
			if (other.rzUrl != null)
				return false;
		} else if (!rzUrl.equals(other.rzUrl))
			return false;
		if (scanCount == null) {
			if (other.scanCount != null)
				return false;
		} else if (!scanCount.equals(other.scanCount))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[updateUser=" + updateUser
				+ ", updateTime=" + updateTime + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", rzManager=" + rzManager
				+ ", entrecId=" + entrecId + ", rzDate=" + rzDate
				+ ", rzRemark=" + rzRemark + ", buildingId=" + buildingId
				+ ", floorId=" + floorId + ", roomId=" + roomId + ", rzBuss="
				+ rzBuss + ", rzId=" + rzId + ", enTypeId=" + enTypeId
				+ ", rzSign=" + rzSign + ", rzMem=" + rzMem + ", rzTelephone="
				+ rzTelephone + ", rzName=" + rzName + ", parkId=" + parkId
				+ ", rzLogo=" + rzLogo + ", rzType=" + rzType + ", rzProperty="
				+ rzProperty + ", rzUrl=" + rzUrl + ", rzImages=" + rzImages
				+ ", productDiscriptio=" + productDiscriptio
				+ ", attentionCount=" + attentionCount + ", scanCount="
				+ scanCount + ", legal=" + legal + "]";
	}
}