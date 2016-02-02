/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTsDao;

@Repository("PropertyservicemanagerTsDao")
public class PropertyservicemanagerTsDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerTs, String> implements PropertyservicemanagerTsDao{
	public Class<PropertyservicemanagerTs> getModelClazz(){
		return PropertyservicemanagerTs.class;
	}
}