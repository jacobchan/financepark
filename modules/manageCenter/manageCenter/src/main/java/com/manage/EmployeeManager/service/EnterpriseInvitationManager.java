package com.manage.EmployeeManager.service;
import java.util.List;
import java.util.Collection;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.EmployeeManager.entity.EnterpriseInvitation;
public interface EnterpriseInvitationManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<EnterpriseInvitation> getEnterpriseInvitations() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<EnterpriseInvitation> getEnterpriseInvitations(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public EnterpriseInvitation getEnterpriseInvitation(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerEnterpriseInvitations(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public EnterpriseInvitation saveEnterpriseInvitation(EnterpriseInvitation o) throws BusException;

    /**
     * 删除对象
     */
    public void removeEnterpriseInvitation(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterpriseInvitations(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitEnterpriseInvitation(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitEnterpriseInvitation(String propertyName,Object value) throws BusException;
	
	public void updateInvitationStatus(String invitationId, String invitationStatus) throws BusException;
}
