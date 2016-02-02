/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.dao.OrdermanagerCommoditydetailDao;

@Repository("OrdermanagerCommoditydetailDao")
public class OrdermanagerCommoditydetailDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerCommoditydetail, String> implements OrdermanagerCommoditydetailDao{
	public Class<OrdermanagerCommoditydetail> getModelClazz(){
		return OrdermanagerCommoditydetail.class;
	}
}