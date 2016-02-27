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
	
	private static final long serialVersionUID = -2561579241940767878L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID

	@Column(name = "PARK_NAME_")
	@Length(max=32)
	private String parkName;//园区名称

	@Column(name = "EMAIL_")
	@Length(max=32)
	private String email;//园区邮箱

	@Column(name = "ADDRESS_")
	@Length(max=56)
	private String address;//园区地址

	@Column(name = "MAIN_INDUSTRY")
	@Length(max=56)
	private String mainIndustry;//主导服务

	@Column(name = "PARK_INTRODUCE_")
	@Length(max=224)
	private String parkIntroduce;//园区简介

	@Column(name = "BUILD_DATE")
	@Length(max=32)
	private String buildDate;//成立时间

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "MANAGER_")
	@Length(max=32)
	private String manager;//园区负责人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "TEL_")
	@Length(max=32)
	private String tel;//联系电话

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "BACKGROUND_IMAGE_")
	@Length(max=100)
	private String backgroundImage;//园区背景图
	
	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getParkName(){
		return this.parkName;
	}
	
	public void setParkName(String parkName){
		this.parkName = parkName;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getMainIndustry(){
		return this.mainIndustry;
	}
	
	public void setMainIndustry(String mainIndustry){
		this.mainIndustry = mainIndustry;
	}
	public String getParkIntroduce(){
		return this.parkIntroduce;
	}
	
	public void setParkIntroduce(String parkIntroduce){
		this.parkIntroduce = parkIntroduce;
	}
	public String getBuildDate(){
		return this.buildDate;
	}
	
	public void setBuildDate(String buildDate){
		this.buildDate = buildDate;
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
	public String getManager(){
		return this.manager;
	}
	
	public void setManager(String manager){
		this.manager = manager;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getTel(){
		return this.tel;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((mainIndustry == null) ? 0 : mainIndustry.hashCode());
		result = prime * result + ((parkIntroduce == null) ? 0 : parkIntroduce.hashCode());
		result = prime * result + ((buildDate == null) ? 0 : buildDate.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (mainIndustry == null) {
			if (other.mainIndustry != null)
				return false;
		} else if (!mainIndustry.equals(other.mainIndustry))
			return false;
		if (parkIntroduce == null) {
			if (other.parkIntroduce != null)
				return false;
		} else if (!parkIntroduce.equals(other.parkIntroduce))
			return false;
		if (buildDate == null) {
			if (other.buildDate != null)
				return false;
		} else if (!buildDate.equals(other.buildDate))
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
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}