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
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.common.MemberManager.entity.MemberInformation;

public interface MemberInformationManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<MemberInformation> getMemberInformations() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<MemberInformation> getMemberInformations(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public MemberInformation getMemberInformation(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMemberInformations(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public MemberInformation saveMemberInformation(MemberInformation o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMemberInformation(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMemberInformations(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMemberInformation(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMemberInformation(String propertyName,Object value) throws BusException;
	
	/**
	 * 用户注册
	 * @param userName 用户名
	 * @param passwd 密码
	 * @param repasswd 重复密码
	 * @param mobile 手机号
	 * @throws BusException
	 */
	public void saveReister(String userName,String passwd,String repasswd,String mobile) throws BusException;
}
