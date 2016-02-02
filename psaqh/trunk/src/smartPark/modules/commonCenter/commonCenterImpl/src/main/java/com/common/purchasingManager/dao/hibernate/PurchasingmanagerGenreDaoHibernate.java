/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.dao.PurchasingmanagerGenreDao;

@Repository("PurchasingmanagerGenreDao")
public class PurchasingmanagerGenreDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerGenre, String> implements PurchasingmanagerGenreDao{
	public Class<PurchasingmanagerGenre> getModelClazz(){
		return PurchasingmanagerGenre.class;
	}
}