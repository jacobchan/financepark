/**
 * 代码声明
 */
package com.member.hotel.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.member.hotel.entity.HotelOrder;
import com.member.hotel.dao.HotelOrderDao;
import com.member.hotel.service.HotelOrderManager;

@Service("hotelOrderManager")
@Transactional
public class HotelOrderManagerImpl extends BaseManagerImpl implements HotelOrderManager{
	@Autowired
	private HotelOrderDao hotelOrderDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<HotelOrder> getHotelOrders() throws BusException{
    	return hotelOrderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<HotelOrder> getHotelOrders(
    	@ConditionCollection(domainClazz=HotelOrder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return hotelOrderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public HotelOrder getHotelOrder(@ServiceParam(name="orderId") String id)  throws BusException{
    	return hotelOrderDao.get(id);
    }
	
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerHotelOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=HotelOrder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime)  throws BusException{
		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		}
		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.RIGHT_EQ,startTime));
		}
		if(StringUtils.isEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		}
	   	
		PagerRecords pagerRecords = hotelOrderDao.findByPager(pager, conditions, orders);
		List<HotelOrder> list = pagerRecords.getRecords();
		return pagerRecords;
	}
	/*
	 * 获取数据总条数
	 * totalCount
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
	   			@ConditionCollection(domainClazz=HotelOrder.class) Collection<Condition> conditions,
				@ServiceParam(name="startTime") String startTime,
				@ServiceParam(name="endTime") String endTime)  throws BusException{
	 	List<Record> recordList=new ArrayList<Record>();
	 	if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		}
		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.RIGHT_EQ,startTime));
		}
		if(StringUtils.isEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("orderTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		}
		List<HotelOrder> List = this.getHotelOrders(conditions, null);
	   	Record record = new Record();
	  	record.put("totalCount", List.size());
		recordList.add(record);
	   	return recordList;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public HotelOrder saveHotelOrder(HotelOrder o) throws BusException{
//    	String hotelOrderId = o.getHotelOrderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(hotelOrderId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return hotelOrderDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeHotelOrder(@ServiceParam(name="orderId") String id) throws BusException{
    	hotelOrderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeHotelOrders(@ServiceParam(name="orderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeHotelOrder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitHotelOrder(@ServiceParam(name="orderId") String id)  throws BusException{
		return hotelOrderDao.exists(id);
	}
    
    public boolean exsitHotelOrder(String propertyName,Object value) throws BusException{
		return hotelOrderDao.exists(propertyName,value);
	}

}
