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
import com.gsoft.workflow.dao.FlowdataDao;
import com.gsoft.workflow.entity.Flowdata;
import com.gsoft.workflow.service.FlowdataManager;

@Service("flowdataManager")
@Transactional
public class FlowdataManagerImpl extends BaseManagerImpl implements
		FlowdataManager {

	@Autowired
	private FlowdataDao flowdataDao;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<Flowdata> getFlowdatas() throws BusException {
		return flowdataDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<Flowdata> getFlowdatas(
			@ConditionCollection(domainClazz = Flowdata.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return flowdataDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public Flowdata getFlowdata(@ServiceParam(name = "id") String id)
			throws BusException {
		return flowdataDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerFlowdatas(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = Flowdata.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = flowdataDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	// (pubConditions={@PubCondition(property="address",pubProperty="userId")})
	public Flowdata saveFlowdata(Flowdata o) throws BusException {
		String FlowdataId = o.getId();
		boolean isUpdate = StringUtils.isNotEmpty(FlowdataId);
		List<Flowdata> list = this.getFlowdatas();// 得到所有的园区
		if (isUpdate) {// 修改

		} else {// 新增

		}
		return flowdataDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeFlowdata(@ServiceParam(name = "id") String id)
			throws BusException {
		flowdataDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeFlowdatas(@ServiceParam(name = "id") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeFlowdata(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitFlowdata(@ServiceParam(name = "id") String id)
			throws BusException {
		return flowdataDao.exists(id);
	}

	public boolean exsitFlowdata(String propertyName, Object value)
			throws BusException {
		return flowdataDao.exists(propertyName, value);
	}

	/* ******************流程相关******************** */



}
