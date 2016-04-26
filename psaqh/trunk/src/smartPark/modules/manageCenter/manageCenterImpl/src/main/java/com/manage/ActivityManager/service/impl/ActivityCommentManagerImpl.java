/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.ActivityManager.entity.ActivityComment;
import com.manage.ActivityManager.dao.ActivityCommentDao;
import com.manage.ActivityManager.service.ActivityCommentManager;

@Service("activityCommentManager")
@Transactional
public class ActivityCommentManagerImpl extends BaseManagerImpl implements ActivityCommentManager{
	@Autowired
	private ActivityCommentDao activityCommentDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ActivityComment> getActivityComments() throws BusException{
    	return activityCommentDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ActivityComment> getActivityComments(
    	@ConditionCollection(domainClazz=ActivityComment.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return activityCommentDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ActivityComment getActivityComment(@ServiceParam(name="commentId") String id)  throws BusException{
    	return activityCommentDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerActivityComments(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ActivityComment.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = activityCommentDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "commentMember.memberId", pubProperty = "userId")})
    public ActivityComment saveActivityComment(ActivityComment o) throws BusException{
//    	String activityCommentId = o.getActivityCommentId();
//    	boolean isUpdate = StringUtils.isNotEmpty(activityCommentId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	o.setCreateUser(o.getCommentMember().getMemberId());
    	o.setCommentTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	return activityCommentDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeActivityComment(@ServiceParam(name="commentId") String id) throws BusException{
    	activityCommentDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityComments(@ServiceParam(name="commentId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeActivityComment(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitActivityComment(@ServiceParam(name="commentId") String id)  throws BusException{
		return activityCommentDao.exists(id);
	}
    
    public boolean exsitActivityComment(String propertyName,Object value) throws BusException{
		return activityCommentDao.exists(propertyName,value);
	}

}
