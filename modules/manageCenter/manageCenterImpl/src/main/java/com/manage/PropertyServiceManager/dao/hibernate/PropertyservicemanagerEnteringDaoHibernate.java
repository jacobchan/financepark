/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEnteringDao;

@Repository("PropertyservicemanagerEnteringDao")
public class PropertyservicemanagerEnteringDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerEntering, String> implements PropertyservicemanagerEnteringDao{
	public Class<PropertyservicemanagerEntering> getModelClazz(){
		return PropertyservicemanagerEntering.class;
	}
}