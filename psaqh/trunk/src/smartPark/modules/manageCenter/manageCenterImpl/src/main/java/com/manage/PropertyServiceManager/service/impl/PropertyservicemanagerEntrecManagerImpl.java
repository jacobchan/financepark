/**
 * 代码声明
 */
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
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.gsoft.entity.MessageTempCode;
import com.gsoft.entity.ReferenceMap;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEnteringDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEntrecDao;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEntrecManager;
import com.manage.ReserveManager.entity.ReservationRecord;

@Service("propertyservicemanagerEntrecManager")
@Transactional
public class PropertyservicemanagerEntrecManagerImpl extends BaseManagerImpl implements PropertyservicemanagerEntrecManager{
	@Autowired
	private PropertyservicemanagerEntrecDao propertyservicemanagerEntrecDao;
	
	@Autowired
	private MemberInformationDao memberInformationDao;
	
	@Autowired
	private MemberInformationManager memberInformationManager;
	
	
	@Autowired
	private PropertyservicemanagerEnteringDao propertyservicemanagerEnteringDao;
	
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
	
	@Autowired
	private McMsgtempalateManager mcMsgtempalateManager;
	
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs() throws BusException{
    	return propertyservicemanagerEntrecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerEntrec> getPropertyservicemanagerEntrecs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerEntrecDao.commonQuery(conditions, orders);
    }
    
    /**
     *个人中心查询我的入驻申请预约
     */
    @EsbServiceMapping
	public PagerRecords getPropertyservicemanagerEntrecsForReserve(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,@ServiceParam(name="userId",pubProperty = "userId") String userId)  throws BusException{
    	conditions.add(ConditionUtils.getCondition("createUser", Condition.EQUALS, userId));
		PagerRecords pagerRecords = propertyservicemanagerEntrecDao.findByPager(pager, conditions, orders);		
		return pagerRecords;
	}
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntrec getPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
    	return propertyservicemanagerEntrecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerEntrecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerEntrecDao.findByPager(pager, conditions, orders);
//		List<PropertyservicemanagerEntrec> entrecNewList = new ArrayList<PropertyservicemanagerEntrec>();
//		for (Object obj : pagerRecords.getRecords()) {
//			PropertyservicemanagerEntrec entrec = (PropertyservicemanagerEntrec) obj;
//			
//			String enteringName=entrec.getEnteringName();
//			if (StringUtils.isNotEmpty(enteringName)) {
//				MemberInformation memberInformation=memberInformationDao.get(enteringName);
//				entrec.setEnteringName(memberInformation.getMemberName());
//			}
//			entrecNewList.add(entrec);
//		}
//		pagerRecords.setRecords(entrecNewList);
		
