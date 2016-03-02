package com.manage.EmployeeManager.entity;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.security.fuc.entity.Role;
@Entity
@Table(name = "sp_enterprise_role")
public class EnterpriseRole implements Domain {
	private static final long serialVersionUID = -1817928299106947087L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "R_ID_")
	@Length(max = 36)
	private String rId;// 角色主键
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name = "EMPLOYEES_ID")
	private EnterpriseEmployees employees;// 企业员工ID
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLEID")
	private Role role;// 角色ID
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name = "CREATE_USER_")
	private MemberInformation createuser;// 创建人
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name = "UPDATE_USER_")
	private MemberInformation updateuser;// 修改人
	
	@Column(name = "CREATE_TIME_")
	private Timestamp createtime;//创建时间
	
	@Column(name = "UPDATE_TIME_")
	private Timestamp updatetime;//修改时间

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public EnterpriseEmployees getEmployees() {
		return employees;
	}

	public void setEmployees(EnterpriseEmployees employees) {
		this.employees = employees;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public MemberInformation getCreateuser() {
		return createuser;
	}

	public void setCreateuser(MemberInformation createuser) {
		this.createuser = createuser;
	}

	public MemberInformation getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(MemberInformation updateuser) {
		this.updateuser = updateuser;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
}
