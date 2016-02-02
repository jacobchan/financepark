/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerOrdermerchanNexus;
import com.common.OrderManager.dao.OrdermanagerOrdermerchanNexusDao;

@Repository("OrdermanagerOrdermerchanNexusDao")
public class OrdermanagerOrdermerchanNexusDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerOrdermerchanNexus, String> implements OrdermanagerOrdermerchanNexusDao{
	public Class<OrdermanagerOrdermerchanNexus> getModelClazz(){
		return OrdermanagerOrdermerchanNexus.class;
	}
}