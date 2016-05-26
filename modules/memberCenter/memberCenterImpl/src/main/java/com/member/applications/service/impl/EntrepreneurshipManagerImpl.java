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

import com.common.CodeManager.service.CodeManager;
import com.common.MemberManager.dao.MemberInformationDao;
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
import com.gsoft.utils.BizCodeUtil;
import com.member.applications.dao.EntrepreneurshipDao;
import com.member.applications.entity.Entrepreneurship;
import com.member.applications.service.EntrepreneurshipManager;

@Service("entrepreneurshipManager")
@Transactional
public class EntrepreneurshipManagerImpl extends BaseManagerImpl implements EntrepreneurshipManager{
	@Autowired
	private EntrepreneurshipDao entrepreneurshipDao;
	@Autowired 
	private CodeitemManager codeitemManager;
	@Autowired
	private MemberInformationDao memberInformationDao;
	@Autowired
	private CodeManager codeManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<Entrepreneurship> getEntrepreneurships() throws BusException{
    	return entrepreneurshipDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<Entrepreneurship> getEntrepreneurships(
    	@ConditionCollection(domainClazz=Entrepreneurship.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return entrepreneurshipDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public Entrepreneurship getEntrepreneurship(@ServiceParam(name="id") String id)  throws BusException{
    	return entrepreneurshipDao.get(id);
    }
	
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public PagerRecords getPagerEntrepreneurships(Pager pager,//分页条件
			@ConditionCollection(domainClazz=Entrepreneurship.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException, ParseException{
		PagerRecords pagerRecords = entrepreneurshipDao.findByPager(pager, conditions, orders);
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化时间跟用户名查找
		for(int i=0;i<pagerRecords.getRecords().size();i++){
			Entrepreneurship entrepreneurship= (Entrepreneurship) pagerRecords.getRecords().get(i);
			//项目类型的代码集名称重新给值
			Codeitem codeitem = codeManager.getCodeitem("projectType", entrepreneurship.getProjectType());
			if(null!=codeitem){
				entrepreneurship.setProjectTypeName(codeitem.getItemCaption());
			}
			//变换时间格式
			String createTime = sdf.format(sdf.parse(entrepreneurship.getCreateTime())).toString();
			entrepreneurship.setCreateTime(createTime);
			//根据memberId获取用户名
			String memberId = entrepreneurship.getMemberId();
			MemberInformation memberInformation  = memberInformationDao.get(memberId);
			entrepreneurship.setMember(memberInformation);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public Entrepreneurship saveEntrepreneurship(Entrepreneurship o) throws BusException{
//    	String entrepreneurshipId = o.getEntrepreneurshipId();
//    	boolean isUpdate = StringUtils.isNotEmpty(entrepreneurshipId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return entrepreneurshipDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEntrepreneurship(@ServiceParam(name="id") String id) throws BusException{
    	entrepreneurshipDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEntrepreneurships(@ServiceParam(name="id") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEntrepreneurship(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEntrepreneurship(@ServiceParam(name="id") String id)  throws BusException{
		return entrepreneurshipDao.exists(id);
	}
    
    public boolean exsitEntrepreneurship(String propertyName,Object value) throws BusException{
		return entrepreneurshipDao.exists(propertyName,value);
	}

    /**
	 * 根据代码集查找创业加速计划项目类型
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<Record> getProjectType() throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> condition =  new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"projectType"));
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
	 * 是否融资代码集查询(0:是;1:否)
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<Record> getBool() throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> condition =  new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"bool"));
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
	 * 导师类型代码集查询
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping
	public List<Record> getTeacherType() throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		Collection<Condition> condition =  new ArrayList<Condition>();
		Collection<Order> order = new ArrayList<Order>();
		condition.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS,"teacherType"));
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
	 * 保存创业加速计划的申请
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "createUser", pubProperty = "userId"),@PubCondition(property = "memberId", pubProperty = "userId")})
	public Entrepreneurship goSaveEntrepreneurship(Entrepreneurship o,@ServiceParam(name="teacherTypeFlg") String teacherTypeFlg)  throws BusException{
		//通过导师选择的类型判断属于选择还是自定义(0:选择;1:自定义)
		if(!"0".equals(teacherTypeFlg)){
			//自定义的场合
			o.setDefineTeacherType(o.getTeacherType());
			o.setTeacherType("05");
		}
		//申请状态
		o.setApplayStatus("01");
		//申请编号
		String applayNo = BizCodeUtil.getInstance().getBizCodeDate("JSSQ");
		o.setApplayNo(applayNo);
		//创建时间
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		//创建返回保存成功返回的实体
		Entrepreneurship saveEntrepreneurship = this.saveEntrepreneurship(o);
		//构建替换模板参数对应的map
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
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0322", replaceMap);  
		//发短信给用户
		mcMsgdatasManager.sendToUser(msgData, memberId);
		return saveEntrepreneurship;
	}
	
	/**
	 * 获取整个数据的totalCount
	 */
	@EsbServiceMapping(pubConditions={@PubCondition(property="memberId",operator=Condition.EQUALS,pubProperty="userId")})
	public List<Record> getTotalCount(
			@ConditionCollection(domainClazz=Entrepreneurship.class) Collection<Condition> conditions)  throws BusException{
		List<Record> recordList=new ArrayList<Record>();
		List<Entrepreneurship> entrepreneurshipsList = this.getEntrepreneurships(conditions, null);
		Record record = new Record();
		record.put("totalCount", entrepreneurshipsList.size());
		recordList.add(record);
		return recordList;
	}
	
	 /**
     * 取消操作
     */
    @EsbServiceMapping
    public Entrepreneurship goCancel(@ServiceParam(name="id") String id) throws BusException{
    	//获取加速申请的信息
    	Entrepreneurship entrepreneurship = this.getEntrepreneurship(id);
    	//更改申请标识为03：取消
    	entrepreneurship.setApplayStatus("03");
    	//构建替换模板参数对应的map
    	Map<String, String> replaceMap = new HashMap<String, String>();
		//获取当前用户id
		String memberId =entrepreneurship.getMemberId();
		//获取当前用户对象
		MemberInformation m=memberInformationManager.getMemberInformation(memberId);
		//获取当前用户名字放入replaceMap中
		replaceMap.put("#user", m.getMemberPhoneNumber());
		//获取当前订单号放入replaceMap中
		replaceMap.put("#applayNo", entrepreneurship.getApplayNo());
		//构建短信       0308为短信模板编号
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData("0323", replaceMap);  
		//发短信给用户
		mcMsgdatasManager.sendToUser(msgData, memberId);
    	return entrepreneurshipDao.save(entrepreneurship);
    }
    
    /**
     * 替换后台数据列表中的导师类型
     */
    @EsbServiceMapping
    public String getTeacherTypeName(@ServiceParam(name="id") String id) throws BusException{
    	String teacherTypeName = "";
    	//获取加速申请的信息
    	Entrepreneurship entrepreneurship = this.getEntrepreneurship(id);
    	//判断当前记录的导师类型是否是自定义  05
    	if("05".equals(entrepreneurship.getTeacherType())){
    		teacherTypeName = entrepreneurship.getDefineTeacherType();
    	}else{
    		//项目类型的代码集名称重新给值
			Codeitem codeitem = codeManager.getCodeitem("teacherType", entrepreneurship.getTeacherType());
			if(null!=codeitem){
				teacherTypeName = codeitem.getItemCaption();
			}
    	}
    	return teacherTypeName;
    }
}
