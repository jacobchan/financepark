package com.manage.EmployeeManager.service;
import java.util.List;
import java.util.Collection;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
public interface EnterpriseEmployeesManager extends BaseManager {

	/**
	 * 查询列表
	 */
	public List<EnterpriseEmployees> getEnterpriseEmployeess()
			throws BusException;

	/**
	 * 条件查询列表
	 */
	public List<EnterpriseEmployees> getEnterpriseEmployeess(
			Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;

	/**
	 * 根据主键查询
	 */
	public EnterpriseEmployees getEnterpriseEmployees(String id)
			throws BusException;

	/**
	 * 分页查询用户
	 * 
	 * @return 分页对象
	 */
	public PagerRecords getPagerEnterpriseEmployeess(Pager pager,// 分页条件
			Collection<Condition> conditions,// 查询条件
			Collection<Order> orders) throws BusException;

	/**
	 * 保存并返回对象
	 */
	public EnterpriseEmployees saveEnterpriseEmployees(EnterpriseEmployees o)
			throws BusException;

	/**
	 * 删除对象
	 */
	public void removeEnterpriseEmployees(String id) throws BusException;

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeEnterpriseEmployeess(String[] ids) throws BusException;

	/**
	 * 主键是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitEnterpriseEmployees(String id) throws BusException;

	/**
	 * 属性值是否已经使用
	 * 
	 * @param ids
	 */
	public boolean exsitEnterpriseEmployees(String propertyName, Object value)
			throws BusException;

	/**
	 * 接受企业邀请成为员工
	 * 
	 * @param phone
	 *            会员电话
	 * @param code
	 *            邀请码
	 * @return String
	 * @throws BusException
	 * @author Zhuyl
	 */
	public Record acceptEnterpriseInvitation(MemberInformation member,
			String code) throws BusException;

	/**
	 * 通过会员查询对应的企业会员
	 * 
	 * @param member
	 * @return
	 * @throws BusException
	 */
	public EnterpriseEmployees getEnterpriseEmployeesByMember(
			MemberInformation member) throws BusException;

	/**
	 * 通过当前登录用户查询是否是企业员工
	 * 
	 * @param o
	 *            企业员工表实体
	 * @return
	 * @throws BusException
	 */
	public EnterpriseEmployees getEnterEmployforpage(EnterpriseEmployees o)
			throws BusException;

	/**
	 * 通过当前登录用户查询企业员工通讯录
	 * 
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public List<EnterpriseEmployees> getEnterprisemaillist(EnterpriseEmployees o)
			throws BusException;

	public List<EnterpriseEmployees> getEnterprisemaillistByName(String userId,
			String employeesName) throws BusException;
}
