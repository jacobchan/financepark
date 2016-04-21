/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;

public interface PropertyservicemanagerBxManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerBx getPropertyservicemanagerBx(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerBxs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerBx savePropertyservicemanagerBx(PropertyservicemanagerBx o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerBx(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerBxs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerBx(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerBx(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据id修改报修状态
	 * @param id 报修记录主键id
	 * @param code 判断流程是否标识
	 * @throws BusException
	 */
	public void upBxbyId(String id,String code) throws BusException;
	/**
	 * 根据当前登录用户获取报修单
	 * @param o 报修对象
	 * @return
	 * @throws BusException
	 */
	public List<PropertyservicemanagerBx> getBxListforpage(PropertyservicemanagerBx o) throws BusException;
	
	/**
	 * 根据报修代码集
	 * @param o 报修对象
	 * @return
	 * @throws BusException
	 */
	public List<Record> getBxcodemapforpage(PropertyservicemanagerBx o) throws BusException;
	/**
	 * 前台用户发起报修单更改
	 * @param bxId 报修单id
	 * @return
	 * @throws BusException
	 */
	public PropertyservicemanagerBx updateBxforpage(String bxId) throws BusException;
	
	/**
	 * //通过订单号获取当前用户的报修单  模糊查询
	 * @param bxCode订单号
	 * @return
	 * @throws BusException
	 */
	public List<PropertyservicemanagerBx> getEnterprisemaillistLikeBxCode(String userId,String bxCode,String startTime,String endTime) throws BusException;
	 /**
		 * 根据当前用户分页查询
		 * @return 分页对象
		 */
		public PagerRecords getPagerBxs(Pager pager,//分页条件
				Collection<Condition> conditions,//查询条件
				Collection<Order> orders) throws BusException;
		/**
		 * 根据当前用户分页查询 chenye
		 * 模糊查询
		 * @return 分页对象
		 */
		public PagerRecords getPagerLikeBx(Pager pager,//分页条件
				Collection<Condition> conditions,//查询条件
				Collection<Order> orders,String bxLikeCode,String startTime,String endTime) throws BusException;
		/**
		 * 获取已完成订单的totalCount    陈烨
		 * @param conditions
		 * @param fkLikeCode
		 * @param startTime
		 * @param endTime
		 * @return
		 * @throws BusException
		 */
		public List<Record> getTotalCount(
	   			Collection<Condition> conditions,
	   			String bxLikeCode,
				String startTime,
				String endTime)  throws BusException;
		
}
