/**
 * 代码声明
 */
package com.common.MemberManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.dao.MemberInformationDao;

@Repository("MemberInformationDao")
public class MemberInformationDaoHibernate extends 
		BaseDaoHibernate<MemberInformation, String> implements MemberInformationDao{
	public Class<MemberInformation> getModelClazz(){
		return MemberInformation.class;
	}
}