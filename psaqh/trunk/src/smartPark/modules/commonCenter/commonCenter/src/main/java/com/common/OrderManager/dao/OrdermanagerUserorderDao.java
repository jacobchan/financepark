/**
 * 代码声明
 */
package com.common.OrderManager.dao;

import java.util.Collection;

import com.gsoft.framework.core.dao.Dao;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.common.OrderManager.entity.OrdermanagerUserorder;

public interface OrdermanagerUserorderDao extends Dao<OrdermanagerUserorder, String>  {

	public PagerRecords getPagerPend_query(Pager pager, Collection<Condition> conditions,
			Collection<Order> orders);
	
}