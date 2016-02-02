/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationMedia;
import com.manage.EnterpriseManager.dao.InformationMediaDao;

@Repository("InformationMediaDao")
public class InformationMediaDaoHibernate extends 
		BaseDaoHibernate<InformationMedia, String> implements InformationMediaDao{
	public Class<InformationMedia> getModelClazz(){
		return InformationMedia.class;
	}
}