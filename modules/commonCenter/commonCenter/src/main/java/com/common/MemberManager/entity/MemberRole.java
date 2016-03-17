/**
 *
 */
package com.common.MemberManager.entity;

import javax.persistence.*;
import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.gsoft.framework.core.dataobj.Domain;
/**
 * 实体: 会员角色关系表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_member_role")
public class MemberRole implements Domain{
	
	private static final long serialVersionUID = 6735771847870736483L;
	
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "ID_")
	@Length(max=36)
	private String ID;
	
	@Column(name = "ROLE_ID_")
	@Length(max=36)
	private String roleId;//角色ID
	
	
	@Column(name = "MEMBER_ID_")
	@Length(max=36)
	private String memberId;//会员用户ID
	
	public String getRoleId(){
		return this.roleId;
	}
	
	public void setRoleId(String roleId){
		this.roleId = roleId;
	}
	
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
	public String getMemberId(){
		return this.memberId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		final MemberRole other = (MemberRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}