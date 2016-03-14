/**
 * 代码声明
 */
package com.distribution.income.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.distribution.income.entity.SalesRec;
import com.distribution.income.dao.SalesRecDao;

@Repository("SalesRecDao")
public class SalesRecDaoHibernate extends 
		BaseDaoHibernate<SalesRec, String> implements SalesRecDao{
	public Class<SalesRec> getModelClazz(){
		return SalesRec.class;
	}
}