/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.SecurityUtils;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEnteringDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEntrecDao;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEntrecManager;

@Service("propertyservicemanagerEntrecManager")
@Transactional
public class PropertyservicemanagerEntrecManagerImpl extends BaseManagerImpl implements PropertyservicemanagerEntrecManager{
	@Autowired
	private PropertyservicemanagerEntrecDao propertyservicemanagerEntrecDao;
	
	@Autowired
	private MemberInformationDao memberInformationDao;
	
	@Autowired
	private PropertyservicemanagerEnteringDao propertyservicemanagerEnteringDao;
	
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs() throws BusException{
    	return propertyservicemanagerEntrecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerEntrecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntrec getPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
    	return propertyservicemanagerEntrecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerEntrecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerEntrecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntrec savePropertyservicemanagerEntrec(PropertyservicemanagerEntrec o) throws BusException{
//    	String propertyservicemanagerEntrecId = o.getPropertyservicemanagerEntrecId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerEntrecId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerEntrecDao.save(o);
    }
    
    
	/**
	 * 前台用户入驻申请,生成入驻服务预约记录表，并修改可办理预约表中的预约数量
	 * */
	@EsbServiceMapping
	public void enterApplication(PropertyservicemanagerEntrec propertyservicemanagerEntrec) throws BusException {
		AccountPrincipal account = SecurityUtils.getAccount();
		String userId = account.getLoginName();
		MemberInformation memberInformation=null;
		if(userId !=null){
			memberInformation=memberInformationDao.getObjectByUniqueProperty("memberNickname", userId);
		}
		if(memberInformation != null){
			propertyservicemanagerEntrec.setMemberId(memberInformation);
		}
		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(propertyservicemanagerEntrec.getPropertyservicemanagerEntering().getEnteringId());
		PropertyservicemanagerEntrec entrec=new PropertyservicemanagerEntrec();
		propertyservicemanagerEntrec.setPropertyservicemanagerEntering(enteringBefore);
		entrec=propertyservicemanagerEntrecDao.save(propertyservicemanagerEntrec);//生成入驻服务预约记录表
		if(entrec!=null && entrec.getEnterrecStatus().equals("02")){
			//若该预约可预约状态变更为已授理，则更新企业入驻信息基本数据和企业会员信息
			enterbusinessmanagerRzManager.saveEnterbusinessmanagerRzBasicData(entrec.getEntrecId());
			
		}else if(entrec!=null && entrec.getEnterrecStatus().equals("01")){
			//01：预约成功后，修改修改可办理预约表中的预约数量
			String enteringId=entrec.getPropertyservicemanagerEntering().getEnteringId();
			PropertyservicemanagerEntering entering=propertyservicemanagerEnteringDao.get(enteringId);
			if(entering.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
				entering.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
			}
			entering.setEnteringRemain(String.valueOf(Integer.valueOf(entering.getEnteringRemain())-1));//剩余预约数量
			entering.setEnteringAlre(String.valueOf(Integer.valueOf(entering.getEnteringAlre())+1));//已预约数量
			
			propertyservicemanagerEnteringDao.save(entering);
		}
		
		
	}

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id) throws BusException{
    	propertyservicemanagerEntrecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEntrecs(@ServiceParam(name="entrecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerEntrec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
		return propertyservicemanagerEntrecDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerEntrec(String propertyName,Object value) throws BusException{
		return propertyservicemanagerEntrecDao.exists(propertyName,value);
	}

}
