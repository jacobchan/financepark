/**
 *
 */
package com.manage.PropertyServiceManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 搬家申请记录
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_propertyservicemanager_moverec")
public class PropertyservicemanagerMoverec implements Domain{
	
	private static final long serialVersionUID = -3525410986078251161L;
	

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "MOVEREC_REMARK_")
	@Length(max=300)
	private String moverecRemark;//物品描述

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "MOVEREC_COMP_")
	@Length(max=32)
	private String moverecComp;//搬家企业名称

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "MOVEREC_WAY_")
	@Length(max=2)
	private String moverecWay;//搬家提交方式

	@Column(name = "MOVEREC_NAME_")
	@Length(max=32)
	private String moverecName;//搬家联系人

//	@Column(name = "MEMBER_ID_")
//	@Length(max=36)
//	private String memberId;//会员用户ID
	
	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation member;//会员用户ID

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MOVEREC_ID_")
	@Length(max=36)
	private String moverecId;//搬家申请记录ID

	@Column(name = "MOVEREC_TIME_")
	@Length(max=32)
	private String moverecTime;//搬家时间

	@Column(name = "MOVEREC_UNIT_")
	@Length(max=20)
	private String moverecUnit;//楼宇单元
	
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getMoverecRemark(){
		return this.moverecRemark;
	}
	
	public void setMoverecRemark(String moverecRemark){
		this.moverecRemark = moverecRemark;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getMoverecComp(){
		return this.moverecComp;
	}
	
	public void setMoverecComp(String moverecComp){
		this.moverecComp = moverecComp;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getMoverecWay(){
		return this.moverecWay;
	}
	
	public void setMoverecWay(String moverecWay){
		this.moverecWay = moverecWay;
	}
	public String getMoverecName(){
		return this.moverecName;
	}
	
	public void setMoverecName(String moverecName){
		this.moverecName = moverecName;
	}
	
	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}

	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getMoverecId(){
		return this.moverecId;
	}
	
	public void setMoverecId(String moverecId){
		this.moverecId = moverecId;
	}
	public String getMoverecTime(){
		return this.moverecTime;
	}
	
	public void setMoverecTime(String moverecTime){
		this.moverecTime = moverecTime;
	}
	public String getMoverecUnit(){
		return this.moverecUnit;
	}
	
	public void setMoverecUnit(String moverecUnit){
		this.moverecUnit = moverecUnit;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((moverecRemark == null) ? 0 : moverecRemark.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((moverecComp == null) ? 0 : moverecComp.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((moverecWay == null) ? 0 : moverecWay.hashCode());
		result = prime * result + ((moverecName == null) ? 0 : moverecName.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((moverecId == null) ? 0 : moverecId.hashCode());
		result = prime * result + ((moverecTime == null) ? 0 : moverecTime.hashCode());
		result = prime * result + ((moverecUnit == null) ? 0 : moverecUnit.hashCode());
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
		final PropertyservicemanagerMoverec other = (PropertyservicemanagerMoverec) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (moverecRemark == null) {
			if (other.moverecRemark != null)
				return false;
		} else if (!moverecRemark.equals(other.moverecRemark))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (moverecComp == null) {
			if (other.moverecComp != null)
				return false;
		} else if (!moverecComp.equals(other.moverecComp))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (moverecWay == null) {
			if (other.moverecWay != null)
				return false;
		} else if (!moverecWay.equals(other.moverecWay))
			return false;
		if (moverecName == null) {
			if (other.moverecName != null)
				return false;
		} else if (!moverecName.equals(other.moverecName))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (moverecId == null) {
			if (other.moverecId != null)
				return false;
		} else if (!moverecId.equals(other.moverecId))
			return false;
		if (moverecTime == null) {
			if (other.moverecTime != null)
				return false;
		} else if (!moverecTime.equals(other.moverecTime))
			return false;
		if (moverecUnit == null) {
			if (other.moverecUnit != null)
				return false;
		} else if (!moverecUnit.equals(other.moverecUnit))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}