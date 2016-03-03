/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFxtdc;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerFxtdcDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerFxtdcManager;

@Service("propertyservicemanagerFxtdcManager")
@Transactional
public class PropertyservicemanagerFxtdcManagerImpl extends BaseManagerImpl implements PropertyservicemanagerFxtdcManager{
	@Autowired
	private PropertyservicemanagerFxtdcDao propertyservicemanagerFxtdcDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerFxtdc> getPropertyservicemanagerFxtdcs() throws BusException{
    	return propertyservicemanagerFxtdcDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerFxtdc> getPropertyservicemanagerFxtdcs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerFxtdc.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerFxtdcDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerFxtdc getPropertyservicemanagerFxtdc(@ServiceParam(name="fxtdcId") String id)  throws BusException{
    	return propertyservicemanagerFxtdcDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerFxtdcs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerFxtdc.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerFxtdcDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerFxtdc savePropertyservicemanagerFxtdc(PropertyservicemanagerFxtdc o) throws BusException{
//    	String propertyservicemanagerFxtdcId = o.getPropertyservicemanagerFxtdcId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerFxtdcId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerFxtdcDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerFxtdc(@ServiceParam(name="fxtdcId") String id) throws BusException{
    	propertyservicemanagerFxtdcDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerFxtdcs(@ServiceParam(name="fxtdcId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerFxtdc(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerFxtdc(@ServiceParam(name="fxtdcId") String id)  throws BusException{
		return propertyservicemanagerFxtdcDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerFxtdc(String propertyName,Object value) throws BusException{
		return propertyservicemanagerFxtdcDao.exists(propertyName,value);
	}
	@Override
	public PropertyservicemanagerFxtdc getFxtdcByMoverec(
			PropertyservicemanagerMoverec moverec) {
		PropertyservicemanagerFxtdc fxtdc = propertyservicemanagerFxtdcDao.getObjectByUniqueProperty("propertyservicemanagerMoverec", moverec) ;
		return fxtdc;
	}
	/**
	 * 通过二维码记录id改变二维码状态
	 * @param id
	 * @throws BusException
	 */
	@EsbServiceMapping
	public String upfxtdById(@ServiceParam(name="id") String id) throws BusException {
		String msg = "";
		PropertyservicemanagerFxtdc fxtdc = propertyservicemanagerFxtdcDao.get(id);
		//搬家申请有效时间
		String fxdate = fxtdc.getPropertyservicemanagerMoverec().getMoverecTime();
		String today = DateUtils.getToday("yyyy-MM-dd");
		if(fxdate.compareTo(today)>0){
			msg	=	"搬家申请时间为"+fxdate;
		}else if(fxdate.compareTo(today)<0){
			fxtdc.setFxtdcStatus("01");
			propertyservicemanagerFxtdcDao.save(fxtdc);
			msg	=	"二维码已过期!";
		}else{
			fxtdc.setFxtdcStatus("01");
			propertyservicemanagerFxtdcDao.save(fxtdc);
			msg	=	"扫描成功!";
		}
		return msg;
	}
	

}
