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

import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.dao.PurchasingmanagerMerchantDao;
import com.common.purchasingManager.service.PurchasingmanagerMerchantManager;

@Service("purchasingmanagerMerchantManager")
@Transactional
public class PurchasingmanagerMerchantManagerImpl extends BaseManagerImpl implements PurchasingmanagerMerchantManager{
	@Autowired
	private PurchasingmanagerMerchantDao purchasingmanagerMerchantDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerMerchant> getPurchasingmanagerMerchants() throws BusException{
    	return purchasingmanagerMerchantDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerMerchant> getPurchasingmanagerMerchants(
    	@ConditionCollection(domainClazz=PurchasingmanagerMerchant.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerMerchantDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerMerchant getPurchasingmanagerMerchant(@ServiceParam(name="merchantId") String id)  throws BusException{
    	return purchasingmanagerMerchantDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerMerchants(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerMerchant.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerMerchantDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerMerchant savePurchasingmanagerMerchant(PurchasingmanagerMerchant o) throws BusException{
//    	String purchasingmanagerMerchantId = o.getPurchasingmanagerMerchantId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerMerchantId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerMerchantDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerMerchant(@ServiceParam(name="merchantId") String id) throws BusException{
    	purchasingmanagerMerchantDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerMerchants(@ServiceParam(name="merchantId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerMerchant(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerMerchant(@ServiceParam(name="merchantId") String id)  throws BusException{
		return purchasingmanagerMerchantDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerMerchant(String propertyName,Object value) throws BusException{
		return purchasingmanagerMerchantDao.exists(propertyName,value);
	}

}
