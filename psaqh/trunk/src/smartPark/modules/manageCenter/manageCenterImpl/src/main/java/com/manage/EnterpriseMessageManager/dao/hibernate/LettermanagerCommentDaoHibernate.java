/**
 * 代码声明
 */
package com.manage.EnterpriseMessageManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseMessageManager.entity.LettermanagerComment;
import com.manage.EnterpriseMessageManager.dao.LettermanagerCommentDao;

@Repository("LettermanagerCommentDao")
public class LettermanagerCommentDaoHibernate extends 
		BaseDaoHibernate<LettermanagerComment, String> implements LettermanagerCommentDao{
	public Class<LettermanagerComment> getModelClazz(){
		return LettermanagerComment.class;
	}
}