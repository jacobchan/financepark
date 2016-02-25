/**
 * 代码声明
 */
package com.manage.EmployeeManager.service.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Collection;

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
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.dao.EnterpriseInvitationDao;
import com.manage.EmployeeManager.dao.EnterpriseRoleDao;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
@Service("enterpriseEmployeesManager")
@Transactional
public class EnterpriseEmployeesManagerImpl extends BaseManagerImpl implements EnterpriseEmployeesManager{
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	@Autowired
	private EnterpriseInvitationDao enterpriseInvitationDao;
	@Autowired
	private EnterbusinessmanagerRzDao enterbusinessmanagerRzDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private EnterpriseRoleDao enterpriseRoleDao;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EnterpriseEmployees> getEnterpriseEmployeess() throws BusException{
    	return enterpriseEmployeesDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EnterpriseEmployees> getEnterpriseEmployeess(
    	@ConditionCollection(domainClazz=EnterpriseEmployees.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return enterpriseEmployeesDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EnterpriseEmployees getEnterpriseEmployees(@ServiceParam(name="employeesId") String id)  throws BusException{
    	return enterpriseEmployeesDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEnterpriseEmployeess(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EnterpriseEmployees.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = enterpriseEmployeesDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public EnterpriseEmployees saveEnterpriseEmployees(EnterpriseEmployees o) throws BusException{
//    	String enterpriseEmployeesId = o.getEnterpriseEmployeesId();
//    	boolean isUpdate = StringUtils.isNotEmpty(enterpriseEmployeesId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return enterpriseEmployeesDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEnterpriseEmployees(@ServiceParam(name="employeesId") String id) throws BusException{
    	enterpriseEmployeesDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterpriseEmployeess(@ServiceParam(name="employeesId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEnterpriseEmployees(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEnterpriseEmployees(@ServiceParam(name="employeesId") String id)  throws BusException{
		return enterpriseEmployeesDao.exists(id);
	}
    
    @EsbServiceMapping
    public boolean exsitEnterpriseEmployees(String propertyName,Object value) throws BusException{
		return enterpriseEmployeesDao.exists(propertyName,value);
	}
    
    /**
	 * 接受企业邀请成为员工
	 * @param rzId 企业id
	 * @param phone 会员电话
	 * @param code 邀请码
	 * @return String
	 * @throws BusException
	 * @author Zhuyl
	 */
    @EsbServiceMapping
	public String acceptEnterpriseInvitation(@ServiceParam(name="rzId") String rzId, @ServiceParam(name="phone") String phone, @ServiceParam(name="code") String code) throws BusException{
		String msg = "";
    	EnterpriseEmployees ems = new EnterpriseEmployees();
		EnterpriseRole role = new EnterpriseRole();
		//根据rzId获取入驻企业
		EnterbusinessmanagerRz rz = enterbusinessmanagerRzDao.get(rzId);
		//根据会员填写的手机号码查询此会员是否存在
		MemberInformation info = memberInformationDao.getObjectByUniqueProperty("memberPhoneNumber", phone);
		//标记填写的手机号码存在于会员表
		if(null!=info){
			//封装获取邀请记录的参数和值
			String[] params = new String[]{"enterbusinessmanagerRz.rzId","invitationTelephone","invitationCode"};
			Object[] values = new Object[]{rzId,phone,code};
			List<EnterpriseInvitation> invitationList = enterpriseInvitationDao.getList(params, values);
			//存在此邀请的情况下
			if(invitationList.size()>0){
				//查询此会员是否已存在
				String[] ams = new String[]{"rzId","employeesTelephone"};
				Object[] lus = new Object[]{rzId,phone};
				List<EnterpriseEmployees> employeeList = enterpriseEmployeesDao.getList(ams, lus);
				//标记此手机号码是否已成为企业员工
				if(employeeList.size()<=0){						
					ems.setEmployeesComId(rz);
					ems.setMemberId(rz.getRzManager());
					ems.setRzId(rzId);
					ems.setEmployeesName(info.getMemberName());
					ems.setEmployeesTelephone(phone);
					ems.setEmployeesDepartment("1");
//					enterpriseEmployeesDao.save(ems);
					
					//企业角色
					Timestamp createTime = new Timestamp(new Date().getTime());
					String[] roleparams = new String[]{"roleId","roleType"};
					Object[] rolevalues = new Object[]{"ROLE_USER","1"};
					List<Role> le = roleDao.getList(roleparams, rolevalues);
					role.setEmployees(ems);
					role.setRole(le.get(0));
					role.setCreateuser(info);
					role.setCreatetime(createTime);
					role.setUpdateuser(info);
					role.setUpdatetime(createTime);
					enterpriseRoleDao.save(role);
					
					msg = info.getMemberName()+"成功入驻企业"+rz.getRzMem();
				}else{
					msg = "已接受此邀请成为企业员工，请勿重复操作！";
				}
			}else{
				msg = "无此企业邀请信息！";
			}
		}else{
			msg = "手机号码不存在！";
		}
		return msg;
	}
}
