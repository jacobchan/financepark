/**
 * 代码声明
 */
package com.member.shoppingCarManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.shoppingCarManager.entity.ShoppingcarCompanyserver;
import com.member.shoppingCarManager.dao.ShoppingcarCompanyserverDao;

@Repository("ShoppingcarCompanyserverDao")
public class ShoppingcarCompanyserverDaoHibernate extends 
		BaseDaoHibernate<ShoppingcarCompanyserver, String> implements ShoppingcarCompanyserverDao{
	public Class<ShoppingcarCompanyserver> getModelClazz(){
		return ShoppingcarCompanyserver.class;
	}
}