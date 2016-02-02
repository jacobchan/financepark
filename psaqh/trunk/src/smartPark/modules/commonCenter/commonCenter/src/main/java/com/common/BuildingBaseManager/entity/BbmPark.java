/**
 *
 */
package com.common.BuildingBaseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 园区信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_bbm_park_")
public class BbmPark implements Domain{
	
	private static final long serialVersionUID = 1175184789817136359L;
	

	@Column(name = "PARK_NAME_")
	@Length(max=32)
	private String parkName;//园区名称

	@Column(name = "MAIN_INDUSTRY")
	@Length(max=56)
	private String mainIndustry;//主导服务

	@Column(name = "ADDRESS_")
	@Length(max=56)
	private String address;//地址

	@Column(name = "TEL_")
	@Length(max=32)
	private String tel;//联系电话

	@Column(name = "PARK_INTRODUCE_")
	@Length(max=224)
	private String parkIntroduce;//园区简介

	@Column(name = "MANAGER_")
	@Length(max=32)
	private String manager;//园区负责人

	@Column(name = "EMAIL_")
	@Length(max=32)
	private String email;//邮箱

	@Column(name = "BUILD_DATE")
	@Length(max=32)
	private String buildDate;//成立时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID
	
	public String getParkName(){
		return this.parkName;
	}
	
	public void setParkName(String parkName){
		this.parkName = parkName;
	}
	public String getMainIndustry(){
		return this.mainIndustry;
	}
	
	public void setMainIndustry(String mainIndustry){
		this.mainIndustry = mainIndustry;
	}
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getTel(){
		return this.tel;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getParkIntroduce(){
		return this.parkIntroduce;
	}
	
	public void setParkIntroduce(String parkIntroduce){
		this.parkIntroduce = parkIntroduce;
	}
	public String getManager(){
		return this.manager;
	}
	
	public void setManager(String manager){
		this.manager = manager;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getBuildDate(){
		return this.buildDate;
	}
	
	public void setBuildDate(String buildDate){
		this.buildDate = buildDate;
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
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((mainIndustry == null) ? 0 : mainIndustry.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((parkIntroduce == null) ? 0 : parkIntroduce.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((buildDate == null) ? 0 : buildDate.hashCode());
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
		final BbmPark other = (BbmPark) obj;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		if (mainIndustry == null) {
			if (other.mainIndustry != null)
				return false;
		} else if (!mainIndustry.equals(other.mainIndustry))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (parkIntroduce == null) {
			if (other.parkIntroduce != null)
				return false;
		} else if (!parkIntroduce.equals(other.parkIntroduce))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (buildDate == null) {
			if (other.buildDate != null)
				return false;
		} else if (!buildDate.equals(other.buildDate))
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