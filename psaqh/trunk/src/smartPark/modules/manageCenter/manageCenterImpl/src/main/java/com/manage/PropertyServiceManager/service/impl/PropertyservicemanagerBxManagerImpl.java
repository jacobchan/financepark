/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;

@Service("propertyservicemanagerBxManager")
@Transactional
public class PropertyservicemanagerBxManagerImpl extends BaseManagerImpl implements PropertyservicemanagerBxManager{
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs() throws BusException{
    	return propertyservicemanagerBxDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerBxDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerBx getPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
    	return propertyservicemanagerBxDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerBxs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerBxDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerBx savePropertyservicemanagerBx(PropertyservicemanagerBx o) throws BusException{
//    	String propertyservicemanagerBxId = o.getPropertyservicemanagerBxId();
//    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerBxId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	if(o.getBxStatus().equals("05")){
    		OrdermanagerUserorder order = new OrdermanagerUserorder();
			order.setUserorderAmount(o.getBxAmount());
			order.setUserorderCode("1111111");
			order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			order.setUserorderProject("物业报修");
			order.setBxId(o.getBxId());
			order.setUserorderBuyUser(o.getBxComp());
			ordermanagerUserorderDao.save(order);
    	}
    	return propertyservicemanagerBxDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerBx(@ServiceParam(name="bxId") String id) throws BusException{
    	propertyservicemanagerBxDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerBxs(@ServiceParam(name="bxId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerBx(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
		return propertyservicemanagerBxDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerBx(String propertyName,Object value) throws BusException{
		return propertyservicemanagerBxDao.exists(propertyName,value);
	}

    @EsbServiceMapping
	public void upBxbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(id);
    	String bxstatus = bx.getBxStatus();
    	if(code.equals("01")){//回绝报修
    		bx.setBxStatus("08");
    	}else{
    		if(bxstatus.equals("00")){//待受理-->已受理
    			bx.setBxStatus("01");
    		}else if(bxstatus.equals("06")){
    			bx.setBxStatus("07");//
    		}
    	}
    	propertyservicemanagerBxDao.save(bx);
	}

    
}
