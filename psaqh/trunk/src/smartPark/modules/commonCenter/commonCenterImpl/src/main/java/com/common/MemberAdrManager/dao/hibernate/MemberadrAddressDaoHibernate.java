/**
 * 代码声明
 */
package com.common.MemberAdrManager.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.common.MemberAdrManager.dao.MemberadrAddressDao;
import com.common.MemberAdrManager.entity.MemberadrAddress;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

@Repository("MemberadrAddressDao")
public class MemberadrAddressDaoHibernate extends 
		BaseDaoHibernate<MemberadrAddress, String> implements MemberadrAddressDao{
	public Class<MemberadrAddress> getModelClazz(){
		return MemberadrAddress.class;
	}
}