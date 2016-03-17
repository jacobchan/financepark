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
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.dao.PurchasingmanagerGenrePropertyDao;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;

@Service("purchasingmanagerGenrePropertyManager")
@Transactional
public class PurchasingmanagerGenrePropertyManagerImpl extends BaseManagerImpl implements PurchasingmanagerGenrePropertyManager{
	@Autowired
	private PurchasingmanagerGenrePropertyDao purchasingmanagerGenrePropertyDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerGenreProperty> getPurchasingmanagerGenrePropertys() throws BusException{
    	return purchasingmanagerGenrePropertyDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenreProperty> getPurchasingmanagerGenrePropertys(
    	@ConditionCollection(domainClazz=PurchasingmanagerGenreProperty.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerGenrePropertyDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerGenreProperty getPurchasingmanagerGenreProperty(@ServiceParam(name="genrePropertyId") String id)  throws BusException{
    	return purchasingmanagerGenrePropertyDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerGenrePropertys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerGenreProperty.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerGenrePropertyDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerGenreProperty savePurchasingmanagerGenreProperty(PurchasingmanagerGenreProperty o) throws BusException{
    	String genrePropertyId = o.getGenrePropertyId();
    	boolean isUpdate = StringUtils.isNotEmpty(genrePropertyId);
    	if(isUpdate){//修改
    		PurchasingmanagerGenreProperty pgp = purchasingmanagerGenrePropertyDao.get(genrePropertyId); 
    		pgp.setGenrePropertyDisplayName(o.getGenrePropertyDisplayName());
    		pgp.setGenrePropertyFieldName(o.getGenrePropertyFieldName());
    		pgp.setPurchasingmanagerGenre(o.getPurchasingmanagerGenre());
    		pgp.setUpdateUser(o.getUpdateUser());
    		pgp.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerGenrePropertyDao.save(pgp);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerGenrePropertyDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerGenreProperty(@ServiceParam(name="genrePropertyId") String id) throws BusException{
    	purchasingmanagerGenrePropertyDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenrePropertys(@ServiceParam(name="genrePropertyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerGenreProperty(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerGenreProperty(@ServiceParam(name="genrePropertyId") String id)  throws BusException{
		return purchasingmanagerGenrePropertyDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerGenreProperty(String propertyName,Object value) throws BusException{
		return purchasingmanagerGenrePropertyDao.exists(propertyName,value);
	}
    //根据类别ID获取类别扩展属性列表
	@Override
	public List<PurchasingmanagerGenreProperty> getPurGenrePropertysByGenre(String genreId) throws BusException {
		List<PurchasingmanagerGenreProperty> list = purchasingmanagerGenrePropertyDao.getList("purchasingmanagerGenre.genreId", genreId);
		return list;
	}

}
