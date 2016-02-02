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

import com.common.purchasingManager.entity.PurchasingmanagerMerchantAddress;
import com.common.purchasingManager.dao.PurchasingmanagerMerchantAddressDao;
import com.common.purchasingManager.service.PurchasingmanagerMerchantAddressManager;

@Service("purchasingmanagerMerchantAddressManager")
@Transactional
public class PurchasingmanagerMerchantAddressManagerImpl extends BaseManagerImpl implements PurchasingmanagerMerchantAddressManager{
	@Autowired
	private PurchasingmanagerMerchantAddressDao purchasingmanagerMerchantAddressDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerMerchantAddress> getPurchasingmanagerMerchantAddresss() throws BusException{
    	return purchasingmanagerMerchantAddressDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerMerchantAddress> getPurchasingmanagerMerchantAddresss(
    	@ConditionCollection(domainClazz=PurchasingmanagerMerchantAddress.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerMerchantAddressDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerMerchantAddress getPurchasingmanagerMerchantAddress(@ServiceParam(name="merchantAddressId") String id)  throws BusException{
    	return purchasingmanagerMerchantAddressDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerMerchantAddresss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerMerchantAddress.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerMerchantAddressDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerMerchantAddress savePurchasingmanagerMerchantAddress(PurchasingmanagerMerchantAddress o) throws BusException{
//    	String purchasingmanagerMerchantAddressId = o.getPurchasingmanagerMerchantAddressId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerMerchantAddressId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerMerchantAddressDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerMerchantAddress(@ServiceParam(name="merchantAddressId") String id) throws BusException{
    	purchasingmanagerMerchantAddressDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerMerchantAddresss(@ServiceParam(name="merchantAddressId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerMerchantAddress(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerMerchantAddress(@ServiceParam(name="merchantAddressId") String id)  throws BusException{
		return purchasingmanagerMerchantAddressDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerMerchantAddress(String propertyName,Object value) throws BusException{
		return purchasingmanagerMerchantAddressDao.exists(propertyName,value);
	}

}