		return pagerRecords;
	}
    /**
     * 保存对象:入驻申请成功之后，发短信通知用户和后台管理员
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PropertyservicemanagerEntrec savePropertyservicemanagerEntrec(PropertyservicemanagerEntrec o) throws BusException{
    	String propertyservicemanagerEnteringId =o.getPropertyservicemanagerEntering().getEnteringId();
    	String propertyservicemanagerEntreId =o.getEntrecId();//主键ID
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerEntreId);
    	
    	MemberInformation memberInformation=new MemberInformation();
    	if(o.getUpdateUser()!=null){
    		memberInformation=memberInformationManager.getMemberInformation(o.getUpdateUser());
    	}
		String enteringType=o.getEnteringType();//申请类型
		//判断入驻申请人是否重复
		List<PropertyservicemanagerEntrec> entrecList=new ArrayList<PropertyservicemanagerEntrec>();
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("memberId.memberId", Condition.EQUALS, memberInformation.getMemberId()));
		conditions.add(ConditionUtils.getCondition("enterrecStatus",Condition.IN, new String[] {"01","02","06"}));//待受理，已授理，已入驻
		conditions.add(ConditionUtils.getCondition("enteringType", Condition.EQUALS, enteringType));

		entrecList=propertyservicemanagerEntrecDao.commonQuery(conditions, null);
    	
    	if(isUpdate){//修改
    		
			PropertyservicemanagerEntering enteringAfter=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
    		PropertyservicemanagerEntrec entrec=propertyservicemanagerEntrecDao.get(propertyservicemanagerEntreId);
    		String enteringId =entrec.getPropertyservicemanagerEntering().getEnteringId();
    		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(enteringId);
    		
    		
    		String enteringNameBefore=entrec.getEnteringName();//变更前的入驻申请人
    		String enteringNameAfter=o.getEnteringName();//变更后的入驻申请人
    		//若入驻申请人没有变更，则更新可办理预约记录和入驻申请服务信息
    		if(enteringNameBefore.equals(enteringNameAfter)){
    			PropertyservicemanagerEntrec pe=this.entringIdChange(o, enteringBefore, enteringAfter);
    			return pe;
    		}else{
    			//若入驻申请人发生变更，则做入驻申请人重复性判断
    			if(entrecList.size()>0){//存在重复申请，则抛提醒消息
        			throw new BusException("该申请人已申请入驻，不能重复申请");
        		}else{
        			PropertyservicemanagerEntrec pe=this.entringIdChange(o, enteringBefore, enteringAfter);
        			return pe;
        		}
    		}
    		
    	}else{//新增
    		PropertyservicemanagerEntering enteringBefore=propertyservicemanagerEnteringDao.get(propertyservicemanagerEnteringId);
    		
    		String enteringRemain=enteringBefore.getEnteringRemain();//剩余预约数量
    		String enteringAlre=enteringBefore.getEnteringAlre();//已预约数量
    		enteringBefore.setEnteringRemain(String.valueOf(Integer.valueOf(enteringRemain)-1));
    		enteringBefore.setEnteringAlre(String.valueOf(Integer.valueOf(enteringAlre)+1));
    		if(enteringBefore.getEnteringRemain().equals("0")){
    			enteringBefore.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满：02
    		}else{
    			enteringBefore.setEnteringStatus("01");
    		}
    		//变更可办理预约表中的剩余预约数量和已预约数量
    		propertyservicemanagerEnteringDao.save(enteringBefore);
    		
    		if(entrecList.size()>0){//存在重复申请，则抛提醒消息
    			throw new BusException("该申请人已申请入驻，不能重复申请");
    		}else{
    			o.setMemberId(memberInformation);
    			o.setPropertyservicemanagerEntering(enteringBefore);
    			o.setEnterrecStatus("01");//01：已预约
    			o.setEnterrecCode(BizCodeUtil.getInstance().getBizCodeDate("YYBH"));//生成入驻预约编号
    			o.setCreateUser(o.getUpdateUser());
    			o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    			o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    			//新增 入驻服务办理预约记录基础数据
    			o=propertyservicemanagerEntrecDao.save(o);
    			//发送短信给联系人
        		try {
        			//构建替换模板参数对应的map
        			Map<String, String> replaceMap = new ReferenceMap();
        			replaceMap.put("#user",memberInformation.getMemberName());
        			replaceMap.put("#appointmentNo", o.getEnterrecCode());
        			//构建消息内容数据
        			McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_USER_1, replaceMap);
        			//发送消息,给会员
        			mcMsgdatasManager.sendMessage(msgData, memberInformation.getMemberId(), 1);
        			
        			Map<String, String> replaceMap1 = new ReferenceMap();
        			replaceMap.put("#appointmentNo", o.getEnterrecCode());
        			replaceMap.put("#relateProject", "入驻服务");
        			//构建消息内容数据
        			McMsgdatas msgData1 = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_BACKGROUND_4, replaceMap1);
        			//发送消息,给物业主管:ROLE_TENE_ADMIN
        			mcMsgdatasManager.sendMessage(msgData1,"ROLE_TENE_ADMIN",2);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
    			
    			//新增 入驻服务办理预约记录基础数据
        		return o;
    		}
    		
    	}
    	
		
		
    }
    
	/**
	 * 修改入驻申请时，判断预约记录Id是否变更
	 * */
	@EsbServiceMapping
	public PropertyservicemanagerEntrec entringIdChange(PropertyservicemanagerEntrec o,PropertyservicemanagerEntering before,PropertyservicemanagerEntering after) throws BusException {
		String enteringIdBefore =before.getEnteringId();//变更前
		String enteringIdAfter=after.getEnteringId();//变更后
		//预约记录ID变更，则修改变更前和变更后的可办理预约记录信息(修改剩余预约数量和已预约数量)
		if(!enteringIdBefore.equals(enteringIdAfter)){
			//变更后
			after.setEnteringRemain(String.valueOf(Integer.valueOf(after.getEnteringRemain())-1));//剩余预约数量
			after.setEnteringAlre(String.valueOf(Integer.valueOf(after.getEnteringAlre())+1));//已预约数量
			if(after.getEnteringRemain().equals("0")){
				after.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满：02
    		}else{
    			after.setEnteringStatus("01");
    		}
			propertyservicemanagerEnteringDao.save(after);


			//变更前
			before.setEnteringRemain(String.valueOf(Integer.valueOf(before.getEnteringRemain())+1));//剩余预约数量
			before.setEnteringAlre(String.valueOf(Integer.valueOf(before.getEnteringAlre())-1));//已预约数量
			if(before.getEnteringRemain().equals("0")){
				before.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满：02
    		}else{
    			before.setEnteringStatus("01");
    		}
			propertyservicemanagerEnteringDao.save(before);

		}

		after.setUpdateUser(o.getUpdateUser());
		after.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		o.setPropertyservicemanagerEntering(after);
		return propertyservicemanagerEntrecDao.save(o);
	}
	
    
	/**
	 * 变更状态:已预约-->已授理，生成入驻受理编号，并发送短信通知用户
	 * */
	@EsbServiceMapping
	public void enterApplication(PropertyservicemanagerEntrec propertyservicemanagerEntrec) throws BusException {
		PropertyservicemanagerEntrec p=new PropertyservicemanagerEntrec();
		String entrecId=propertyservicemanagerEntrec.getEntrecId();
		if(StringUtils.isNotEmpty(entrecId)){
			p=propertyservicemanagerEntrecDao.get(entrecId);//根据主键查询入驻服务办理预约数据
		}
		p.setEnterrecStatus("02");//已授理
		p.setEnterrecCode(BizCodeUtil.getInstance().getBizCodeDate("RZYY"));//生成入驻预约编号
		PropertyservicemanagerEntrec entrec=propertyservicemanagerEntrecDao.save(p);
		MemberInformation mb=entrec.getMemberId();
		//只有入驻申请类型的预约，才生成企业信息
		if(entrec!=null && entrec.getEnterrecStatus().equals("02") && entrec.getEnteringType().equals("01")){
			//若该预约可预约状态变更为已授理，则更新企业入驻信息基本数据和企业会员信息
			enterbusinessmanagerRzManager.saveEnterbusinessmanagerRzBasicData(entrec.getEntrecId());
		}
		
		//发送短信给联系人
		try {
			//构建替换模板参数对应的map
			Map<String, String> replaceMap = new ReferenceMap();
			replaceMap.put("#user",mb != null?mb.getMemberName():entrec.getEnteringName());
			replaceMap.put("#appointmentNo", entrec.getEnterrecCode());
			//构建消息内容数据
			McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_USER_5, replaceMap);
			//发送消息,给会员
			mcMsgdatasManager.sendMessage(msgData, mb != null?mb.getMemberId():null, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id) throws BusException{
    	propertyservicemanagerEntrecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEntrecs(@ServiceParam(name="entrecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerEntrec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerEntrec(@ServiceParam(name="entrecId") String id)  throws BusException{
		return propertyservicemanagerEntrecDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerEntrec(String propertyName,Object value) throws BusException{
		return propertyservicemanagerEntrecDao.exists(propertyName,value);
	}
    
    /**
	 * 取消预约申请，将待受理状态变更为已取消，并还原预约数量
	 * @param ReservationRecord
	 */
    @EsbServiceMapping
	 public PropertyservicemanagerEntrec cancelReservation(PropertyservicemanagerEntrec o) throws BusException{
    	PropertyservicemanagerEntrec p=new PropertyservicemanagerEntrec();
		String entrecId=o.getEntrecId();
		if(StringUtils.isNotEmpty(entrecId)){
			p=propertyservicemanagerEntrecDao.get(entrecId);//根据主键查询入驻服务办理预约数据
		}
		String enteringId=p.getPropertyservicemanagerEntering().getEnteringId();
		PropertyservicemanagerEntering entering=propertyservicemanagerEnteringDao.get(enteringId);
		String enteringRemain=entering.getEnteringRemain();//剩余预约数量
		String enteringAlre=entering.getEnteringAlre();//已预约数量
		entering.setEnteringRemain(String.valueOf(Integer.valueOf(enteringRemain)+1));
		entering.setEnteringAlre(String.valueOf(Integer.valueOf(enteringAlre)-1));
		if(entering.getEnteringRemain().equals("0")){
			entering.setEnteringStatus("02");//剩余数量为0，修改可预约状态为预约已满：02
		}else{
			entering.setEnteringStatus("01");
		}
		propertyservicemanagerEnteringDao.save(entering);
		
		p.setEnterrecStatus("04");//已取消
		return propertyservicemanagerEntrecDao.save(p);
    }
    /**
	 *前台 根据当前用户分页查询
	 * @return 分页对象
	 */ 
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPager(Pager pager,//分页条件
				@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions,//查询条件
				@OrderCollection Collection<Order> orders)
				throws BusException {
	   PagerRecords pagerRecords = propertyservicemanagerEntrecDao.findByPager(pager, conditions, orders);
	   return pagerRecords;
	}
   /**获取全部订单的totalCount    
	* @param conditions
    * @return
	* @throws BusException
	*/	    		    
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
			   			@ConditionCollection(domainClazz=PropertyservicemanagerEntrec.class) Collection<Condition> conditions)  throws BusException{
		List<Record> recordList=new ArrayList<Record>();  		
		List<PropertyservicemanagerEntrec> List = this.getPropertyservicemanagerEntrecs(conditions, null);
		Record record = new Record();
        record.put("totalCount", List.size());
		recordList.add(record);
		return recordList;
	}

}
