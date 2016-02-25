/**
 *
 */
package com.manage.EmployeeManager.entity;

import javax.persistence.*;

import org.hibernate.validator.*;

import org.hibernate.annotations.GenericGenerator;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Domain;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
/**
 * 实体: 企业员工表
 * @author
 * @version
 * 
 */
@Entity
@Table(name = "sp_enterprise_employees")
public class EnterpriseEmployees implements Domain{
	private static final long serialVersionUID = 2584651808359871795L;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="EMPLOYEES_COM_ID")
	private EnterbusinessmanagerRz employeesComId;//企业信息ID_

	@Column(name = "EMPLOYEES_DEPARTMENT")
	@Length(max=2)
	private String employeesDepartment;//所属部门
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "EMPLOYEES_ID")
	@Length(max=36)
	private String employeesId;//ID_

	@Column(name = "EMPLOYEES_TELEPHONE")
	@Length(max=16)
	private String employeesTelephone;//员工电话

	@Column(name = "EMPLOYEES_NAME")
	@Length(max=32)
	private String employeesName;//员工姓名

	@Column(name = "RZ_ID_")
	@Length(max=36)
	private String rzId;//ID

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID_")
	private MemberInformation memberId;//会员用户ID
	

	public String getEmployeesDepartment(){
		return this.employeesDepartment;
	}
	
	public void setEmployeesDepartment(String employeesDepartment){
		this.employeesDepartment = employeesDepartment;
	}
	public String getEmployeesId(){
		return this.employeesId;
	}
	
	public void setEmployeesId(String employeesId){
		this.employeesId = employeesId;
	}
	public String getEmployeesTelephone(){
		return this.employeesTelephone;
	}
	
	public void setEmployeesTelephone(String employeesTelephone){
		this.employeesTelephone = employeesTelephone;
	}
	public String getEmployeesName(){
		return this.employeesName;
	}
	
	public void setEmployeesName(String employeesName){
		this.employeesName = employeesName;
	}
	public String getRzId(){
		return this.rzId;
	}
	
	public void setRzId(String rzId){
		this.rzId = rzId;
	}
	
	
	
	
	public EnterbusinessmanagerRz getEmployeesComId() {
		return employeesComId;
	}

	public void setEmployeesComId(EnterbusinessmanagerRz employeesComId) {
		this.employeesComId = employeesComId;
	}

	

	public MemberInformation getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberInformation memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeesComId == null) ? 0 : employeesComId.hashCode());
		result = prime * result + ((employeesDepartment == null) ? 0 : employeesDepartment.hashCode());
		result = prime * result + ((employeesId == null) ? 0 : employeesId.hashCode());
		result = prime * result + ((employeesTelephone == null) ? 0 : employeesTelephone.hashCode());
		result = prime * result + ((employeesName == null) ? 0 : employeesName.hashCode());
		result = prime * result + ((rzId == null) ? 0 : rzId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		final EnterpriseEmployees other = (EnterpriseEmployees) obj;
		if (employeesComId == null) {
			if (other.employeesComId != null)
				return false;
		} else if (!employeesComId.equals(other.employeesComId))
			return false;
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
		if (rzId == null) {
			if (other.rzId != null)
				return false;
		} else if (!rzId.equals(other.rzId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
}