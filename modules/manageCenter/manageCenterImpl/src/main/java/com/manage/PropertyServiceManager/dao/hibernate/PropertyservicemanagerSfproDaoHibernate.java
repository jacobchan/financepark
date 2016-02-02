/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSfproDao;

@Repository("PropertyservicemanagerSfproDao")
public class PropertyservicemanagerSfproDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerSfpro, String> implements PropertyservicemanagerSfproDao{
	public Class<PropertyservicemanagerSfpro> getModelClazz(){
		return PropertyservicemanagerSfpro.class;
	}
}