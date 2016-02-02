/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerFkcodeDao;

@Repository("PropertyservicemanagerFkcodeDao")
public class PropertyservicemanagerFkcodeDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerFkcode, String> implements PropertyservicemanagerFkcodeDao{
	public Class<PropertyservicemanagerFkcode> getModelClazz(){
		return PropertyservicemanagerFkcode.class;
	}
}