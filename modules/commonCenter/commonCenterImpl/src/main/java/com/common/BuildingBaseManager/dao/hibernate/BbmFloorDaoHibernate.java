/**
 * 代码声明
 */
package com.common.BuildingBaseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.dao.BbmFloorDao;

@Repository("BbmFloorDao")
public class BbmFloorDaoHibernate extends 
		BaseDaoHibernate<BbmFloor, String> implements BbmFloorDao{
	public Class<BbmFloor> getModelClazz(){
		return BbmFloor.class;
	}
}