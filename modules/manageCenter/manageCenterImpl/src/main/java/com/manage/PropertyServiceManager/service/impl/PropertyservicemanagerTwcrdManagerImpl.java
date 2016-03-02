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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTwcrd;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerTwcrdDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTwcrdManager;

@Service("propertyservicemanagerTwcrdManager")
@Transactional
public class PropertyservicemanagerTwcrdManagerImpl extends BaseManagerImpl implements PropertyservicemanagerTwcrdManager{
	@Autowired
	private PropertyservicemanagerTwcrdDao propertyservicemanagerTwcrdDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerTwcrd> getPropertyservicemanagerTwcrds() throws BusException{
    	return propertyservicemanagerTwcrdDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerTwcrd> getPropertyservicemanagerTwcrds(
    	@ConditionCollection(domainClazz=PropertyservicemanagerTwcrd.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerTwcrdDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerTwcrd getPropertyservicemanagerTwcrd(@ServiceParam(name="twcrdId") String id)  throws BusException{
    	return propertyservicemanagerTwcrdDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerTwcrds(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerTwcrd.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerTwcrdDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerTwcrd savePropertyservicemanagerTwcrd(PropertyservicemanagerTwcrd o) throws BusException{
//    	String propertyservicemanagerTwcrdId = o.getPropertyservicemanagerTwcrdId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerTwcrdId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return propertyservicemanagerTwcrdDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerTwcrd(@ServiceParam(name="twcrdId") String id) throws BusException{
    	propertyservicemanagerTwcrdDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerTwcrds(@ServiceParam(name="twcrdId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerTwcrd(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerTwcrd(@ServiceParam(name="twcrdId") String id)  throws BusException{
		return propertyservicemanagerTwcrdDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerTwcrd(String propertyName,Object value) throws BusException{
		return propertyservicemanagerTwcrdDao.exists(propertyName,value);
	}
    
    /**
	 * 通过访客申请找到对应的二维码
	 * @param fkcode 访客申请对象
	 * @return
	 */
	@Override
	@EsbServiceMapping
	public PropertyservicemanagerTwcrd findTwcrdByFkcode(
			@ServiceParam(name="fkcode")PropertyservicemanagerFkcode fkcode) {
		PropertyservicemanagerTwcrd twcrd = propertyservicemanagerTwcrdDao.getObjectByUniqueProperty("propertyservicemanagerFkcode", fkcode) ;
		return twcrd;
	}
	
	/**
	 * 根据二维码ID更新二维码状态
	 * @param twcrdId 二维码id
	 */
	@Override
	@EsbServiceMapping
	public void updateTwcrd(@ServiceParam(name="twcrdId")String twcrdId) {
		if(StringUtils.isNotEmpty(twcrdId)){
			PropertyservicemanagerTwcrd twcrd = propertyservicemanagerTwcrdDao.get(twcrdId) ;
			twcrd.setStatus("01");//将二维码状态设置为已失效
			propertyservicemanagerTwcrdDao.save(twcrd) ;
		}
	}
}
