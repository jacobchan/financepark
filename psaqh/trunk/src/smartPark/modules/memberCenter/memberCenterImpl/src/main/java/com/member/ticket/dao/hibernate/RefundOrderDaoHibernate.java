/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.RefundOrder;
import com.member.ticket.dao.RefundOrderDao;

@Repository("RefundOrderDao")
public class RefundOrderDaoHibernate extends 
		BaseDaoHibernate<RefundOrder, String> implements RefundOrderDao{
	public Class<RefundOrder> getModelClazz(){
		return RefundOrder.class;
	}
}