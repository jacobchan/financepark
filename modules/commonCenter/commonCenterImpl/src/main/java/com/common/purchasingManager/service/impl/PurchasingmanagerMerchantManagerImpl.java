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
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.dao.PurchasingmanagerMerchantDao;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerMerchantManager;

@Service("purchasingmanagerMerchantManager")
@Transactional
public class PurchasingmanagerMerchantManagerImpl extends BaseManagerImpl implements PurchasingmanagerMerchantManager{
	@Autowired
	private PurchasingmanagerMerchantDao purchasingmanagerMerchantDao;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	
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
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerMerchant savePurchasingmanagerMerchant(PurchasingmanagerMerchant o) throws BusException{
    	String merchantId = o.getMerchantId();
    	boolean isUpdate = StringUtils.isNotEmpty(merchantId);
    	if(isUpdate){//修改
    		PurchasingmanagerMerchant pm = purchasingmanagerMerchantDao.get(merchantId);
    		pm.setMerchantName(o.getMerchantName());
    		pm.setMerchantEnterpriseName(o.getMerchantEnterpriseName());
    		pm.setMerchantType(o.getMerchantType());
    		pm.setMerchantLinkman(o.getMerchantLinkman());
    		pm.setMerchantLinkmanPhone(o.getMerchantLinkmanPhone());
    		pm.setMerchantSendAddress(o.getMerchantSendAddress());
    		pm.setMerchantReturnAddress(o.getMerchantReturnAddress());
    		pm.setMerchantLogo(o.getMerchantLogo());
    		pm.setMerchantUrl(o.getMerchantUrl());
    		pm.setMerchantAbout(o.getMerchantAbout());
    		pm.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerMerchantDao.save(pm);
    	}else{//新增
    		PurchasingmanagerGenre pg= purchasingmanagerGenreManager.getPurchasingmanagerGenre(o.getMerchantType().getGenreId());
    		if(pg != null){
    			o.setMerchantType(pg);
    		}
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerMerchantDao.save(o);
    	}
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
    /**
     * 根据商品类别获取相关商户列表
     */
    @Override
    @EsbServiceMapping
	public List<PurchasingmanagerMerchant> getMerchantsByGenre(@ServiceParam(name="purchasingmanagerGenre.genreId") String genreId)  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(genreId);
    	while(pg.getPurchasingmanagerGenre() != null){
    		pg = pg.getPurchasingmanagerGenre();
    	}
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
}
