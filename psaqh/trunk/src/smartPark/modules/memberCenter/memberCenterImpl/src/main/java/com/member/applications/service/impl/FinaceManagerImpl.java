/**
 * 代码声明
 */
package com.member.applications.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.BizCodeUtil;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.member.applications.dao.FinaceDao;
import com.member.applications.entity.Finace;
import com.member.applications.service.FinaceManager;

@Service("finaceManager")
@Transactional
public class FinaceManagerImpl extends BaseManagerImpl implements FinaceManager{
	@Autowired
	private FinaceDao finaceDao;
	@Autowired
	private EnterbusinessmanagerRzDao enterbusinessmanagerRzDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Finace> getFinaces() throws BusException{
    	return finaceDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Finace> getFinaces(
    	@ConditionCollection(domainClazz=Finace.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return finaceDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Finace getFinace(@ServiceParam(name="id") String id)  throws BusException{
    	return finaceDao.get(id);
    }
	
    @EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerFinaces(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Finace.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException, ParseException{
		PagerRecords pagerRecords = finaceDao.findByPager(pager, conditions, orders);
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化时间跟用户名查找
		for(int i=0;i<pagerRecords.getRecords().size();i++){
			Finace finace= (Finace) pagerRecords.getRecords().get(i);
			//变换时间格式
			String createTime = sdf.format(sdf.parse(finace.getCreateTime())).toString();
			finace.setCreateTime(createTime);
			//根据memberId获取用户名
			String memberId = finace.getMemberId();
			MemberInformation memberInformation  = memberInformationDao.get(memberId);
			finace.setMember(memberInformation);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public Finace saveFinace(Finace o) throws BusException{
//    	String finaceId = o.getFinaceId();
//    	boolean isUpdate = StringUtils.isNotEmpty(finaceId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return finaceDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeFinace(@ServiceParam(name="id") String id) throws BusException{
    	finaceDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeFinaces(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeFinace(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitFinace(@ServiceParam(name="id") String id)  throws BusException{
		return finaceDao.exists(id);
	}
    
    public boolean exsitFinace(String propertyName,Object value) throws BusException{
		return finaceDao.exists(propertyName,value);
	}

    /**
   	 * 融资申请页面加载开始获取公司名称和主页地址
   	 * 根据登录信息里面的企业ID进行查找
   	 * @return
   	 * @throws BusException
   	 */
   	@EsbServiceMapping
   	public List<Map<String,String>> getCompanyData(@ServiceParam(name="userId",pubProperty="userId") String userId)  throws BusException{
   		List<Map<String,String>> reListMap = new ArrayList<Map<String,String>>();
   		Map<String,String> reMap = new HashMap<String,String>();
   		//根据用户ID查询自己相关的企业
   		MemberInformation  memberInformation = memberInformationDao.get(userId);
   		String companyId = memberInformation.getCompanyId();
   		//判断此个用户是否存在企业
   		if(StringUtils.isNotEmpty(companyId)){
   			//根据企业ID进行查找相关的企业信息
   			EnterbusinessmanagerRz enterbusinessmanagerRz = enterbusinessmanagerRzDao.get(companyId);
   			//查找的企业信息不为空的情况，开始返回数据的封装
   			if(null!=enterbusinessmanagerRz){
   				//公司名称
   				reMap.put("rzName", enterbusinessmanagerRz.getRzName());
   				//主页地址
   				reMap.put("rzUrl", enterbusinessmanagerRz.getRzUrl());
   				reListMap.add(reMap);
   			}
   		}
   		return reListMap;
   	}
   	
    /**
	 * 融资申请
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "memberId", pubProperty = "userId"),@PubCondition(property = "memberId", pubProperty = "userId")})
	public Finace goSaveFinace(Finace o)  throws BusException{
		//创建时间
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		//申请状态
		o.setApplayStatus("01");
		//申请编号
		String applayNo = BizCodeUtil.getInstance().getBizCodeDate("RZSQ");
		o.setApplayNo(applayNo);	
		Map<String, String> replaceMap = new HashMap<String, String>();
		//获取当前用户id
		String memberId =o.getMemberId();
		//获取当前用户对象
		MemberInformation m=memberInformationManager.getMemberInformation(memberId);
		//获取当前用户名字放入replaceMap中
		replaceMap.put("#user", m.getMemberPhoneNumber());
		//获取当前订单号放入replaceMap中
		replaceMap.put("#applayNo", o.getApplayNo());
		//构建短信       0308为短信模板编号
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0320", replaceMap);  
		//发短信给用户
		mcMsgdatasManager.sendToUser(msgData, memberId);
		//创建返回保存成功返回的实体
		Finace saveFinace = this.saveFinace(o);
		return saveFinace;
	}
	
	/**
	 * 获取整个数据的totalCount
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
			@ConditionCollection(domainClazz=Finace.class) Collection<Condition> conditions)  throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		List<Finace> finaceList = this.getFinaces(conditions, null);
		Record record = new Record();
		record.put("totalCount", finaceList.size());
		recordList.add(record);
		return recordList;
	}
	
	 /**
     * 取消操作
     */
    @EsbServiceMapping
    public Finace goCancel(@ServiceParam(name="id") String id) throws BusException{
    	//获取融资申请的信息
    	Finace finace = this.getFinace(id);
    	//更改申请标识为03：取消
    	finace.setApplayStatus("03");
    	Map<String, String> replaceMap = new HashMap<String, String>();
		//获取当前用户id
		String memberId =finace.getMemberId();
		//获取当前用户对象
		MemberInformation m=memberInformationManager.getMemberInformation(memberId);
		//获取当前用户名字放入replaceMap中
		replaceMap.put("#user", m.getMemberPhoneNumber());
		//获取当前订单号放入replaceMap中
		replaceMap.put("#applayNo", finace.getApplayNo());
		//构建短信       0308为短信模板编号
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0321", replaceMap);  
		//发短信给用户
		mcMsgdatasManager.sendToUser(msgData, memberId);
    	return finaceDao.save(finace);
    }
}
