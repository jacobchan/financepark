/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.QRCodeUtil;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerMoverecDao;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerFxtdc;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerMoverec;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerFxtdcManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerMoverecManager;

@Service("propertyservicemanagerMoverecManager")
@Transactional
public class PropertyservicemanagerMoverecManagerImpl extends BaseManagerImpl implements PropertyservicemanagerMoverecManager{
	@Autowired
	private PropertyservicemanagerMoverecDao propertyservicemanagerMoverecDao;
	@Autowired
	private PropertyservicemanagerFxtdcManager propertyservicemanagerFxtdcManager ;
	@Autowired 
	private CodeitemManager codeitemManager;
	@Value("#{configProperties['file.root.path']}")
	private String root;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs() throws BusException{
    	return propertyservicemanagerMoverecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerMoverec> getPropertyservicemanagerMoverecs(
    	@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerMoverecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerMoverec getPropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id)  throws BusException{
    	return propertyservicemanagerMoverecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerMoverecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerMoverecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",pubProperty="userId")})
    public PropertyservicemanagerMoverec savePropertyservicemanagerMoverec(PropertyservicemanagerMoverec o) throws BusException{
    	String propertyservicemanagerMoverecId = o.getMoverecId();
    	PropertyservicemanagerMoverec rec = null;
    	boolean isUpdate = StringUtils.isNotEmpty(propertyservicemanagerMoverecId);
   		if(isUpdate){//修改
   			rec = propertyservicemanagerMoverecDao.save(o);
   		}else{//新增
   			/*String enName = o.getMoverecComp() ;//得到搬家企业名称
   	    	if(StringUtils.isEmpty(enName)){
   	    		throw new BusException("非企业用户没有权限申请！") ;
   	    	}*/
   	    	o.setMoverecStatus("00");
   	    	//生成搬家编号
   	    	o.setMoverecCode(BizCodeUtil.getInstance().getBizCodeDate("WYMV"));
   	    	o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   	    	o.setApplyTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
   	    	//保存并得到当前对象
   	    	rec =  propertyservicemanagerMoverecDao.save(o);
   	    	Map<String, String> replaceMap = new HashMap<String, String>();	
   	    	//获取当前用户id
   	    	String memberId=o.getMember().getMemberId();
   	        //获取当前用户对象
    		MemberInformation m=memberInformationManager.getMember(memberId);
    		//获取当前用户名字
    		String name=m.getMemberName();
    		//把名字放进短信模板中
        	replaceMap.put("#user",name);
        	//把订单编号放进短信模板中
        	replaceMap.put("#movereCode", o.getMoverecCode());
        	//0311为短信模板编号
        	McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0311", replaceMap);			
        	//mcMsgdatasManager.sendToUser(msgData, o.getMember().getMemberId());
        	try {
        		//发短信
        		mcMsgdatasManager.sendToUser(msgData, o.getMember().getMemberId());
    			//HttpSenderMsg.sendMsg(rec.getMoverecPhone(), "尊敬的用户"+rec.getMoverecName()+"你好，"
    					//+"你的搬家预约已经成功提交，预约单号为【"+rec.getMoverecCode()+"】，预约结果请留意短信通知，"
    					//+ "或进入个人中心查看处理结果，感谢你对富春硅谷的支持！");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
   		}
   		return rec;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id) throws BusException{
    	//propertyservicemanagerFxtdcManager
    	PropertyservicemanagerMoverec moverec = propertyservicemanagerMoverecDao.get(id) ;//得到搬家申请记录
    	PropertyservicemanagerFxtdc fxtdc = propertyservicemanagerFxtdcManager.getFxtdcByMoverec(moverec) ;//得到搬家申请记录对应的二维码
    	propertyservicemanagerFxtdcManager.removePropertyservicemanagerFxtdc(fxtdc.getFxtdcId());//通过id删除对应的二维码
    	propertyservicemanagerMoverecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerMoverecs(@ServiceParam(name="moverecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerMoverec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerMoverec(@ServiceParam(name="moverecId") String id)  throws BusException{
		return propertyservicemanagerMoverecDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerMoverec(String propertyName,Object value) throws BusException{
		return propertyservicemanagerMoverecDao.exists(propertyName,value);
	}
    
    /**
	 *  根据申请记录id审批
	 * @param id 搬家申请记录id
	 * @throws BusException
	 */
	@EsbServiceMapping
	public void upMovById(@ServiceParam(name="id") String id) throws BusException {
		PropertyservicemanagerMoverec moverec = propertyservicemanagerMoverecDao.get(id) ;//得到搬家申请记录
		
		if(moverec!=null){
				String status = moverec.getMoverecStatus();
				if(status.equals("00")){
					moverec.setMoverecStatus("01");
					moverec.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		    		PropertyservicemanagerFxtdc propertyservicemanagerFxtdc = new PropertyservicemanagerFxtdc() ;
		    		//设置搬家二维码状态为有效
		    		try {
		    			String imgPath = root+"qrcode/";     
		    	        String contents = moverec.getMoverecRemark();  
						String url = QRCodeUtil.encode(contents, imgPath);
						propertyservicemanagerFxtdc.setTwcrdAddrec("qrcode/"+url);
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		propertyservicemanagerFxtdc.setFxtdcStatus("00");
		        	propertyservicemanagerFxtdc.setPropertyservicemanagerMoverec(moverec);
		        	propertyservicemanagerFxtdcManager.savePropertyservicemanagerFxtdc(propertyservicemanagerFxtdc);
				}else if(status.equals("01")){//放行
					moverec.setMoverecStatus("02");
					moverec.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
				}	
				propertyservicemanagerMoverecDao.save(moverec);
	    	}else{
	    		throw new BusException("未找到记录!");
	    	}
		}

	/**
	 * 根据当前登录获取搬家放行
	 * @param o 搬家对象
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",pubProperty="userId")})
	public List<PropertyservicemanagerMoverec> getMovListforpage(PropertyservicemanagerMoverec o) throws BusException{
		//获取当前登录用户id
    	String id = o.getMember().getMemberId();
    	if(id!=null){
	    	//获取当前用户参加活动的list
	    	Collection<Condition> condition = new ArrayList<Condition>();
	    	condition.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, id));
	    	List<PropertyservicemanagerMoverec> list = propertyservicemanagerMoverecDao.commonQuery(condition, null);
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
	 * 查询搬家代码集
	 * @param o 搬家对象
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",pubProperty="userId")})
	public List<Record> getMovcodemapforpage(PropertyservicemanagerMoverec o) throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> condition =  new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"oc_way"));
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
		 * 根据当前用户分页查询    陈烨
		 * @return 分页对象
		 */
	    @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",operator=Condition.EQUALS,pubProperty="userId")})
		public PagerRecords getPagerMoverec(Pager pager,//分页条件
				@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions,//查询条件
				@OrderCollection Collection<Order> orders)
				throws BusException {
	    	PagerRecords pagerRecords = propertyservicemanagerMoverecDao.findByPager(pager, conditions, orders);
			return pagerRecords;
		}
	    /**
		 * 前台取消访客
		 * @param moverecId  陈烨
		 * @return
		 * @throws BusException
		 */
	    @EsbServiceMapping
		public PropertyservicemanagerMoverec cancelStatus(@ServiceParam(name="moverecId") String moverecId) throws BusException{
	    	PropertyservicemanagerMoverec moverec = propertyservicemanagerMoverecDao.get(moverecId);
	    	String moverecStatus=moverec.getMoverecStatus();
	    	if("00".equals(moverecStatus)){
	    		moverec.setMoverecStatus("03");//0为待审批	    		
	    	}	
	    	PropertyservicemanagerMoverec p=propertyservicemanagerMoverecDao.save(moverec);
	    	Map<String, String> replaceMap = new HashMap<String, String>();	
   	    	//获取当前用户id
   	    	String memberId=moverec.getMember().getMemberId();
   	        //获取当前用户对象
    		MemberInformation m=memberInformationManager.getMember(memberId);
    		//获取当前用户名字
    		String name=m.getMemberName();
    		//把名字放进短信模板中
        	replaceMap.put("#user",name);
        	//把订单编号放进短信模板中
        	replaceMap.put("#movereCode", moverec.getMoverecCode());
        	//0311为短信模板编号
        	McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0316", replaceMap);			
        	mcMsgdatasManager.sendToUser(msgData, moverec.getMember().getMemberId());
			return p;	    	    		    	
	    }
	    /**
	   	 * 获取已完成订单的totalCount    陈烨
	   	 * @param conditions
	   	 * @return
	   	 * @throws BusException
	   	 */
	       @EsbServiceMapping(pubConditions={@PubCondition(property="member.memberId",operator=Condition.EQUALS,pubProperty="userId")})
	   	public List<Record> getTotalCount(
	   			@ConditionCollection(domainClazz=PropertyservicemanagerMoverec.class) Collection<Condition> conditions
	   			)  throws BusException{
	   		List<Record> recordList=new ArrayList<Record>();
	   		List<PropertyservicemanagerMoverec> List = this.getPropertyservicemanagerMoverecs(conditions, null);
	   		Record record = new Record();
	   		record.put("totalCount", List.size());
	   		recordList.add(record);
	   		return recordList;
	   	}   			
}
