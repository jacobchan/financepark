/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerMoverecDao;

@Repository("PropertyservicemanagerMoverecDao")
public class PropertyservicemanagerMoverecDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerMoverec, String> implements PropertyservicemanagerMoverecDao{
	public Class<PropertyservicemanagerMoverec> getModelClazz(){
		return PropertyservicemanagerMoverec.class;
	}
}