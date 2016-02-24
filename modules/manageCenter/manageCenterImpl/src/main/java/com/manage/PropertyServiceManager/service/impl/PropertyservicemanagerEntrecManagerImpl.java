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
import com.gsoft.framework.util.StringUtils;
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
    	String propertyservicemanagerEnteringId =o.getPropertyservicemanagerEntering().getEnteringId();
    	String propertyservicemanagerEntreId =o.getEntrecId();
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerEntreId);
    	if(isUpdate){//修改
    		PropertyservicemanagerEntrec entrec=propertyservicemanagerEntrecDao.get(propertyservicemanagerEntreId);
    		String enteringId =entrec.getPropertyservicemanagerEntering().getEnteringId();
    		if(!enteringId.equals(propertyservicemanagerEnteringId)){//变更预约
    			
    			//修改后的
    			PropertyservicemanagerEntering enteringAfter=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
        		//修改可办理预约表中的剩余预约数量和已预约数量
        		if(enteringAfter.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
        			enteringAfter.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
        		}
        		enteringAfter.setEnteringRemain(String.valueOf(Integer.valueOf(enteringAfter.getEnteringRemain())-1));//剩余预约数量
        		enteringAfter.setEnteringAlre(String.valueOf(Integer.valueOf(enteringAfter.getEnteringAlre())+1));//已预约数量
        		propertyservicemanagerEnteringDao.save(enteringAfter);
        		
        		//修改前的
        		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(enteringId);
        		//修改可办理预约表中的剩余预约数量和已预约数量
        		if(enteringBefore.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
        			enteringBefore.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
        		}
        		enteringBefore.setEnteringRemain(String.valueOf(Integer.valueOf(enteringBefore.getEnteringRemain())+1));//剩余预约数量
        		enteringBefore.setEnteringAlre(String.valueOf(Integer.valueOf(enteringBefore.getEnteringAlre())-1));//已预约数量
        		propertyservicemanagerEnteringDao.save(enteringBefore);
        		
        		o.setPropertyservicemanagerEntering(enteringAfter);
    		}
    	}else{//新增

    		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
    		//修改可办理预约表中的剩余预约数量和已预约数量
    		if(enteringBefore.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
    			enteringBefore.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
    		}
    		enteringBefore.setEnteringRemain(String.valueOf(Integer.valueOf(enteringBefore.getEnteringRemain())-1));//剩余预约数量
    		enteringBefore.setEnteringAlre(String.valueOf(Integer.valueOf(enteringBefore.getEnteringAlre())+1));//已预约数量
    		propertyservicemanagerEnteringDao.save(enteringBefore);


    		AccountPrincipal account = SecurityUtils.getAccount();//当前登录用户
    		String userId = account.getLoginName();
    		MemberInformation memberInformation=null;
    		if(userId !=null){
    			memberInformation=memberInformationDao.getObjectByUniqueProperty("memberNickname", userId);
    		}
    		if(memberInformation != null){
    			o.setMemberId(memberInformation);
    		}
    		o.setPropertyservicemanagerEntering(enteringBefore);
    		o.setEnterrecStatus("01");//已预约
    	}
    	
		return propertyservicemanagerEntrecDao.save(o);
		
    }
    
    
	/**
	 * 已授理状态变更
	 * */
	@EsbServiceMapping
	public void enterApplication(PropertyservicemanagerEntrec propertyservicemanagerEntrec) throws BusException {
		PropertyservicemanagerEntrec p=new PropertyservicemanagerEntrec();
		if(propertyservicemanagerEntrec.getEntrecId() != null){
			p=propertyservicemanagerEntrecDao.get(propertyservicemanagerEntrec.getEntrecId());
		}
		p.setEnterrecStatus("02");//已授理
		PropertyservicemanagerEntrec entrec=propertyservicemanagerEntrecDao.save(p);
		if(entrec!=null && entrec.getEnterrecStatus().equals("02")){
			//若该预约可预约状态变更为已授理，则更新企业入驻信息基本数据和企业会员信息
			enterbusinessmanagerRzManager.saveEnterbusinessmanagerRzBasicData(entrec.getEntrecId());
			
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
