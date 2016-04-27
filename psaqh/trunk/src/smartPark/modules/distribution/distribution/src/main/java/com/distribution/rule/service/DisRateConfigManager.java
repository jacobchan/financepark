/**
 * 代码声明
 */
package com.distribution.rule.service;

import java.util.Collection;
import java.util.List;

import com.distribution.rule.entity.DisRateConfig;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

public interface DisRateConfigManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<DisRateConfig> getDisRateConfigs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<DisRateConfig> getDisRateConfigs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public DisRateConfig getDisRateConfig(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerDisRateConfigs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public void saveDisRateConfig(DisRateConfig o,String v1,String v2,String v3) throws BusException;

    /**
     * 删除对象
     */
    public void removeDisRateConfig(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDisRateConfigs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitDisRateConfig(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitDisRateConfig(String propertyName,Object value) throws BusException;
	
	/**
	 * 获取未生成规则的分销等级
	 * @return
	 * @throws BusException
	 */
	public String getLevel(String level) throws BusException;
	
}
