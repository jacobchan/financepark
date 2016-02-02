/**
 * 代码声明
 */
package com.common.NewsManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.dao.NmIssuetypeDao;

@Repository("NmIssuetypeDao")
public class NmIssuetypeDaoHibernate extends 
		BaseDaoHibernate<NmIssuetype, String> implements NmIssuetypeDao{
	public Class<NmIssuetype> getModelClazz(){
		return NmIssuetype.class;
	}
}