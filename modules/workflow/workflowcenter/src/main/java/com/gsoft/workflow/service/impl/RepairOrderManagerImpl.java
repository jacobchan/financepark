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
import com.gsoft.workflow.dao.RepairOrderDao;
import com.gsoft.workflow.entity.RepairOrder;
import com.gsoft.workflow.service.RepairOrderManager;

@Service("repairOrderManager")
@Transactional
public class RepairOrderManagerImpl extends BaseManagerImpl implements
		RepairOrderManager {

	@Autowired
	private RepairOrderDao repairOrderDao;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<RepairOrder> getRepairOrders() throws BusException {
		return repairOrderDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<RepairOrder> getRepairOrders(
			@ConditionCollection(domainClazz = RepairOrder.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return repairOrderDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public RepairOrder getRepairOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		return repairOrderDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerRepairOrders(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = RepairOrder.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = repairOrderDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	// (pubConditions={@PubCondition(property="address",pubProperty="userId")})
	public RepairOrder saveRepairOrder(RepairOrder o) throws BusException {
		String RepairOrderId = o.getFlowId();
		boolean isUpdate = StringUtils.isNotEmpty(RepairOrderId);
		List<RepairOrder> list = this.getRepairOrders();// 得到所有的园区
		if (isUpdate) {// 修改

		} else {// 新增

		}
		return repairOrderDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeRepairOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		repairOrderDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeRepairOrders(@ServiceParam(name = "id") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeRepairOrder(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitRepairOrder(@ServiceParam(name = "id") String id)
			throws BusException {
		return repairOrderDao.exists(id);
	}

	public boolean exsitRepairOrder(String propertyName, Object value)
			throws BusException {
		return repairOrderDao.exists(propertyName, value);
	}

	/* ******************流程相关******************** */



}
