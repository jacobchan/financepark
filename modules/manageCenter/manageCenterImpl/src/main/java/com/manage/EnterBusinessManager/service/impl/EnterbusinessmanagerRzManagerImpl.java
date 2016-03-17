package com.manage.EnterBusinessManager.service.impl;
import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;
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
	@Autowired
	private EnterpriseRoleManager enterpriseRoleManager;
	@Autowired
	private BbmRoomManager bbmRoomManager;
	
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
    public EnterbusinessmanagerRz saveEnterbusinessmanagerRz(EnterbusinessmanagerRz o,@ServiceParam(name="roomId") String roomId) throws BusException{
    	String enterbusinessmanagerRzId = o.getRzId();
    	boolean isUpdate = StringUtils.isNotEmpty(enterbusinessmanagerRzId);
    	if(isUpdate){//修改
    		if(StringUtils.isNotEmpty(roomId)){
    			BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(roomId);
    			o.setParkId(bbmRoom.getBbmPark().getParkId());
    			o.setBuildingId(bbmRoom.getBbmBuilding().getBuildingId());
    			o.setFloorId(bbmRoom.getBbmFloor().getFloorId());
    			
    			//更新单元基础信息企业
    			bbmRoom.setRzId(o.getRzId());
    			bbmRoomManager.saveBbmRoom(bbmRoom);
    		}
    	}else{//新增b
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd"));
    		o.setCreateUser("");
    	}
    	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd"));
    	o.setUpdateUser("");
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
    	PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(id);
    	//根据入驻办理预约记录表数据新增入驻信息基本数据
    	EnterbusinessmanagerRz enterbusinessmanagerRz=new EnterbusinessmanagerRz();
    	enterbusinessmanagerRz.setEntrecId(psme);
    	enterbusinessmanagerRz.setRzManager(psme.getMemberId());
    	EnterbusinessmanagerRz er=enterbusinessmanagerRzDao.save(enterbusinessmanagerRz);
    	//新增企业员工数据
    	EnterpriseEmployees enterpriseEmployees=new EnterpriseEmployees();
    	enterpriseEmployees.setRz(er);
    	enterpriseEmployees.setEmployeesTelephone(er.getRzTelephone());
    	enterpriseEmployees.setMember(er.getRzManager());
    	enterpriseEmployees=enterpriseEmployeesManager.saveEnterpriseEmployees(enterpriseEmployees);
    	//企业员工默认为管理员角色
    	EnterpriseRole enterpriseRole=new EnterpriseRole();
    	enterpriseRole.setEmployees(enterpriseEmployees);
    	enterpriseRole.setRole(new Role());
    	enterpriseRoleManager.saveEnterpriseRole(enterpriseRole);
	}
    
    @EsbServiceMapping
	public void updateEnteringStatus(@ServiceParam(name="rzId") String id) throws BusException {
    	EnterbusinessmanagerRz enterbusinessmanagerRz=enterbusinessmanagerRzDao.get(id);
		String buildingId=enterbusinessmanagerRz.getBuildingId();
		if(buildingId!=""&&buildingId!=null){
			PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(enterbusinessmanagerRz.getEntrecId().getEntrecId());
			psme.setEnterrecStatus("06");//更改状态为已入驻
			propertyservicemanagerEntrecManager.savePropertyservicemanagerEntrec(psme);
		}
	}
}