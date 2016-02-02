/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendValueDao;

@Repository("PurchasingmanagerCommodityExtendValueDao")
public class PurchasingmanagerCommodityExtendValueDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCommodityExtendValue, String> implements PurchasingmanagerCommodityExtendValueDao{
	public Class<PurchasingmanagerCommodityExtendValue> getModelClazz(){
		return PurchasingmanagerCommodityExtendValue.class;
	}
}