/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEntrecDao;

@Repository("PropertyservicemanagerEntrecDao")
public class PropertyservicemanagerEntrecDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerEntrec, String> implements PropertyservicemanagerEntrecDao{
	public Class<PropertyservicemanagerEntrec> getModelClazz(){
		return PropertyservicemanagerEntrec.class;
	}
}