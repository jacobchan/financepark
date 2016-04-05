/**
 * 代码声明
 */
package com.member.applications.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.applications.entity.Entrepreneurship;
import com.member.applications.dao.EntrepreneurshipDao;

@Repository("EntrepreneurshipDao")
public class EntrepreneurshipDaoHibernate extends 
		BaseDaoHibernate<Entrepreneurship, String> implements EntrepreneurshipDao{
	public Class<Entrepreneurship> getModelClazz(){
		return Entrepreneurship.class;
	}
}