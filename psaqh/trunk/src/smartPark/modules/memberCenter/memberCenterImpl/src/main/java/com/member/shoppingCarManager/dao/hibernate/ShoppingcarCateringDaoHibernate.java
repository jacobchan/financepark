/**
 * 代码声明
 */
package com.member.shoppingCarManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.shoppingCarManager.entity.ShoppingcarCatering;
import com.member.shoppingCarManager.dao.ShoppingcarCateringDao;

@Repository("ShoppingcarCateringDao")
public class ShoppingcarCateringDaoHibernate extends 
		BaseDaoHibernate<ShoppingcarCatering, String> implements ShoppingcarCateringDao{
	public Class<ShoppingcarCatering> getModelClazz(){
		return ShoppingcarCatering.class;
	}
}