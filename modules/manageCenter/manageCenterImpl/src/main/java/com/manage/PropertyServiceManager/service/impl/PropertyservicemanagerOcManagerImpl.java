/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerOc;
import com.manage.ActivityManager.entity.ActivityApply;
import com.manage.ActivityManager.entity.ActivityApplylist;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerOcDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerOcManager;
         
@Service("propertyservicemanagerOcManager")
@Transactional
public class PropertyservicemanagerOcManagerImpl extends BaseManagerImpl implements PropertyservicemanagerOcManager{
	@Autowired
	private PropertyservicemanagerOcDao propertyservicemanagerOcDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	/**
     * 修改一卡通预约状态
     */
	 @EsbServiceMapping	
	 public void updateOcStatus(@ServiceParam(name="ocId") String id, @ServiceParam(name="ocStatus") String ocStatus)
				throws BusException {
		// TODO Auto-generated method stub
		 if(id!=null){
			 PropertyservicemanagerOc o=propertyservicemanagerOcDao.get(id);
			 String bindStatus=o.getBindStatus();
			 if("01".equals(bindStatus)){
				 o.setOcStatus(ocStatus);
		    	 propertyservicemanagerOcDao.save(o); 
			 }
	    	 
		 }
	}
	/* @EsbServiceMapping
		public void updateUserorderStatus(@ServiceParam(name="userorderId") String id, @ServiceParam(name="userorderStatus") String userorderStatus)
				throws BusException {
			// TODO Auto-generated method stub
	    	OrdermanagerUserorder o=ordermanagerUserorderDao.get(id);
	    	o.setUserorderStatus(userorderStatus);
	    	ordermanagerUserorderDao.save(o);
		}*/
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs() throws BusException{
    	return propertyservicemanagerOcDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerOcDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerOc getPropertyservicemanagerOc(@ServiceParam(name="ocId") String id)  throws BusException{
    	return propertyservicemanagerOcDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerOcs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerOcDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",pubProperty="userId")})
    public PropertyservicemanagerOc savePropertyservicemanagerOc(PropertyservicemanagerOc o) throws BusException{
    	String propertyservicemanagerOcId = o.getOcId();
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerOcId);
    	if(isUpdate){//修改
    		//获取一卡通申请记录
    		PropertyservicemanagerOc ocde = propertyservicemanagerOcDao.get(propertyservicemanagerOcId);
    		if(ocde!=null){
    			if(ocde.getOcStatus().equals("00")){//待处理-->已办理
		    		ocde.setOcNumber(o.getOcNumber());
		    		ocde.setOcDate(o.getOcDate());
		    		ocde.setOcRemark(o.getOcRemark());
		    		ocde.setOcStatus(o.getOcStatus());
		    		ocde.setOcStatus("01");
    			}else if(ocde.getOcStatus().equals("01")){//已办理-->已领卡
    				ocde.setOcStatus("02");
    			}
	    		return propertyservicemanagerOcDao.save(ocde);
    		}else{
    			throw new BusException("未找到申请记录!");
    		}
    	}else{//新增
    		//生成一卡通编号
    		Collection<Condition> condition = new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, o.getMemberId()));	
    		List<EnterpriseEmployees> employees = enterpriseEmployeesManager.getEnterpriseEmployeess(condition, null);
    		PropertyservicemanagerOc saveOc = null;
    		if(employees.size()>0){
	    		o.setOcComp(employees.get(0).getRz().getRzName());
	    		o.setOcWay("00");
	    		o.setOcStatus("00");
	    		o.setOcCode(BizCodeUtil.getInstance().getBizCodeDate("WYOC"));
	    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
	    		o.setApplyTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
	    		saveOc = propertyservicemanagerOcDao.save(o);
	    		//发送短信给联系人
	    		try {
	    			HttpSenderMsg.sendMsg(saveOc.getOcAddree().getAddressPhone(), "您的一卡通申请已成功,申请单号："+saveOc.getOcCode()+"，请等待办卡完成！");
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
    		}else{
    			throw new BusException("您不是企业会员!");
    		}	
    		return saveOc;
    	}
    
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerOc(@ServiceParam(name="ocId") String id) throws BusException{
    	propertyservicemanagerOcDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerOcs(@ServiceParam(name="ocId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerOc(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerOc(@ServiceParam(name="ocId") String id)  throws BusException{
		return propertyservicemanagerOcDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerOc(String propertyName,Object value) throws BusException{
		return propertyservicemanagerOcDao.exists(propertyName,value);
	}
    /**
     * 获取当前登录用户一卡通号码
     * @return
     * @throws BusException
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
    public List<PropertyservicemanagerOc> getPropertyservicemanagerOcListByLoginUser(PropertyservicemanagerOc o)
			throws BusException {
		//获取当前登录用户id
		String id = o.getCreateUser();		
		List<PropertyservicemanagerOc> list=propertyservicemanagerOcDao.getList("memberId", id);
		for(PropertyservicemanagerOc oc : list){
			if(StringUtils.isNotEmpty(oc.getMemberId())){
				String memberId = oc.getMemberId();
				MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
				oc.setMember(memberInformation);
			}
		}
		return list;
	}
    /**
     * 一卡通解绑
     * @return
     * @throws BusException
     */
   @EsbServiceMapping
    public PropertyservicemanagerOc updateBindStatus(PropertyservicemanagerOc p) throws BusException{   	
	   String ocId = p.getOcId();	   
	   PropertyservicemanagerOc psm = propertyservicemanagerOcDao.get(ocId);    		
       psm.setBindStatus("0");
	   return propertyservicemanagerOcDao.save(psm);    		
    }
   /**
	 * 增加绑定卡号
	 * @param ocNumber
	 * @param bindStatus
	 */
   @EsbServiceMapping
   public PropertyservicemanagerOc addBindOc(
		   @ServiceParam(name="ocNumber") String ocNumber,  
		   @ServiceParam(name="bindStatus") String  bindStatus)
			throws BusException {											
	   PropertyservicemanagerOc psm = propertyservicemanagerOcDao. getObjectByUniqueProperty("ocNumber", ocNumber);   		
       psm.setBindStatus("1");
	   return propertyservicemanagerOcDao.save(psm);    		
   }
   /**
    * 修改一卡通预约状态
    */
	 @EsbServiceMapping	
   public PropertyservicemanagerOc cancleOcStatus(@ServiceParam(name="ocId") String id)
				throws BusException {
		// TODO Auto-generated method stub	
		PropertyservicemanagerOc o=propertyservicemanagerOcDao.get(id);
		String ocStstus=o.getOcStatus();
		if("00".equals(ocStstus)){
			o.setOcStatus("08");
			o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			return propertyservicemanagerOcDao.save(o); 
	    }else{
	    	 throw new BusException("只有在未办理成功时才能取消"); 
	    	 
	    }		
		  
	}
	//通过订单号获取当前用户的一卡通申请记录  模糊查询
	    @EsbServiceMapping
		 public List<PropertyservicemanagerOc> getOclistLikeOcCode(
				 @ServiceParam(name="userId",pubProperty="userId") String userId,
				@ServiceParam(name="ocCode") String ocCode,
				@ServiceParam(name="startTime") String startTime,
				@ServiceParam(name="endTime") String endTime) throws BusException {	
	       
			Collection<Condition> condition = new ArrayList<Condition>();
			condition.add(ConditionUtils.getCondition("memberId", Condition.EQUALS, userId));	
			//condition.add(ConditionUtils.getCondition("ocCode", Condition.LIKE, ocCode));
			condition.add(ConditionUtils.getCondition("ocDate", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
			List<PropertyservicemanagerOc> list =propertyservicemanagerOcDao.commonQuery(condition, null);
			return list;
	    }
	    /**
		 * 前台根据当前用户分页查询
		 * @return 分页对象
		 */
	    @SuppressWarnings("unchecked")
	    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
		public PagerRecords getPagerOc(Pager pager,//分页条件
				@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,//查询条件
				@OrderCollection Collection<Order> orders)
				throws BusException {	    		   
	    	PagerRecords pagerRecords = propertyservicemanagerOcDao.findByPager(pager, conditions, orders);
	    	List<PropertyservicemanagerOc> list = pagerRecords.getRecords();
	    	for(PropertyservicemanagerOc oc : list){
    			if(StringUtils.isNotEmpty(oc.getMemberId())){
    				String memberId = oc.getMemberId();
    				MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
    				oc.setMember(memberInformation);
    			}
    		}
	    	return pagerRecords;
		}
	    /**
		 * 前台根据当前用户分页查询         chenye
		 * @return 分页对象
		 */
	    @SuppressWarnings("unchecked")
	    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
		public PagerRecords getPagerLikeOc(Pager pager,//分页条件
				@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,//查询条件
				@OrderCollection Collection<Order> orders,
				@ServiceParam(name="startTime") String startTime,
				@ServiceParam(name="endTime") String endTime)
				throws BusException {
	        conditions.add(ConditionUtils.getCondition("ocDate", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));	    	
	    	PagerRecords pagerRecords = propertyservicemanagerOcDao.findByPager(pager, conditions, orders);
	    	List<PropertyservicemanagerOc> list = pagerRecords.getRecords();
	    	for(PropertyservicemanagerOc oc : list){
    			if(StringUtils.isNotEmpty(oc.getMemberId())){
    				String memberId = oc.getMemberId();
    				MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
    				oc.setMember(memberInformation);
    			}
    		}
	    	return pagerRecords;
		}
	    /**
	   	 * 获取已完成订单的totalCount    陈烨
	   	 * @param conditions
	   	 * @return
	   	 * @throws BusException
	   	 */
	       @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	   	public List<Record> getTotalCount(
	   			@ConditionCollection(domainClazz=PropertyservicemanagerOc.class) Collection<Condition> conditions,
				@ServiceParam(name="startTime") String startTime,
				@ServiceParam(name="endTime") String endTime)  throws BusException{
	   		List<Record> recordList=new ArrayList<Record>();
	   		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			conditions.add(ConditionUtils.getCondition("applyTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
	   			}
	    	List<PropertyservicemanagerOc> List = this.getPropertyservicemanagerOcs(conditions, null);
	   		Record record = new Record();
	   		record.put("totalCount", List.size());
	   		recordList.add(record);
	   		return recordList;
	   	} 
   /**
	* 根据主键查询 前台个人中心，一卡通预约详情   chenye
	*/		
    @EsbServiceMapping  
    public PropertyservicemanagerOc getOc(@ServiceParam(name="ocId") String id)  throws BusException{
    	PropertyservicemanagerOc oc=propertyservicemanagerOcDao.get(id);
		String memberId=oc.getMemberId();
		MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId); 
		oc.setMember(memberInformation);
		return oc;
		}	       
}
