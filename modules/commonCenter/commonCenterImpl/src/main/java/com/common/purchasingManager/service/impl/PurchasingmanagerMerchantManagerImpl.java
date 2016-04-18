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
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.esb.annotation.*;
import com.gsoft.framework.util.ConditionUtils;
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
	//获取公共资源类型的商户列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPublicResoMerchants(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerMerchant.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		String[] buff = new String[]{"0301","0302","0303"};
		conditions.add(ConditionUtils.getCondition("merchantType.genreCode", Condition.IN, buff));
		PagerRecords pagerRecords = purchasingmanagerMerchantDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取采购类型的商户列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPurMerchants(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerMerchant.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		conditions.add(ConditionUtils.getCondition("merchantType.genreCode", Condition.EQUALS, "01"));
		PagerRecords pagerRecords = purchasingmanagerMerchantDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取企业服务类型的商户列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerCompSerMerchants(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerMerchant.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getCompSerOrderTypes("");
		List<String> list = new ArrayList<String>();
		for(PurchasingmanagerGenre pg:pgList){
			list.add(pg.getGenreId());
		}
		String[] buff = (String[])list.toArray(new String[list.size()]);
		conditions.add(ConditionUtils.getCondition("merchantType.genreId", Condition.IN, buff));
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
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerMerchantDao.save(o);
    	}
    }
	/**
     * 保存采购商户
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerMerchant savePurMerchant(PurchasingmanagerMerchant o) throws BusException{
    	String merchantId = o.getMerchantId();
    	boolean isUpdate = StringUtils.isNotEmpty(merchantId);
    	if(isUpdate){//修改
    		PurchasingmanagerMerchant pm = purchasingmanagerMerchantDao.get(merchantId);
    		pm.setMerchantName(o.getMerchantName());
    		pm.setMerchantEnterpriseName(o.getMerchantEnterpriseName());
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
    		o.setMerchantType(purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "01"));
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
	public List<PurchasingmanagerMerchant> getMerchantsByGenre(@ServiceParam(name="genreId") String genreId,@ServiceParam(name="genreCode") String genreCode)  throws BusException{
    	PurchasingmanagerGenre pg =new PurchasingmanagerGenre();
    	if(genreId!=null){
    		pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(genreId);
    	}else{
    		if(genreCode !=null){
    			Collection<Condition> conditions = new ArrayList<Condition>();
    			conditions.add(ConditionUtils.getCondition("genreCode",Condition.EQUALS, genreCode));
    			// 根据genreCode查询属于商品
    			List<PurchasingmanagerGenre> purchasingmanagerGenreList=purchasingmanagerGenreManager.getPurchasingmanagerGenres(conditions, null);
    			pg=purchasingmanagerGenreList.size()>0?purchasingmanagerGenreList.get(0):null;
    		}
    	}
    	
    	while(pg.getGenreCode() == null){//获取有编码的商品类别
			pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pg.getPagrenId());
		}
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
    /**
     * 获取采购商品所属商户列表
     */
    @Override
    @EsbServiceMapping
	public List<PurchasingmanagerMerchant> getPurMerchants()  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","01");
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
    /**
     * 获取会议室所属商户列表
     */
    @Override
    @EsbServiceMapping
	public List<PurchasingmanagerMerchant> getMeetRoomMerchants()  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0301");
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
    /**
     * 获取车辆租赁所属商户列表
     */
    @Override
    @EsbServiceMapping
	public List<PurchasingmanagerMerchant> getCarRentalMerchants()  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0302");
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
    /**
     * 获取广告位所属商户列表
     */
    @Override
    @EsbServiceMapping
	public List<PurchasingmanagerMerchant> getAdsenseMerchants()  throws BusException{
    	PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0303");
		List<PurchasingmanagerMerchant> list = purchasingmanagerMerchantDao.getList("merchantType.genreId", pg.getGenreId());
		return list;
	}
}
