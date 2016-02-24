/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.dao.OrdermanagerUserorderDao;
import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.Assert;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerCharge;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSfpro;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerChargeDao;
import com.manage.PropertyServiceManager.dao.PropertyservicemanagerSfproDao;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerSfproManager;

@Service("propertyservicemanagerSfproManager")
@Transactional
public class PropertyservicemanagerSfproManagerImpl extends BaseManagerImpl implements PropertyservicemanagerSfproManager{
	@Autowired
	private PropertyservicemanagerSfproDao propertyservicemanagerSfproDao;
	@Autowired
	private PropertyservicemanagerChargeDao propertyservicemanagerChargeDao;
	@Autowired
	private OrdermanagerUserorderDao ordermanagerUserorderDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PropertyservicemanagerSfpro> getPropertyservicemanagerSfpros() throws BusException{
    	return propertyservicemanagerSfproDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PropertyservicemanagerSfpro> getPropertyservicemanagerSfpros(
    	@ConditionCollection(domainClazz=PropertyservicemanagerSfpro.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return propertyservicemanagerSfproDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PropertyservicemanagerSfpro getPropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id)  throws BusException{
    	return propertyservicemanagerSfproDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSfpros(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSfpro.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerSfproDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSfprosByCharge(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PropertyservicemanagerSfpro.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = propertyservicemanagerSfproDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//根据收费登记获取收费登记项目列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EsbServiceMapping
	public PagerRecords getPagerPropertyservicemanagerSfprosByCharge(Pager pager, 
			PropertyservicemanagerCharge psc, @OrderCollection Collection<Order> orders){
     Assert.notNull(psc, "物业缴费登记条件不能为空！");
     Assert.notNull(psc.getChargeId(), "物业缴费登记对象中chargeId不能为空！");
 
     PropertyservicemanagerCharge dbpsc = (PropertyservicemanagerCharge)this.propertyservicemanagerChargeDao.get(psc.getChargeId());
 
     Collection conditions = new ArrayList();
     conditions.add(ConditionUtils.getCondition("propertyservicemanagerCharge.chargeId", "EQUALS", dbpsc.getChargeId()));

     return this.propertyservicemanagerSfproDao.findByPager(pager, conditions, orders);
   }
	
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PropertyservicemanagerSfpro savePropertyservicemanagerSfpro(PropertyservicemanagerSfpro o) throws BusException{
//    	PropertyservicemanagerSfpro ps = new PropertyservicemanagerSfpro();
//    	PropertyservicemanagerCharge pc = new PropertyservicemanagerCharge();
//    	BigDecimal chargeAmount = BigDecimal.valueOf(0);
//    	String sfproId = o.getSfproId();
//    	boolean isUpdate = StringUtils.isNotEmpty(sfproId);
//    	if(isUpdate){//修改
//    		ps = propertyservicemanagerSfproDao.get(o.getSfproId());
//    		pc = ps.getPropertyservicemanagerCharge();
//    		chargeAmount = getChargeAmountByCharge(pc);
//    		chargeAmount = chargeAmount.subtract(ps.getSfproAmount()).add(o.getSfproAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//    		ps.setSfproAmount(o.getSfproAmount());
//    		ps.setSfproName(o.getSfproName());
//    		ps = propertyservicemanagerSfproDao.save(ps);
//    		
//    	}else{//新增
//    		if(o.getPropertyservicemanagerCharge() == null||o.getPropertyservicemanagerCharge().getChargeId() == null){
//        		throw new BusException("请选择收费登记再增加收费登记项！");
//        	}
//        	pc = propertyservicemanagerChargeDao.get(o.getPropertyservicemanagerCharge().getChargeId());
//        	chargeAmount = getChargeAmountByCharge(pc);
//    		ps = propertyservicemanagerSfproDao.save(o);
//    		chargeAmount = chargeAmount.add(o.getSfproAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
//    	}
//    	
//    	pc.setChargeAmount(chargeAmount);
//		propertyservicemanagerChargeDao.save(pc);
//		OrdermanagerUserorder userOrder = pc.getOrdermanagerUserorder();
//		userOrder.setUserorderAmount(chargeAmount);
//		ordermanagerUserorderDao.save(userOrder);
//		
//		pc = propertyservicemanagerChargeDao.save(pc);
    	return o;
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id) throws BusException{
    	propertyservicemanagerSfproDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePropertyservicemanagerSfpros(@ServiceParam(name="sfproId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePropertyservicemanagerSfpro(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPropertyservicemanagerSfpro(@ServiceParam(name="sfproId") String id)  throws BusException{
		return propertyservicemanagerSfproDao.exists(id);
	}
    
    public boolean exsitPropertyservicemanagerSfpro(String propertyName,Object value) throws BusException{
		return propertyservicemanagerSfproDao.exists(propertyName,value);
	}
    //根据收费登记获取收费登记项目金额总和
	@Override
	public BigDecimal getChargeAmountByCharge(PropertyservicemanagerCharge pc) {
		return propertyservicemanagerSfproDao.getChargeAmountByCharge(pc);
	}
	//保存物业收费登记项目
	@Override
	@EsbServiceMapping
	public void saveChargeSfpro(@ServiceParam(name="chargeId") String chargeId, @ServiceParam(name="chargeIsbool") String chargeIsbool,
			@ServiceParam(name="chargeCreatetime") String chargeCreatetime, @ServiceParam(name="chargeBedate") String chargeBedate, 
			@ServiceParam(name="chargeEndate") String chargeEndate,@DomainCollection(domainClazz=PropertyservicemanagerSfpro.class) List<PropertyservicemanagerSfpro> sfproList) {
		PropertyservicemanagerCharge pc = new PropertyservicemanagerCharge();
		BigDecimal chargeAmount = BigDecimal.valueOf(0);
		for(PropertyservicemanagerSfpro ps:sfproList){
			chargeAmount = chargeAmount.add(ps.getSfproAmount());
		}
		boolean isUpdate = StringUtils.isNotEmpty(chargeId);
		if(isUpdate){
			pc = propertyservicemanagerChargeDao.get(chargeId);
			pc.setChargeIsbool(chargeIsbool);
			pc.setChargeCreatetime(chargeCreatetime);
			pc.setChargeBedate(chargeBedate);
			pc.setChargeEndate(chargeEndate);
			propertyservicemanagerChargeDao.save(pc);
			for(PropertyservicemanagerSfpro ps:sfproList){
				PropertyservicemanagerSfpro pss = propertyservicemanagerSfproDao.get(ps.getSfproId());
				pss.setSfproAmount(ps.getSfproAmount());
				pss.setSfproName(ps.getSfproName());
				propertyservicemanagerSfproDao.save(pss);
			}
			OrdermanagerUserorder userOrder = pc.getOrdermanagerUserorder();
			userOrder.setUserorderAmount(chargeAmount);
			ordermanagerUserorderDao.save(userOrder);
		}else{
			OrdermanagerUserorder userOrder = new OrdermanagerUserorder();
    		userOrder.setUserorderAmount(chargeAmount);
    		userOrder.setUserorderCode("123");
    		userOrder = ordermanagerUserorderDao.save(userOrder);
    		pc.setOrdermanagerUserorder(userOrder);
			pc.setChargeAmount(chargeAmount);
			pc.setChargeIsbool(chargeIsbool);
			pc.setChargeCreatetime(chargeCreatetime);
			pc.setChargeBedate(chargeBedate);
			pc.setChargeEndate(chargeEndate);
			pc = propertyservicemanagerChargeDao.save(pc);
			for(PropertyservicemanagerSfpro ps:sfproList){
				ps.setPropertyservicemanagerCharge(pc);
				propertyservicemanagerSfproDao.save(ps);
			}
		}
		// TODO Auto-generated method stub
	}

}
