/**
 * 代码声明
 */
package com.manage.EnterpriseManager.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

import com.manage.EnterpriseManager.entity.InformationProduct;
import com.manage.EnterpriseManager.dao.InformationProductDao;

@Repository("InformationProductDao")
public class InformationProductDaoHibernate extends 
		BaseDaoHibernate<InformationProduct, String> implements InformationProductDao{
	public Class<InformationProduct> getModelClazz(){
		return InformationProduct.class;
	}
}