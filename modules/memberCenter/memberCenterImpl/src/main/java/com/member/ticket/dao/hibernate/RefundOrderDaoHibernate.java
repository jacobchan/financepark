/**
 * 代码声明
 */
package com.member.ticket.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.ticket.entity.RefundOrder;
import com.member.ticket.entity.TicketPassenger;
import com.member.ticket.dao.RefundOrderDao;

@Repository("RefundOrderDao")
public class RefundOrderDaoHibernate extends 
		BaseDaoHibernate<RefundOrder, String> implements RefundOrderDao{
	public Class<RefundOrder> getModelClazz(){
		return RefundOrder.class;
	}

	@Override
	public RefundOrder findByRefundNo(String sequenceNo) {
		String hql = "from sp_refund_order m where "
				+ "m.REFUND_ORDER_NO_ = " + sequenceNo;
		List<RefundOrder> list = getHibernateTemplate().find(hql);
		if (!list.isEmpty()) {
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void update(RefundOrder refundOrder) {
		getHibernateTemplate().update(refundOrder);
		getHibernateTemplate().flush();
	}
}