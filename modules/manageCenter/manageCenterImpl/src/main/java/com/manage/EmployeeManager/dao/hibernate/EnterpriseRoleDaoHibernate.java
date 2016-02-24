package com.manage.EmployeeManager.dao.hibernate;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.manage.EmployeeManager.dao.EnterpriseRoleDao;
import com.manage.EmployeeManager.entity.EnterpriseRole;
@Repository("EnterpriseRoleDao")
public class EnterpriseRoleDaoHibernate extends
		BaseDaoHibernate<EnterpriseRole, String> implements EnterpriseRoleDao {
	public Class<EnterpriseRole> getModelClazz() {
		return EnterpriseRole.class;
	}
}