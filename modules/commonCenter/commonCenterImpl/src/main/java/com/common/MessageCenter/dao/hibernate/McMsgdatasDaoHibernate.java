/**
 * 代码声明
 */
package com.common.MessageCenter.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.dao.McMsgdatasDao;

@Repository("McMsgdatasDao")
public class McMsgdatasDaoHibernate extends 
		BaseDaoHibernate<McMsgdatas, String> implements McMsgdatasDao{
	public Class<McMsgdatas> getModelClazz(){
		return McMsgdatas.class;
	}
}