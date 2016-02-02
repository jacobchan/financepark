/**
 * 代码声明
 */
package com.manage.ActivityManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ActivityManager.entity.ActivityComment;
import com.manage.ActivityManager.dao.ActivityCommentDao;

@Repository("ActivityCommentDao")
public class ActivityCommentDaoHibernate extends 
		BaseDaoHibernate<ActivityComment, String> implements ActivityCommentDao{
	public Class<ActivityComment> getModelClazz(){
		return ActivityComment.class;
	}
}