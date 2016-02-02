/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerChargeDao;

@Repository("PropertyservicemanagerChargeDao")
public class PropertyservicemanagerChargeDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerCharge, String> implements PropertyservicemanagerChargeDao{
	public Class<PropertyservicemanagerCharge> getModelClazz(){
		return PropertyservicemanagerCharge.class;
	}
}