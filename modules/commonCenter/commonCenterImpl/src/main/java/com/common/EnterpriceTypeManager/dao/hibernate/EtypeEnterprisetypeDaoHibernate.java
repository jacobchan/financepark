package com.common.EnterpriceTypeManager.dao.hibernate;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.dao.EtypeEnterprisetypeDao;
@Repository("EtypeEnterprisetypeDao")
public class EtypeEnterprisetypeDaoHibernate extends 
		BaseDaoHibernate<EtypeEnterprisetype, String> implements EtypeEnterprisetypeDao{
	public Class<EtypeEnterprisetype> getModelClazz(){
		return EtypeEnterprisetype.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EtypeEnterprisetype> getEtypeEnterprisetypeList() {
		String hql = "from EtypeEnterprisetype et where et.etypeEnterprisetype is NULL order by et.enTypeId";
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EtypeEnterprisetype> getSubEnterpriseTypeList() {
		String hql = "from EtypeEnterprisetype et where et.etypeEnterprisetype is not null";
		return getHibernateTemplate().find(hql);
	}
}