/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.ArrayList;
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
import com.manage.ReserveManager.entity.ReservationRecord;

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
//		List<PropertyservicemanagerEntrec> entrecNewList = new ArrayList<PropertyservicemanagerEntrec>();
//		for (Object obj : pagerRecords.getRecords()) {
//			PropertyservicemanagerEntrec entrec = (PropertyservicemanagerEntrec) obj;
//			
//			String enteringName=entrec.getEnteringName();
//			if (StringUtils.isNotEmpty(enteringName)) {
//				MemberInformation memberInformation=memberInformationDao.get(enteringName);
//				entrec.setEnteringName(memberInformation.getMemberName());
//			}
//			entrecNewList.add(entrec);
//		}
//		pagerRecords.setRecords(entrecNewList);
		
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
			PropertyservicemanagerEntering enteringAfter=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
    		PropertyservicemanagerEntrec entrec=propertyservicemanagerEntrecDao.get(propertyservicemanagerEntreId);
    		String enteringId =entrec.getPropertyservicemanagerEntering().getEnteringId();
    		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(enteringId);
    		//先前已经预约的申请，现修改后重新预约
    		if(!enteringId.equals(propertyservicemanagerEnteringId)){
    			
        		//修改可办理预约表中的剩余预约数量和已预约数量：修改后
        		if(enteringAfter.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
        			enteringAfter.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
        		}
        		enteringAfter.setEnteringRemain(String.valueOf(Integer.valueOf(enteringAfter.getEnteringRemain())-1));//剩余预约数量
        		enteringAfter.setEnteringAlre(String.valueOf(Integer.valueOf(enteringAfter.getEnteringAlre())+1));//已预约数量
        		propertyservicemanagerEnteringDao.save(enteringAfter);
        		
        		
        		//修改可办理预约表中的剩余预约数量和已预约数量：修改前
        		if(enteringBefore.getEnteringRemain().equals("1")){//判断可办理预约表中剩余预约数量是否还有值
        			enteringBefore.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满
        		}
        		enteringBefore.setEnteringRemain(String.valueOf(Integer.valueOf(enteringBefore.getEnteringRemain())+1));//剩余预约数量
        		enteringBefore.setEnteringAlre(String.valueOf(Integer.valueOf(enteringBefore.getEnteringAlre())-1));//已预约数量
        		propertyservicemanagerEnteringDao.save(enteringBefore);
        		
    		}
    		o.setPropertyservicemanagerEntering(enteringAfter);
    	}else{//新增

    		//修改可办理预约表中的剩余预约数量和已预约数量
    		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
    		
    		String enteringRemain=enteringBefore.getEnteringRemain();//剩余预约数量
    		String enteringAlre=enteringBefore.getEnteringAlre();//已预约数量
    		enteringBefore.setEnteringRemain(String.valueOf(Integer.valueOf(enteringRemain)-1));
    		enteringBefore.setEnteringAlre(String.valueOf(Integer.valueOf(enteringAlre)+1));
    		if(enteringBefore.getEnteringRemain().equals("1")){
    			enteringBefore.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满：02
    		}
    		propertyservicemanagerEnteringDao.save(enteringBefore);

    		//新增 入驻服务办理预约记录基础数据
    		MemberInformation memberInformation=null;
    		if(o.getEnteringName() !=null){
    			memberInformation=memberInformationDao.get(o.getEnteringName());
    		}
    		if(memberInformation != null){
    			o.setMemberId(memberInformation);
    		}
    		o.setPropertyservicemanagerEntering(enteringBefore);
    		o.setEnterrecStatus("01");//01：已预约
    	}
    	
		return propertyservicemanagerEntrecDao.save(o);
		
    }
    
    
	/**
	 * 变更状态:已预约-->已授理
	 * */
	@EsbServiceMapping
	public void enterApplication(PropertyservicemanagerEntrec propertyservicemanagerEntrec) throws BusException {
		PropertyservicemanagerEntrec p=new PropertyservicemanagerEntrec();
		String entrecId=propertyservicemanagerEntrec.getEntrecId();
		if(StringUtils.isNotEmpty(entrecId)){
			p=propertyservicemanagerEntrecDao.get(entrecId);//根据主键查询入驻服务办理预约数据
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
    
    /**
	 * 取消预约申请，将待受理状态变更为已取消
	 * @param ReservationRecord
	 */
    @EsbServiceMapping
	 public void cancelReservation(PropertyservicemanagerEntrec o) throws BusException{
    	PropertyservicemanagerEntrec p=new PropertyservicemanagerEntrec();
		String entrecId=o.getEntrecId();
		if(StringUtils.isNotEmpty(entrecId)){
			p=propertyservicemanagerEntrecDao.get(entrecId);//根据主键查询入驻服务办理预约数据
		}
		p.setEnterrecStatus("04");//已取消
		propertyservicemanagerEntrecDao.save(p);
    }

}
