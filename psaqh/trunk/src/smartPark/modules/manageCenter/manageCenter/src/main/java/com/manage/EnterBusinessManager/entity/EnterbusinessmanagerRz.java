/**
 *
 */
package com.manage.EnterBusinessManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
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
	

	@Column(name = "RZ_MANAGER_")
	@Length(max=36)
	private String rzManager;//企业管理员

	@Column(name = "RZ_DATE_")
	@Length(max=20)
	private String rzDate;//入驻时间

	@Column(name = "RZ_REMARK_")
	@Length(max=200)
	private String rzRemark;//企业备注

	@Column(name = "BUILDING_ID_")
	@Length(max=36)
	private String buildingId;//楼栋ID

	@Column(name = "RZ_BUSS_")
	@Length(max=2)
	private String rzBuss;//企业主营
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@Column(name = "en_type_id_")
	@Length(max=36)
	private String enTypeId;//企业类型ID

	@Column(name = "RZ_SIGN_")
	@Length(max=8)
	private String rzSign;//企业码

	@Column(name = "RZ_MEM_")
	@Length(max=36)
	private String rzMem;//会员信息

	@Column(name = "RZ_TELEPHONE_")
	@Length(max=16)
	private String rzTelephone;//联系方式

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID
	
	
	public String getRzManager(){
		return this.rzManager;
	}
	
	public void setRzManager(String rzManager){
		this.rzManager = rzManager;
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
	public String getEnTypeId(){
		return this.enTypeId;
	}
	
	public void setEnTypeId(String enTypeId){
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
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rzManager == null) ? 0 : rzManager.hashCode());
		result = prime * result + ((rzDate == null) ? 0 : rzDate.hashCode());
		result = prime * result + ((rzRemark == null) ? 0 : rzRemark.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((rzBuss == null) ? 0 : rzBuss.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((enTypeId == null) ? 0 : enTypeId.hashCode());
		result = prime * result + ((rzSign == null) ? 0 : rzSign.hashCode());
		result = prime * result + ((rzMem == null) ? 0 : rzMem.hashCode());
		result = prime * result + ((rzTelephone == null) ? 0 : rzTelephone.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
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
		final EnterbusinessmanagerRz other = (EnterbusinessmanagerRz) obj;
		if (rzManager == null) {
			if (other.rzManager != null)
				return false;
		} else if (!rzManager.equals(other.rzManager))
			return false;
		if (rzDate == null) {
			if (other.rzDate != null)
				return false;
		} else if (!rzDate.equals(other.rzDate))
			return false;
		if (rzRemark == null) {
			if (other.rzRemark != null)
				return false;
		} else if (!rzRemark.equals(other.rzRemark))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (rzBuss == null) {
			if (other.rzBuss != null)
				return false;
		} else if (!rzBuss.equals(other.rzBuss))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (enTypeId == null) {
			if (other.enTypeId != null)
				return false;
		} else if (!enTypeId.equals(other.enTypeId))
			return false;
		if (rzSign == null) {
			if (other.rzSign != null)
				return false;
		} else if (!rzSign.equals(other.rzSign))
			return false;
		if (rzMem == null) {
			if (other.rzMem != null)
				return false;
		} else if (!rzMem.equals(other.rzMem))
			return false;
		if (rzTelephone == null) {
			if (other.rzTelephone != null)
				return false;
		} else if (!rzTelephone.equals(other.rzTelephone))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}