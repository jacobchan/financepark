package com.manage.EmployeeManager.service.impl;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.fuc.service.RoleManager;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.dao.EnterpriseRoleDao;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;
@Service("enterpriseRoleManager")
@Transactional
public class EnterpriseRoleManagerImpl extends BaseManagerImpl implements
		EnterpriseRoleManager {
	@Autowired
	private EnterpriseRoleDao enterpriseRoleDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	
	@Autowired
	private RoleManager roleManager;

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
			@ServiceParam(name = "rId") String id) throws BusException {
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
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
	public EnterpriseRole saveEnterpriseRole(EnterpriseRole o)
			throws BusException {
		EnterpriseEmployees es = enterpriseEmployeesDao.get(o.getEmployees().getEmployeesId());
		o.setEmployees(es);
		o.setRole(roleManager.getRole("ROLE_QY_ADMIN"));
		o.setCreateTime(new Timestamp(new Date().getTime()));
		o.setUpdateUser(o.getCreateUser());
		o.setUpdateTime(new Timestamp(new Date().getTime()));
		return enterpriseRoleDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeEnterpriseRole(@ServiceParam(name = "rId") String id)
			throws BusException {
		enterpriseRoleDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeEnterpriseRoles(@ServiceParam(name = "rId") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeEnterpriseRole(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitEnterpriseRole(@ServiceParam(name = "rId") String id)
			throws BusException {
		return enterpriseRoleDao.exists(id);
	}

	public boolean exsitEnterpriseRole(String propertyName, Object value)
			throws BusException {
		return enterpriseRoleDao.exists(propertyName, value);
	}

	/**
	 * 根据员工id
	 * 
	 * @param eId
	 *            员工id
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<EnterpriseRole> getEnterpriseRoleByEmployees(
			@ServiceParam(name = "eId") String eId) throws BusException {
		String[] keys = new String[] { "employees.employeesId" };
		Object[] objs = new Object[] { eId };
		List<EnterpriseRole> role = enterpriseRoleDao.getList(keys, objs);
		return role;
	}
}