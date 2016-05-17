/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;

@Repository("PurchasingmanagerCommodityDao")
public class PurchasingmanagerCommodityDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerCommodity, String> implements PurchasingmanagerCommodityDao{
	public Class<PurchasingmanagerCommodity> getModelClazz(){
		return PurchasingmanagerCommodity.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserRoleListByRoleId(final String roleId){
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<User>>() {
					@Override
					public List<User> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer sqlBuf = new StringBuffer();
						sqlBuf.append("SELECT r.* FROM YOUI_USER r LEFT OUTER JOIN YOUI_R_USER_ROLE r1 ON r.USER_ID=r1.USER_ID where r1.ROLE_ID  = :roleId");
						SQLQuery query = session.createSQLQuery(sqlBuf
								.toString());
						query.setParameter("roleId", roleId);
						query.addEntity("User", User.class);
						return query.list();
					}
				});
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUserRoleListByMenuId(final String id){
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {
					@Override
					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer sqlBuf = new StringBuffer();
						sqlBuf.append("select m.ROLE_ID as roleId from youi_r_role_menu m where m.MENU_ID= :menuId");
						SQLQuery query = session.createSQLQuery(sqlBuf
								.toString());
						query.setParameter("menuId", id);
						query.addScalar("roleId", Hibernate.STRING);
						return query.list();
					}
				});
	}
	
}