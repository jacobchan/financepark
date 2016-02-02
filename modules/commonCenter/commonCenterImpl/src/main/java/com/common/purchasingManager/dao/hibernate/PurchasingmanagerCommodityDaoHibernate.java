/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;

@Repository("PurchasingmanagerCommodityDao")
public class PurchasingmanagerCommodityDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCommodity, String> implements PurchasingmanagerCommodityDao{
	public Class<PurchasingmanagerCommodity> getModelClazz(){
		return PurchasingmanagerCommodity.class;
	}
}