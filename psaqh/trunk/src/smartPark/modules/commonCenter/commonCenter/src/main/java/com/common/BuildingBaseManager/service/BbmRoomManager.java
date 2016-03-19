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
import com.common.BuildingBaseManager.entity.BbmRoom;

public interface BbmRoomManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<BbmRoom> getBbmRooms() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<BbmRoom> getBbmRooms(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public BbmRoom getBbmRoom(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerBbmRooms(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public BbmRoom saveBbmRoom(BbmRoom o) throws BusException;
    
    /**
     * 删除对象
     */
    public void removeBbmRoom(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmRooms(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitBbmRoom(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitBbmRoom(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过楼层ID获取对应的楼栋信息
	 * @param FloorId 楼层ID
	 * @return
	 */
	public BbmBuilding findBbmBuildingByFloorId(String floorId);
	
	/**
	 * 通过单元ID获取对应的楼层信息
	 * @param roomId 单元ID
	 * @return
	 */
	public BbmFloor findBbmFloorByRoomId(String roomId) ;
	
	/**
	 * 通过单元ID的到单元信息
	 * @param roomId
	 * @return
	 */
	public BbmRoom getRoomByRoomId(String roomId) ;
}
