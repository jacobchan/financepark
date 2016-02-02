/**
 * 代码声明
 */
package com.common.PayManager.service.impl;

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

import com.common.PayManager.entity.PaymanagerOrdrePayflow;
import com.common.PayManager.dao.PaymanagerOrdrePayflowDao;
import com.common.PayManager.service.PaymanagerOrdrePayflowManager;

@Service("paymanagerOrdrePayflowManager")
@Transactional
public class PaymanagerOrdrePayflowManagerImpl extends BaseManagerImpl implements PaymanagerOrdrePayflowManager{
	@Autowired
	private PaymanagerOrdrePayflowDao paymanagerOrdrePayflowDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PaymanagerOrdrePayflow> getPaymanagerOrdrePayflows() throws BusException{
    	return paymanagerOrdrePayflowDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PaymanagerOrdrePayflow> getPaymanagerOrdrePayflows(
    	@ConditionCollection(domainClazz=PaymanagerOrdrePayflow.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return paymanagerOrdrePayflowDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PaymanagerOrdrePayflow getPaymanagerOrdrePayflow(@ServiceParam(name="orderPayflowId") String id)  throws BusException{
    	return paymanagerOrdrePayflowDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPaymanagerOrdrePayflows(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PaymanagerOrdrePayflow.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = paymanagerOrdrePayflowDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PaymanagerOrdrePayflow savePaymanagerOrdrePayflow(PaymanagerOrdrePayflow o) throws BusException{
//    	String paymanagerOrdrePayflowId = o.getPaymanagerOrdrePayflowId();
//    	boolean isUpdate = StringUtils.isNotEmpty(paymanagerOrdrePayflowId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return paymanagerOrdrePayflowDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePaymanagerOrdrePayflow(@ServiceParam(name="orderPayflowId") String id) throws BusException{
    	paymanagerOrdrePayflowDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePaymanagerOrdrePayflows(@ServiceParam(name="orderPayflowId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePaymanagerOrdrePayflow(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPaymanagerOrdrePayflow(@ServiceParam(name="orderPayflowId") String id)  throws BusException{
		return paymanagerOrdrePayflowDao.exists(id);
	}
    
    public boolean exsitPaymanagerOrdrePayflow(String propertyName,Object value) throws BusException{
		return paymanagerOrdrePayflowDao.exists(propertyName,value);
	}

}
