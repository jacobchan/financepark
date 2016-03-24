/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.dao.PurchasingmanagerPublicDao;

@Repository("PurchasingmanagerPublicDao")
public class PurchasingmanagerPublicDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCommodity, String> implements PurchasingmanagerPublicDao{
	public Class<PurchasingmanagerCommodity> getModelClazz(){
		return PurchasingmanagerCommodity.class;
	}
}