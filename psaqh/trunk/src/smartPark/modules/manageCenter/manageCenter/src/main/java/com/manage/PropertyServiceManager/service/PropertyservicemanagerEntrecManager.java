/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;

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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.ReserveManager.entity.ReservationRecord;

public interface PropertyservicemanagerEntrecManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerEntrec getPropertyservicemanagerEntrec(String id) throws BusException;
    
	/**
	 * 个人中心分页查询我的入驻申请预约
	 * @return
	 */
    public PagerRecords getPropertyservicemanagerEntrecsForReserve(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
		    Collection<Order> orders,String userId)  throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerEntrecs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerEntrec savePropertyservicemanagerEntrec(PropertyservicemanagerEntrec o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerEntrec(String id) throws BusException;
    
    /**
     *入驻申请添加
     */
    public void enterApplication(PropertyservicemanagerEntrec propertyservicemanagerEntrec) throws BusException;
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEntrecs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerEntrec(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerEntrec(String propertyName,Object value) throws BusException;
    /**
     * 取消预约申请，将待受理状态变更为已取消
     * @param propertyservicemanagerEntrec
     * @return 
     * @throws BusException
     */
    public PropertyservicemanagerEntrec cancelReservation(PropertyservicemanagerEntrec o) throws BusException;
    
    /**
	 * 修改入驻服务申请时，判断预约记录Id是否变更
	 *  @param o:入驻申请服务实体
	 *  @param before:变更前可办理预约记录
	 *  @param after:变更后可办理预约记录
	 * */
	public PropertyservicemanagerEntrec entringIdChange(PropertyservicemanagerEntrec o,PropertyservicemanagerEntering before,PropertyservicemanagerEntering after) throws BusException;
	/**
	 *前台 根据当前用户分页查询
	 * @return 分页对象
	 */
	public PagerRecords getPager(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
}
