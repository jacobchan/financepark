/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationNotice;
import com.manage.EnterpriseManager.dao.InformationNoticeDao;

@Repository("InformationNoticeDao")
public class InformationNoticeDaoHibernate extends 
		BaseDaoHibernate<InformationNotice, String> implements InformationNoticeDao{
	public Class<InformationNotice> getModelClazz(){
		return InformationNotice.class;
	}
}