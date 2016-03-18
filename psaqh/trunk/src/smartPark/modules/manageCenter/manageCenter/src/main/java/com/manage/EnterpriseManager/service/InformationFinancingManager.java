/**
 * 代码声明
 */
package com.manage.EnterpriseManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.manage.EnterpriseManager.entity.InformationFinancing;

public interface InformationFinancingManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<InformationFinancing> getInformationFinancings() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<InformationFinancing> getInformationFinancings(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public InformationFinancing getInformationFinancing(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerInformationFinancings(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public InformationFinancing saveInformationFinancing(InformationFinancing o) throws BusException;

    /**
     * 删除对象
     */
    public void removeInformationFinancing(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationFinancings(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitInformationFinancing(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitInformationFinancing(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据企业id查询融资信息
	 * @param financingRe 入驻企业id
	 * @return 符合条件的融资对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-17
	 */
	@EsbServiceMapping
	public List<InformationFinancing> findInformationFinancing(
			@ServiceParam(name = "financingRe") String financingRe)
			throws BusException;
}
