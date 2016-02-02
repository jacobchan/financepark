/**
 * 代码声明
 */
package com.manage.EmployeeManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;

@Repository("EnterpriseEmployeesDao")
public class EnterpriseEmployeesDaoHibernate extends 
		BaseDaoHibernate<EnterpriseEmployees, String> implements EnterpriseEmployeesDao{
	public Class<EnterpriseEmployees> getModelClazz(){
		return EnterpriseEmployees.class;
	}
}