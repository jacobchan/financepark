/**
 * 代码声明
 */
package com.member.ticket.dao;

import com.gsoft.framework.core.dao.Dao;
import com.member.ticket.entity.RefundOrder;

public interface RefundOrderDao extends Dao<RefundOrder, String>  {

	RefundOrder findByRefundNo(String sequenceNo);

	void update(RefundOrder refundOrder);
	
}