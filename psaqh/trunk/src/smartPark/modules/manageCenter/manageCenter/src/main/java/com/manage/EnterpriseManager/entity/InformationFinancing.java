/**
 *
 */
package com.manage.EnterpriseManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 融资信息
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_information_financing")
public class InformationFinancing implements Domain{
	
	private static final long serialVersionUID = -8613500289550409415L;
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "FINANCING_PRE_")
	private String financingPre;//持股比例

	@Column(name = "FINANCING_COST_")
	@Length(max=10)
	private String financingCost;//融资估值

	@Column(name = "FINANCING_RE_")
	@Length(max=32)
	private String financingRe;//企业信息ID

	@Column(name = "FINANCING_TIME_")
	@Length(max=32)
	private String financingTime;//融资时间
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "FINANCING_ID_")
	@Length(max=36)
	private String financingId;//ID

	@Column(name = "FINANCING_TP_")
	@Length(max=2)
	private String financingTp;//融资状态

	@Column(name = "FINANCING_NAME_")
	@Length(max=64)
	private String financingName;//融资企业名称

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "FINANCING_AMOUNT_")
	@Length(max=10)
	private String financingAmount;//融资金额

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//企业信息

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "FINANCING_STATUS_")
	private String financingStatus;//发布状态

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "FINANCING_SUB_")
	private String financingSub;//投资主体
	
	@Column(name = "FINANCING_DESCRIBE_")
	private String financingDescribe;//融资描述
	
	@Transient
	private String financingSubValue;//投资主体
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	public String getFinancingSubValue() {
		return financingSubValue;
	}

	public void setFinancingSubValue(String financingSubValue) {
		this.financingSubValue = financingSubValue;
	}

	public String getFinancingDescribe() {
		return financingDescribe;
	}

	public void setFinancingDescribe(String financingDescribe) {
		this.financingDescribe = financingDescribe;
	}

	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getFinancingPre(){
		return this.financingPre;
	}
	
	public void setFinancingPre(String financingPre){
		this.financingPre = financingPre;
	}
	public String getFinancingCost(){
		return this.financingCost;
	}
	
	public void setFinancingCost(String financingCost){
		this.financingCost = financingCost;
	}
	public String getFinancingRe(){
		return this.financingRe;
	}
	
	public void setFinancingRe(String financingRe){
		this.financingRe = financingRe;
	}
	public String getFinancingTime(){
		return this.financingTime;
	}
	
	public void setFinancingTime(String financingTime){
		this.financingTime = financingTime;
	}
	public String getFinancingId(){
		return this.financingId;
	}
	
	public void setFinancingId(String financingId){
		this.financingId = financingId;
	}
	public String getFinancingTp(){
		return this.financingTp;
	}
	
	public void setFinancingTp(String financingTp){
		this.financingTp = financingTp;
	}
	public String getFinancingName(){
		return this.financingName;
	}
	
	public void setFinancingName(String financingName){
		this.financingName = financingName;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getFinancingAmount(){
		return this.financingAmount;
	}
	
	public void setFinancingAmount(String financingAmount){
		this.financingAmount = financingAmount;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getFinancingStatus(){
		return this.financingStatus;
	}
	
	public void setFinancingStatus(String financingStatus){
		this.financingStatus = financingStatus;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getFinancingSub(){
		return this.financingSub;
	}
	
	public void setFinancingSub(String financingSub){
		this.financingSub = financingSub;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((financingPre == null) ? 0 : financingPre.hashCode());
		result = prime * result + ((financingCost == null) ? 0 : financingCost.hashCode());
		result = prime * result + ((financingRe == null) ? 0 : financingRe.hashCode());
		result = prime * result + ((financingTime == null) ? 0 : financingTime.hashCode());
		result = prime * result + ((financingId == null) ? 0 : financingId.hashCode());
		result = prime * result + ((financingTp == null) ? 0 : financingTp.hashCode());
		result = prime * result + ((financingName == null) ? 0 : financingName.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((financingAmount == null) ? 0 : financingAmount.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((financingStatus == null) ? 0 : financingStatus.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((financingSub == null) ? 0 : financingSub.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
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
		final InformationFinancing other = (InformationFinancing) obj;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (financingPre == null) {
			if (other.financingPre != null)
				return false;
		} else if (!financingPre.equals(other.financingPre))
			return false;
		if (financingCost == null) {
			if (other.financingCost != null)
				return false;
		} else if (!financingCost.equals(other.financingCost))
			return false;
		if (financingRe == null) {
			if (other.financingRe != null)
				return false;
		} else if (!financingRe.equals(other.financingRe))
			return false;
		if (financingTime == null) {
			if (other.financingTime != null)
				return false;
		} else if (!financingTime.equals(other.financingTime))
			return false;
		if (financingId == null) {
			if (other.financingId != null)
				return false;
		} else if (!financingId.equals(other.financingId))
			return false;
		if (financingTp == null) {
			if (other.financingTp != null)
				return false;
		} else if (!financingTp.equals(other.financingTp))
			return false;
		if (financingName == null) {
			if (other.financingName != null)
				return false;
		} else if (!financingName.equals(other.financingName))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (financingAmount == null) {
			if (other.financingAmount != null)
				return false;
		} else if (!financingAmount.equals(other.financingAmount))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (financingStatus == null) {
			if (other.financingStatus != null)
				return false;
		} else if (!financingStatus.equals(other.financingStatus))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (financingSub == null) {
			if (other.financingSub != null)
				return false;
		} else if (!financingSub.equals(other.financingSub))
			return false;
		/**新增园区字段   start**/
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
		/**新增园区字段   end**/
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}