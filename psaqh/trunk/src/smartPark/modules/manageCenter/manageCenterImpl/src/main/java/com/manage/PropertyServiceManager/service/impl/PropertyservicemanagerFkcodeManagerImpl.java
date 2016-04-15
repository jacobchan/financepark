/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpSenderMsg;
import com.gsoft.utils.QRCodeUtil;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.PolicyManager.entity.PolicyApply;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCos;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFkcode;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTwcrd;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerFkcodeDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerFkcodeManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerTwcrdManager;

@Service("propertyservicemanagerFkcodeManager")
@Transactional
public class PropertyservicemanagerFkcodeManagerImpl extends BaseManagerImpl implements PropertyservicemanagerFkcodeManager{
	@Autowired
	private PropertyservicemanagerFkcodeDao propertyservicemanagerFkcodeDao;
	@Autowired
	private PropertyservicemanagerTwcrdManager propertyservicemanagerTwcrdManager ;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	@Value("#{configProperties['file.root.path']}")
	private String root;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes() throws BusException{
    	return propertyservicemanagerFkcodeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerFkcode> getPropertyservicemanagerFkcodes(
    	@ConditionCollection(domainClazz=PropertyservicemanagerFkcode.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerFkcodeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerFkcode getPropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id)  throws BusException{
    	return propertyservicemanagerFkcodeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerFkcodes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerFkcode.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerFkcodeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",pubProperty="userId")})
    public PropertyservicemanagerFkcode savePropertyservicemanagerFkcode(PropertyservicemanagerFkcode o) throws BusException{
    	String propertyservicemanagerFkcodeId = o.getFkcodeId();
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerFkcodeId);
    	PropertyservicemanagerFkcode fkcode =  null ;
    	if(isUpdate){//修改
    		fkcode = propertyservicemanagerFkcodeDao.save(o) ;//保存访客申请
    	}else{//新增
    		//如果是新增，则要创建对应的二维码
    		//o.setApplyStatus("01");//默认申请状态为申请中
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setApplyTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setFkCode(BizCodeUtil.getInstance().getBizCodeDate("WYGV"));
    		//查询登陆人所在企业
    		EnterpriseEmployees em = null;
    		Collection<Condition> conditions = new ArrayList<Condition>();
	    	conditions.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, o.getMember().getMemberId()));
    		List<EnterpriseEmployees> employlist =  enterpriseEmployeesManager.getEnterpriseEmployeess(conditions, null);
    		if(employlist.size()>0){
    			em = employlist.get(0);
    			o.setFkcodeComp(em.getRz().getRzId());//保存所在企业id
    		}
    		
    		fkcode = propertyservicemanagerFkcodeDao.save(o) ;//保存访客申请
    		
    		try {
    			HttpSenderMsg.sendMsg(fkcode.getFkcodeTelephone(), "您提交访客申请："+fkcode.getFkCode()+"已成功，欢迎到来！");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		
    		PropertyservicemanagerTwcrd twcrd = new PropertyservicemanagerTwcrd() ;//申请成功后会生成对应的二维码
    		twcrd.setStatus("00");//00二维码状态为有效,01表示无效
    		twcrd.setPropertyservicemanagerFkcode(fkcode);//将访客申请set到对应的二维码中
    		twcrd.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));	
    		try {
    			String imgPath = root+"qrcode/";     
    	        String contents = "欢迎来访!";  
				String url = QRCodeUtil.encode(contents, imgPath);
				twcrd.setTwcrdAddrec("qrcode/"+url);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		propertyservicemanagerTwcrdManager.savePropertyservicemanagerTwcrd(twcrd) ;//保存访客申请的二维码
    	}
    	return fkcode;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id) throws BusException{
    	if(StringUtils.isNotEmpty(id)){
    		PropertyservicemanagerFkcode fkcode = propertyservicemanagerFkcodeDao.get(id) ;//通过id得到对应的申请对象
    		PropertyservicemanagerTwcrd twcrd = propertyservicemanagerTwcrdManager.findTwcrdByFkcode(fkcode) ;//通过访客申请对象得到对应的二维码对象
    		if(null != twcrd){//表示此申请状态有相应的二维码
    			String twcrdId = twcrd.getTwcrdId() ;//得到二维码的ID
    			propertyservicemanagerTwcrdManager.removePropertyservicemanagerTwcrd(twcrdId);//通过id删除二维码
    		}
    		propertyservicemanagerFkcodeDao.remove(id);
    	}
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerFkcodes(@ServiceParam(name="fkcodeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerFkcode(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerFkcode(@ServiceParam(name="fkcodeId") String id)  throws BusException{
		return propertyservicemanagerFkcodeDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerFkcode(String propertyName,Object value) throws BusException{
		return propertyservicemanagerFkcodeDao.exists(propertyName,value);
	}
    
	/**
	 * 根据访客申请ID得到会员名称
	 * @param fkcodeId 访客申请ID
	 * @return
	 */
    @EsbServiceMapping
	@Override
	public MemberInformation getMemberByFkcodeId(@ServiceParam(name="fkcodeId") String fkcodeId) {
    	if(StringUtils.isNotEmpty(fkcodeId)){
    		PropertyservicemanagerFkcode fkcode = propertyservicemanagerFkcodeDao.get(fkcodeId) ;
    		MemberInformation member = fkcode.getMember() ;
    		if(member != null){
    			return member ;
    		}else{
    			return null ;
    		}
    	}
		return null;
	}
    
    /**
	 * 更新访客申请的申请状态
	 * @param fkcodeId 访客申请ID
	 * @param 标识符，00表示同意申请，01表示拒绝申请
	 */
//    @Override
//    @EsbServiceMapping
//    public void updateFkcode(@ServiceParam(name="fkcodeId")String fkcodeId, @ServiceParam(name="code")String code) {
//    	PropertyservicemanagerFkcode fkcode = propertyservicemanagerFkcodeDao.get(fkcodeId) ;
//    	if("00".equals(code)){//同意
//    		fkcode.setApplyStatus("02");//02表示申请成功
//    		fkcode = propertyservicemanagerFkcodeDao.save(fkcode) ;
//    		PropertyservicemanagerTwcrd twcrd = new PropertyservicemanagerTwcrd() ;//申请成功后会生成对应的二维码
//    		twcrd.setStatus("00");//00二维码状态为有效,01表示无效
//    		twcrd.setPropertyservicemanagerFkcode(fkcode);//将访客申请set到对应的二维码中
//    		propertyservicemanagerTwcrdManager.savePropertyservicemanagerTwcrd(twcrd) ;//保存访客申请的二维码
//    	}
//    	if("01".equals(code)){//拒绝
//    		fkcode.setApplyStatus("03");//03表示申请失败
//        	propertyservicemanagerFkcodeDao.save(fkcode) ;
//    	}
//    }
    /**
	 * 根据登录用户获取访客申请
	 * @param o 访客对象
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",pubProperty="userId")})
	public List<PropertyservicemanagerFkcode> getFkcodeListforpage(PropertyservicemanagerFkcode o) throws BusException{
    	//获取当前登录用户id
    	String id = o.getMember().getMemberId();
    	if(id!=null){
	    	//获取当前用户参加活动的list
	    	Collection<Condition> condition = new ArrayList<Condition>();
	    	condition.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, id));
	    	List<PropertyservicemanagerFkcode> list = propertyservicemanagerFkcodeDao.commonQuery(condition, null);
	    	if(list.size()>0){
	    		return list;
	    	}else{
	    		return null;
	    	}
    	}else{
    		return null;
    	}
    }
    
    /**
	 * 前台取消访客
	 * @param fkcodeId
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
	public PropertyservicemanagerFkcode cancelStatus(@ServiceParam(name="fkcodeId") String fkcodeId) throws BusException{
    	PropertyservicemanagerFkcode fkcode = propertyservicemanagerFkcodeDao.get(fkcodeId) ;
    	if(fkcode!=null){
    		PropertyservicemanagerTwcrd twcrd = propertyservicemanagerTwcrdManager.findTwcrdByFkcode(fkcode) ;//通过访客申请对象得到对应的二维码对象
    		twcrd.setStatus("03");
    		propertyservicemanagerTwcrdManager.savePropertyservicemanagerTwcrd(twcrd);
    		return fkcode;
    	}else{
    		return null;
    	}
    	
    	
    }
    //通过订单号获取当前用户的访客记录  模糊查询
    @EsbServiceMapping
	 public List<PropertyservicemanagerFkcode> getFkcodelistLikeFkcodeCode(
			 @ServiceParam(name="userId",pubProperty="userId") String userId,
			@ServiceParam(name="fkCode") String fkCode,
			@ServiceParam(name="startTime") String startTime,
			@ServiceParam(name="endTime") String endTime) throws BusException {							 
		Collection<Condition> condition = new ArrayList<Condition>();
		condition.add(ConditionUtils.getCondition("fkCode", Condition.LIKE, fkCode));	
		condition.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, userId));
		condition.add(ConditionUtils.getCondition("fkcodeTime", Condition.BETWEEN, startTime+Condition.BETWEEN_SPLIT+endTime));
		List<PropertyservicemanagerFkcode> list =propertyservicemanagerFkcodeDao.commonQuery(condition, null);
		return list;
				
	}
    /**
	 * 根据当前用户分页查询
	 * @return 分页对象
	 */
    
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerFkcodes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerFkcode.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)
			throws BusException {
    	PagerRecords pagerRecords = propertyservicemanagerFkcodeDao.findByPager(pager, conditions, orders); 
    	@SuppressWarnings("unchecked")
		List<PropertyservicemanagerFkcode> list = pagerRecords.getRecords();
    	for(PropertyservicemanagerFkcode fk : list){
			if(StringUtils.isNotEmpty(fk.getFkcodeId())){
				String fkcode = fk.getFkcodeId();
				Collection<Condition> condition = new ArrayList<Condition>();
				condition.add(ConditionUtils.getCondition("propertyservicemanagerFkcode.fkcodeId", Condition.EQUALS,fkcode));
				List<PropertyservicemanagerTwcrd> twcrd = propertyservicemanagerTwcrdManager.getPropertyservicemanagerTwcrds(condition, null) ;//通过访客申请对象得到对应的二维码对象
				fk.setDksataus(twcrd.get(0).getStatus());
													
			}
		}
    	return pagerRecords;
	}
    
}
