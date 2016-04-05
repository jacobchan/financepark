/**
 * 代码声明
 */
package com.member.applications.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.applications.entity.Finace;
import com.member.applications.dao.FinaceDao;

@Repository("FinaceDao")
public class FinaceDaoHibernate extends 
		BaseDaoHibernate<Finace, String> implements FinaceDao{
	public Class<Finace> getModelClazz(){
		return Finace.class;
	}
}