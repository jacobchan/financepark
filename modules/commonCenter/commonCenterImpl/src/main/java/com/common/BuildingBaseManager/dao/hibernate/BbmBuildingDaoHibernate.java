/**
 * 代码声明
 */
package com.common.BuildingBaseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.dao.BbmBuildingDao;

@Repository("BbmBuildingDao")
public class BbmBuildingDaoHibernate extends 
		BaseDaoHibernate<BbmBuilding, String> implements BbmBuildingDao{
	public Class<BbmBuilding> getModelClazz(){
		return BbmBuilding.class;
	}
}