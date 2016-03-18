/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

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
import com.gsoft.framework.util.DateUtils;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.ActivityManager.dao.ActivityApplylistDao;
import com.manage.ActivityManager.service.ActivityApplylistManager;

@Service("activityApplylistManager")
@Transactional
public class ActivityApplylistManagerImpl extends BaseManagerImpl implements ActivityApplylistManager{
	@Autowired
	private ActivityApplylistDao activityApplylistDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ActivityApplylist> getActivityApplylists() throws BusException{
    	return activityApplylistDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ActivityApplylist> getActivityApplylists(
    	@ConditionCollection(domainClazz=ActivityApplylist.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return activityApplylistDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ActivityApplylist getActivityApplylist(@ServiceParam(name="applylistId") String id)  throws BusException{
    	return activityApplylistDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerActivityApplylists(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ActivityApplylist.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = activityApplylistDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ActivityApplylist saveActivityApplylist(ActivityApplylist o) throws BusException{
//    	String activityApplylistId = o.getActivityApplylistId();
//    	boolean isUpdate = StringUtils.isNotEmpty(activityApplylistId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return activityApplylistDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeActivityApplylist(@ServiceParam(name="applylistId") String id) throws BusException{
    	activityApplylistDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeActivityApplylists(@ServiceParam(name="applylistId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeActivityApplylist(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitActivityApplylist(@ServiceParam(name="applylistId") String id)  throws BusException{
		return activityApplylistDao.exists(id);
	}
    
    public boolean exsitActivityApplylist(String propertyName,Object value) throws BusException{
		return activityApplylistDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public ActivityApplylist saveActivityApplylistForPage(ActivityApplylist o)
			throws BusException {
		// TODO Auto-generated method stub
    	MemberInformation member=memberInformationManager.getMemberInformation(o.getUpdateUser());
    	o.setMember(member);
    	o.setApplylistTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	o.setCreateUser(o.getUpdateUser());
    	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	o.setUpdateUser(o.getUpdateUser());
    	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	activityApplylistDao.save(o);
		return o;
	}

}
