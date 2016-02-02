/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.dao.PurchasingmanagerGenrePropertyDao;

@Repository("PurchasingmanagerGenrePropertyDao")
public class PurchasingmanagerGenrePropertyDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerGenreProperty, String> implements PurchasingmanagerGenrePropertyDao{
	public Class<PurchasingmanagerGenreProperty> getModelClazz(){
		return PurchasingmanagerGenreProperty.class;
	}
}