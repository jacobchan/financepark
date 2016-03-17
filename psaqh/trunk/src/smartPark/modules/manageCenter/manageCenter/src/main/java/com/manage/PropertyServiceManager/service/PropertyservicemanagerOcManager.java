/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service;

import java.util.List;
import java.util.Collection;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerOc;

public interface PropertyservicemanagerOcManager extends BaseManager{
	 /**
     * 修改一卡通预约状态
     */
		/*public void updateOcStatus(@ServiceParam(name="ocId") String id, @ServiceParam(name="ocStatus") String ocStatus)
				throws BusException;*/
		public void updateOcStatus(String id, String ocStatus) throws BusException;
 /*public void updateUserorderStatus(String id,String userorderStatus) throws BusException;*/
    /**
     * 查询列表
     */
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerOc getPropertyservicemanagerOc(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerOcs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerOc savePropertyservicemanagerOc(PropertyservicemanagerOc o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerOc(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerOcs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerOc(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerOc(String propertyName,Object value) throws BusException;
	/**
	 * 获取当前登录用户一卡通号码
	 */
	public List<PropertyservicemanagerOc> getPropertyservicemanagerOcListByLoginUser(PropertyservicemanagerOc o) throws BusException;
	/**
	 * 修改绑定状态 */
	public PropertyservicemanagerOc updateBindStatus(PropertyservicemanagerOc p) throws BusException;
	/**
	 * 增加绑定卡号
	 * @param ocNumber
	 * @param bindStatus
	 */
	public PropertyservicemanagerOc addBindOc(String ocNumber, String  bindStatus)throws BusException;
	/**
	 * 取消一卡通预约
	 * @param id
	 * @param ocStatus
	 * @throws BusException
	 */
	public PropertyservicemanagerOc cancleOcStatus(String id)throws BusException;
}
