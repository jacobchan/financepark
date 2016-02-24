package com.manage.EmployeeManager.service.impl;
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
import com.manage.EmployeeManager.dao.EnterpriseRoleDao;
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;
@Service("enterpriseRoleManager")
@Transactional
public class EnterpriseRoleManagerImpl extends BaseManagerImpl implements
		EnterpriseRoleManager {
	@Autowired
	private EnterpriseRoleDao enterpriseRoleDao;

	@Override
	public List<EnterpriseRole> getEnterpriseRoles() throws BusException {
		return enterpriseRoleDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<EnterpriseRole> getEnterpriseRoles(
			@ConditionCollection(domainClazz = EnterpriseInvitation.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return enterpriseRoleDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public EnterpriseRole getEnterpriseRole(
			@ServiceParam(name = "invitationId") String id) throws BusException {
		return enterpriseRoleDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerEnterpriseRoles(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = EnterpriseRole.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = enterpriseRoleDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public EnterpriseRole saveEnterpriseRole(EnterpriseRole o)
			throws BusException {
		// String enterpriseInvitationId = o.getEnterpriseInvitationId();
		// boolean isUpdate = StringUtils.isNotEmpty(enterpriseInvitationId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		return enterpriseRoleDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeEnterpriseRole(
			@ServiceParam(name = "invitationId") String id) throws BusException {
		enterpriseRoleDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeEnterpriseRoles(
			@ServiceParam(name = "invitationId") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeEnterpriseRole(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitEnterpriseRole(
			@ServiceParam(name = "invitationId") String id) throws BusException {
		return enterpriseRoleDao.exists(id);
	}

	public boolean exsitEnterpriseRole(String propertyName, Object value)
			throws BusException {
		return enterpriseRoleDao.exists(propertyName, value);
	}
}