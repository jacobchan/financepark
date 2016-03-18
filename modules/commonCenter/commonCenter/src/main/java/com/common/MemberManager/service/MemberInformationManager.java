/**
 * 代码声明
 */
package com.common.MemberManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.entity.TempDemo;
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
	 * @param passwd 密码
	 * @param mobile 手机号
	 * @throws BusException
	 */
	public MemberInformation saveReister(String passwd,String repasswd,String mobile) throws BusException;
	
	/**
	 * 判断手机号是否已经注册
	 * @param mobile 注册手机号
	 * @return
	 */
	public TempDemo exsitMobile(String mobile) ;
	  /**
		 * 获取用户基本信息
		 * @param user 登陆用户名
		 * @return
		 * @throws BusException
		 */
	public MemberInformation getMemberInformationByLoginUser(String userId) throws BusException;
	/**
	 * 修改密码
	 * @param password
	 * @param confirmPassword
	 * @param oldPassword
	 * @throws BusException
	 */
	public void doModifyPassword(String password,String confirmPassword,String oldPassword,String userId) throws BusException;
	/**
	 * 修改手机号码
	 * @param memberPhoneNumber
	 * @throws BusException
	 */
	public void updatePhoneNumber(MemberInformation o) throws BusException;
	
	/**
	 * 用户登录
	 * @param memberInformation 用户信息
	 * @throws BusException
	 */
	public MemberInformation userLogin(MemberInformation memberInformation) throws BusException;
}
