package com.common.EnterpriceTypeManager.service;
import java.util.List;
import java.util.Collection;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
public interface EtypeEnterprisetypeManager extends BaseManager{
    /**
     * 查询列表
     */
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<EtypeEnterprisetype> getEtypeEnterprisetypes(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public EtypeEnterprisetype getEtypeEnterprisetype(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerEtypeEnterprisetypes(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public EtypeEnterprisetype saveEtypeEnterprisetype(EtypeEnterprisetype o) throws BusException;

    /**
     * 删除对象
     */
    public void removeEtypeEnterprisetype(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEtypeEnterprisetypes(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitEtypeEnterprisetype(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitEtypeEnterprisetype(String propertyName,Object value) throws BusException;
	
	public List<EtypeEnterprisetype> getChildren(String parentId) throws BusException;
	
	/**
	 * 获取父级企业类型
	 * @return
	 * @throws BusException
	 */
	public List<EtypeEnterprisetype> getParentEnterpriseType() throws BusException;
	
	/**
	 * 获取子级企业类型JSon
	 * @return
	 * @throws BusException
	 */
	public String findEnterpriseTypeTree(String pId) throws BusException;
	/**
	 * 获取子级企业类型
	 * @return
	 * @throws BusException
	 */
	public List<EtypeEnterprisetype> getSubEnterpriseTypeList() throws BusException;
}
