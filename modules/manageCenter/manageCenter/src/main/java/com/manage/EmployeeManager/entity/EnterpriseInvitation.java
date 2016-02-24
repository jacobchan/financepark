/**
 *
 */
package com.manage.EmployeeManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;
import com.gsoft.framework.core.dataobj.Domain;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;

/**
 * 实体: 邀请记录表
 * 
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_enterprise_invitation")
public class EnterpriseInvitation implements Domain {

	private static final long serialVersionUID = -1817928299106947087L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RZ_ID_")
	private EnterbusinessmanagerRz enterbusinessmanagerRz;// 企业ID

	@Column(name = "INVITATION_TELEPHONE")
	@Length(max = 32)
	private String invitationTelephone;// 会员电话
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "INVITATION_ID_")
	@Length(max = 36)
	private String invitationId;// 邀请记录系列

	@Column(name = "INVITATION_CODE")
	@Length(max = 32)
	private String invitationCode;// 企业邀请码

	public String getInvitationTelephone() {
		return this.invitationTelephone;
	}

	public void setInvitationTelephone(String invitationTelephone) {
		this.invitationTelephone = invitationTelephone;
	}

	public String getInvitationId() {
		return this.invitationId;
	}

	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}

	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public EnterbusinessmanagerRz getEnterbusinessmanagerRz() {
		return enterbusinessmanagerRz;
	}

	public void setEnterbusinessmanagerRz(
			EnterbusinessmanagerRz enterbusinessmanagerRz) {
		this.enterbusinessmanagerRz = enterbusinessmanagerRz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((invitationTelephone == null) ? 0 : invitationTelephone
						.hashCode());
		result = prime * result
				+ ((invitationId == null) ? 0 : invitationId.hashCode());
		result = prime * result
				+ ((invitationCode == null) ? 0 : invitationCode.hashCode());
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
		if (invitationTelephone == null) {
			if (other.invitationTelephone != null)
				return false;
		} else if (!invitationTelephone.equals(other.invitationTelephone))
			return false;
		if (invitationId == null) {
			if (other.invitationId != null)
				return false;
		} else if (!invitationId.equals(other.invitationId))
			return false;
		if (invitationCode == null) {
			if (other.invitationCode != null)
				return false;
		} else if (!invitationCode.equals(other.invitationCode))
			return false;
		return true;
	}

	public String toString() {
		return super.toString();
	}
}