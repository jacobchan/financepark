/**
 * 代码声明
 */
package com.manage.EnterBusinessManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;

public interface EnterbusinessmanagerRzManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public EnterbusinessmanagerRz getEnterbusinessmanagerRz(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerEnterbusinessmanagerRzs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public EnterbusinessmanagerRz saveEnterbusinessmanagerRz(EnterbusinessmanagerRz o) throws BusException;

    /**
     * 删除对象
     */
    public void removeEnterbusinessmanagerRz(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterbusinessmanagerRzs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitEnterbusinessmanagerRz(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitEnterbusinessmanagerRz(String propertyName,Object value) throws BusException;
}
