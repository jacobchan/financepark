/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.EnterpriseManager.dao.InformationLegalDao;

@Repository("InformationLegalDao")
public class InformationLegalDaoHibernate extends 
		BaseDaoHibernate<InformationLegal, String> implements InformationLegalDao{
	public Class<InformationLegal> getModelClazz(){
		return InformationLegal.class;
	}
}