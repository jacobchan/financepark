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
    /**新增园区字段   start**/
	@Column(name = "PARK_NAME_")
	@Length(max=256)
	private String parkName;//园区名称
	
	@Column(name = "PARK_ID_")
	@Length(max=36)
	private String parkId;//园区id
	/**新增园区字段   end**/ 

	/**新增园区字段   start**/
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	/**新增园区字段   end**/
	public String getEmployeesId() {
		return employeesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime
				* result
				+ ((employeesDepartment == null) ? 0 : employeesDepartment
						.hashCode());
		result = prime * result
				+ ((employeesId == null) ? 0 : employeesId.hashCode());
		result = prime * result
				+ ((employeesName == null) ? 0 : employeesName.hashCode());
		result = prime
				* result
				+ ((employeesTelephone == null) ? 0 : employeesTelephone
						.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		/**新增园区字段   start**/
		result = prime * result + ((parkId == null) ? 0 : parkId.hashCode());
		result = prime * result
				+ ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((rz == null) ? 0 : rz.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		/**新增园区字段   end**/
		result = prime * result
				+ ((updateUser == null) ? 0 : updateUser.hashCode());
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
		EnterpriseEmployees other = (EnterpriseEmployees) obj;
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
		if (employeesName == null) {
			if (other.employeesName != null)
				return false;
		} else if (!employeesName.equals(other.employeesName))
			return false;
		if (employeesTelephone == null) {
			if (other.employeesTelephone != null)
				return false;
		} else if (!employeesTelephone.equals(other.employeesTelephone))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		/**新增园区字段   start**/
		if (parkId == null) {
			if (other.parkId != null)
				return false;
		} else if (!parkId.equals(other.parkId))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		/**新增园区字段   end**/

		if (rz == null) {
			if (other.rz != null)
				return false;
		} else if (!rz.equals(other.rz))
			return false;
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
		return true;
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