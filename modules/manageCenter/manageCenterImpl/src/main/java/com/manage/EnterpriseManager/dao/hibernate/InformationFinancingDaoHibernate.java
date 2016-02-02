/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationFinancing;
import com.manage.EnterpriseManager.dao.InformationFinancingDao;

@Repository("InformationFinancingDao")
public class InformationFinancingDaoHibernate extends 
		BaseDaoHibernate<InformationFinancing, String> implements InformationFinancingDao{
	public Class<InformationFinancing> getModelClazz(){
		return InformationFinancing.class;
	}
}