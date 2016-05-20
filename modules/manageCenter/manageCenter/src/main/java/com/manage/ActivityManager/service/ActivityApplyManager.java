/**
 * 代码声明
 */
package com.manage.ActivityManager.service;

import java.util.List;
import java.util.Collection;

import com.common.MemberManager.entity.MemberInformation;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityComment;
import com.manage.ActivityManager.entity.ActivityDocument;

public interface ActivityApplyManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ActivityApply> getActivityApplys() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ActivityApply> getActivityApplys(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ActivityApply getActivityApply(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerActivityApplys(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ActivityApply saveActivityApply(ActivityApply o) throws BusException;

    /**
     * 删除对象
     */
    public void removeActivityApply(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityApplys(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitActivityApply(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitActivityApply(String propertyName,Object value) throws BusException;
    /**
     *  获取当前登录用户参加活动集合  
     * @param userId
     * @return
     * @throws BusException
     */
    public List<ActivityApply> getParticipateActivityList(String userId) throws BusException;
    /**
     * 获取当前登录用户发布活动集合  
     * @param userId
     * @return
     * @throws BusException
     */
    public List<ActivityApply> getPublishActivityList(String userId) throws BusException;
    /**
     *  根据活动主键查询报名名单   
     * @param o
     * @return
     * @throws BusException
     */
    public List<MemberInformation> getPublishActivityMembers(ActivityApply o) throws BusException;
    /**
     *  根据活动主键查询活动评价  
     * @param o
     * @return
     * @throws BusException
     */
    public List<ActivityComment> getPublishActivityComments(ActivityApply o) throws BusException;
    /**
     * 根据活动主键查询文档   
     * @param o
     * @return
     * @throws BusException
     */
    public List<ActivityDocument> getPublishActivityDocuments(ActivityApply o) throws BusException;
    /**
     * 根据活动主键查询活动场地 
     * @param o
     * @return
     * @throws BusException
     */
    public List<OrdermanagerUserorder> getPublishActivityOrder(ActivityApply o) throws BusException;
    /**
     * 申请通过更改状态
     * @param id
     * @throws BusException
     */
    public void updateApplyStatus(String id,String status) throws BusException;
 
    /**
     * 根据创智慧类型获取活动
     * @param type
     * @return
     * @throws BusException
     */    
    public List<ActivityApply> getActivityListByType(ActivityApply o) throws BusException;
    
    /**
     *  获取推荐活动
     * @param isRecoment
     * @return
     * @throws BusException
     */
    public List<ActivityApply> getActivityListIsRecoment(String isRecoment) throws BusException;
    /**
     *  获取类型为推荐的活动
     * @param o
     * @return
     * @throws BusException
     */
    public List<ActivityApply> getActivityListIsRecoomend(ActivityApply o) throws BusException;
    
    /**
     * 个人中心活动发布保存
     * @param o
     * @return
     * @throws BusException
     */
    public ActivityApply saveActivityApplyForPage(ActivityApply o) throws BusException;
    
    /**
	 * 获取即将进行的最新活动
	 * @return 分页对象
	 */
	public PagerRecords getNewApplys(Pager pager) throws BusException;
}
