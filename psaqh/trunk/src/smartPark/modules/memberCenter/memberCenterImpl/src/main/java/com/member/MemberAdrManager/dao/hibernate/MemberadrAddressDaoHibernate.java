/**
 * 代码声明
 */
package com.member.MemberAdrManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.member.MemberAdrManager.entity.MemberadrAddress;
import com.member.MemberAdrManager.dao.MemberadrAddressDao;

@Repository("MemberadrAddressDao")
public class MemberadrAddressDaoHibernate extends 
		BaseDaoHibernate<MemberadrAddress, String> implements MemberadrAddressDao{
	public Class<MemberadrAddress> getModelClazz(){
		return MemberadrAddress.class;
	}
}