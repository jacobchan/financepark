package com.manage.PropertyServiceManager.service.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.entity.ReferenceMap;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerCosDao;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerCosManager;
@Service("propertyservicemanagerCosManager")
@Transactional
public class PropertyservicemanagerCosManagerImpl extends BaseManagerImpl implements PropertyservicemanagerCosManager{
	@Autowired
	private PropertyservicemanagerCosDao propertyservicemanagerCosDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss() throws BusException{
    	return propertyservicemanagerCosDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerCos> getPropertyservicemanagerCoss(
    	@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerCosDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerCos getPropertyservicemanagerCos(@ServiceParam(name="cosId") String id)  throws BusException{
    	return propertyservicemanagerCosDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerCoss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerCosDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "memberInformation.memberId", pubProperty = "userId")})
    public PropertyservicemanagerCos savePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{
    	if(!"".equals(o.getMemberInformation().getMemberId())&& null!=o.getMemberInformation().getMemberId()){
    		MemberInformation memberInformation = memberInformationDao.get(o.getMemberInformation().getMemberId());
        	o.setMemberInformation(memberInformation);
    	}
    	o.setCosCode(BizCodeUtil.getInstance().getBizCodeDate("WYTS"));
    	//待受理
    	o.setCosStatus("01");
    	if("".equals(o.getCosTime()) || null==o.getCosTime()){
    		o.setCosTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	}
    	try {
			HttpSenderMsg.sendMsg(o.getCosTelephone(), "您提交的投诉："+o.getCosCode()+"待物业管理员受理中，请及时关注受理状态！");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return propertyservicemanagerCosDao.save(o);
    }
    
    /**
     * 修改对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerCos updatePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{
    	PropertyservicemanagerCos cos = propertyservicemanagerCosDao.get(o.getCosId());
    	cos.setBackrecord(o.getBackrecord());
    	cos.setBackcode(BizCodeUtil.getInstance().getBizCodeDate("WYHF"));
    	cos.setBacktime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
    	try {
			HttpSenderMsg.sendMsg(cos.getCosTelephone(), "您的投诉："+cos.getCosCode()+"回访信息为："+o.getBackrecord()+"！");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return propertyservicemanagerCosDao.save(cos);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerCos(@ServiceParam(name="cosId") String id) throws BusException{
    	propertyservicemanagerCosDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerCoss(@ServiceParam(name="cosId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerCos(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerCos(@ServiceParam(name="cosId") String id)  throws BusException{
		return propertyservicemanagerCosDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerCos(String propertyName,Object value) throws BusException{
		return propertyservicemanagerCosDao.exists(propertyName,value);
	}

    @EsbServiceMapping
	public void upCosbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerCos cos = propertyservicemanagerCosDao.get(id);
    	cos.setCosStatus(code);
    	propertyservicemanagerCosDao.save(cos);
	}
    /**
     * 获取当前登录用户投诉列表
     * @return
     * @throws BusException
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
	public List<PropertyservicemanagerCos> getCosListByLoginUser(PropertyservicemanagerCos p) throws BusException {
    	String id = p.getCreateUser();	    	
    	List<PropertyservicemanagerCos> list =propertyservicemanagerCosDao.getList("memberInformation.memberId", id);
    	return list; 
	}
   /**
    * 前台修改订单
    * @param cosId
    * @return
    * @throws BusException
    */
    @SuppressWarnings("unused")
    @EsbServiceMapping
    public PropertyservicemanagerCos updateCosforpage(@ServiceParam(name="cosId") String cosId) throws BusException{
	    PropertyservicemanagerCos psm = propertyservicemanagerCosDao.get(cosId);
	    String cosStatus = psm.getCosStatus();
	    if(psm!=null){
		    //取消投诉 
		    if("01".equals(cosStatus)){
		    	psm.setCosStatus("03");
		    	psm.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    }else{
		    	throw new BusException("该状态下的订单不允许取消操作");
		    }
		    return propertyservicemanagerCosDao.save(psm);
	    }else{
	    	throw new BusException("该状态下的订单不允许取消操作");
	    } 
    }
	//通过订单号获取当前用户的报修单  模糊查询
	@EsbServiceMapping
	public List<PropertyservicemanagerCos> getCoslistLikeCosCode(
		@ServiceParam(name="userId",pubProperty="userId") String userId,
		@ServiceParam(name="cosCode") String cosCode,
		@ServiceParam(name="startTime") String startTime,
		@ServiceParam(name="endTime") String endTime) throws BusException {		
		
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("cosCode", Condition.LIKE, cosCode));	
		condition.add(ConditionUtils.getCondition("memberInformation.memberId", Condition.EQUALS, userId));
		condition.add(ConditionUtils.getCondition("cosTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		List<PropertyservicemanagerCos> list =propertyservicemanagerCosDao.commonQuery(condition, null);
		
		return list;
	}
	 /**
	 * 根据当前用户分页查询
	 * @return 分页对象
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberInformation.memberId",operator=Condition.EQUALS,pubProperty="userId")})
   
	public PagerRecords getPagerCos(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)
			throws BusException {  
    	PagerRecords pagerRecords = propertyservicemanagerCosDao.findByPager(pager, conditions, orders);  	
    	return pagerRecords;
	}
    
    
    /**
     * 受理保存对象
     * 修改投诉状态标识，添加回访记录
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PropertyservicemanagerCos acceptancePropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{
    	//查出该条投诉的基本信息
    	PropertyservicemanagerCos savePropertyservicemanagerCos = propertyservicemanagerCosDao.get(o.getCosId());
    	
    	//投诉受理状态
    	savePropertyservicemanagerCos.setCosStatus("02");
    	//修改时间
    	savePropertyservicemanagerCos.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	//回访记录
    	String backrecord = o.getBackrecord();
    	savePropertyservicemanagerCos.setBackrecord(backrecord);
    	//回访时间
    	savePropertyservicemanagerCos.setBacktime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	
    	//发送信息 
    	//用户名
    	String memberName = savePropertyservicemanagerCos.getMemberInformation().getMemberName();
    	//投诉单号
    	String cosCode = savePropertyservicemanagerCos.getCosCode();
    	//用户编号
    	String memberId = savePropertyservicemanagerCos.getMemberInformation().getMemberId();
    	this.sendMessage(memberName, cosCode, memberId);
    	
    	return propertyservicemanagerCosDao.save(savePropertyservicemanagerCos);
    }
    
    /**
     * 受理拒绝保存对象
     * 修改投诉状态标识，添加拒绝原因记录
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PropertyservicemanagerCos rejectPropertyservicemanagerCos(PropertyservicemanagerCos o) throws BusException{

    	//查出该条投诉的基本信息
    	PropertyservicemanagerCos savePropertyservicemanagerCos = propertyservicemanagerCosDao.get(o.getCosId());
    	//投诉受理状态
    	savePropertyservicemanagerCos.setCosStatus("04");
    	//修改时间
    	savePropertyservicemanagerCos.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	//拒绝原因
    	String backRemark = o.getBackRemark();
    	savePropertyservicemanagerCos.setBackRemark(backRemark);
    	//回访时间
    	savePropertyservicemanagerCos.setBacktime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	//发送信息
    	//用户名
    	String memberName = savePropertyservicemanagerCos.getMemberInformation().getMemberName();
    	//投诉单号
    	String cosCode = savePropertyservicemanagerCos.getCosCode();
    	//用户编号
    	String memberId = savePropertyservicemanagerCos.getMemberInformation().getMemberId();
    	this.sendMessage(memberName, cosCode, memberId);
    	
    	return propertyservicemanagerCosDao.save(savePropertyservicemanagerCos);
    }
    /**
	 *  /**
	 * 根据当前用户分页查询 根据投诉单号模糊查询（ 前台个人中心）    chenye
	 */
	 
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberInformation.memberId",operator=Condition.EQUALS,pubProperty="userId")})	   
	public PagerRecords getPagerLikeCos(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,
			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime,
			@ServiceParam(name="coslikeCode") String coslikeCode)
			throws BusException {  
    	conditions.add(ConditionUtils.getCondition("cosCode", Condition.LIKE, coslikeCode));
        //conditions.add(ConditionUtils.getCondition("cosCode", Condition.EQUALS, cosCode));
    	conditions.add(ConditionUtils.getCondition("cosTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
    	PagerRecords pagerRecords = propertyservicemanagerCosDao.findByPager(pager, conditions, orders);  	
    	return pagerRecords;
	}
    /**
   	 * 获取已完成订单的totalCount    陈烨
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberInformation.memberId",operator=Condition.EQUALS,pubProperty="userId")})
   	public List<Record> getTotalCount(
   			@ConditionCollection(domainClazz=PropertyservicemanagerCos.class) Collection<Condition> conditions,
   			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime,
			@ServiceParam(name="coslikeCode") String coslikeCode)  throws BusException{
   		List<Record> recordList=new ArrayList<Record>();
   		if(StringUtils.isNotEmpty(coslikeCode)){
   		conditions.add(ConditionUtils.getCondition("cosCode", Condition.LIKE, coslikeCode));
   		}
   		if(StringUtils.isNotEmpty(startTime)||StringUtils.isNotEmpty(endTime)){
		conditions.add(ConditionUtils.getCondition("applyTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
   		}
		List<PropertyservicemanagerCos> List = this.getPropertyservicemanagerCoss(conditions, null);
   		Record record = new Record();
   		record.put("totalCount", List.size());
   		recordList.add(record);
   		return recordList;
    }
    
    /**
     * 发送模版消息
     * @param memberName 用户name
     * @param cosCode 投诉单号
     * @param memberId 用户ID
     * @return
     */
    public String sendMessage(String memberName,String cosCode,String memberId) {
    	//构建替换模板参数对应的map
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", memberName);
		replaceMap.put("#serviceNo", cosCode);
		//构建消息内容数据
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0307", replaceMap);
		//发送消息,给会员
		return mcMsgdatasManager.sendToUser(msgData, memberId);
	}
}