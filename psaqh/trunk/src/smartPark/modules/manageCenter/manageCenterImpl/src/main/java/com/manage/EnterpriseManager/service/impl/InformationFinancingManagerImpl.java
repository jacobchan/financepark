package com.manage.EnterpriseManager.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EnterpriseManager.entity.InformationFinancing;
import com.manage.EnterpriseManager.dao.InformationFinancingDao;
import com.manage.EnterpriseManager.service.InformationFinancingManager;
@Service("informationFinancingManager")
@Transactional
public class InformationFinancingManagerImpl extends BaseManagerImpl implements
		InformationFinancingManager {
	@Autowired
	private InformationFinancingDao informationFinancingDao;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<InformationFinancing> getInformationFinancings()
			throws BusException {
		return informationFinancingDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<InformationFinancing> getInformationFinancings(
			@ConditionCollection(domainClazz = InformationFinancing.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return informationFinancingDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public InformationFinancing getInformationFinancing(
			@ServiceParam(name = "financingId") String id) throws BusException {
		return informationFinancingDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerInformationFinancings(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = InformationFinancing.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = informationFinancingDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public InformationFinancing saveInformationFinancing(InformationFinancing o)
			throws BusException {
		// String informationFinancingId = o.getInformationFinancingId();
		// boolean isUpdate = StringUtils.isNotEmpty(informationFinancingId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		o.setCreateUser(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
		return informationFinancingDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeInformationFinancing(
			@ServiceParam(name = "financingId") String id) throws BusException {
		informationFinancingDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeInformationFinancings(
			@ServiceParam(name = "financingId") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeInformationFinancing(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitInformationFinancing(
			@ServiceParam(name = "financingId") String id) throws BusException {
		return informationFinancingDao.exists(id);
	}

	public boolean exsitInformationFinancing(String propertyName, Object value)
			throws BusException {
		return informationFinancingDao.exists(propertyName, value);
	}

	/**
	 * 根据企业id查询融资信息
	 * @param financingRe 入驻企业id
	 * @return 符合条件的融资对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-18
	 */
	@EsbServiceMapping
	public List<InformationFinancing> findInformationFinancing(
			@ServiceParam(name = "financingRe") String financingRe)
			throws BusException {
		Collection<Condition> condition = new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("financingRe",
				Condition.EQUALS, financingRe));
		order.add(ConditionUtils.getOrder("createTime", true));
		List<InformationFinancing> list = informationFinancingDao
				.commonQuery(condition, order);
		return list;
	}
}