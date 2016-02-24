/**
 * 代码声明
 */
package com.common.MessageCenter.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.common.MessageCenter.dao.McMsgdatasDao;
import com.common.MessageCenter.entity.McMsgdatas;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

@Repository("McMsgdatasDao")
public class McMsgdatasDaoHibernate extends 
		BaseDaoHibernate<McMsgdatas, String> implements McMsgdatasDao{
	public Class<McMsgdatas> getModelClazz(){
		return McMsgdatas.class;
	}

}