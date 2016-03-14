/**
 * 代码声明
 */
package com.distribution.contacts.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.distribution.contacts.entity.RecommendMember;
import com.distribution.contacts.dao.RecommendMemberDao;

@Repository("RecommendMemberDao")
public class RecommendMemberDaoHibernate extends 
		BaseDaoHibernate<RecommendMember, String> implements RecommendMemberDao{
	public Class<RecommendMember> getModelClazz(){
		return RecommendMember.class;
	}
}