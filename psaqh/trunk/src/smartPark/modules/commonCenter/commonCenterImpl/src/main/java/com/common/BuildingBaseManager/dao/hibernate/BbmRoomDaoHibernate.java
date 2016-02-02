/**
 * 代码声明
 */
package com.common.BuildingBaseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.dao.BbmRoomDao;

@Repository("BbmRoomDao")
public class BbmRoomDaoHibernate extends 
		BaseDaoHibernate<BbmRoom, String> implements BbmRoomDao{
	public Class<BbmRoom> getModelClazz(){
		return BbmRoom.class;
	}
}