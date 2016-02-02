/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendDao;

@Repository("PurchasingmanagerCommodityExtendDao")
public class PurchasingmanagerCommodityExtendDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCommodityExtend, String> implements PurchasingmanagerCommodityExtendDao{
	public Class<PurchasingmanagerCommodityExtend> getModelClazz(){
		return PurchasingmanagerCommodityExtend.class;
	}
}