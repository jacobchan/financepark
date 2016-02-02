/**
 * 代码声明
 */
package com.common.EnterpriceTypeManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.dao.EtypeEnterprisetypeDao;

@Repository("EtypeEnterprisetypeDao")
public class EtypeEnterprisetypeDaoHibernate extends 
		BaseDaoHibernate<EtypeEnterprisetype, String> implements EtypeEnterprisetypeDao{
	public Class<EtypeEnterprisetype> getModelClazz(){
		return EtypeEnterprisetype.class;
	}
}