/**
 * 代码声明
 */
package com.common.purchasingManager.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.dao.PurchasingmanagerGenreDao;

@Repository("PurchasingmanagerGenreDao")
public class PurchasingmanagerGenreDaoHibernate extends 
		BaseDaoHibernate<PurchasingmanagerGenre, String> implements PurchasingmanagerGenreDao{
	public Class<PurchasingmanagerGenre> getModelClazz(){
		return PurchasingmanagerGenre.class;
	}
	
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<PurchasingmanagerGenre> getRootList() {
//			List<PurchasingmanagerGenre> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<PurchasingmanagerGenre>>(){
//			@Override
//			public List<PurchasingmanagerGenre> doInHibernate(Session session) throws HibernateException,
//					SQLException {
//				StringBuffer sqlBuf = new StringBuffer();
//				sqlBuf.append("select a.* from P2P_AUTO_BID_ a,P2P_MEMBER_BASE_ b where a.USER_ = b.ID_ and a.STATUS_ = '00' and a.SET_STATUS_ = '00' order by b.USER_LEVER_ desc,a.LAST_TIME_");
//				SQLQuery query = session.createSQLQuery(sqlBuf.toString());
//				query.addEntity("autoBid", PurchasingmanagerGenre.class);
//				return query.list();
//			}
//		});
//		return list;
//	}
	//得到类别根列表
	@SuppressWarnings("unchecked")
	@Override
	public List<PurchasingmanagerGenre> getRootList() {
		String hql = "from PurchasingmanagerGenre m where "
				+ "m.purchasingmanagerGenre is null ";
		return getHibernateTemplate().find(hql);
	}
}