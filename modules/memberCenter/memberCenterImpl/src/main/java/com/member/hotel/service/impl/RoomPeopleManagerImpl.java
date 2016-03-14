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

import com.member.hotel.entity.RoomPeople;
import com.member.hotel.dao.RoomPeopleDao;
import com.member.hotel.service.RoomPeopleManager;

@Service("roomPeopleManager")
@Transactional
public class RoomPeopleManagerImpl extends BaseManagerImpl implements RoomPeopleManager{
	@Autowired
	private RoomPeopleDao roomPeopleDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<RoomPeople> getRoomPeoples() throws BusException{
    	return roomPeopleDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<RoomPeople> getRoomPeoples(
    	@ConditionCollection(domainClazz=RoomPeople.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return roomPeopleDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public RoomPeople getRoomPeople(@ServiceParam(name="recId") String id)  throws BusException{
    	return roomPeopleDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerRoomPeoples(Pager pager,//分页条件
			@ConditionCollection(domainClazz=RoomPeople.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = roomPeopleDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public RoomPeople saveRoomPeople(RoomPeople o) throws BusException{
//    	String roomPeopleId = o.getRoomPeopleId();
//    	boolean isUpdate = StringUtils.isNotEmpty(roomPeopleId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return roomPeopleDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeRoomPeople(@ServiceParam(name="recId") String id) throws BusException{
    	roomPeopleDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeRoomPeoples(@ServiceParam(name="recId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeRoomPeople(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitRoomPeople(@ServiceParam(name="recId") String id)  throws BusException{
		return roomPeopleDao.exists(id);
	}
    
    public boolean exsitRoomPeople(String propertyName,Object value) throws BusException{
		return roomPeopleDao.exists(propertyName,value);
	}

}
