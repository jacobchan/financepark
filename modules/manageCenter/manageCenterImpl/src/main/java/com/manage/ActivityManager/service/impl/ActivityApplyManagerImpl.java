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
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.ActivityManager.entity.ActivityComment;
import com.manage.ActivityManager.entity.ActivityDocument;
import com.manage.ActivityManager.entity.ApplayType;
import com.manage.ActivityManager.dao.ActivityApplyDao;
import com.manage.ActivityManager.service.ActivityApplyManager;
import com.manage.ActivityManager.service.ActivityApplylistManager;
import com.manage.ActivityManager.service.ActivityCommentManager;
import com.manage.ActivityManager.service.ActivityDocumentManager;
import com.manage.ActivityManager.service.ApplayTypeManager;
import com.mysql.jdbc.Util;

@Service("activityApplyManager")
@Transactional
public class ActivityApplyManagerImpl extends BaseManagerImpl implements ActivityApplyManager{
	@Autowired
	private ActivityApplyDao activityApplyDao;
	@Autowired
	private ActivityApplylistManager activityApplylistManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private ActivityCommentManager activityCommentManager;
	@Autowired
	private ActivityDocumentManager activityDocumentManager;
	@Autowired
	private ApplayTypeManager applayTypeManager;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private PurchasingmanagerCommodityManager purchasingmanagerCommodityManager;
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
		/*List<ActivityApply> list = pagerRecords.getRecords();
		for(ActivityApply app : list){
			if(StringUtils.isNotEmpty(app.getApplyOrderNumber())){
				String commodityId = app.getApplyOrderNumber();
				PurchasingmanagerCommodity comm =  purchasingmanagerCommodityManager.getPurchasingmanagerCommodity(commodityId);
				app.setCommAdd(comm.getCommodityTitle());
			}
		}*/
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ActivityApply saveActivityApply(ActivityApply o) throws BusException{
    	String applyId = o.getApplyId();
    	boolean isUpdate = StringUtils.isNotEmpty(applyId);
    	Collection<Condition> conditions=new ArrayList<Condition>();
    	conditions.add(ConditionUtils.getCondition("memberId.memberId", Condition.EQUALS, o.getMemberId().getMemberId()));
    	conditions.add(ConditionUtils.getCondition("applyStatus", Condition.EQUALS,"00"));
    	List<ActivityApply> list=activityApplyDao.commonQuery(conditions, null);
    	if(list.size()>1){
    		throw new BusException("当前用户有申请还在审核中,请等管理员审批后再申请！");
    	}
    	if(isUpdate){//修改
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	}else{//新增
    		//活动申请选了场地要生成会议室订单
    		if(StringUtils.isNotEmpty(o.getApplyOrderNumber())){
    			System.out.println("****************活动申请选了场地要生成会议室订单******************");
    		}
    		o.setApplyNumber(BizCodeUtil.getInstance().getBizCodeDate("GRHD"));
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	o.setDocumentCount(0);//初始化文档数
    	}
    	ActivityApply apply = activityApplyDao.save(o);
		/*ActivityDocument document = new ActivityDocument() ;
		document.setActivityApply(apply);
		document.setDocumentPath(o.getDocumentPath());
		activityDocumentManager.saveActivityDocumentList(document);*/
		return apply ;
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
    @EsbServiceMapping
	public List<ActivityApply> getParticipateActivityList(@ServiceParam(name="userId",pubProperty = "userId") String userId)
			throws BusException {
		// TODO Auto-generated method stub
    	//先模拟一个登陆用户，之后会修改
    	MemberInformation member=memberInformationManager.getMemberInformation(userId);
    	//获取当前用户参加活动的list
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, member.getMemberId()));
    	List<ActivityApplylist> activityApplylist=activityApplylistManager.getActivityApplylists(condition, null);
    	List<ActivityApply> aalist=new ArrayList<ActivityApply>();
    	for(ActivityApplylist aal:activityApplylist){
    		aalist.add(aal.getActivityApply());
    	}
		return aalist;
	}
    /**
     * 获取当前登录用户发布活动集合
     * 
     */ 
    @EsbServiceMapping
	public List<ActivityApply> getPublishActivityList(@ServiceParam(name="userId",pubProperty = "userId") String userId) throws BusException {
		// TODO Auto-generated method stub
    	//先模拟一个登陆用户，之后会修改
    	MemberInformation member=memberInformationManager.getMemberInformation(userId);
    	//获取当前用户参加活动的list
    	List<ActivityApply> list=activityApplyDao.getList("memberId.memberId", member.getMemberId()); 	
		return list;
	}
    /**
     * 根据活动主键查询报名名单
     * 
     */ 
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public List<MemberInformation> getPublishActivityMembers(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
    	//获取活动报名的list
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("activityApply.applyId", Condition.EQUALS,o.getApplyId()));
    	List<ActivityApplylist> activityApplylist=activityApplylistManager.getActivityApplylists(condition, null);
    	List<MemberInformation> members=new ArrayList<MemberInformation>();
    	for(ActivityApplylist aa:activityApplylist){
    		MemberInformation member=aa.getMember();
    		members.add(member);
    	}
		return members;
	}
    /**
     * 根据活动主键查询评论
     * 
     */ 
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public List<ActivityComment> getPublishActivityComments(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
    	//获取活动评论的list
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("activityApply.applyId", Condition.EQUALS,o.getApplyId()));
    	Collection<Order> orders = new ArrayList<Order>();
    	orders.add(ConditionUtils.getOrder("createTime", false));
    	List<ActivityComment> activityComments=activityCommentManager.getActivityComments(condition, orders);
		return activityComments;
	}
    /**
     * 根据活动主键查询文档
     * 
     */   
    @EsbServiceMapping
	public List<ActivityDocument> getPublishActivityDocuments(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("activityApply.applyId", Condition.EQUALS,o.getApplyId()));
    	Collection<Order> orders = new ArrayList<Order>();
    	orders.add(ConditionUtils.getOrder("createTime", false));
    	List<ActivityDocument> activityDocuments=activityDocumentManager.getActivityDocuments(condition, orders);
		return activityDocuments;
	}
    
    /**
     * 根据活动主键查询活动场地 
     * 
     */   
    @EsbServiceMapping
	public List<OrdermanagerUserorder> getPublishActivityOrder(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
    	ActivityApply aa=activityApplyDao.get(o.getApplyId());
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("userorderId", Condition.EQUALS,aa.getApplyOrderNumber()));
    	List<OrdermanagerUserorder> ordermanagerUserorder=ordermanagerUserorderManager.getOrdermanagerUserorders(condition, null);
		return ordermanagerUserorder;
	}
    
    /**
     * 申请通过更改状态
     */
    @EsbServiceMapping
	public void updateApplyStatus(@ServiceParam(name="applyId") String id) throws BusException {
		// TODO Auto-generated method stub
    	ActivityApply aa=activityApplyDao.get(id);
    	aa.setApplyStatus("01");
    	activityApplyDao.save(aa);
	}
    /**
     * 根据创智慧类型获取活动
     * @param type
     * @return
     * @throws BusException
     */ 
    @EsbServiceMapping
	public List<ActivityApply> getActivityListByType(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
    	//获取当前用户参加活动的list
    	if(StringUtils.isEmpty(o.getApplayType().getTypeId())){
    		return this.getActivityApplys();
    	}
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("applayType.typeId", Condition.EQUALS,o.getApplayType().getTypeId()));	
    	condition.add(ConditionUtils.getCondition("applyStatus", Condition.EQUALS,"01"));
    	List<ActivityApply> activityApplyList=activityApplyDao.commonQuery(condition, null);
		return activityApplyList;
	}
    /**
     * 获取类型为推荐的活动 
     * @param isRecoment
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public List<ActivityApply> getActivityListIsRecoment(@ServiceParam(name="isRecoment")String isRecoment)
			throws BusException {
		// TODO Auto-generated method stub
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("applayType.isRecoment", Condition.EQUALS,"0"));
    	List<ActivityApply> activityApplyList=activityApplyDao.commonQuery(condition, null);
		return activityApplyList;
	}
    /**
     *  获取强烈推荐活动 
     * @param o
     * @return
     * @throws BusException
     */
    @EsbServiceMapping
	public List<ActivityApply> getActivityListIsRecoomend(ActivityApply o)
			throws BusException {
		// TODO Auto-generated method stub
    	Collection<Condition> condition = new ArrayList<Condition>();
    	condition.add(ConditionUtils.getCondition("isRecoomend", Condition.EQUALS,"0"));
    	condition.add(ConditionUtils.getCondition("applyStatus", Condition.EQUALS,"01"));
     	List<ActivityApply> activityApplyList=activityApplyDao.commonQuery(condition, null);
		return activityApplyList;
	}
    
    /**
     * 个人中心活动发布保存
     * @param o
     * @return
     * @throws BusException
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public ActivityApply saveActivityApplyForPage(ActivityApply o)
			throws BusException {
    	Collection<Condition> conditions=new ArrayList<Condition>();
    	conditions.add(ConditionUtils.getCondition("memberId.memberId", Condition.EQUALS, o.getUpdateUser()));
    	conditions.add(ConditionUtils.getCondition("applyStatus", Condition.EQUALS,"00"));
    	List<ActivityApply> list=activityApplyDao.commonQuery(conditions, null);
    	if(list.size()>1){
    		throw new BusException("您有申请还在审核中,请等管理员审批后再申请！");
    	}
    	o.setMemberId(memberInformationManager.getMemberInformation(o.getUpdateUser()));
    	o.setApplyStatus("00");//默认申请中
    	o.setIsRecoomend("1");//默认不推荐
    	//o.setApplayType(applayType);
    	//获取所有类型
    	List<ApplayType>  typelist = applayTypeManager.getApplayTypes();
    	if(typelist.size()>0){
    		o.setApplayType(typelist.get(0));
    	}
    	o.setApplyNumber(BizCodeUtil.getInstance().getBizCodeDate("GRHD"));
    	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	o.setCreateUser(o.getUpdateUser());
    	o.setUpdateUser(o.getUpdateUser());
    	ActivityApply apply = activityApplyDao.save(o);
    	if(StringUtils.isNotEmpty(o.getDocumentPath())){ //当上传了文档
	    	ActivityDocument document = new ActivityDocument() ;
			document.setActivityApply(apply);
			document.setDocumentPath(o.getDocumentPath());
			activityDocumentManager.saveActivityDocumentList(document);
    	}
		return apply;
	}

    /**
   	 * 获取即将进行的最新活动
   	 * @return 分页对象
   	 */
    @EsbServiceMapping
    public PagerRecords getNewApplys(Pager pager) throws BusException{
    	Collection<Condition> condition = new ArrayList<Condition>();
    	String time = DateUtils.getToday("yyyy-MM-dd HH:mm:ss");
    	condition.add(ConditionUtils.getCondition("startTime",Condition.RIGHT,time));
    	condition.add(ConditionUtils.getCondition("applyStatus", Condition.EQUALS,"01"));
    	Collection<Order> order = new ArrayList<Order>();
    	order.add(ConditionUtils.getOrder("startTime", true));
    	PagerRecords pagerRecords = activityApplyDao.findByPager(pager, condition, order);
    	return pagerRecords;
    }
}
