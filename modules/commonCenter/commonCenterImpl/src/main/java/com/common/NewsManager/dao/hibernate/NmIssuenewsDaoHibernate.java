/**
 * 代码声明
 */
package com.common.NewsManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.dao.NmIssuenewsDao;

@Repository("NmIssuenewsDao")
public class NmIssuenewsDaoHibernate extends 
		BaseDaoHibernate<NmIssuenews, String> implements NmIssuenewsDao{
	public Class<NmIssuenews> getModelClazz(){
		return NmIssuenews.class;
	}
}