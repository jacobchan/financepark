/**
 * 代码声明
 */
package com.manage.ActivityManager.service;

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
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityApplylist;

public interface ActivityApplylistManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ActivityApplylist> getActivityApplylists() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ActivityApplylist> getActivityApplylists(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ActivityApplylist getActivityApplylist(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerActivityApplylists(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ActivityApplylist saveActivityApplylist(ActivityApplylist o) throws BusException;

    /**
     * 删除对象
     */
    public void removeActivityApplylist(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityApplylists(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitActivityApplylist(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitActivityApplylist(String propertyName,Object value) throws BusException;
    /**
     * 活动前端页面报名
     * @param o
     * @return
     * @throws BusException
     */
	public Record saveActivityApplylistForPage(ActivityApplylist o,String captcha) throws BusException;
	/**
	 * 	获取报名活动短信校验码 
	 * @param id
	 * @return
	 * @throws BusException
	 */
	public TempDemo getActivityCaptcha(String applyId,String phone) throws BusException; 
}
