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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTwcrd;

public interface PropertyservicemanagerTwcrdManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PropertyservicemanagerTwcrd> getPropertyservicemanagerTwcrds() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PropertyservicemanagerTwcrd> getPropertyservicemanagerTwcrds(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PropertyservicemanagerTwcrd getPropertyservicemanagerTwcrd(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPropertyservicemanagerTwcrds(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PropertyservicemanagerTwcrd savePropertyservicemanagerTwcrd(PropertyservicemanagerTwcrd o) throws BusException;

    /**
     * 删除对象
     */
    public void removePropertyservicemanagerTwcrd(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerTwcrds(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPropertyservicemanagerTwcrd(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPropertyservicemanagerTwcrd(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过访客申请找到对应的二维码
	 * @param fkcode 访客申请对象
	 * @return
	 */
	public PropertyservicemanagerTwcrd findTwcrdByFkcode(PropertyservicemanagerFkcode fkcode) ;
	
	/**
	 * 通过访客id找到对应的二维码
	 * @param fkId
	 * @return
	 */
	public PropertyservicemanagerTwcrd findTwcrdById(String fkcodeId) throws BusException;
	
	/**
	 * 根据二维码ID更新二维码状态
	 * @param twcrdId 二维码id
	 */
	public void updateTwcrd(String twcrdId) ;
	
	
}
