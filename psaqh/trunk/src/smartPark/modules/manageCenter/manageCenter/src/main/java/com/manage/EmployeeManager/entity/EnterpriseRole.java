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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEES_ID")
	private EnterpriseEmployees employees;// 企业员工ID
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLEID")
	private Role role;// 角色ID
	
	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "UPDATE_TIME_")
	private Timestamp updateTime;//修改时间
	
	@Column(name = "CREATE_TIME_")
	private Timestamp createTime;//创建时间

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

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}