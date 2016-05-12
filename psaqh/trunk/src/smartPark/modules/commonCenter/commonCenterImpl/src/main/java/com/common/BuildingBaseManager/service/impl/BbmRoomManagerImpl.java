/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service.impl;

import java.util.ArrayList;
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
import com.gsoft.framework.util.ConditionUtils;
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
    
    
	
    @EsbServiceMapping
    public List<BbmRoom> getSaleBbmRooms() throws BusException{
    	List<BbmRoom> list = bbmRoomDao.getList("saleState", "0");
    	return list;
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
		orders.add(ConditionUtils.getOrder("bbmPark.parkName", true));
		orders.add(ConditionUtils.getOrder("bbmBuilding.buildingName", true));
		orders.add(ConditionUtils.getOrder("bbmBuilding.buildingNo", true));
		orders.add(ConditionUtils.getOrder("roomNo", true));
		PagerRecords pagerRecords = bbmRoomDao.findByPager(pager, conditions, orders);
		//@SuppressWarnings("unchecked")
		/*List<BbmRoom> rooms = pagerRecords.getRecords();
		for(BbmRoom room:rooms){
			String rzId = room.getRzId() ;

		
		
		}*/
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
    	String bbmRoomId = o.getRoomId();
    	boolean isUpdate = StringUtils.isNotEmpty(bbmRoomId);
    	
    	BbmFloor floor = o.getBbmFloor() ;//获取楼层对象，此时只包含一个楼层ID
    	String floorId = floor.getFloorId() ;//获取楼层ID
    	floor = bbmFloorManager.getBbmFloor(floorId) ;//获取楼层对象
    	BbmBuilding building = floor.getBbmBuilding() ;//获取楼栋对象
    	BbmPark park = building.getBbmPark() ;//获取园区对象
    	o.setBbmBuilding(building);
    	o.setBbmPark(park);
    	vilidateForRoomNo(floor,building,o.getRoomNo()) ;
    	int count = Integer.parseInt(floor.getFloorRoomCount()) ;//获取楼层单元的数量
    	List<BbmRoom> room = bbmFloorManager.getRoomByFloorId(floorId) ;//得到当前楼层下的所有room
    	if(isUpdate){//修改
    		for(int i=0;i<room.size();i++){
    			if(bbmRoomId.equals(room.get(i).getRoomId())){
    				
    			}else{
    				String buildingName = room.get(i).getBbmBuilding().getBuildingName() ;//楼栋名称
    				String floorNo = room.get(i).getBbmFloor().getFloorNo() ;//楼层编号
    				String roomNo = room.get(i).getRoomNo() ;//单元编号
    				if(building.getBuildingName().equals(buildingName) && floor.getFloorNo().equals(floorNo) && o.getRoomNo().equals(roomNo)){
    					throw new BusException("此楼栋的该楼层的该单元已存在！") ;
    				}
    			}
    		}
    		String roomAddress = getRoomAddress(park,building,floor,o) ;
        	o.setRoomAddress(roomAddress);
    		return bbmRoomDao.save(o);
    	}else{//新增
    		if(room.size() >= count){
    			throw new BusException("楼层单元已满！") ;
    		}
    		for(int i=0;i<room.size();i++){
    			String buildingName = room.get(i).getBbmBuilding().getBuildingName() ;//楼栋名称
    			String floorNo = room.get(i).getBbmFloor().getFloorNo() ;//楼层编号
    			String roomNo = room.get(i).getRoomNo() ;//单元编号
    			if(building.getBuildingName().equals(buildingName) && floor.getFloorNo().equals(floorNo) && o.getRoomNo().equals(roomNo)){
    				throw new BusException("此楼栋的该楼层的该单元已存在！") ;
    			}
    		}
    		String roomAddress = getRoomAddress(park,building,floor,o) ;
        	o.setRoomAddress(roomAddress);
        	o.setStatus("00");//默认为：00，未使用
        	return bbmRoomDao.save(o);
    	}
    }
    
    /**
     * 得到单元的详细地址
     * @param park
     * @param building
     * @param floor
     * @param o
     * @return
     */
    private String getRoomAddress(BbmPark park,BbmBuilding building,BbmFloor floor,BbmRoom o){
    	String parkAddress = park.getAddress() ;//园区地址
		String parkName = park.getParkName() ;//园区名字
    	String buildingNo = building.getBuildingNo() ;//楼栋编号
    	String floorNo = floor.getFloorNo() ;//楼层编号
    	String temp = floorNo.substring(0, floorNo.length()-1) ;
    	String roomNo = o.getRoomNo() ;//单元编号
    	String roomNoTemp = roomNo.substring(roomNo.lastIndexOf("-")+1) ;
    	String roomAddress = parkAddress+parkName+buildingNo+"栋"+temp+roomNoTemp+"室" ;//详细地址
    	return roomAddress ;
    }
    
    /**
     * 验证后台传过来的单元编号的格式！
     * @param floor
     * @param building
     * @param roomNo
     * @throws BusException
     */
    private void vilidateForRoomNo(BbmFloor floor,BbmBuilding building,String roomNo) throws BusException{
    	String buildingNo = building.getBuildingNo() ;
    	String floorNo = floor.getFloorNo() ;
    	String prefix = buildingNo + "-" + floorNo + "-" ;
    	String format = "([A-Za-z0-9]+)-([A-Za-z0-9]+)-([0-9]+)" ;//正则表达式，规定roomNo的格式为：字符-字符-字符，字符为英文或数字
    	if(roomNo.matches(format)){
    		String[] str = roomNo.split("-") ;
    		if(str.length == 3){
    			String temp = str[0]+"-"+str[1]+"-" ;
    			if(!prefix.equals(temp)){
    				throw new BusException("单元编号前缀必须为：楼栋编号-楼层编号-") ;
    			}else{
    				boolean flag = false ;
    				try{
    					int num = Integer.parseInt(str[2]) ;
    					if(num <= 0 || num > 12){
    						flag = true ;
    						throw new BusException("") ;
    					}
    				}catch(BusException be){
    					if(flag){
    						throw new BusException("单元编号后两位必须在01到12之间！") ;
    					}else{
    						throw new BusException("单元编号的后两位必须是数字！") ;
    					}
    				}
    			}
    		}else{
    			throw new BusException("单元编号格式不正确") ;
    		}
    	}else{
			throw new BusException("单元编号格式不正确") ;
		}
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
    
    /**
	 * 通过单元ID的到单元信息
	 * @param roomId
	 * @return
	 */
    @EsbServiceMapping
    public BbmRoom getRoomByRoomId(@ServiceParam(name="roomId") String roomId) {
    	return bbmRoomDao.get(roomId);
    }
    
    /**
	 * 通过企业ID获取单元信息
	 * @param rzId
	 * @return
	 */
    @EsbServiceMapping
    public String getRoomByRzId(@ServiceParam(name="rzId") String rzId) throws BusException{
    	StringBuffer resultJson = new StringBuffer();
		String json = "";
		
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Order> orders = new ArrayList<Order>();
		conditions.add(ConditionUtils.getCondition("rzId", Condition.EQUALS, rzId));
		List<BbmRoom> roomList = bbmRoomDao.commonQuery(conditions, orders);
		if(roomList.size()>0){
			for(int i=0; i<roomList.size(); i++){
				resultJson.append("{id:'" + roomList.get(i).getRoomId() + "', pId:'', name:'" + roomList.get(i).getRoomAddress() + "'},");
			}
			json = resultJson.substring(0, resultJson.length() - 1);
		}
		
		return json;
	}
    /**
	 * 通过企业ID获取单元列表
	 * @param rzId
	 * @return
	 */
    @Override
    @EsbServiceMapping
    public List<BbmRoom> getRoomListByRzId(@ServiceParam(name="rzId") String rzId) throws BusException{
		Collection<Condition> conditions = new ArrayList<Condition>();
		Collection<Order> orders = new ArrayList<Order>();
		conditions.add(ConditionUtils.getCondition("rzId", Condition.EQUALS, rzId));
		List<BbmRoom> roomList = bbmRoomDao.commonQuery(conditions, orders);
		return roomList;
	}
    
    /**
	 * 会议室占用单元时，设置单元状态
	 * @param roomId 单元ID
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public BbmRoom setMeetingRoomStatus(@ServiceParam(name="roomId") String roomId) throws BusException {
		if(StringUtils.isNotEmpty(roomId)){
			BbmRoom room = this.bbmRoomDao.get(roomId) ;
			room.setSaleState("03"); //销售状态为：无
			room.setStatus("01");//使用状态：01是会议室
			return this.bbmRoomDao.save(room) ;
		}
		return null;
	}
	
	/**
	 * 企业入驻占用单元时，设置单元状态
	 * @param roomId 单元ID
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public BbmRoom setEnterRoomStatus(@ServiceParam(name="rzId") String rzId,@ServiceParam(name="roomId") String roomId) throws BusException {
		if(StringUtils.isNotEmpty(roomId)){
			BbmRoom room = this.bbmRoomDao.get(roomId) ;
			room.setRzId(rzId);
			room.setSaleState("02"); //销售状态02为:已售已招
			room.setStatus("03");//使用状态：03是企业入驻
			return this.bbmRoomDao.save(room) ;
		}
		return null;
	}
	
	/**
	 * 创立方占用单元时，设置单元状态
	 * @param roomId 单元ID
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public BbmRoom setChuangRoomStatus(@ServiceParam(name="roomId") String roomId) throws BusException {
		if(StringUtils.isNotEmpty(roomId)){
			BbmRoom room = this.bbmRoomDao.get(roomId) ;
			room.setSaleState("03"); //销售状态为:无
			room.setStatus("02");//使用状态：02是创立方
			return this.bbmRoomDao.save(room) ;
		}
		return null;
	}
}
