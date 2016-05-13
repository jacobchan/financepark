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
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
import com.manage.EmployeeManager.dao.EnterpriseInvitationDao;
import com.manage.EmployeeManager.service.EnterpriseInvitationManager;
@Service("enterpriseInvitationManager")
@Transactional
public class EnterpriseInvitationManagerImpl extends BaseManagerImpl implements EnterpriseInvitationManager{
	@Autowired
	private EnterpriseInvitationDao enterpriseInvitationDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EnterpriseInvitation> getEnterpriseInvitations() throws BusException{
    	return enterpriseInvitationDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EnterpriseInvitation> getEnterpriseInvitations(
    	@ConditionCollection(domainClazz=EnterpriseInvitation.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return enterpriseInvitationDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EnterpriseInvitation getEnterpriseInvitation(@ServiceParam(name="invitationId") String id)  throws BusException{
    	return enterpriseInvitationDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEnterpriseInvitations(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EnterpriseInvitation.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = enterpriseInvitationDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
    public EnterpriseInvitation saveEnterpriseInvitation(EnterpriseInvitation o) throws BusException{
//    	String enterpriseInvitationId = o.getEnterpriseInvitationId();
//    	boolean isUpdate = StringUtils.isNotEmpty(enterpriseInvitationId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	o.setInvitationStatus(0);
    	o.setCreateTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	return enterpriseInvitationDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEnterpriseInvitation(@ServiceParam(name="invitationId") String id) throws BusException{
    	enterpriseInvitationDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterpriseInvitations(@ServiceParam(name="invitationId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEnterpriseInvitation(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEnterpriseInvitation(@ServiceParam(name="invitationId") String id)  throws BusException{
		return enterpriseInvitationDao.exists(id);
	}
    
    public boolean exsitEnterpriseInvitation(String propertyName,Object value) throws BusException{
		return enterpriseInvitationDao.exists(propertyName,value);
	}

}
