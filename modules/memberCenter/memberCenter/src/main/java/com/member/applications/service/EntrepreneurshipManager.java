/**
 * 代码声明
 */
package com.member.applications.service;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.member.applications.entity.Entrepreneurship;

public interface EntrepreneurshipManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<Entrepreneurship> getEntrepreneurships() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<Entrepreneurship> getEntrepreneurships(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public Entrepreneurship getEntrepreneurship(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerEntrepreneurships(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException, ParseException;
    /**
     * 保存并返回对象
     */
    public Entrepreneurship saveEntrepreneurship(Entrepreneurship o) throws BusException;

    /**
     * 删除对象
     */
    public void removeEntrepreneurship(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEntrepreneurships(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitEntrepreneurship(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitEntrepreneurship(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据代码集查找项目类型
	 * @return
	 */
	public List<Record> getProjectType() throws BusException;
	
	/**
	 * 是否融资代码集查询(0:是;1:否)
	 * @return
	 */
	public List<Record> getBool() throws BusException;
	
	/**
	 * 导师类型代码集查询
	 * @return
	 */
	public List<Record> getTeacherType() throws BusException;
	
	/**
	 * 保存创业加速计划的申请
	 * @return
	 */
	public Entrepreneurship goSaveEntrepreneurship(Entrepreneurship o,String teacherTypeFlg)  throws BusException;
	
	/**
	 * 获取整个数据的totalCount
	 * @param conditions
	 */
	public List<Record> getTotalCount(Collection<Condition> conditions)  throws BusException;
	
	/**
     * 取消操作
     * @param id
     */
    public Entrepreneurship goCancel(@ServiceParam(name="id") String id) throws BusException;
}
