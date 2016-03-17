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
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.dao.BbmRoomDao;
import com.common.BuildingBaseManager.service.BbmFloorManager;
import com.common.BuildingBaseManager.service.BbmRoomManager;

@Service("bbmRoomManager")
@Transactional
public class BbmRoomManagerImpl extends BaseManagerImpl implements BbmRoomManager{
	@Autowired
	private BbmRoomDao bbmRoomDao;
	@Autowired
	private BbmFloorManager bbmFloorManager ;
	
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
		//@SuppressWarnings("unchecked")
//		List<BbmRoom> rooms = pagerRecords.getRecords();
//		for(BbmRoom room:rooms){
//			BbmPark park = room.getBbmPark();
//			if(park != null){
//				room.setParkName(park.getParkName());
//			}
//			BbmBuilding building = room.getBbmBuilding();
//			if(building != null){
//				room.setBuildingName(building.getBuildingCaption());
//			}
//			BbmFloor floor = room.getBbmFloor();
//			if(floor != null){
//				room.setFloorName(floor.getFloorCaption());
//			}
			
		//}
		//pagerRecords.setRecords(rooms);
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
    	BbmFloor floor = o.getBbmFloor() ;//获取楼层对象，此时只包含一个楼层ID
    	String floorId = floor.getFloorId() ;//获取楼层ID
    	floor = bbmFloorManager.getBbmFloor(floorId) ;//获取楼层对象
    	BbmBuilding building = floor.getBbmBuilding() ;//获取楼栋对象
    	BbmPark park = building.getBbmPark() ;//获取园区对象
    	String parkAddress = park.getAddress() ;//园区地址
    	String parkName = park.getParkName() ;//园区名字
    	String buildingNo = building.getBuildingNo() ;//楼栋编号
    	String floorNo = floor.getFloorNo() ;//楼层编号
    	String roomNo = o.getRoomNo() ;//单元编号
    	String roomAddress = parkAddress+" "+parkName+" "+buildingNo+" "+floorNo+" "+roomNo ;//详细地址
    	o.setBbmBuilding(building);
    	o.setBbmPark(park);
    	o.setRoomAddress(roomAddress);
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
    
    /**
	 * 通过楼层ID获取对应的楼栋信息
	 * @param FloorId 楼层ID
	 * @return
	 */
    @EsbServiceMapping
	@Override
	public BbmBuilding findBbmBuildingByFloorId(@ServiceParam(name="floorId") String floorId) {
    	if(! "".equals(floorId)){
    		BbmFloor floor = bbmFloorManager.getBbmFloor(floorId) ;
    		BbmBuilding building = floor.getBbmBuilding() ;
    		return building ;
    	}
		return null;
	}
    
    /**
	 * 通过单元ID获取对应的楼层信息
	 * @param roomId 单元ID
	 * @return
	 */
    @Override
    @EsbServiceMapping
    public BbmFloor findBbmFloorByRoomId(@ServiceParam(name="roomId") String roomId) {
    	if(StringUtils.isNotEmpty(roomId)){
    		BbmRoom room = bbmRoomDao.get(roomId) ;//通过单元ID获取单元对象
    		BbmFloor floor = room.getBbmFloor() ;//获取楼层对象
    		return floor ;
    	}
    	return null;
    }
}
