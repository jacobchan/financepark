/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;

@Repository("PropertyservicemanagerBxDao")
public class PropertyservicemanagerBxDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerBx, String> implements PropertyservicemanagerBxDao{
	public Class<PropertyservicemanagerBx> getModelClazz(){
		return PropertyservicemanagerBx.class;
	}
}