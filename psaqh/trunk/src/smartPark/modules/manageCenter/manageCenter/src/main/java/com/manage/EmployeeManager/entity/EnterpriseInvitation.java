package com.manage.EmployeeManager.entity;
import javax.persistence.*;
import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;
import com.gsoft.framework.core.dataobj.Domain;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
/**
 * 实体: 邀请记录表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_enterprise_invitation")
public class EnterpriseInvitation implements Domain{
	private static final long serialVersionUID = 2572499642718059106L;
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "INVITATION_ID_")
	@Length(max=36)
	private String invitationId;//邀请记录系列
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RZ_ID_")
	private EnterbusinessmanagerRz enterbusinessmanagerRz;// 企业ID
	
	@Column(name = "INVITATION_CODE")
	@Length(max=32)
	private String invitationCode;//企业邀请码

	@Column(name = "INVITATION_TELEPHONE")
	@Length(max=32)
	private String invitationTelephone;//会员电话
	
	@Column(name = "INVITATION_STATUS_")
	@Length(max=20)
	private Integer invitationStatus;//状态

	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
	
	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
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
	
	public EnterbusinessmanagerRz getEnterbusinessmanagerRz() {
		return enterbusinessmanagerRz;
	}

	public void setEnterbusinessmanagerRz(
			EnterbusinessmanagerRz enterbusinessmanagerRz) {
		this.enterbusinessmanagerRz = enterbusinessmanagerRz;
	}

	public String getInvitationId(){
		return this.invitationId;
	}
	
	public void setInvitationId(String invitationId){
		this.invitationId = invitationId;
	}
	public String getInvitationTelephone(){
		return this.invitationTelephone;
	}
	
	public void setInvitationTelephone(String invitationTelephone){
		this.invitationTelephone = invitationTelephone;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getInvitationCode(){
		return this.invitationCode;
	}
	
	public void setInvitationCode(String invitationCode){
		this.invitationCode = invitationCode;
	}
	
	public Integer getInvitationStatus() {
		return invitationStatus;
	}

	public void setInvitationStatus(Integer invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((invitationId == null) ? 0 : invitationId.hashCode());
		result = prime * result + ((invitationTelephone == null) ? 0 : invitationTelephone.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((invitationCode == null) ? 0 : invitationCode.hashCode());
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
		final EnterpriseInvitation other = (EnterpriseInvitation) obj;
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
		if (invitationId == null) {
			if (other.invitationId != null)
				return false;
		} else if (!invitationId.equals(other.invitationId))
			return false;
		if (invitationTelephone == null) {
			if (other.invitationTelephone != null)
				return false;
		} else if (!invitationTelephone.equals(other.invitationTelephone))
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
		if (invitationCode == null) {
			if (other.invitationCode != null)
				return false;
		} else if (!invitationCode.equals(other.invitationCode))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}