/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerOc;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerOcDao;

@Repository("PropertyservicemanagerOcDao")
public class PropertyservicemanagerOcDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerOc, String> implements PropertyservicemanagerOcDao{
	public Class<PropertyservicemanagerOc> getModelClazz(){
		return PropertyservicemanagerOc.class;
	}
}