/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.common.purchasingManager.dao.PurchasingmanagerGenreevaluateDao;
import com.common.purchasingManager.entity.PurchasingmanagerGenreevaluate;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;


@Repository("PurchasingmanagerGenreevaluateDao")
public class PurchasingmanagerGenreevaluateDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerGenreevaluate, String> implements PurchasingmanagerGenreevaluateDao{
	public Class<PurchasingmanagerGenreevaluate> getModelClazz(){
		return PurchasingmanagerGenreevaluate.class;
	}
}