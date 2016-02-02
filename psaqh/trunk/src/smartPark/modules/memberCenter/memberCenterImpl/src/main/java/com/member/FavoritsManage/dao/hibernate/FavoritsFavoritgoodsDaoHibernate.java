/**
 * 代码声明
 */
package com.member.FavoritsManage.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.FavoritsManage.entity.FavoritsFavoritgoods;
import com.member.FavoritsManage.dao.FavoritsFavoritgoodsDao;

@Repository("FavoritsFavoritgoodsDao")
public class FavoritsFavoritgoodsDaoHibernate extends 
		BaseDaoHibernate<FavoritsFavoritgoods, String> implements FavoritsFavoritgoodsDao{
	public Class<FavoritsFavoritgoods> getModelClazz(){
		return FavoritsFavoritgoods.class;
	}
}