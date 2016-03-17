/**
 * 代码声明
 */
package com.common.MemberManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.MemberManager.entity.MemberRole;
import com.common.MemberManager.dao.MemberRoleDao;

@Repository("MemberRoleDao")
public class MemberRoleDaoHibernate extends 
		BaseDaoHibernate<MemberRole, String> implements MemberRoleDao{
	public Class<MemberRole> getModelClazz(){
		return MemberRole.class;
	}
}