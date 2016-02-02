/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFxtdc;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerFxtdcDao;

@Repository("PropertyservicemanagerFxtdcDao")
public class PropertyservicemanagerFxtdcDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerFxtdc, String> implements PropertyservicemanagerFxtdcDao{
	public Class<PropertyservicemanagerFxtdc> getModelClazz(){
		return PropertyservicemanagerFxtdc.class;
	}
}