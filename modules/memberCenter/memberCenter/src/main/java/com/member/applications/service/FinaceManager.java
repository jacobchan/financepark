/**
 * 代码声明
 */
package com.member.applications.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.member.applications.entity.Finace;

public interface FinaceManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<Finace> getFinaces() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<Finace> getFinaces(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public Finace getFinace(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerFinaces(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public Finace saveFinace(Finace o) throws BusException;

    /**
     * 删除对象
     */
    public void removeFinace(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFinaces(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitFinace(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitFinace(String propertyName,Object value) throws BusException;
	
	/**
   	 * 融资申请页面加载开始获取公司名称和主页地址
   	 * 根据登录信息里面的企业ID进行查找
   	 * @param userId
   	 * @return
   	 */
   	public List<Map<String,String>> getCompanyData(String userId)  throws BusException;
   	
	/**
	 * 融资申请
	 * @return
	 */
	public Finace goSaveFinace(Finace o)  throws BusException;
}
