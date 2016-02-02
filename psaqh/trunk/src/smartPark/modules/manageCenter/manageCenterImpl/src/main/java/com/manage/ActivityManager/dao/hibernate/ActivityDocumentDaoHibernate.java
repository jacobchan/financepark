/**
 * 代码声明
 */
package com.manage.ActivityManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.ActivityManager.entity.ActivityDocument;
import com.manage.ActivityManager.dao.ActivityDocumentDao;

@Repository("ActivityDocumentDao")
public class ActivityDocumentDaoHibernate extends 
		BaseDaoHibernate<ActivityDocument, String> implements ActivityDocumentDao{
	public Class<ActivityDocument> getModelClazz(){
		return ActivityDocument.class;
	}
}