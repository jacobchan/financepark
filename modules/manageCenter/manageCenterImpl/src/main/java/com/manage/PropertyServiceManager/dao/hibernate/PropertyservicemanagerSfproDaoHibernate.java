/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSfproDao;

@Repository("PropertyservicemanagerSfproDao")
public class PropertyservicemanagerSfproDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerSfpro, String> implements PropertyservicemanagerSfproDao{
	public Class<PropertyservicemanagerSfpro> getModelClazz(){
		return PropertyservicemanagerSfpro.class;
	}
	
	//根据收费登记获取收费登记项目金额总和
	@Override
	public BigDecimal getChargeAmountByCharge(final PropertyservicemanagerCharge pc) {
		Object obj = getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "SELECT SUM(SFPRO_AMOUNT_) AS totalAmount from sp_propertyservicemanager_sfpro WHERE CHARGE_ID_ = '"+pc.getChargeId()+"'";
				Query query = session.createSQLQuery(hql);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				Object result = query.uniqueResult();
				return result;
			}
		});
		@SuppressWarnings("rawtypes")
		Map map = (HashMap)obj;
		Object res = map.get("totalAmount");
		BigDecimal chargeAmount = BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		if(res != null){
			String str = map.get("totalAmount").toString();
			chargeAmount = new BigDecimal(str).setScale(2, BigDecimal.ROUND_HALF_UP);
			
		}
		return chargeAmount;
	}
}