/**
 * 代码声明
 */
package com.member.hotel.service.impl;

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

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.member.hotel.entity.HotelOrderItem;
import com.member.hotel.dao.HotelOrderItemDao;
import com.member.hotel.service.HotelOrderItemManager;

@Service("hotelOrderItemManager")
@Transactional
public class HotelOrderItemManagerImpl extends BaseManagerImpl implements HotelOrderItemManager{
	@Autowired
	private HotelOrderItemDao hotelOrderItemDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<HotelOrderItem> getHotelOrderItems() throws BusException{
    	return hotelOrderItemDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<HotelOrderItem> getHotelOrderItems(
    	@ConditionCollection(domainClazz=HotelOrderItem.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return hotelOrderItemDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public HotelOrderItem getHotelOrderItem(@ServiceParam(name="itemId") String id)  throws BusException{
    	return hotelOrderItemDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerHotelOrderItems(Pager pager,//分页条件
			@ConditionCollection(domainClazz=HotelOrderItem.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = hotelOrderItemDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public HotelOrderItem saveHotelOrderItem(HotelOrderItem o) throws BusException{
//    	String hotelOrderItemId = o.getHotelOrderItemId();
//    	boolean isUpdate = StringUtils.isNotEmpty(hotelOrderItemId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return hotelOrderItemDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeHotelOrderItem(@ServiceParam(name="itemId") String id) throws BusException{
    	hotelOrderItemDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeHotelOrderItems(@ServiceParam(name="itemId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeHotelOrderItem(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitHotelOrderItem(@ServiceParam(name="itemId") String id)  throws BusException{
		return hotelOrderItemDao.exists(id);
	}
    
    public boolean exsitHotelOrderItem(String propertyName,Object value) throws BusException{
		return hotelOrderItemDao.exists(propertyName,value);
	}

}
