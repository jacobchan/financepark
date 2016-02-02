/**
 * 代码声明
 */
package com.common.NewsManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.dao.NmIssueflowDao;

@Repository("NmIssueflowDao")
public class NmIssueflowDaoHibernate extends 
		BaseDaoHibernate<NmIssueflow, String> implements NmIssueflowDao{
	public Class<NmIssueflow> getModelClazz(){
		return NmIssueflow.class;
	}
}