package com.manage.EmployeeManager.service;
import java.util.Collection;
import java.util.List;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.EmployeeManager.entity.EnterpriseRole;
public interface EnterpriseRoleManager extends BaseManager {
	/**
	 * 查询列表
	 */
	public List<EnterpriseRole> getEnterpriseRoles()
			throws BusException;

	/**
	 * 条件查询列表
	 */
	public List<EnterpriseRole> getEnterpriseRoles(
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;

	/**
	 * 根据主键查询
	 */
	public EnterpriseRole getEnterpriseRole(String id)
			throws BusException;
	
	/**
	 * 根据员工id
	 * @param eId 员工id
	 * @return
	 * @throws BusException
	 */
	public List<EnterpriseRole> getEnterpriseRoleByEmployees(String eId)
			throws BusException;

	/**
	 * 分页查询用户
	 * 
	 * @return 分页对象
	 */
	public PagerRecords getPagerEnterpriseRoles(Pager pager,// 分页条件
			Collection<Condition> conditions,// 查询条件
			Collection<Order> orders) throws BusException;

	/**
	 * 保存并返回对象
	 */
	public EnterpriseRole saveEnterpriseRole(EnterpriseRole o)
			throws BusException;

	/**
	 * 删除对象
	 */
	public void removeEnterpriseRole(String id) throws BusException;

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeEnterpriseRoles(String[] ids) throws BusException;

	/**
	 * 主键是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitEnterpriseRole(String id) throws BusException;

	/**
	 * 属性值是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitEnterpriseRole(String propertyName, Object value)
			throws BusException;
}
