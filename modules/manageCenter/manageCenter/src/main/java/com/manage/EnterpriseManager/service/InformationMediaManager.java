/**
 * 代码声明
 */
package com.manage.EnterpriseManager.service;

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
import com.manage.EnterpriseManager.entity.InformationMedia;

public interface InformationMediaManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<InformationMedia> getInformationMedias() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<InformationMedia> getInformationMedias(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public InformationMedia getInformationMedia(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerInformationMedias(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public InformationMedia saveInformationMedia(InformationMedia o) throws BusException;

    /**
     * 删除对象
     */
    public void removeInformationMedia(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationMedias(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitInformationMedia(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitInformationMedia(String propertyName,Object value) throws BusException;
	
	/**
	 * 根据企业id查询媒体信息
	 * @param mediaRe 入驻企业id
	 * @return 符合条件的媒体对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-18
	 */
	@EsbServiceMapping
	public List<InformationMedia> findInformationMedia(
			@ServiceParam(name = "mediaRe") String mediaRe)
			throws BusException;
}
