/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;
import java.util.Map;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.DomainCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;

public interface PropertyservicemanagerSerManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerSer> getPropertyservicemanagerSers(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerSer getPropertyservicemanagerSer(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerSers(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
	
	/**
	 * 根据派工id查询维修费用清单
	 * @param pager
	 * @param ts 派工对象
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPropertyservicemanagerSersByTs(Pager pager,//分页条件
			PropertyservicemanagerTs ts,
			Collection<Order> orders) throws BusException;
	
	/**
	 * 根据报修id查询维修费用清单
	 * @param pager
	 * @param bx 报修对象
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerPropertyservicemanagerSersByBx(Pager pager,//分页条件
			String id,
			Collection<Order> orders) throws BusException;
	
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerSer savePropertyservicemanagerSer(PropertyservicemanagerSer o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerSer(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerSers(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerSer(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerSer(String propertyName,Object value) throws BusException;
	/**
	 * 批量新增维修费用清单
	 * @param tsId 派工ID
	 * @param listSer 费用清单列表
	 */
	public void saveListSer(String tsId ,
			@DomainCollection(domainClazz=PropertyservicemanagerSer.class) List<PropertyservicemanagerSer> listSer);
	
	/**
	 *	APP--查询费用维修清单
	 * @param 报修单id
	 * @return
	 * @throws BusException
	 */
	public List<Map<String, Object>> getGroupSer (String id) throws BusException;
	 /**
     * 后台个人维修记录
     * @param userId
	 * @return
	 * @throws BusException
     */
    @EsbServiceMapping
    public PagerRecords getPropertySer(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,
			String userId) throws BusException;
}
