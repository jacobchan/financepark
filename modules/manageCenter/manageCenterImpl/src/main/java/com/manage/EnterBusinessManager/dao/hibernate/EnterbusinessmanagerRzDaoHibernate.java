/**
 * 代码声明
 */
package com.manage.EnterBusinessManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;

@Repository("EnterbusinessmanagerRzDao")
public class EnterbusinessmanagerRzDaoHibernate extends 
		BaseDaoHibernate<EnterbusinessmanagerRz, String> implements EnterbusinessmanagerRzDao{
	public Class<EnterbusinessmanagerRz> getModelClazz(){
		return EnterbusinessmanagerRz.class;
	}
}