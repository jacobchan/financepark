/**
 * 代码声明
 */
package com.manage.ActivityManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.ActivityManager.dao.ActivityApplylistDao;

@Repository("ActivityApplylistDao")
public class ActivityApplylistDaoHibernate extends 
		BaseDaoHibernate<ActivityApplylist, String> implements ActivityApplylistDao{
	public Class<ActivityApplylist> getModelClazz(){
		return ActivityApplylist.class;
	}
}