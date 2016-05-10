package com.gsoft.workflow.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.workflow.dao.FlowdataDao;
import com.gsoft.workflow.entity.Flowdata;

@Repository
public class FlowdataDaoHibernate extends BaseDaoHibernate<Flowdata, String> implements
FlowdataDao {
	public Class<Flowdata> getModelClazz() {
		return Flowdata.class;
	}


}
