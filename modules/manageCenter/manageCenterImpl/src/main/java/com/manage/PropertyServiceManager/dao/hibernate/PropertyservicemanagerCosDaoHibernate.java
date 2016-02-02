/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerCosDao;

@Repository("PropertyservicemanagerCosDao")
public class PropertyservicemanagerCosDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerCos, String> implements PropertyservicemanagerCosDao{
	public Class<PropertyservicemanagerCos> getModelClazz(){
		return PropertyservicemanagerCos.class;
	}
}