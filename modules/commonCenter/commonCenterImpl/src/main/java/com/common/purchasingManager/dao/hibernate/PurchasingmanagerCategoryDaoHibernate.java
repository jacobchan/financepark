/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerCategory;
import com.common.purchasingManager.dao.PurchasingmanagerCategoryDao;

@Repository("PurchasingmanagerCategoryDao")
public class PurchasingmanagerCategoryDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCategory, String> implements PurchasingmanagerCategoryDao{
	public Class<PurchasingmanagerCategory> getModelClazz(){
		return PurchasingmanagerCategory.class;
	}
}