/**
 * 代码声明
 */
package com.common.PayManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.common.PayManager.entity.PaymanagerOrdrePayflow;

public interface PaymanagerOrdrePayflowManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PaymanagerOrdrePayflow> getPaymanagerOrdrePayflows() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PaymanagerOrdrePayflow> getPaymanagerOrdrePayflows(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PaymanagerOrdrePayflow getPaymanagerOrdrePayflow(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPaymanagerOrdrePayflows(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PaymanagerOrdrePayflow savePaymanagerOrdrePayflow(PaymanagerOrdrePayflow o) throws BusException;

    /**
     * 删除对象
     */
    public void removePaymanagerOrdrePayflow(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePaymanagerOrdrePayflows(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPaymanagerOrdrePayflow(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPaymanagerOrdrePayflow(String propertyName,Object value) throws BusException;
}
