/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerMerchantAddress;
import com.common.purchasingManager.dao.PurchasingmanagerMerchantAddressDao;

@Repository("PurchasingmanagerMerchantAddressDao")
public class PurchasingmanagerMerchantAddressDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerMerchantAddress, String> implements PurchasingmanagerMerchantAddressDao{
	public Class<PurchasingmanagerMerchantAddress> getModelClazz(){
		return PurchasingmanagerMerchantAddress.class;
	}
}