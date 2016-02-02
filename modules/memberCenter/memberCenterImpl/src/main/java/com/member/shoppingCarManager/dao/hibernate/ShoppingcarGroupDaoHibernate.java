/**
 * 代码声明
 */
package com.member.shoppingCarManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.shoppingCarManager.entity.ShoppingcarGroup;
import com.member.shoppingCarManager.dao.ShoppingcarGroupDao;

@Repository("ShoppingcarGroupDao")
public class ShoppingcarGroupDaoHibernate extends 
		BaseDaoHibernate<ShoppingcarGroup, String> implements ShoppingcarGroupDao{
	public Class<ShoppingcarGroup> getModelClazz(){
		return ShoppingcarGroup.class;
	}
}