/**
 * 代码声明
 */
package com.member.ticket.service.impl;

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

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.member.ticket.entity.RefundOrder;
import com.member.ticket.dao.RefundOrderDao;
import com.member.ticket.service.RefundOrderManager;

@Service("refundOrderManager")
@Transactional
public class RefundOrderManagerImpl extends BaseManagerImpl implements RefundOrderManager{
	@Autowired
	private RefundOrderDao refundOrderDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<RefundOrder> getRefundOrders() throws BusException{
    	return refundOrderDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<RefundOrder> getRefundOrders(
    	@ConditionCollection(domainClazz=RefundOrder.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return refundOrderDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public RefundOrder getRefundOrder(@ServiceParam(name="orderId") String id)  throws BusException{
    	return refundOrderDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerRefundOrders(Pager pager,//分页条件
			@ConditionCollection(domainClazz=RefundOrder.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = refundOrderDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public RefundOrder saveRefundOrder(RefundOrder o) throws BusException{
//    	String refundOrderId = o.getRefundOrderId();
//    	boolean isUpdate = StringUtils.isNotEmpty(refundOrderId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return refundOrderDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeRefundOrder(@ServiceParam(name="orderId") String id) throws BusException{
    	refundOrderDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeRefundOrders(@ServiceParam(name="orderId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeRefundOrder(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitRefundOrder(@ServiceParam(name="orderId") String id)  throws BusException{
		return refundOrderDao.exists(id);
	}
    
    public boolean exsitRefundOrder(String propertyName,Object value) throws BusException{
		return refundOrderDao.exists(propertyName,value);
	}

}
