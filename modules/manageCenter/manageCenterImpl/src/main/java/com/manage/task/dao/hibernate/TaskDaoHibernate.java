/**
 * 代码声明
 */
package com.manage.task.dao.hibernate;

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
import com.manage.task.dao.TaskDao;
import com.manage.task.entity.Task;

@Repository("TaskDao")
public class TaskDaoHibernate extends 
		BaseDaoHibernate<Task, String> implements TaskDao{
	public Class<Task> getModelClazz(){
		return Task.class;
	}
	//查询任务总数
	@Override
	public String getTaskCount(final String tableName,final String filter) {
		Object obj = getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "SELECT count(*) AS taskCount from "+tableName+" where "+filter;
				Query query = session.createSQLQuery(hql);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				Object result = query.uniqueResult();
				return result;
			}
		});
		@SuppressWarnings("rawtypes")
		Map map = (HashMap)obj;
		System.out.println(map.toString());
		return map.get("taskCount").toString();
	}
}