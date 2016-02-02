/**
 * 代码声明
 */
package com.manage.PolicyManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PolicyManager.entity.PolicyApply;
import com.manage.PolicyManager.dao.PolicyApplyDao;

@Repository("PolicyApplyDao")
public class PolicyApplyDaoHibernate extends 
		BaseDaoHibernate<PolicyApply, String> implements PolicyApplyDao{
	public Class<PolicyApply> getModelClazz(){
		return PolicyApply.class;
	}
}