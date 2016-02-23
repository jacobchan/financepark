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
	
	private static final long serialVersionUID = 4943320578230696156L;
	

	@Column(name = "MOVEREC_UNIT_")
	@Length(max=20)
	private String moverecUnit;//楼宇单元

	@Column(name = "MOVEREC_COMP_")
	@Length(max=32)
	private String moverecComp;//搬家企业名称
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "MOVEREC_ID_")
	@Length(max=36)
	private String moverecId;//搬家申请记录ID

	@Column(name = "MOVEREC_REMARK_")
	@Length(max=300)
	private String moverecRemark;//物品描述

	@Column(name = "MOVEREC_NAME_")
	@Length(max=32)
	private String moverecName;//搬家联系人

	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation member;//会员用户ID

	@Column(name = "MOVEREC_WAY_")
	@Length(max=2)
	private String moverecWay;//搬家提交方式
	
	public String getMoverecUnit(){
		return this.moverecUnit;
	}
	
	public void setMoverecUnit(String moverecUnit){
		this.moverecUnit = moverecUnit;
	}
	public String getMoverecComp(){
		return this.moverecComp;
	}
	
	public void setMoverecComp(String moverecComp){
		this.moverecComp = moverecComp;
	}
	public String getMoverecId(){
		return this.moverecId;
	}
	
	public void setMoverecId(String moverecId){
		this.moverecId = moverecId;
	}
	public String getMoverecRemark(){
		return this.moverecRemark;
	}
	
	public void setMoverecRemark(String moverecRemark){
		this.moverecRemark = moverecRemark;
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

	public String getMoverecWay(){
		return this.moverecWay;
	}
	
	public void setMoverecWay(String moverecWay){
		this.moverecWay = moverecWay;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moverecUnit == null) ? 0 : moverecUnit.hashCode());
		result = prime * result + ((moverecComp == null) ? 0 : moverecComp.hashCode());
		result = prime * result + ((moverecId == null) ? 0 : moverecId.hashCode());
		result = prime * result + ((moverecRemark == null) ? 0 : moverecRemark.hashCode());
		result = prime * result + ((moverecName == null) ? 0 : moverecName.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((moverecWay == null) ? 0 : moverecWay.hashCode());
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
		if (moverecUnit == null) {
			if (other.moverecUnit != null)
				return false;
		} else if (!moverecUnit.equals(other.moverecUnit))
			return false;
		if (moverecComp == null) {
			if (other.moverecComp != null)
				return false;
		} else if (!moverecComp.equals(other.moverecComp))
			return false;
		if (moverecId == null) {
			if (other.moverecId != null)
				return false;
		} else if (!moverecId.equals(other.moverecId))
			return false;
		if (moverecRemark == null) {
			if (other.moverecRemark != null)
				return false;
		} else if (!moverecRemark.equals(other.moverecRemark))
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
		if (moverecWay == null) {
			if (other.moverecWay != null)
				return false;
		} else if (!moverecWay.equals(other.moverecWay))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}