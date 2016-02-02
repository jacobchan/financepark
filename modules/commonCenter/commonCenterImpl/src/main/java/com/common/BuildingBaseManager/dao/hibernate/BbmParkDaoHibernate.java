/**
 * 代码声明
 */
package com.common.BuildingBaseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.dao.BbmParkDao;

@Repository("BbmParkDao")
public class BbmParkDaoHibernate extends 
		BaseDaoHibernate<BbmPark, String> implements BbmParkDao{
	public Class<BbmPark> getModelClazz(){
		return BbmPark.class;
	}
}