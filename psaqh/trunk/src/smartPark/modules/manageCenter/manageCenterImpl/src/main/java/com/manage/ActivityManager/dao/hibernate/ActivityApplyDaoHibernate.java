/**
 * 代码声明
 */
package com.manage.ActivityManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.dao.ActivityApplyDao;

@Repository("ActivityApplyDao")
public class ActivityApplyDaoHibernate extends 
		BaseDaoHibernate<ActivityApply, String> implements ActivityApplyDao{
	public Class<ActivityApply> getModelClazz(){
		return ActivityApply.class;
	}
}