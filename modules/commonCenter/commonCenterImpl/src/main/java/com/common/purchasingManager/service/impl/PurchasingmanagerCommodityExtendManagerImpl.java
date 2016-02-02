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

import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;

@Service("purchasingmanagerCommodityExtendManager")
@Transactional
public class PurchasingmanagerCommodityExtendManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityExtendManager{
	@Autowired
	private PurchasingmanagerCommodityExtendDao purchasingmanagerCommodityExtendDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerCommodityExtend> getPurchasingmanagerCommodityExtends() throws BusException{
    	return purchasingmanagerCommodityExtendDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerCommodityExtend> getPurchasingmanagerCommodityExtends(
    	@ConditionCollection(domainClazz=PurchasingmanagerCommodityExtend.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerCommodityExtendDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodityExtend getPurchasingmanagerCommodityExtend(@ServiceParam(name="commodityExtendId") String id)  throws BusException{
    	return purchasingmanagerCommodityExtendDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerCommodityExtends(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodityExtend.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerCommodityExtendDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public PurchasingmanagerCommodityExtend savePurchasingmanagerCommodityExtend(PurchasingmanagerCommodityExtend o) throws BusException{
//    	String purchasingmanagerCommodityExtendId = o.getPurchasingmanagerCommodityExtendId();
//    	boolean isUpdate = StringUtils.isNotEmpty(purchasingmanagerCommodityExtendId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return purchasingmanagerCommodityExtendDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerCommodityExtend(@ServiceParam(name="commodityExtendId") String id) throws BusException{
    	purchasingmanagerCommodityExtendDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerCommodityExtends(@ServiceParam(name="commodityExtendId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerCommodityExtend(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerCommodityExtend(@ServiceParam(name="commodityExtendId") String id)  throws BusException{
		return purchasingmanagerCommodityExtendDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerCommodityExtend(String propertyName,Object value) throws BusException{
		return purchasingmanagerCommodityExtendDao.exists(propertyName,value);
	}

}
