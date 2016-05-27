/**
 *
 */
package com.common.PayManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 订单支付流水表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_PayManager_ordre_payFlow")
public class PaymanagerOrdrePayflow implements Domain{
	
	private static final long serialVersionUID = -1575954002349383477L;
	

	@Column(name = "ORDER_PAYFLOW_ORDER_CODE_")
	@Length(max=32)
	private String orderPayflowOrderCode;//订单号编号

	@Column(name = "ORDER_PAYFLOW_ORDER_PAYMODE_")
	@Length(max=2)
	private String orderPayflowOrderPaymode;//支付方式

	@Column(name = "ORDER_PAYFLOW_PAY_TIME_")
	@Length(max=20)
	private String orderPayflowPayTime;//支付时间
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ORDER_PAYFLOW_ID_")
	@Length(max=36)
	private String orderPayflowId;//支付流水序列

	@Column(name = "ORDER_PAYFLOW_CODE_")
	@Length(max=32)
	private String orderPayflowCode;//流水编号

	@Column(name = "ORDER_PAYFLOW_PAY_AMOUNT_")
	@Length(max=10)
	private String orderPayflowPayAmount;//支付金额

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "ORDER_PAYFLOW_PAY_PROJECT_")
	@Length(max=128)
	private String orderPayflowPayProject;//支付项目

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
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
	public String getOrderPayflowOrderCode(){
		return this.orderPayflowOrderCode;
	}
	
	public void setOrderPayflowOrderCode(String orderPayflowOrderCode){
		this.orderPayflowOrderCode = orderPayflowOrderCode;
	}
	public String getOrderPayflowOrderPaymode(){
		return this.orderPayflowOrderPaymode;
	}
	
	public void setOrderPayflowOrderPaymode(String orderPayflowOrderPaymode){
		this.orderPayflowOrderPaymode = orderPayflowOrderPaymode;
	}
	public String getOrderPayflowPayTime(){
		return this.orderPayflowPayTime;
	}
	
	public void setOrderPayflowPayTime(String orderPayflowPayTime){
		this.orderPayflowPayTime = orderPayflowPayTime;
	}
	public String getOrderPayflowId(){
		return this.orderPayflowId;
	}
	
	public void setOrderPayflowId(String orderPayflowId){
		this.orderPayflowId = orderPayflowId;
	}
	public String getOrderPayflowCode(){
		return this.orderPayflowCode;
	}
	
	public void setOrderPayflowCode(String orderPayflowCode){
		this.orderPayflowCode = orderPayflowCode;
	}
	public String getOrderPayflowPayAmount(){
		return this.orderPayflowPayAmount;
	}
	
	public void setOrderPayflowPayAmount(String orderPayflowPayAmount){
		this.orderPayflowPayAmount = orderPayflowPayAmount;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getOrderPayflowPayProject(){
		return this.orderPayflowPayProject;
	}
	
	public void setOrderPayflowPayProject(String orderPayflowPayProject){
		this.orderPayflowPayProject = orderPayflowPayProject;
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderPayflowOrderCode == null) ? 0 : orderPayflowOrderCode.hashCode());
		result = prime * result + ((orderPayflowOrderPaymode == null) ? 0 : orderPayflowOrderPaymode.hashCode());
		result = prime * result + ((orderPayflowPayTime == null) ? 0 : orderPayflowPayTime.hashCode());
		result = prime * result + ((orderPayflowId == null) ? 0 : orderPayflowId.hashCode());
		result = prime * result + ((orderPayflowCode == null) ? 0 : orderPayflowCode.hashCode());
		result = prime * result + ((orderPayflowPayAmount == null) ? 0 : orderPayflowPayAmount.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((orderPayflowPayProject == null) ? 0 : orderPayflowPayProject.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		final PaymanagerOrdrePayflow other = (PaymanagerOrdrePayflow) obj;
		if (orderPayflowOrderCode == null) {
			if (other.orderPayflowOrderCode != null)
				return false;
		} else if (!orderPayflowOrderCode.equals(other.orderPayflowOrderCode))
			return false;
		if (orderPayflowOrderPaymode == null) {
			if (other.orderPayflowOrderPaymode != null)
				return false;
		} else if (!orderPayflowOrderPaymode.equals(other.orderPayflowOrderPaymode))
			return false;
		if (orderPayflowPayTime == null) {
			if (other.orderPayflowPayTime != null)
				return false;
		} else if (!orderPayflowPayTime.equals(other.orderPayflowPayTime))
			return false;
		if (orderPayflowId == null) {
			if (other.orderPayflowId != null)
				return false;
		} else if (!orderPayflowId.equals(other.orderPayflowId))
			return false;
		if (orderPayflowCode == null) {
			if (other.orderPayflowCode != null)
				return false;
		} else if (!orderPayflowCode.equals(other.orderPayflowCode))
			return false;
		if (orderPayflowPayAmount == null) {
			if (other.orderPayflowPayAmount != null)
				return false;
		} else if (!orderPayflowPayAmount.equals(other.orderPayflowPayAmount))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (orderPayflowPayProject == null) {
			if (other.orderPayflowPayProject != null)
				return false;
		} else if (!orderPayflowPayProject.equals(other.orderPayflowPayProject))
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