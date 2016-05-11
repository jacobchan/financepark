/**
 * 代码声明
 */
package com.common.OrderManager.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gsoft.framework.core.dao.hibernate.BaseDaoHibernate;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.orm.hibernate.HibernateCondition;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;

@Repository("OrdermanagerUserorderDao")
public class OrdermanagerUserorderDaoHibernate extends 
		BaseDaoHibernate<OrdermanagerUserorder, String> implements OrdermanagerUserorderDao{
	public Class<OrdermanagerUserorder> getModelClazz(){
		return OrdermanagerUserorder.class;
	}

	@Override
	public PagerRecords getPagerPend_query(final Pager pager,
			Collection<Condition> conditions,
			Collection<Order> orders) {
		final List<Object> params = new ArrayList<Object>();
		String condition = buildConditions(conditions,params);
		String order = buildOrder(orders);
		final String hql = "from PersonMember t where (t.videoStatus in ('00','01','03') or t.siteStatus in ('00','01', '03') ) " + condition + ("".equals(order)?" ":" order by ") + order;
		final String countHql = "select count(t.id)  from PersonMember t where (t.videoStatus in ('00','01','03') or t.siteStatus in ('00','01', '03') ) " + condition;
		
		return getHibernateTemplate().execute(new HibernateCallback<PagerRecords>(){
			public PagerRecords doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				Query countQuery = session.createQuery(countHql);
				for (int i = 0; i < params.size(); i++) { 
					query.setParameter(i, params.get(i));
					countQuery.setParameter(i, params.get(i));
				}
				int count = ((Long)countQuery.uniqueResult()).intValue();
				if(pager != null){
					query.setMaxResults(pager.getPageSize());
					query.setFirstResult(pager.getStartIndex());
					pager.setCounts(count);
				}
				PagerRecords result = new PagerRecords(query.list(), count);
				if(pager == null){
					result.setPager(new Pager(0, 0, 0));
				}
				else{
					result.setPager(pager);
				}
				return result;
			}});
	}
	
	private String buildOrder(Collection<Order> orders) {
		String result = "";
		for (Order order : orders) {
			if(result.length() > 0) result += ",";
			result += "t." + ((HibernateCondition) order).generateExpression();
		}
		return result;
	}
	
	private String buildConditions(Collection<Condition> conditions,
			List<Object> params) {
		String condition = "";
		for (Condition c : conditions) {
			if(condition.length() > 0) condition += " and ";
			condition += builderCondition(c,params);
		}
		if(condition.length() > 0) condition = " and " + condition; 
		
		return condition;
	}
	@SuppressWarnings("unchecked")
	private String builderCondition(Condition c, List<Object> params) {
		String condition = "t." + c.getProperty();
		
		if(c.getOperator().equals(Condition.EQUALS)){//
			condition += " = ?";
			params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.NOT_EQUALS)){//
			condition += " <> ?";
			params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.LIKE)){//
			condition += " like ?";
			params.add("%"+c.getValue()+"%");
		}else if(c.getOperator().equals(Condition.RIGHT)){//
			condition += " > ?";
			params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.LEFT)){//
				condition += " < ?";
				params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.RIGHT_EQ)){//
			condition += " >= ?";
			params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.LEFT_EQ)){//
				condition += " <= ?";
				params.add(c.getValue());
		}else if(c.getOperator().equals(Condition.IS_NOT_NULL)){//
			condition += " is not null ";	
		}else if(c.getOperator().equals(Condition.IS_NULL)){//
			condition += " is  null ";	
		}else if(c.getOperator().equals(Condition.END)){//
			condition += " like ?";
			params.add("%" + c.getValue());
		}else if(c.getOperator().equals(Condition.START)){//
			condition += " like ?";
			params.add(c.getValue() + "%");
		}else if(c.getOperator().equals(Condition.BETWEEN)){//
			String[] betweenArray = c.getValue().toString().split(Condition.BETWEEN_SPLIT);
			if(betweenArray.length >= 2){
				condition += " between ? and ?";
				params.add(betweenArray[0]);
				params.add(betweenArray[1]);
			}
		}else if(c.getOperator().equals(Condition.IN)){
			
			if(c.getValue() instanceof String[]){
				String values = "";
				for(String s : (String[])c.getValue()){
					values = values + ",'" + s + "'";
				}
				if("".equals(values)) return "";
				condition += " in ( "+ values.substring(1) + " )";
			}else{
				condition += " in ( "+ c.getValue() + " )";
			}
			
		}else if(c.getOperator().equals(Condition.NOT_IN)){
			
			if(c.getValue() instanceof String[]){
				String values = "";
				for(String s : (String[])c.getValue()){
					values = values + ",'" + s + "'";
				}
				if("".equals(values)) return "";
				condition += " not in ( "+ values.substring(1) + " )";
			}else{
				condition += " not in ( "+ c.getValue() + " )";
			}
			
		}else if(c.getOperator().equals(Condition.OR)){
			condition = "";
			if(c.getValue() instanceof Collection<?>){
				String conditions = "" ;
				for(Condition con : (Collection<Condition>)c.getValue()){
					conditions = conditions + " or " + builderCondition(con,params) ;
				}
				if(!"".equals(conditions)){
					condition = " (" + conditions.replaceFirst("or", "") + " ) ";
				}
			}
		}
		return condition;
	}
}