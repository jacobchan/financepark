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

import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;

@Service("purchasingmanagerCommodityManager")
@Transactional
public class PurchasingmanagerCommodityManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityManager{
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys() throws BusException{
    	return purchasingmanagerCommodityDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodity> getPurchasingmanagerCommoditys(
    	@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerCommodityDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodity getPurchasingmanagerCommodity(@ServiceParam(name="commodityId") String id)  throws BusException{
    	return purchasingmanagerCommodityDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodity savePurchasingmanagerCommodity(PurchasingmanagerCommodity o) throws BusException{
//    	String purchasingmanagerCommodityId = o.getPurchasingmanagerCommodityId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerCommodityId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerCommodityDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerCommodity(@ServiceParam(name="commodityId") String id) throws BusException{
    	purchasingmanagerCommodityDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommoditys(@ServiceParam(name="commodityId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerCommodity(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerCommodity(@ServiceParam(name="commodityId") String id)  throws BusException{
		return purchasingmanagerCommodityDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerCommodity(String propertyName,Object value) throws BusException{
		return purchasingmanagerCommodityDao.exists(propertyName,value);
	}

}
