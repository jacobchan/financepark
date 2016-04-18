/**
 * 代码声明
 */
package com.manage.PolicyManager.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PolicyManager.entity.PolicyApply;

public interface PolicyApplyManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<PolicyApply> getPolicyApplys() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<PolicyApply> getPolicyApplys(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public PolicyApply getPolicyApply(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerPolicyApplys(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public PolicyApply savePolicyApply(PolicyApply o) throws BusException;

    /**
     * 删除对象
     */
    public void removePolicyApply(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePolicyApplys(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitPolicyApply(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitPolicyApply(String propertyName,Object value) throws BusException;
	  
    /**
     * 更新政策流程状态
     * @param policyApplyId，政策申请记录ID
     * @throws BusException
     */
	public void updatePolicyApply(String policyApplyId) throws BusException;
	
	/**
	 * 通过会员id查询到相应的企业名称
	 * @param id 会员id
	 * @return
	 * @throws BusException
	 */
	public EnterbusinessmanagerRz findEnterpriseByMemberId(String id) throws BusException;
	/**
     * 获取当前登录用户申请的政策    */
	public List<PolicyApply> getPolicyApplyListByLoginUser(PolicyApply o)throws BusException;   	
	/**
     * 修改政策申请状态  */  
    public PolicyApply updatePolicyApplyStatus(String policyApplyId) throws BusException;  	
    
    /**
     * 取消政策申请，前端调用
     * @param policyApplyId，政策申请记录ID
     * @return
     * @throws BusException
     */
    public PolicyApply cancelApply(String policyApplyId) throws BusException ;
    /**
	 * 根据当前用户分页查询
	 * @return 分页对象
	 */
	public PagerRecords getPagerPolicyApply(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
	
	/**
	 * 获取整个数据的totalCount
	 */
	public List<Record> getTotalCount(Collection<Condition> conditions);
}
