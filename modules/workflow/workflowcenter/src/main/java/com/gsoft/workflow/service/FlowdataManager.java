package com.gsoft.workflow.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.workflow.entity.Flowdata;

public interface FlowdataManager extends BaseManager{


    /**
     * 查询列表
     */
    public List<Flowdata> getFlowdatas() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<Flowdata> getFlowdatas(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public Flowdata getFlowdata(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerFlowdatas(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public Flowdata saveFlowdata(Flowdata o) throws BusException;

    /**
     * 删除对象
     */
    public void removeFlowdata(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFlowdatas(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitFlowdata(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitFlowdata(String propertyName,Object value) throws BusException;
	
}
