/**
 * 代码声明
 */
package com.manage.ActivityManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ActivityManager.entity.ApplayType;
import com.manage.ActivityManager.dao.ApplayTypeDao;

@Repository("ApplayTypeDao")
public class ApplayTypeDaoHibernate extends 
		BaseDaoHibernate<ApplayType, String> implements ApplayTypeDao{
	public Class<ApplayType> getModelClazz(){
		return ApplayType.class;
	}
}