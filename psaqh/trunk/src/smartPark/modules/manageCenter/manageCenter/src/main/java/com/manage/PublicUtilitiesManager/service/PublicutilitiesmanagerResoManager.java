/**
 * 代码声明
 */
package com.manage.PublicUtilitiesManager.service;

import java.util.List;
import java.util.Collection;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.manage.PublicUtilitiesManager.entity.PublicutilitiesmanagerReso;

public interface PublicutilitiesmanagerResoManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PublicutilitiesmanagerReso> getPublicutilitiesmanagerResos(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PublicutilitiesmanagerReso getPublicutilitiesmanagerReso(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPublicutilitiesmanagerResos(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PublicutilitiesmanagerReso savePublicutilitiesmanagerReso(PublicutilitiesmanagerReso o) throws BusException;

    /**
     * 删除对象
     */
    public void removePublicutilitiesmanagerReso(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePublicutilitiesmanagerResos(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPublicutilitiesmanagerReso(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPublicutilitiesmanagerReso(String propertyName,Object value) throws BusException;
	
	/**
	 * 查询园区商品类型为公用资源的商品
	 * @return
	 * @throws BusException
	 */
	public List<PurchasingmanagerCommodity> getCommoditysByPublicStatus() throws BusException;
	
	/**
     * 前台页面：用户预约公共资源,保存对象
     *  @param List<PublicutilitiesmanagerReso> o  公共资源列表
     */
	 public List<PublicutilitiesmanagerReso> savePublicutilitiesmanagerResoList(List<PublicutilitiesmanagerReso> o) throws BusException;
	 
	 public OrdermanagerUserorder savePublicResoOrder(OrdermanagerUserorder o,
				PurchasingmanagerCommodity commodity,
				List<PublicutilitiesmanagerReso> publicResoList) throws BusException;
}
