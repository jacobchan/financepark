/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.dao.PurchasingmanagerMerchantDao;

@Repository("PurchasingmanagerMerchantDao")
public class PurchasingmanagerMerchantDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerMerchant, String> implements PurchasingmanagerMerchantDao{
	public Class<PurchasingmanagerMerchant> getModelClazz(){
		return PurchasingmanagerMerchant.class;
	}
}