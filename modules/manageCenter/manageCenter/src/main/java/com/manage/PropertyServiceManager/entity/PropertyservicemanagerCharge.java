/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import java.math.BigDecimal;

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
	
	private static final long serialVersionUID = -6701377551062721156L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "CHARGE_ID_")
	@Length(max=36)
	private String chargeId;//收费登记序列
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USERORDER_ID_")
	private com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder;//用户订单

	@Column(name = "CHARGE_CREATETIME_")
	@Length(max=20)
	private String chargeCreatetime;//登记日期

	@Column(name = "CHARGE_AMOUNT_")
	private BigDecimal chargeAmount;//应缴费总额

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROOM_ID_")
	private com.common.BuildingBaseManager.entity.BbmRoom bbmRoom;//单元

	@Column(name = "CHARGE_ISBOOL_")
	@Length(max=2)
	private String chargeIsbool;//是否缴费

	@Column(name = "CHARGE_COMP_")
	@Length(max=50)
	private String chargeComp;//收费企业名称

	@Column(name = "CHARGE_UNIT_")
	@Length(max=10)
	private String chargeUnit;//单元号

	@Column(name = "CHARGE_BEDATE_")
	@Length(max=20)
	private String chargeBedate;//起始日期

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@Column(name = "CHARGE_TIME_")
	@Length(max=20)
	private String chargeTime;//缴费日期

	@Column(name = "CHARGE_ENDATE_")
	@Length(max=20)
	private String chargeEndate;//截止日期

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public com.common.OrderManager.entity.OrdermanagerUserorder getOrdermanagerUserorder() {
		return ordermanagerUserorder;
	}

	public void setOrdermanagerUserorder(
			com.common.OrderManager.entity.OrdermanagerUserorder ordermanagerUserorder) {
		this.ordermanagerUserorder = ordermanagerUserorder;
	}

	public String getChargeCreatetime() {
		return chargeCreatetime;
	}

	public void setChargeCreatetime(String chargeCreatetime) {
		this.chargeCreatetime = chargeCreatetime;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public com.common.BuildingBaseManager.entity.BbmRoom getBbmRoom() {
		return bbmRoom;
	}

	public void setBbmRoom(com.common.BuildingBaseManager.entity.BbmRoom bbmRoom) {
		this.bbmRoom = bbmRoom;
	}

	public String getChargeIsbool() {
		return chargeIsbool;
	}

	public void setChargeIsbool(String chargeIsbool) {
		this.chargeIsbool = chargeIsbool;
	}

	public String getChargeComp() {
		return chargeComp;
	}

	public void setChargeComp(String chargeComp) {
		this.chargeComp = chargeComp;
	}

	public String getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public String getChargeBedate() {
		return chargeBedate;
	}

	public void setChargeBedate(String chargeBedate) {
		this.chargeBedate = chargeBedate;
	}

	public String getRzId() {
		return rzId;
	}

	public void setRzId(String rzId) {
		this.rzId = rzId;
	}

	public String getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getChargeEndate() {
		return chargeEndate;
	}

	public void setChargeEndate(String chargeEndate) {
		this.chargeEndate = chargeEndate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bbmRoom == null) ? 0 : bbmRoom.hashCode());
		result = prime * result
				+ ((chargeAmount == null) ? 0 : chargeAmount.hashCode());
		result = prime * result
				+ ((chargeBedate == null) ? 0 : chargeBedate.hashCode());
		result = prime * result
				+ ((chargeComp == null) ? 0 : chargeComp.hashCode());
		result = prime
				* result
				+ ((chargeCreatetime == null) ? 0 : chargeCreatetime.hashCode());
		result = prime * result
				+ ((chargeEndate == null) ? 0 : chargeEndate.hashCode());
		result = prime * result
				+ ((chargeId == null) ? 0 : chargeId.hashCode());
		result = prime * result
				+ ((chargeIsbool == null) ? 0 : chargeIsbool.hashCode());
		result = prime * result
				+ ((chargeTime == null) ? 0 : chargeTime.hashCode());
		result = prime * result
				+ ((chargeUnit == null) ? 0 : chargeUnit.hashCode());
		result = prime
				* result
				+ ((ordermanagerUserorder == null) ? 0 : ordermanagerUserorder
						.hashCode());
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
		PropertyservicemanagerCharge other = (PropertyservicemanagerCharge) obj;
		if (bbmRoom == null) {
			if (other.bbmRoom != null)
				return false;
		} else if (!bbmRoom.equals(other.bbmRoom))
			return false;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (chargeBedate == null) {
			if (other.chargeBedate != null)
				return false;
		} else if (!chargeBedate.equals(other.chargeBedate))
			return false;
		if (chargeComp == null) {
			if (other.chargeComp != null)
				return false;
		} else if (!chargeComp.equals(other.chargeComp))
			return false;
		if (chargeCreatetime == null) {
			if (other.chargeCreatetime != null)
				return false;
		} else if (!chargeCreatetime.equals(other.chargeCreatetime))
			return false;
		if (chargeEndate == null) {
			if (other.chargeEndate != null)
				return false;
		} else if (!chargeEndate.equals(other.chargeEndate))
			return false;
		if (chargeId == null) {
			if (other.chargeId != null)
				return false;
		} else if (!chargeId.equals(other.chargeId))
			return false;
		if (chargeIsbool == null) {
			if (other.chargeIsbool != null)
				return false;
		} else if (!chargeIsbool.equals(other.chargeIsbool))
			return false;
		if (chargeTime == null) {
			if (other.chargeTime != null)
				return false;
		} else if (!chargeTime.equals(other.chargeTime))
			return false;
		if (chargeUnit == null) {
			if (other.chargeUnit != null)
				return false;
		} else if (!chargeUnit.equals(other.chargeUnit))
			return false;
		if (ordermanagerUserorder == null) {
			if (other.ordermanagerUserorder != null)
				return false;
		} else if (!ordermanagerUserorder.equals(other.ordermanagerUserorder))
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