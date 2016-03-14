/**
 * 代码声明
 */
package com.distribution.rule.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.distribution.rule.entity.DisRateConfig;
import com.distribution.rule.dao.DisRateConfigDao;

@Repository("DisRateConfigDao")
public class DisRateConfigDaoHibernate extends 
		BaseDaoHibernate<DisRateConfig, String> implements DisRateConfigDao{
	public Class<DisRateConfig> getModelClazz(){
		return DisRateConfig.class;
	}
}