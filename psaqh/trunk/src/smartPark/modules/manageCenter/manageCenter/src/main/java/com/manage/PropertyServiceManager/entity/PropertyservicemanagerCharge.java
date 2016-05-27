/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.OrderManager.entity.OrdermanagerUserorder;
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
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CHARGE_TIME_")
	@Length(max=20)
	private String chargeTime;//缴费日期

	@Column(name = "CHARGE_ISBOOL_")
	@Length(max=2)
	private String chargeIsbool;//是否缴费

	@Column(name = "CHARGE_AMOUNT_")
	private BigDecimal chargeAmount;//应缴费总额

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "CHARGE_CREATETIME_")
	@Length(max=20)
	private String chargeCreatetime;//登记日期

	@Column(name = "CHARGE_COMP_")
	@Length(max=50)
	private String chargeComp;//收费企业名称

	@Column(name = "CHARGE_ENDATE_")
	@Length(max=20)
	private String chargeEndate;//截止日期
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USERORDER_ID_")
	private OrdermanagerUserorder userorder;//用户订单

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CHARGE_UNIT_")
	@Length(max=10)
	private String chargeUnit;//单元号

	@Column(name = "CHARGE_BEDATE_")
	@Length(max=20)
	private String chargeBedate;//起始日期
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "CHARGE_ID_")
	@Length(max=36)
	private String chargeId;//收费登记序列
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROOM_ID_")
	private BbmRoom bbmRoom;//单元

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID
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
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getChargeIsbool() {
		return chargeIsbool;
	}

	public void setChargeIsbool(String chargeIsbool) {
		this.chargeIsbool = chargeIsbool;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
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

	public String getChargeCreatetime() {
		return chargeCreatetime;
	}

	public void setChargeCreatetime(String chargeCreatetime) {
		this.chargeCreatetime = chargeCreatetime;
	}

	public String getChargeComp() {
		return chargeComp;
	}

	public void setChargeComp(String chargeComp) {
		this.chargeComp = chargeComp;
	}

	public String getChargeEndate() {
		return chargeEndate;
	}

	public void setChargeEndate(String chargeEndate) {
		this.chargeEndate = chargeEndate;
	}

	public OrdermanagerUserorder getUserorder() {
		return userorder;
	}

	public void setUserorder(OrdermanagerUserorder userorder) {
		this.userorder = userorder;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public BbmRoom getBbmRoom() {
		return bbmRoom;
	}

	public void setBbmRoom(BbmRoom bbmRoom) {
		this.bbmRoom = bbmRoom;
	}

	public String getRzId() {
		return rzId;
	}

	public void setRzId(String rzId) {
		this.rzId = rzId;
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
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result
				+ ((userorder == null) ? 0 : userorder.hashCode());
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
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
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
		if (userorder == null) {
			if (other.userorder != null)
				return false;
		} else if (!userorder.equals(other.userorder))
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