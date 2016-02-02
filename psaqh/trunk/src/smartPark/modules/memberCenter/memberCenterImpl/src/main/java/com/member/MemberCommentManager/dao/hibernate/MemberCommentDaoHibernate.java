/**
 * 代码声明
 */
package com.member.MemberCommentManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.MemberCommentManager.entity.MemberComment;
import com.member.MemberCommentManager.dao.MemberCommentDao;

@Repository("MemberCommentDao")
public class MemberCommentDaoHibernate extends 
		BaseDaoHibernate<MemberComment, String> implements MemberCommentDao{
	public Class<MemberComment> getModelClazz(){
		return MemberComment.class;
	}
}