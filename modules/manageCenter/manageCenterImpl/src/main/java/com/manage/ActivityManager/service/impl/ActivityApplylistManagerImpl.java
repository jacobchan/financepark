/**
 * 代码声明
 */
package com.manage.ActivityManager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.MessageService;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.ActivityManager.dao.ActivityApplylistDao;
import com.manage.ActivityManager.service.ActivityApplyManager;
import com.manage.ActivityManager.service.ActivityApplylistManager;

@Service("activityApplylistManager")
@Transactional
public class ActivityApplylistManagerImpl extends BaseManagerImpl implements ActivityApplylistManager{
	@Autowired
	private ActivityApplylistDao activityApplylistDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	@Autowired
	private ActivityApplyManager activityApplyManager;
	
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
	public Record saveActivityApplylistForPage(ActivityApplylist o,@ServiceParam(name="captcha") String captcha)
			throws BusException {
		//校验是否重复报名
    	Record cord = new Record();
    	List<ActivityApplylist> applist = activityApplylistDao.getList(new String[]{"activityApply.applyId","applyPhone"},new String[]{o.getActivityApply().getApplyId(),o.getApplyPhone()});
    	if(applist.size()<=0){
    		Boolean bool = mcMsgdatasManager.checkCode(o.getApplyPhone(), captcha);
    		if(bool){
    			if(StringUtils.isNotEmpty(o.getUpdateUser())){//登录用户报名保存，匿名用户不保存
    				MemberInformation member=memberInformationManager.getMemberInformation(o.getUpdateUser());
    				o.setMember(member);
    			}
		    	o.setApplylistTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	o.setCreateUser(o.getUpdateUser());
		    	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	o.setUpdateUser(o.getUpdateUser());
		    	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    	activityApplylistDao.save(o);
		    	cord.put("code", "00");//报名成功!
				cord.put("meg", "活动报名成功!");
    		}else{
    			cord.put("code", "01");//校验码错误
				cord.put("meg", "校验码错误,请重新输入!");
    		}
    	}else{
    		cord.put("code", "02");//已成功报名
			cord.put("meg", "你已报名成功!");
    	}
    	return cord;
	}
    /**
	 * 	获取报名活动短信校验码 
	 * @param id
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
    public TempDemo getActivityCaptcha(@ServiceParam(name="applyId") String applyId,
    		@ServiceParam(name="phone") String phone) throws BusException{
    	TempDemo demo = new TempDemo();
    	ActivityApply activity = activityApplyManager.getActivityApply(applyId);
    	if(activity!=null){
    		Random random = new Random(new Date().getTime());
			Long code = Math.abs(random.nextLong() % 999999);
			String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
			Map<String,Object> map = new HashMap<String, Object>();
			map.put(MessageService.CODE, captcha);
    		//根据手机号码获取用户
    		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
    		Boolean success = mcMsgdatasManager.smsSend("1015", map, mb!=null?mb.getMemberId():null, phone);
    		if(success){
    			demo.setBuff("000000");
    		}else{
    			demo.setBuff("发送失败");
    		}
    	}else{
			demo.setBuff("发送失败");
		}
    	return demo;
    }
}
