/**
 * 代码声明
 */
package com.manage.EnterpriseMessageManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseMessageManager.entity.LettermanagerLetter;
import com.manage.EnterpriseMessageManager.dao.LettermanagerLetterDao;

@Repository("LettermanagerLetterDao")
public class LettermanagerLetterDaoHibernate extends 
		BaseDaoHibernate<LettermanagerLetter, String> implements LettermanagerLetterDao{
	public Class<LettermanagerLetter> getModelClazz(){
		return LettermanagerLetter.class;
	}
}