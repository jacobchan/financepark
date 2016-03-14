/**
 * 代码声明
 */
package com.member.hotel.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.hotel.entity.HotelOrderItem;
import com.member.hotel.dao.HotelOrderItemDao;

@Repository("HotelOrderItemDao")
public class HotelOrderItemDaoHibernate extends 
		BaseDaoHibernate<HotelOrderItem, String> implements HotelOrderItemDao{
	public Class<HotelOrderItem> getModelClazz(){
		return HotelOrderItem.class;
	}
}