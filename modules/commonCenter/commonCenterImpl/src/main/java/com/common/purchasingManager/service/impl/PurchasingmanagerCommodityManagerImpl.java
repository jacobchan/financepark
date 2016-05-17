/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.ExtentionAtrManager.service.ExtentionAtrManager;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.dao.MenuDao;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.gsoft.framework.security.fuc.service.RoleManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;

@Service("purchasingmanagerCommodityManager")
@Transactional
public class PurchasingmanagerCommodityManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityManager{
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	@Autowired
	private ExtentionAtrManager extentionAtrManager;
	@Autowired
	private RoleManager roleManager;

	@Autowired
	private MenuManager menuManager;
	
	@Autowired
	private UserManager userManager;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
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
	//获取所有的会议室列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerMeetRoomCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0301");
		conditions.add(ConditionUtils.getCondition("genreId", Condition.EQUALS, pg.getGenreId()));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取所有的车辆列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerCarRentalCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0302");
		conditions.add(ConditionUtils.getCondition("genreId", Condition.EQUALS, pg.getGenreId()));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取所有的广告位列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerAdsenseCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0303");
		conditions.add(ConditionUtils.getCondition("genreId", Condition.EQUALS, pg.getGenreId()));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取所有的创立方列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerCcuCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0401");
		conditions.add(ConditionUtils.getCondition("genreId", Condition.EQUALS, pg.getGenreId()));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
	//获取所有的工位列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerStationCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","040101");
		conditions.add(ConditionUtils.getCondition("genreId", Condition.EQUALS, pg.getGenreId()));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity savePurchasingmanagerCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setGenreId(o.getGenreId());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }
	/**
     * 保存会议室
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity saveMeetRoomCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0301");
    		o.setGenreId(pg.getGenreId());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }
	/**
     * 保存车辆租赁
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity saveCarRentalCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0302");
    		o.setGenreId(pg.getGenreId());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }
	/**
     * 保存广告位
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity saveAdsenseCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0303");
    		o.setGenreId(pg.getGenreId());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }
	/**
     * 保存创立方
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity saveCcuCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","0401");
    		o.setGenreId(pg.getGenreId());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
    }
	/**
     * 保存工位
     */
	@Override
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public PurchasingmanagerCommodity saveStationCommodity(PurchasingmanagerCommodity o) throws BusException{
    	String commodityId = o.getCommodityId();
		boolean isUpdate = StringUtils.isNotEmpty(commodityId);
    	if(isUpdate){//修改
    		PurchasingmanagerCommodity pc = purchasingmanagerCommodityDao.get(commodityId); 
    		pc.setCommodityTitle(o.getCommodityTitle());
    		pc.setCommodityPrice(o.getCommodityPrice());
    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		pc.setCommodityIsnotDisplayStock(o.getCommodityIsnotDisplayStock());
    		pc.setCommodityUpTime(o.getCommodityUpTime());
    		pc.setCommodityDownTime(o.getCommodityDownTime());
    		pc.setCommodityImage(o.getCommodityImage());
    		pc.setCommodityCoverImage(o.getCommodityCoverImage());
    		pc.setCommodityDescribe(o.getCommodityDescribe());
    		pc.setUpdateUser(o.getUpdateUser());
    		pc.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(pc);
    	}else{//新增
    		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode","040101");
    		o.setGenreId(pg.getGenreId());
    		o.setCreateUser(o.getUpdateUser());
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		return purchasingmanagerCommodityDao.save(o);
    	}
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
    
    /**
     * 根据商品类型获取相应的商品信息
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getCommodityRecordsByRecordType(
       @ServiceParam(name="commodityId.genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list=new ArrayList<PurchasingmanagerCommodity>();
		if(StringUtils.isNotEmpty(genreId)){
			list = purchasingmanagerCommodityDao.getList("genreId", genreId);
		}
		return list;
	}
	
	/**
     * 根据商品类别ID获取相应的商品信息
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getCommodityRecordsByGenreId(@ServiceParam(name="genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", genreId);
		return list;
	}
	
	/**
     * 获取工商变更类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getComChangeCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0502");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		return list;
	}
	/**
     * 获取公司注册类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getComReisterCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0501");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		return list;
	}
	/**
     * 获取代理记账类别的所有商品列表
     */
	@Override
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getAgencyCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0504");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		for(PurchasingmanagerCommodity pc :list){
			extentionAtrManager.setAgencyBookExtendValue(pc);
		}
		return list;
	}
	/**
     * 获取法律服务类别的所有商品列表
     */
	@Override
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getLawSerCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0505");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		for(PurchasingmanagerCommodity pc :list){
			extentionAtrManager.setLawserverExtendValue(pc);
		}
		return list;
	}
	/**
     * 获取商标专利类别的所有商品列表
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getChopPatentCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0506");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		return list;
	}
	/**
     * 获取威客服务类别的所有商品列表
     */
	@Override
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getWkserverCommodityList(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException{
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getGenreByUniqueProperty("genreCode", "0507");
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("genreId", pg.getGenreId());
		return list;
	}
	
	//获取采购类别的所有商品列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerPurCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getPurGenres();
		List<String> genreIdList = new ArrayList<String>();
		for(PurchasingmanagerGenre pg:pgList){
			genreIdList.add(pg.getGenreId());
		}
		String[] buff = (String[])genreIdList.toArray(new String[genreIdList.size()]);
		conditions.add(ConditionUtils.getCondition("genreId", Condition.IN, buff));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList = pagerRecords.getRecords();
		for(PurchasingmanagerCommodity pc:pcList){
			PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pc.getGenreId());
			pc.setPurchasingmanagerGenre(pg);
		}
		return pagerRecords;
	}
	//获取企业服务类别的所有商品列表
	@Override
	@EsbServiceMapping
	public PagerRecords getPagerCompSerCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		//获取企业服务的所有类别
		List<PurchasingmanagerGenre> pgList = purchasingmanagerGenreManager.getCompSerGenres();
		List<String> genreIdList = new ArrayList<String>();
		for(PurchasingmanagerGenre pg:pgList){
			genreIdList.add(pg.getGenreId());
		}
		String[] buff = (String[])genreIdList.toArray(new String[genreIdList.size()]);
		conditions.add(ConditionUtils.getCondition("genreId", Condition.IN, buff));
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList = pagerRecords.getRecords();
		for(PurchasingmanagerCommodity pc:pcList){
			PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getPurchasingmanagerGenre(pc.getGenreId());
			pc.setPurchasingmanagerGenre(pg);
		}
		return pagerRecords;
	}
	
	@EsbServiceMapping
	public void removeRole(@ServiceParam(name="roleId") String id) throws BusException{
		Role dbRole=roleManager.getRole(id);
		List<User> userRoleList = purchasingmanagerCommodityDao.getUserRoleListByRoleId(dbRole.getRoleId());
		for(User u:userRoleList){
			User user = (User) this.userDao.get(u.getUserId());
			user.setRoles(null);
			user=userDao.save(user);
		}
		dbRole.setMenus(null);
		dbRole=roleDao.save(dbRole);
		roleDao.remove(id);
	}
	
	@EsbServiceMapping
	public void removeMenu(@ServiceParam(name="menuId") String id) throws BusException{
		//通过菜单编号menuId查询所有关联的角色
		List<String> userRoleList = purchasingmanagerCommodityDao.getUserRoleListByMenuId(id);
		for(String roleId:userRoleList){
			Role dbRole=roleManager.getRole(roleId);
			dbRole.setMenus(null);
			dbRole=roleDao.save(dbRole);
		}
		 this.menuDao.remove(id);
	}
}
