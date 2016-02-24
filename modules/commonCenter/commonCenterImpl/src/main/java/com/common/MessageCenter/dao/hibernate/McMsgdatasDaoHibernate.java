/**
 * 代码声明
 */
package com.common.MessageCenter.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.common.MessageCenter.dao.McMsgdatasDao;
import com.common.MessageCenter.entity.McMsgdatas;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.framework.security.agt.entity.User;

@Repository("McMsgdatasDao")
public class McMsgdatasDaoHibernate extends 
		BaseDaoHibernate<McMsgdatas, String> implements McMsgdatasDao{
	public Class<McMsgdatas> getModelClazz(){
		return McMsgdatas.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByRoles(final String[] roles) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<User>>(){
			@Override
			public List<User> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sqlBuf = new StringBuffer();
				sqlBuf.append("select u.* from youi_r_user_role r,youi_user u ");
				sqlBuf.append("where u.user_id = r.user_id and r.role_id in (:roles)");
				SQLQuery query = session.createSQLQuery(sqlBuf.toString());
				query.setParameterList("roles", roles);
				query.addEntity("User", User.class);
				return query.list();
			}
		});
	}
}