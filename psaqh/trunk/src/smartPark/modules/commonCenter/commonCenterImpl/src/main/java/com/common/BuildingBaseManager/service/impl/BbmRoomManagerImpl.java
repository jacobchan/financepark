/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service.impl;

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
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.dao.BbmRoomDao;
import com.common.BuildingBaseManager.service.BbmRoomManager;

@Service("bbmRoomManager")
@Transactional
public class BbmRoomManagerImpl extends BaseManagerImpl implements BbmRoomManager{
	@Autowired
	private BbmRoomDao bbmRoomDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BbmRoom> getBbmRooms() throws BusException{
    	return bbmRoomDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BbmRoom> getBbmRooms(
    	@ConditionCollection(domainClazz=BbmRoom.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return bbmRoomDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BbmRoom getBbmRoom(@ServiceParam(name="roomId") String id)  throws BusException{
//    	return bbmRoomDao.get(id);
    	return bbmRoomDao.getInitializeObject(id, new String[]{"bbmPark","bbmBuilding","bbmFloor"});
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBbmRooms(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BbmRoom.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = bbmRoomDao.findByPager(pager, conditions, orders);
		List<BbmRoom> rooms = pagerRecords.getRecords();
		for(BbmRoom room:rooms){
			BbmPark park = room.getBbmPark();
			room.setParkName(park.getParkName());
			BbmBuilding building = room.getBbmBuilding();
			room.setBuildingName(building.getBuildingCaption());
			BbmFloor floor = room.getBbmFloor();
			room.setFloorName(floor.getFloorCaption());
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public BbmRoom saveBbmRoom(BbmRoom o) throws BusException{
//    	String bbmRoomId = o.getBbmRoomId();
//    	boolean isUpdate = StringUtils.isNotEmpty(bbmRoomId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return bbmRoomDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBbmRoom(@ServiceParam(name="roomId") String id) throws BusException{
    	bbmRoomDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmRooms(@ServiceParam(name="roomId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBbmRoom(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBbmRoom(@ServiceParam(name="roomId") String id)  throws BusException{
		return bbmRoomDao.exists(id);
	}
    
    public boolean exsitBbmRoom(String propertyName,Object value) throws BusException{
		return bbmRoomDao.exists(propertyName,value);
	}

}
