/**
 * 代码声明
 */
package com.member.hotel.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.hotel.entity.RoomPeople;
import com.member.hotel.dao.RoomPeopleDao;

@Repository("RoomPeopleDao")
public class RoomPeopleDaoHibernate extends 
		BaseDaoHibernate<RoomPeople, String> implements RoomPeopleDao{
	public Class<RoomPeople> getModelClazz(){
		return RoomPeople.class;
	}
}