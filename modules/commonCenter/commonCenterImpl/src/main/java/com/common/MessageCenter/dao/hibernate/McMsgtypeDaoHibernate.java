/**
 * 代码声明
 */
package com.common.MessageCenter.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.MessageCenter.entity.McMsgtype;
import com.common.MessageCenter.dao.McMsgtypeDao;

@Repository("McMsgtypeDao")
public class McMsgtypeDaoHibernate extends 
		BaseDaoHibernate<McMsgtype, String> implements McMsgtypeDao{
	public Class<McMsgtype> getModelClazz(){
		return McMsgtype.class;
	}
}