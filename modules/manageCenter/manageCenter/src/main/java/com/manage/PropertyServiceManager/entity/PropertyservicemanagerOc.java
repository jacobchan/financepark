/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 一卡通办理申请记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_oc")
public class PropertyservicemanagerOc implements Domain{
	
	private static final long serialVersionUID = 8864663924863234408L;
	

	@Column(name = "OC_WAY_")
	@Length(max=2)
	private String ocWay;//一卡通办理方式
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "OC_ID_")
	@Length(max=36)
	private String ocId;//一卡通预约记录

	@Column(name = "OC_ADDREE_")
	@Length(max=36)
	private String ocAddree;//选择地址

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "OC_STATUS_")
	@Length(max=2)
	private String ocStatus;//一卡通预约状态

	@Column(name = "OC_DATE_")
	@Length(max=20)
	private String ocDate;//一卡通预约时间

	@Column(name = "OC_REMARK_")
	@Length(max=300)
	private String ocRemark;//一卡通其他说明

	@Column(name = "OC_COMP_")
	@Length(max=50)
	private String ocComp;//所属企业名称

	@Column(name = "OC_NUMBER_")
	@Length(max=20)
	private String ocNumber;//一卡通号码
	
	public String getOcWay(){
		return this.ocWay;
	}
	
	public void setOcWay(String ocWay){
		this.ocWay = ocWay;
	}
	public String getOcId(){
		return this.ocId;
	}
	
	public void setOcId(String ocId){
		this.ocId = ocId;
	}
	public String getOcAddree(){
		return this.ocAddree;
	}
	
	public void setOcAddree(String ocAddree){
		this.ocAddree = ocAddree;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getOcStatus(){
		return this.ocStatus;
	}
	
	public void setOcStatus(String ocStatus){
		this.ocStatus = ocStatus;
	}
	public String getOcDate(){
		return this.ocDate;
	}
	
	public void setOcDate(String ocDate){
		this.ocDate = ocDate;
	}
	public String getOcRemark(){
		return this.ocRemark;
	}
	
	public void setOcRemark(String ocRemark){
		this.ocRemark = ocRemark;
	}
	public String getOcComp(){
		return this.ocComp;
	}
	
	public void setOcComp(String ocComp){
		this.ocComp = ocComp;
	}
	public String getOcNumber(){
		return this.ocNumber;
	}
	
	public void setOcNumber(String ocNumber){
		this.ocNumber = ocNumber;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ocWay == null) ? 0 : ocWay.hashCode());
		result = prime * result + ((ocId == null) ? 0 : ocId.hashCode());
		result = prime * result + ((ocAddree == null) ? 0 : ocAddree.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((ocStatus == null) ? 0 : ocStatus.hashCode());
		result = prime * result + ((ocDate == null) ? 0 : ocDate.hashCode());
		result = prime * result + ((ocRemark == null) ? 0 : ocRemark.hashCode());
		result = prime * result + ((ocComp == null) ? 0 : ocComp.hashCode());
		result = prime * result + ((ocNumber == null) ? 0 : ocNumber.hashCode());
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
		final PropertyservicemanagerOc other = (PropertyservicemanagerOc) obj;
		if (ocWay == null) {
			if (other.ocWay != null)
				return false;
		} else if (!ocWay.equals(other.ocWay))
			return false;
		if (ocId == null) {
			if (other.ocId != null)
				return false;
		} else if (!ocId.equals(other.ocId))
			return false;
		if (ocAddree == null) {
			if (other.ocAddree != null)
				return false;
		} else if (!ocAddree.equals(other.ocAddree))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (ocStatus == null) {
			if (other.ocStatus != null)
				return false;
		} else if (!ocStatus.equals(other.ocStatus))
			return false;
		if (ocDate == null) {
			if (other.ocDate != null)
				return false;
		} else if (!ocDate.equals(other.ocDate))
			return false;
		if (ocRemark == null) {
			if (other.ocRemark != null)
				return false;
		} else if (!ocRemark.equals(other.ocRemark))
			return false;
		if (ocComp == null) {
			if (other.ocComp != null)
				return false;
		} else if (!ocComp.equals(other.ocComp))
			return false;
		if (ocNumber == null) {
			if (other.ocNumber != null)
				return false;
		} else if (!ocNumber.equals(other.ocNumber))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}