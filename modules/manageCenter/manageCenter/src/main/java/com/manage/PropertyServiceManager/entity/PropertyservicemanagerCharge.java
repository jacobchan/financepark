/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 物业收费登记表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_charge")
public class PropertyservicemanagerCharge implements Domain{
	
	private static final long serialVersionUID = -6580344328596110188L;
	

	@Column(name = "CHARGE_UNIT_")
	@Length(max=10)
	private String chargeUnit;//单元号

	@Column(name = "CHARGE_ENDATE_")
	@Length(max=20)
	private String chargeEndate;//截止日期

	@Column(name = "ROOM_ID_")
	@Length(max=36)
	private String roomId;//单元ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "CHARGE_ID_")
	@Length(max=36)
	private String chargeId;//收费登记序列

	@Column(name = "CHARGE_CREATETIME_")
	@Length(max=20)
	private String chargeCreatetime;//登记日期

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CHARGE_TIME_")
	@Length(max=20)
	private String chargeTime;//缴费日期

	@Column(name = "CHARGE_AMOUNT_")
	@Length(max=14)
	private String chargeAmount;//应缴费总额

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CHARGE_BEDATE_")
	@Length(max=20)
	private String chargeBedate;//起始日期

	@Column(name = "USERORDER_ID_")
	@Length(max=36)
	private String userorderId;//用户订单序列

	@Column(name = "CHARGE_COMP_")
	@Length(max=50)
	private String chargeComp;//收费企业名称

	@Column(name = "CHARGE_ISBOOL_")
	@Length(max=2)
	private String chargeIsbool;//是否缴费

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
	
	public String getChargeUnit(){
		return this.chargeUnit;
	}
	
	public void setChargeUnit(String chargeUnit){
		this.chargeUnit = chargeUnit;
	}
	public String getChargeEndate(){
		return this.chargeEndate;
	}
	
	public void setChargeEndate(String chargeEndate){
		this.chargeEndate = chargeEndate;
	}
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRoomId(String roomId){
		this.roomId = roomId;
	}
	public String getChargeId(){
		return this.chargeId;
	}
	
	public void setChargeId(String chargeId){
		this.chargeId = chargeId;
	}
	public String getChargeCreatetime(){
		return this.chargeCreatetime;
	}
	
	public void setChargeCreatetime(String chargeCreatetime){
		this.chargeCreatetime = chargeCreatetime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getChargeTime(){
		return this.chargeTime;
	}
	
	public void setChargeTime(String chargeTime){
		this.chargeTime = chargeTime;
	}
	public String getChargeAmount(){
		return this.chargeAmount;
	}
	
	public void setChargeAmount(String chargeAmount){
		this.chargeAmount = chargeAmount;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getChargeBedate(){
		return this.chargeBedate;
	}
	
	public void setChargeBedate(String chargeBedate){
		this.chargeBedate = chargeBedate;
	}
	public String getUserorderId(){
		return this.userorderId;
	}
	
	public void setUserorderId(String userorderId){
		this.userorderId = userorderId;
	}
	public String getChargeComp(){
		return this.chargeComp;
	}
	
	public void setChargeComp(String chargeComp){
		this.chargeComp = chargeComp;
	}
	public String getChargeIsbool(){
		return this.chargeIsbool;
	}
	
	public void setChargeIsbool(String chargeIsbool){
		this.chargeIsbool = chargeIsbool;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chargeUnit == null) ? 0 : chargeUnit.hashCode());
		result = prime * result + ((chargeEndate == null) ? 0 : chargeEndate.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((chargeId == null) ? 0 : chargeId.hashCode());
		result = prime * result + ((chargeCreatetime == null) ? 0 : chargeCreatetime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((chargeTime == null) ? 0 : chargeTime.hashCode());
		result = prime * result + ((chargeAmount == null) ? 0 : chargeAmount.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((chargeBedate == null) ? 0 : chargeBedate.hashCode());
		result = prime * result + ((userorderId == null) ? 0 : userorderId.hashCode());
		result = prime * result + ((chargeComp == null) ? 0 : chargeComp.hashCode());
		result = prime * result + ((chargeIsbool == null) ? 0 : chargeIsbool.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
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
		final PropertyservicemanagerCharge other = (PropertyservicemanagerCharge) obj;
		if (chargeUnit == null) {
			if (other.chargeUnit != null)
				return false;
		} else if (!chargeUnit.equals(other.chargeUnit))
			return false;
		if (chargeEndate == null) {
			if (other.chargeEndate != null)
				return false;
		} else if (!chargeEndate.equals(other.chargeEndate))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (chargeId == null) {
			if (other.chargeId != null)
				return false;
		} else if (!chargeId.equals(other.chargeId))
			return false;
		if (chargeCreatetime == null) {
			if (other.chargeCreatetime != null)
				return false;
		} else if (!chargeCreatetime.equals(other.chargeCreatetime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (chargeTime == null) {
			if (other.chargeTime != null)
				return false;
		} else if (!chargeTime.equals(other.chargeTime))
			return false;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (chargeBedate == null) {
			if (other.chargeBedate != null)
				return false;
		} else if (!chargeBedate.equals(other.chargeBedate))
			return false;
		if (userorderId == null) {
			if (other.userorderId != null)
				return false;
		} else if (!userorderId.equals(other.userorderId))
			return false;
		if (chargeComp == null) {
			if (other.chargeComp != null)
				return false;
		} else if (!chargeComp.equals(other.chargeComp))
			return false;
		if (chargeIsbool == null) {
			if (other.chargeIsbool != null)
				return false;
		} else if (!chargeIsbool.equals(other.chargeIsbool))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}