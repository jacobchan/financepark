/**
 * 代码声明
 */
package com.distribution.income.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.distribution.income.entity.SettleRec;
import com.distribution.income.dao.SettleRecDao;

@Repository("SettleRecDao")
public class SettleRecDaoHibernate extends 
		BaseDaoHibernate<SettleRec, String> implements SettleRecDao{
	public Class<SettleRec> getModelClazz(){
		return SettleRec.class;
	}
}