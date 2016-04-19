/**
 * 代码声明
 */
package com.common.MemberManager.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.framework.security.agt.entity.User;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.dao.MemberInformationDao;

@Repository("MemberInformationDao")
public class MemberInformationDaoHibernate extends 
		BaseDaoHibernate<MemberInformation, String> implements MemberInformationDao{
	public Class<MemberInformation> getModelClazz(){
		return MemberInformation.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberInformation> getMembersByRole(final String role) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<User>>() {
					@Override
					public List<User> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer sqlBuf = new StringBuffer();
						sqlBuf.append("select m.* from sp_enterprise_role r , sp_member_information m,sp_enterprise_employees e ");
						sqlBuf.append("where r.EMPLOYEES_ID = e.EMPLOYEES_ID AND e.MEMBER_ID_ = m.MEMBER_ID_ AND r.ROLEID = :role");
						SQLQuery query = session.createSQLQuery(sqlBuf
								.toString());
						query.setParameter("role", role);
						query.addEntity("MemberInformation", MemberInformation.class);
						return query.list();
					}
				});
	}
}