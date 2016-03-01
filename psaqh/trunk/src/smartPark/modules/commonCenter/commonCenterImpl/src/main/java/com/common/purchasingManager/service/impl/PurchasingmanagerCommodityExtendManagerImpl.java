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
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;
import com.common.purchasingManager.entity.PurchasingmanagerCommodityExtend;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerGenreProperty;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.purchasingManager.dao.PurchasingmanagerCommodityExtendDao;
import com.common.purchasingManager.dao.PurchasingmanagerGenrePropertyDao;
import com.common.purchasingManager.service.PurchasingmanagerCommodityExtendManager;
import com.common.purchasingManager.service.PurchasingmanagerGenreManager;

@Service("purchasingmanagerCommodityExtendManager")
@Transactional
public class PurchasingmanagerCommodityExtendManagerImpl extends BaseManagerImpl implements PurchasingmanagerCommodityExtendManager{
	@Autowired
	private PurchasingmanagerCommodityExtendDao purchasingmanagerCommodityExtendDao;
	@Autowired
	private PurchasingmanagerGenrePropertyDao purchasingmanagerGenrePropertyDao;
	@Autowired
	private PurchasingmanagerGenreManager purchasingmanagerGenreManager;
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	
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
    /**
     * 根据商品ID获取商品扩展属性
     */
	@Override
	@EsbServiceMapping
	public List<PurchasingmanagerCommodityExtend> getPagerCommodityExts(@ServiceParam(name="commodity.commodityId") String commodityId) 
			throws BusException {
		List<PurchasingmanagerCommodityExtend> commodityExtList = new ArrayList<PurchasingmanagerCommodityExtend>();
		PurchasingmanagerCommodity pc =  purchasingmanagerCommodityDao.get(commodityId);
		//根据类别ID获得最上级商品类别
		PurchasingmanagerGenre pg = purchasingmanagerGenreManager.getSuperGenre(pc.getPurchasingmanagerGenre().getGenreId());
		//根据类别ID获得商品类属性
		List<PurchasingmanagerGenreProperty> pgpList = purchasingmanagerGenrePropertyDao.getList("purchasingmanagerGenre.genreId", pg.getGenreId());
		for(PurchasingmanagerGenreProperty pgp:pgpList){
			PurchasingmanagerCommodityExtend pce = new PurchasingmanagerCommodityExtend();
			//根据商品ID和商品类属性字段名获取商品扩展属性
			List<PurchasingmanagerCommodityExtend> pceList = purchasingmanagerCommodityExtendDao.getList(
					new String[]{"commodity.commodityId","purchasingmanagerGenreProperty.genrePropertyFieldName"}, new String[]{commodityId,pgp.getGenrePropertyFieldName()});
			if(pceList.size()>0){
				pce = pceList.get(0);
			}else{
				pce.setPurchasingmanagerGenreProperty(pgp);
			}
			commodityExtList.add(pce);
		}
		return commodityExtList;
	}
	/**
	 * 保存商品扩展属性
	 */
	@Override
	@EsbServiceMapping
	public void saveCommodityExts(@ServiceParam(name="commodity.commodityId") String commodityId,
			@DomainCollection(domainClazz=PurchasingmanagerCommodityExtend.class) List<PurchasingmanagerCommodityExtend> commodityExtList)
			throws BusException {
		//获取当前登录用户
		Object object = SecurityUtils.getPrincipal();
		User user = new User();
		if(object != null && object instanceof User){
			user = (User) object;
		}
		for(PurchasingmanagerCommodityExtend pce:commodityExtList){
			if(StringUtils.isNotEmpty(pce.getCommodityExtendId())){//修改
				PurchasingmanagerCommodityExtend purCE = purchasingmanagerCommodityExtendDao.get(pce.getCommodityExtendId());
				purCE.setCommodityExtendContent(pce.getCommodityExtendContent());
				purCE.setUpdateUser(user.getUserId());
				purCE.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
				purchasingmanagerCommodityExtendDao.save(purCE);
			}else{//新增
				PurchasingmanagerCommodity pc = new PurchasingmanagerCommodity();
				pc.setCommodityId(commodityId);
				pce.setCommodity(pc);
				pce.setCreateUser(user.getUserId());
				pce.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
				pce.setUpdateUser(user.getUserId());
				pce.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
				purchasingmanagerCommodityExtendDao.save(pce);
			}
		}
	}
}
