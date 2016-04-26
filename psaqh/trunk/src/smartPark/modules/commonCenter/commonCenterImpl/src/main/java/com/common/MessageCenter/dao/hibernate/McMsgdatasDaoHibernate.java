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
import com.common.MessageCenter.entity.Code;
import com.common.MessageCenter.entity.McMsgdatas;
import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;

@Repository("McMsgdatasDao")
public class McMsgdatasDaoHibernate extends 
		BaseDaoHibernate<McMsgdatas, String> implements McMsgdatasDao{
	public Class<McMsgdatas> getModelClazz(){
		return McMsgdatas.class;
	}

	@Override
	public Code getNewCode(final String phone) {
		return (Code) this.getHibernateTemplate().execute(
				new HibernateCallback<Code>() {
					@SuppressWarnings("unchecked")
					@Override
					public Code doInHibernate(Session session)throws HibernateException, SQLException {
						StringBuffer sqlBuf = new StringBuffer();
						sqlBuf.append("select MSG_CONTENT_ , SEND_DATE_ from sp_mc_msgdatas_ WHERE RECEIVE_ = :phone and SEND_STATUS_ = '02' and MSG_TYPE_='0' ORDER BY SEND_DATE_ desc limit 1");
						SQLQuery query = session.createSQLQuery(sqlBuf.toString());
						query.setParameter("phone", phone);
//						query.setMaxResults(1);
						List<Object[]> list = query.list();
						if(list!=null&&list.size()>0){
							Object [] results = list.get(0);
							Code code = new Code();
							code.setCode(results[0].toString());
							code.setSendTime(results[1].toString());
							return code;
						}
						return null;
	//					return (Code) query.uniqueResult();
					}
				});
	}
	
}