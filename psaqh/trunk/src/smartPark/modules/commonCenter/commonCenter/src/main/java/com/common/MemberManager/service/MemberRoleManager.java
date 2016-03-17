/**
 * 代码声明
 */
package com.common.MemberManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.common.MemberManager.entity.MemberRole;

public interface MemberRoleManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<MemberRole> getMemberRoles() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<MemberRole> getMemberRoles(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public MemberRole getMemberRole(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMemberRoles(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public MemberRole saveMemberRole(MemberRole o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMemberRole(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberRoles(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMemberRole(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMemberRole(String propertyName,Object value) throws BusException;
	
	/**
     * 获取用户所有角色ID
     * @param memberId 会员用户ID
     * @return 角色ID数组
     */
    public List<String> getRolesByMemberId(String memberId) throws BusException;
}
