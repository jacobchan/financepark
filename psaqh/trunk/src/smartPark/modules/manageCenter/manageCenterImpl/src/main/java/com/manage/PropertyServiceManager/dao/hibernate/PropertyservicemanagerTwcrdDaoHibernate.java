/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTwcrd;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTwcrdDao;

@Repository("PropertyservicemanagerTwcrdDao")
public class PropertyservicemanagerTwcrdDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerTwcrd, String> implements PropertyservicemanagerTwcrdDao{
	public Class<PropertyservicemanagerTwcrd> getModelClazz(){
		return PropertyservicemanagerTwcrd.class;
	}
}