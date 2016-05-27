/**
 *
 */
package com.member.applications.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 340701预留停车位
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_carport")
public class Carport implements Domain{
	
	private static final long serialVersionUID = 172596596455230064L;
	

	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间

	@Column(name = "CP_BEGION_TIME_")
	@Length(max=20)
	private String cpBegionTime;//开始时间

	@Column(name = "CP_EN_NAME_")
	@Length(max=256)
	private String cpEnName;//企业名称

	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间

	@Column(name = "CP_LINK_MAN_")
	@Length(max=128)
	private String cpLinkMan;//联系人

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人

	@Column(name = "APPLAY_STATUS_")
	@Length(max=2)
	private String applayStatus;//申请状态

	@Column(name = "CP_LINK_TEL_")
	@Length(max=20)
	private String cpLinkTel;//联系方式

	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区ID
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ID_")
	@Length(max=36)
	private String id;//ID_

	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//申请人

	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人

	@Column(name = "CP_COUNT_")
	private String cpCount;//车位数量

	@Column(name = "CP_EN_ADR_")
	@Length(max=256)
	private String cpEnAdr;//企业地址

	@Column(name = "CP_ENTD_TIME_")
	@Length(max=20)
	private String cpEntdTime;//结束时间

	@Column(name = "APPLAY_NO_")
	@Length(max=36)
	private String applayNo;//申请编号
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	/**新增园区字段   end**/

	public String getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	public String getCpBegionTime(){
		return this.cpBegionTime;
	}
	
	public void setCpBegionTime(String cpBegionTime){
		this.cpBegionTime = cpBegionTime;
	}
	public String getCpEnName(){
		return this.cpEnName;
	}
	
	public void setCpEnName(String cpEnName){
		this.cpEnName = cpEnName;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCpLinkMan(){
		return this.cpLinkMan;
	}
	
	public void setCpLinkMan(String cpLinkMan){
		this.cpLinkMan = cpLinkMan;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getApplayStatus(){
		return this.applayStatus;
	}
	
	public void setApplayStatus(String applayStatus){
		this.applayStatus = applayStatus;
	}
	public String getCpLinkTel(){
		return this.cpLinkTel;
	}
	
	public void setCpLinkTel(String cpLinkTel){
		this.cpLinkTel = cpLinkTel;
	}
	public String getParkId(){
		return this.parkId;
	}
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getMemberId(){
		return this.memberId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getUpdateUser(){
		return this.updateUser;
	}
	
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public String getCpCount(){
		return this.cpCount;
	}
	
	public void setCpCount(String cpCount){
		this.cpCount = cpCount;
	}
	public String getCpEnAdr(){
		return this.cpEnAdr;
	}
	
	public void setCpEnAdr(String cpEnAdr){
		this.cpEnAdr = cpEnAdr;
	}
	public String getCpEntdTime(){
		return this.cpEntdTime;
	}
	
	public void setCpEntdTime(String cpEntdTime){
		this.cpEntdTime = cpEntdTime;
	}
	public String getApplayNo(){
		return this.applayNo;
	}
	
	public void setApplayNo(String applayNo){
		this.applayNo = applayNo;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((cpBegionTime == null) ? 0 : cpBegionTime.hashCode());
		result = prime * result + ((cpEnName == null) ? 0 : cpEnName.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((cpLinkMan == null) ? 0 : cpLinkMan.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((applayStatus == null) ? 0 : applayStatus.hashCode());
		result = prime * result + ((cpLinkTel == null) ? 0 : cpLinkTel.hashCode());
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((cpCount == null) ? 0 : cpCount.hashCode());
		result = prime * result + ((cpEnAdr == null) ? 0 : cpEnAdr.hashCode());
		result = prime * result + ((cpEntdTime == null) ? 0 : cpEntdTime.hashCode());
		result = prime * result + ((applayNo == null) ? 0 : applayNo.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
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
		final Carport other = (Carport) obj;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (cpBegionTime == null) {
			if (other.cpBegionTime != null)
				return false;
		} else if (!cpBegionTime.equals(other.cpBegionTime))
			return false;
		if (cpEnName == null) {
			if (other.cpEnName != null)
				return false;
		} else if (!cpEnName.equals(other.cpEnName))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (cpLinkMan == null) {
			if (other.cpLinkMan != null)
				return false;
		} else if (!cpLinkMan.equals(other.cpLinkMan))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (applayStatus == null) {
			if (other.applayStatus != null)
				return false;
		} else if (!applayStatus.equals(other.applayStatus))
			return false;
		if (cpLinkTel == null) {
			if (other.cpLinkTel != null)
				return false;
		} else if (!cpLinkTel.equals(other.cpLinkTel))
			return false;
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (cpCount == null) {
			if (other.cpCount != null)
				return false;
		} else if (!cpCount.equals(other.cpCount))
			return false;
		if (cpEnAdr == null) {
			if (other.cpEnAdr != null)
				return false;
		} else if (!cpEnAdr.equals(other.cpEnAdr))
			return false;
		if (cpEntdTime == null) {
			if (other.cpEntdTime != null)
				return false;
		} else if (!cpEntdTime.equals(other.cpEntdTime))
			return false;
		if (applayNo == null) {
			if (other.applayNo != null)
				return false;
		} else if (!applayNo.equals(other.applayNo))
			return false;

		/**新增园区字段   start**/
		
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