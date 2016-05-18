/**
 * 代码声明
 */
package com.distribution.income.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.common.MemberManager.entity.MemberInformation;
import com.distribution.income.entity.SalesRec;

public interface SalesRecManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<SalesRec> getSalesRecs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<SalesRec> getSalesRecs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public SalesRec getSalesRec(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerSalesRecs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public SalesRec saveSalesRec(SalesRec o,String memPhone) throws BusException;

    /**
     * 删除对象
     */
    public void removeSalesRec(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSalesRecs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitSalesRec(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitSalesRec(String propertyName,Object value) throws BusException;
	
	/**
	 * 查询所有下级会员
	 * @return
	 */
	public List<MemberInformation> findNextMember(String memberId,String lev);
}
