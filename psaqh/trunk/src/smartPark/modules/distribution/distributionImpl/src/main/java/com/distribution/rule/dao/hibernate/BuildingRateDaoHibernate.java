/**
 * 代码声明
 */
package com.distribution.rule.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.distribution.rule.entity.BuildingRate;
import com.distribution.rule.dao.BuildingRateDao;

@Repository("BuildingRateDao")
public class BuildingRateDaoHibernate extends 
		BaseDaoHibernate<BuildingRate, String> implements BuildingRateDao{
	public Class<BuildingRate> getModelClazz(){
		return BuildingRate.class;
	}
}