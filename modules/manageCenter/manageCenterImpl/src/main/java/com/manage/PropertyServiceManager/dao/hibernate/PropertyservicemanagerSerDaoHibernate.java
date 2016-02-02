/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSerDao;

@Repository("PropertyservicemanagerSerDao")
public class PropertyservicemanagerSerDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerSer, String> implements PropertyservicemanagerSerDao{
	public Class<PropertyservicemanagerSer> getModelClazz(){
		return PropertyservicemanagerSer.class;
	}
}