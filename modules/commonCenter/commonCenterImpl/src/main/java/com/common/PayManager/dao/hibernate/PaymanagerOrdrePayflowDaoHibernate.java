/**
 * 代码声明
 */
package com.common.PayManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.PayManager.entity.PaymanagerOrdrePayflow;
import com.common.PayManager.dao.PaymanagerOrdrePayflowDao;

@Repository("PaymanagerOrdrePayflowDao")
public class PaymanagerOrdrePayflowDaoHibernate extends 
		BaseDaoHibernate<PaymanagerOrdrePayflow, String> implements PaymanagerOrdrePayflowDao{
	public Class<PaymanagerOrdrePayflow> getModelClazz(){
		return PaymanagerOrdrePayflow.class;
	}
}