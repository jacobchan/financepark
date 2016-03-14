/**
 * 代码声明
 */
package com.member.hotel.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.hotel.entity.HotelOrder;
import com.member.hotel.dao.HotelOrderDao;

@Repository("HotelOrderDao")
public class HotelOrderDaoHibernate extends 
		BaseDaoHibernate<HotelOrder, String> implements HotelOrderDao{
	public Class<HotelOrder> getModelClazz(){
		return HotelOrder.class;
	}
}