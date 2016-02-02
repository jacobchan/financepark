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

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.common.OrderManager.entity.OrdermanagerCommoditydetail;
import com.common.OrderManager.dao.OrdermanagerCommoditydetailDao;
import com.common.OrderManager.service.OrdermanagerCommoditydetailManager;

@Service("ordermanagerCommoditydetailManager")
@Transactional
public class OrdermanagerCommoditydetailManagerImpl extends BaseManagerImpl implements OrdermanagerCommoditydetailManager{
	@Autowired
	private OrdermanagerCommoditydetailDao ordermanagerCommoditydetailDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<OrdermanagerCommoditydetail> getOrdermanagerCommoditydetails() throws BusException{
    	return ordermanagerCommoditydetailDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<OrdermanagerCommoditydetail> getOrdermanagerCommoditydetails(
    	@ConditionCollection(domainClazz=OrdermanagerCommoditydetail.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return ordermanagerCommoditydetailDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public OrdermanagerCommoditydetail getOrdermanagerCommoditydetail(@ServiceParam(name="commoditydetailId") String id)  throws BusException{
    	return ordermanagerCommoditydetailDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerOrdermanagerCommoditydetails(Pager pager,//分页条件
			@ConditionCollection(domainClazz=OrdermanagerCommoditydetail.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = ordermanagerCommoditydetailDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public OrdermanagerCommoditydetail saveOrdermanagerCommoditydetail(OrdermanagerCommoditydetail o) throws BusException{
//    	String ordermanagerCommoditydetailId = o.getOrdermanagerCommoditydetailId();
//    	boolean isUpdate = StringUtils.isNotEmpty(ordermanagerCommoditydetailId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return ordermanagerCommoditydetailDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeOrdermanagerCommoditydetail(@ServiceParam(name="commoditydetailId") String id) throws BusException{
    	ordermanagerCommoditydetailDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeOrdermanagerCommoditydetails(@ServiceParam(name="commoditydetailId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeOrdermanagerCommoditydetail(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitOrdermanagerCommoditydetail(@ServiceParam(name="commoditydetailId") String id)  throws BusException{
		return ordermanagerCommoditydetailDao.exists(id);
	}
    
    public boolean exsitOrdermanagerCommoditydetail(String propertyName,Object value) throws BusException{
		return ordermanagerCommoditydetailDao.exists(propertyName,value);
	}

}
