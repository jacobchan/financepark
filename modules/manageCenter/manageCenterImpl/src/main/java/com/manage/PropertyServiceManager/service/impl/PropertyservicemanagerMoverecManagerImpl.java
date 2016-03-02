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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFxtdc;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerMoverecDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerFxtdcManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerMoverecManager;

@Service("propertyservicemanagerMoverecManager")
@Transactional
public class PropertyservicemanagerMoverecManagerImpl extends BaseManagerImpl implements PropertyservicemanagerMoverecManager{
	@Autowired
	private PropertyservicemanagerMoverecDao propertyservicemanagerMoverecDao;
	@Autowired
	private PropertyservicemanagerFxtdcManager propertyservicemanagerFxtdcManager ;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs() throws BusException{
    	return propertyservicemanagerMoverecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerMoverecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerMoverec getPropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id)  throws BusException{
    	return propertyservicemanagerMoverecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerMoverecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerMoverecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerMoverec savePropertyservicemanagerMoverec(PropertyservicemanagerMoverec o) throws BusException{
    	String enName = o.getMoverecComp() ;//得到搬家企业名称
    	if(StringUtils.isEmpty(enName)){
    		throw new BusException("非企业用户没有权限申请！") ;
    	}
    	    	
    	String propertyservicemanagerMoverecId = o.getMoverecId();//得到当前搬家申请的ID
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerMoverecId);//为空表示新增，不为空表示修改
    	PropertyservicemanagerMoverec rec = null ;
    	if(isUpdate){//修改
    		rec = propertyservicemanagerMoverecDao.save(o);
    	}else{//新增
    		rec = propertyservicemanagerMoverecDao.save(o);
        	PropertyservicemanagerFxtdc propertyservicemanagerFxtdc = new PropertyservicemanagerFxtdc() ;//
            propertyservicemanagerFxtdc.setPropertyservicemanagerMoverec(rec);
            propertyservicemanagerFxtdcManager.savePropertyservicemanagerFxtdc(propertyservicemanagerFxtdc);//将搬家申请对应到二维码中
    	}
    	return rec;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id) throws BusException{
    	//propertyservicemanagerFxtdcManager
    	PropertyservicemanagerMoverec moverec = propertyservicemanagerMoverecDao.get(id) ;//得到搬家申请记录
    	PropertyservicemanagerFxtdc fxtdc = propertyservicemanagerFxtdcManager.getFxtdcByMoverec(moverec) ;//得到搬家申请记录对应的二维码
    	propertyservicemanagerFxtdcManager.removePropertyservicemanagerFxtdc(fxtdc.getFxtdcId());//通过id删除对应的二维码
    	propertyservicemanagerMoverecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerMoverecs(@ServiceParam(name="moverecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerMoverec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id)  throws BusException{
		return propertyservicemanagerMoverecDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerMoverec(String propertyName,Object value) throws BusException{
		return propertyservicemanagerMoverecDao.exists(propertyName,value);
	}

}
