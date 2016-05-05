/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.Collection;
import java.util.List;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;

public interface PropertyservicemanagerFkcodeManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerFkcode getPropertyservicemanagerFkcode(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerFkcodes(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerFkcode savePropertyservicemanagerFkcode(PropertyservicemanagerFkcode o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerFkcode(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerFkcodes(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerFkcode(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerFkcode(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据访客申请ID得到会员名称
	 * @param fkcodeId 访客申请ID
	 * @return
	 */
	public MemberInformation getMemberByFkcodeId(String fkcodeId) ;
	
	/**
	 * 更新访客申请的申请状态
	 * @param fkcodeId 访客申请ID
	 * @param 标识符，00表示同意申请，01表示拒绝申请
	 */
	//public void updateFkcode(String fkcodeId,String code) ;
	/**
	 * 根据登录用户获取访客申请
	 * @param o 访客对象
	 * @return
	 * @throws BusException
	 */
	public List<PropertyservicemanagerFkcode> getFkcodeListforpage(PropertyservicemanagerFkcode o) throws BusException; 
	/**
	 * 前台取消访客
	 * @param fkcodeId
	 * @return
	 * @throws BusException
	 */
	public PropertyservicemanagerFkcode cancelStatus(String fkcodeId) throws BusException;
	/**
	 * 根据订单号模糊查询
	 * @param fkCode订单号
	 * @return userId当前用户id
	 * @throws BusException
	 */
    public List<PropertyservicemanagerFkcode> getFkcodelistLikeFkcodeCode(String userId,String fkCode,String startTime,String endTime) throws BusException;
	/**
	 * 根据当前用户分页查询 
	 * 模糊查询
	 * @return 分页对象
	 */
	public PagerRecords getPagerFk(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders,String startTime,String endTime) throws BusException;
	/**
	 * 获取已完成订单的totalCount    陈烨
	 * @param conditions
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusException
	 */
	public List<Record> getTotalCount(Collection<Condition> conditions,String startTime,String endTime)  throws BusException;
  /**
   	* 根据访客申请ID得到状态
   	* @param fkcodeId 访客申请ID
   	* @return
   	*/
    public PropertyservicemanagerFkcode getFkByFkcodeId(String fkcodeId)throws BusException;
}
