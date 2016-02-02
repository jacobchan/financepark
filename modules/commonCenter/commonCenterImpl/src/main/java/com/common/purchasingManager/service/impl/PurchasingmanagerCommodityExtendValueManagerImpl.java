/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

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

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtendValue;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendValueDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendValueManager;

@Service("purchasingmanagerCommodityExtendValueManager")
@Transactional
public class PurchasingmanagerCommodityExtendValueManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityExtendValueManager{
	@Autowired
	private PurchasingmanagerCommodityExtendValueDao purchasingmanagerCommodityExtendValueDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerCommodityExtendValue> getPurchasingmanagerCommodityExtendValues() throws BusException{
    	return purchasingmanagerCommodityExtendValueDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodityExtendValue> getPurchasingmanagerCommodityExtendValues(
    	@ConditionCollection(domainClazz=PurchasingmanagerCommodityExtendValue.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerCommodityExtendValueDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodityExtendValue getPurchasingmanagerCommodityExtendValue(@ServiceParam(name="commodityExtendValueId") String id)  throws BusException{
    	return purchasingmanagerCommodityExtendValueDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerCommodityExtendValues(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodityExtendValue.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerCommodityExtendValueDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodityExtendValue savePurchasingmanagerCommodityExtendValue(PurchasingmanagerCommodityExtendValue o) throws BusException{
//    	String purchasingmanagerCommodityExtendValueId = o.getPurchasingmanagerCommodityExtendValueId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerCommodityExtendValueId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerCommodityExtendValueDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerCommodityExtendValue(@ServiceParam(name="commodityExtendValueId") String id) throws BusException{
    	purchasingmanagerCommodityExtendValueDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommodityExtendValues(@ServiceParam(name="commodityExtendValueId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerCommodityExtendValue(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerCommodityExtendValue(@ServiceParam(name="commodityExtendValueId") String id)  throws BusException{
		return purchasingmanagerCommodityExtendValueDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerCommodityExtendValue(String propertyName,Object value) throws BusException{
		return purchasingmanagerCommodityExtendValueDao.exists(propertyName,value);
	}

}
