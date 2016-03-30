/**
 * 代码声明
 */
package com.common.purchasingManager.service;

import java.util.Collection;
import java.util.List;

import com.common.ExtentionAtrManager.entity.MeetingEntity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;

public interface PurchasingmanagerPublicManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys() throws BusException;
    
    
    
    /**
     * 根据主键查询广告位
     */
    public PurchasingmanagerCommodity getPurchasingmanagerCommodityLed(String id) throws BusException;
    
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerCommodity getPurchasingmanagerCommodity(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerCommoditys(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,String genreCode) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerCommodity savePurchasingmanagerCommodity(PurchasingmanagerCommodity o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerCommodity(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommoditys(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerCommodity(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerCommodity(String propertyName,Object value) throws BusException;
	
	  /**
     * 根据商品类型获取相应的商品信息
     *  @param genreId:商品类别
     */
    public List<PurchasingmanagerCommodity> getCommodityRecordsByRecordType(String genreId) throws BusException;
    
    /**
     * 根据商品类别ID获取相应的商品信息
     * @param genreId:商品类别ID
     */
    public List<PurchasingmanagerCommodity> getCommodityRecordsByGenreId(String genreId) throws BusException;
    /**
     * 获取工商变更类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getComChangeCommodityList(String userId) throws BusException;
    /**
     * 获取公司注册类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getComReisterCommodityList(String userId) throws BusException;
    /**
     * 获取代理记账类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getAgencyCommodityList(String userId) throws BusException;
    /**
     * 获取法律服务类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getLawSerCommodityList(String userId) throws BusException;
    /**
     * 获取商标专利类别的所有商品列表
     * @param userId
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodity> getChopPatentCommodityList(String userId) throws BusException;

    /**
     * 获取商品类别获取商品扩展属性
     * @param genreCode 商品类别编号
     * @return
     * @throws BusException
     */
    public List<PurchasingmanagerCommodityExtend> getPagerCommodityExtsByGenreId(
			String genreCode) throws BusException;

    /**
     *保存会议室及其会议室商品扩展属性
     * @param roomId 会议室地址
     * @param roomContain 会议室规模人数
     * @param roomType 会议室类型人数：视屏会议室，普通会议室
     * @param roomProjector 会议室投影仪：有 ，无
     * @param o 商品实体
     * @return
     * @throws BusException
     */
    public void saveCommodityAndPropertyForRoom(PurchasingmanagerCommodity o);
    
    /**
     *保存车辆及其车辆商品扩展属性
     * @param stalls 档位
     * @param seat 座位
     * @param licensePlate 车牌
     * @param o 商品实体
     * @return
     * @throws BusException
     */
    public void saveCommodityAndPropertyForCar(PurchasingmanagerCommodity o);
    
    /**
     *保存工位及其扩展属性
     * @param o 商品实体
     * @return
     * @throws BusException
     */
    public void saveCommodityAndPropertyForGw(PurchasingmanagerCommodity o) throws BusException;
    
    
    /**
     * 保存广告位及其车辆商品扩展属性
     * @param size 尺寸
     * @param unit 单位
     * @param loopType 轮播方式
     * @param o 商品实体
     * @throws BusException
     */
    public void saveCommodityAndPropertyForLed(PurchasingmanagerCommodity o) throws BusException;
    
    /**
     * 根据商品genreCode来获取商品类别
     * param genreCode 商品类别编号
     */
	public List<Record> getRecordsByGenreCode(String genreCode) throws BusException;
}
