/**
 * 代码声明
 */
package com.manage.EmployeeManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.dao.EnterpriseInvitationDao;

@Repository("EnterpriseInvitationDao")
public class EnterpriseInvitationDaoHibernate extends 
		BaseDaoHibernate<EnterpriseInvitation, String> implements EnterpriseInvitationDao{
	public Class<EnterpriseInvitation> getModelClazz(){
		return EnterpriseInvitation.class;
	}
}