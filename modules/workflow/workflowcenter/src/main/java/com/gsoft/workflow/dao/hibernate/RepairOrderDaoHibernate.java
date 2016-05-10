package com.gsoft.workflow.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.workflow.dao.RepairOrderDao;
import com.gsoft.workflow.entity.RepairOrder;

@Repository
public class RepairOrderDaoHibernate extends BaseDaoHibernate<RepairOrder, String> implements
RepairOrderDao {
	public Class<RepairOrder> getModelClazz() {
		return RepairOrder.class;
	}


}
