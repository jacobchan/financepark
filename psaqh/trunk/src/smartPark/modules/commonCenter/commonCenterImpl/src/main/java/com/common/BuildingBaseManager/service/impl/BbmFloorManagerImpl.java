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
import com.common.BuildingBaseManager.dao.BbmFloorDao;
import com.common.BuildingBaseManager.service.BbmBuildingManager;
import com.common.BuildingBaseManager.service.BbmFloorManager;
import com.common.BuildingBaseManager.service.BbmRoomManager;

@Service("bbmFloorManager")
@Transactional
public class BbmFloorManagerImpl extends BaseManagerImpl implements BbmFloorManager{
	@Autowired
	private BbmFloorDao bbmFloorDao;
	@Autowired
	private BbmBuildingManager bbmBuildingManager ;
	@Autowired
	private BbmRoomManager bbmRoomManager ;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<BbmFloor> getBbmFloors() throws BusException{
    	return bbmFloorDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<BbmFloor> getBbmFloors(
    	@ConditionCollection(domainClazz=BbmFloor.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return bbmFloorDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public BbmFloor getBbmFloor(@ServiceParam(name="floorId") String id)  throws BusException{
//    	return bbmFloorDao.get(id);
    	return bbmFloorDao.getInitializeObject(id, new String[]{"bbmBuilding","bbmPark"});
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerBbmFloors(Pager pager,//分页条件
			@ConditionCollection(domainClazz=BbmFloor.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		orders.add(ConditionUtils.getOrder("bbmPark.parkName", true));
		orders.add(ConditionUtils.getOrder("bbmBuilding.buildingName", true));
		orders.add(ConditionUtils.getOrder("floorNo", true));
		PagerRecords pagerRecords = bbmFloorDao.findByPager(pager, conditions, orders);
//		List<BbmFloor> floors = pagerRecords.getRecords();
//		for(BbmFloor floor:floors){
//			BbmPark park = floor.getBbmPark();
//			floor.setParkName(park.getParkName());
//			BbmBuilding building = floor.getBbmBuilding();
//			floor.setBuildingName(building.getBuildingCaption());
//		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public BbmFloor saveBbmFloor(BbmFloor o) throws BusException{
    	String bbmFloorId = o.getFloorId();
    	boolean isUpdate = StringUtils.isNotEmpty(bbmFloorId);
    	BbmBuilding building = o.getBbmBuilding() ; //得到楼栋对象，此时楼栋对象里面只有ID
    	String buildingId = building.getBuildingId() ;//得到楼栋ID
    	building = bbmBuildingManager.getBbmBuilding(buildingId) ; //通过楼栋ID获取楼栋对象
    	BbmPark park = building.getBbmPark() ;//获取楼栋对象对应的园区信息
    	int size = Integer.parseInt(building.getAttributeFloorCount()) ;//获取楼层数量
    	List<BbmFloor> floor = this.getBbmFloorByBuildingId(buildingId) ;
    	if(isUpdate){//修改
    		for(int i=0;i<floor.size();i++){
    			if(bbmFloorId.equals(floor.get(i).getFloorId())){
    				
    			}else{
    				String buildingName = floor.get(i).getBbmBuilding().getBuildingName() ;
    				String floorNo = floor.get(i).getFloorNo() ;
    				if(building.getBuildingName().equals(buildingName) && o.getFloorNo().equals(floorNo)){
    					throw new BusException("此楼栋下的该楼层已存在！") ;
    				}
    			}
    		}
    		o.setBbmBuilding(building);
    		o.setBbmPark(park);//将园区信息set到楼层对象中
        	return bbmFloorDao.save(o);//保存楼层对象
    	}else{//新增
    		if(floor.size() >= size){
    			throw new BusException("该栋楼的楼层数量已经满了！") ;
    		}
    		for(int i=0;i<floor.size();i++){
    				String buildingName = floor.get(i).getBbmBuilding().getBuildingName() ;
    				String floorNo = floor.get(i).getFloorNo() ;
    				if(building.getBuildingName().equals(buildingName) && o.getFloorNo().equals(floorNo)){
    					throw new BusException("此楼栋下的该楼层已存在！") ;
    				}
    		}
    		o.setBbmBuilding(building);
    		o.setBbmPark(park);//将园区信息set到楼层对象中
        	return bbmFloorDao.save(o);//保存楼层对象
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeBbmFloor(@ServiceParam(name="floorId") String id) throws BusException{
    	bbmFloorDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmFloors(@ServiceParam(name="floorId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeBbmFloor(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitBbmFloor(@ServiceParam(name="floorId") String id)  throws BusException{
		return bbmFloorDao.exists(id);
	}
    
    public boolean exsitBbmFloor(String propertyName,Object value) throws BusException{
		return bbmFloorDao.exists(propertyName,value);
	}
    
    /**
	 * 通过楼栋ID获取园区
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public BbmPark findBbmParkByBuildingId(@ServiceParam(name="buildingId") String buildingId) throws BusException {
		if( ! "".equals(buildingId)){
			BbmBuilding building = bbmBuildingManager.getBbmBuilding(buildingId) ;//通过楼栋ID获取楼栋信息
			BbmPark park = building.getBbmPark() ;
			
			return park;
		}
		return null ;
	}
	/**
	 * 通过楼栋ID得到楼层
	 * @param buildingId 楼栋ID
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<BbmFloor> getBbmFloorByBuildingId(@ServiceParam(name="buildingId") String buildingId)
			throws BusException {
		List<BbmFloor> list = null ;
		if(StringUtils.isNotEmpty(buildingId)){
			Collection<Condition> condition =  new ArrayList<Condition>();
    		condition.add(ConditionUtils.getCondition("bbmBuilding.buildingId", Condition.EQUALS,buildingId));//创建查询条件
    		Collection<Order> orders = new ArrayList<Order>();
    		orders.add(ConditionUtils.getOrder("floorNo", true));
    		list = bbmFloorDao.commonQuery(condition, orders) ;
		}
		return list;
	}
	
	/**
	 * 通过楼层Id获取该楼层所有的单元
	 * @param floorId
	 * @return
	 */
	@EsbServiceMapping
	public List<BbmRoom> getRoomByFloorId(@ServiceParam(name="floorId") String floorId) {
		Collection<Condition> condition =  new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("bbmFloor.floorId", Condition.EQUALS,floorId));//创建查询条件
		List<BbmRoom> list = bbmRoomManager.getBbmRooms(condition, null) ;
		if(list != null){
			return list;
		}else{
			return new ArrayList<BbmRoom>() ;
		}
	}
	
	/**
	 * 通过楼层id得到相关信息
	 * @param floorId
	 * @return
	 */
	@EsbServiceMapping
	public String getInforByFloorId(@ServiceParam(name="floorId") String floorId) {
		BbmFloor floor = bbmFloorDao.get(floorId) ;//获取当前楼层
		BbmBuilding building = floor.getBbmBuilding() ;//获取楼层对应的楼栋
		String floorCount = building.getAttributeFloorCount() ;//获取楼层量
		String buildingName = building.getBuildingName() ;//得到楼栋编号
		String floorNo = floor.getFloorNo() ;
		String str = floorNo.substring(0, floorNo.length()-1) ;
		String infor = buildingName + "("+str+"/"+floorCount+")" ;
		return infor;
	}
	
	/**
	 * 通过楼层id得到楼层
	 * @param floorId 楼层id
	 * @return
	 */
	@EsbServiceMapping
	public BbmFloor getFloorByFloorId(@ServiceParam(name="floorId") String floorId) {
		return bbmFloorDao.get(floorId);
	}
}
