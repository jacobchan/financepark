/**
 * 代码声明
 */
package com.manage.EmployeeManager.service.impl;
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
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.dao.EnterpriseInvitationDao;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
@Service("enterpriseEmployeesManager")
@Transactional
public class EnterpriseEmployeesManagerImpl extends BaseManagerImpl implements EnterpriseEmployeesManager{
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	@Autowired
	private EnterpriseInvitationDao enterpriseInvitationDao;
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
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
	public EnterpriseEmployees acceptEnterpriseInvitation(@ServiceParam(name="rzId") String rzId, @ServiceParam(name="phone") String phone, @ServiceParam(name="code") String code) throws BusException{
		System.out.println("参数值"+rzId+","+phone+","+code);
		EnterpriseEmployees ems = new EnterpriseEmployees();
		String[] params = new String[]{"rzId","phone","code"};
		Object[] values = new Object[]{rzId,phone,code};
		List<EnterpriseInvitation> invitationList = enterpriseInvitationDao.getList(params, values);
		System.out.println(invitationList.size());
		return ems;
	}
}
