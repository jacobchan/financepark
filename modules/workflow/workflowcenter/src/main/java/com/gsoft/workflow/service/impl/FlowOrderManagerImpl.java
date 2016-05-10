package com.gsoft.workflow.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.workflow.dao.FlowOrderDao;
import com.gsoft.workflow.entity.FlowOrder;
import com.gsoft.workflow.service.FlowOrderManager;

@Service("flowOrderManager")
@Transactional
public class FlowOrderManagerImpl extends BaseManagerImpl implements
		FlowOrderManager {

	@Autowired
	private FlowOrderDao flowOrderDao;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<FlowOrder> getFlowOrders() throws BusException {
		return flowOrderDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<FlowOrder> getFlowOrders(
			@ConditionCollection(domainClazz = FlowOrder.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return flowOrderDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public FlowOrder getFlowOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		return flowOrderDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerFlowOrders(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = FlowOrder.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = flowOrderDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	// (pubConditions={@PubCondition(property="address",pubProperty="userId")})
	public FlowOrder saveFlowOrder(FlowOrder o) throws BusException {
		String FlowOrderId = o.getId();
		boolean isUpdate = StringUtils.isNotEmpty(FlowOrderId);
		List<FlowOrder> list = this.getFlowOrders();// 得到所有的园区
		if (isUpdate) {// 修改

		} else {// 新增

		}
		return flowOrderDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeFlowOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		flowOrderDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeFlowOrders(@ServiceParam(name = "id") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeFlowOrder(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitFlowOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		return flowOrderDao.exists(id);
	}

	public boolean exsitFlowOrder(String propertyName, Object value)
			throws BusException {
		return flowOrderDao.exists(propertyName, value);
	}

	/* ******************流程相关******************** */



}
