/**
 * 代码声明
 */
package com.manage.ReserveManager.service;

import java.util.List;
import java.util.Collection;

import org.apache.poi.hssf.record.Record;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
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
     * 授理预约记录，变更状态：已预约--->已授理
     * @param o
     * @throws BusException
     */
    public void changeReservationRecordByStatus(ReservationRecord o) throws BusException;
    
    /**
	 * 取消预约申请，将待受理状态变更为已取消
	 * @param propertyservicemanagerEntrec
	 * @throws BusException
	 */
	 public void cancelReservation(ReservationRecord o) throws BusException;
}
