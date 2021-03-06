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


import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.*;
import com.common.purchasingManager.entity.PurchasingmanagerCategory;
import com.common.purchasingManager.dao.PurchasingmanagerCategoryDao;
import com.common.purchasingManager.service.PurchasingmanagerCategoryManager;

@Service("purchasingmanagerCategoryManager")
@Transactional
public class PurchasingmanagerCategoryManagerImpl extends BaseManagerImpl implements PurchasingmanagerCategoryManager{
	@Autowired
	private PurchasingmanagerCategoryDao purchasingmanagerCategoryDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerCategory> getPurchasingmanagerCategorys() throws BusException{
    	return purchasingmanagerCategoryDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerCategory> getPurchasingmanagerCategorys(
    	@ConditionCollection(domainClazz=PurchasingmanagerCategory.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerCategoryDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerCategory getPurchasingmanagerCategory(@ServiceParam(name="categoryId") String id)  throws BusException{
    	return purchasingmanagerCategoryDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerCategorys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCategory.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerCategoryDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerCategory savePurchasingmanagerCategory(PurchasingmanagerCategory o) throws BusException{
//    	String purchasingmanagerCategoryId = o.getPurchasingmanagerCategoryId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerCategoryId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerCategoryDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerCategory(@ServiceParam(name="categoryId") String id) throws BusException{
    	purchasingmanagerCategoryDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCategorys(@ServiceParam(name="categoryId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerCategory(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerCategory(@ServiceParam(name="categoryId") String id)  throws BusException{
		return purchasingmanagerCategoryDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerCategory(String propertyName,Object value) throws BusException{
		return purchasingmanagerCategoryDao.exists(propertyName,value);
	}

}
