/**
 * 代码声明
 */
package com.common.OrderManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.service.OrdermanagerUserorderManager;

@Service("ordermanagerUserorderManager")
@Transactional
public class OrdermanagerUserorderManagerImpl extends BaseManagerImpl implements OrdermanagerUserorderManager{
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders() throws BusException{
    	return ordermanagerUserorderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerUserorder> getOrdermanagerUserorders(
    	@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerUserorderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerUserorder getOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
    	return ordermanagerUserorderDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerUserorders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	/**
	 * 获取企业服务订单列表
	 */
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerComSerOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerUserorder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("ordermanagerOrdertype.ordertypeId", Condition.LIKE, "05"));
		PagerRecords pagerRecords = ordermanagerUserorderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerUserorder saveOrdermanagerUserorder(OrdermanagerUserorder o) throws BusException{
//    	String ordermanagerUserorderId = o.getOrdermanagerUserorderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerUserorderDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerUserorder(@ServiceParam(name="userorderId") String id) throws BusException{
    	ordermanagerUserorderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerUserorders(@ServiceParam(name="userorderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerUserorder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerUserorder(@ServiceParam(name="userorderId") String id)  throws BusException{
		return ordermanagerUserorderDao.exists(id);
	}
    
    public boolean exsitOrdermanagerUserorder(String propertyName,Object value) throws BusException{
		return ordermanagerUserorderDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping
	public void updateUserorderStatus(@ServiceParam(name="userorderId") String id, @ServiceParam(name="userorderStatus") String userorderStatus)
			throws BusException {
		// TODO Auto-generated method stub
    	OrdermanagerUserorder o=ordermanagerUserorderDao.get(id);
    	o.setUserorderStatus(userorderStatus);
    	ordermanagerUserorderDao.save(o);
	}
    /**
     * 保存或修改采购订单
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "params.userId")})
	public OrdermanagerUserorder savePurOrdermanager(OrdermanagerUserorder o)
			throws BusException {
		//获取采购订单类型对象
		
    	String ordermanagerUserorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder purOrder = ordermanagerUserorderDao.get(ordermanagerUserorderId);
//    		purOrder.setOrdermanagerOrdertype(oot);
    		purOrder.setUserorderProject(o.getUserorderProject());
    		purOrder.setUserorderAmount(o.getUserorderAmount());
    		purOrder.setUserorderStatus(o.getUserorderStatus());
    		purOrder.setUserorderPayMode(o.getUserorderPayMode());
    		purOrder.setUserorderTime(o.getUserorderTime());
    		purOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		purOrder.setUpdateUser(o.getUpdateUser());
    		return ordermanagerUserorderDao.save(purOrder);
    	}else{//新增
//    		o.setOrdermanagerOrdertype(oot);
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		if(o.getUpdateUser() != null){
    			MemberInformation mem = memberInformationDao.get(o.getUpdateUser()); //获取当前登录用户
        		o.setUserorderBuyUser(mem.getMemberName());
    		}
    		o.setMemberId(o.getUpdateUser());
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(o);
    	}
	}
	/**
     * 保存或修改餐饮订单
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "params.userId")})
	public OrdermanagerUserorder saveFoodOrdermanager(OrdermanagerUserorder o)
			throws BusException {
		//获取餐饮订单类型对象
		
    	String ordermanagerUserorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder purOrder = ordermanagerUserorderDao.get(ordermanagerUserorderId);
//    		purOrder.setOrdermanagerOrdertype(oot);
    		purOrder.setUserorderProject(o.getUserorderProject());
    		purOrder.setUserorderAmount(o.getUserorderAmount());
    		purOrder.setUserorderStatus(o.getUserorderStatus());
    		purOrder.setUserorderPayMode(o.getUserorderPayMode());
    		purOrder.setUserorderTime(o.getUserorderTime());
    		purOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		purOrder.setUpdateUser(o.getUpdateUser());
    		return ordermanagerUserorderDao.save(purOrder);
    	}else{//新增
//    		o.setOrdermanagerOrdertype(oot);
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
    		if(o.getUpdateUser() != null){
    			MemberInformation mem = memberInformationDao.get(o.getUpdateUser()); //获取当前登录用户
    			o.setUserorderBuyUser(mem.getMemberName());
    		}
    		o.setMemberId(o.getUpdateUser());
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(o);
    	}
	}
	/**
     * 保存或修改企业服务订单
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "params.userId")})
	public OrdermanagerUserorder saveCompSerOrderMg(OrdermanagerUserorder o)
			throws BusException {
		//获取企业订单类型对象
		
    	String ordermanagerUserorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder purOrder = ordermanagerUserorderDao.get(ordermanagerUserorderId);
//    		purOrder.setOrdermanagerOrdertype(oot);
    		purOrder.setUserorderProject(o.getUserorderProject());
    		purOrder.setUserorderAmount(o.getUserorderAmount());
    		purOrder.setUserorderStatus(o.getUserorderStatus());
    		purOrder.setUserorderPayMode(o.getUserorderPayMode());
    		purOrder.setUserorderTime(o.getUserorderTime());
    		purOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		purOrder.setUpdateUser(o.getUpdateUser());
    		return ordermanagerUserorderDao.save(purOrder);
    	}else{//新增
//    		o.setOrdermanagerOrdertype(oot);
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
    		if(o.getUpdateUser() != null){
    			MemberInformation mem = memberInformationDao.get(o.getUpdateUser()); //获取当前登录用户
    			o.setUserorderBuyUser(mem.getMemberName());
    		}
    		o.setMemberId(o.getUpdateUser());
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(o);
    	}
	}
	/**
     * 保存或修改IT服务订单
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
	public OrdermanagerUserorder saveITSerOrderMg(OrdermanagerUserorder o)
			throws BusException {
		//获取IT服务订单类型对象
		
    	String ordermanagerUserorderId = o.getUserorderId();
    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerUserorderId);
    	if(isUpdate){//修改
    		OrdermanagerUserorder purOrder = ordermanagerUserorderDao.get(ordermanagerUserorderId);
//    		purOrder.setOrdermanagerOrdertype(oot);
    		purOrder.setUserorderProject(o.getUserorderProject());
    		purOrder.setUserorderAmount(o.getUserorderAmount());
    		purOrder.setUserorderStatus(o.getUserorderStatus());
    		purOrder.setUserorderPayMode(o.getUserorderPayMode());
    		purOrder.setUserorderTime(o.getUserorderTime());
    		purOrder.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		purOrder.setUpdateUser(o.getUpdateUser());
    		return ordermanagerUserorderDao.save(purOrder);
    	}else{//新增
//    		o.setOrdermanagerOrdertype(oot);
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUserorderCode(BizCodeUtil.getInstance().getBizCodeDate("CG"));
    		if(o.getUpdateUser() != null){
    			MemberInformation mem = memberInformationDao.get(o.getUpdateUser()); //获取当前登录用户
    			o.setUserorderBuyUser(mem.getMemberName());
    		}
    		o.setMemberId(o.getUpdateUser());
    		o.setUserorderTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return ordermanagerUserorderDao.save(o);
    	}
	}
}
