/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerOrderprojecttype;
import com.common.OrderManager.dao.OrdermanagerOrderprojecttypeDao;

@Repository("OrdermanagerOrderprojecttypeDao")
public class OrdermanagerOrderprojecttypeDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerOrderprojecttype, String> implements OrdermanagerOrderprojecttypeDao{
	public Class<OrdermanagerOrderprojecttype> getModelClazz(){
		return OrdermanagerOrderprojecttype.class;
	}
}