/**
 * 代码声明
 */
package com.common.MemberManager.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
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
	public TempDemo saveReister(String passwd,String repasswd,String mobile,String captcha) throws BusException;
	
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
	 * @return 
	 * @throws BusException
	 */
	public Record doModifyPassword(String password,String confirmPassword,String oldPassword,String userId) throws BusException;
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
	/**
	 * //获取当前用户公司员工的通讯录
	 * @param userId
	 * @return
	 * @throws BusException
	 */
		 
	public List<MemberInformation> getPhoneNumberlist(String userId) throws BusException;
		 /**
		  * //通过名字获取当前用户公司员工的通讯录
		  * @param userId
		  * @param memberName
		  * @return
		  * @throws BusException
		  */
		
	 public List<MemberInformation> getPhoneNumberlistByName(String userId, String memberName) throws BusException;
	 /**
	  *前台 根据当前用户分页查询
	  * @return 分页对象
	  */
	 public PagerRecords getPager(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders, String userId) throws BusException;
	 /**
	   *  个人中心-个人资料（修改）
	   * @param o
	   * @return
	   * @throws BusException	   */				    
    
     public MemberInformation updateMemberInformation(MemberInformation o) throws BusException;
     /**
      * 根据手机号码获取用户
      * @param phone
      * @return
      */
	 public MemberInformation getUserByPhone(String phone);
	
	 /**根据角色查询会员信息
	 * @param role
	 * @return
	 * @throws BusException
	 */
	public List<MemberInformation> getMembersByRole(String role)throws BusException;
	/**
	 * 获取企业商城的加密数据信息
	 * @param userId
	 * @return
	 * @throws BusException
	 */
	public String getEncryptStringForEnterpriseMall(String userId) throws BusException;
	/**
	* 获取已完成订单的totalCount    陈烨
	* @param conditions
	* @return
	* @throws BusException
	*/
	public List<Record> getTotalCount(
	   			Collection<Condition> conditions,
	   			String userId)  throws BusException;
	/**
	 * APP端重新设置密码
	 * @param phone
	 * @param passwd
	 * @param repasswd
	 * @param phoneCode
	 * @return
	 */
	public MemberInformation findPwdReset(String phone, String passwd,
			String repasswd, String phoneCode);
	/**
     * 前台个人中心    安全中心，chenye
     * @param userId  
     * @return
     * @throws BusException
     */
	public MemberInformation getMember( String userId) throws BusException;
	/**
	 * 获取企业通讯录
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @return
	 * @throws BusException
	 */
	public PagerRecords getPagerEnterMemberInformations(Pager pager,
			Collection<Condition> conditions, Collection<Order> orders,String userId)
			throws BusException;
}
