/**
 * 代码声明
 */
package com.common.purchasingManager.service;

import java.util.List;
import java.util.Collection;

import com.common.purchasingManager.entity.PurchasingmanagerGenreevaluate;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;


public interface PurchasingmanagerGenreevaluateManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PurchasingmanagerGenreevaluate> getPurchasingmanagerGenreevaluates() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PurchasingmanagerGenreevaluate> getPurchasingmanagerGenreevaluates(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PurchasingmanagerGenreevaluate getPurchasingmanagerGenreevaluate(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPurchasingmanagerGenreevaluates(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PurchasingmanagerGenreevaluate savePurchasingmanagerGenreevaluate(PurchasingmanagerGenreevaluate o) throws BusException;

    /**
     * 删除对象
     */
    public void removePurchasingmanagerGenreevaluate(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenreevaluates(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPurchasingmanagerGenreevaluate(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPurchasingmanagerGenreevaluate(String propertyName,Object value) throws BusException;
	/**
	 * 提交评论
	 * @param userId 用户ID
	 * @param overallSatisfaction 整体满意度
	 * @param reactionRate 反应速度
	 * @param serviceAttitude 服务态度
	 * @param costPerformance 性价比
	 * @param genreCode 商品类别编码
	 * @param evaluateContent 评论内容
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerGenreevaluate savePurGenreEvaluate(String userId,
			String overallSatisfaction, String reactionRate,
			String serviceAttitude, String costPerformance, String genreCode,
			String evaluateContent) throws BusException;
	/**
	 * 根据商品类别编码获取评论列表
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @param genreCode
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPurGenreEvaluatesByCode(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders,
			String genreCode) throws BusException;
	/**
	 * 提交咨询
	 * @param userId
	 * @param genreCode
	 * @param content
	 * @return
	 * @throws BusException
	 */
	public PurchasingmanagerGenreevaluate savePurGenreConsult(String userId,
			String genreCode, String content) throws BusException;
	/**
   	 * 前台个人中心  获取已完成订单的totalCount    chenye
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */
    public List<Record> getTotalCount(Collection<Condition> conditions)throws BusException;
    /**
  	 * 前台个人中心   根据当前用户分页查询    chenye
  	 * @param pager
  	 * @param conditions
  	 * @param orders
  	 * @return
  	 * @throws BusException
  	 */
  	public PagerRecords getPager(Pager pager,//分页条件
  			Collection<Condition> conditions,//查询条件
  			Collection<Order> orders)throws BusException;
}
