/**
 * 代码声明
 */
package com.manage.PublicUtilitiesManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;
import com.manage.PublicUtilitiesManager.dao.PublicutilitiesmanagerResoDao;

@Repository("PublicutilitiesmanagerResoDao")
public class PublicutilitiesmanagerResoDaoHibernate extends 
		BaseDaoHibernate<PublicutilitiesmanagerReso, String> implements PublicutilitiesmanagerResoDao{
	public Class<PublicutilitiesmanagerReso> getModelClazz(){
		return PublicutilitiesmanagerReso.class;
	}
}