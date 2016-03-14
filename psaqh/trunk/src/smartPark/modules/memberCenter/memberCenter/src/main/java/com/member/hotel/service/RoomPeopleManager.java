/**
 * 代码声明
 */
package com.member.hotel.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.member.hotel.entity.RoomPeople;

public interface RoomPeopleManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<RoomPeople> getRoomPeoples() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<RoomPeople> getRoomPeoples(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public RoomPeople getRoomPeople(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerRoomPeoples(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public RoomPeople saveRoomPeople(RoomPeople o) throws BusException;

    /**
     * 删除对象
     */
    public void removeRoomPeople(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeRoomPeoples(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitRoomPeople(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitRoomPeople(String propertyName,Object value) throws BusException;
}
