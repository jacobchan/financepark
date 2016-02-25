/**
 * 代码声明
 */
package com.common.MessageCenter.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.common.MessageCenter.entity.McMsgtempalate;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

public interface McMsgtempalateManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<McMsgtempalate> getMcMsgtempalates() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<McMsgtempalate> getMcMsgtempalates(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public McMsgtempalate getMcMsgtempalate(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMcMsgtempalates(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public McMsgtempalate saveMcMsgtempalate(McMsgtempalate o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMcMsgtempalate(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMcMsgtempalates(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMcMsgtempalate(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMcMsgtempalate(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据消息模板获取消息内容
	 * @param msgtempalate 模板
	 * @param replaceMap 置换的map
	 * @return
	 * @throws BusException
	 */
	public String genMsgContent(McMsgtempalate msgtempalate,Map<String,String> replaceMap) throws BusException;
	
	/**获取参数个数
	 * @param content
	 * @return
	 * @throws BusExcption
	 */
	public String getParamCount(String content) throws BusException;
	
}
