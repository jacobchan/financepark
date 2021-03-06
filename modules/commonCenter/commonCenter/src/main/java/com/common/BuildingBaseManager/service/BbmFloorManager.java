/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;

public interface BbmFloorManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<BbmFloor> getBbmFloors() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<BbmFloor> getBbmFloors(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public BbmFloor getBbmFloor(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerBbmFloors(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public BbmFloor saveBbmFloor(BbmFloor o) throws BusException;

    /**
     * 删除对象
     */
    public void removeBbmFloor(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmFloors(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitBbmFloor(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitBbmFloor(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过楼栋ID获取园区
	 * @param buildingId 楼栋ID
	 * @return
	 * @throws BusException
	 */
	public BbmPark findBbmParkByBuildingId(String buildingId) throws BusException ;
	
	/**
	 * 通过楼栋ID得到楼层
	 * @param buildingId 楼栋ID
	 * @return
	 * @throws BusException
	 */
	public List<BbmFloor> getBbmFloorByBuildingId(String buildingId) throws BusException;
	
	/**
	 * 通过楼层Id获取该楼层所有的单元
	 * @param floorId
	 * @return
	 */
	public List<BbmRoom> getRoomByFloorId(String floorId) ;
	
	/**
	 * 通过楼层id得到相关信息
	 * @param floorId
	 * @return
	 */
	public String getInforByFloorId(String floorId) ;
	
	/**
	 * 通过楼层id得到楼层
	 * @param floorId 楼层id
	 * @return
	 */
	public BbmFloor getFloorByFloorId(String floorId) ;
}
