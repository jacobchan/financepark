/**
 * 代码声明
 */
package com.common.BuildingBaseManager.service;

import java.util.List;
import java.util.Collection;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;

public interface BbmParkManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<BbmPark> getBbmParks() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<BbmPark> getBbmParks(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public BbmPark getBbmPark(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerBbmParks(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public BbmPark saveBbmPark(BbmPark o) throws BusException;

    /**
     * 删除对象
     */
    public void removeBbmPark(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmParks(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitBbmPark(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitBbmPark(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据园区名称查询
	 * @param parkName 园区名称
	 * @return
	 */
	public BbmPark getBbmParkByParkName(String parkName) ;
	
	/**
	 * 根据园区名称得到楼栋及相应的楼层
	 * @param parkName 园区名称
	 * @return
	 */
	public JSONArray getBuildingAndFloorByParkName(String parkName) ;
}
