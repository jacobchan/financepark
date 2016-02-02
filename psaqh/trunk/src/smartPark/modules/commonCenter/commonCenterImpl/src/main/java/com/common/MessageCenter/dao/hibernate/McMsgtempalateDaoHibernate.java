/**
 * 代码声明
 */
package com.common.MessageCenter.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.dao.McMsgtempalateDao;

@Repository("McMsgtempalateDao")
public class McMsgtempalateDaoHibernate extends 
		BaseDaoHibernate<McMsgtempalate, String> implements McMsgtempalateDao{
	public Class<McMsgtempalate> getModelClazz(){
		return McMsgtempalate.class;
	}
}