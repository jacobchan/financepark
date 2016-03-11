/**
 * 代码声明
 */
package com.common.purchasingManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.Record;
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
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.common.purchasingManager.service.PurchasingmanagerCommodityManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;
import com.common.purchasingManager.service.PurchasingmanagerGenrePropertyManager;
import com.common.purchasingManager.service.PurchasingmanagerMerchantManager;

@Service("purchasingmanagerCommodityManager")
@Transactional
public class PurchasingmanagerCommodityManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityManager{
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	
	@Autowired
	private PurchasingmanagerMerchantManager purchasingmanagerMerchantManager;
	
	@Autowired
	private PurchasingmanagerGenrePropertyManager extensionPropertyManager;
	
	@Autowired
	private PurchasingmanagerCommodityExtendManager purchasingmanagerCommodityExtendManager;
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
     * 查询属于公共资源的商品
     */
	@EsbServiceMapping
	public PagerRecords getPagerPublicCommoditys(Pager pager,//分页条件
			@ConditionCollection(domainClazz=PurchasingmanagerCommodity.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = purchasingmanagerCommodityDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<PurchasingmanagerCommodity> pcList=(List<PurchasingmanagerCommodity>) pagerRecords.getRecords();
		
		
		List<Record> records = new ArrayList<Record>();
		
		for(PurchasingmanagerCommodity pc:pcList){
			Record record = new Record();
			record.put("commodityId",pc.getCommodityId());//商品ID
			record.put("commodityTitle",pc.getCommodityTitle());//商品标题
			record.put("commodityPrice",pc.getCommodityPrice());//商品标价
			record.put("commodityDescribe",pc.getCommodityDescribe());//商品描述
			record.put("commodityImage",pc.getCommodityImage());//商品图像
			record.put("commodityCoverImage",pc.getCommodityCoverImage());//封面图片
			record.put("merchantName",pc.getPurchasingmanagerMerchant().getMerchantName());//商户名称
			record.put("merchantId",pc.getPurchasingmanagerMerchant().getMerchantId());//商户Id
			record.put("merchantLinkman",pc.getPurchasingmanagerMerchant().getMerchantLinkman());//联系人电话
			record.put("merchantLinkmanPhone",pc.getPurchasingmanagerMerchant().getMerchantLinkmanPhone());//联系人电话
			
			PurchasingmanagerGenre pg = pc.getPurchasingmanagerGenre();
			while(pg.getPurchasingmanagerGenre() != null){//获取最顶级商品类别
				pg = pg.getPurchasingmanagerGenre();
			}
			//获取商品类别
			Collection<Condition> condition = new ArrayList<Condition>();
			List<PurchasingmanagerCommodityExtend> pceList=new ArrayList<PurchasingmanagerCommodityExtend>();
			condition.add(ConditionUtils.getCondition("purchasingmanagerGenre.genreId", Condition.EQUALS, pg.getGenreId()));
			List<PurchasingmanagerGenreProperty> genrePropertyList = extensionPropertyManager.getPurchasingmanagerGenrePropertys(condition, null);
			for(PurchasingmanagerGenreProperty genreProperty:genrePropertyList){
				if("dw".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("dwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():null);//商品属性：档位
				}else if("zw".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("zwValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():null);//商品属性：座位
				}else if("chepai".equals(genreProperty.getGenrePropertyFieldName())){
					//获取商品扩展属性
					Collection<Condition> conditionE = new ArrayList<Condition>();
					conditionE.add(ConditionUtils.getCondition("purchasingmanagerGenreProperty.genrePropertyId", Condition.EQUALS, genreProperty.getGenrePropertyId()));
					conditionE.add(ConditionUtils.getCondition("commodity.commodityId", Condition.EQUALS, pc.getCommodityId()));
					pceList=purchasingmanagerCommodityExtendManager.getPurchasingmanagerCommodityExtends(conditionE, null);
					record.put("cpValue",pceList.size()>0?pceList.get(0).getCommodityExtendContent():null);//商品属性：车牌
				}
			}
			records.add(record);
		}
		
		pagerRecords.setRecords(records);
		
		
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
    		pc.setPurchasingmanagerGenre(o.getPurchasingmanagerGenre());
//    		pc.setPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant());
    		pc.setCommodityStock(o.getCommodityStock());
    		if(o.getPurchasingmanagerMerchant().getMerchantId()!=null){
    			
    			PurchasingmanagerMerchant pm=purchasingmanagerMerchantManager.getPurchasingmanagerMerchant(o.getPurchasingmanagerMerchant().getMerchantId());
    			pc.setPurchasingmanagerMerchant(pm);
    		}
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
       @ServiceParam(name="commodityId.purchasingmanagerGenre.genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list=new ArrayList<PurchasingmanagerCommodity>();
		if(StringUtils.isNotEmpty(genreId)){
			list = purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreId", genreId);
		}
		return list;
	}
	
	/**
     * 根据商品类别ID获取相应的商品信息
     */
	@EsbServiceMapping
    public List<PurchasingmanagerCommodity> getCommodityRecordsByGenreId(
       @ServiceParam(name="genreId") String genreId) throws BusException{
		List<PurchasingmanagerCommodity> list= purchasingmanagerCommodityDao.getList("purchasingmanagerGenre.genreId", genreId);
		return list;
	}
}
