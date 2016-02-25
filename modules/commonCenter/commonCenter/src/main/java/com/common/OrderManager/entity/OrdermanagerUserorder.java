/**
 *
 */
package com.common.OrderManager.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 用户订单表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_OrderManager_userOrder")
public class OrdermanagerUserorder implements Domain{
	
	private static final long serialVersionUID = 7322749356175066916L;
	

	@Column(name = "USERORDER_CODE_")
	@Length(max=32)
	private String userorderCode;//订单编号

	@Column(name = "USERORDER_PAY_MODE_")
	@Length(max=2)
	private String userorderPayMode;//支付方式

	@Column(name = "BX_ID_")
	@Length(max=36)
	private String bxId;//报修记录ID

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID

	@Column(name = "USERORDER_PROJECT_")
	@Length(max=128)
	private String userorderProject;//订单项目
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "USERORDER_ID_")
	@Length(max=36)
	private String userorderId;//用户订单序列

	@Column(name = "USERORDER_STATUS_")
	@Length(max=2)
	private String userorderStatus;//订单状态

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USERORDER_BUY_USER_")
	private MemberInformation userorderBuyUser;//购买人

	@Column(name = "USERORDER_AMOUNT_")
	private BigDecimal userorderAmount;//订单金额

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "USERORDER_TIME_")
	@Length(max=20)
	private String userorderTime;//下单时间

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDERTYPE_ID_")
	private com.common.OrderManager.entity.OrdermanagerOrdertype ordermanagerOrdertype;//订单类型
	
	public String getUserorderCode(){
		return this.userorderCode;
	}
	
	public void setUserorderCode(String userorderCode){
		this.userorderCode = userorderCode;
	}
	public String getUserorderPayMode(){
		return this.userorderPayMode;
	}
	
	public void setUserorderPayMode(String userorderPayMode){
		this.userorderPayMode = userorderPayMode;
	}
	public String getBxId(){
		return this.bxId;
	}
	
	public void setBxId(String bxId){
		this.bxId = bxId;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getUserorderProject(){
		return this.userorderProject;
	}
	
	public void setUserorderProject(String userorderProject){
		this.userorderProject = userorderProject;
	}
	public String getUserorderId(){
		return this.userorderId;
	}
	
	public void setUserorderId(String userorderId){
		this.userorderId = userorderId;
	}
	public String getUserorderStatus(){
		return this.userorderStatus;
	}
	
	public void setUserorderStatus(String userorderStatus){
		this.userorderStatus = userorderStatus;
	}
	
	public MemberInformation getUserorderBuyUser() {
		return userorderBuyUser;
	}

	public void setUserorderBuyUser(MemberInformation userorderBuyUser) {
		this.userorderBuyUser = userorderBuyUser;
	}

	public BigDecimal getUserorderAmount() {
		return userorderAmount;
	}

	public void setUserorderAmount(BigDecimal userorderAmount) {
		this.userorderAmount = userorderAmount;
	}

	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getUserorderTime(){
		return this.userorderTime;
	}
	
	public void setUserorderTime(String userorderTime){
		this.userorderTime = userorderTime;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public void setOrdermanagerOrdertype(com.common.OrderManager.entity.OrdermanagerOrdertype ordermanagerOrdertype){
		this.ordermanagerOrdertype = ordermanagerOrdertype;
	}
	
	public com.common.OrderManager.entity.OrdermanagerOrdertype getOrdermanagerOrdertype(){
		return this.ordermanagerOrdertype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userorderCode == null) ? 0 : userorderCode.hashCode());
		result = prime * result + ((userorderPayMode == null) ? 0 : userorderPayMode.hashCode());
		result = prime * result + ((bxId == null) ? 0 : bxId.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((userorderProject == null) ? 0 : userorderProject.hashCode());
		result = prime * result + ((userorderId == null) ? 0 : userorderId.hashCode());
		result = prime * result + ((userorderStatus == null) ? 0 : userorderStatus.hashCode());
		result = prime * result + ((userorderBuyUser == null) ? 0 : userorderBuyUser.hashCode());
		result = prime * result + ((userorderAmount == null) ? 0 : userorderAmount.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((userorderTime == null) ? 0 : userorderTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
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
		final OrdermanagerUserorder other = (OrdermanagerUserorder) obj;
		if (userorderCode == null) {
			if (other.userorderCode != null)
				return false;
		} else if (!userorderCode.equals(other.userorderCode))
			return false;
		if (userorderPayMode == null) {
			if (other.userorderPayMode != null)
				return false;
		} else if (!userorderPayMode.equals(other.userorderPayMode))
			return false;
		if (bxId == null) {
			if (other.bxId != null)
				return false;
		} else if (!bxId.equals(other.bxId))
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
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (userorderProject == null) {
			if (other.userorderProject != null)
				return false;
		} else if (!userorderProject.equals(other.userorderProject))
			return false;
		if (userorderId == null) {
			if (other.userorderId != null)
				return false;
		} else if (!userorderId.equals(other.userorderId))
			return false;
		if (userorderStatus == null) {
			if (other.userorderStatus != null)
				return false;
		} else if (!userorderStatus.equals(other.userorderStatus))
			return false;
		if (userorderBuyUser == null) {
			if (other.userorderBuyUser != null)
				return false;
		} else if (!userorderBuyUser.equals(other.userorderBuyUser))
			return false;
		if (userorderAmount == null) {
			if (other.userorderAmount != null)
				return false;
		} else if (!userorderAmount.equals(other.userorderAmount))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (userorderTime == null) {
			if (other.userorderTime != null)
				return false;
		} else if (!userorderTime.equals(other.userorderTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}