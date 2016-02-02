/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerOrdertype;
import com.common.OrderManager.dao.OrdermanagerOrdertypeDao;

@Repository("OrdermanagerOrdertypeDao")
public class OrdermanagerOrdertypeDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerOrdertype, String> implements OrdermanagerOrdertypeDao{
	public Class<OrdermanagerOrdertype> getModelClazz(){
		return OrdermanagerOrdertype.class;
	}
}