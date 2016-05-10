package com.common.NewsManager.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.common.NewsManager.dao.NmIssuenewsDorCDao;
import com.common.NewsManager.entity.NmIssuenewsDorC;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

@Repository("NmIssuenewsDorCDao")
public class NmIssuenewsDorCDaoHibernate extends 
	BaseDaoHibernate<NmIssuenewsDorC, String> implements NmIssuenewsDorCDao{
	public Class<NmIssuenewsDorC> getModelClazz(){
	return NmIssuenewsDorC.class;
	}
}
