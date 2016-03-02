package com.manage.EmployeeManager.entity;
import javax.persistence.*;
import org.hibernate.validator.*;
import org.hibernate.annotations.GenericGenerator;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
/**
 * 实体: 企业员工表
 * 
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_enterprise_employees")
public class EnterpriseEmployees implements Domain {
	private static final long serialVersionUID = 2584651808359871795L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "EMPLOYEES_ID")
	@Length(max = 36)
	private String employeesId;// ID_
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RZ_ID_")
	private EnterbusinessmanagerRz rz;// 企业信息ID_
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEMBER_ID_")
	private MemberInformation member;// 会员用户ID
	
	@Column(name = "EMPLOYEES_NAME")
	@Length(max = 32)
	private String employeesName;// 员工姓名

	@Column(name = "EMPLOYEES_TELEPHONE")
	@Length(max = 16)
	private String employeesTelephone;// 员工电话
	
	@Column(name = "EMPLOYEES_DEPARTMENT")
	@Length(max = 2)
	private String employeesDepartment;// 所属部门
	
	@Column(name = "UPDATE_USER_")
	@Length(max=36)
	private String updateUser;//修改人
	
	@Column(name = "CREATE_USER_")
	@Length(max=36)
	private String createUser;//创建人
	
	@Column(name = "UPDATE_TIME_")
	private String updateTime;//修改时间
	
	@Column(name = "CREATE_TIME_")
	private String createTime;//创建时间
//	
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},targetEntity = EnterpriseRole.class,mappedBy = "employees")
//	private Set<EnterpriseRole> enterpriseRole = new HashSet<EnterpriseRole>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((employeesDepartment == null) ? 0 : employeesDepartment
						.hashCode());
		result = prime * result
				+ ((employeesId == null) ? 0 : employeesId.hashCode());
		result = prime
				* result
				+ ((employeesTelephone == null) ? 0 : employeesTelephone
						.hashCode());
		result = prime * result
				+ ((employeesName == null) ? 0 : employeesName.hashCode());
		return result;
	}

	public String getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(String employeesId) {
		this.employeesId = employeesId;
	}

	public EnterbusinessmanagerRz getRz() {
		return rz;
	}

	public void setRz(EnterbusinessmanagerRz rz) {
		this.rz = rz;
	}

	public MemberInformation getMember() {
		return member;
	}

	public void setMember(MemberInformation member) {
		this.member = member;
	}

	public String getEmployeesName() {
		return employeesName;
	}

	public void setEmployeesName(String employeesName) {
		this.employeesName = employeesName;
	}

	public String getEmployeesTelephone() {
		return employeesTelephone;
	}

	public void setEmployeesTelephone(String employeesTelephone) {
		this.employeesTelephone = employeesTelephone;
	}

	public String getEmployeesDepartment() {
		return employeesDepartment;
	}

	public void setEmployeesDepartment(String employeesDepartment) {
		this.employeesDepartment = employeesDepartment;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EnterpriseEmployees other = (EnterpriseEmployees) obj;
		if (employeesDepartment == null) {
			if (other.employeesDepartment != null)
				return false;
		} else if (!employeesDepartment.equals(other.employeesDepartment))
			return false;
		if (employeesId == null) {
			if (other.employeesId != null)
				return false;
		} else if (!employeesId.equals(other.employeesId))
			return false;
		if (employeesTelephone == null) {
			if (other.employeesTelephone != null)
				return false;
		} else if (!employeesTelephone.equals(other.employeesTelephone))
			return false;
		if (employeesName == null) {
			if (other.employeesName != null)
				return false;
		} else if (!employeesName.equals(other.employeesName))
			return false;
		return true;
	}

	public String toString() {
		return super.toString();
	}
}