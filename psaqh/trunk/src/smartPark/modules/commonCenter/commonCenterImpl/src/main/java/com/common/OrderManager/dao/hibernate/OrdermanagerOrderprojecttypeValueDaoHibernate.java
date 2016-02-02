/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeValueDao;

@Repository("OrdermanagerOrderprojecttypeValueDao")
public class OrdermanagerOrderprojecttypeValueDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerOrderprojecttypeValue, String> implements OrdermanagerOrderprojecttypeValueDao{
	public Class<OrdermanagerOrderprojecttypeValue> getModelClazz(){
		return OrdermanagerOrderprojecttypeValue.class;
	}
}