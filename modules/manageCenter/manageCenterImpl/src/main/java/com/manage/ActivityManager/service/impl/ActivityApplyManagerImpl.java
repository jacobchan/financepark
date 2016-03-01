/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.SecurityUtils;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.ActivityManager.dao.ActivityApplyDao;
import com.manage.ActivityManager.service.ActivityApplyManager;
import com.manage.ActivityManager.service.ActivityApplylistManager;

@Service("activityApplyManager")
@Transactional
public class ActivityApplyManagerImpl extends BaseManagerImpl implements ActivityApplyManager{
	@Autowired
	private ActivityApplyDao activityApplyDao;
	@Autowired
	private ActivityApplylistManager activityApplylistManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ActivityApply> getActivityApplys() throws BusException{
    	return activityApplyDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ActivityApply> getActivityApplys(
    	@ConditionCollection(domainClazz=ActivityApply.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return activityApplyDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ActivityApply getActivityApply(@ServiceParam(name="applyId") String id)  throws BusException{
    	return activityApplyDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerActivityApplys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ActivityApply.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = activityApplyDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ActivityApply saveActivityApply(ActivityApply o) throws BusException{
//    	String activityApplyId = o.getActivityApplyId();
//    	boolean isUpdate = StringUtils.isNotEmpty(activityApplyId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return activityApplyDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeActivityApply(@ServiceParam(name="applyId") String id) throws BusException{
    	activityApplyDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityApplys(@ServiceParam(name="applyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeActivityApply(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitActivityApply(@ServiceParam(name="applyId") String id)  throws BusException{
		return activityApplyDao.exists(id);
	}
    
    public boolean exsitActivityApply(String propertyName,Object value) throws BusException{
		return activityApplyDao.exists(propertyName,value);
	}
    
    /**
     * 获取当前登录用户参加活动集合
     * 
     */ 
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public List<ActivityApply> getParticipateActivityList()
			throws BusException {
		// TODO Auto-generated method stub
    	//先模拟一个登陆用户，之后会修改
    	MemberInformation member=memberInformationManager.getMemberInformationByLoginUser(null);
    	//获取当前用户参加活动的list
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("applyMember", Condition.EQUALS, member.getMemberId()));
    	List<ActivityApplylist> activityApplylist=activityApplylistManager.getActivityApplylists(condition, null);
    	List<ActivityApply> aalist=new ArrayList<ActivityApply>();
    	for(ActivityApplylist aal:activityApplylist){
    		aalist.add(aal.getActivityApply());
    	}
		return aalist;
	}

}
