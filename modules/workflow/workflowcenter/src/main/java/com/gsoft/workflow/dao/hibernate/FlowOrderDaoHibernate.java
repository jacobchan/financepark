package com.gsoft.workflow.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.workflow.dao.FlowOrderDao;
import com.gsoft.workflow.entity.FlowOrder;

@Repository
public class FlowOrderDaoHibernate extends BaseDaoHibernate<FlowOrder, String> implements
FlowOrderDao {
	public Class<FlowOrder> getModelClazz() {
		return FlowOrder.class;
	}


}
