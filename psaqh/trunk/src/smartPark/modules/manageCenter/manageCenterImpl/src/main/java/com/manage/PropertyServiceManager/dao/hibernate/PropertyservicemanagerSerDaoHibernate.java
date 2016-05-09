/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.framework.core.dataobj.Record;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSerDao;

@Repository("PropertyservicemanagerSerDao")
public class PropertyservicemanagerSerDaoHibernate extends 
		BaseDaoHibernate<PropertyservicemanagerSer, String> implements PropertyservicemanagerSerDao{
	public Class<PropertyservicemanagerSer> getModelClazz(){
		return PropertyservicemanagerSer.class;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Record> querySerList(final String id) {
		return (List<Record>)getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select ym.ITEM_CAPTION,t.SER_PRICE_ from sp_propertyservicemanager_ser t "
						+ "left join youi_codeitem ym on t.SER_NAME_ = ym.ITEM_VALUE "
						+"left join youi_codemap yp on ym.Codemap_ID = yp.CODEMAP_ID WHERE yp.`CODE`='ser_name' and t.TS_ID_ = :id";
				Query query = session.createSQLQuery(sql);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				query.setParameter("id", id);
				List list = query.list();
				List<Record> records = new ArrayList<Record>();
				for(Object obj:list){
					Map map = (Map)obj;
					Record record = new Record();
					Set keys = map.keySet();
					for(Object key:keys){
						record.put(key.toString(), map.get(key));
					}
					records.add(record);
				}
				return records;
			}
		});

	}
}