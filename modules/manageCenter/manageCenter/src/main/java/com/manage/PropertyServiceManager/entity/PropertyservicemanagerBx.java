/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 物业报修记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_bx")
public class PropertyservicemanagerBx implements Domain{
	
	private static final long serialVersionUID = 438289935878401876L;
	

	@Column(name = "BX_FUJIAN")
	@Length(max=50)
	private String bxFujian;//附件

	@Column(name = "BX_PROJECT_")
	@Length(max=2)
	private String bxProject;//报修项目

	@Column(name = "BX_REMARK_")
	@Length(max=300)
	private String bxRemark;//描述

	@Column(name = "BX_WAY_")
	@Length(max=2)
	private String bxWay;//报修方式

	@Column(name = "BX_COMP_")
	@Length(max=50)
	private String bxComp;//企业名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "BX_ID_")
	@Length(max=36)
	private String bxId;//报修记录ID

	@Column(name = "BX_AMOUNT_")
	@Length(max=14)
	private String bxAmount;//维修总价

	@Column(name = "BX_TYPE_")
	@Length(max=2)
	private String bxType;//报修类型

	@Column(name = "BX_ADDRESS_")
	@Length(max=36)
	private String bxAddress;//维修地址
	
	public String getBxFujian(){
		return this.bxFujian;
	}
	
	public void setBxFujian(String bxFujian){
		this.bxFujian = bxFujian;
	}
	public String getBxProject(){
		return this.bxProject;
	}
	
	public void setBxProject(String bxProject){
		this.bxProject = bxProject;
	}
	public String getBxRemark(){
		return this.bxRemark;
	}
	
	public void setBxRemark(String bxRemark){
		this.bxRemark = bxRemark;
	}
	public String getBxWay(){
		return this.bxWay;
	}
	
	public void setBxWay(String bxWay){
		this.bxWay = bxWay;
	}
	public String getBxComp(){
		return this.bxComp;
	}
	
	public void setBxComp(String bxComp){
		this.bxComp = bxComp;
	}
	public String getBxId(){
		return this.bxId;
	}
	
	public void setBxId(String bxId){
		this.bxId = bxId;
	}
	public String getBxAmount(){
		return this.bxAmount;
	}
	
	public void setBxAmount(String bxAmount){
		this.bxAmount = bxAmount;
	}
	public String getBxType(){
		return this.bxType;
	}
	
	public void setBxType(String bxType){
		this.bxType = bxType;
	}
	public String getBxAddress(){
		return this.bxAddress;
	}
	
	public void setBxAddress(String bxAddress){
		this.bxAddress = bxAddress;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bxFujian == null) ? 0 : bxFujian.hashCode());
		result = prime * result + ((bxProject == null) ? 0 : bxProject.hashCode());
		result = prime * result + ((bxRemark == null) ? 0 : bxRemark.hashCode());
		result = prime * result + ((bxWay == null) ? 0 : bxWay.hashCode());
		result = prime * result + ((bxComp == null) ? 0 : bxComp.hashCode());
		result = prime * result + ((bxId == null) ? 0 : bxId.hashCode());
		result = prime * result + ((bxAmount == null) ? 0 : bxAmount.hashCode());
		result = prime * result + ((bxType == null) ? 0 : bxType.hashCode());
		result = prime * result + ((bxAddress == null) ? 0 : bxAddress.hashCode());
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
		final PropertyservicemanagerBx other = (PropertyservicemanagerBx) obj;
		if (bxFujian == null) {
			if (other.bxFujian != null)
				return false;
		} else if (!bxFujian.equals(other.bxFujian))
			return false;
		if (bxProject == null) {
			if (other.bxProject != null)
				return false;
		} else if (!bxProject.equals(other.bxProject))
			return false;
		if (bxRemark == null) {
			if (other.bxRemark != null)
				return false;
		} else if (!bxRemark.equals(other.bxRemark))
			return false;
		if (bxWay == null) {
			if (other.bxWay != null)
				return false;
		} else if (!bxWay.equals(other.bxWay))
			return false;
		if (bxComp == null) {
			if (other.bxComp != null)
				return false;
		} else if (!bxComp.equals(other.bxComp))
			return false;
		if (bxId == null) {
			if (other.bxId != null)
				return false;
		} else if (!bxId.equals(other.bxId))
			return false;
		if (bxAmount == null) {
			if (other.bxAmount != null)
				return false;
		} else if (!bxAmount.equals(other.bxAmount))
			return false;
		if (bxType == null) {
			if (other.bxType != null)
				return false;
		} else if (!bxType.equals(other.bxType))
			return false;
		if (bxAddress == null) {
			if (other.bxAddress != null)
				return false;
		} else if (!bxAddress.equals(other.bxAddress))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}