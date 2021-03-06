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

public interface BbmBuildingManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<BbmBuilding> getBbmBuildings() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<BbmBuilding> getBbmBuildings(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public BbmBuilding getBbmBuilding(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerBbmBuildings(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public BbmBuilding saveBbmBuilding(BbmBuilding o) throws BusException;

    /**
     * 删除对象
     */
    public void removeBbmBuilding(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBbmBuildings(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitBbmBuilding(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitBbmBuilding(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过园区名称获取该园区所有的楼栋
	 * @param parkName 园区名称
	 * @return
	 */
	public List<BbmBuilding> getAllBuildingByParkName(String parkName) throws BusException;
	
	/**
	 * 通过园区ID获取该园区所有的楼栋
	 * @param parkId 园区ID
	 * @return
	 */
	public List<BbmBuilding> getAllBuildingByParkId(String parkId) throws BusException;
}
