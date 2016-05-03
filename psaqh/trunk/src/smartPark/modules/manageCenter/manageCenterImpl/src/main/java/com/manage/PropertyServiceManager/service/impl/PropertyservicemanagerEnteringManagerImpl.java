/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.codemap.dao.CodeitemDao;
import com.gsoft.framework.codemap.entity.Codeitem;
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
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerBx;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntering;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerTs;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerEnteringDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEnteringManager;

@Service("propertyservicemanagerEnteringManager")
@Transactional
public class PropertyservicemanagerEnteringManagerImpl extends BaseManagerImpl implements PropertyservicemanagerEnteringManager{
	@Autowired
	private PropertyservicemanagerEnteringDao propertyservicemanagerEnteringDao;
	@Autowired
	private CodeitemDao<Codeitem, String> codeItemDao;
	
	@Autowired
	private MemberInformationManager memberInformationManager;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings() throws BusException{
    	return propertyservicemanagerEnteringDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerEntering> getPropertyservicemanagerEnterings(
    	@ConditionCollection(domainClazz=PropertyservicemanagerEntering.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerEnteringDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerEntering getPropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id)  throws BusException{
    	return propertyservicemanagerEnteringDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerEnterings(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntering.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerEnteringDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
    /**
     * 查询所有可以预约的预约记录
     */
	@EsbServiceMapping
	public PagerRecords getPropertyservicemanagerEnteringsByStatus(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerEntering.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("enteringStatus",Condition.EQUALS, "01"));// 查询所有可以预约的预约记录
		PagerRecords pagerRecords = propertyservicemanagerEnteringDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public void savePropertyservicemanagerEntering(PropertyservicemanagerEntering o) throws BusException{
    	String enteringId = o.getEnteringId();
    	boolean isUpdate = StringUtils.isNotEmpty(enteringId);
    	if(isUpdate){//修改
    		PropertyservicemanagerEntering p=propertyservicemanagerEnteringDao.get(enteringId);
    		if(StringUtils.isNotEmpty(o.getEnteringDate())){
    			//判断预约日期是否变更，若不变更，不需要判断日期重复性问题
    			if(p.getEnteringDate().equals(o.getEnteringDate())){
    				p.setEnteringDate(o.getEnteringDate());
    				p.setEnteringSum(o.getEnteringSum());
    				p.setUpdateUser(o.getUpdateUser());
    				p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				propertyservicemanagerEnteringDao.save(o);
    			}else if(propertyservicemanagerEnteringDao.exists("enteringDate",o.getEnteringDate())){
    				//若变更，则需要判断日期重复性问题，重复则抛异常，不重复则新增
    				throw new BusException("该预约日期已经添加,无需重复添加！");
    			}else{
    				p.setEnteringDate(o.getEnteringDate());
    				p.setEnteringSum(o.getEnteringSum());
    				p.setUpdateUser(o.getUpdateUser());
    				p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    				propertyservicemanagerEnteringDao.save(o);
    			}
    		}
    		
    	}else{//新增
    		//判断预约日期是否重复
    		if(StringUtils.isNotEmpty(o.getEnteringDate())){
    			if(propertyservicemanagerEnteringDao.exists("enteringDate",o.getEnteringDate())){
    				throw new BusException("该预约日期已经添加,无需重复添加！");
    			}else{
    				List<PropertyservicemanagerEntering> enteringList=new ArrayList<PropertyservicemanagerEntering> ();
    	    		o.setEnteringTime("AM");//时段AM： 9:00-11:00
    	    		o.setEnteringStatus("01");//01:可以预约
    	    		o.setCreateUser(o.getUpdateUser());
    	    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		enteringList.add(o);
    	    		PropertyservicemanagerEntering p=new PropertyservicemanagerEntering();
    	    		p.setEnteringAlre(o.getEnteringAlre());
    	    		p.setEnteringRemain(o.getEnteringRemain());
    	    		p.setEnteringSum(o.getEnteringSum());
    	    		p.setEnteringDate(o.getEnteringDate());
    	    		p.setEnteringTime("PM");//时段PM： 14:00-17:00
    	    		p.setEnteringStatus("01");//01:可以预约
    	    		p.setCreateUser(o.getUpdateUser());
    	    		p.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		enteringList.add(p);
    	    		propertyservicemanagerEnteringDao.save(enteringList);
    			}
    		}
    	}
    	
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id) throws BusException{
    	propertyservicemanagerEnteringDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerEnterings(@ServiceParam(name="enteringId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerEntering(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerEntering(@ServiceParam(name="enteringId") String id)  throws BusException{
		return propertyservicemanagerEnteringDao.exists(id);
	}
    
    @EsbServiceMapping
    public TempDemo exsitPropertyservicemanagerEnteringForDate(@ServiceParam(name="propertyName") String propertyName,@ServiceParam(name="value")String value) throws BusException{
		
    	TempDemo temp=new TempDemo();
    	boolean existFlag=propertyservicemanagerEnteringDao.exists(propertyName,value);
    	temp.setBuff(String.valueOf(existFlag));
    	return temp;
		
	}
    
    /**
  	 * 批量新增可办理预约记录
  	 * @param listEntering 可办理预约记录
  	 */
    @EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public void saveListEntering(@DomainCollection(domainClazz=PropertyservicemanagerEntering.class) List<PropertyservicemanagerEntering> listEntering) {

    	//保存可办理预约记录
    	for(PropertyservicemanagerEntering entering : listEntering){
    		if(StringUtils.isNotEmpty(entering.getEnteringDate())){
    			if(propertyservicemanagerEnteringDao.exists("enteringDate",entering.getEnteringDate())){
    				throw new BusException("该预约日期已经添加,无需重复添加！");
    			}else{
    				List<PropertyservicemanagerEntering> enteringList=new ArrayList<PropertyservicemanagerEntering> ();
    	    		entering.setEnteringAlre("0");
    	    		entering.setEnteringRemain(entering.getEnteringSum());
    	    		entering.setEnteringStatus("01");//预约状态
    	    		entering.setEnteringTime("AM");//时段AM： 9:00-11:00
    	    		entering.setCreateUser(entering.getUpdateUser());
    	    		entering.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		entering.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		enteringList.add(entering);
    	    		
    	    		PropertyservicemanagerEntering p=new PropertyservicemanagerEntering();
    	    		p.setEnteringSum(entering.getEnteringSum());//下午预约总量
    	    		p.setEnteringAlre("0");
    	    		p.setEnteringRemain(entering.getEnteringSum());
    	    		p.setEnteringDate(entering.getEnteringDate());
    	    		p.setEnteringTime("PM");//时段PM： 14:00-17:00
    	    		p.setEnteringStatus("01");//01:可以预约
    	    		p.setCreateUser(entering.getUpdateUser());
    	    		p.setUpdateUser(entering.getUpdateUser());
    	    		p.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		p.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    	    		enteringList.add(p);
    	    		propertyservicemanagerEnteringDao.save(enteringList);
    			}
    		}else{
    			throw new BusException("请选择预约日期！");
    		}
    	}

    }
    
    /**
	 * 前台展示可办理预约记录
	 */
    @EsbServiceMapping
    public List<Record> getEnteringList(Pager pager,@ServiceParam(name="userId",pubProperty = "userId") String userId)  throws BusException{
		
    	List<Record> enteringValueList=new ArrayList<Record>();
    	Collection<Condition> conditions =new ArrayList<Condition>();
    	Collection<Order> orders =new ArrayList<Order>();
    	String now=DateUtils.getToday();
    	pager.setPageSize(12);
    	orders.add(ConditionUtils.getOrder("enteringDate", true));
    	conditions.add(ConditionUtils.getCondition("enteringDate", Condition.RIGHT,now));
    	PagerRecords pagerRecords = propertyservicemanagerEnteringDao.findByPager(pager, conditions, orders);
    	String total=String.valueOf(pagerRecords.getTotalCount());
		List<PropertyservicemanagerEntering> enteringList = (List<PropertyservicemanagerEntering>)pagerRecords.getRecords();
    	List<PropertyservicemanagerEntering> enteringLists=new ArrayList<PropertyservicemanagerEntering>();
    	
    	//获取当前用户信息
    	MemberInformation mem=new MemberInformation();
    	if(StringUtils.isNotEmpty(userId) && userId !=null){
    		mem=memberInformationManager.getMemberInformation(userId);
    	}
    	
    	if(enteringList.size()>0){
    		for(PropertyservicemanagerEntering pe:enteringList){
        		if(pe.getEnteringTime().equals("AM")){
        			Record record = new Record();
        			record.put("enteringId",pe.getEnteringId());//ID
        			record.put("enteringDate",pe.getEnteringDate());
        			record.put("enteringTime",pe.getEnteringTime());
        			record.put("enteringRemain",pe.getEnteringRemain());//剩余预约数量
        			record.put("enteringAlre",pe.getEnteringAlre());//已预约数量
        			List<Codeitem> list = codeItemDao.getList(new String[] {"codemap.code", "itemValue" }, new Object[] { "enteringStatus",pe.getEnteringStatus()});
        			record.put("enteringStatus",pe.getEnteringStatus());
        			record.put("enteringStatusName",list.size()>0?list.get(0).getItemCaption():"");
        			record.put("total",total);
        			record.put("memName",mem !=null?mem.getMemberName():"");
        			record.put("memPhone",mem !=null?mem.getMemberPhoneNumber():"");
        			enteringValueList.add(record);
        		}else{
        			enteringLists.add(pe);
        		}
        	}
    	}else{
    		Record record = new Record();
			record.put("memName",mem !=null?mem.getMemberName():"");
			record.put("memPhone",mem !=null?mem.getMemberPhoneNumber():"");
			enteringValueList.add(record);
    	}
    	
    	for(PropertyservicemanagerEntering pe:enteringLists){
    		Record record = new Record();
			record.put("enteringId",pe.getEnteringId());//ID
			record.put("enteringRemain",pe.getEnteringRemain());//剩余预约数量
			record.put("enteringAlre",pe.getEnteringAlre());//已预约数量
			record.put("enteringTime",pe.getEnteringTime());
			record.put("total",total);
			List<Codeitem> list = codeItemDao.getList(new String[] {"codemap.code", "itemValue" }, new Object[] { "enteringStatus",pe.getEnteringStatus()});
			record.put("enteringStatus",pe.getEnteringStatus());
			record.put("enteringStatusName",list.size()>0?list.get(0).getItemCaption():"");
			record.put("memName",mem !=null?mem.getMemberName():"");
			record.put("memPhone",mem !=null?mem.getMemberPhoneNumber():"");
			enteringValueList.add(record);
    	}
    	return enteringValueList;
    }
    


}
