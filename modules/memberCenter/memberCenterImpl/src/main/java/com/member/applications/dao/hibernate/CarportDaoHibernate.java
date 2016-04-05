/**
 * 代码声明
 */
package com.member.applications.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.applications.entity.Carport;
import com.member.applications.dao.CarportDao;

@Repository("CarportDao")
public class CarportDaoHibernate extends 
		BaseDaoHibernate<Carport, String> implements CarportDao{
	public Class<Carport> getModelClazz(){
		return Carport.class;
	}
}