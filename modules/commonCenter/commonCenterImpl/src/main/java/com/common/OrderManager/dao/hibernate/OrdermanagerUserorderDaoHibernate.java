/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;

@Repository("OrdermanagerUserorderDao")
public class OrdermanagerUserorderDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerUserorder, String> implements OrdermanagerUserorderDao{
	public Class<OrdermanagerUserorder> getModelClazz(){
		return OrdermanagerUserorder.class;
	}
}