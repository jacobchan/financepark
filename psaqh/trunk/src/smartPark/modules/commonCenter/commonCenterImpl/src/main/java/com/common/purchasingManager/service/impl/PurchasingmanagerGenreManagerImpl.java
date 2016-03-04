/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.ArrayList;
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
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.dao.PurchasingmanagerGenreDao;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;

@Service("purchasingmanagerGenreManager")
@Transactional
public class PurchasingmanagerGenreManagerImpl extends BaseManagerImpl implements PurchasingmanagerGenreManager{
	@Autowired
	private PurchasingmanagerGenreDao purchasingmanagerGenreDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres() throws BusException{
    	return purchasingmanagerGenreDao.getAll();
    }
    /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenres(
    		@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
    	return purchasingmanagerGenreDao.commonQuery(conditions, orders);
    }


    /**
     * 根据商品类别（enreCode）查询商品
     */
    @EsbServiceMapping
    public List<PurchasingmanagerGenre> getPurchasingmanagerGenresByGenreCode(
    		@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,
    		@OrderCollection Collection<Order> orders) throws BusException{
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, "03"));// 查询属于公共资源的商品：genreCode=03
    	List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreDao.commonQuery(condition, order);
    	if(purchasingmanagerGenreList.size()>0){
    		conditions.add(ConditionUtils.getCondition("purchasingmanagerGenre",Condition.EQUALS, purchasingmanagerGenreList.get(0)));// 查询公共资源下包含的商品
    	}
    	return purchasingmanagerGenreDao.commonQuery(conditions, orders);
    }
   
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public PurchasingmanagerGenre getPurchasingmanagerGenre(@ServiceParam(name="genreId") String id)  throws BusException{
    	return purchasingmanagerGenreDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerPurchasingmanagerGenres(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerGenre.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerGenreDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerGenre savePurchasingmanagerGenre(PurchasingmanagerGenre o) throws BusException{
    	String genreId = o.getGenreId();
    	boolean isUpdate = StringUtils.isNotEmpty(genreId);
    	if(isUpdate){//修改
    		PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(genreId);
    		pg.setGenreName(o.getGenreName());
    		pg.setUpdateUser(o.getUpdateUser());
    		pg.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerGenreDao.save(pg);
    	
    	}else{//新增
    		if(o.getPurchasingmanagerGenre() != null){
    			PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(o.getPurchasingmanagerGenre().getGenreId());
    			o.setPurchasingmanagerGenre(pg);
    		}
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
        	return purchasingmanagerGenreDao.save(o);
    	}
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removePurchasingmanagerGenre(@ServiceParam(name="genreId") String id) throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreDao.get(id);
    	if("01".equals(pg.getGenreCode())){
    		throw new BusException("不能删除急速采购类别！");
    	}else if("02".equals(pg.getGenreCode())){
    		throw new BusException("不能删除餐饮类别！");
    	}else if("06".equals(pg.getGenreCode())){
    		throw new BusException("不能删除IT服务类别！");
    	}else{
    		purchasingmanagerGenreDao.remove(id);
    	}
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removePurchasingmanagerGenres(@ServiceParam(name="genreId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removePurchasingmanagerGenre(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitPurchasingmanagerGenre(@ServiceParam(name="genreId") String id)  throws BusException{
		return purchasingmanagerGenreDao.exists(id);
	}
    
    public boolean exsitPurchasingmanagerGenre(String propertyName,Object value) throws BusException{
		return purchasingmanagerGenreDao.exists(propertyName,value);
	}
	/**
	 * 获取所有的采购、餐饮、IT服务类别列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getPurFoodGenres() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getPurFoodGenresList();
		return list;
	}
	/**
	 * 获取所有的订单类型列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getOrderTypes() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getOrderTypesList();
		return list;
	}
	
	/**
	 * 获取商户类别列表
	 * @return
	 * @throws BusException
	 */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerGenre> getMerchantGenres() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		List<PurchasingmanagerGenre> pgList = getPurchasingmanagerGenres();
		for(PurchasingmanagerGenre pg:pgList){
			if(pg.getPurchasingmanagerGenre() == null){
				list.add(pg);
			}
		}
		return list;
	}
	/**
	 * 根据类别唯一编号获取对象
	 */
	@Override
	public PurchasingmanagerGenre getGenreByUniqueProperty(String genreCode)
			throws BusException {
		return purchasingmanagerGenreDao.getObjectByUniqueProperty("genreCode", genreCode);
	}
	/**
	 * 获取所有商品类别列表
	 */
	@Override
	public List<PurchasingmanagerGenre> getCommodityGenreList() throws BusException {
		List<PurchasingmanagerGenre> list = new ArrayList<PurchasingmanagerGenre>();
		list = purchasingmanagerGenreDao.getCommodityGenreList();
		return list;
	}
}
