/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationKnowledge;
import com.manage.EnterpriseManager.dao.InformationKnowledgeDao;

@Repository("InformationKnowledgeDao")
public class InformationKnowledgeDaoHibernate extends 
		BaseDaoHibernate<InformationKnowledge, String> implements InformationKnowledgeDao{
	public Class<InformationKnowledge> getModelClazz(){
		return InformationKnowledge.class;
	}
}