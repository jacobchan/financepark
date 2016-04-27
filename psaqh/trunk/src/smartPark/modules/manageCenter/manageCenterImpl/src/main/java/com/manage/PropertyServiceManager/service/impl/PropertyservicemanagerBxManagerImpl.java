/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.OrderManager.entity.OrdermanagerOrderprojecttypeValue;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerBxDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTsManager;

@Service("propertyservicemanagerBxManager")
@Transactional
public class PropertyservicemanagerBxManagerImpl extends BaseManagerImpl implements PropertyservicemanagerBxManager{
	@Autowired
	private PropertyservicemanagerBxDao propertyservicemanagerBxDao;
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	@Autowired
	private PurchasingmanagerGenreManager	purchasingmanagerGenreManager;
	@Autowired
	private PurchasingmanagerGenrePropertyManager purchasingmanagerGenrePropertyManager;
	@Autowired
	private OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager;
	@Autowired
	private PropertyservicemanagerTsManager propertyservicemanagerTsManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	@Autowired 
	private CodeitemManager codeitemManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs() throws BusException{
    	return propertyservicemanagerBxDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerBx> getPropertyservicemanagerBxs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerBxDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerBx getPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
    	return propertyservicemanagerBxDao.get(id);
    }
    
    @SuppressWarnings("unchecked")
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerBxs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerBxDao.findByPager(pager, conditions, orders);	
		List<PropertyservicemanagerBx> bxlist = pagerRecords.getRecords();
		for(PropertyservicemanagerBx bx : bxlist){
			if(StringUtils.isNotEmpty(bx.getMemberId())){
				String memberId = bx.getMemberId();
				MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
				bx.setMember(memberInformation);
			}
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",pubProperty="userId")})
    public PropertyservicemanagerBx savePropertyservicemanagerBx(PropertyservicemanagerBx o) throws BusException{
    	String propertyservicemanagerBxId = o.getBxId();
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerBxId);
    	PropertyservicemanagerBx savebx = null;
    	if(isUpdate){//修改
    		//物业管理员定价生成订单
        	if(o.getBxStatus().equals("05")){
        		//获取报修单
        		String bxId = o.getBxId();
        		PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(bxId);
        		String memberId = bx.getMemberId();
        		MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
        		//获取当前登录用户
        		Object object = SecurityUtils.getPrincipal();
        		User user = new User();
        		if(object != null && object instanceof User){
        			user = (User) object;
        		}
        		OrdermanagerUserorder order = new OrdermanagerUserorder();
     
        		//查询商品类别
        		Collection<Condition> condition =  new ArrayList<Condition>();
        		condition.add(ConditionUtils.getCondition("genreCode", Condition.EQUALS,"0601"));
        		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenres(condition, null).get(0);
        		
        		order.setGenreId(pg);
        		order.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("BXOD"));
        		order.setUserorderStatus("01");//01-未支付
        		order.setCreateUser(user.getUserId());
        		order.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		order.setUpdateUser(user.getUserId());
        		order.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		order.setUserorderBuyUser(memberInformation.getMemberName());//购买人姓名
        		order.setMemberId(memberInformation.getMemberId());//购买人id
        		order.setUserorderProject("物业报修");//购买项目
        		order.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        		order.setUserorderAmount(o.getBxAmount());//购买金额
        		OrdermanagerUserorder saveorder = 	ordermanagerUserorderManager.saveOrdermanagerUserorder(order);
        		if(saveorder!=null){
	        		//保存订单扩展属性列表
	        		Collection<Condition> purcondition =  new ArrayList<Condition>();
	        		purcondition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS,pg.getGenreId()));
	        		List<PurchasingmanagerGenreProperty> genrePropertyList = purchasingmanagerGenrePropertyManager.getPurchasingmanagerGenrePropertys(purcondition,null);
	        		if(genrePropertyList.size()>0){
	    	    		for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){//保存订单扩展项信息
	    	    			OrdermanagerOrderprojecttypeValue orderExtendValue = new OrdermanagerOrderprojecttypeValue();
	    	    			orderExtendValue.setOrdermanagerUserorder(saveorder);
	    	    			orderExtendValue.setGenrePropertyId(genreProperty);
	    	    			if("orderBxId".equals(genreProperty.getGenrePropertyFieldName())){
	    	    				orderExtendValue.setOrderprojecttypeValueFieldValue(bxId);
	    	    			}
	    	    			ordermanagerOrderprojecttypeValueManager.saveOrdermanagerOrderprojecttypeValue(orderExtendValue);
	    	    		}
	        		}
        		}
        		//物业管理员定价，同时关闭派工记录
        		PropertyservicemanagerTs ts =  propertyservicemanagerTsManager.getTsBybxId(bxId);
        		ts.setTsStatus("03");
        		propertyservicemanagerTsManager.savePropertyservicemanagerTs(ts);
        		//保存报修记录
        		bx.setBxStatus(o.getBxStatus());
        		bx.setBxAmount(o.getBxAmount());
        		savebx = propertyservicemanagerBxDao.save(bx);
        	}else{
        		savebx = propertyservicemanagerBxDao.save(o);
        	}
    	}else{//新增
    		//查询当前申请用户
    		String memberId = o.getMemberId();
    		MemberInformation memberInformation = null;
    		if(StringUtils.isNotEmpty(memberId)){
    			memberInformation = memberInformationManager.getMemberInformation(memberId);
    		}
   			o.setBxCode(BizCodeUtil.getInstance().getBizCodeDate("WYBX"));
   			o.setCreateUser(memberId);
   			o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   			o.setApplyTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   			o.setBxStatus("00");
   			savebx = propertyservicemanagerBxDao.save(o);
   			try {
    			HttpSenderMsg.sendMsg(memberInformation.getMemberPhoneNumber(), "您提交报修已成功，申请单号："+savebx.getBxCode()+"，请等待物业管理员审批！");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
   		}	
    	return savebx;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerBx(@ServiceParam(name="bxId") String id) throws BusException{
    	propertyservicemanagerBxDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerBxs(@ServiceParam(name="bxId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerBx(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerBx(@ServiceParam(name="bxId") String id)  throws BusException{
		return propertyservicemanagerBxDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerBx(String propertyName,Object value) throws BusException{
		return propertyservicemanagerBxDao.exists(propertyName,value);
	}

    /**
     * 根据id修改报修状态
	 * @param id 报修记录主键id
	 * @param code 判断流程是否标识
	 * @throws BusException
     */
    @EsbServiceMapping
	public void upBxbyId(@ServiceParam(name="id") String id,
			@ServiceParam(name="code") String code) throws BusException {
    	PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(id);
    	String bxstatus = bx.getBxStatus();
    	if(code.equals("01")){//回绝报修
    		if(bxstatus.equals("00")){
    			bx.setBxStatus("08");
    		}else if(bxstatus.equals("05")){//重修报修
        		bx.setBxStatus("01");//回滚状态到已受理	
    		}
    	}else{
    		if(bxstatus.equals("00")){//待受理-->已受理
    			bx.setBxStatus("01");
    		}else if(bxstatus.equals("05")){//已定价-->已支付
    			bx.setBxStatus("06");
    		}else if(bxstatus.equals("06")){//已付款-->已完成
    			bx.setBxStatus("07");
    		}
    	}
    	propertyservicemanagerBxDao.save(bx);
	}
    
	/**
	 * 根据当前登录用户获取报修单
	 * @param o 报修对象
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId")})
	public List<PropertyservicemanagerBx> getBxListforpage(PropertyservicemanagerBx o)
			throws BusException {
		//获取当前登录用户id
		String id = o.getMemberId();
		if(id!=null){
	    	//根据当前用户获取公司保修的list
			EnterpriseEmployees e = enterpriseEmployeesDao.getObjectByUniqueProperty("member.memberId", id);
		    EnterbusinessmanagerRz rz=e.getRz();
	        String rzName=rz.getRzName();
	    	Collection<Condition> condition = new ArrayList<Condition>();
	    	condition.add(ConditionUtils.getCondition("bxComp", Condition.LIKE, rzName));
	    	 List<PropertyservicemanagerBx> list = propertyservicemanagerBxDao.commonQuery(condition, null);
	    		for(PropertyservicemanagerBx bx : list){
	    			if(StringUtils.isNotEmpty(bx.getMemberId())){
	    				String memberId = bx.getMemberId();
	    				MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
	    				bx.setMember(memberInformation);
	    			}
	    		}
	    		 
	    		 return list;
	    	 
		}else{
			return null;
		}
		
	}
	
	/**
	 * 根据报修代码集
	 * @param o 报修对象
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId")})
	public List<Record> getBxcodemapforpage(PropertyservicemanagerBx o) throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> condition =  new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"bx_type"));
		order.add(ConditionUtils.getOrder("itemValue", true));
		List<Codeitem> list = codeitemManager.getCodeitems(condition, order);
		for(int i=0;i<list.size();i++){
				Codeitem co=list.get(i);
				Record record = new Record();
				record.put("itemValue", co.getItemValue());
				record.put("itemName", co.getItemCaption());
				recordList.add(record);
			}	
		return recordList;
	}
	/**
	 * 前台用户发起报修单更改
	 * @param bxId 报修单id
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public PropertyservicemanagerBx updateBxforpage(@ServiceParam(name="bxId") String bxId) throws BusException{
		PropertyservicemanagerBx bx = propertyservicemanagerBxDao.get(bxId);
		if(bx!=null){
	    	String bxstatus = bx.getBxStatus();
	    	if(!"05".equals(bxstatus)){
	    		//取消报修订单
	    		bx.setBxStatus("08");
	    		bx.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
	    	}else if("05".equals(bxstatus)){
	    		//重新报修--到已受理状态
	    		bx.setBxStatus("01");
	    		bx.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
	    	}
	    	return propertyservicemanagerBxDao.save(bx);
		}else{
			throw new BusException("未查询到该报修单，如有疑问请与客服人员联系");
		}
	}
	/**
	 * 根据当前用户分页查询    跟据订单号模糊查询    chenye
	 * @param pager
	 * @param conditions
	 * @param orders
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusException
	 */
	@SuppressWarnings("unchecked")
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerBxs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders,					
			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime)throws BusException {
		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
		conditions.add(ConditionUtils.getCondition("applyTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		}
		PagerRecords pagerRecords = propertyservicemanagerBxDao.findByPager(pager, conditions, orders);
		List<PropertyservicemanagerBx> bxlist = pagerRecords.getRecords();
    	for(PropertyservicemanagerBx bx : bxlist){
    	if(StringUtils.isNotEmpty(bx.getMemberId())){
		String memberId = bx.getMemberId();
	    MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId);
	    bx.setMember(memberInformation);
	    			}
	    		}
				return pagerRecords;
			}
	/**
   	 * 获取已完成订单的totalCount    
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */		    
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
    public List<Record> getTotalCount(
   			@ConditionCollection(domainClazz=PropertyservicemanagerBx.class) Collection<Condition> conditions,
			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime)  throws BusException{
   		List<Record> recordList=new ArrayList<Record>();
   		if(StringUtils.isNotEmpty(startTime)||StringUtils.isNotEmpty(endTime)){
   			conditions.add(ConditionUtils.getCondition("applyTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
   		}
    	List<PropertyservicemanagerBx> List = this.getPropertyservicemanagerBxs(conditions, null);
   		Record record = new Record();
   		record.put("totalCount", List.size());
   		recordList.add(record);
   		return recordList;
   	} 
		/**
		 * 根据主键查询 前台个人中心，保修详情   chenye
		 */
	@EsbServiceMapping  
    public PropertyservicemanagerBx getBx(@ServiceParam(name="bxId") String id)  throws BusException{
		PropertyservicemanagerBx bx=propertyservicemanagerBxDao.get(id);
		String memberId=bx.getMemberId();
		MemberInformation memberInformation = memberInformationManager.getMemberInformation(memberId); 
		bx.setMember(memberInformation);
		return bx;
	}
}
