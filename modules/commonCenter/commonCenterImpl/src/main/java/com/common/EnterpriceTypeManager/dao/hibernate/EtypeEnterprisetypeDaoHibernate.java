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
		String hql = "from EtypeEnterprisetype where etypeEnterprisetype.enTypeId is null";
		return getHibernateTemplate().find(hql);
	}
}