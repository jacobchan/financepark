package com.manage.EmployeeManager.entity;
import java.sql.Timestamp;

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
	private Timestamp updateTime;//修改时间
	
	@Column(name = "CREATE_TIME_")
	private Timestamp createTime;//创建时间

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