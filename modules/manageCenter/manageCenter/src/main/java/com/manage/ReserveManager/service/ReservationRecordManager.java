/**
 * 代码声明
 */
package com.manage.ReserveManager.service;

import java.util.Collection;
import java.util.List;

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.ReserveManager.entity.ReservationRecord;

public interface ReservationRecordManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ReservationRecord> getReservationRecords() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ReservationRecord> getReservationRecords(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ReservationRecord getReservationRecord(String id) throws BusException;
    
    /**
     * 查询企业规模代码集:companyScale
     */
	public List<Record> getRecordsByExtendValue(String recordType) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerReservationRecords(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ReservationRecord saveReservationRecord(ReservationRecord o) throws BusException;

    /**
     * 删除对象
     */
    public void removeReservationRecord(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeReservationRecords(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitReservationRecord(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitReservationRecord(String propertyName,Object value) throws BusException;
	/**
	 * 新增回访记录，预约由已授理状态变更为已到访或未到访状态
	 * @param o
	 * @return
	 * @throws BusException
	 */
	public ReservationRecord saveReternRecords(ReservationRecord o) throws BusException;
	
  /**
  * 根据预约类型查询不同的预约对象，比如：01众创空间：查询商品表基础信息；02虚拟空间查询单元表基础信息
  * @param recordType:预约类型
  * @return
  * @throws BusException
  */
    public List<com.gsoft.framework.core.dataobj.Record> getRecordsByRecordType(String recordType) throws BusException;
    /**
     *获取招商客服角色
     * @param o
     * @throws BusException
     */
    public List<com.gsoft.framework.core.dataobj.Record> getRoleSaleSer(String userId) throws BusException;
    
    /**
     * 授理预约记录，变更状态：已预约--->已授理
     * @param o
     * @throws BusException
     */
    public void changeReservationRecordByStatus(ReservationRecord o) throws BusException;
    
    /**
	 * 取消预约申请，将待受理状态变更为已取消
	 * @param propertyservicemanagerEntrec
     * @return 
	 * @throws BusException
	 */
	 public ReservationRecord cancelReservation(ReservationRecord o) throws BusException;
	/**
	 * 根据当前登录用户获取预约记录
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getReservationRecordsforpage(Pager pager,//分页条件    chenye
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,
			String userId) throws BusException;
	 /**
     * 根据众创空间下的商品类别下所有的商品 
     * @param genreCode=04:众创空间
     */
	public List<PurchasingmanagerCommodity> getCommodityByGenreType(String genreCode) throws BusException;
	 /**
   	 * 获取已完成订单的totalCount     chenye
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */		    
	public List<Record> getTotalCount(
		   			Collection<Condition> conditions)  throws BusException;
	/**
	 * 获取维修工角色
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public List<Record> getRoleRepairer(String userId) throws BusException;	 
}
