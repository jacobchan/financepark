/**
 * 代码声明
 */
package com.member.FavoritsManage.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.FavoritsManage.entity.FavoritsFavoritActivity;
import com.member.FavoritsManage.dao.FavoritsFavoritActivityDao;

@Repository("FavoritsFavoritActivityDao")
public class FavoritsFavoritActivityDaoHibernate extends 
		BaseDaoHibernate<FavoritsFavoritActivity, String> implements FavoritsFavoritActivityDao{
	public Class<FavoritsFavoritActivity> getModelClazz(){
		return FavoritsFavoritActivity.class;
	}
}