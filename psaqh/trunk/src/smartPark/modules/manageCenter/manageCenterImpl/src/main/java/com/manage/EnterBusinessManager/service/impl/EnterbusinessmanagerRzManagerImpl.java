/**
 * 代码声明
 */
package com.manage.EnterBusinessManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEntrecManager;

@Service("enterbusinessmanagerRzManager")
@Transactional
public class EnterbusinessmanagerRzManagerImpl extends BaseManagerImpl implements EnterbusinessmanagerRzManager{
	@Autowired
	private EnterbusinessmanagerRzDao enterbusinessmanagerRzDao;
	@Autowired
	private PropertyservicemanagerEntrecManager propertyservicemanagerEntrecManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs() throws BusException{
    	return enterbusinessmanagerRzDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs(
    	@ConditionCollection(domainClazz=EnterbusinessmanagerRz.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return enterbusinessmanagerRzDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EnterbusinessmanagerRz getEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id)  throws BusException{
    	return enterbusinessmanagerRzDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEnterbusinessmanagerRzs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EnterbusinessmanagerRz.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = enterbusinessmanagerRzDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public EnterbusinessmanagerRz saveEnterbusinessmanagerRz(EnterbusinessmanagerRz o) throws BusException{
//    	String enterbusinessmanagerRzId = o.getEnterbusinessmanagerRzId();
//    	boolean isUpdate = StringUtils.isNotEmpty(enterbusinessmanagerRzId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return enterbusinessmanagerRzDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id) throws BusException{
    	enterbusinessmanagerRzDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterbusinessmanagerRzs(@ServiceParam(name="rzId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEnterbusinessmanagerRz(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id)  throws BusException{
		return enterbusinessmanagerRzDao.exists(id);
	}
    
    public boolean exsitEnterbusinessmanagerRz(String propertyName,Object value) throws BusException{
		return enterbusinessmanagerRzDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping
	public void saveEnterbusinessmanagerRzBasicData(@ServiceParam(name="entrecId") String id)
			throws BusException {
		// TODO Auto-generated method stub
    	PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(id);
    	//根据入驻办理预约记录表数据新增入驻信息基本数据
    	EnterbusinessmanagerRz enterbusinessmanagerRz=new EnterbusinessmanagerRz();
    	enterbusinessmanagerRz.setEntrecId(psme);
    	enterbusinessmanagerRz.setRzManager(psme.getMemberId());
    	EnterbusinessmanagerRz er=enterbusinessmanagerRzDao.save(enterbusinessmanagerRz);
    	//新增企业员工数据
    	EnterpriseEmployees enterpriseEmployees=new EnterpriseEmployees();
    	enterpriseEmployees.setEmployeesComId(er);
    	enterpriseEmployees.setEmployeesTelephone(er.getRzTelephone());
    	enterpriseEmployees.setMemberId(er.getRzManager());
    	enterpriseEmployeesManager.saveEnterpriseEmployees(enterpriseEmployees);
	}
    
    @EsbServiceMapping
	public void updateEnteringStatus(@ServiceParam(name="rzId") String id) throws BusException {
		// TODO Auto-generated method stub
    	EnterbusinessmanagerRz enterbusinessmanagerRz=enterbusinessmanagerRzDao.get(id);
		String buildingId=enterbusinessmanagerRz.getBuildingId();
		if(buildingId!=""&&buildingId!=null){
			PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(enterbusinessmanagerRz.getEntrecId().getEntrecId());
			psme.setEnteringStatus("");//更改状态
			propertyservicemanagerEntrecManager.savePropertyservicemanagerEntrec(psme);
		}
	}
}
