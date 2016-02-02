/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicenanagerBack;
import com.manage.PropertyServiceManager.dao.PropertyservicenanagerBackDao;

@Repository("PropertyservicenanagerBackDao")
public class PropertyservicenanagerBackDaoHibernate extends 
		BaseDaoHibernate<PropertyservicenanagerBack, String> implements PropertyservicenanagerBackDao{
	public Class<PropertyservicenanagerBack> getModelClazz(){
		return PropertyservicenanagerBack.class;
	}
}