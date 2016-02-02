/**
 * 代码声明
 */
package com.common.NewsManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.NewsManager.entity.NmIssuetempalate;
import com.common.NewsManager.dao.NmIssuetempalateDao;

@Repository("NmIssuetempalateDao")
public class NmIssuetempalateDaoHibernate extends 
		BaseDaoHibernate<NmIssuetempalate, String> implements NmIssuetempalateDao{
	public Class<NmIssuetempalate> getModelClazz(){
		return NmIssuetempalate.class;
	}
}