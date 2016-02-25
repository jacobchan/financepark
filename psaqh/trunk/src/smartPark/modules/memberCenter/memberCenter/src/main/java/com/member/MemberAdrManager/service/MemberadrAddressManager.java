/**
 * 代码声明
 */
package com.member.MemberAdrManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.member.MemberAdrManager.entity.MemberadrAddress;

public interface MemberadrAddressManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<MemberadrAddress> getMemberadrAddresss() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<MemberadrAddress> getMemberadrAddresss(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public MemberadrAddress getMemberadrAddress(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMemberadrAddresss(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public MemberadrAddress saveMemberadrAddress(MemberadrAddress o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMemberadrAddress(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberadrAddresss(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMemberadrAddress(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMemberadrAddress(String propertyName,Object value) throws BusException;
	
	/**
     * 根据用户名获取地址信息
     * @param memberName 用户名
     */
	public MemberadrAddress getAddressByname(String memberName) throws BusException;
}
